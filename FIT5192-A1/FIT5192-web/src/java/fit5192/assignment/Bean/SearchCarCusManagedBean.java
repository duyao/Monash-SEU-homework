/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CarRepository;
import fit5192.assignment.repository.UserRepository;
import fit5192.assignment.repository.entities.Car;
import fit5192.assignment.repository.entities.SalesPerson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

/**
 *
 * @author dy
 */
@ManagedBean(name = "searchCarCusManagedBean")
@SessionScoped
public class SearchCarCusManagedBean implements Serializable {

    @EJB
    private CarRepository carRepository;
    @EJB
    private UserRepository userRepository;
    private String modelName;
    private String modelNo;
    private String make;
    private String type;

    private String vin = "";
    private Car car;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Creates a new instance of SearchCarManagedBean
     */
    public SearchCarCusManagedBean() {

    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Car> showAllCars() {
        return carRepository.getAllCars();
    }

    public List<Car> searchPara() {

        String manufature = this.getMake();
        String carName = this.getModelName();
        String carNo = this.getModelNo();
        String carType = this.getType();
        if (carType != null) {
            carType = carType.equals("--Please choose types of car--") ? null : carType;
        }

        return this.carRepository.selectCarsByConditions(manufature, modelName, modelNo, carType);

    }

    public void attributeListener(ActionEvent event) {
        this.vin = (String) event.getComponent().getAttributes().get("vin");
    }

    public String viewCar() {
        System.out.println("vin->" + vin);
        this.car = carRepository.searchVIN(vin);
//        return "/SalesPerson/viewCar.xhtml";
        return "viewCar.xhtml";

    }

 
    public String buyCar(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("buy",new Date());
        
        System.out.println("vin->" + vin);
        return "buyCar";
        
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    
    

}
