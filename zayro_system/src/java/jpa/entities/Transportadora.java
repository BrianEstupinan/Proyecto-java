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
@Table(name = "transportadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportadora.findAll", query = "SELECT t FROM Transportadora t")
    , @NamedQuery(name = "Transportadora.findByIdTransportadora", query = "SELECT t FROM Transportadora t WHERE t.idTransportadora = :idTransportadora")
    , @NamedQuery(name = "Transportadora.findByNombreTransportadora", query = "SELECT t FROM Transportadora t WHERE t.nombreTransportadora = :nombreTransportadora")
    , @NamedQuery(name = "Transportadora.findByContacto", query = "SELECT t FROM Transportadora t WHERE t.contacto = :contacto")})
public class Transportadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TRANSPORTADORA")
    private Integer idTransportadora;
    @Size(max = 45)
    @Column(name = "NOMBRE_TRANSPORTADORA")
    private String nombreTransportadora;
    @Size(max = 45)
    @Column(name = "CONTACTO")
    private String contacto;
    @OneToMany(mappedBy = "idTransportadora")
    private Collection<Envios> enviosCollection;

    public Transportadora() {
    }

    public Transportadora(Integer idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public Integer getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(Integer idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    public String getNombreTransportadora() {
        return nombreTransportadora;
    }

    public void setNombreTransportadora(String nombreTransportadora) {
        this.nombreTransportadora = nombreTransportadora;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @XmlTransient
    public Collection<Envios> getEnviosCollection() {
        return enviosCollection;
    }

    public void setEnviosCollection(Collection<Envios> enviosCollection) {
        this.enviosCollection = enviosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransportadora != null ? idTransportadora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportadora)) {
            return false;
        }
        Transportadora other = (Transportadora) object;
        if ((this.idTransportadora == null && other.idTransportadora != null) || (this.idTransportadora != null && !this.idTransportadora.equals(other.idTransportadora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Transportadora[ idTransportadora=" + idTransportadora + " ]";
    }
    
}
