/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Customer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dy
 */
@Remote
public interface CustomerRepository {
    
     
    
    public Customer searchByID(String id);
    
    public Customer searchByPhone(String phone);
    
    public void addCustomer(Customer customer);
}
