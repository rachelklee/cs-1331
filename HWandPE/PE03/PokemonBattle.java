package PE03;
import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    
    double input;

    public static Double round(double input){
        double rounded = Math.round(100.0 * input) / 100.0;
        return rounded;
    }
    public static void main(String args[]){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String name;
        String rival;
        int timesAttack;
        Double damage;
        Double totalDamage = 0.0;
        Double health = round(40 + (rand.nextDouble() * 20));
        //System.out.println("=====health: " + health + "=====");
        //Double health = Math.round(100.0 * (40 + (Math.random() * 20))) / 100.0;
        //System.out.println("====== HEALTH ===== " + health);
        int temp = (int) (health * 100);
        //System.out.println("temp = " + temp);
        health = (double) (temp)/100;
        String atk;
        int turns = 0;
        Double prizeMoney;
        
        System.out.println("Enter your Pokemon's nickname: ");
        name = scan.nextLine();

        System.out.println("Enter your rival Pokemon's nickname: ");
        rival = scan.nextLine();

        scan.close();

        System.out.printf("Your rival has chosen %s to fight, which has %.2f health%n", rival, health);

        do {
            totalDamage = 0.0;
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            atk = attack.name();
            //System.out.println(attack);

            if (attack.name().equals("SCRATCH")){
                timesAttack =  1+ rand.nextInt(3);
                
                for (int i = 1; i <= timesAttack; i++){
                    damage = round(1 + (rand.nextDouble()*5));
                    //damage = Math.round(100.0 * (1 + (rand.nextDouble()*5))) / 100.0;
                    //damage = 1 + (Math.random() * 5);
                    totalDamage += damage;
                    //System.out.println("=====on SCRATCH attack " + i + " , " + damage + " damage was done.=====");
                    //System.out.println("=====SCRATCH total damage is now: " + totalDamage + "=====");
                    //System.out.println("damage" + totalDamage);
                }

                health -= totalDamage;
            }
            else if (attack.name().equals("SURF")){
                totalDamage = round(2 + (rand.nextDouble()*9));
                //totalDamage = Math.round(100.0 * (2 + (rand.nextDouble()*9))) / 100.0;
                health -= totalDamage;
                //System.out.println("damage" + totalDamage);

            }
            else if (attack.name().equals("TACKLE")){
                totalDamage = round(7 + (rand.nextDouble()*2));
                //totalDamage = Math.round(100.0 * (7 + (rand.nextDouble()*2))) / 100.0;
                health -= totalDamage;
                //System.out.println("damage" + totalDamage);

            }

        turns++;
        System.out.printf("%s used %s and he did %.2f damage. Your rival has %.2f health remaining%n", name, atk, totalDamage, health);

        } while(health >= 0);

        System.out.printf("%s fainted after %d turns!%n", rival, turns);
        prizeMoney = round(2400 + (rand.nextDouble()*(-1200)));
        //prizeMoney = Math.round(100.0 * (1201 + (rand.nextDouble()*1200))) / 100.0;
        //System.out.println(prizeMoney);
        System.out.printf("You have earned $%.2f!%n", prizeMoney);

    }
}


