/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;
import java.util.ArrayList;

public class ElementsCotaNieveProv {

    private ArrayList<Element> cotaNieveProv = new ArrayList<Element>();

    public ElementsCotaNieveProv( Element day ){

        int i = 0;

        while ( i < day.getElementsByTagName( "cota_nieve_prov" ).getLength() ){
            this.cotaNieveProv.add( (Element) day.getElementsByTagName( "cota_nieve_prov" ).item( i ) );
            i++;
        }
    }

    public void setCota_nieve_provTextContent( int index, String textContent ){
        this.cotaNieveProv.get( index ).setTextContent( textContent );
    }

    public void setAddCota_nieve_prov( int index, String name, String value ){
        this.cotaNieveProv.get( index ).setAttribute( name, value );
    }

    public ArrayList<Element> getCota_nieve_prov() {
        return cotaNieveProv;
    }

    public void printCotaNieveProv() {

        int i = 0;

        while ( i < this.cotaNieveProv.size() ){

            System.out.print( "Cota nieve provincia: " + this.cotaNieveProv.get( i ).getAttribute( "periodo" ) );
            if ( this.cotaNieveProv.get( i ).getTextContent().length() < 1 ) {
                System.out.println( " No hay datos almacenados en este periodo" );
            }
            else {
                System.out.println( " Valor: " + this.cotaNieveProv.get( i ).getTextContent() );
            }
            i++;
        }
    }
}

