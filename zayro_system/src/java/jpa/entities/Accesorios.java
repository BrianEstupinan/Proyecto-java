/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "accesorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accesorios.findAll", query = "SELECT a FROM Accesorios a")
    , @NamedQuery(name = "Accesorios.findByIdAccesorio", query = "SELECT a FROM Accesorios a WHERE a.idAccesorio = :idAccesorio")
    , @NamedQuery(name = "Accesorios.findByAccesorios", query = "SELECT a FROM Accesorios a WHERE a.accesorios = :accesorios")})
public class Accesorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACCESORIO")
    private Integer idAccesorio;
    @Size(max = 45)
    @Column(name = "ACCESORIOS")
    private String accesorios;
    @ManyToMany(mappedBy = "accesoriosCollection")
    private Collection<Producto> productoCollection;

    public Accesorios() {
    }

    public Accesorios(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public Integer getIdAccesorio() {
        return idAccesorio;
    }

    public void setIdAccesorio(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccesorio != null ? idAccesorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accesorios)) {
            return false;
        }
        Accesorios other = (Accesorios) object;
        if ((this.idAccesorio == null && other.idAccesorio != null) || (this.idAccesorio != null && !this.idAccesorio.equals(other.idAccesorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Accesorios[ idAccesorio=" + idAccesorio + " ]";
    }
    
}
