/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "entrada_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntradaProducto.findAll", query = "SELECT e FROM EntradaProducto e")
    , @NamedQuery(name = "EntradaProducto.findByIdEntradaProducto", query = "SELECT e FROM EntradaProducto e WHERE e.idEntradaProducto = :idEntradaProducto")
    , @NamedQuery(name = "EntradaProducto.findByNombreProducto", query = "SELECT e FROM EntradaProducto e WHERE e.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "EntradaProducto.findByFechaEntrada", query = "SELECT e FROM EntradaProducto e WHERE e.fechaEntrada = :fechaEntrada")})
public class EntradaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENTRADA_PRODUCTO")
    private Integer idEntradaProducto;
    @Size(max = 45)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @JoinColumn(name = "ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
    @ManyToOne
    private Inventario idInventario;

    public EntradaProducto() {
    }

    public EntradaProducto(Integer idEntradaProducto) {
        this.idEntradaProducto = idEntradaProducto;
    }

    public Integer getIdEntradaProducto() {
        return idEntradaProducto;
    }

    public void setIdEntradaProducto(Integer idEntradaProducto) {
        this.idEntradaProducto = idEntradaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
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
        hash += (idEntradaProducto != null ? idEntradaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaProducto)) {
            return false;
        }
        EntradaProducto other = (EntradaProducto) object;
        if ((this.idEntradaProducto == null && other.idEntradaProducto != null) || (this.idEntradaProducto != null && !this.idEntradaProducto.equals(other.idEntradaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EntradaProducto[ idEntradaProducto=" + idEntradaProducto + " ]";
    }
    
}
