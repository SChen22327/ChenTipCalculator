import java.util.Scanner;
import java.util.ArrayList;

/* (1) https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
    link for rounding to two decimals
   (2) https://stackoverflow.com/questions/30310147/how-to-print-an-string-variable-as-italicized-text
    link for italicizing text
   (3) https://www.w3schools.com/java/java_arraylist.asp
    link for arraylist
 */
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> itemNames = new ArrayList<String>();
        ArrayList<Double> itemCost = new ArrayList<Double>();

        System.out.print("Welcome to the tip calculator!");
        System.out.print("How many people are dining today?");
        int party = scan.nextInt();
        scan.nextLine();

        System.out.println("How much are you tipping our \033[3mfine\033[0m waiters?"); //(1)
        System.out.print("Please tell me the percent, as a decimal: ");
        double percentTip = scan.nextDouble();
        scan.nextLine();

        System.out.print("The cost of the item in dollars and cents(enter -1 to end): ");
        double cost = scan.nextDouble();
        scan.nextLine();

        System.out.print("The name of the item: ");
        String item = scan.nextLine();

        while (cost != -1) {
            itemCost.add(cost);
            itemNames.add(item);
            System.out.print("Enter another item in dollars and cents, enter -1 to end: ");
            cost = scan.nextDouble();
            System.out.print("The name of the next item: ");
            item = scan.nextLine();
        }

    }
}
