import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.io.File;

public class YKPX27DOMModify {

    public static void main(String[] args) {

        try {
            File input = new File("YKPX27.xml");
            File output = new File("YKPX27_modified.xml");

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =
                    factory.newDocumentBuilder();
            Document document = builder.parse(input);

            document.getDocumentElement().normalize();

            // -------------------------------
            // Új hallgató hozzáadása
            // -------------------------------
            Element hallgatok =
                    (Element) document
                            .getElementsByTagName("hallgatok")
                            .item(0);

            Element ujHallgato =
                    document.createElement("hallgato");
            ujHallgato.setTextContent("Teszt Elek");

            hallgatok.appendChild(ujHallgato);

            // -------------------------------
            // Mentés
            // -------------------------------
            TransformerFactory tf =
                    TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            transformer.setOutputProperty(
                    OutputKeys.INDENT, "yes");

            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(output));

            System.out.println("Módosított XML mentve: "
                    + output.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
