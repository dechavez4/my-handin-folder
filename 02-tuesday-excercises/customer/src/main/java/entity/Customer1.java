/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import static java.util.Calendar.DATE;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Renz
 */
@Entity
public class Customer1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String firstName;
    private String lastName;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;

    public Customer1() {
    }

    public Customer1(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        created = new Date();
        
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Temporal(TemporalType.DATE)
    protected java.util.Date endDate;

    public Date getCreated() {
        return created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
