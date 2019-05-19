package es.jorge.example.domXml.dom;

import es.jorge.example.domXml.utils.LoadFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class DomXML {

    private Document document;

    public DomXML( String pathName ){

        LoadFile file = new LoadFile(  pathName  );

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.document = dBuilder.parse( file.getFile() );
            this.document.normalizeDocument();
        } catch(Exception e) {
            System.out.println( "Error: " + e.getMessage() );
        }
    }

    public Document getDocument() {
        return document;
    }

    /**
     * Devuelve el elemento encontrado tras la busqueda por nombre del elemento, nombre del atributo y su valor.
     * @param elementName nombre del elemento
     * @param attributeName nombre del atributo
     * @param valueAttribute valor del atributo
     * @return elemento encontrado o en caso negativo null.
     */
    public Element elmentGetAtributeSearchAtributeValue( DomXML document, String elementName, String attributeName, String valueAttribute  ) {

        int numberNodes = this.document.getElementsByTagName( elementName ).getLength();
        ArrayList<Element> elements = new ArrayList<Element>();
        int i = 0;

        try {
            while (i < numberNodes) {
                elements.add( (Element) this.document.getElementsByTagName( elementName ).item( i ) );
                if (elements.get( i ).getAttribute( attributeName ).equals( valueAttribute )) {
                    return elements.get( i );
                }
                i++;
            }
        }catch ( Exception e ){
            System.out.println( e.getMessage() );
        }
        return null;
    }

    /**
     * Guarda documento en el directorio introducido.
     * @param pathName
     */
    public void save( String pathName ){

        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource( this.document );
            StreamResult result = new StreamResult( new File( pathName ) );
            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
