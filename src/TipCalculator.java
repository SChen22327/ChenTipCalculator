import java.util.Scanner;
import java.util.ArrayList;
// links
/* (1) https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
    link for rounding to two decimals
   (2) https://stackoverflow.com/questions/30310147/how-to-print-an-string-variable-as-italicized-text
    link for italicizing text
   (3) https://www.w3schools.com/java/java_arraylist.asp
    link for arraylist
   (4) https://www.javatpoint.com/java-break
     link for breaking loop
   (5) https://stackoverflow.com/questions/44830259/can-you-have-two-conditions-in-an-if-statement
     link for multiple conditions
 */
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //creates a list for the item names and their costs
        ArrayList<String> itemNames = new ArrayList<String>(); //(3)
        ArrayList<Double> itemCost = new ArrayList<Double>();
        double totalCost = 0;
        //asking stuff
        System.out.println("Welcome to the tip calculator!");
        System.out.print("How many people are dining today? ");
        int party = scan.nextInt();
        scan.nextLine();

        System.out.println("How much are you tipping our \033[3mfine\033[0m waiters?"); //(2)
        System.out.print("Please tell me the percent: ");
        double percentTip = scan.nextDouble();
        scan.nextLine();
        //adding the first item so cost equals something for the while loop
        System.out.print("\nThe cost of the item in dollars and cents(enter -1 to end): ");
        double cost = scan.nextDouble();
        scan.nextLine();

        System.out.print("The name of the item: ");
        String item = scan.nextLine();

        itemCost.add(cost);
        itemNames.add(item);
        totalCost += cost;
        //the while loop asks FIRST what price they're putting in.
        //Putting in -1 will break out of the loop immediately
        //putting in anything else will let the code continue to ask the item name and adds them to the lists and totalCost
        while (cost != -1) {
            System.out.println();
            System.out.print("Enter another item in dollars and cents, enter -1 to end: ");
            cost = scan.nextDouble();
            scan.nextLine();

            if (cost == -1) {
                break; //(4)
            }

            System.out.print("The name of the next item: ");
            item = scan.nextLine();

            itemCost.add(cost);
            itemNames.add(item);
            totalCost += cost;
        }
        //sometimes it prints out a very long decimal, so I added this to make it a normal price.
        System.out.println();
        totalCost = Math.round(totalCost * 100) / 100.0;
        System.out.println("Your total bill before tips is: $" + String.format("%.2f",totalCost));
        if (totalCost / party >= 20) { //(5)
            //if the price per person before tips is $20 or more, prints a little comment
            System.out.println("Wow that's gonna be quite costly for your party of " + party + ".");
        }
        //prints the tip that was entered as a decimal as a percent and prints a comment if the tip is good
        //also prints out the percent as a whole number if it ends with .0, otherwise prints the whole decimal
        if (percentTip / (int) percentTip > 1) {
            System.out.println("You chose to tip " + percentTip + "%");
        } else {
            System.out.println("You chose to tip " + (int) percentTip + "%");
        }
        if (percentTip <= 15 && percentTip >= 10) {
            System.out.println("That's a decent tip!");
        } else if (percentTip > 15) {
            System.out.println("Wow, that's an amazing tip.");
        }
        //multiplies percentTip to totalCost so the percentTip is now the total amount of tip
        percentTip = (percentTip / 100.0 ) * totalCost;
        percentTip = Math.round(percentTip * 100) / 100.0;
        System.out.println("You're tipping a total of $" + String.format("%.2f", percentTip) + ".");
        System.out.println("The total including tips is $" + String.format("%.2f", (totalCost + percentTip)) + ".");
        //finds the cost per person before and after tips
        totalCost = Math.round(totalCost * 100 / party) / 100.0;
        System.out.println("Before tips, each person is going to pay $" + String.format("%.2f",totalCost));
        percentTip = Math.round(percentTip * 100 / party) / 100.0;
        System.out.println("Each person is going to tip $" + String.format("%.2f", percentTip));
        System.out.println("Each person will pay $" + String.format("%.2f", (totalCost + percentTip)) + " in total");

        //Extra Credit
        //prints the items ordered along with its price
        System.out.println("\nItems ordered: ");
        int a = 0;
        for (String i : itemNames) {
            System.out.println(i + " cost $" + String.format("%.2f", itemCost.get(a)));
            a++;
        }

    }
}
