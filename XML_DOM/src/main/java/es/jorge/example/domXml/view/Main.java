/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.view;

import es.jorge.example.domXml.dom.DomXML;
import es.jorge.example.domXml.utils.loadLocalidad.ElementsDay;

public class Main {

    public static void main (String [ ] args) {

        String pathNameDocument = "src/main/java/files/localidad_38023.xml";

        DomXML document = new DomXML( pathNameDocument );

        //1º Obtengo el día deseado (Según el ejercicio miércoloes de la semana).
        ElementsDay wednesday = new ElementsDay( document.elmentGetAtributeSearchAtributeValue( document, "dia", "fecha", "2019-01-02" ) );

        //2º Imprimo ( Muestro por pantalla el día solicitado )
        System.out.println( " Miercoles 02-01-2019 ------------------------------------------------------" );
        printDay( wednesday );

        //3º Obtengo el día deseado (Según el ejercicio ahora el jueves de la semana ).
        ElementsDay thursday = new ElementsDay( document.elmentGetAtributeSearchAtributeValue( document, "dia", "fecha", "2019-01-03" ) );

        //4º Modifico algunos elementos del jueves

          //(4.a) prob_precipitacion (Añado atributo con un valor )
        thursday.probPrecipitacion().setAddProbPrecipitacion( 1, "AnadiendoAtributo", "dandoValorAtributo" );

          //(4.b)viento en su primer elemento añado texto contenodo
        thursday.rachaMax().setRachaMaxTextContent( 0, "Añadiendo contenido" );

          //(4.c)imprimo los cambios realizados tanto en racha máxima (textContent).
        thursday.rachaMax().printRachaMaxs();


        document.save( pathNameDocument );

    }


    /**
     * Imprime por pantalla objeto dia.
     * @param day
     */
    public static void printDay( ElementsDay day){

        day.probPrecipitacion().printProbPrecipitacions();
        day.cotaNieveProv().printCotaNieveProv();
        day.estadoCielo().printEstadoCielo();
        day.viento().printVientoVelocidad();
        day.rachaMax().printRachaMaxs();
        day.temperatura().printTemperaturaMaxima();
        day.temperatura().printTemperaturaMinima();
        day.temperatura().printDates();
        day.sensTermica().printSensTermicaMaxima();
        day.sensTermica().printSensTermicaMinima();
        day.sensTermica().printDates();
        day.humedadRelativa().printHumedadRelativaMaxima();
        day.humedadRelativa().printHumedadRelativaMinima();
        day.humedadRelativa().printDates();
        day.uvMax().printUvMax();

        System.out.println( "------------------------------------------------------------" );
    }

}
