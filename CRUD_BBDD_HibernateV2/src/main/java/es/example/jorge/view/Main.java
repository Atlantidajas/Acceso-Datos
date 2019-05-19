/* @author Jorge Herrán
 * @version 2.0
 * @since 21-04-2019
 */

package es.example.jorge.view;

import es.example.jorge.controller.ControllerAlumno;
import es.example.jorge.model.Alumno;

import java.util.Date;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        ControllerAlumno controllerAlumno = new ControllerAlumno();

        Alumno alumno_0 = new Alumno( "Jorge",
                                   "Coello Coello", new Date(1978, 9, 16 ),
                                   "Santa Cruz de Tenerife" );

        Alumno alumno_1 = new Alumno( "Suso",
                                   "Brito Brito", new Date(1979, 10, 20 ),
                                   "Las Plamas de Gran Canaria" );


        //<-- Insert and select
        controllerAlumno.insert( alumno_0 );
        controllerAlumno.insert( alumno_1 );

        List<Alumno> alumnoList0 = controllerAlumno.select();

        System.out.println( "Resultados de la insert" );
        printResultListAlumno( alumnoList0 );


        //<-- Update and select where
        alumno_1.setName( "Nombre modificado." );
        alumno_1.setSurnames( "Apellido modificado." );

        controllerAlumno.update( alumno_1 );

        System.out.println( "Resultados de update" );
        List<Alumno> alumnoList1 = controllerAlumno.selectWhere( alumno_1 );
        printResultListAlumno( alumnoList1 );


        //<-- Delete and select
        controllerAlumno.deleteWhere( alumno_1 );

        System.out.println( "Resultados delete" );
        List<Alumno> alumnoList2 = controllerAlumno.select();
        printResultListAlumno( alumnoList2 );

    }

    public static void printResultListAlumno( List<Alumno> alumnoList ){

        for ( int i = 0; i < alumnoList.size(); i++ ){
            System.out.println( "***********************************************" );
            System.out.println( "*  Identificador: " + alumnoList.get( i ).getId() );
            System.out.println( "*  Nombre: " + alumnoList.get( i ).getName() );
            System.out.println( "*  Apellidos: " + alumnoList.get( i ).getSurnames() );
            System.out.println( "*  Anio nacimiento: " + alumnoList.get( i ).getBirthDate() );
            System.out.println( "*  Lugar nacimiento: " + alumnoList.get( i ).getBirthPlace() );
            System.out.println( "***********************************************" );
        }
    }
}
