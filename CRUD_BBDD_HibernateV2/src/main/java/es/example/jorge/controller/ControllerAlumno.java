/* @author Jorge Herrán
 * @version 2.0
 * @since 21-04-2019
 */


package es.example.jorge.controller;

import es.example.jorge.utils.HibernateUtil;
import es.example.jorge.model.Alumno;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ControllerAlumno {


    public ControllerAlumno(){}

    public void insert( Alumno alumno ) {

        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            session.save( alumno );
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en la función insertar :" + e.getMessage());
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    public List<Alumno> select() {

        Session session = null;

        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Alumno" );
            List<Alumno> alumnos = query.list();

            return alumnos;
        } catch (Exception e) {
            System.out.println( "Error en la función select: " +e.getMessage() );
        } finally {
            if(session != null) {
              session.close();
            }
        }
        return null;
    }

    public List<Alumno> selectWhere( Alumno alumno ) {

        Session session = null;

        try {
            session = HibernateUtil.getSession();

            Query query = session.createQuery("FROM Alumno WHERE id = :value");
            query.setParameter("value", alumno.getId() );
            List<Alumno> alumnoList = query.list();

            return alumnoList;

        } catch (Exception e) {
            System.out.println("Error en la función selectWhere: " + e.getMessage());

        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    public void deleteWhere( Alumno alumno ) {

        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            session.delete( alumno );

            session.flush();
            transaction.commit();

        } catch (Exception e) {
            System.out.println( "Error en la función deleteWhere" + e.getMessage() );
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void update( Alumno alumno ) {

        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();

            session.update( alumno );

            session.flush();
            transaction.commit();

        } catch (Exception e) {
            System.out.println( "Error en la función update" + e.getMessage() );
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
