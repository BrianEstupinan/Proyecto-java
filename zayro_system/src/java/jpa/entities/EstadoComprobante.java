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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "estado_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoComprobante.findAll", query = "SELECT e FROM EstadoComprobante e")
    , @NamedQuery(name = "EstadoComprobante.findByIdEstadoComprobante", query = "SELECT e FROM EstadoComprobante e WHERE e.idEstadoComprobante = :idEstadoComprobante")
    , @NamedQuery(name = "EstadoComprobante.findByDescripcion", query = "SELECT e FROM EstadoComprobante e WHERE e.descripcion = :descripcion")})
public class EstadoComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_COMPROBANTE")
    private Integer idEstadoComprobante;
    @Size(max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idEstadoComprobante")
    private Collection<Orden> ordenCollection;

    public EstadoComprobante() {
    }

    public EstadoComprobante(Integer idEstadoComprobante) {
        this.idEstadoComprobante = idEstadoComprobante;
    }

    public Integer getIdEstadoComprobante() {
        return idEstadoComprobante;
    }

    public void setIdEstadoComprobante(Integer idEstadoComprobante) {
        this.idEstadoComprobante = idEstadoComprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoComprobante != null ? idEstadoComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoComprobante)) {
            return false;
        }
        EstadoComprobante other = (EstadoComprobante) object;
        if ((this.idEstadoComprobante == null && other.idEstadoComprobante != null) || (this.idEstadoComprobante != null && !this.idEstadoComprobante.equals(other.idEstadoComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadoComprobante[ idEstadoComprobante=" + idEstadoComprobante + " ]";
    }
    
}
