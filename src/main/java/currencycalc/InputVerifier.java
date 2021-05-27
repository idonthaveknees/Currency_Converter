/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputVerifier {

    public double readAmount(Scanner scanner) {
        double amountOfMoney = 0;
        boolean isCorrect = false;
        while(!isCorrect) {
            try {
                amountOfMoney = scanner.nextDouble();
                if(amountOfMoney >= 0) {
                    isCorrect = true;
                } else {
                    System.out.println("Podaj kwotę powyżej 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawną kwotę (w liczbach).");
                scanner.nextLine();
            }
        }
        return amountOfMoney;
    }
}
