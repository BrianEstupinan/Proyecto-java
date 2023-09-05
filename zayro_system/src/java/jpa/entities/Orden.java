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
@Table(name = "orden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Orden.findByCantidad", query = "SELECT o FROM Orden o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Orden.findByMetodoPago", query = "SELECT o FROM Orden o WHERE o.metodoPago = :metodoPago")
    , @NamedQuery(name = "Orden.findByPrecio", query = "SELECT o FROM Orden o WHERE o.precio = :precio")
    , @NamedQuery(name = "Orden.findByPrecioTotal", query = "SELECT o FROM Orden o WHERE o.precioTotal = :precioTotal")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEN")
    private Integer idOrden;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Size(max = 45)
    @Column(name = "METODO_PAGO")
    private String metodoPago;
    @Column(name = "PRECIO")
    private Integer precio;
    @Column(name = "PRECIO_TOTAL")
    private Integer precioTotal;
    @JoinTable(name = "orden_producto", joinColumns = {
        @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")})
    @ManyToMany
    private Collection<Producto> productoCollection;
    @OneToMany(mappedBy = "idOrden")
    private Collection<ReciboVenta> reciboVentaCollection;
    @JoinColumn(name = "ID_ENVIO", referencedColumnName = "ID_ENVIO")
    @ManyToOne
    private Envios idEnvio;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
    @ManyToOne
    private Inventario idInventario;
    @JoinColumn(name = "ID_TALLA", referencedColumnName = "ID_TALLA")
    @ManyToOne
    private Talla idTalla;
    @JoinColumn(name = "ID_ESTADO_COMPROBANTE", referencedColumnName = "ID_ESTADO_COMPROBANTE")
    @ManyToOne
    private EstadoComprobante idEstadoComprobante;

    public Orden() {
    }

    public Orden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<ReciboVenta> getReciboVentaCollection() {
        return reciboVentaCollection;
    }

    public void setReciboVentaCollection(Collection<ReciboVenta> reciboVentaCollection) {
        this.reciboVentaCollection = reciboVentaCollection;
    }

    public Envios getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Envios idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    public Talla getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Talla idTalla) {
        this.idTalla = idTalla;
    }

    public EstadoComprobante getIdEstadoComprobante() {
        return idEstadoComprobante;
    }

    public void setIdEstadoComprobante(EstadoComprobante idEstadoComprobante) {
        this.idEstadoComprobante = idEstadoComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Orden[ idOrden=" + idOrden + " ]";
    }
    
}
