package fit5192.assignment.repository;

import fit5192.assignment.repository.entities.Car;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.ejb.Remote;

/**
 * @autor dy
 */
@Remote
public interface CarRepository {
    public void add(Car car);
    public void edit(Car car);
    public void delete(String vin);
    
    public List<Car> getAllCars();
    
    public List<Car> selectCarsByConditions(String make,String model,String modelNo,String type);

    public List<Car> searchByType(String type) throws Exception;
    
    public List<Car> searchByModelNo(String id) throws Exception;
    
    public List<Car> searchByModelName(String name) throws Exception;
    
    public List<Car> searchByMake(String make) throws Exception;
    
    public List<Car> searchFourPara(String make, String modelName, String modelNo, String type) throws Exception;
    
    public List<Car> searchMakeAName(String make, String modelName) throws Exception;
    
    public List<Car> searchMakeANo(String make, String no) throws Exception;
    
    public List<Car> searchMakeAType(String make, String type) throws Exception;
    
    public List<Car> searchModelNameANo(String name, String id) throws Exception;
    
    public List<Car> searchModelNameAType(String name, String type) throws Exception;
    
    public List<Car> searchModelNoAType(String id, String type) throws Exception;
    
    public List<Car> searchModelNameAModelNoAType(String name, String id, String type) throws Exception;

    public List<Car> searchMakeAModelNameAModelNo(String make, String name, String id) throws Exception;
    
    public Car searchVIN(String vin); 
    
   // public List<String> searchByModelNameNoPara() throws Exception;

    
    
    public void close();
    
}
