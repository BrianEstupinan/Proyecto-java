/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "recibo_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReciboVenta.findAll", query = "SELECT r FROM ReciboVenta r")
    , @NamedQuery(name = "ReciboVenta.findByIdReciboVenta", query = "SELECT r FROM ReciboVenta r WHERE r.idReciboVenta = :idReciboVenta")
    , @NamedQuery(name = "ReciboVenta.findByCantidad", query = "SELECT r FROM ReciboVenta r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "ReciboVenta.findByMetodoPago", query = "SELECT r FROM ReciboVenta r WHERE r.metodoPago = :metodoPago")
    , @NamedQuery(name = "ReciboVenta.findByPrecioUnidad", query = "SELECT r FROM ReciboVenta r WHERE r.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "ReciboVenta.findByPrecioTotal", query = "SELECT r FROM ReciboVenta r WHERE r.precioTotal = :precioTotal")
    , @NamedQuery(name = "ReciboVenta.findByFecha", query = "SELECT r FROM ReciboVenta r WHERE r.fecha = :fecha")})
public class ReciboVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RECIBO_VENTA")
    private Integer idReciboVenta;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Size(max = 45)
    @Column(name = "METODO_PAGO")
    private String metodoPago;
    @Column(name = "PRECIO_UNIDAD")
    private Integer precioUnidad;
    @Column(name = "PRECIO_TOTAL")
    private Integer precioTotal;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToMany(mappedBy = "reciboVentaCollection")
    private Collection<Producto> productoCollection;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")
    @ManyToOne
    private Orden idOrden;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public ReciboVenta() {
    }

    public ReciboVenta(Integer idReciboVenta) {
        this.idReciboVenta = idReciboVenta;
    }

    public Integer getIdReciboVenta() {
        return idReciboVenta;
    }

    public void setIdReciboVenta(Integer idReciboVenta) {
        this.idReciboVenta = idReciboVenta;
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

    public Integer getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(Integer precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public Orden getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Orden idOrden) {
        this.idOrden = idOrden;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReciboVenta != null ? idReciboVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReciboVenta)) {
            return false;
        }
        ReciboVenta other = (ReciboVenta) object;
        if ((this.idReciboVenta == null && other.idReciboVenta != null) || (this.idReciboVenta != null && !this.idReciboVenta.equals(other.idReciboVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ReciboVenta[ idReciboVenta=" + idReciboVenta + " ]";
    }
    
}
