/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.SalesPerson;
import fit5192.assignment.repository.entities.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author dy
 */
@Remote
public interface UserRepository {
    public SalesPerson searchSalePersonByUid(String uid);
    
    public List<SalesPerson> searchAllSalesPersons();
    
    public void addUser(Users user);
    
    public List<Users> SearchByPhone(String phone);

    public List<Users> searchByParamters(String uid, String lname, String fName, String type, String eamil);

    public String searchByNameAPassword(String username, String password);

    public String searchByType(String username, String password);

}
