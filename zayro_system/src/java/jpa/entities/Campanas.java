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
@Table(name = "campanas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanas.findAll", query = "SELECT c FROM Campanas c")
    , @NamedQuery(name = "Campanas.findByIdCampa\u00f1a", query = "SELECT c FROM Campanas c WHERE c.idCampa\u00f1a = :idCampa\u00f1a")
    , @NamedQuery(name = "Campanas.findByNombreCampa\u00f1a", query = "SELECT c FROM Campanas c WHERE c.nombreCampa\u00f1a = :nombreCampa\u00f1a")
    , @NamedQuery(name = "Campanas.findByDescripcion", query = "SELECT c FROM Campanas c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Campanas.findByEmailClientes", query = "SELECT c FROM Campanas c WHERE c.emailClientes = :emailClientes")
    , @NamedQuery(name = "Campanas.findByFechaInicio", query = "SELECT c FROM Campanas c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Campanas.findByFechaFin", query = "SELECT c FROM Campanas c WHERE c.fechaFin = :fechaFin")})
public class Campanas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAMPA\u00d1A")
    private Integer idCampaña;
    @Size(max = 45)
    @Column(name = "NOMBRE_CAMPA\u00d1A")
    private String nombreCampaña;
    @Size(max = 45)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "EMAIL_CLIENTES")
    private String emailClientes;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @ManyToMany(mappedBy = "campanasCollection")
    private Collection<Descuentos> descuentosCollection;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public Campanas() {
    }

    public Campanas(Integer idCampaña) {
        this.idCampaña = idCampaña;
    }

    public Integer getIdCampaña() {
        return idCampaña;
    }

    public void setIdCampaña(Integer idCampaña) {
        this.idCampaña = idCampaña;
    }

    public String getNombreCampaña() {
        return nombreCampaña;
    }

    public void setNombreCampaña(String nombreCampaña) {
        this.nombreCampaña = nombreCampaña;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmailClientes() {
        return emailClientes;
    }

    public void setEmailClientes(String emailClientes) {
        this.emailClientes = emailClientes;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public Collection<Descuentos> getDescuentosCollection() {
        return descuentosCollection;
    }

    public void setDescuentosCollection(Collection<Descuentos> descuentosCollection) {
        this.descuentosCollection = descuentosCollection;
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
        hash += (idCampaña != null ? idCampaña.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campanas)) {
            return false;
        }
        Campanas other = (Campanas) object;
        if ((this.idCampaña == null && other.idCampaña != null) || (this.idCampaña != null && !this.idCampaña.equals(other.idCampaña))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Campanas[ idCampa\u00f1a=" + idCampaña + " ]";
    }
    
}
