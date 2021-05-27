/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj kwotę do przeliczenia: ");
        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        System.out.println("Podaj docelową walutę: ");
        String currency = scanner.nextLine();
        Calculator calc = new Calculator();
        double result = calc.exchangeCurrency(amountOfMoney, currency);

        System.out.println("\nOtrzymana kwota: " + result);

    }
}

/*
pomysły do dodania:
1. testy jednostkowe (?)
 */

/*
błędy, które mogą się pojawić:
1. Podanie nieprawidłowej kwoty przez użytkownika
    - kwota na minusie
    - kwota, w której liczba miejsc po przecinku > 2 (?)
    - znaki inne od cyfr w kwocie
2. Podanie nieprawidłowej waluty przez użytkownika
    - kwota inna od wymienionych w XML-u
 */

/*
co dać do readme:
1. które błędy obsługuje program
2. dlaczego wybrałam taką, a nie inną bibliotekę do parsowania XML-a
3. inne biblioteki, których użyłam (?)
 */