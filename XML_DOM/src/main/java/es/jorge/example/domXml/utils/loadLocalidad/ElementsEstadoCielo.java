/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */


package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsEstadoCielo {

    private ArrayList<Element> estadoCielo = new ArrayList<Element>();

    public ElementsEstadoCielo( Element day ){

        int i = 0;

        while ( i < day.getElementsByTagName( "estado_cielo" ).getLength() ){
            this.estadoCielo.add( (Element) day.getElementsByTagName( "estado_cielo" ).item( i ) );
            i++;
        }
    }

    public void setEstadoCieloTextContent( int index, String textContent ){
        this.estadoCielo.get( index ).setTextContent( textContent );
    }

    public void setAddEstadoCielo( int index, String name, String value ){
        this.estadoCielo.get( index ).setAttribute( name, value );
    }

    public ArrayList<Element> getEstadoCielo() {
        return estadoCielo;
    }

    public void printEstadoCielo() {

        int i = 0;

        while ( i < this.estadoCielo.size() ){

            System.out.print( "Estado cielo descripcion: " + this.estadoCielo.get( i ).getAttribute( "descripcion" ) );
            System.out.print( " Periodo: " + this.estadoCielo.get( i ).getAttribute( "periodo" ) );
            if ( this.estadoCielo.get( i ).getTextContent().length() < 1 ) {
                System.out.println( " No hay datos almacenados." );
            }
            else {
                System.out.println( " Valor: " + this.estadoCielo.get( i ).getTextContent() );
            }
            i++;
        }
    }
}

