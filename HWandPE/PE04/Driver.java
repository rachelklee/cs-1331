package PE04;
public class Driver {
    public static void main(String[] args) {
        TechDining dining = new TechDining();
        Food[] meal1 = dining.createMeal(2);
        int cost = dining.mealCost(meal1);
        System.out.printf("Meal 1 Cost is $%d%n", cost);
        Food[] meal2 = dining.createMeal(3);
        cost = dining.mealCost(meal2);
        System.out.printf("Meal 2 Cost is $%d%n", cost);

        Food[][] order1 = dining.createOrder(2);
        cost = dining.orderCost(order1);
        System.out.printf("Order 1 Cost is $%d%n", cost);

        Food[][] order2 = dining.createOrder(3);
        cost = dining.orderCost(order2);
        System.out.printf("Order 2 Cost is $%d%n", cost);
    }
}
