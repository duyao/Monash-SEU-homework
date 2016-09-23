/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.CarRepository;
import fit5192.assignment.repository.entities.Car;
import fit5192.util.MyUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Date;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author dy
 */
@Named(value = "addCarManagedBean")
@SessionScoped
public class AddCarManagedBean implements Serializable {

    @EJB
    private CarRepository carRepository;

    private Car car;
    private String urlInfo = "";
    private Part file;
    private String fileText;

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }
    private String filename = "";

    private String makeInfo;
    private String makeRecord = "";

    @PostConstruct
    public void init() {
        Car c = (Car) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("car");
        if (c != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("car");
            this.car = c;
        }else{
            car = new Car();
        }

    }
//    public String showUrlInfo() {
//        if (makeInfo != null) {
//            urlInfo = MyUtil.getURLFromGoogle(makeInfo);
//            makeRecord = makeInfo;
//        }
//        return urlInfo;
//    }

    public String showUrlInfo() {
        System.out.println("showUrlInfo->car"+car);
        if (car != null && car.getMake() != null) {
            urlInfo = MyUtil.getURLFromGoogle(car.getMake());
            makeRecord = makeInfo;
        }
        return urlInfo;
    }

    public void addCar() {
         if (null != file) {
            try {
                InputStream is = file.getInputStream();
                fileText = new Scanner(is).useDelimiter("\\A").next();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("add+car");
        System.out.println("urlin->" + urlInfo);
        System.out.println("car->" + car);
        System.out.println("file->" + filename);
        System.out.println("make->" + makeRecord);

    }

    public String nextStep() {
        System.out.println("in next");
        Car c = new Car();
        c.setVin(car.getVin());
        c.setType(car.getType());
        c.setDescription(car.getDescription());
        c.setCstate("available");
        c.setMake(car.getMake());
        c.setModelName(car.getModelName());
        c.setModelNo(car.getModelNo());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("car", c);
        System.out.println("car->" + car);
        return "addCar_a";
    }

    public void save() {
        System.out.println("save");
        if (file != null) {
            try (InputStream input = file.getInputStream()) {
                String uploads = "C:\\Users\\dy\\Documents\\NetBeansProjects\\FIT5192-web\\web\\resources\\images";
                String time = new Date().toString();
                filename = time + file.getSubmittedFileName();
                System.out.println("filename" + filename + "fda->" + file.getName());

                Files.copy(input, new File(uploads, filename).toPath());
                System.out.println("???");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public AddCarManagedBean() {
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getMakeInfo() {
        return makeInfo;
    }

    public void setMakeInfo(String makeInfo) {
        this.makeInfo = makeInfo;
    }

}
