package es.example.jorge.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut( new PrintStream( outContent ) );
    }

    @Test
    public void testMainConstructor() {
        try {
            new Main();
        } catch (Exception e) {
            fail( "Problema en el constructor." );
        }
    }


    @After
    public void cleanUpStreams() {
        System.setOut( null );
    }

}