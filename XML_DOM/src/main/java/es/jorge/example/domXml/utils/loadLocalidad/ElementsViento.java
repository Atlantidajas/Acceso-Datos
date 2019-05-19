/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsViento {

    private Element direccion;
    private Element velocidad;
    private ArrayList<Element> datos = new ArrayList<Element>();

    public ElementsViento( Element viento ) {

        int i = 0;

        this.direccion = (Element) viento.getElementsByTagName( "direccion" ).item( 0 );
        this.velocidad = (Element) viento.getElementsByTagName( "velocidad" ).item( 0 );

        while ( i < viento.getElementsByTagName( "dato" ).getLength() ){
            this.datos.add( (Element) viento.getElementsByTagName( "dato" ).item( i ) );
            i++;
        }
    }


    public void setAddDireccionAttribute( String name, String value ) {
        this.direccion.setAttribute( name, value );
    }

    public void setDireccionTextContent( String textContent) {
        this.direccion.setTextContent( textContent );
    }

    public void setAddVelocidadAttribute( String name, String value ) {
        this.velocidad.setAttribute( name, value );
    }

    public void setVelocidadTextContent( String textContent ){
        this.velocidad.setTextContent( textContent );
    }

    public void setAddDatoAttribute( int index, String name, String value ) {
        this.datos.get( index ).setAttribute( name, value );
    }

    public void setDatoTextContent( int index, String textContent ) {
        this.datos.get( index ).setTextContent( textContent );
    }

    // Getter

    public Element getDireccion() {
        return direccion;
    }

    public Element getVelocidad() {
        return velocidad;
    }

    public ArrayList<Element> getDatos() {
        return datos;
    }

    public void printVientoDireccion(){
        System.out.println( "El viento dirección es: " + this.direccion.getTextContent() );
    }

    public void printVientoVelocidad(){
        System.out.println( "El viento su velocidad es: " + this.velocidad.getTextContent() );
    }

    public void printDates() {
        int i = 0;
        int e = 0;

        while ( i < this.datos.size() ){

            while ( e < this.datos.get( i ).getAttributes().getLength() ) {

                System.out.println( "Viento " + this.datos.get( i ).getAttributes().item( e ) );

                e++;
            }
            System.out.println( "dato: " + this.datos.get( i ).getTextContent() );
            i++;
        }
    }
}
