/* @author Jorge Herrán
 * @version 2.0
 * @since 21-04-2019
 */


package es.example.jorge.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AlumnoTest {

    public Alumno alumnoTest;

    public static  final int TEST_ID = 0;
    public static final String TEST_NAME = "testName";
    public static final String TEST_SURNAMES = "testSurnames";
    public static final Date TEST_BIRTH_DATE = new Date( 1978, 9, 16 );
    public static final String TEST_BIRTH_PLACE = "testPlace";

    @Before
    public void before() {

        try {
            this.alumnoTest = new Alumno( TEST_NAME,
                                          TEST_SURNAMES,
                                          TEST_BIRTH_DATE,
                                          TEST_BIRTH_PLACE );
        } catch (Exception e) {
            fail( "Problema en el constructor Alumno." );
        }
    }

    @Test
    public void create() {

        try{
            Assert.assertNotNull( "No se han obtenido ningún resultado de tipo Alumno ", alumnoTest );
            Assert.assertEquals( "El objeto retornado tipo Alumno es diferente al esperado", alumnoTest, alumnoTest );
            Assert.assertTrue( "", alumnoTest.getClass().equals( Alumno.class ) );
        }catch ( AssertionError error ){
            fail( "Error: " + error.getMessage() );
        }
    }

    @Test
    public void getId() {
        try {
            Assert.assertEquals( "No se ha obtenido el resultado esperado en la columna (Id) de la entidad Alumno ",
                    alumnoTest.getId(), TEST_ID );

            Assert.assertNotNull( "Este campo es requerido y no puede ser nulo. Columna ( Id ) de la entidad Alumno ",
                    alumnoTest.getId() );
        }catch ( AssertionError error ){
            fail( "Error al retornar id: " + error.getMessage() );
        }

    }

    @Test
    public void getName() {
        try {
            Assert.assertEquals( "No se ha obtenido el resultado esperado en la columna (name) de la entidad Alumno ",
                    alumnoTest.getName(), TEST_NAME );

            Assert.assertTrue( "El tipo de datos no es concordante", alumnoTest.getName().getClass().equals( String.class ) );

            Assert.assertNotNull( "Este campo es requerido y no puede ser nulo. Columna ( Id ) de la entidad Alumno ",
                    alumnoTest.getName() );
        }catch ( AssertionError error ){
            fail( "Error al retornar name: " + error.getMessage() );
        }
    }

    @Test
    public void getSurname() {
        try {
            Assert.assertEquals( "No se ha obtenido el resultado esperado en la columna (surname) de la entidad Alumno ",
                    alumnoTest.getSurnames(), TEST_SURNAMES );

            Assert.assertTrue( "El tipo de datos no es concordante", alumnoTest.getSurnames().getClass().equals( String.class ) );

            Assert.assertNotNull( "Este campo es requerido y no puede ser nulo. Columna ( surname ) de la entidad Alumno ",
                    alumnoTest.getSurnames() );
        }catch ( AssertionError error ){
            fail( "Error al retornar surnames: " + error.getMessage() );
        }
    }

    @Test
    public void getBirthDate() {
        try {
            Assert.assertEquals( "No se ha obtenido el resultado esperado en la columna (birthDate) de la entidad Alumno ",
                    alumnoTest.getBirthDate(), TEST_BIRTH_DATE );

            Assert.assertTrue( "El tipo de datos no es concordante", alumnoTest.getBirthDate().getClass().equals( Date.class ) );

            Assert.assertNotNull( "Este campo es requerido y no puede ser nulo. Columna ( birthDate ) de la entidad Alumno ",
                    alumnoTest.getBirthDate() );
        }catch ( AssertionError error ){
            fail( "Error al retornar birthDate: " + error.getMessage() );
        }
    }

    @Test
    public void getBirthPlace() {
        try {
            Assert.assertEquals( "No se ha obtenido el resultado esperado en la columna (birthPlace) de la entidad Alumno ",
                    alumnoTest.getBirthPlace(), TEST_BIRTH_PLACE );

            Assert.assertTrue( "El tipo de datos no es concordante", alumnoTest.getBirthPlace().getClass().equals( String.class ) );

            Assert.assertNotNull( "Este campo es requerido y no puede ser nulo. Columna ( birthPlace ) de la entidad Alumno ",
                    alumnoTest.getBirthPlace() );
        }catch ( AssertionError error ){
            fail( "Error al retornar brithPlace: " + error.getMessage() );
        }
    }
}