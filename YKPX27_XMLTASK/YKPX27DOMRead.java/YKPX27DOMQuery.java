import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.File;

public class YKPX27DOMQuery {

    public static void main(String[] args) {

        try {
            File xmlFile = new File("YKPX27.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // -------------------------------
            // Hallgatók lekérdezése
            // -------------------------------
            NodeList hallgatok =
                    document.getElementsByTagName("hallgato");

            System.out.println("Hallgatók száma: "
                    + hallgatok.getLength());

            // -------------------------------
            // Oktatók lekérdezése
            // -------------------------------
            NodeList oktatok =
                    document.getElementsByTagName("oktato");

            System.out.println("\nOktatók:");
            for (int i = 0; i < oktatok.getLength(); i++) {
                Element oktato = (Element) oktatok.item(i);
                System.out.println(" - "
                        + oktato.getTextContent().trim());
            }

            // -------------------------------
            // Kurzusok lekérdezése
            // -------------------------------
            NodeList kurzusok =
                    document.getElementsByTagName("kurzus");

            System.out.println("\nKurzusok száma: "
                    + kurzusok.getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
