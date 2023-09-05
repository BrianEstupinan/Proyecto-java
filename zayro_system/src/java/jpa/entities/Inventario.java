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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT i FROM Inventario i WHERE i.idInventario = :idInventario")
    , @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad")
    , @NamedQuery(name = "Inventario.findByPrecioUnitario", query = "SELECT i FROM Inventario i WHERE i.precioUnitario = :precioUnitario")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIO")
    private Integer idInventario;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "PRECIO_UNITARIO")
    private Integer precioUnitario;
    @OneToMany(mappedBy = "idInventario")
    private Collection<Descuentos> descuentosCollection;
    @OneToMany(mappedBy = "idInventario")
    private Collection<Producto> productoCollection;
    @OneToMany(mappedBy = "idInventario")
    private Collection<SalidaProducto> salidaProductoCollection;
    @OneToMany(mappedBy = "idInventario")
    private Collection<Orden> ordenCollection;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_DISPONIBILIDAD", referencedColumnName = "ID_DISPONIBILIDAD")
    @ManyToOne
    private Disponibilidad idDisponibilidad;
    @OneToMany(mappedBy = "idInventario")
    private Collection<EntradaProducto> entradaProductoCollection;

    public Inventario() {
    }

    public Inventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @XmlTransient
    public Collection<Descuentos> getDescuentosCollection() {
        return descuentosCollection;
    }

    public void setDescuentosCollection(Collection<Descuentos> descuentosCollection) {
        this.descuentosCollection = descuentosCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<SalidaProducto> getSalidaProductoCollection() {
        return salidaProductoCollection;
    }

    public void setSalidaProductoCollection(Collection<SalidaProducto> salidaProductoCollection) {
        this.salidaProductoCollection = salidaProductoCollection;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Disponibilidad getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Disponibilidad idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    @XmlTransient
    public Collection<EntradaProducto> getEntradaProductoCollection() {
        return entradaProductoCollection;
    }

    public void setEntradaProductoCollection(Collection<EntradaProducto> entradaProductoCollection) {
        this.entradaProductoCollection = entradaProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Inventario[ idInventario=" + idInventario + " ]";
    }
    
}
