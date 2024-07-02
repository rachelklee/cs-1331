package HW05;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * This class will be used to test your code.
 * You need JUnit in order for the tests to properly function.
 *
 * Once you have set up testing in your IDE, just run all the tests and you will be able to see if something is not working properly.
 * 
 * You may wish to add more tests. I can't guarantee that this class tests every edge case.
 * @author Gustavo Eduardo Garfias Garcia
 * @version 1.1.0
 */
public class Tests {
    // no need for revision
    @Nested
    class GenreTests {
        @Test
        @DisplayName("Genre correct order. Genre contains all required genres.")
        void correctOrder() {
            assertEquals(0, Genre.ACTION.ordinal());
            assertEquals(1, Genre.COMEDY.ordinal());
            assertEquals(2, Genre.FANTASY.ordinal());
            assertEquals(3, Genre.HORROR.ordinal());
            assertEquals(4, Genre.MYSTERY.ordinal());
            assertEquals(5, Genre.ROMANCE.ordinal());
            assertEquals(6, Genre.SCI_FI.ordinal());
        }
    }

    // no need for revision
    @Nested
    class MovieTests {
        @Nested
        class MovieConstructors {
            @Test
            @DisplayName("Movie five-arg constructor exists and works.")
            void fiveArgConstructor() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertEquals("Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5," +
                        " Rental Price: $3.50, Runtime: 120", mov.toString());
                assertEquals(3.501, mov.getRentalPrice());
            }

            @Test
            @DisplayName("Movie three-arg constructor exists and works.")
            void threeArgConstructor() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5);

