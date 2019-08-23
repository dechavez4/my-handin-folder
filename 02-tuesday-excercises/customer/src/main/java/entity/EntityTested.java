/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Renz
 */
public class EntityTested {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Customer1 c1 = new Customer1("renz", "de Chavez");

        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();

            //Verify that books are managed and has been given a database id
            System.out.println("customer.1: " + c1.getId());

        } finally {
            em.close();
        }
    }
}
