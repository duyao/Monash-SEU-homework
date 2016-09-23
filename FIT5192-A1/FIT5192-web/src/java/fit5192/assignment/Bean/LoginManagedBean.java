/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CustomerRepository;
import fit5192.assignment.repository.SalesPersonRepository;
import fit5192.assignment.repository.UserRepository;
import fit5192.assignment.repository.entities.Customer;
import fit5192.assignment.repository.entities.SalesPerson;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author dy
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginManagedBean implements Serializable {
    
    @EJB
    private UserRepository userRepository;
    
    @EJB
    private CustomerRepository customerRepository;
    
    @EJB
    private SalesPersonRepository salesPersonRepository;
    
    private Customer customer;
    
    private SalesPerson salesPerson;
    
    private String username;
    
    private String password;
    
    public LoginManagedBean() {
        customer = null;
        salesPerson = null;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }
    
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login() {
        String login_username = this.username;
        String login_password = this.password;
        String type = this.userRepository.searchByNameAPassword(login_username, login_password);
        System.out.println("logn->typpe" + type);
        if (!type.equals("0")) {
            System.out.println("judge======================");
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            try {
//                request.login(login_username, login_password);
//            } catch (ServletException ex) {
//                Logger.getLogger(LoginManagedBean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//             if(request.isUserInRole("SalesPerson")){
//                return "/SalesPerson/SalesPerson";
//             }
//             else if(request.isUserInRole("Customer")){
//                return "/Customer/Customer";
//             }
//             else {
//                return "index";
//             }
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userRepository.SearchByPhone(username).get(0));
            
            if (type.equals("SalesPerson")) {
                
                return "/SalesPerson/SalesPerson";
            } else {
                return "/Customer/Customer";
            }
            
        } else {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage("loginForm:login_username", new FacesMessage(FacesMessage.SEVERITY_WARN, "Input wrong", "Please input right phone number and corresponding password !"));
            return "login?faces-redirect=true";
        }
        
    }
    
}
