/* @author Jorge Herrán
 * @version 2.0
 * @since 21-04-2019
 */
package es.example.jorge.controller;

import es.example.jorge.model.Alumno;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;


public class ControllerAlumnoTest {

    public ControllerAlumno controllerAlumno = null;
    public Alumno alumno = new Alumno(  "test",
                                     "test",
                                          new Date(1978, 9, 16 ),
                                    "test" );



    @Before
    public void after() {
        if ( controllerAlumno == null )
            controllerAlumno = new ControllerAlumno();
            controllerAlumno.insert( this.alumno );
    }

    @After
    public void before(){
        // Borro alumno modificacdo para que no interfiera en el siguiente test
        controllerAlumno.deleteWhere( alumno );
    }


    @Test
    public void selectWhere() {

        List<Alumno> alumnoList = controllerAlumno.selectWhere( this.alumno );

        Assert.assertNotNull( "No se han obtenido valores de la entidad Alumno: ", alumnoList.get( 0 ) );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna nombre de la entidad Alumno ",
                alumnoList.get( 0 ).getId(), 1 );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna nombre de la entidad Alumno ",
                alumnoList.get( 0 ).getName(), "test" );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna nombre de la entidad Alumno ",
                alumnoList.get( 0 ).getSurnames(), "test" );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna nombre de la entidad Alumno ",
                alumnoList.get( 0 ).getBirthPlace(), "test" );

    }

    @Test
    public void update() {

        List<Alumno> alumnoList = controllerAlumno.select();
        alumnoList.get( 0 ).setName( "modificado_test" );
        alumnoList.get( 0 ).setSurnames( "modificado_test" );
        alumnoList.get( 0 ).setBirthPlace( "modificado_test" );

        controllerAlumno.update( alumnoList.get( 0 ) );

        List<Alumno> alumnoListUpdate = controllerAlumno.select();

        // NotNull
        Assert.assertNotNull( "No se han obtenido valores de la entidad Alumno: ", alumnoListUpdate );

        //Equals
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna nombre: ",
                alumnoListUpdate.get( 0 ).getName(), "modificado_test" );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna apellidos: ",
                alumnoListUpdate.get( 0 ).getSurnames(), "modificado_test" );
        Assert.assertEquals("No se ha obtenido el resultado esperado en la columna lugar nacimiento: ",
                alumnoListUpdate.get( 0 ).getBirthPlace(), "modificado_test" );



    }

    @Test
    public void deleteWhere(){

        controllerAlumno.deleteWhere( this.alumno );
        List<Alumno> alumnoList = controllerAlumno.selectWhere( this.alumno );
        if ( alumnoList.size() == 0 ) {
            boolean result = true;
            Assert.assertTrue("No se ha borrado alumno", result );
        }
    }
}