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
@Table(name = "salida_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalidaProducto.findAll", query = "SELECT s FROM SalidaProducto s")
    , @NamedQuery(name = "SalidaProducto.findByIdSalidaProducto", query = "SELECT s FROM SalidaProducto s WHERE s.idSalidaProducto = :idSalidaProducto")
    , @NamedQuery(name = "SalidaProducto.findByNombreProducto", query = "SELECT s FROM SalidaProducto s WHERE s.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "SalidaProducto.findByFechaSalida", query = "SELECT s FROM SalidaProducto s WHERE s.fechaSalida = :fechaSalida")})
public class SalidaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SALIDA_PRODUCTO")
    private Integer idSalidaProducto;
    @Size(max = 45)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinColumn(name = "ID_INVENTARIO", referencedColumnName = "ID_INVENTARIO")
    @ManyToOne
    private Inventario idInventario;

    public SalidaProducto() {
    }

    public SalidaProducto(Integer idSalidaProducto) {
        this.idSalidaProducto = idSalidaProducto;
    }

    public Integer getIdSalidaProducto() {
        return idSalidaProducto;
    }

    public void setIdSalidaProducto(Integer idSalidaProducto) {
        this.idSalidaProducto = idSalidaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
        hash += (idSalidaProducto != null ? idSalidaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaProducto)) {
            return false;
        }
        SalidaProducto other = (SalidaProducto) object;
        if ((this.idSalidaProducto == null && other.idSalidaProducto != null) || (this.idSalidaProducto != null && !this.idSalidaProducto.equals(other.idSalidaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SalidaProducto[ idSalidaProducto=" + idSalidaProducto + " ]";
    }
    
}
