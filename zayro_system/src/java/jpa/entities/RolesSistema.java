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
@Table(name = "roles_sistema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesSistema.findAll", query = "SELECT r FROM RolesSistema r")
    , @NamedQuery(name = "RolesSistema.findByIdRol", query = "SELECT r FROM RolesSistema r WHERE r.idRol = :idRol")
    , @NamedQuery(name = "RolesSistema.findByDescripcionRoles", query = "SELECT r FROM RolesSistema r WHERE r.descripcionRoles = :descripcionRoles")})
public class RolesSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ROL")
    private Integer idRol;
    @Size(max = 45)
    @Column(name = "DESCRIPCION_ROLES")
    private String descripcionRoles;
    @JoinTable(name = "roles_sistema_permisos", joinColumns = {
        @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_PERMISO", referencedColumnName = "ID_PERMISO")})
    @ManyToMany
    private Collection<Permisos> permisosCollection;
    @OneToMany(mappedBy = "idRol")
    private Collection<Usuario> usuarioCollection;

    public RolesSistema() {
    }

    public RolesSistema(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRoles() {
        return descripcionRoles;
    }

    public void setDescripcionRoles(String descripcionRoles) {
        this.descripcionRoles = descripcionRoles;
    }

    @XmlTransient
    public Collection<Permisos> getPermisosCollection() {
        return permisosCollection;
    }

    public void setPermisosCollection(Collection<Permisos> permisosCollection) {
        this.permisosCollection = permisosCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesSistema)) {
            return false;
        }
        RolesSistema other = (RolesSistema) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.RolesSistema[ idRol=" + idRol + " ]";
    }
    
}
