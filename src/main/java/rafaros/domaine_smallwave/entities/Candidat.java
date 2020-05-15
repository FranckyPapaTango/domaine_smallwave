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
@Table(name = "candidat", catalog = "smallwave", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidat.findAll", query = "SELECT c FROM Candidat c")
    , @NamedQuery(name = "Candidat.findByIdCandidat", query = "SELECT c FROM Candidat c WHERE c.idCandidat = :idCandidat")
    , @NamedQuery(name = "Candidat.findByNom", query = "SELECT c FROM Candidat c WHERE c.nom = :nom")
    , @NamedQuery(name = "Candidat.findByPrenom", query = "SELECT c FROM Candidat c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Candidat.findByAdresse", query = "SELECT c FROM Candidat c WHERE c.adresse = :adresse")
    , @NamedQuery(name = "Candidat.findByPays", query = "SELECT c FROM Candidat c WHERE c.pays = :pays")
    , @NamedQuery(name = "Candidat.findByLastfonct", query = "SELECT c FROM Candidat c WHERE c.lastfonct = :lastfonct")
    , @NamedQuery(name = "Candidat.findByStudlevel", query = "SELECT c FROM Candidat c WHERE c.studlevel = :studlevel")
    , @NamedQuery(name = "Candidat.findByDiplomtitle", query = "SELECT c FROM Candidat c WHERE c.diplomtitle = :diplomtitle")
    , @NamedQuery(name = "Candidat.findByEmail", query = "SELECT c FROM Candidat c WHERE c.email = :email")
    , @NamedQuery(name = "Candidat.findByPhone", query = "SELECT c FROM Candidat c WHERE c.phone = :phone")
    , @NamedQuery(name = "Candidat.findBySexe", query = "SELECT c FROM Candidat c WHERE c.sexe = :sexe")
    , @NamedQuery(name = "Candidat.findByPathDle", query = "SELECT c FROM Candidat c WHERE c.pathDle = :pathDle")})
public class Candidat extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CANDIDAT")
    private Long idCandidat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 255)
    @Column(name = "ADRESSE")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAYS")
    private String pays;
    @Size(max = 50)
    @Column(name = "LASTFONCT")
    private String lastfonct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STUDLEVEL")
    private String studlevel;
    @Size(max = 50)
    @Column(name = "DIPLOMTITLE")
    private String diplomtitle;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEXE")
    private String sexe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PATH_DLE")
    private String pathDle;

    public Candidat() {
    }

    public Candidat(Long idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Candidat(Long idCandidat, String nom, String prenom, String pays, String studlevel, String email, String sexe, String pathDle) {
        this.idCandidat = idCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.studlevel = studlevel;
        this.email = email;
        this.sexe = sexe;
        this.pathDle = pathDle;
    }

    public Long getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(Long idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getLastfonct() {
        return lastfonct;
    }

    public void setLastfonct(String lastfonct) {
        this.lastfonct = lastfonct;
    }

    public String getStudlevel() {
        return studlevel;
    }

    public void setStudlevel(String studlevel) {
        this.studlevel = studlevel;
    }

    public String getDiplomtitle() {
        return diplomtitle;
    }

    public void setDiplomtitle(String diplomtitle) {
        this.diplomtitle = diplomtitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPathDle() {
        return pathDle;
    }

    public void setPathDle(String pathDle) {
        this.pathDle = pathDle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidat != null ? idCandidat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
        if ((this.idCandidat == null && other.idCandidat != null) || (this.idCandidat != null && !this.idCandidat.equals(other.idCandidat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rafaros.domaine_smallwave.entities.Candidat[ idCandidat=" + idCandidat + " ]";
    }
    
}
