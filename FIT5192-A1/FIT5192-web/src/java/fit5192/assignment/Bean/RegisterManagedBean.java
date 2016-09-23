/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CustomerRepository;
import fit5192.assignment.repository.GroupRepository;
import fit5192.assignment.repository.SalesPersonRepository;
import fit5192.assignment.repository.UserRepository;
import fit5192.assignment.repository.entities.Customer;
import fit5192.assignment.repository.entities.SalesPerson;
import fit5192.assignment.repository.entities.Users;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dy
 */
@Named(value = "registerManagedBean")
@RequestScoped
public class RegisterManagedBean implements Serializable {

    /**
     * Creates a new instance of RegisterManagedBean
     */
    @EJB
    private CustomerRepository customerRepository;

    @EJB
    private SalesPersonRepository salesPersonRepository;
    @EJB
    private UserRepository userRepository;

    @EJB
    private GroupRepository groupRepository;

    private SalesPerson salesPerson;

    private Customer customer;

    private Users myUser;

    private String checkpassword;

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Users getUsers() {
        return myUser;
    }

    public void setUsers(Users users) {
        this.myUser = users;
    }

    public String getCheckpassword() {
        return checkpassword;
    }

    public void setCheckpassword(String checkpassword) {
        this.checkpassword = checkpassword;
    }

    public RegisterManagedBean() {

        this.salesPerson = new SalesPerson();

        this.customer = new Customer();

        this.myUser = new Users();

    }

    private static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);

        }
        return stb.toString();
    }

    public String addOrcheck() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        String cphone = myUser.getPhonenumber().trim();
        if (this.userRepository.SearchByPhone(cphone).size() != 0) {

            System.out.println("uuu=============================" + this.userRepository.SearchByPhone(cphone).size());
            myUser.setPhonenumber("");
            ctx.addMessage("userForm:phonenumber", new FacesMessage(FacesMessage.SEVERITY_WARN, "Repeated phone number", "Repeated phone number. Please write another phone number."));

            return "singup";
        } else {
            String password_md5 = "";
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            if (null != md) {
                byte[] origBytes = myUser.getPassword().getBytes();
                md.update(origBytes);
                byte[] digestRes = md.digest();
                password_md5 = getDigestStr(digestRes);

            }
            myUser.setPassword(password_md5);
            System.out.println("type============"+myUser.getType());
            this.userRepository.addUser(myUser);
            this.groupRepository.addGroup(myUser.getType(), myUser.getPhonenumber());
            return "login?faces-redirect=true";

        }

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
