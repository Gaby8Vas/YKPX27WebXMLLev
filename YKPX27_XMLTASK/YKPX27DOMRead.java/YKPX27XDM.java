import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.File;

public class YKPX27XDM {

    public static void main(String[] args) {

        try {
            File xmlFile = new File("YKPX27.xml");

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =
                    factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            XPathFactory xpf =
                    XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();

            // Hallgatók neve
            NodeList hallgatok =
                    (NodeList) xpath.evaluate(
                            "//hallgato",
                            document,
                            XPathConstants.NODESET);

            System.out.println("Hallgatók XPath alapján:");
            for (int i = 0; i < hallgatok.getLength(); i++) {
                System.out.println(" - "
                        + hallgatok.item(i)
                                .getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
