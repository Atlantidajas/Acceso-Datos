/* @author Jorge Herrán
 * @version 2.0
 * @since 01-04-2019
 */


package es.jorge.example.domXml.utils;

import java.io.File;

public class LoadFile {

    private File file;

    public LoadFile( String pathName ){

        this.file = new File( pathName );
    }

    public String getPathName() {
        return this.file.getPath();
    }

    public File getFile() {

        if (this.file.exists()) {
            return this.file;
        } else {

            System.out.println( "No se ha podido cargar fichero con ruta: " + this.getPathName() );

        }
        return this.file;
    }
}
