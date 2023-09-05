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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "descuentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descuentos.findAll", query = "SELECT d FROM Descuentos d")
    , @NamedQuery(name = "Descuentos.findByIdDescuentos", query = "SELECT d FROM Descuentos d WHERE d.idDescuentos = :idDescuentos")
    , @NamedQuery(name = "Descuentos.findByPorcentajeDescuento", query = "SELECT d FROM Descuentos d WHERE d.porcentajeDescuento = :porcentajeDescuento")})
public class Descuentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DESCUENTOS")
    private Integer idDescuentos;
    @Column(name = "PORCENTAJE_DESCUENTO")
    private Integer porcentajeDescuento;
    @JoinTable(name = "descuentos_campa\u00f1as", joinColumns = {
        @JoinColumn(name = "ID_DESCUENTOS", referencedColumnName = "ID_DESCUENTOS")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_CAMPA\u00d1A", referencedColumnName = "ID_CAMPA\u00d1A")})
    @ManyToMany
    private Collection<Campanas> campanasCollection;
    @JoinColumn(name = "ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
    @ManyToOne
    private Inventario idInventario;

    public Descuentos() {
    }

    public Descuentos(Integer idDescuentos) {
        this.idDescuentos = idDescuentos;
    }

    public Integer getIdDescuentos() {
        return idDescuentos;
    }

    public void setIdDescuentos(Integer idDescuentos) {
        this.idDescuentos = idDescuentos;
    }

    public Integer getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Integer porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @XmlTransient
    public Collection<Campanas> getCampanasCollection() {
        return campanasCollection;
    }

    public void setCampanasCollection(Collection<Campanas> campanasCollection) {
        this.campanasCollection = campanasCollection;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDescuentos != null ? idDescuentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descuentos)) {
            return false;
        }
        Descuentos other = (Descuentos) object;
        if ((this.idDescuentos == null && other.idDescuentos != null) || (this.idDescuentos != null && !this.idDescuentos.equals(other.idDescuentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Descuentos[ idDescuentos=" + idDescuentos + " ]";
    }
    
}
