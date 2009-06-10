package ftn.edu.ais.model;

import ftn.edu.ais.model.BaseObject;

//import java.util.HashSet;
//import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
//import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name="tim",catalog="dipl2")
public class Tim extends BaseObject implements Serializable {
    private Long idt;
    private String nazt;
    private String opist;
    private String napomenat;
    //private Set<Pripada> pripadas = new HashSet<Pripada>(0);
    //private Set<Dete> detes = new HashSet<Dete>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdt() {
        return this.idt;
    }
    
    public void setIdt(Long idt) {
        this.idt = idt;
    }
    
    @Column(name="nazt", nullable=false, length=30)
    public String getNazt() {
        return this.nazt;
    }
    
    public void setNazt(String nazt) {
        this.nazt = nazt;
    }
    
    @Column(name="opist", length=50)
    public String getOpist() {
        return this.opist;
    }
    
    public void setOpist(String opist) {
        this.opist = opist;
    }
    
    @Column(name="napomenat", length=50)
    public String getNapomenat() {
        return this.napomenat;
    }
    
    public void setNapomenat(String napomenat) {
        this.napomenat = napomenat;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tim")
//    public Set<Pripada> getPripadas() {
//        return this.pripadas;
//    }
//    
//    public void setPripadas(Set<Pripada> pripadas) {
//        this.pripadas = pripadas;
//    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="tim")
//    public Set<Dete> getDetes() {
//        return this.detes;
//    }
//    
//    public void setDetes(Set<Dete> detes) {
//        this.detes = detes;
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tim pojo = (Tim) o;

        if (nazt != null ? !nazt.equals(pojo.nazt) : pojo.nazt != null) return false;
        if (opist != null ? !opist.equals(pojo.opist) : pojo.opist != null) return false;
        if (napomenat != null ? !napomenat.equals(pojo.napomenat) : pojo.napomenat != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (nazt != null ? nazt.hashCode() : 0);
        result = 31 * result + (opist != null ? opist.hashCode() : 0);
        result = 31 * result + (napomenat != null ? napomenat.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idt").append("='").append(getIdt()).append("', ");
        sb.append("nazt").append("='").append(getNazt()).append("', ");
        sb.append("opist").append("='").append(getOpist()).append("', ");
        sb.append("napomenat").append("='").append(getNapomenat()).append("', ");
        
        
        sb.append("]");
      
        return sb.toString();
    }

}
