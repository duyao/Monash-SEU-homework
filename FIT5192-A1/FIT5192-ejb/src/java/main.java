
import fit5192.assignment.repository.CustomerRepositoryBean;
import fit5192.assignment.repository.entities.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dy
 */
public class main {

    public static CustomerRepositoryBean customerRepositoryBean = lookupCustomerRepositoryBeanBean();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Customer newCustomer = new Customer();
        newCustomer.setLastname("1");
        newCustomer.setFirstname("1");
        newCustomer.setPassword("1");
        newCustomer.setAddress("1");
        newCustomer.setEmail("1");
        newCustomer.setPhonenumber("1");
        System.out.println("u"+newCustomer.toString());
        customerRepositoryBean.addCustomer(newCustomer);
    }

    private static CustomerRepositoryBean lookupCustomerRepositoryBeanBean() {
        try {
            Context c = new InitialContext();
            return (CustomerRepositoryBean) c.lookup("java:global/FIT5192/FIT5192-ejb/CustomerRepositoryBean!fit5192.assignment.repository.CustomerRepositoryBean");
        } catch (NamingException ne) {
            throw new RuntimeException(ne);
        }
    }

}
