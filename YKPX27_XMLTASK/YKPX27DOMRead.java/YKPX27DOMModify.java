package ykpx27.domparse.hu;

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
            File xmlFile = new File("YKPX27XML.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            // Hallgatók listája
            NodeList hallgatoList = document.getElementsByTagName("hallgato");

            for (int i = 0; i < hallgatoList.getLength(); i++) {

                Element hallgato = (Element) hallgatoList.item(i);

                // Konkrét hallgató kiválasztása ID alapján
                if (hallgato.getAttribute("id").equals("H1")) {

                    // Évfolyam módosítása
                    hallgato.getElementsByTagName("evfolyam")
                            .item(0)
                            .setTextContent("4");

                    System.out.println("Hallgató évfolyama módosítva!");
                }
            }

            // XML visszaírás fájlba
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("NeptunkodXML.xml"));

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
