package eip.fileintegration.serializedobjects;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class Creer {
Product p ;
 
    public Creer (Product p ) {
        this.p = p;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElementNS("THilor","Product");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getEmployee(doc, String.valueOf(p.getProductId()),p.getProductDescription(), String.valueOf(p.getProductAmount()), String.valueOf(p.getProductPrice())));

            //append second child

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("emps.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getEmployee(Document doc, String id, String name, String age, String role) {
        Element employee = doc.createElement("Product");

        //set id attribute
        employee.setAttribute("id", id);

        employee.appendChild(getEmployeeElements(doc, employee, "id", id));
        //create name element
        employee.appendChild(getEmployeeElements(doc, employee, "product", name));

        //create age element
        employee.appendChild(getEmployeeElements(doc, employee, "amount", age));

        //create role element
        employee.appendChild(getEmployeeElements(doc, employee, "price", role));

       
        return employee;
    }


    //utility method to create text node
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}
