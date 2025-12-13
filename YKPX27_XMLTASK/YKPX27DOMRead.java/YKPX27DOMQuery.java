package ykpx27.domparse.hu;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.File;

public class YKPX27DOMQuery {

    public static void main(String[] args) {

        try {
            File xmlFile = new File("YKPX27XML.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            // Hallgatók lekérdezése
            NodeList hallgatoList = document.getElementsByTagName("hallgato");

            System.out.println("Hallgatók száma: " + hallgatoList.getLength());

            for (int i = 0; i < hallgatoList.getLength(); i++) {

                Node node = hallgatoList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element hallgato = (Element) node;

                    String id = hallgato.getAttribute("id");
                    String vezeteknev = hallgato
                            .getElementsByTagName("vezeteknev")
                            .item(0)
                            .getTextContent();
                    String keresztnev = hallgato
                            .getElementsByTagName("keresztnev")
                            .item(0)
                            .getTextContent();
                    String evfolyam = hallgato
                            .getElementsByTagName("evfolyam")
                            .item(0)
                            .getTextContent();

                    System.out.println("ID: " + id);
                    System.out.println("Név: " + vezeteknev + " " + keresztnev);
                    System.out.println("Évfolyam: " + evfolyam);
                    System.out.println("----------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
