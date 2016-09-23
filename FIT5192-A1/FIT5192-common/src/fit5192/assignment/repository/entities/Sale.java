/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.assignment.repository.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dy
 */
@Entity
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Customer cid;

    @Column(name = "finish_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finish_date;

    @Column(name = "sale_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sale_date;

    @OneToOne
    @JoinColumn(name = "vin")
    private Car vin;

    @ManyToOne
    @JoinColumn(name = "sid")
    private SalesPerson sid;

    private String sstate;

    public Sale() {
    }

    public Sale(String id, Customer cid, Date finish_date, Date sale_date, Car vin, SalesPerson sid, String sstate) {
        this.id = id;
        this.cid = cid;
        this.finish_date = finish_date;
        this.sale_date = sale_date;
        this.vin = vin;
        this.sid = sid;
        this.sstate = sstate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users getCid() {
        return cid;
    }

    public void setCid(Customer cid) {
        this.cid = cid;
    }

    public Date getSale_date() {
        return sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public Car getVin() {
        return vin;
    }

    public void setVin(Car vin) {
        this.vin = vin;
    }

    public Users getSid() {
        return sid;
    }

    public void setSid(SalesPerson sid) {
        this.sid = sid;
    }

    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
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
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

}
