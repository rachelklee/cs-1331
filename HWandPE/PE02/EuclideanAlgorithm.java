package PE02;

public class EuclideanAlgorithm {
    public static void main(String args[]){
        int num1 = 934;
        int num2 = 23;
        int steps = 0;
        int dividend = num1;
        int divisor = num2; 
        int gcd;
        int quotient;
        int remainder;

        System.out.printf("Finding the greatest common divisor of %d and %d.%n", num1, num2);

        if(divisor > dividend){
            System.out.println("The inputs would have caused an unnecessary step");
            //System.out.printf("original dividend is %d, divisor %d%n", dividend, divisor);
            int temp = divisor;
            divisor = dividend;
            dividend = temp;
            //.out.printf("swapped dividend is %d, divisor %d%n", dividend, divisor);
        }
        else{
            System.out.println("An extra step was avoided.");
        }

        do {
            steps++;
            quotient = dividend / divisor;
            remainder = dividend % divisor;
            System.out.printf("Steps %d: %d = %d * %d + %d%n", steps, dividend, divisor, quotient, remainder);
            gcd = divisor;
            dividend = divisor;
            divisor = remainder;
        } 
        while(remainder != 0);

        System.out.println("The GCD is " + gcd + ".");

        switch (steps) {
            case 1:
                System.out.println("Only one step was needed!");
                break;
            case 2:
                System.out.println("Two steps were taken!");
                break;
            case 3:
                System.out.println("This process took three steps.");
                break;    
            case 4:
                System.out.println("Wow! Four steps.");
                break;
            default:
                System.out.printf("%d steps is a lot of steps!%n", steps);
                break;
        }

        // result = testCondition ? trueValue : falseValue
        String relativelyPrime = gcd == 1 ? "are" : "are not";
        System.out.printf("%d and %d %s relatively prime.%n", num1, num2, relativelyPrime);
    }
}
