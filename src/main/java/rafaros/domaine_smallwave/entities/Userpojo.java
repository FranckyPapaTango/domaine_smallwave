/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rafaros.domaine_smallwave.entities;

//import javax.persistence.Basic;
//import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author BigWave
 *///image de l'entity client (possede les mêmes attributs sans les contraintes de validations et d'associations)
public class Userpojo {

    private Long id;

    @NotNull(message = "Field 'nom' cannot be empty (le champ 'nom' ne peut être vide)")
    @Size(min = 1, max = 300)
    private String nom;

    @NotEmpty(message = "Field 'username' cannot be empty (le champ 'username' ne peut être vide)")
    private String username;

    @NotEmpty(message = "Field 'statut' cannot be empty (le champ 'statut' ne peut être vide)")
    private String statut;

    @Size(min = 6, max = 300)
    @NotEmpty(message = "Field 'login email' cannot be empty (le champ 'login email' ne peut être vide)")
    @Email(message = "Enter a valid email (entrez un email valide)")
    private String login;

    @Size(min = 6, max = 300)
    @NotEmpty(message="Field 'password' cannot be empty (le champ 'password' ne peut être vide)")
    private String password;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Userpojo() {
    }

    public Userpojo(Long id, String nom, String username, String statut, String login, String password) {
        this.id = id;
        this.nom = nom;
        this.username = username;
        this.statut = statut;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Userpojo{" + "email=" + login + ", password=" + password + '}';
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package mgw.domaine_lavage_auto.entities;
//
//import javax.persistence.Basic;
//import javax.persistence.Column;
////import javax.validation.constraints.NotNull;
////import javax.validation.constraints.Size;
////import org.hibernate.validator.constraints.Email;
////import org.hibernate.validator.constraints.NotEmpty;
////import javax.validation.constraints.Email;
////import javax.validation.constraints.NotEmpty;
//
///**
// *
// * @author BigWave
// *///image de l'entity client (possede les mêmes attributs sans les contraintes de validations et d'associations)
//public class Userpojo {
//
//    private Long id;
//
//    //     @NotNull(message = "Field 'nom' cannot be empty (le champ 'nom' ne peut être vide)")
//    //    @Size(min = 1, max = 30)
//    private String nom;
//
//    //    @NotEmpty(message = "Field 'username' cannot be empty (le champ 'username' ne peut être vide)")
//    private String username;
//
//    //    @NotEmpty(message = "Field 'statut' cannot be empty (le champ 'statut' ne peut être vide)")
//    private String statut;
//
//    //    @Size(min = 6, max = 30)
//    //    @NotEmpty(message = "Field 'login email' cannot be empty (le champ 'login email' ne peut être vide)")
//    //    @Email(message = "Enter a valid email (entrez un email valide)")
//    private String login;
//
//    //    @NotEmpty(message="Field 'password' cannot be empty (le champ 'password' ne peut être vide)")
//    private String password;
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getStatut() {
//        return statut;
//    }
//
//    public void setStatut(String statut) {
//        this.statut = statut;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Userpojo() {
//    }
//
//    public Userpojo(Long id, String nom, String username, String statut, String login, String password) {
//        this.id = id;
//        this.nom = nom;
//        this.username = username;
//        this.statut = statut;
//        this.login = login;
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "Userpojo{" + "email=" + login + ", password=" + password + '}';
//    }
//
//}
