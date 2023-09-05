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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByDireccionBogota", query = "SELECT u FROM Usuario u WHERE u.direccionBogota = :direccionBogota")
    , @NamedQuery(name = "Usuario.findByEMail", query = "SELECT u FROM Usuario u WHERE u.eMail = :eMail")
    , @NamedQuery(name = "Usuario.findByTelefono1", query = "SELECT u FROM Usuario u WHERE u.telefono1 = :telefono1")
    , @NamedQuery(name = "Usuario.findByTelefono2", query = "SELECT u FROM Usuario u WHERE u.telefono2 = :telefono2")
    , @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByConfirmacionClave", query = "SELECT u FROM Usuario u WHERE u.confirmacionClave = :confirmacionClave")
    , @NamedQuery(name = "Usuario.findByConfirmacionPermiso", query = "SELECT u FROM Usuario u WHERE u.confirmacionPermiso = :confirmacionPermiso")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "DIRECCION_BOGOTA")
    private String direccionBogota;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "E_MAIL")
    private String eMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO_1")
    private int telefono1;
    @Column(name = "TELEFONO_2")
    private Integer telefono2;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 45)
    @Column(name = "CONFIRMACION_CLAVE")
    private String confirmacionClave;
    @Column(name = "CONFIRMACION_PERMISO")
    private Boolean confirmacionPermiso;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Campanas> campanasCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<ReciboVenta> reciboVentaCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Pqrs> pqrsCollection;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne
    private RolesSistema idRol;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Orden> ordenCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Inventario> inventarioCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, int telefono1) {
        this.idUsuario = idUsuario;
        this.telefono1 = telefono1;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccionBogota() {
        return direccionBogota;
    }

    public void setDireccionBogota(String direccionBogota) {
        this.direccionBogota = direccionBogota;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public Integer getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(Integer telefono2) {
        this.telefono2 = telefono2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConfirmacionClave() {
        return confirmacionClave;
    }

    public void setConfirmacionClave(String confirmacionClave) {
        this.confirmacionClave = confirmacionClave;
    }

    public Boolean getConfirmacionPermiso() {
        return confirmacionPermiso;
    }

    public void setConfirmacionPermiso(Boolean confirmacionPermiso) {
        this.confirmacionPermiso = confirmacionPermiso;
    }

    @XmlTransient
    public Collection<Campanas> getCampanasCollection() {
        return campanasCollection;
    }

    public void setCampanasCollection(Collection<Campanas> campanasCollection) {
        this.campanasCollection = campanasCollection;
    }

    @XmlTransient
    public Collection<ReciboVenta> getReciboVentaCollection() {
        return reciboVentaCollection;
    }

    public void setReciboVentaCollection(Collection<ReciboVenta> reciboVentaCollection) {
        this.reciboVentaCollection = reciboVentaCollection;
    }

    @XmlTransient
    public Collection<Pqrs> getPqrsCollection() {
        return pqrsCollection;
    }

    public void setPqrsCollection(Collection<Pqrs> pqrsCollection) {
        this.pqrsCollection = pqrsCollection;
    }

    public RolesSistema getIdRol() {
        return idRol;
    }

    public void setIdRol(RolesSistema idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
