/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.SalesPerson;
import fit5192.assignment.repository.entities.Users;
import fit5192.util.MyUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dy
 */
@Stateful
public class UserRepositoryBean implements UserRepository {

    private static final String PERSISTENCE_UNIT = "FIT5192-ejbPU";

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public String searchByNameAPassword(String username, String password) {

        String password_md5 = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (null != md) {
            byte[] origBytes = password.getBytes();
            md.update(origBytes);
            byte[] digestRes = md.digest();
            password_md5 = getDigestStr(digestRes);

        }

        Query query = this.entityManager.createQuery("select u from Users u where u.phonenumber = :phonenumber and u.password = :password");
        query.setParameter("phonenumber", username);
        query.setParameter("password", password_md5);
        List<Users> users = query.getResultList();
        if (users.size() != 0) {
            return users.get(0).getType();
        } else {
            return "0";
        }
    }

    @Override
    public String searchByType(String username, String password) {
//        Query query = this.entityManager.createQuery("select u from User u where u.email = :email and u.password = :password");
//        query.setParameter("email", username);
//        query.setParameter("password", password);
//        List<Users> users = query.getResultList();
//        if(users.size() != 0)
//        {
//            //String type = users.get(0).
//        }
        return null;
    }

    @Override
    public List<Users> searchByParamters(String uid, String lName, String fName, String type, String eamil) {
        String sql = "SELECT u FROM Users u WHERE 1 = 1 ";
        if (uid != null && !uid.isEmpty()) {
            sql += "AND u.uid = '" + uid + "'";
        }
        if (lName != null && !lName.isEmpty()) {
            sql += " AND u.lastname = '" + lName + "'";
        }
        if (fName != null && !fName.isEmpty()) {
            sql += " AND u.firstname = '" + fName + "'";
        }
        if (type != null && !type.isEmpty()) {
            sql += " AND u.type = '" + type + "'";
        }
        if (eamil != null && !eamil.isEmpty()) {
            sql += " AND u.email = '" + eamil + "'";
        }

        System.out.println("sql->" + sql);
        Query query = this.entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public List<Users> SearchByPhone(String phone) {
        Query query = this.entityManager.createQuery("SELECT u FROM Users u WHERE u.phonenumber = :phonenumber ");
        query.setParameter("phonenumber", phone);
        List<Users> res = query.getResultList();
        System.out.println("SearchByPhone->" + res);
        return query.getResultList();

    }

    @Override
    public void addUser(Users user) {

        user.setUid(MyUtil.getId());
        System.out.println("add user================" + user);
        this.entityManager.persist(user);
    }

    @Override
    public List<SalesPerson> searchAllSalesPersons() {
        String sql = "SELECT u FROM Users u WHERE u.type = 'SalesPerson' ";
        System.out.println("sql->" + sql);
        Query query = this.entityManager.createQuery(sql);
        return query.getResultList();

    }

    @Override
    public SalesPerson searchSalePersonByUid(String uid) {
        Query query = this.entityManager.createQuery("SELECT u FROM Users u WHERE u.uid = :uid ");
        query.setParameter("uid", uid);
        List<SalesPerson> res = query.getResultList();
        return res.get(0);
    }

}
