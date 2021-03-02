package eip.fileintegration.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
/**
 *
 * @author ernestoexposito
 */
public class Exporter {
    
    // the file system document name
    private String filename;
    // the DOM tree structure of the document to be created
    private Document doc;
    // the root of the DOM tree
    private Element rootElement;
    // various constant strings allowing to add XML declarations
    private static final String decl11 = "xmlns:xsi";
    private static final String decl12 = "http://www.w3.org/2001/XMLSchema-instance";
    private static final String decl21 = "xsi:noNamespaceSchemaLocation";
    private static final String decl22 = "http://eexposit.perso.univ-pau.fr/content/xsd/Product.xsd";

    public Exporter(String filename) throws Exception {
        this.filename = filename;
        // builder factory pattern
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        
        // the factory allows to create a document buidler
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        // de document builder allows to create an empty DOM document
        doc = dBuilder.newDocument();
        
        // the Products element will be created and it will be referenced as the root of the DOM tree
        rootElement = doc.createElement("Products");
        
        // the empty document will be added to the empty DOM tree. 
        doc.appendChild(rootElement);
        
        //  Two attributes will be added to the Products element
        //  The xmlns:xsi attribut and its value
        rootElement.setAttribute(decl11, decl12);
        //  The xsi:noNamespaceSchemaLocation attribute and its value
        rootElement.setAttribute(decl21, decl22);
        
    }

    public void exportObject(Object object) {
        Product data = (Product) object;
        // Product element
        Element product = doc.createElement("Product");
        rootElement.appendChild(product);
        // ProductID element
        Element productId = doc.createElement("ProductDescription");
        productId.appendChild(productId)
        // ProductDescription element
        
        // ProductPrice element
        
        // ProductAmount element
        
        
    }
    
    public void close()
    {
         // transformer factory pattern
        
        // the factory allows to create a transformer
        
        
            
            // the transformer is configured to use the UTF-8 encoding type 
            
            // to indent the document
            
            // to produce an xml format
            
            // a DOMsource object is created based on the previously created DOM document
            
            // a Stream result is instanciated as an empty file using the provided filename
            
            // Finally the transformer will transform the DOM to an xml file. 
            
            
       
        
    }

}

