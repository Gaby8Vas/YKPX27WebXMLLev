package ykpx27.domparse.hu;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class YKPX27DOMRead {

    public static void main(String[] args) {

        try {
            // XML fájl betöltése
            File xmlFile = new File("YKPX27XML.xml");

            // DOM parser létrehozása
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // XML dokumentum beolvasása
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Gyökérelem kiírása
            System.out.println("Gyökérelem: " + document.getDocumentElement().getNodeName());

            // Összes gyermek elem bejárása
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("Elem: " + node.getNodeName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
