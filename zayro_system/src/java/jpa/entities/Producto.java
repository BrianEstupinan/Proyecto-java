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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombreDisfraz", query = "SELECT p FROM Producto p WHERE p.nombreDisfraz = :nombreDisfraz")
    , @NamedQuery(name = "Producto.findByTalla", query = "SELECT p FROM Producto p WHERE p.talla = :talla")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Size(max = 45)
    @Column(name = "NOMBRE_DISFRAZ")
    private String nombreDisfraz;
    @Lob
    @Column(name = "IMAGEN_DISFRAZ")
    private byte[] imagenDisfraz;
    @Size(max = 45)
    @Column(name = "TALLA")
    private String talla;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinTable(name = "producto_recibo_venta", joinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_RECIBO_VENTA", referencedColumnName = "ID_RECIBO_VENTA")})
    @ManyToMany
    private Collection<ReciboVenta> reciboVentaCollection;
    @JoinTable(name = "producto_accesorios", joinColumns = {
        @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ACCESORIO", referencedColumnName = "ID_ACCESORIO")})
    @ManyToMany
    private Collection<Accesorios> accesoriosCollection;
    @ManyToMany(mappedBy = "productoCollection")
    private Collection<Orden> ordenCollection;
    @JoinColumn(name = "ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
    @ManyToOne
    private Inventario idInventario;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "ID_TALLA", referencedColumnName = "ID_TALLA")
    @ManyToOne
    private Talla idTalla;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreDisfraz() {
        return nombreDisfraz;
    }

    public void setNombreDisfraz(String nombreDisfraz) {
        this.nombreDisfraz = nombreDisfraz;
    }

    public byte[] getImagenDisfraz() {
        return imagenDisfraz;
    }

    public void setImagenDisfraz(byte[] imagenDisfraz) {
        this.imagenDisfraz = imagenDisfraz;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<ReciboVenta> getReciboVentaCollection() {
        return reciboVentaCollection;
    }

    public void setReciboVentaCollection(Collection<ReciboVenta> reciboVentaCollection) {
        this.reciboVentaCollection = reciboVentaCollection;
    }

    @XmlTransient
    public Collection<Accesorios> getAccesoriosCollection() {
        return accesoriosCollection;
    }

    public void setAccesoriosCollection(Collection<Accesorios> accesoriosCollection) {
        this.accesoriosCollection = accesoriosCollection;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Talla getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Talla idTalla) {
        this.idTalla = idTalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
