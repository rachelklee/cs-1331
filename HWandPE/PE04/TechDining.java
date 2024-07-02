package PE04;
import java.util.Random;


public class TechDining {

    public static Food[] createMeal(int mealLength) {
        Random rand = new Random();

        Food[] meal = new Food[mealLength];

        for (int i = 0; i < meal.length; i++) {
            int itemNum = rand.nextInt(5);
            //System.out.println("-----RAND-----: " + itemNum);
            for (Food f : Food.values()) {
                int foodOrd = f.ordinal();
                if (foodOrd == itemNum) {
                    meal[i] = f;
                }
            }
        }

        /**System.out.println("-----CREATED MEAL-----");
        for (Food f : meal) {
            System.out.println(f);
        }**/
        return meal;
    }

    public static Food[][] createOrder(int numOfMeals) {
        //System.out.println("----------CREATING ORDER----------: " + numOfMeals);
        int maxMeal = numOfMeals;
        Food[][] order = new Food[numOfMeals][];
        //System.out.println("Number of meals: " + order.length);
        for (int i = 0; i < maxMeal; i++) {
            //System.out.println("Meal number " + i + " contains " + numOfMeals + " meals.");
            Food[] orderMeal = createMeal(numOfMeals);
            order[i] = orderMeal;
            numOfMeals--;
        }
        /**System.out.println(":::::::::::::::::::::::::::");
        System.out.println("-----ENTIRE ORDER-----");

        for (int i = 0; i < order.length; i++){
            for (int j = 0; j < order[i].length; j++){
                System.out.print(order[i][j] + " ");
            }
            System.out.println("");
        }**/
        return order;
    }

    public static int mealCost(Food[] meal) {
        int totalCost = 0;
        for (int i = 0; i < meal.length; i++) {
            totalCost += i * meal[i].ordinal();
        }
        //System.out.println(":::::::::::::::::::::");
        //System.out.println("--> Cost of Meal: " + totalCost);
        return totalCost;
    }

    public static int orderCost(Food[][] order) {
        int totalCost = 0;
        for (int i = 0; i < order.length; i++) {
            totalCost += mealCost(order[i]);
        }
        //System.out.println(":::::::::::::::::::::");
        //System.out.println("--> Cost of Order: " + totalCost);
        return totalCost;
    }
}
