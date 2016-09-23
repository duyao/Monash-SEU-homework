/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Sale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dy
 */
@Stateless
public class SaleRepositoryBean implements SaleRepository {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static final String PERSISTENCE_UNIT = "FIT5192-ejbPU";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSale(Sale sale) {
        this.entityManager.persist(sale);
    }
    
}
