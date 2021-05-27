/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputVerifier iv = new InputVerifier();
        Calculator calc = new Calculator();

        System.out.println("Podaj kwotę do przeliczenia: ");
        double amountOfMoney = iv.readAmount(scanner);
        System.out.println("Podaj docelową walutę: ");
        double result = calc.calculateResult(scanner, amountOfMoney);
        System.out.println("\nOtrzymana kwota: " + result);
    }
}