/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CustomerRepository;
import fit5192.assignment.repository.UserRepository;
import fit5192.assignment.repository.entities.Customer;
import fit5192.assignment.repository.entities.Users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dy
 */
@Named(value = "searchCustomerManagedBean")
@SessionScoped
public class SearchCustomerManagedBean implements Serializable{

    /**
     * Creates a new instance of SearchCustomerManagedBean
     */
    @EJB
    private UserRepository userRepository;
    private CustomerRepository customerRepository;
    private Customer customer;
    private String uid;
    private String lastName;
    private String firstName;
    private String email;
    private String type;

    public SearchCustomerManagedBean() {
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> searchPara() {

        String puid = this.getUid();
        String lname = this.getLastName();
        String fname = this.getFirstName();
        String pType = this.getType();
        String mail = this.getEmail();
        if (pType != null) {
            pType = pType.equals("--Please choose types of person--") ? null : pType;
        }

        return this.userRepository.searchByParamters(puid, lname, fname, pType, mail);

    }

}
