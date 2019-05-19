/* @author Jorge Herrán
 * @version 2.0
 * @since 21-04-2019
 */

package es.example.jorge.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumno")

public class Alumno {

    @Id
    @Basic( optional = false )
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column( name = "id" )
    private int id;

    @Basic( optional = false )
    @Column( name = "name", length = 35 )
    private String name;

    @Basic( optional = false )
    @Column( name = "surnames", length = 45 )
    private String surnames;

    @Basic( optional = false )
    @Column( name = "birthDate" )
    private Date birthDate;

    @Column( name = "birthPlace", length = 45)
    private String birthPlace;

    public Alumno() {
    }

    public Alumno( String name,
                   String surnames,
                   Date birthDate,
                   String birthPlace ) {
                                    this.name = name;
                                    this.surnames = surnames;
                                    this.birthDate = birthDate;
                                    this.birthPlace = birthPlace;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setSurnames( String surnames ) {
        this.surnames = surnames;
    }

    public void setBirthDate( Date birthDate ) {
        this.birthDate = birthDate;
    }

    public void setBirthPlace( String birthPlace ) {
        this.birthPlace = birthPlace;
    }

    //<-- Get

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
