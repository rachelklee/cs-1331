package HW01;
public class Player {
    private final String playerName;
    private int stamina;
    private Position[] positions;
    private int skillRating;

    //private static final String DEF_NAME = "Lionel Messi";
    private static final int DEF_STAMINA = 75;
    private static final Position[] DEF_POSITION = new Position[]{Position.MIDFIELDER};
    private static final int DEF_SKILLRATING = 80;


    public Player() {
        this("Lionel Messi", 75, new Position[]{Position.FORWARD}, 100);
    }

    public Player(String playerName, Position[] positions) {
        this(playerName, DEF_STAMINA, positions, DEF_SKILLRATING);
    }

    public Player(String playerName, int stamina, Position[] positions, int skillRating) {
        this.playerName = playerName;
        this.stamina = staminaRange(stamina);
        this.positions = positions;
        this.skillRating = skillRatingRange(skillRating);

        if (positions.length == 0 || positions[0] == null) {
            this.positions = DEF_POSITION;
        }
    }

    private int staminaRange(int val) {
        if (val >= 0 && val <= 100) {
            return val;
        } else {
            return 75;
        }
    }

    private int skillRatingRange(int sR) {
        if (90 <= sR && sR <= 100) {
            System.out.println("Skill rating: Excellent");
            return sR;
        } else if (sR >= 80 && sR <= 89) {
            System.out.println("Skill rating: Great");
            return sR;
        } else if (sR >= 70 && sR <= 70) {
            System.out.println("Skill rating: Very Good");
            return sR;
        } else if (sR >= 60 && sR <= 69) {
            System.out.println("Skill rating: Good");
            return sR;
        } else if (sR >= 50 && sR <= 59) {
            System.out.println("Skill rating: Fine");
            return sR;
        } else if (sR >= 40 && sR <= 49) {
            System.out.println("Skill rating: Bad");
            return sR;
        } else {
            System.out.println("Skill rating: Great");
            return 80;
        }
    }

    public boolean isTrainable() {
        return skillRating >= 50 && skillRating <= 89;
    }

    public Position preferredPosition() {
        if (positions.length > 0) {
            return positions[0];
        } else {
            return null;
        }
    }

    public boolean canPlayAs(Position check) {
        for (Position pos : positions) {
            if (pos == check) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String val1 = playerName;
        int val2 = stamina;
        Position val3 = preferredPosition();
        int val4 = skillRating;
        boolean val5 = isTrainable();
        return String.format("<%s,%s,%s,%s,%s>", val1, val2, val3, val4, val5);
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSkillRating() {
        return this.skillRating;
    }

    public void setSkillRating(int skillRating) {
        this.skillRating = skillRating;
    }
}
