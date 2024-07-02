package HW03;
/**
 * Driver class for RollerCoaster and Trolley. This class does NOT directly test Ride, only
 * indirectly through its subclasses.
 * @author jh04
 * @version 1.0.4 (2023-10-15_23:15)
 */
public class Driver {
    // The full width of the printed boxes.
    private static final int BOX_WIDTH = 50;

    // Constants for the RollerCoaster constructor test.
    private static final String[] ROLLERCOASTER_PASSENGER_LIST = new String[] {"Dipper", "Mabel", "Bill"};

    private static final Object[][] ROLLERCOASTER_CONSTRUCTOR_INPUTS = new Object[][] {
        new Object[] {"6-arg constructor", "FlightDeck", 8,
                      ROLLERCOASTER_PASSENGER_LIST, 6.70, 2.54, 95},
        new Object[] {"spaces in id", "Flight Deck", 8,
                      ROLLERCOASTER_PASSENGER_LIST, 6.70, 2.54, 95},
        new Object[] {"3-arg constructor", "Goldstriker", 27, 1678},
        new Object[] {"1-arg constructor", "Railblazer"}
    };

    private static final String[] ROLLERCOASTER_CONSTRUCTOR_OUTPUTS = new String[] {
        "Roller Coaster FlightDeck has run 8 times and has earned $0.00. It can only run 87 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster Flight Deck has run 8 times and has earned $0.00. It can only run 87 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster Goldstriker has run 27 times and has earned $0.00. It can only run 1651 "
            + "more times. It costs $10.00 per ride and there is a one-time photo fee of $15.00.",
        "Roller Coaster Railblazer has run 0 times and has earned $0.00. It can only run 200 "
            + "more times. It costs $10.00 per ride and there is a one-time photo fee of $15.00."
    };



    // Constants for the RollerCoaster canRun() test
    private static final RollerCoaster ROLLERCOASTER_CANRUN_TESTER =
        new RollerCoaster("Grizzly", 6, 70);

    private static final int[] ROLLERCOASTER_CANRUN_INPUTS = new int[] {
        0, 5, 80, 69, -1, 64
    };

    private static final boolean[] ROLLERCOASTER_CANRUN_OUTPUTS = new boolean[] {
        true, true, false, false, false, true
    };



    // Constants for the RollerCoaster inspectRide() test
    private static final Object[][] ROLLERCOASTER_INSPECTRIDE_INPUTS = new Object[][] {
        new Object[] {"two-element array", new String[] {"Tracks Clear", "Brakes Ok"}},
        new Object[] {"many-element array", new String[] {"Tracks Clear", "Brakes Ok", "a", "b"}},
        new Object[] {"one-element array", new String[] {"Tracks Clear,Brakes Ok"}},
        new Object[] {"all-lowercase", new String[] {"tracks clear", "brakes ok"}},
        new Object[] {"all-uppercase", new String[] {"TRACKS CLEAR", "BRAKES OK"}},
        new Object[] {"different order", new String[] {"a", "b", "Brakes Ok", "c", "Tracks Clear"}}
    };

    private static final boolean[] ROLLERCOASTER_INSPECTRIDE_OUTPUTS = new boolean[] {
        true, true, false, true, true, true
    };

    private static final String[] ROLLERCOASTER_INSPECTRIDE_TOSTRING_OUTPUTS = new String[] {
        "Roller Coaster FlightDeck has run 0 times and has earned $0.00. It can only run 95 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster FlightDeck has run 0 times and has earned $0.00. It can only run 95 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster FlightDeck has run 8 times and has earned $0.00. It can only run 87 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster FlightDeck has run 0 times and has earned $0.00. It can only run 95 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster FlightDeck has run 0 times and has earned $0.00. It can only run 95 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54.",
        "Roller Coaster FlightDeck has run 0 times and has earned $0.00. It can only run 95 more "
            + "times. It costs $6.70 per ride and there is a one-time photo fee of $2.54."
    };



    // Outputs for the RollerCoaster costPerPassenger() test. Assumes the same roller coaster as
    // the inspectRide() test.
    private static final double[] ROLLERCOASTER_COSTPERPASSENGER_OUTPUTS = new double[] {
        2.54, 9.24, 15.94, 22.64, 29.34, 36.04, 42.74
    };



