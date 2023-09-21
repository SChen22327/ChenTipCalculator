import java.util.Scanner;
/* (1) https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
    link for rounding to two decimals
   (2) https://stackoverflow.com/questions/30310147/how-to-print-an-string-variable-as-italicized-text
    link for italicizing text
* */
public class TipCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Welcome to the tip calculator!");
        System.out.print("How many people are dining today?");
        int party = scan.nextInt();
        scan.nextLine();

        System.out.println("How much are you tipping our \033[3mfine\033[0m waiters?"); //(1)
        System.out.print("Please tell me the percent, as a decimal: ");
        double percentTip = scan.nextDouble();
        scan.nextLine();



    }
}
