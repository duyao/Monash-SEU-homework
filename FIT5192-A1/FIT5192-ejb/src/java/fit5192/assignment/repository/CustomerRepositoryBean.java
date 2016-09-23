/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Car;
import fit5192.assignment.repository.entities.Customer;
import fit5192.util.MyUtil;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dy
 */
@Stateful
public class CustomerRepositoryBean implements CustomerRepository {

    private static final String PERSISTENCE_UNIT = "FIT5192-ejbPU";
    private Pattern pattern1;
    private Matcher matcher1;

    private Pattern pattern2;
    private Matcher matcher2;

    private Pattern pattern3;
    private Matcher matcher3;

    private Pattern pattern4;
    private Matcher matcher4;

    //   private final List<Car> cars;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer searchByID(String id) {
        //System.out.println("shujuku====" + id);
        long convert_id = Long.parseLong(id);
//        Customer customer = null;
//        if(entityManager.find(Customer.class, id)!=null)
//        {
//            customer = entityManager.find(Customer.class, id);
//        }
//        //property.getTags().size();
//        return customer;
        System.out.println("id========" + convert_id);
        Query query = this.entityManager.createQuery("select c from Customer c where c.uid = :uid");
        query.setParameter("uid", convert_id);
        List<Customer> customer = query.getResultList();
        if (customer.size() != 0) {
            return customer.get(0);
        } else {
            return null;
        }

    }

    @Override
    public Customer searchByPhone(String phone) {
        //System.out.println("email====" + email);
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Customer.class);
        Root<Customer> p = query.from(Customer.class);
        query.select(p).where(builder.equal(p.get("phonenumber").as(String.class), phone));
        List<Customer> customer = entityManager.createQuery(query).getResultList();
        //System.out.println("customer====" + customer);
        if (customer.size() != 0) {
            return customer.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        
        customer.setUid(MyUtil.getId());
        System.out.println("addCustomer" + customer.toString());
        entityManager.persist(customer);

//        pattern1 = Pattern.compile("^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
//        matcher1 = pattern1.matcher(customer.getEmail());
//
//
//        pattern2 = Pattern.compile("6\\d{7}$|1[3,5,8]\\d{9}");
//        matcher2 = pattern2.matcher(customer.getPhonenumber());
//
//        pattern3 = Pattern.compile("[^\\d]+$");
//        matcher3 = pattern3.matcher(customer.getFirstname());
//
//        pattern4 = Pattern.compile("[^\\d]+$");
//        matcher4 = pattern4.matcher(customer.getLastname());
//
//        if (matcher1.find() && matcher2.find() && matcher3.find() && matcher4.find()) {
//            System.out.println("addCustomer->suc");
//            entityManager.persist(customer);
//        }
    }

}
