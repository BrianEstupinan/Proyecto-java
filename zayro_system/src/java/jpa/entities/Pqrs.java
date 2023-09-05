/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p")
    , @NamedQuery(name = "Pqrs.findByIdPqrs", query = "SELECT p FROM Pqrs p WHERE p.idPqrs = :idPqrs")
    , @NamedQuery(name = "Pqrs.findByTipoPqrs", query = "SELECT p FROM Pqrs p WHERE p.tipoPqrs = :tipoPqrs")
    , @NamedQuery(name = "Pqrs.findByDescripcion", query = "SELECT p FROM Pqrs p WHERE p.descripcion = :descripcion")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PQRS")
    private Integer idPqrs;
    @Size(max = 50)
    @Column(name = "TIPO_PQRS")
    private String tipoPqrs;
    @Size(max = 250)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Lob
    @Column(name = "IMAGEN")
    private byte[] imagen;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Pqrs() {
    }

    public Pqrs(Integer idPqrs) {
        this.idPqrs = idPqrs;
    }

    public Integer getIdPqrs() {
        return idPqrs;
    }

    public void setIdPqrs(Integer idPqrs) {
        this.idPqrs = idPqrs;
    }

    public String getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(String tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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
        hash += (idPqrs != null ? idPqrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.idPqrs == null && other.idPqrs != null) || (this.idPqrs != null && !this.idPqrs.equals(other.idPqrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Pqrs[ idPqrs=" + idPqrs + " ]";
    }
    
}
