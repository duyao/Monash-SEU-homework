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
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findById", query = "SELECT r FROM Report r WHERE r.id = :id"),
    @NamedQuery(name = "Report.findByTime", query = "SELECT r FROM Report r WHERE r.time = :time"),
    @NamedQuery(name = "Report.findByConsumed", query = "SELECT r FROM Report r WHERE r.consumed = :consumed"),
    @NamedQuery(name = "Report.findByIntaked", query = "SELECT r FROM Report r WHERE r.intaked = :intaked"),
    @NamedQuery(name = "Report.findByTotalSteps", query = "SELECT r FROM Report r WHERE r.totalSteps = :totalSteps"),
    @NamedQuery(name = "Report.findByCalorieSetGoal", query = "SELECT r FROM Report r WHERE r.calorieSetGoal = :calorieSetGoal"),
    @NamedQuery(name = "Report.findByRemaining", query = "SELECT r FROM Report r WHERE r.remaining = :remaining")})
public class Report implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consumed")
    private double consumed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intaked")
    private double intaked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_steps")
    private double totalSteps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calorie_set_goal")
    private double calorieSetGoal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "remaining")
    private double remaining;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Report() {
    }

    public Report(String id) {
        this.id = id;
    }

    public Report(String id, Date time, double consumed, double intaked, double totalSteps, double calorieSetGoal, double remaining) {
        this.id = id;
        this.time = time;
        this.consumed = consumed;
        this.intaked = intaked;
        this.totalSteps = totalSteps;
        this.calorieSetGoal = calorieSetGoal;
        this.remaining = remaining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getConsumed() {
        return consumed;
    }

    public void setConsumed(double consumed) {
        this.consumed = consumed;
    }

    public double getIntaked() {
        return intaked;
    }

    public void setIntaked(double intaked) {
        this.intaked = intaked;
    }

    public double getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(double totalSteps) {
        this.totalSteps = totalSteps;
    }

    public double getCalorieSetGoal() {
        return calorieSetGoal;
    }

    public void setCalorieSetGoal(double calorieSetGoal) {
        this.calorieSetGoal = calorieSetGoal;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
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
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dy.entity.Report[ id=" + id + " ]";
    }
    
}
