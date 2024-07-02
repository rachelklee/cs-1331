package HW04;
/**
 * Represents a class HalloweenNight.
 * @author Rachel Lee
 * @version 1.0
 */
public class HalloweenNight {
    private TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
    private TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

    /**
     * A constructor that creates an object HalloweenNight with 2 parameters.
     * @param cryptKickerFive Array of type TrickOrTreater
     * @param ghoulGang Array of type TrickOrTreater
     */
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        this.cryptKickerFive = cryptKickerFive;
        this.ghoulGang = ghoulGang;
    }

    /** Method to return a string in a given format, overridden from Object class.
     * @return a string in a format describing an instance of HalloweenNight
     */
    @Override
    public String toString() {
        String cKF = "cryptKickerFive: ";
        String gG = "ghoulGang: ";

        for (TrickOrTreater t : cryptKickerFive) {
            cKF += t.toString() + ", ";
        }
        cKF = cKF.substring(0, cKF.length() - 2);

        for (TrickOrTreater t : ghoulGang) {
            gG += t.toString() + ", ";
        }
        gG = gG.substring(0, gG.length() - 2);

        return String.format("%s versus %s", cKF, gG);
    }

    /**
     * Method that compares two teams.
     */
    public void compareTeams() {
        int gGCount = 0;
        int cKFCount = 0;
        int same = 0;

        for (int i = 0; i < cryptKickerFive.length && i < ghoulGang.length; ++i) {
            if (ghoulGang[i].compareTo(cryptKickerFive[i]) > 0) {
                ++gGCount;
            } else if (ghoulGang[i].compareTo(cryptKickerFive[i]) < 0) {
                ++cKFCount;
            }
            if (ghoulGang[i].compareTo(cryptKickerFive[i]) == 0) {
                ++same;
            }
        }

        //System.out.println("GGCOUNT " + gGCount);
        //System.out.println("CKFCOUNT " + cKFCount);

        if (same > 0) {
            System.out.println("Neither team is favored.");
        } else {
            //System.out.println("Ghoul Gang: " + gGCount);
            //System.out.println("CKF: " + cKFCount);
            if (gGCount > cKFCount) {
                System.out.println("ghoulGang is favored.");
            } else if (gGCount < cKFCount) {
                System.out.println("cryptKickerFive is favored.");
            } else if (gGCount == cKFCount) {
                System.out.println("Neither team is favored.");
            }
        }

    }

    /**
     * Method that battles two classes.
     * @param candyThreshold int representing the threshold amount of candy needed to win
     */
    public void battle(int candyThreshold) {

        if (candyThreshold <= 0) {
            candyThreshold = 60;
        }
        while (true) {
            for (TrickOrTreater t : cryptKickerFive) {
                if (t instanceof TrickOrTreater) {
                    t.trickOrTreat();
                }
            }
            for (int i = 0; i < cryptKickerFive.length && i < ghoulGang.length; ++i) {
                if (cryptKickerFive[i] instanceof Ghost) {
                    Ghost g = (Ghost) cryptKickerFive[i];
                    g.rob(ghoulGang[i]);
                }
            }
            for (TrickOrTreater t : ghoulGang) {
                if (t instanceof TrickOrTreater) {
                    t.trickOrTreat();
                }
            }

            for (int i = 0; i < cryptKickerFive.length && i < ghoulGang.length; ++i) {
                if (ghoulGang[i] instanceof Ghost) {
                    Ghost g = (Ghost) ghoulGang[i];
                    g.rob(cryptKickerFive[i]);
                }

                //System.out.println("CKF CANDY: " + cKFCandy);
                //System.out.println("GG CANDY: " + gGCandy);
                //System.out.println("THRESHOLD: " + candyThreshold);
            }
            int cKFCandy = 0;
            int gGCandy = 0;

            for (TrickOrTreater t : cryptKickerFive) {
                cKFCandy += t.getNumCandy();
            }

            for (TrickOrTreater t : ghoulGang) {
                gGCandy += t.getNumCandy();
            }
            if (cKFCandy >= candyThreshold && gGCandy >= candyThreshold) {
                System.out.println("It is a tie!");
                break;
            } else if (cKFCandy >= candyThreshold && gGCandy < candyThreshold) {
                System.out.println("cryptKickerFive won!");
                break;
            } else if (gGCandy >= candyThreshold && cKFCandy < candyThreshold) {
                System.out.println("ghoulGang won!");
                break;
            }
        }
    }
}