                assertEquals("Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5," +
                        " Rental Price: $5.00, Runtime: 111", mov.toString());
                assertEquals(5.0, mov.getRentalPrice());
            }
        }

        @Nested
        class MovieToString {
            @Test
            @DisplayName("Movie toString correct rentalPrice rounding.")
            void movieToStringCorrectRentalPriceRounding() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                assertEquals("Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5," +
                        " Rental Price: $3.50, Runtime: 120", mov.toString());
                assertEquals(3.501, mov.getRentalPrice());

                mov = new Movie(Genre.ACTION, "Fast and Furious V", 3, 3.567, 99);
                assertEquals("Genre: ACTION, Name: Fast and Furious V, Rating: 3," +
                        " Rental Price: $3.57, Runtime: 99", mov.toString());
                assertEquals(3.567, mov.getRentalPrice());
            }
        }

        @Nested
        class MovieEquals {
            @Test
            void movieEquals1() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertEquals(true, mov1.equals(mov2));
                assertEquals(true, mov2.equals(mov1));
            }

            @Test
            void movieEquals2() {
                Movie mov1 = new Movie(Genre.ACTION, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertEquals(false, mov1.equals(mov2));
                assertEquals(false, mov2.equals(mov1));
            }

            @Test
            void movieEquals3() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Ston", 5, 3.501, 120);

                assertEquals(false, mov1.equals(mov2));
                assertEquals(false, mov2.equals(mov1));
            }

            @Test
            void movieEquals4() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 4, 3.501, 120);

                assertEquals(false, mov1.equals(mov2));
                assertEquals(false, mov2.equals(mov1));
            }

            @Test
            void movieEquals5() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.5011, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertEquals(false, mov1.equals(mov2));
                assertEquals(false, mov2.equals(mov1));
            }

            @Test
            void movieEquals6() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 121);

                assertEquals(false, mov1.equals(mov2));
                assertEquals(false, mov2.equals(mov1));
            }
        }
    }

    // no need for revision
    @Nested
    class CompareToTests {
        @Nested
        class CompareToTestsOnlyMovies {
            @Test
            void compareToTestEquals() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertEquals(0, mov2.compareTo(mov1));
                assertEquals(0, mov1.compareTo(mov2));
            }

            @Test
            void compareToTestByGenre() {
                Movie mov1 = new Movie(Genre.ACTION, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.COMEDY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertTrue(mov1.compareTo(mov2) < 0);
                assertTrue(mov2.compareTo(mov1) > 0);
            }

            @Test
            void compareToTestByName() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone A", 5, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone B", 5, 3.501, 120);

                assertTrue(mov1.compareTo(mov2) < 0);
                assertTrue(mov2.compareTo(mov1) > 0);
            }

            @Test
            void compareToTestByRating() {
                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 3, 3.501, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);

                assertTrue(mov1.compareTo(mov2) < 0);
                assertTrue(mov2.compareTo(mov1) > 0);
            }
        }

        @Nested
        class CompareToTestsOnlyVideoGames {
            @Test
            void compareToTestEquals() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 2.098, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 2.098, 3, true);

                assertEquals(0, game1.compareTo(game2));
                assertEquals(0, game2.compareTo(game1));
            }

            @Test
            void compareToTestByGenre() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 2.098, 3, true);
                VideoGame game2 = new VideoGame(Genre.COMEDY, "Mortal Kombat 11", 4, 2.098, 3, true);

                assertTrue(game1.compareTo(game2) < 0);
                assertTrue(game2.compareTo(game1) > 0);
            }

            @Test
            void compareToTestByName() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11 A", 4, 2.098, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11 B", 4, 2.098, 3, true);

                assertTrue(game1.compareTo(game2) < 0);
                assertTrue(game2.compareTo(game1) > 0);
            }

            @Test
            void compareToTestByRating() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 3, 2.098, 3, true);
                VideoGame game2 = new VideoGame(Genre.COMEDY, "Mortal Kombat 11", 4, 2.098, 3, true);

                assertTrue(game1.compareTo(game2) < 0);
                assertTrue(game2.compareTo(game1) > 0);
            }
        }
        
        @Nested
        class CompareToTestsMixed {
            @Test
            void compareToTestEquals() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 2.098, 3, true);

                assertEquals(0, mov.compareTo(game));
                assertEquals(0, game.compareTo(mov));
            }

            @Test
            void compareToTestByGenre() {
                Movie mov = new Movie(Genre.ACTION, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                VideoGame game = new VideoGame(Genre.COMEDY, "Harry Potter and the Philosopher's Stone", 5, 2.098, 3, true);

                assertTrue(mov.compareTo(game) < 0);
                assertTrue(game.compareTo(mov) > 0);
            }

            @Test
            void compareToTestByName() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone A", 5, 3.501, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter and the Philosopher's Stone B", 5, 2.098, 3, true);

                assertTrue(mov.compareTo(game) < 0);
                assertTrue(game.compareTo(mov) > 0);
            }

            @Test
            void compareToTestByRating() {
                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 4, 3.501, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 2.098, 3, true);

                assertTrue(mov.compareTo(game) < 0);
                assertTrue(game.compareTo(mov) > 0);
            }
        }
    }

    // no need for revision
    @Nested
    class VideoGameTests {
        @Nested
        class VideoGameConstructors {
            @Test
            @DisplayName("VideoGame six-arg constructor exists and works.")
            void sixArgConstructor() {
                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 2.098, 3, true);

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                        " Rental Price: $2.10, Players: 3, does need console", game.toString());
                assertEquals(2.098, game.getRentalPrice());
            }

            @Test
            @DisplayName("VideoGame three-arg constructor exists and works.")
            void threeArgConstructor() {
                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4);

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                        " Rental Price: $5.00, Players: 2, does not need console", game.toString());
                assertEquals(5.0, game.getRentalPrice());
            }
        }

        @Nested
        class VideoGameToString {
            @Test
            @DisplayName("VideoGame toString correct rentalPrice rounding.")
            void movieToStringCorrectRentalPriceRounding() {
                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                        " Rental Price: $3.00, Players: 3, does need console", game.toString());

                game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.006, 3, true);

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                        " Rental Price: $3.01, Players: 3, does need console", game.toString());
            }
        }

        @Nested
        class VideoGameEquals {
            @Test
            void VideoGameEquals1() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(true, game1.equals(game2));
                assertEquals(true, game2.equals(game1));
            }

            @Test
            void VideoGameEquals2() {
                VideoGame game1 = new VideoGame(Genre.MYSTERY, "Mortal Kombat 11", 4, 3.004, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEquals3() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 1", 4, 3.004, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEquals4() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 3, 3.004, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEquals5() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.0041, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEquals6() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 4, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEquals7() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);
                VideoGame game2 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, false);

                assertEquals(false, game1.equals(game2));
                assertEquals(false, game2.equals(game1));
            }

            @Test
            void VideoGameEqualsMovie() {
                VideoGame game1 = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);
                Movie mov2 = new Movie(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 120);

                assertEquals(false, game1.equals(mov2));
                assertEquals(false, mov2.equals(game1));
            }
        }
    }

    // revised
    @Nested
    class BlockbusterTests {
        // revised
        @Nested
        class BlockbusterAddMedia {
            // revised
            @Test
            void blockbusterAddMedia1() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;

                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                store.addMedia(game);

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                    " Rental Price: $3.00, Players: 3, does need console\n", inventoryString);

                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                
                store.addMedia(mov);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4,"
                    + " Rental Price: $3.00, Players: 3, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
            }
        }

        // revised
        @Nested
        class BlockbusterRemoveMedia {
            // revised
            @Test
            void blockbusterRemoveMediaValidInput1() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;

                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                store.addMedia(game);

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                    " Rental Price: $3.00, Players: 3, does need console\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                
                store.addMedia(mov);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4,"
                    + " Rental Price: $3.00, Players: 3, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                store.removeMedia(game);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
            }

            // revised
            @Test
            void blockbusterRemoveMediaValidInput2() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;

                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                store.addMedia(game);

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                    " Rental Price: $3.00, Players: 3, does need console\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                
                store.addMedia(mov);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4,"
                    + " Rental Price: $3.00, Players: 3, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                store.removeMedia(mov);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                    " Rental Price: $3.00, Players: 3, does need console\n", inventoryString);
            }

            // revised
            @Test
            void blockbusterRemoveMediaNonExistentItem() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;

                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                VideoGame game = new VideoGame(Genre.ACTION, "Mortal Kombat 11", 4, 3.004, 3, true);

                store.addMedia(game);

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4," +
                    " Rental Price: $3.00, Players: 3, does need console\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                Movie mov = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Stone", 5, 3.501, 120);
                
                store.addMedia(mov);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4,"
                    + " Rental Price: $3.00, Players: 3, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString),
                    () -> "Aborting test: addMedia is non-functional.");

                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter and the Philosopher's Ston", 5, 3.501, 120);

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals(null, store.removeMedia(mov2));
                assertEquals("Genre: ACTION, Name: Mortal Kombat 11, Rating: 4,"
                    + " Rental Price: $3.00, Players: 3, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter and the Philosopher's Stone, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
            }
        }
    
        // revised
        @Nested
        class BlockbusterSortMedia {
            // revised
            @Test
            void blockbusterSortMediaByName() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;

                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String invString = "";

                try {
                    invString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", invString);
            }

            // revised
            @Test
            void blockbusterSortMediaByGenre() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.ACTION, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.COMEDY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.HORROR, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.MYSTERY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.ROMANCE, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.SCI_FI, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.ACTION, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.ACTION, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);
                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: ACTION, Name: Harry Potter 1, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: ACTION, Name: Harry Potter 8, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: ACTION, Name: Harry Potter 9, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: COMEDY, Name: Harry Potter 2, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: HORROR, Name: Harry Potter 4, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: MYSTERY, Name: Harry Potter 5, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: ROMANCE, Name: Harry Potter 6, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: SCI_FI, Name: Harry Potter 7, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        , inventoryString);
            }
            
            // revised
            @Test
            void blockbusterSortMediaByRating() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter", 1, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter", 2, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter", 3, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter", 4, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter", 6, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter", 7, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter", 8, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter", 9, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 2,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 3,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 4,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 5,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 6,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 7,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 8,"
                        + " Rental Price: $3.50, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 9,"
                        + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
            }

            // revised
            @Test
            void blockbusterSortMediaByNothing() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter", 1, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter", 1, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter", 1, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter", 1, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter", 1, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter", 1, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter", 1, 8.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter", 1, 9.0, 120);
                
                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $7.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $2.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $5.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $1.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $8.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $4.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $9.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $6.00, Runtime: 120\n"
                        + "Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                        + " Rental Price: $3.00, Runtime: 120\n", inventoryString);
            }
        }

        // revised
        @Nested
        class BlockbusterFindMedia {
            // revised
            @Test
            void blockbusterFindMediaFound() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter A", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter B", 1, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter C", 1, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter D", 1, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter E", 1, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter F", 1, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter G", 1, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter H", 1, 8.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter I", 1, 9.0, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String storeInventory = "";

                try {
                    storeInventory = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter A, Rating: 1,"
                    + " Rental Price: $1.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter B, Rating: 1,"
                    + " Rental Price: $2.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter C, Rating: 1,"
                    + " Rental Price: $3.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter D, Rating: 1,"
                    + " Rental Price: $4.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter E, Rating: 1,"
                    + " Rental Price: $5.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter F, Rating: 1,"
                    + " Rental Price: $6.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter G, Rating: 1,"
                    + " Rental Price: $7.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter H, Rating: 1,"
                    + " Rental Price: $8.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter I, Rating: 1,"
                    + " Rental Price: $9.00, Runtime: 120\n").equals(storeInventory));

                Movie mov1copy = new Movie(Genre.FANTASY, "Harry Potter A", 1, 1.0, 120);
                Movie mov2copy = new Movie(Genre.FANTASY, "Harry Potter B", 1, 1.0, 120);

                Media found = store.findMedia(mov1copy);

                assertEquals(0, found.compareTo(mov1copy));
                assertTrue(found.compareTo(mov2copy) != 0);
                assertTrue(found == mov1);
                assertTrue(found != mov2);
                assertTrue(found != mov1copy);
                assertTrue(found != mov2copy);
            }

            // revised
            @Test
            void blockbusterFindMediaNotFound() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter A", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter B", 1, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter C", 1, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter D", 1, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter E", 1, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter F", 1, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter G", 1, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter H", 1, 8.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter I", 1, 9.0, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String storeInventory = "";

                try {
                    storeInventory = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter A, Rating: 1,"
                    + " Rental Price: $1.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter B, Rating: 1,"
                    + " Rental Price: $2.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter C, Rating: 1,"
                    + " Rental Price: $3.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter D, Rating: 1,"
                    + " Rental Price: $4.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter E, Rating: 1,"
                    + " Rental Price: $5.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter F, Rating: 1,"
                    + " Rental Price: $6.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter G, Rating: 1,"
                    + " Rental Price: $7.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter H, Rating: 1,"
                    + " Rental Price: $8.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter I, Rating: 1,"
                    + " Rental Price: $9.00, Runtime: 120\n").equals(storeInventory));

                Movie movNew = new Movie(Genre.FANTASY, "Pirates of the Caribbean", 1, 1.0, 120);

                Media found = store.findMedia(movNew);

                assertEquals(null, found);
            }
        }

        // revised
        @Nested
        class BlockbusterMostPopularMovie {
            // revised
            @Test
            void blockbusterMostPopularMovieOnlyRating() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter", 2, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter", 3, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter", 4, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter", 5, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter", 6, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter", 7, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter", 8, 8.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter", 9, 9.0, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                    + " Rental Price: $1.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 2,"
                    + " Rental Price: $2.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 3,"
                    + " Rental Price: $3.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 4,"
                    + " Rental Price: $4.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 5,"
                    + " Rental Price: $5.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 6,"
                    + " Rental Price: $6.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 7,"
                    + " Rental Price: $7.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 8,"
                    + " Rental Price: $8.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 9,"
                    + " Rental Price: $9.00, Runtime: 120\n").equals(inventoryString));

                Movie popular = store.getMostPopularMovie();

                Movie mov9copy = new Movie(Genre.FANTASY, "Harry Potter", 9, 9.0, 120);

                assertTrue(popular.equals(mov9));
                assertEquals(popular, mov9);
                assertTrue(popular != mov9copy);
            }

            // revised
            @Test
            void blockbusterMostPopularMovieMixed() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter", 2, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter", 3, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter", 4, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter", 5, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter", 6, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter", 7, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter", 8, 8.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter", 9, 9.0, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, false);

                // added in a 'random' order
                store.addMedia(game);
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                    + " Rental Price: $1.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 2,"
                    + " Rental Price: $2.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 3,"
                    + " Rental Price: $3.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 4,"
                    + " Rental Price: $4.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 5,"
                    + " Rental Price: $5.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 6,"
                    + " Rental Price: $6.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 7,"
                    + " Rental Price: $7.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 8,"
                    + " Rental Price: $8.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 9,"
                    + " Rental Price: $9.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does not need console\n").equals(inventoryString));

                Movie popular = store.getMostPopularMovie();

                assertTrue(popular.equals(mov9));
                assertEquals(popular, mov9);
            }

            // revised
            @Test
            void blockbusterMostPopularMovieByName() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }

                inventory.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter", 1, 1.0, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter", 2, 2.0, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter", 3, 3.0, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter", 4, 4.0, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter", 5, 5.0, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter", 6, 6.0, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter", 7, 7.0, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter A", 9, 9.0, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter B", 9, 9.0, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, false);

                // added in a 'random' order
                store.addMedia(game);
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 1,"
                    + " Rental Price: $1.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 2,"
                    + " Rental Price: $2.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 3,"
                    + " Rental Price: $3.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 4,"
                    + " Rental Price: $4.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 5,"
                    + " Rental Price: $5.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 6,"
                    + " Rental Price: $6.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 7,"
                    + " Rental Price: $7.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does not need console\n"
                    + "Genre: FANTASY, Name: Harry Potter A, Rating: 9,"
                    + " Rental Price: $9.00, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter B, Rating: 9,"
                    + " Rental Price: $9.00, Runtime: 120\n").equals(inventoryString));

                Movie popular = store.getMostPopularMovie();

                assertTrue(popular.equals(mov8));
                assertEquals(popular, mov8);
            }
        }
    }

    @Nested
    class OliviaTests {
        // revised
        @Nested
        class addToCartTests {
            // revised
            @Test
            void addToCartValid() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                Movie mov1copy = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);


                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 3.5);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertTrue(Olivia.addToCart(mov1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(0, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }

            // revised
            @Test
            void addToCartInsufficientBudget() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                Movie mov1copy = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 3.499);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals(false, Olivia.addToCart(mov1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(3.499, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }

            // revised
            @Test
            void addToCartNotFound() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assumeTrue(("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                Movie mov10 = new Movie(Genre.FANTASY, "Pirates of the Caribbean", 5, 3.5, 120);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 3.6);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                
                assertEquals(false, Olivia.addToCart(mov10, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(3.6, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }
            
            // revised
            @Test
            void addToCartValidVideoGame() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, false);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);
                store.addMedia(game);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does not need console\n"
                    + "Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                VideoGame game1copy = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, false);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 10.0);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                boolean canUseConsoleValue = false;
                try {
                    canUseConsole.set(o, true);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                
                assertTrue(Olivia.addToCart(game1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does not need console\n", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(0, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }

            // revised
            @Test
            void addToCartValidVideoGameNeedsConsole() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, true);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);
                store.addMedia(game);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                VideoGame game1copy = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, true);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 10.0);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                boolean canUseConsoleValue = false;
                try {
                    canUseConsole.set(o, true);
                    canUseConsoleValue = (boolean) canUseConsole.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertTrue(Olivia.addToCart(game1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does need console\n", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(0, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }

            // revised
            @Test
            void addToCartInvalidVideoGameNeedsConsole() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);
                VideoGame game = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, true);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);
                store.addMedia(game);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                VideoGame game1copy = new VideoGame(Genre.FANTASY, "Harry Potter", 10, 10.0, 2, true);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 10.0);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                boolean canUseConsoleValue = false;
                try {
                    canUseConsole.set(o, false);
                    canUseConsoleValue = (boolean) canUseConsole.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assertEquals(false, Olivia.addToCart(game1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter, Rating: 10,"
                    + " Rental Price: $10.00,"
                    + " Players: 2, does need console\n"
                    + "Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("", cartString);

                try {
                    budgetValue = (Double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(10.0, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }
        }

        @Nested
        class changeMindTests {
            @Test
            void changeMindValid() {
                Blockbuster store = new Blockbuster();

                Field[] fields = Blockbuster.class.getDeclaredFields();
                Field inventory = null;
                for (int i = 0; i < fields.length; i++) {
                    if (fields[i].getName() == "inventory") {
                        inventory = fields[i];
                        break;
                    }
                }
                
                Field[] fieldsO = Olivia.class.getDeclaredFields();
                Field budget = null;
                Field cart = null;
                Field canUseConsole = null;
                for (int i = 0; i < fieldsO.length; i++) {
                    if (fieldsO[i].getName() == "budget") {
                        budget = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "cart") {
                        cart = fieldsO[i];
                        continue;
                    }
                    if (fieldsO[i].getName() == "canUseConsole") {
                        canUseConsole = fieldsO[i];
                        continue;
                    }
                }

                if (inventory == null) {
                    fail("Test was not able to be executed. Cannot access inventory.");
                }
                if (budget == null) {
                    fail("Test was not able to be executed. Cannot access budget.");
                }
                if (cart == null) {
                    fail("Test was not able to be executed. Cannot access cart.");
                }
                if (canUseConsole == null) {
                    fail("Test was not able to be executed. Cannot access canUseConsole.");
                }

                inventory.setAccessible(true);
                budget.setAccessible(true);
                cart.setAccessible(true);
                canUseConsole.setAccessible(true);

                Movie mov1 = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);
                Movie mov2 = new Movie(Genre.FANTASY, "Harry Potter 2", 5, 3.5, 120);
                Movie mov3 = new Movie(Genre.FANTASY, "Harry Potter 3", 5, 3.5, 120);
                Movie mov4 = new Movie(Genre.FANTASY, "Harry Potter 4", 5, 3.5, 120);
                Movie mov5 = new Movie(Genre.FANTASY, "Harry Potter 5", 5, 3.5, 120);
                Movie mov6 = new Movie(Genre.FANTASY, "Harry Potter 6", 5, 3.5, 120);
                Movie mov7 = new Movie(Genre.FANTASY, "Harry Potter 7", 5, 3.5, 120);
                Movie mov8 = new Movie(Genre.FANTASY, "Harry Potter 8", 5, 3.5, 120);
                Movie mov9 = new Movie(Genre.FANTASY, "Harry Potter 9", 5, 3.5, 120);

                // added in a 'random' order
                store.addMedia(mov7);
                store.addMedia(mov2);
                store.addMedia(mov5);
                store.addMedia(mov1);
                store.addMedia(mov8);
                store.addMedia(mov4);
                store.addMedia(mov9);
                store.addMedia(mov6);
                store.addMedia(mov3);

                store.sortMedia();

                String inventoryString = "";
                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));

                Movie mov1copy = new Movie(Genre.FANTASY, "Harry Potter 1", 5, 3.5, 120);

                Olivia o = new Olivia();

                double budgetValue = 0.0;
                try {
                    budget.set(o, 3.5);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }

                assumeTrue(Olivia.addToCart(mov1copy, store));

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assumeTrue(("Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(inventoryString));
                
                String cartString = "";
                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assumeTrue(("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n").equals(cartString));

                try {
                    budgetValue = (double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assumeTrue(0 == budgetValue);

                Olivia.changeMind(mov1copy, store);
                store.sortMedia();

                try {
                    inventoryString = arrayListToString((ArrayList<Media>) inventory.get(store));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("Genre: FANTASY, Name: Harry Potter 1, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 2, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 3, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 4, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 5, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 6, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 7, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 8, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n"
                    + "Genre: FANTASY, Name: Harry Potter 9, Rating: 5,"
                    + " Rental Price: $3.50, Runtime: 120\n", inventoryString);

                try {
                    cartString = arrayListToString((ArrayList<Media>) cart.get(o));
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals("", cartString);

                try {
                    budgetValue = (double) budget.get(o);
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
                assertEquals(3.5, budgetValue);

                try {
                    cart.set(o, new ArrayList<Media>());
                } catch (Exception e) {
                    fail("Test was not able to be executed. " + e.getMessage());
                }
            }
        }
        
    }

    private String arrayListToString(ArrayList<Media> a) {
        String result = "";

        for (int i = 0; i < a.size(); i++) {
            result += a.get(i).toString() + "\n";
        }

        return result;
    }
}