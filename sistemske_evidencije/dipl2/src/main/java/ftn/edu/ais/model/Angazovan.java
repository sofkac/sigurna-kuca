package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="angazovan",catalog="dipl2")
public class Angazovan extends BaseObject implements Serializable {
    private Long ida;
    private Zaposleni zaposleni;
    private Pripada pripada;
    private Date data;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIda() {
        return this.ida;
    }
    
    public void setIda(Long ida) {
        this.ida = ida;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idz", nullable=false)
    public Zaposleni getZaposleni() {
        return this.zaposleni;
    }
    
    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idp", nullable=false)
    public Pripada getPripada() {
        return this.pripada;
    }
    
    public void setPripada(Pripada pripada) {
        this.pripada = pripada;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable=false, length=0)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Angazovan pojo = (Angazovan) o;

        if (zaposleni != null ? !zaposleni.equals(pojo.zaposleni) : pojo.zaposleni != null) return false;
        if (pripada != null ? !pripada.equals(pojo.pripada) : pojo.pripada != null) return false;
        if (data != null ? !data.equals(pojo.data) : pojo.data != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (zaposleni != null ? zaposleni.hashCode() : 0);
        result = 31 * result + (pripada != null ? pripada.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("ida").append("='").append(getIda()).append("', ");
        sb.append("zaposleni").append("='").append(getZaposleni()).append("', ");
        sb.append("pripada").append("='").append(getPripada()).append("', ");
        sb.append("data").append("='").append(getData()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
