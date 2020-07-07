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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Type;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "actualite", catalog = "smallwave", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actualite.findAll", query = "SELECT a FROM Actualite a")
    , @NamedQuery(name = "Actualite.findById", query = "SELECT a FROM Actualite a WHERE a.id = :id")
    , @NamedQuery(name = "Actualite.findByTitre", query = "SELECT a FROM Actualite a WHERE a.titre = :titre")
    , @NamedQuery(name = "Actualite.findByAuteur", query = "SELECT a FROM Actualite a WHERE a.auteur = :auteur")
    , @NamedQuery(name = "Actualite.findByEmail", query = "SELECT a FROM Actualite a WHERE a.email = :email")})
public class Actualite extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Lob    
//    @Size(min = 1, max = 2147483647)
    @Column(name = "CORPS")
    @Type(type = "org.hibernate.type.TextType")
    private String corps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AUTEUR")
    private String auteur;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<Image> imageCollection;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false)
    private Categorie idCategorie;

    public Actualite() {
    }

    public Actualite(Long id) {
        this.id = id;
    }

//    public Actualite(Long id, String titre, String corps, String auteur, String email) {
//        this.id = id;
//        this.titre = titre;
//        this.corps = corps;
//        this.auteur = auteur;
//        this.email = email;
//    }
    
    

    public Actualite(Long id, @NotNull @Size(min = 1, max = 255) String titre, @NotNull String corps,
			@NotNull @Size(min = 1, max = 255) String auteur, @NotNull @Size(min = 1, max = 50) String email,
//			Collection<Image> imageCollection, 
			Categorie idCategorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.corps = corps;
		this.auteur = auteur;
		this.email = email;
//		this.imageCollection = imageCollection;
		this.idCategorie = idCategorie;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Image> getImageCollection() {
        return imageCollection;
    }

    public void setImageCollection(Collection<Image> imageCollection) {
        this.imageCollection = imageCollection;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actualite)) {
            return false;
        }
        Actualite other = (Actualite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rafaros.domaine_smallwave.entities.Actualite[ id=" + id + " ]";
    }
    
}
