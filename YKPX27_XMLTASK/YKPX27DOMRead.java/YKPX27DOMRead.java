import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.io.File;

public class YKPX27DOMRead {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("YKPX27.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();

            System.out.println("Gyökérelem: "
                    + document.getDocumentElement().getNodeName());

            printNode(document.getDocumentElement(), 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, int level) {

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        System.out.print("<" + node.getNodeName());

        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++) {
                Node attr = attrs.item(i);
                System.out.print(" " + attr.getNodeName() + "=\""
                        + attr.getNodeValue() + "\"");
            }
        }

        System.out.print(">");

        if (node.getChildNodes().getLength() == 1 &&
                node.getTextContent() != null) {
            System.out.print(node.getTextContent().trim());
        }

        System.out.println();

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                printNode(child, level + 1);
            }
        }

        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("</" + node.getNodeName() + ">");
    }
}
