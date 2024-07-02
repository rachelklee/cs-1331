public class Speedometer {
    
    //Name: Rachel Lee
    //Fun fact: I am left handed
    
    public static void main(String args[]){
        int kilometers = 50;
        double kmPerMile = 1.60934;
        double hours = 0.54;
        String name = "Rachel";
        double miles;
        double milesTrunc;
        double rawSpeed;
        double speed;

        miles = kilometers / kmPerMile;
        milesTrunc = ((double) (int) (miles * 1000)) / 1000;

        //System.out.println("miles " + miles);
        //System.out.println("trunc " + milesTrunc);

        speed = ((double) (int) ((milesTrunc / hours) * 100)) / 100;

        //System.out.println("speed " + speed);

        System.out.println(name + " drove at a speed of " + speed + " mph for " + milesTrunc + " miles!");

    }
}
