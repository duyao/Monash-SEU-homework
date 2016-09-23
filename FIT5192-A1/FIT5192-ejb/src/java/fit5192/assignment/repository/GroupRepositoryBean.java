/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Groups;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dy
 */
@Stateless
public class GroupRepositoryBean implements GroupRepository {

    
    private static final String PERSISTENCE_UNIT = "FIT5192-ejbPU";

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void addGroup(String type, String username) {
        System.out.println("username=====" + username);
        System.out.println("type======" + type);
        Groups group = new Groups(username,type);
        entityManager.persist(group);
    }
    
}
