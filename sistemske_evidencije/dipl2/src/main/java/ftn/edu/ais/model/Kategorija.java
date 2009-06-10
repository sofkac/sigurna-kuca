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
@Table(name="kategorija",catalog="dipl2")
public class Kategorija extends BaseObject implements Serializable {
    private Long idk;
    private String nazk;
    private String opisk;
    //private Set<Dete> detes = new HashSet<Dete>(0);

    @Id @GeneratedValue(strategy = GenerationType.AUTO)    
    public Long getIdk() {
        return this.idk;
    }
    
    public void setIdk(Long idk) {
        this.idk = idk;
    }
    
    @Column(name="nazk", nullable=false, length=25)
    public String getNazk() {
        return this.nazk;
    }
    
    public void setNazk(String nazk) {
        this.nazk = nazk;
    }
    
    @Column(name="opisk", length=30)
    public String getOpisk() {
        return this.opisk;
    }
    
    public void setOpisk(String opisk) {
        this.opisk = opisk;
    }
//@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="kategorija")
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

        Kategorija pojo = (Kategorija) o;

        if (nazk != null ? !nazk.equals(pojo.nazk) : pojo.nazk != null) return false;
        if (opisk != null ? !opisk.equals(pojo.opisk) : pojo.opisk != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (nazk != null ? nazk.hashCode() : 0);
        result = 31 * result + (opisk != null ? opisk.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("idk").append("='").append(getIdk()).append("', ");
        sb.append("nazk").append("='").append(getNazk()).append("', ");
        sb.append("opisk").append("='").append(getOpisk()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

}
