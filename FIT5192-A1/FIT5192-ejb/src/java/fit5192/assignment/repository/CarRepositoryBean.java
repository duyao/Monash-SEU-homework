/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Car;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dy
 */
@Stateless
public class CarRepositoryBean implements CarRepository {
//Car tmp = new Car("Jeep365", "1FA-CP45E-X-LF192944", "Jeep", "Jeep", "Truck", "thumbnail", "des", "previewurl", 1);

    private static final String PERSISTENCE_UNIT = "FIT5192-ejbPU";

    @PersistenceContext
    private EntityManager entityManager;

    public CarRepositoryBean() {
    }

//    public List<String> searchByModelNameNoPara() throws Exception{
//        Query query = this.entityManager.createQuery("select c.ModelName from Car c");
//        List<String> modelName = query.getResultList();
//        for(String modelname : modelName)
//        {
//            System.out.println("No:" + modelName);
//        }
//        return modelName;
//    }
    @Override
    public List<Car> searchByType(String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.type = :type and c.cstate = 'available'");
        query.setParameter("type", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchByModelNo(String id) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelNo = :id and c.cstate = 'available'");
        query.setParameter("id", id);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {

            return cars;
        } else {
            return null;
        }

    }

    @Override
    public List<Car> searchByModelName(String name) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelName = :name and c.cstate = 'available'");
        query.setParameter("name", name);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchByMake(String make) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.cstate = 'available'");
        query.setParameter("make", make);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchFourPara(String make, String modelName, String modelNo, String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.ModelName = :mname and c.ModelNo =:mid and c.type = :mtype and c.cstate = 'available'");
        query.setParameter("make", make);
        query.setParameter("mname", modelName);
        query.setParameter("mid", modelNo);
        query.setParameter("mtype", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public void close() {
//        if (this.entityManager.isOpen()) {
//            this.entityManager.close();
//        }
    }

    @Override
    public List<Car> searchMakeAName(String make, String modelName) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.ModelName = :modelName and c.cstate = 'available'");
        query.setParameter("make", make);
        query.setParameter("modelName", modelName);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchMakeANo(String make, String no) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.ModelNo = :modelNo and c.cstate = 'available'");
        query.setParameter("make", make);
        query.setParameter("modelNo", no);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchMakeAType(String make, String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.type = :type and c.cstate = 'available'");
        query.setParameter("make", make);
        query.setParameter("type", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchModelNameANo(String name, String id) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelName = :name and c.ModelNo = :id and c.cstate = 'available'");
        query.setParameter("name", name);
        query.setParameter("id", id);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchModelNameAType(String name, String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelName = :name and c.type = :type and c.cstate = 'available'");
        query.setParameter("name", name);
        query.setParameter("type", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchModelNoAType(String id, String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelNo = :modelNo and c.type = :type and c.cstate = 'available'");
        query.setParameter("modelNo", id);
        query.setParameter("type", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchModelNameAModelNoAType(String name, String id, String type) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.ModelName = :modelName and c.ModelNo = :modelNo and c.type = :type and c.cstate = 'available'");
        query.setParameter("modelName", name);
        query.setParameter("modelNo", id);
        query.setParameter("type", type);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public List<Car> searchMakeAModelNameAModelNo(String make, String name, String id) throws Exception {
        Query query = this.entityManager.createQuery("select c from Car c where c.make = :make and c.ModelName = :modelName and c.ModelNo = :modelNo and c.cstate = 'available'");
        query.setParameter("make", make);
        query.setParameter("modelName", name);
        query.setParameter("modelNo", id);
        List<Car> cars = query.getResultList();
        if (cars.size() != 0) {
            return cars;
        } else {
            return null;
        }
    }

    @Override
    public Car searchVIN(String vin) {
        Query query = this.entityManager.createQuery("select c from Car c where c.vin = :vin and c.cstate = 'available'");
        query.setParameter("vin", vin);
        List<Car> cars = query.getResultList();
        Car car = cars.get(0);
        System.out.println("car No" + car.getModelNo());
        return car;
    }

    @Override
    public List<Car> selectCarsByConditions(String make, String model, String modelNo, String type) {
        String sql = "SELECT c FROM Car c WHERE c.cstate = 'available'";
        if (make != null && !make.isEmpty()) {
            sql += "AND c.make = '" + make + "'";
        }
        if (model != null && !model.isEmpty()) {
            sql += " AND c.ModelName = '" + model + "'";
        }
        if (modelNo != null && !modelNo.isEmpty()) {
            sql += " AND c.ModelNo = '" + modelNo + "'";
        }
        if (type != null && !type.isEmpty()) {
            sql += " AND c.type = '" + type + "'";
        }
        System.out.println("sql->" + sql);
        Query query = this.entityManager.createQuery(sql);
        return query.getResultList();

    }

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT c FROM Car c";
        Query query = this.entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public void delete(String vin) {
        Car car = this.searchVIN(vin);
        this.entityManager.remove(car);
        
    }

    @Override
    public void edit(Car car) {
        this.entityManager.merge(car);
    }

    @Override
    public void add(Car car) {
        this.entityManager.persist(car);
    }

}
