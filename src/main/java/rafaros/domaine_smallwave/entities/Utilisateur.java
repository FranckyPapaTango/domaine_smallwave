/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafaros.domaine_smallwave.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
 * @author BigWave
 */
@Entity
@Table(name = "utilisateur", catalog = "smallwave", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByUtilisateurId", query = "SELECT u FROM Utilisateur u WHERE u.utilisateurId = :utilisateurId")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username")
    , @NamedQuery(name = "Utilisateur.findByStatut", query = "SELECT u FROM Utilisateur u WHERE u.statut = :statut")
    , @NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login")
    , @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")
    , @NamedQuery(name = "Utilisateur.findByTelFixe", query = "SELECT u FROM Utilisateur u WHERE u.telFixe = :telFixe")
    , @NamedQuery(name = "Utilisateur.findByTelMobile", query = "SELECT u FROM Utilisateur u WHERE u.telMobile = :telMobile")
    , @NamedQuery(name = "Utilisateur.findByCodePostale", query = "SELECT u FROM Utilisateur u WHERE u.codePostale = :codePostale")
    , @NamedQuery(name = "Utilisateur.findByComplement", query = "SELECT u FROM Utilisateur u WHERE u.complement = :complement")
//    , @NamedQuery(name = "Utilisateur.findByDateAdded", query = "SELECT u FROM Utilisateur u WHERE u.dateAdded = :dateAdded")
    , @NamedQuery(name = "Utilisateur.findByPathDle", query = "SELECT u FROM Utilisateur u WHERE u.pathDle = :pathDle")
    , @NamedQuery(name = "Utilisateur.findByPays", query = "SELECT u FROM Utilisateur u WHERE u.pays = :pays")
    , @NamedQuery(name = "Utilisateur.findBySessionId", query = "SELECT u FROM Utilisateur u WHERE u.sessionId = :sessionId")
    , @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville")
    , @NamedQuery(name = "Utilisateur.findByNumVoieTypeVoieLibelleVoie", query = "SELECT u FROM Utilisateur u WHERE u.numVoieTypeVoieLibelleVoie = :numVoieTypeVoieLibelleVoie")})
@NamedNativeQueries({
    @NamedNativeQuery(name = "Utilisateur.findUtilisateurByKeyWord",
            query = "SELECT * FROM utilisateur WHERE USERNAME like CONCAT('%', :search, '%') OR nom like CONCAT('%', :search, '%') OR utilisateur_id like CONCAT('%', :search, '%')",
            resultClass = Utilisateur.class)
    ,
//,
//    @NamedNativeQuery(name = "Utilisateurr.findUtilisateurByLoginAndPassword",
//            query = "SELECT * FROM utilisateur WHERE login=:email AND password=:password",
//            resultClass = Utilisateurr.class),
        @NamedNativeQuery(name = "Utilisateur.findUtilisateurByLoginEmailAndPassword",
            query = "SELECT * FROM utilisateur WHERE login=:email AND password=:password",
            resultClass = Utilisateur.class)
})
public class Utilisateur extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UTILISATEUR_ID")
    private Long utilisateurId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "STATUT")
    private String statut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 30)
    @Column(name = "TEL_FIXE")
    private String telFixe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TEL_MOBILE")
    private String telMobile;
    @Size(max = 20)
    @Column(name = "CODE_POSTALE")
    private String codePostale;
    @Size(max = 100)
    @Column(name = "COMPLEMENT")
    private String complement;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "DATE_ADDED")
//    @Temporal(TemporalType.DATE)
//    private Date dateAdded;
    @Size(max = 255)
    @Column(name = "PATH_DLE")
    private String pathDle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 255)
    @Column(name = "SESSION_ID")
    private String sessionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "VILLE")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NUM_VOIE_TYPE_VOIE_LIBELLE_VOIE")
    private String numVoieTypeVoieLibelleVoie;

//  @OneToMany(mappedBy = "utiUtilisateurId")
//  private Collection<Commande> commandeCollection;
//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurId")
//  private Collection<Commande> commandeCollection1;
//  @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateurId")
//  private Collection<Message> messageCollection;

    public Utilisateur() {
    }

    public Utilisateur(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Utilisateur(Long utilisateurId, String nom, String username, String statut, String login, String password, String telMobile, //Date dateAdded, 
            String pays, String ville, String numVoieTypeVoieLibelleVoie) {
        this.utilisateurId = utilisateurId;
        this.nom = nom;
        this.username = username;
        this.statut = statut;
        this.login = login;
        this.password = password;
        this.telMobile = telMobile;
//        this.dateAdded = dateAdded;
        this.pays = pays;
        this.ville = ville;
        this.numVoieTypeVoieLibelleVoie = numVoieTypeVoieLibelleVoie;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelFixe() {
        return telFixe;
    }

    public void setTelFixe(String telFixe) {
        this.telFixe = telFixe;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

//    public Date getDateAdded() {
//        return dateAdded;
//    }
//
//    public void setDateAdded(Date dateAdded) {
//        this.dateAdded = dateAdded;
//    }

    public String getPathDle() {
        return pathDle;
    }

    public void setPathDle(String pathDle) {
        this.pathDle = pathDle;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNumVoieTypeVoieLibelleVoie() {
        return numVoieTypeVoieLibelleVoie;
    }

    public void setNumVoieTypeVoieLibelleVoie(String numVoieTypeVoieLibelleVoie) {
        this.numVoieTypeVoieLibelleVoie = numVoieTypeVoieLibelleVoie;
    }

//    @XmlTransient
//    public Collection<Commande> getCommandeCollection() {
//        return commandeCollection;
//    }
//
//    public void setCommandeCollection(Collection<Commande> commandeCollection) {
//        this.commandeCollection = commandeCollection;
//    }
//
//    @XmlTransient
//    public Collection<Commande> getCommandeCollection1() {
//        return commandeCollection1;
//    }
//
//    public void setCommandeCollection1(Collection<Commande> commandeCollection1) {
//        this.commandeCollection1 = commandeCollection1;
//    }
//
//    @XmlTransient
//    public Collection<Message> getMessageCollection() {
//        return messageCollection;
//    }
//
//    public void setMessageCollection(Collection<Message> messageCollection) {
//        this.messageCollection = messageCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (utilisateurId != null ? utilisateurId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.utilisateurId == null && other.utilisateurId != null) || (this.utilisateurId != null && !this.utilisateurId.equals(other.utilisateurId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+ utilisateurId ;
    }
    
}