    // Constants for the RollerCoaster addPassengers() test.
    private static final Object[][] ROLLERCOASTER_ADDPASSENGERS_INPUTS = new Object[][] {
        new Object[] {
            "5 slots total, 5 empty, 5 new passengers.",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            1
        },
        new Object[] {
            "5 slots total, 4 empty, 4 new passengers.",
            new String[] {null, "Bob", null, null, null},
            new String[] {"Ann", "Cam", "Dan", "Ed"},
            1
        },
        new Object[] {
            "5 slots total, 5 empty, 4 new passengers.",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Cam", "Dan", "Ed"},
            1
        },
        new Object[] {
            "4 slots total, 4 empty, 5 new passengers.",
            new String[] {null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            1
        },
        new Object[] {
            "5 slots total, 3 empty, 3 new passengers.",
            new String[] {null, "Bob", null, "Dan", null},
            new String[] {"Ann", "Cam", "Ed"},
            1
        },
        new Object[] {
            "5 slots total, 3 empty, 2 new passengers.",
            new String[] {null, "Bob", null, "Dan", null},
            new String[] {"Ann", "Cam"},
            1
        },
        new Object[] {
            "5 slots total, 5 empty, 6 new passengers.",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed", "Fin"},
            1
        },
        new Object[] {
            "negative number of runs",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            -1
        },
        new Object[] {
            "0 runs",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            0
        },
        new Object[] {
            "max number of runs",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            10
        },
        new Object[] {
            "too many runs",
            new String[] {null, null, null, null, null},
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            11
        },
    };

    private static final boolean[] ROLLERCOASTER_ADDPASSENGERS_OUTPUTS = new boolean[] {
        true, true, true, false, true, true, false, false, true, true, false
    };

    private static final String[] ROLLERCOASTER_ADDPASSENGERS_TOSTRING_OUTPUTS = new String[] {
        "Roller Coaster FlightDeck has run 2 times and has earned $10.05. It can only run "
            + "9 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 2 times and has earned $8.04. It can only run "
            + "9 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 2 times and has earned $8.04. It can only run "
            + "9 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 1 times and has earned $0.00. It can only run "
            + "10 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 2 times and has earned $6.03. It can only run "
            + "9 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 2 times and has earned $4.02. It can only run "
            + "9 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 1 times and has earned $0.00. It can only run "
            + "10 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 1 times and has earned $0.00. It can only run "
            + "10 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 1 times and has earned $5.00. It can only run "
            + "10 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 11 times and has earned $55.50. It can only run "
            + "0 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
        "Roller Coaster FlightDeck has run 1 times and has earned $0.00. It can only run "
            + "10 more times. It costs $1.01 per ride and there is a one-time photo fee of $1.00.",
    };



    // Constants for the RollerCoaster .equals() test
    private static final RollerCoaster ROLLERCOASTER_EQUALS_ORIGINAL =
        new RollerCoaster("FlightDeck", 8, new String[] {"Sun Tzu"}, 6.70, 2.54, 95);
    private static final RollerCoaster[] ROLLERCOASTER_EQUALS_INPUTS = new RollerCoaster[] {
        new RollerCoaster("FlightDeck", 8, new String[] {"Sun Tzu"}, 6.70, 2.54, 95),
        new RollerCoaster("Railblazer", 8, new String[] {"Sun Tzu"}, 6.70, 2.54, 95),
        new RollerCoaster("FlightDeck", 1, new String[] {"Sun Tzu"}, 6.70, 2.54, 95),
        new RollerCoaster("FlightDeck", 8, new String[] {"Skipper"}, 6.70, 2.54, 95),
        new RollerCoaster("FlightDeck", 8, new String[] {"Sun Tzu"}, 9.71, 2.54, 95),
        new RollerCoaster("FlightDeck", 8, new String[] {"Sun Tzu"}, 6.70, 6.04, 95),
        new RollerCoaster("FlightDeck", 8, new String[] {"Sun Tzu"}, 6.70, 2.54, 27),
    };

    private static final String[] ROLLERCOASTER_EQUALS_LABELS = new String[] {
        "identical objects",
        "different ID",
        "different runsSinceInspection",
        "different passenger list",
        "different rate",
        "different photoFees",
        "different maxNumRuns"
    };

    private static final boolean[] ROLLERCOASTER_EQUALS_OUTPUTS = new boolean[] {
        true, false, false, true, false, false, false
    };



    // Constants for the RollerCoaster deep copy test
    private static String[] rollercoasterDeepcopyPassengerList = new String[] {
        "Dipper",
        "Mabel",
        null,
        null,
        null,
    };

    private static final String[] ROLLERCOASTER_DEEPCOPY_ADDPASSENGERS = new String[] {
        "Grunkle Stan",
        "Grunkle Ford",
    };

    private static final Object[] WEIRDMAGEDDON_COASTER = new Object[] {
        "Weirdmageddon",
        0,
        rollercoasterDeepcopyPassengerList,
        1.01,
        1.00,
        10
    };



    // Constants for the Trolley's constructor test
    private static final Object[][] TROLLEY_CONSTRUCTOR_INPUTS = new Object[][] {
        new Object[] {"4-arg constructor", "Blue", 1, new String[] {"East", "West", "CRC"}, 0},
        new Object[] {"3-arg constructor", "Red", new String[] {"East", "CRC", "West"}, 1},
        new Object[] {"spaces in ID", "Gold Line", 1, new String[] {"CRC", "West", "Tech Square"}, 0},
        new Object[] {"maximum station", "Green", new String[] {"CRC", "West", "SCC", "Hub"}, 2}
    };

    private static final String[] TROLLEY_CONSTRUCTOR_OUTPUTS = new String[] {
        "Trolley Blue has driven 1 loops and has earned $0.00. This trolley is at East. Next up "
            + "is West.",
        "Trolley Red has driven 0 loops and has earned $0.00. This trolley is at CRC. Next up is West.",
        "Trolley Gold Line has driven 1 loops and has earned $0.00. This trolley is at CRC. Next "
            + "up is West.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at SCC. Next up is Hub."
    };



    // Constants for the Trolley's canRun test
    private static final Trolley TROLLEY_CANRUN_TESTER = new Trolley(
        "Green",
        2,
        new String[] {"Hub", "CRC", "West", "SCC"},
        0
    );

    private static final int[] TROLLEY_CANRUN_INPUTS = new int[] {-2, -1, 0, 1, 10, 100, 1000};

    private static final boolean[] TROLLEY_CANRUN_OUTPUTS = new boolean[] {
        false, false, true, true, true, true, true
    };



    // Constants for the Trolley inspectRide() test
    private static final Object[][] TROLLEY_INSPECTRIDE_INPUTS = new Object[][] {
        new Object[] {"two-element array", new String[] {"Gas Tank Not Empty", "Brakes Ok"}},
        new Object[] {"many-element array", new String[] {"Gas Tank Not Empty", "Brakes Ok", "a", "b"}},
        new Object[] {"one element contains both strings", new String[] {"Gas Tank Not Empty,Brakes Ok"}}, //check this
        new Object[] {"all-lowercase", new String[] {"gas tank not empty", "brakes ok"}},
        new Object[] {"all-uppercase", new String[] {"GAS TANK NOT EMPTY", "BRAKES OK"}},
        new Object[] {"different order", new String[] {"a", "b", "Gas Tank Not Empty", "c", "Brakes Ok"}}
    };

    private static final boolean[] TROLLEY_INSPECTRIDE_OUTPUTS = new boolean[] {
        true, true, false, true, true, true
    };

    private static final String[] TROLLEY_INSPECTRIDE_TOSTRING_OUTPUTS = new String[] {
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 2 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
    };



    // Outputs for the Trolley's costPerPassenger() test. Assumes the same roller coaster as
    // the canRun() test.
    private static final double[][] TROLLEY_COSTPERPASSENGER_OUTPUTS = new double[][] {
        new double[] {0.0, 0.75, 1.5, 2.25, 3.0},
        new double[] {0.0, 0.6, 1.2, 1.8, 2.4}
    };



    // Constants for the addPassengers() test.
    private static final Object[][] TROLLEY_ADDPASSENGERS_INPUTS = new Object[][] {
        new Object[] {
            "2 new passengers, 2 stops",
            new String[] {"Ann", "Cam"},
            2
        },
        new Object[] {
            "3 new passengers, 3 stops",
            new String[] {"Ann", "Cam", "Ed"},
            3
        },
        new Object[] {
            "4 new passengers, 4 stops",
            new String[] {"Ann", "Bob", "Cam", "Dan"},
            4
        },
        new Object[] {
            "20 (max) new passengers, 2 stops",
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed", "Fin", "Gus", "Hank", "Ian", "Jess",
                          "Kyle", "Lin", "Mac", "Ned", "Oak", "Pam", "Qin", "Roy", "Sam", "Ted"},
            2
        },
        new Object[] {
            "21 new passengers, 2 stops",
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed", "Fin", "Gus", "Hank", "Ian", "Jess",
                          "Kyle", "Lin", "Mac", "Ned", "Oak", "Pam", "Qin", "Roy", "Sam", "Ted",
                          "I couldn't think of any short names that begin with U"},
            2
        },
        new Object[] {
            "negative number of runs",
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            -1
        },
        new Object[] {
            "0 runs",
            new String[] {"Ann", "Bob", "Cam", "Dan", "Ed"},
            0
        },
    };

    private static final boolean[] TROLLEY_ADDPASSENGERS_OUTPUTS = new boolean[] {
        true, true, true, true, true, false, true
    };

    private static final String[] TROLLEY_ADDPASSENGERS_TOSTRING_OUTPUTS = new String[] {
        "Trolley Red has driven 1 loops and has earned $3.00. This trolley is at CRC. Next up is Hub.",
        "Trolley Red has driven 1 loops and has earned $6.75. This trolley is at Hub. Next up is East.",
        "Trolley Red has driven 2 loops and has earned $12.00. This trolley is at East. Next up is West.",
        "Trolley Red has driven 1 loops and has earned $30.00. This trolley is at CRC. Next up is Hub.",
        "Trolley Red has driven 1 loops and has earned $30.00. This trolley is at CRC. Next up is Hub.",
        "Trolley Red has driven 1 loops and has earned $0.00. This trolley is at East. Next up is West.",
        "Trolley Red has driven 1 loops and has earned $0.00. This trolley is at East. Next up is West.",
    };



    // Constants for Trolley .equals() test
    private static final Trolley TROLLEY_EQUALS_ORIGINAL =
        new Trolley("Green", 1, new String[] {"Hub", "CRC", "West", "SCC"}, 0);

    private static final Trolley[] TROLLEY_EQUALS_INPUTS = new Trolley[] {
        new Trolley("Green", 1, new String[] {"Hub", "CRC", "West", "SCC"}, 0),
        new Trolley("Not Green", 1, new String[] {"Hub", "CRC", "West", "SCC"}, 0),
        new Trolley("Green", 2, new String[] {"Hub", "CRC", "West", "SCC"}, 0),
        new Trolley("Green", 1, new String[] {"Hub", "CRC", "SCC"}, 0),
        new Trolley("Green", 1, new String[] {"Hub", "CRC", "West", "SCC"}, 1)
    };

    private static final String[] TROLLEY_EQUALS_LABELS = new String[] {
        "identical objects",
        "different ID",
        "different runsSinceInspection",
        "different stations",
        "different currentStation"
    };

    private static final boolean[] TROLLEY_EQUALS_OUTPUTS = new boolean[] {
        true, false, false, false, false
    };

    // Constants for moveTrolley() test
    private static final String[] MOVE_TROLLEY_OUTPUTS = new String[] {
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at CRC. Next up is West.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at West. Next up is SCC.",
        "Trolley Green has driven 0 loops and has earned $0.00. This trolley is at SCC. Next up is Hub.",
        "Trolley Green has driven 1 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 1 loops and has earned $0.00. This trolley is at CRC. Next up is West.",
        "Trolley Green has driven 1 loops and has earned $0.00. This trolley is at West. Next up is SCC.",
        "Trolley Green has driven 1 loops and has earned $0.00. This trolley is at SCC. Next up is Hub.",
        "Trolley Green has driven 2 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 2 loops and has earned $0.00. This trolley is at CRC. Next up is West.",
        "Trolley Green has driven 2 loops and has earned $0.00. This trolley is at West. Next up is SCC.",
        "Trolley Green has driven 2 loops and has earned $0.00. This trolley is at SCC. Next up is Hub.",
        "Trolley Green has driven 3 loops and has earned $0.00. This trolley is at Hub. Next up is CRC.",
        "Trolley Green has driven 3 loops and has earned $0.00. This trolley is at CRC. Next up is West.",
        "Trolley Green has driven 3 loops and has earned $0.00. This trolley is at West. Next up is SCC.",
        "Trolley Green has driven 3 loops and has earned $0.00. This trolley is at SCC. Next up is Hub.",
    };



    // Constants for the Ride removePassenger() test
    private static final Object[][] RIDE_REMOVEPASSENGER_INPUTS = new Object[][] {
        new Object[] {"typical passenger", "Tremor", 0, new String[] {"Lindsay", "Katia", "Yoon"},
                      1.0, 1.00, 10, "Lindsay"},
        new Object[] {"passenger does not exist", "Tremor", 0, new String[] {"Ansel", "Kritt", "Elise"},
                      1.0, 1.00, 10, "Roopa"},
        new Object[] {"null passengers exist in passenger list", "Tremor", 0, new String[] {null, "Itay", "Kyle"},
                      1.0, 1.00, 10, "Kyle"},
        new Object[] {"all-caps comparison", "Tremor", 0, new String[] {"Aditi", "Armaan", "Sebby"},
                      1.0, 1.00, 10, "SEBBY"},
        new Object[] {"all-lowercase comparison", "Tremor", 0, new String[] {"Vi", "Auhon", "Rachel"},
                      1.0, 1.00, 10, "auhon"},
        new Object[] {"passenger named \"null\"", "Tremor", 0, new String[] {null, "Shannon", "Laura", "Clarence"},
                      1.0, 1.00, 10, "null"},
        new Object[] {"duplicate passengers exist", "Tremor", 0, new String[] {"Aayush", "Ethan", "Ethan"},
                      1.0, 1.00, 10, "Ethan"},
    };

    private static final boolean[] RIDE_REMOVEPASSENGER_OUTPUTS = new boolean[] {
        true, false, true, true, true, false, true
    };

    private static final String[] RIDE_REMOVEPASSENGER_TOSTRING_OUTPUTS = new String[] {
        "Passenger List for Tremor:\nKatia\nYoon",
        "Passenger List for Tremor:\nAnsel\nKritt\nElise",
        "Passenger List for Tremor:\nItay",
        "Passenger List for Tremor:\nAditi\nArmaan",
        "Passenger List for Tremor:\nVi\nRachel",
        "Passenger List for Tremor:\nShannon\nLaura\nClarence",
        "Passenger List for Tremor:\nAayush\nEthan",
    };



    /**
     * Main method. Runs all tests and prints results to command line
     * @param args Not used.
     */
    public static void main(String[] args) {
        int[] totalResults = new int[] {0, 0};

        totalResults = addResults(totalResults, testRollerCoaster());
        totalResults = addResults(totalResults, testTrolley());
        totalResults = addResults(totalResults, testRide());
        totalResults = addResults(totalResults, testEqualsMethods());

        System.out.println(createBox(new String[] {"Testing complete!",
                                     formatResults(totalResults, false)}, BOX_WIDTH + 10));
    }



    /**
     * Tests constructors, canRun(), inspectRide(), costPerPassenger(), addPassengers(), equals(),
     * and toString() methods of the RollerCoaster class, and returns the total passed/failed. Also
     * checks whether the passenger list is properly deep copied.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoaster() {
        int[] results = new int[] {0, 0};

        System.out.println(createBox(new String[] {"Testing Roller Coaster..."}, BOX_WIDTH));

        results = addResults(results, testRollerCoasterConstructors());
        results = addResults(results, testRollerCoasterCanRun());
        results = addResults(results, testRollerCoasterInspectRide());
        results = addResults(results, testRollerCoasterCostPerPassenger());
        results = addResults(results, testRollerCoasterAddPassengers());
        results = addResults(results, testRollerCoasterEquals());
        results = addResults(results, testRollerCoasterDeepCopy());

        System.out.println(createBox(new String[] {"Done testing Roller Coaster!",
                           formatResults(results, false)}, BOX_WIDTH));
        return results;
    }

    /**
     * Tests RollerCoaster constructors.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterConstructors() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing constructors and toString()"));

        for (int i = 0; i < ROLLERCOASTER_CONSTRUCTOR_INPUTS.length; i++) {
            Object[] args = ROLLERCOASTER_CONSTRUCTOR_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            RollerCoaster coaster;
            if (args.length == 7) {
                coaster = new RollerCoaster((String) args[1], (int) args[2], (String[]) args[3],
                                            (double) args[4], (double) args[5], (int) args[6]);
            } else if (args.length == 4) {
                coaster = new RollerCoaster((String) args[1], (int) args[2], (int) args[3]);
            } else {
                coaster = new RollerCoaster((String) args[1]);
            }

            if (coaster.toString().equals(ROLLERCOASTER_CONSTRUCTOR_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %s\n    but received %s\n",
                                  ROLLERCOASTER_CONSTRUCTOR_OUTPUTS[i], coaster.toString());
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests RollerCoaster canRun() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterCanRun() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing canRun()"));
        System.out.println("This RollerCoaster has done 6 runs, with a max of 70.");

        RollerCoaster coaster = ROLLERCOASTER_CANRUN_TESTER;
        for (int i = 0; i < ROLLERCOASTER_CANRUN_INPUTS.length; i++) {
            System.out.println(String.format("Testing %d...", ROLLERCOASTER_CANRUN_INPUTS[i]));

            if (coaster.canRun(ROLLERCOASTER_CANRUN_INPUTS[i]) == ROLLERCOASTER_CANRUN_OUTPUTS[i]) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %b but received %b\n",
                                  ROLLERCOASTER_CANRUN_OUTPUTS[i],
                                  coaster.canRun(ROLLERCOASTER_CANRUN_INPUTS[i]));
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests RollerCoaster inspectRide() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterInspectRide() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing inspectRide()"));

        for (int i = 0; i < ROLLERCOASTER_INSPECTRIDE_INPUTS.length; i++) {
            Object[] args = ROLLERCOASTER_INSPECTRIDE_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            RollerCoaster coaster = new RollerCoaster("FlightDeck", 8,
                new String[] {"Dipper", "Mabel", "Bill"}, 6.70, 2.54, 95);

            boolean inspection = coaster.inspectRide((String[]) args[1]);
            if (inspection == ROLLERCOASTER_INSPECTRIDE_OUTPUTS[i]
                && coaster.toString().equals(ROLLERCOASTER_INSPECTRIDE_TOSTRING_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                if (inspection != ROLLERCOASTER_INSPECTRIDE_OUTPUTS[i]) {
                    System.out.printf("Failed! Expected %b but received %b\n",
                                      ROLLERCOASTER_INSPECTRIDE_OUTPUTS[i], inspection);
                } else {
                    System.out.printf("Failed! Expected %s\n    but received %s\n",
                                      ROLLERCOASTER_INSPECTRIDE_TOSTRING_OUTPUTS[i],
                                      coaster.toString());
                }
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests RollerCoaster costPerPassenger() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterCostPerPassenger() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing costPerPassenger()"));

        RollerCoaster coaster = new RollerCoaster("FlightDeck", 8,
            new String[] {"Dipper", "Mabel", "Bill"}, 6.70, 2.54, 95);

        for (int i = 0; i < ROLLERCOASTER_COSTPERPASSENGER_OUTPUTS.length; i++) {
            System.out.printf("Testing %d...\n", i);
            double cost = coaster.costPerPassenger(i);

            if (doublesEquals(cost, ROLLERCOASTER_COSTPERPASSENGER_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %f but received %f.\n",
                                  ROLLERCOASTER_COSTPERPASSENGER_OUTPUTS[i], cost);
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests RollerCoaster addPassengers() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterAddPassengers() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing addPassengers()"));

        for (int i = 0; i < ROLLERCOASTER_ADDPASSENGERS_INPUTS.length; i++) {
            Object[] args = ROLLERCOASTER_ADDPASSENGERS_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            RollerCoaster coaster = new RollerCoaster("FlightDeck", 1,
                (String[]) args[1], 1.01, 1.00, 11);
            boolean testResult = coaster.addPassengers((int) args[3], (String[]) args[2]);
            String toString = coaster.toString();

            if (testResult == ROLLERCOASTER_ADDPASSENGERS_OUTPUTS[i]
                && toString.equals(ROLLERCOASTER_ADDPASSENGERS_TOSTRING_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                if (testResult != ROLLERCOASTER_ADDPASSENGERS_OUTPUTS[i]) {
                    System.out.printf("Failed! Expected %b but received %b\n",
                                      ROLLERCOASTER_ADDPASSENGERS_OUTPUTS[i], testResult);
                } else {
                    System.out.printf("Failed! Expected %s\n    but received %s\n",
                                      ROLLERCOASTER_ADDPASSENGERS_TOSTRING_OUTPUTS[i],
                                      toString);
                }
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests RollerCoaster equals() method, for correctness and commutativity.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterEquals() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing equals()"));

        for (int i = 0; i < ROLLERCOASTER_EQUALS_INPUTS.length; i++) {
            System.out.println("Testing " + ROLLERCOASTER_EQUALS_LABELS[i] + "...");
            boolean check1 = ROLLERCOASTER_EQUALS_ORIGINAL.equals(ROLLERCOASTER_EQUALS_INPUTS[i]);
            boolean check2 = ROLLERCOASTER_EQUALS_INPUTS[i].equals(ROLLERCOASTER_EQUALS_ORIGINAL);

            if (check1 != check2) {
                results[1]++;
                System.out.println("Failed! Your .equals() method is not commutative!");
            } else if (check1 != ROLLERCOASTER_EQUALS_OUTPUTS[i]) {
                results[1]++;
                System.out.printf("Failed! Expected %b, received %b\n",
                    ROLLERCOASTER_EQUALS_OUTPUTS[i], check1);
            } else {
                results[0]++;
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests whether the passenger list is deep copied in the constructor. Depends on
     * addPassengers() being correct.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRollerCoasterDeepCopy() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing deep copy of passenger list"));
        System.out.println("Note: This test depends on addPassengers() being correct!");

        System.out.println("\nConstructing new RollerCoaster...");

        RollerCoaster coaster = new RollerCoaster(
            (String) WEIRDMAGEDDON_COASTER[0],
            (int) WEIRDMAGEDDON_COASTER[1],
            rollercoasterDeepcopyPassengerList,
            (double) WEIRDMAGEDDON_COASTER[3],
            (double) WEIRDMAGEDDON_COASTER[4],
            (int) WEIRDMAGEDDON_COASTER[5]
        );

        rollercoasterDeepcopyPassengerList[2] = "Bill";
        rollercoasterDeepcopyPassengerList[3] = "Bodacious T";

        boolean added = coaster.addPassengers(1, ROLLERCOASTER_DEEPCOPY_ADDPASSENGERS);
        if (added) {
            results[0]++;
        } else {
            results[1]++;
            System.out.println("It looks like the Driver was able to change the value of the "
                               + "passengers list within the ride. This is either due to improper "
                               + "deep copying, or a bug with addPassengers().");
        }

        System.out.println(formatResults(results, true));
        return results;
    }



    /**
     * Tests constructors, canRun(), inspectRide(), costPerPassenger(), addPassengers(), equals(),
     * and toString() methods of the RollerCoaster class, and returns the total passed/failed. Also
     * checks whether the passenger list is properly deep copied.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolley() {
        int[] results = new int[] {0, 0};

        System.out.println(createBox(new String[] {"Testing Trolley..."}, BOX_WIDTH));

        results = addResults(results, testTrolleyConstructors());
        results = addResults(results, testTrolleyCanRun());
        results = addResults(results, testTrolleyInspectRide());
        results = addResults(results, testTrolleyCostPerPassenger());
        results = addResults(results, testTrolleyAddPassengers());
        results = addResults(results, testTrolleyEquals());
        results = addResults(results, testMoveTrolley());
        results = addResults(results, testTrolleyDeepCopy());

        System.out.println(createBox(new String[] {"Done testing Trolley!",
                           formatResults(results, false)}, BOX_WIDTH));
        return results;
    }

    /**
     * Tests Trolley constructors.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyConstructors() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing constructors and toString()"));

        for (int i = 0; i < TROLLEY_CONSTRUCTOR_INPUTS.length; i++) {
            Object[] args = TROLLEY_CONSTRUCTOR_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            Trolley trolley;
            if (args.length == 5) {
                trolley = new Trolley((String) args[1], (int) args[2], (String[]) args[3], (int) args[4]);
            } else {
                trolley = new Trolley((String) args[1], (String[]) args[2], (int) args[3]);
            }

            if (trolley.toString().equals(TROLLEY_CONSTRUCTOR_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %s\n    but received %s\n",
                                  TROLLEY_CONSTRUCTOR_OUTPUTS[i], trolley.toString());
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley constructors.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyCanRun() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing canRun()"));

        Trolley trolley = TROLLEY_CANRUN_TESTER;
        for (int i = 0; i < TROLLEY_CANRUN_INPUTS.length; i++) {
            System.out.println(String.format("Testing %d...", TROLLEY_CANRUN_INPUTS[i]));

            if (trolley.canRun(TROLLEY_CANRUN_INPUTS[i]) == TROLLEY_CANRUN_OUTPUTS[i]) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %b but received %b\n",
                                  TROLLEY_CANRUN_OUTPUTS[i],
                                  trolley.canRun(TROLLEY_CANRUN_INPUTS[i]));
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley inspectRide() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyInspectRide() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing inspectRide()"));

        for (int i = 0; i < TROLLEY_INSPECTRIDE_INPUTS.length; i++) {
            Object[] args = TROLLEY_INSPECTRIDE_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            Trolley trolley = new Trolley("Green", 2, new String[] {"Hub", "CRC", "West", "SCC"}, 0);

            boolean inspection = trolley.inspectRide((String[]) args[1]);
            if (inspection == TROLLEY_INSPECTRIDE_OUTPUTS[i]
                && trolley.toString().equals(TROLLEY_INSPECTRIDE_TOSTRING_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                if (inspection != TROLLEY_INSPECTRIDE_OUTPUTS[i]) {
                    System.out.printf("Failed! Expected %b but received %b\n",
                                      TROLLEY_INSPECTRIDE_OUTPUTS[i], inspection);
                } else {
                    System.out.printf("Failed! Expected %s\n    but received %s\n",
                                      TROLLEY_INSPECTRIDE_TOSTRING_OUTPUTS[i],
                                      trolley.toString());
                }
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley costPerPassenger() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyCostPerPassenger() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing costPerPassenger()"));

        Trolley trolley = new Trolley("Green", 2, new String[] {"Hub", "CRC", "West", "SCC"}, 0);
        Trolley trolley2 = new Trolley("Gold", 2, new String[] {"Hub", "CRC", "West", "Kendeda", "Tech Sq"}, 0);

        for (int i = 0; i < 5; i++) {
            System.out.printf("Testing %d stops on a 4-stop trolley...\n", i);
            double cost = trolley.costPerPassenger(i);

            if (doublesEquals(cost, TROLLEY_COSTPERPASSENGER_OUTPUTS[0][i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %f but received %f.\n",
                                  TROLLEY_COSTPERPASSENGER_OUTPUTS[0][i], cost);
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.printf("Testing %d stops on a 5-stop trolley...\n", i);
            double cost = trolley2.costPerPassenger(i);

            if (doublesEquals(cost, TROLLEY_COSTPERPASSENGER_OUTPUTS[1][i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %f but received %f.\n",
                                  TROLLEY_COSTPERPASSENGER_OUTPUTS[1][i], cost);
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley addPassengers() method.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyAddPassengers() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing addPassengers()"));

        for (int i = 0; i < TROLLEY_ADDPASSENGERS_INPUTS.length; i++) {
            Object[] args = TROLLEY_ADDPASSENGERS_INPUTS[i];
            System.out.println(String.format("Testing %s...", (String) args[0]));

            Trolley trolley = new Trolley("Red", 1, new String[] {"East", "West", "CRC", "Hub"}, 0);
            boolean testResult = trolley.addPassengers((int) args[2], (String[]) args[1]);
            String toString = trolley.toString();

            if (testResult == TROLLEY_ADDPASSENGERS_OUTPUTS[i]
                && toString.equals(TROLLEY_ADDPASSENGERS_TOSTRING_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                if (testResult != TROLLEY_ADDPASSENGERS_OUTPUTS[i]) {
                    System.out.printf("Failed! Expected %b but received %b\n",
                                      TROLLEY_ADDPASSENGERS_OUTPUTS[i], testResult);
                } else {
                    System.out.printf("Failed! Expected %s\n    but received %s\n",
                                      TROLLEY_ADDPASSENGERS_TOSTRING_OUTPUTS[i],
                                      toString);
                }
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley equals() method, for correctness and commutativity.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyEquals() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing equals()"));

        for (int i = 0; i < TROLLEY_EQUALS_INPUTS.length; i++) {
            System.out.println("Testing " + TROLLEY_EQUALS_LABELS[i] + "...");
            boolean check1 = TROLLEY_EQUALS_ORIGINAL.equals(TROLLEY_EQUALS_INPUTS[i]);
            boolean check2 = TROLLEY_EQUALS_INPUTS[i].equals(TROLLEY_EQUALS_ORIGINAL);

            if (check1 != check2) {
                results[1]++;
                System.out.println("Failed! Your .equals() method is not commutative!");
            } else if (check1 != TROLLEY_EQUALS_OUTPUTS[i]) {
                results[1]++;
                System.out.printf("Failed! Expected %b, received %b\n",
                    TROLLEY_EQUALS_OUTPUTS[i], check1);
            } else {
                results[0]++;
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests Trolley's moveTrolley() method for correctness.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testMoveTrolley() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing moveTrolley()"));

        for (int i = 0; i <= 15; i++) {
            System.out.printf("Testing %d stops...\n", i);
            Trolley trolley = new Trolley("Green", 0, new String[] {"Hub", "CRC", "West", "SCC"}, 0);
            trolley.moveTrolley(i);
            String toString = trolley.toString();

            if (toString.equals(MOVE_TROLLEY_OUTPUTS[i])) {
                results[0]++;
            } else {
                results[1]++;
                System.out.printf("Failed! Expected %s\n    but received %s\n",
                                   MOVE_TROLLEY_OUTPUTS[i],
                                   toString);
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }

    /**
     * Tests whether the stations array is deep copied.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testTrolleyDeepCopy() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing deep copy of stations list"));
        System.out.println("Note: This test depends on moveTrolley() being correct!");

        System.out.println("\nConstructing new Trolley...");

        String[] stops = new String[] {"Hub", "West", "East", "Emory"};
        Trolley trolley = new Trolley("GT/Emory", 0, stops, 0);

        stops[2] = "Tech Square";
        stops[3] = "UGA";

        trolley.moveTrolley(2);
        String expectedString = "Trolley GT/Emory has driven 0 loops and has earned $0.00. This "
                                 + "trolley is at East. Next up is Emory.";
        String badString = "Trolley GT/Emory has driven 0 loops and has earned $0.00. This "
                                 + "trolley is at Tech Square. Next up is UGA.";

        if (trolley.toString().equals(expectedString)) {
            results[0]++;
        } else if (trolley.toString().equals(badString)) {
            results[1]++;
            System.out.println("It looks like the Driver was able to change the value of the "
                               + "stations list within the trolley. This is likely due to "
                               + "improper deep copying.");
        } else {
            results[1]++;
            System.out.println("There is either a bug with moveTrolley() or with toString().");
        }

        System.out.println(formatResults(results, true));
        return results;
    }



    /**
     * Tests two methods of the Ride class, using RollerCoaster.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRide() {
        int[] results = new int[] {0, 0};

        System.out.println(createBox(new String[] {"Testing Ride..."}, BOX_WIDTH));

        results = addResults(results, testRideRemovePassenger());

        System.out.println(createBox(new String[] {"Done testing Ride!",
                           formatResults(results, false)}, BOX_WIDTH));
        return results;
    }

    /**
     * Tests Ride removePassenger() method for correctness.
     * @return The number passed and failed, in an array of length 2. Index 0 is passed, 1 is failed.
     */
    private static int[] testRideRemovePassenger() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing removePassenger() and getPassengerList"));
        System.out.println("Note: This test relies on RollerCoaster being implemented correctly!\n");

        for (int i = 0; i < RIDE_REMOVEPASSENGER_INPUTS.length; i++) {
            Object[] args = RIDE_REMOVEPASSENGER_INPUTS[i];

            System.out.println(String.format("Testing %s...", args[0]));
            RollerCoaster ride = new RollerCoaster((String) args[1], (int) args[2],
                                                          (String[]) args[3], (double) args[4],
                                                          (double) args[5], (int) args[6]);

            boolean result = ride.removePassenger((String) args[7]);
            if (result != RIDE_REMOVEPASSENGER_OUTPUTS[i]) {
                results[1]++;
                System.out.printf("Failed! Expected %b but received %b\n",
                                  RIDE_REMOVEPASSENGER_OUTPUTS[i],
                                  result);
            } else if (!ride.getPassengerList().equals(RIDE_REMOVEPASSENGER_TOSTRING_OUTPUTS[i])) {
                results[1]++;
                System.out.printf("Failed! Expected\n%s\nbut received\n%s\n",
                                  RIDE_REMOVEPASSENGER_TOSTRING_OUTPUTS[i],
                                  ride.getPassengerList());
            } else {
                results[0]++;
            }
        }

        System.out.println(formatResults(results, true));
        return results;
    }



    /**
     * Tests the equals methods of both Trolley and RollerCoaster, comparing with one another.
     * @return
     */
    private static int[] testEqualsMethods() {
        int[] results = new int[] {0, 0};
        System.out.println(formatTestHeader("Testing equals() between subclasses"));

        RollerCoaster coaster = new RollerCoaster("myRide", 1, 3);
        Trolley trolley = new Trolley("myRide", 1, new String[] {"GT", "Emory"}, 0);

        System.out.println("Testing coaster.equals(trolley)...");
        if (coaster.equals(trolley)) {
            results[1]++;
            System.out.println("Failed! Expected false, received true");
        } else {
            results[0]++;
        }

        System.out.println("Testing trolley.equals(coaster)...");
        if (trolley.equals(coaster)) {
            results[1]++;
            System.out.println("Failed! Expected false, received true");
        } else {
            results[0]++;
        }

        if (trolley.equals(coaster) != coaster.equals(trolley)) {
            System.out.println("Warning! Your Trolley and RollerCoaster equals() methods are not symmetric!");
        }

        System.out.println(formatResults(results, true));
        return results;
    }



    /**
     * Helper method that creates a box with the given strings and the given width, with a blank
     * line above and below the text. The text is centered in the box, and the strings are in the
     * order given. The string lengths MUST be less than or equal to width - 2.
     * @param labels The Strings to put inside the box. Must not be null or contain null elements.
     * @param width The width of the box, including the pipes on either end. Must be >= 3.
     * @return The formatted box, with neither leading nor trailing whitespace.
     */
    private static String createBox(String[] labels, int width) {
        StringBuilder s = new StringBuilder();

        // Making the top of the box
        s.append(" ");
        for (int i = 0; i < width - 2; i++) {
            s.append("-");
        }
        s.append("\n");

        // Box content
        s.append(formatString("", width) + "\n");
        for (int i = 0; i < labels.length; i++) {
            s.append(formatString(labels[i], width) + "\n");
        }
        s.append(formatString("", width) + "\n");

        // Bottom of the box
        s.append(" ");
        for (int i = 0; i < width - 2; i++) {
            s.append("-");
        }

        return s.toString();
    }

    /**
     * Helper method that centers the given text between two pipe symbols such
     * that the total string length is is the given length.
     * @param s The string to be centered
     * @param length The total length of the formatted string
     * @return The formatted String.
     */
    private static String formatString(String s, int length) {
        int leadingSpaces = (length - 2 - s.length()) / 2;
        int trailingSpaces = (length - 2 - s.length()) - leadingSpaces;
        String newString = "|";
        for (int i = 0; i < leadingSpaces; i++) {
            newString += " ";
        }
        newString += s;
        for (int i = 0; i < trailingSpaces; i++) {
            newString += " ";
        }
        newString += "|";
        return newString;
    }

    /**
     * Helper method to tally up passes/fails.
     * @param first The first array of passes and fails. Index 0 is passes, 1 is fails.
     * @param second The second array of passes and fails. Index 0 is passes, 1 is fails.
     * @return A new array of length 2. Index 0 is passes, 1 is fails.
     */
    private static int[] addResults(int[] first, int[] second) {
        return new int[] {first[0] + second[0], first[1] + second[1]};
    }

    /**
     * Helper method to format the results string
     * @param results The results to format. Index 0 is passes, 1 is fails.
     * @param addLine Whether to add a leading & trailing newline characters or not.
     * @return The formatted string.
     */
    private static String formatResults(int[] results, boolean addLines) {
        return String.format((addLines ? "\n" : "") + "Passed: %d, Failed: %d" + (addLines ? "\n" : ""),
                              results[0], results[1]);
    }

    /**
     * Helper method to format the method testing label
     * @param test The name of the current test
     * @return The formatted string
     */
    private static String formatTestHeader(String test) {
        return String.format("~ ~ ~ ~ ~ %s ~ ~ ~ ~ ~", test);
    }

    /**
     * Returns whether or not the two doubles are the same, to within 0.000001.
     * @param d1 The first double to compare.
     * @param d2 The second double to compare.
     * @return True if they're within the specified threshold. False otherwise.
     */
    private static boolean doublesEquals(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.000001;
    }
}