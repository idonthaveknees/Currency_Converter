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

    private final String FILENAME = "currencies_xml.xml";

    public double parseXML(String desiredCurrency) {
        double rate = 0;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));

            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName("Cube");
            int size = nodeList.getLength();
            for(int i = 2; i < size; i++) {
                Node node = nodeList.item(i);
                Element e = (Element)node;
                String name = e.getAttribute("currency");
                if(name.equals(desiredCurrency)) {
                    String rateStr = e.getAttribute("rate");
                    rate = Double.parseDouble(rateStr);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return rate;
    }

}