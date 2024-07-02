import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

/**
 * A class representing a Tickets.
 * @author Rachel Lee
 * @version 1.0
 */
public class Tickets {

    /**
     * A method to retrieve games.
     * @param pathToFile String representing file to read from
     * @return ArrayList storing SportsGame type representing games
     * @throws FileNotFoundException Exception thrown if file is not found
     * @throws InvalidTicketException Exception thrown if ticket is invalid
     */
    public static ArrayList<SportsGame> retrieveGames(String pathToFile)
        throws FileNotFoundException, InvalidTicketException {

        if (pathToFile == null || pathToFile.isBlank()) {
            throw new FileNotFoundException("Null, Blank, or Nonexistent Path Not Valid");
        } else {
            File f = new File(pathToFile);
            ArrayList<SportsGame> games = new ArrayList<>();
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String token = s.nextLine();
                games.add(processInfo(token));
            }
            s.close();
            return games;
        }
    }

    /**
     * A helper method to process information
     * @param token String representing line of text from CSV
     * @return SportsGame object
     * @throws InvalidTicketException Exception thrown if ticket is not valid
     */
    private static SportsGame processInfo(String token) throws InvalidTicketException {
        String[] gameData = token.split(",");

        if (gameData[0].equals("BasketballGame")) {
            return new BasketballGame(gameData[1], gameData[2], gameData[3], Integer.parseInt(gameData[4]),
                Integer.parseInt(gameData[5]), Integer.parseInt(gameData[6]), gameData[7]);
        } else if (gameData[0].equals("FootballGame")) {
            return new FootballGame(gameData[1], gameData[2], gameData[3], Integer.parseInt(gameData[4]),
                Integer.parseInt(gameData[5]), Integer.parseInt(gameData[6]), gameData[7]);
        } else {
            throw new InvalidTicketException("SportsGame type invalid");
        }
    }

    /**
     * A method to purchase tickets.
     * @param outFile String representing path of file to write to
     * @param games ArrayList of SportsGame type representing games
     * @throws IllegalArgumentException Exception thrown if illegal argument is passed
     * @throws IOException Exception thrown if I/O exception occurs
     */
    public static void purchaseTickets(String outFile, ArrayList<SportsGame> games)
        throws IllegalArgumentException, IOException, InvalidTicketException {
        if (outFile == null || outFile.isBlank()) {
            throw new IllegalArgumentException("Inputted path invalid");
        }

        File f = new File(outFile);

        if (!f.exists()) {
            f.createNewFile();
        }

        ArrayList<SportsGame> existing = retrieveGames(outFile);
        PrintWriter outWriter = new PrintWriter(outFile);

        for (SportsGame s : existing) {
            outWriter.println(s);
        }

        System.out.println("NEW");
        for (SportsGame s : games) {
            if (s.getSeatsLeft() != 0) {
                System.out.println(s);
                outWriter.println(s);
            }
        }

        outWriter.close();
        outWriter.flush();
    }

    /**
     * A method to find tickets.
     * @param readFile String representing patho of file to read from
     * @param findGame SportsGame object representing game type to find
     * @return ArrayList storing integer type of tickets found
     * @throws FileNotFoundException Exception thrown if file is not found
     * @throws IOException Exception thrown if I/O exception occurs
     * @throws InvalidTicketException Exception thrown if ticket is not valid
     */
    public static ArrayList<Integer> findTickets(String readFile, SportsGame findGame)
        throws FileNotFoundException, IOException, InvalidTicketException {

        if (readFile == null || readFile.isBlank()) {
            throw new FileNotFoundException("Filename invalid");
        }

        ArrayList<Integer> ticketsFound = new ArrayList<>();
        File f = new File(readFile);

        if (!f.isFile() || f.isDirectory()) {
            throw new FileNotFoundException("File not found");
        }

        ArrayList<SportsGame> retrieved = retrieveGames(readFile);

        boolean found = false;
        for (int i = 0; i < retrieved.size(); ++i) {
            if (retrieved.get(i).equals(findGame)) {
                found = true;
                ticketsFound.add(i);
            }
        }

        if (!found) {
            throw new InvalidTicketException("Ticket has no occurences");
        }

        return ticketsFound;

    }

    /**
     * A method to represent a game being attended.
     * @param writeFile String representing path of file to write to
     * @param game SportsGame object representing game being attended
     * @throws FileNotFoundException Exception thrown if file is not found
     * @throws IOException Exception thrown if I/O exception occurs
     * @throws InvalidTicketException Exception thrown if ticket is not valid
     */
    public static void attendGame(String writeFile, SportsGame game)
        throws FileNotFoundException, IOException, InvalidTicketException {

        if (writeFile == null || writeFile.isBlank()) {
            throw new FileNotFoundException("Path invalid");
        }

        File f = new File(writeFile);
        ArrayList<SportsGame> retrieved = retrieveGames(writeFile);

        for (int i = retrieved.size() - 1; i >= 0; --i) {
            if (retrieved.get(i).equals(game)) {
                retrieved.remove(i);
            }
        }

        PrintWriter outWriter = new PrintWriter(f);
        for (SportsGame s : retrieved) {
            outWriter.println(s);
        }

        outWriter.close();
        outWriter.flush();
    }
}
