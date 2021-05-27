/*
Currency converter
Rozalia Karolczak
 */
package currencycalc;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Parser {
    private double findRate(String desiredCurrency, NodeList nodeList) {
        double rate = 0;
        int size = nodeList.getLength();
        boolean isInList = false;

        for(int i = 2; i < size; i++) {
            Node node = nodeList.item(i);
            Element e = (Element)node;
            String name = e.getAttribute("currency");
            if(name.equals(desiredCurrency)) {
                String rateStr = e.getAttribute("rate");
                rate = Double.parseDouble(rateStr);
                isInList = true;
            }
        }

        if(!isInList) {
            System.out.println("Wpisz jedną z walut do wyboru.");
            return 0;
        }
        return rate;
    }

    public double parseXML(String desiredCurrency) {
        double rate = 0;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            String FILENAME = "currencies_xml.xml";
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Cube");
            rate = findRate(desiredCurrency, nodeList);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return rate;
    }

}