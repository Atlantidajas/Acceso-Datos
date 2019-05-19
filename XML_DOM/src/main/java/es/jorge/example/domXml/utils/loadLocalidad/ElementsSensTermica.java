/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */


package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsSensTermica {

    private Element maxima;
    private Element minima;
    private ArrayList<Element> datos = new ArrayList<Element>();

    public ElementsSensTermica( Element sensTermica ) {

        int i = 0;

        this.maxima = (Element) sensTermica.getElementsByTagName( "maxima" ).item( 0 );
        this.minima = (Element) sensTermica.getElementsByTagName( "minima" ).item( 0 );

        while ( i < sensTermica.getElementsByTagName( "dato" ).getLength() ){
            this.datos.add( (Element) sensTermica.getElementsByTagName( "dato" ).item( i ) );
            i++;
        }
    }

    public void setAddMaximaAttribute( String name, String value ) {
        this.maxima.setAttribute( name, value );
    }

    public void setMaximaTextContent( String textContent) {
        this.maxima.setTextContent( textContent );
    }

    public void setAddMinimaAttribute( String name, String value ) {
        this.minima.setAttribute( name, value );
    }

    public void setMinimaTextContent( String textContent ){
        this.minima.setTextContent( textContent );
    }

    public void setAddDatoAttribute( int index, String name, String value ) {
        this.datos.get( index ).setAttribute( name, value );
    }

    public void setDatoTextContent( int index, String textContent ) {
        this.datos.get( index ).setTextContent( textContent );
    }

    // Getter

    public Element getMaxima() {
        return maxima;
    }

    public Element getMinima() {
        return minima;
    }

    public ArrayList<Element> getDatos() {
        return datos;
    }

    public void printSensTermicaMaxima(){
        System.out.println( "La Sensación Termica máxima es: " + this.maxima.getTextContent() );
    }

    public void printSensTermicaMinima(){
        System.out.println( "La sensación térmica minima es: " + this.minima.getTextContent() );
    }

    public void printDates() {
        int i = 0;
        int e = 0;

        while ( i < this.datos.size() ){

            while ( e < this.datos.get( i ).getAttributes().getLength() ) {

                System.out.println( "Sensación térmica " + this.datos.get( i ).getAttributes().item( e ) );

                e++;
            }
            System.out.println( "dato: " + this.datos.get( i ).getTextContent() );
            i++;
        }
    }
}

