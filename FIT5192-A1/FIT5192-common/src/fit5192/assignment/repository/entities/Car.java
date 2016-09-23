/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dy
 */
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "vin")
    private String vin;  
        
    @Basic(optional = false)
    @NotNull
    private String ModelName;  
            
    @Basic(optional = false)
    @NotNull
    private String ModelNo;
    
    @Basic(optional = false)
    @NotNull
    private String make;
    
    @Basic(optional = false)
    @NotNull
    private String type;
    
    @Basic(optional = false)
    @NotNull
    private String description;
    
    @Basic(optional = false)
    @NotNull
    private String color;
    
    @Basic(optional = false)
    @NotNull
    private float price;
        
    @Basic(optional = false)
    @NotNull
    private String thumbnail;  
     
    @Basic(optional = false)
    @NotNull
    @Column(name = "preview_url")
    private String preview_url;   
    
    @Basic(optional = false)
    @NotNull
    private String cstate; 
    
//    @OneToMany(mappedBy = "vin")
//    private Collection<Sale> saleCollection;

    public Car() {
    }

    public Car(String vin, String ModelName, String ModelNo, String make, String type, String description, String color, float price, String thumbnail, String preview_url, String cstate) {
        this.vin = vin;
        this.ModelName = ModelName;
        this.ModelNo = ModelNo;
        this.make = make;
        this.type = type;
        this.description = description;
        this.color = color;
        this.price = price;
        this.thumbnail = thumbnail;
        this.preview_url = preview_url;
        this.cstate = cstate;
    }

//    public Car(Long vin, String ModelName, String ModelNo, String make, String type, String description, String color, float price, String thumbnail, String preview_url, String cstate, Collection<Sale> saleCollection) {
//        this.vin = vin;
//        this.ModelName = ModelName;
//        this.ModelNo = ModelNo;
//        this.make = make;
//        this.type = type;
//        this.description = description;
//        this.color = color;
//        this.price = price;
//        this.thumbnail = thumbnail;
//        this.preview_url = preview_url;
//        this.cstate = cstate;
//        this.saleCollection = saleCollection;
//    }
    
    

    public Car(String ModelName, String ModelNo, String make, String type) {
        this.ModelName = ModelName;
        this.ModelNo = ModelNo;
        this.make = make;
        this.type = type;
    }

    
    
    public Car(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getModelNo() {
        return ModelNo;
    }

    public void setModelNo(String ModelNo) {
        this.ModelNo = ModelNo;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vin != null ? vin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.vin == null && other.vin != null) || (this.vin != null && !this.vin.equals(other.vin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "vin=" + vin + ", ModelName=" + ModelName + ", ModelNo=" + ModelNo + ", make=" + make + ", type=" + type + ", description=" + description + ", color=" + color + ", price=" + price + ", thumbnail=" + thumbnail + ", preview_url=" + preview_url + ", cstate=" + cstate + '}';
    }

    
}
