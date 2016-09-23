/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.Bean;

import fit5192.assignment.repository.SaleRepository;
import fit5192.assignment.repository.CarRepository;
import fit5192.assignment.repository.UserRepository;
import fit5192.assignment.repository.entities.Car;
import fit5192.assignment.repository.entities.Customer;
import fit5192.assignment.repository.entities.Sale;
import fit5192.assignment.repository.entities.SalesPerson;
import fit5192.util.MyUtil;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author dy
 */
@ManagedBean(name = "buyCarManagedBean")
@SessionScoped
public class BuyCarManagedBean implements Serializable {

    @ManagedProperty(value = "#{searchCarCusManagedBean}")
    private SearchCarCusManagedBean searchCarCusManagedBean;

    @EJB
    private CarRepository carRepository;
    @EJB
    private UserRepository userRepository;
    @EJB
    private SaleRepository saleRepository;

    private Car car;
    private SalesPerson salesPerson;
    private Sale sale;

    private String uid;
    private String vin;

    public String pay() {
        String svin = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("vin");
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("vin");
        String suid = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("uid");
        Date buy = (Date) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("buy");
        Customer cus = (Customer)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

        Sale s = new Sale();
        s.setCid(cus);
        s.setId(MyUtil.getId());
        s.setSid(userRepository.searchSalePersonByUid(suid));
        s.setVin(carRepository.searchVIN(svin));
        s.setSstate("finish");
        s.setSale_date(buy);
        s.setFinish_date(new Date());
        this.saleRepository.addSale(s);
        return "searchCar_c";
        
        
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @PostConstruct
    public void initVINVINVIN() {
        String s = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("vin");
        if (s == null) {
            System.out.println("this is first!!!!!!!!!");
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("vin", searchCarCusManagedBean.getVin());
        }

    }

    public String initVIN() {
        if (vin == null) {
            String tvin = "";
            if (searchCarCusManagedBean != null) {
                tvin = searchCarCusManagedBean.getVin();
            }
            return tvin;
        }
        return vin;
    }

    public String initDescription() {
        String tvin = "";
        if (vin == null) {
            if (searchCarCusManagedBean != null) {
                tvin = searchCarCusManagedBean.getVin();
            }
        } else {
            tvin = vin;
        }

        return carRepository.searchVIN(tvin).getDescription();
    }

    public String initPrice() {
        String tvin = "";
        if (vin == null) {
            if (searchCarCusManagedBean != null) {
                tvin = searchCarCusManagedBean.getVin();
            }
        } else {
            tvin = vin;
        }

        return Float.toString(carRepository.searchVIN(tvin).getPrice());
    }

    public String initThumbnail() {
        String tvin = "";
        System.out.println("vinvvvvvvvvvvv+" + vin + "dsfs" + (vin == null));
        if (vin == null) {
            if (searchCarCusManagedBean != null) {
                tvin = searchCarCusManagedBean.getVin();
            }
        } else {
            tvin = vin;
        }

        return carRepository.searchVIN(tvin).getThumbnail();
    }

    public Car init() {
        String tvin = "";
        System.out.println("this.car->" + car);
        if (this.car == null && searchCarCusManagedBean != null) {
            tvin = searchCarCusManagedBean.getVin();
        } else {
            tvin = this.car.getVin();
        }
        if (!"".equals(tvin)) {

            this.setCar(carRepository.searchVIN(tvin));
        }
        return car;

    }

    public SalesPerson initSalePerson() {
        String tuid = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("uid");
        return this.userRepository.searchSalePersonByUid(tuid);
    }

    public String chooseSalesPerson() {
        String svin = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("vin");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", uid);
        this.car = carRepository.searchVIN(svin);
        this.salesPerson = userRepository.searchSalePersonByUid(uid);
        System.out.println("saleperson" + salesPerson + "carrrrr" + car);
        return "buyCar_a";
    }

    public void attributeListener(ActionEvent event) {
        this.uid = (String) event.getComponent().getAttributes().get("uid");
        this.vin = (String) event.getComponent().getAttributes().get("vin");
    }

    public List<SalesPerson> buyCar() {

        return userRepository.searchAllSalesPersons();

    }

    public SearchCarCusManagedBean getSearchCarCusManagedBean() {
        return searchCarCusManagedBean;
    }

    public void setSearchCarCusManagedBean(SearchCarCusManagedBean searchCarCusManagedBean) {
        this.searchCarCusManagedBean = searchCarCusManagedBean;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SaleRepository getSaleRepository() {
        return saleRepository;
    }

    public void setSaleRepository(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
