package eip.fileintegration.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author ernestoexposito
 */
public class Importer implements ErrorHandler {
    // the DOM structure representingthe imported XML document
    private Document doc;
    // the file system document name
    private String filename;
    // constants for SCHEMA validation
    public static final String 
        JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    public static final String
        W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
    // the list of all the <Product> elements
    private NodeList elements;
    // the current element being imported
    private int nbElement = 0;
    // a flag of the potential detected erros
    private boolean errorDetected =false;

    public Importer(String filename) throws Exception {
        
        // a builder factory pattern
        
        // the factory is configured to check XML namespaces
        
        // the XSD validation is activated
        
        // The attributes for XSD declaration are added
        
        // a document builder is created from the configured factory
        
        // in case of errors during the document parsing, the error handler methods
        // implemented by the importer will be invoked
        
        // the XML document is parsed and if no errors are found
        // the DOM tree will be populated
        
        // the root <Products> element is retrieved
        
        // all the <Product> elements that are part of the root element are retrieved
             
    }

    public Object importObject() {
        
        // if there are elements to be imported and no errors are detected
        
            // a new empty Product is created
            
            //  a <Product> element is retrived at the nbElement position
            
            // the <ProductId> element is retrieved and its value stored into the product object
           
            // the <ProductDescription> element is retrieved and its value stored into the product object
            
            // the <ProductPrice> element is retrieved and its value stored into the product object
            
            // the <ProductAmount> element is retrieved and its value stored into the product object
            
            // if this is the last element, the list is initialized to null
           
       
        // the product object is returned
        return null;
    }
    
     public void close()
    {
        // the imported file is deleted
        
    }
     
     // the error handler interface method are implemented\
    // in our case the identified warning o errors are printed
    // in case of error, the errorDetect flag is activated 
    // to avoid continuing importing the XML document
    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Warning : " + exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Error! XML file will not be used : " + exception);
        errorDetected = true;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Fatal Error! XML file will not be used : " + exception);
         errorDetected = true;
    }
}
