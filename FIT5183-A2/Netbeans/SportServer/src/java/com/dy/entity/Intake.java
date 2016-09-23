/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dy.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dy
 */
@Entity
@Table(name = "intake")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intake.findAll", query = "SELECT i FROM Intake i"),
    @NamedQuery(name = "Intake.findById", query = "SELECT i FROM Intake i WHERE i.id = :id"),
    @NamedQuery(name = "Intake.findByQuantiy", query = "SELECT i FROM Intake i WHERE i.quantiy = :quantiy"),
    @NamedQuery(name = "Intake.findByTime", query = "SELECT i FROM Intake i WHERE i.time = :time"),
    @NamedQuery(name = "Intake.getTotalCalByIntake", query = "SELECT f, intake.quantiy FROM Food f INNER JOIN Intake intake WHERE f.id = intake.foodId.id AND intake.userId.id = :id AND intake.time >= :start AND intake.time <= :end")
})
public class Intake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantiy")
    private double quantiy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Food foodId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Intake() {
    }

    public Intake(String id) {
        this.id = id;
    }

    public Intake(String id, double quantiy, Date time) {
        this.id = id;
        this.quantiy = quantiy;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(double quantiy) {
        this.quantiy = quantiy;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intake)) {
            return false;
        }
        Intake other = (Intake) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dy.entity.Intake[ id=" + id + " ]";
    }
    
}
