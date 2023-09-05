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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FAMILIA
 */
@Entity
@Table(name = "envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findByIdEnvio", query = "SELECT e FROM Envios e WHERE e.idEnvio = :idEnvio")
    , @NamedQuery(name = "Envios.findByNumeroRadicadoEnvio", query = "SELECT e FROM Envios e WHERE e.numeroRadicadoEnvio = :numeroRadicadoEnvio")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENVIO")
    private Integer idEnvio;
    @Size(max = 25)
    @Column(name = "NUMERO_RADICADO_ENVIO")
    private String numeroRadicadoEnvio;
    @OneToMany(mappedBy = "idEnvio")
    private Collection<Estado> estadoCollection;
    @OneToMany(mappedBy = "idEnvio")
    private Collection<Orden> ordenCollection;
    @JoinColumn(name = "ID_TRANSPORTADORA", referencedColumnName = "ID_TRANSPORTADORA")
    @ManyToOne
    private Transportadora idTransportadora;

    public Envios() {
    }

    public Envios(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNumeroRadicadoEnvio() {
        return numeroRadicadoEnvio;
    }

    public void setNumeroRadicadoEnvio(String numeroRadicadoEnvio) {
        this.numeroRadicadoEnvio = numeroRadicadoEnvio;
    }

    @XmlTransient
    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    public Transportadora getIdTransportadora() {
        return idTransportadora;
    }

    public void setIdTransportadora(Transportadora idTransportadora) {
        this.idTransportadora = idTransportadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnvio != null ? idEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.idEnvio == null && other.idEnvio != null) || (this.idEnvio != null && !this.idEnvio.equals(other.idEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Envios[ idEnvio=" + idEnvio + " ]";
    }
    
}
