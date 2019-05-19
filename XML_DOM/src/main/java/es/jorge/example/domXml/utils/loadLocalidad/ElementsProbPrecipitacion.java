/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsProbPrecipitacion {

    private ArrayList<Element> probPrecipitacion = new ArrayList<Element>();

    public ElementsProbPrecipitacion( Element day ){

        int i = 0;

        while ( i < day.getElementsByTagName( "prob_precipitacion" ).getLength() ){
            this.probPrecipitacion.add( (Element) day.getElementsByTagName( "prob_precipitacion" ).item( i ) );
            i++;
        }
    }

    public void setProbPrecipitacionTextContent( int index, String textContent ){
        this.probPrecipitacion.get( index ).setTextContent( textContent );
    }

    public void setAddProbPrecipitacion( int index, String name, String value ){
        this.probPrecipitacion.get( index ).setAttribute( name, value );
    }

    public ArrayList<Element> getProbPrecipitacion() {
        return probPrecipitacion;
    }

    public void printProbPrecipitacions() {

        int i = 0;

        while ( i < this.probPrecipitacion.size() ){

            System.out.print( "Prob Precipitaciones: " + this.probPrecipitacion.get( i ).getAttribute( "periodo" ) );
            if ( this.probPrecipitacion.get( i ).getTextContent().length() < 1 ) {
                System.out.println( " No hay datos almacenados en este periodo" );
            }
            else {
                System.out.println( " Valor: " + this.probPrecipitacion.get( i ).getTextContent() );
            }
            i++;
        }
    }
}
