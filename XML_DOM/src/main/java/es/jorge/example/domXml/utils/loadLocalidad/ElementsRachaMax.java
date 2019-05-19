/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsRachaMax {

    private ArrayList<Element> rachaMax = new ArrayList<Element>();

    public ElementsRachaMax( Element day ){

        int i = 0;

        while ( i < day.getElementsByTagName( "racha_max" ).getLength() ){
            this.rachaMax.add( (Element) day.getElementsByTagName( "racha_max" ).item( i ) );
            i++;
        }
    }

    public void setRachaMaxTextContent( int index, String textContent ){
        this.rachaMax.get( index ).setTextContent( textContent );
    }

    public void setAddRachaMaxAttribute( int index, String name, String value ){
        this.rachaMax.get( index ).setAttribute( name, value );
    }

    public ArrayList<Element> getRachaMax() {
        return rachaMax;
    }

    public void printRachaMaxs() {

        int i = 0;

        while ( i < this.rachaMax.size() ){

            System.out.print( "Racha maxima: " + this.rachaMax.get( i ).getAttribute( "periodo" ) );
            if ( this.rachaMax.get( i ).getTextContent().length() < 1 ) {
                System.out.println( " No hay datos almacenados en este periodo" );
            }
            else {
                System.out.println( " Valor: " + this.rachaMax.get( i ).getTextContent() );
            }
            i++;
        }
    }
}
