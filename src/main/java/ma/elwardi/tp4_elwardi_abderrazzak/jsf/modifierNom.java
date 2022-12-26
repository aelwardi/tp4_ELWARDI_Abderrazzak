package ma.elwardi.tp4_elwardi_abderrazzak.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import ma.elwardi.tp4_elwardi_abderrazzak.ejb.GestionnaireCompte;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;

/**
 *
 * @author Heisenberg
 */
@Named(value = "modifierNom")
@ViewScoped
public class modifierNom implements Serializable {

    public modifierNom() {
    }

    @EJB
    private GestionnaireCompte gestionnaireCompte;

    private Long id;
    private CompteBancaire compte;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setMontant(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void loadCompte() {
        compte = gestionnaireCompte.findById(id);
    }

    public String enregistrer() {
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Nouveau nom enregistré : " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
