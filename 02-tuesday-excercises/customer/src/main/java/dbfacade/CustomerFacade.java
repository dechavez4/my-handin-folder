/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer1;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Renz
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer1 c1 = facade.addCustomer("renz", "de Chavez");

        System.out.println("customer.1: " + facade.findCustomerByID(c1.getId()));

    }

    public CustomerFacade() {
    }
    
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    

    public Customer1 findCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer1 customer = em.find(Customer1.class, id);
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer1> findCustomerByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer1 customer = em.find(Customer1.class, name);
            return (List<Customer1>) customer;
        } finally {
            em.close();
        }
    }

    public List<Customer1> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer1> query = em.createQuery("Select customer from Customer customer", Customer1.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer1 addCustomer(String fName, String lName) {
        Customer1 customer = new Customer1(fName, lName);
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

}
