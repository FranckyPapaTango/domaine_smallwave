/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafaros.domaine_smallwave.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "typecommande", catalog = "smallwave", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typecommande.findAll", query = "SELECT t FROM Typecommande t")
    , @NamedQuery(name = "Typecommande.findByIdTypecommande", query = "SELECT t FROM Typecommande t WHERE t.idTypecommande = :idTypecommande")
    , @NamedQuery(name = "Typecommande.findByLibelletype", query = "SELECT t FROM Typecommande t WHERE t.libelletype = :libelletype")})
public class Typecommande extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TYPECOMMANDE")
    private Long idTypecommande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "LIBELLETYPE")
    private String libelletype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypecommande")
    private Collection<Commande> commandeCollection;

    public Typecommande() {
    }

    public Typecommande(Long idTypecommande) {
        this.idTypecommande = idTypecommande;
    }

    public Typecommande(Long idTypecommande, String libelletype) {
        this.idTypecommande = idTypecommande;
        this.libelletype = libelletype;
    }

    public Long getIdTypecommande() {
        return idTypecommande;
    }

    public void setIdTypecommande(Long idTypecommande) {
        this.idTypecommande = idTypecommande;
    }

    public String getLibelletype() {
        return libelletype;
    }

    public void setLibelletype(String libelletype) {
        this.libelletype = libelletype;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypecommande != null ? idTypecommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typecommande)) {
            return false;
        }
        Typecommande other = (Typecommande) object;
        if ((this.idTypecommande == null && other.idTypecommande != null) || (this.idTypecommande != null && !this.idTypecommande.equals(other.idTypecommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rafaros.domaine_smallwave.entities.Typecommande[ idTypecommande=" + idTypecommande + " ]";
    }
    
}
