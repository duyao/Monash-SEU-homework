/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CarRepository;
import fit5192.assignment.repository.entities.Car;
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
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

/**
 *
 * @author dy
 */
@Named(value = "searchCarManagedBean")
@SessionScoped
public class SearchCarManagedBean implements Serializable {

    @EJB
    private CarRepository carRepository;
    private String modelName;
    private String modelNo;
    private String make;
    private String type;

    private String vin = "";
    private Car car;

    private Part file;
    private String filename="";

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
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
    public SearchCarManagedBean() {

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

    public String initEditCar() {
        System.out.println("vin->" + vin);
        this.car = carRepository.searchVIN(vin);
//        return "/SalesPerson/editCar.xhtml";
        return "editCar.xhtml";
    }

    public String editCar() {
        System.out.println("car============="+car);
        System.out.println("filename=========="+filename);
        if(!"".equals(filename)){
            car.setThumbnail(filename);
        }

        this.carRepository.edit(car);
//        return "/SalesPerson/searchCar.xhtml";
        return "searchCar.xhtml";
    }

    public String deleteCar() {
        this.carRepository.delete(vin);
        return "searchCar.xhtml";

//        return "/SalesPerson/searchCar.xhtml";
    }

    public String addcar() {
        this.carRepository.add(car);
        return "searchCar.xhtml";

//        return "/SalesPerson/searchCar.xhtml";
    }

    public String initAddcar() {
//                return "/SalesPerson/addCar.xhtml";

        return "addCar.xhtml";
    }

    public void save() {
        System.out.println("save");
        try (InputStream input = file.getInputStream()) {
            String uploads = "C:\\Users\\dy\\Documents\\NetBeansProjects\\FIT5192-web\\web\\resources\\images";
            String time = new Date().toString();
            filename = time + file.getSubmittedFileName();
            Files.copy(input, new File(uploads, filename).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
