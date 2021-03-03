/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafaros.domaine_smallwave.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BigWave
 */
@Entity
@Table(name = "commande", catalog = "smallwave", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByIdCommande ", query = "SELECT c FROM Commande c WHERE c.idCommande  = :idCommande ")
    , @NamedQuery(name = "Commande.findByCivilite", query = "SELECT c FROM Commande c WHERE c.civilite = :civilite")
    , @NamedQuery(name = "Commande.findByPays", query = "SELECT c FROM Commande c WHERE c.pays = :pays")
    , @NamedQuery(name = "Commande.findByPrenom", query = "SELECT c FROM Commande c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Commande.findByNom", query = "SELECT c FROM Commande c WHERE c.nom = :nom")
    , @NamedQuery(name = "Commande.findByNomProduit", query = "SELECT c FROM Commande c WHERE c.nomProduit = :nomProduit")
    , @NamedQuery(name = "Commande.findByDescriptionProduit", query = "SELECT c FROM Commande c WHERE c.descriptionProduit = :descriptionProduit")
    , @NamedQuery(name = "Commande.findByPhone", query = "SELECT c FROM Commande c WHERE c.phone = :phone")
    , @NamedQuery(name = "Commande.findByInstantMessenger", query = "SELECT c FROM Commande c WHERE c.instantMessenger = :instantMessenger")
    , @NamedQuery(name = "Commande.findByEmail", query = "SELECT c FROM Commande c WHERE c.email = :email")
    , @NamedQuery(name = "Commande.findByDeadline", query = "SELECT c FROM Commande c WHERE c.deadline = :deadline")
    , @NamedQuery(name = "Commande.findByBudget", query = "SELECT c FROM Commande c WHERE c.budget = :budget")
    , @NamedQuery(name = "Commande.findByPathDle", query = "SELECT c FROM Commande c WHERE c.pathDle = :pathDle")})
public class Commande extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMMANDE")
    private Long idCommande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CIVILITE")
    private String civilite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAYS")
    private String pays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_PRODUIT")
    private String nomProduit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPTION_PRODUIT")
    private String descriptionProduit;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 50)
    @Column(name = "INSTANT_MESSENGER")
    private String instantMessenger;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEADLINE")
    private String deadline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BUDGET")
    private String budget;
    @Size(max = 255)
    @Column(name = "PATH_DLE")
    private String pathDle;
    @JoinColumn(name = "ID_TYPECOMMANDE", referencedColumnName = "ID_TYPECOMMANDE")
    @ManyToOne(optional = false)
    private Typecommande idTypecommande;

    public Commande() {
    }

    public Commande(Long idCommande ) {
        this.idCommande = idCommande ;
    }

    public Commande(Long idCommande , String civilite, String pays, String prenom, String nom, String nomProduit, String descriptionProduit, String email, String deadline, String budget) {
        this.idCommande = idCommande ;
        this.civilite = civilite;
        this.pays = pays;
        this.prenom = prenom;
        this.nom = nom;
        this.nomProduit = nomProduit;
        this.descriptionProduit = descriptionProduit;
        this.email = email;
        this.deadline = deadline;
        this.budget = budget;
    }

    public Long getIdCommande () {
        return idCommande;
    }

    public void setIdCommande (Long idCommande ) {
        this.idCommande = idCommande ;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInstantMessenger() {
        return instantMessenger;
    }

    public void setInstantMessenger(String instantMessenger) {
        this.instantMessenger = instantMessenger;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPathDle() {
        return pathDle;
    }

    public void setPathDle(String pathDle) {
        this.pathDle = pathDle;
    }

    public Typecommande getIdTypecommande() {
        return idTypecommande;
    }

    public void setIdTypecommande(Typecommande idTypecommande) {
        this.idTypecommande = idTypecommande;
    }

@Override
public void setCssRawColorCode(String cssRawColorCode) {
	// TODO Auto-generated method stub
	super.setCssRawColorCode(cssRawColorCode);
}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rafaros.domaine_smallwave.entities.Commande[ idCommande =" + idCommande + " ]";
    }
    
}
