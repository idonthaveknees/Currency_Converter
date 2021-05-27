/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import java.text.DecimalFormat;

public class Calculator {
    private double result;

    public Calculator() {
        result = 0;
    }

    double exchangeCurrency(double amountOfMoney, String currency) {
        Parser parser = new Parser();
        double rate = parser.parseXML(currency);
        result = amountOfMoney * rate;
        double scale = Math.pow(10,2);
        return Math.round(result * scale) / scale;
    }
}
