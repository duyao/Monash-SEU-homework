/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author dy
 */
@Entity
@DiscriminatorValue("Customer")
public class Customer extends Users{


    public Customer() {
        
    }

    
    
    
}
