/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import java.util.Scanner;

public class Calculator {
    private double result;

    public Calculator() {
        result = 0;
    }

    private double exchangeCurrency(double amountOfMoney, String currency) {
        Parser parser = new Parser();
        double rate = parser.parseXML(currency);
        result = amountOfMoney * rate;
        double scale = Math.pow(10,2);
        return Math.round(result * scale) / scale;
    }

    public double calculateResult(Scanner scanner, double amountOfMoney) {
        double result = 0;
        while(result == 0) {
            String currency = scanner.next();
            result = exchangeCurrency(amountOfMoney, currency);
        }
        return result;
    }
}
