/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */

package es.jorge.example.domXml.utils.loadLocalidad;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class ElementsDay {

    private ElementsProbPrecipitacion probPrecipitacion;
    private ElementsCotaNieveProv cotaNieveProv;
    private ElementsEstadoCielo estadoCielo;
    private ElementsViento viento;
    private ElementsRachaMax rachaMax;
    private ElementsTemperatura temperatura;
    private ElementsSensTermica sensTermica;
    private ElementsHumedadRelativa humedadRelativa;
    private ElementsUvMax uvMax;

    public ElementsDay( Element day ) {

        this.probPrecipitacion = new ElementsProbPrecipitacion( (Element) day );
        this.cotaNieveProv = new ElementsCotaNieveProv( (Element) day );
        this.estadoCielo = new ElementsEstadoCielo( (Element) day );
        this.viento = new ElementsViento( (Element) day.getElementsByTagName( "viento" ).item( 0 ) );
        this.rachaMax = new ElementsRachaMax( (Element) day );
        this.temperatura = new ElementsTemperatura( (Element) day.getElementsByTagName( "temperatura" ).item( 0 ) );
        this.sensTermica = new ElementsSensTermica( (Element) day.getElementsByTagName( "sens_termica" ).item( 0 ) );
        this.humedadRelativa = new ElementsHumedadRelativa( (Element) day.getElementsByTagName( "humedad_relativa" ).item( 0 ) );
        this.uvMax = new ElementsUvMax ( (Element) day );
    }

    public ElementsProbPrecipitacion probPrecipitacion() {
        return probPrecipitacion;
    }

    public ElementsCotaNieveProv cotaNieveProv() {
        return cotaNieveProv;
    }

    public ElementsEstadoCielo estadoCielo() {
        return estadoCielo;
    }

    public ElementsViento viento() {
        return viento;
    }

    public ElementsRachaMax rachaMax() {
        return rachaMax;
    }

    public ElementsTemperatura temperatura() {
        return temperatura;
    }

    public ElementsSensTermica sensTermica() {
        return sensTermica;
    }

    public ElementsHumedadRelativa humedadRelativa() {
        return humedadRelativa;
    }

    public ElementsUvMax uvMax() {
        return uvMax;
    }
}
