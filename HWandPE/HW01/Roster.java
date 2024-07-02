package HW01;
import java.util.Random;


public class Roster {
    private Player[] players;
    private int size;
    private Random rand;

    public Roster(Player[] players) {
        rand = new Random();
        this.players = players;
        for (Player player : players) {
            if (player != null) {
                ++size;
            }
        }
    }

    public Roster() {
        rand = new Random();
        this.players = new Player[4];
        size = 0;
    }

    public Player signPlayer(int index, Player player) {
        if (index < 0 || index >= players.length || player == null) {
            System.out.println("Cannot add a player to this spot on the roster.");
            return null;
        } else {
            if (players[index] == null) {
                ++size;
                players[index] = player;
                System.out.println("Signed: " + players[index]);
                return player;
            } else {
                Player replaced = players[index];
                System.out.println("Replaced: " + players[index]);
                players[index] = player;
                return replaced;
            }
        }
    }

    public Player transferPlayer(int index) {
        if (0 <= index && index < players.length && players[index] != null) {
            System.out.println("Transferred: " + players[index]);
            --size;
            return players[index];
        } else {
            System.out.println("There was no player to transfer!");
            return null;
        }
    }

    public void showBestPlayers(int skillRating) {
        for (Player player : players) {
            if (player != null && player.getSkillRating() > skillRating) {
                System.out.println(player);
            }
        }
    }

    public void trainAllPlayers() {

        int sr = 0;
        int train = 0;
        int trainNum = 0;

        if (players.length == 0) {
            System.out.println("There were no players to train.");
        } else {
            for (Player p : players) {
                if (p != null && p.isTrainable()) {
                    sr = p.getSkillRating();
                    train = rand.nextInt(10) + 1;
                    sr += train;
                    p.setSkillRating(sr);
                    ++trainNum;
                    System.out.println(String.format("Trained to %d: %s", sr, p));
                }
            }

            if (trainNum == 0) {
                System.out.println("There were no players to train.");
            }
        }
    }

    public void play(int index, Position position) {
        if (index >= 0 && index < players.length && players[index] != null) {
            Player p = players[index];
            Position pPosPref = p.preferredPosition();
            boolean pPosCap = p.canPlayAs(position);
            int tired = 0;
            int stamina = p.getStamina();

            if (pPosPref == position) {
                tired = rand.nextInt(5) + 1;
                stamina -= tired;
            } else if (pPosCap) {
                tired = rand.nextInt(5) + 5;
                stamina -= tired;
            } else {
                System.out.println("This player cannot be played in position " + position);
            }

            if (stamina >= 0) {
                p.setStamina(stamina);
            } else {
                p.setStamina(0);
            }
        } else {
            System.out.println("Cannot play the player in this spot.");
        }
    }

    public String toString() {
        String str = "";
        if (size == 0) {
            return "The team has no players!";
        }
        str = String.format("There are %d players on Java FC.", size);
        for (Player player : players) {
            if (player != null) {
                str = str.concat(String.format("\r\n%s", player));
            }
        }
        return str;

    }

}
