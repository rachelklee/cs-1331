package HWandPE.HW01;
public class Driver {
    public static void main(String[] args) {
        Player[] jfcplayers = new Player[4];
        Roster javaFCRoster = new Roster(jfcplayers);
        Player p1 = new Player("Lauren Chan", 90, new Position[]{Position.DEFENDER, Position.MIDFIELDER}, 86);
        Player p2 = new Player("Sara Patel", new Position[]{Position.GOALKEEPER});
        Player p3 = new Player("Ajay Shrivastava", 95, new Position[]{Position.MIDFIELDER, Position.FORWARD}, 95);
        javaFCRoster.signPlayer(0, p1);
        javaFCRoster.signPlayer(1, p2);
        javaFCRoster.signPlayer(2, p3);

        javaFCRoster.transferPlayer(0);

        javaFCRoster.showBestPlayers(75);

        javaFCRoster.trainAllPlayers();

        javaFCRoster.play(0, Position.GOALKEEPER);

        javaFCRoster.toString();
    }
}