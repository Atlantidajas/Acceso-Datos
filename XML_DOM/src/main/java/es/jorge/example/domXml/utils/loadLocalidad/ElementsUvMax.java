/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsUvMax {

    private ArrayList<Element> uvMax = new ArrayList<Element>();

    public ElementsUvMax( Element day ){

        int i = 0;

        while ( i < day.getElementsByTagName( "uv_max" ).getLength() ){
            this.uvMax.add( (Element) day.getElementsByTagName( "uv_max" ).item( i ) );
            i++;
        }
    }

    public void setUvMaxTextContent( int index, String textContent ){
        this.uvMax.get( index ).setTextContent( textContent );
    }

    public void setAddsetUvMaxAttribute( int index, String name, String value ){
        this.uvMax.get( index ).setAttribute( name, value );
    }

    public ArrayList<Element> getsetUvMax() {
        return uvMax;
    }

    public void printUvMax() {

        int i = 0;

        while ( i < this.uvMax.size() ){

            System.out.print( "Rayos UV Máximos: " + this.uvMax.get( i ).getAttribute( "periodo" ) );
            if ( this.uvMax.get( i ).getTextContent().length() < 1 ) {
                System.out.println( " No hay datos almacenados en este periodo" );
            }
            else {
                System.out.println( " Valor: " + this.uvMax.get( i ).getTextContent() );
            }
            i++;
        }
    }
}