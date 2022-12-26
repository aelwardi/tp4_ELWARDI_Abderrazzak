
package ma.elwardi.tp4_elwardi_abderrazzak.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import ma.elwardi.tp4_elwardi_abderrazzak.ejb.GestionnaireCompte;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;

/**
 *
 * @author Heisenberg
 */
@Named(value = "ajout")
@Dependent
public class AjoutCompte {

    @EJB
    private GestionnaireCompte gestionnaireCompte;
    
    private String nom;
    private int solde;
    
    public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getSolde() {
    return solde;
  }

  public void setSolde(int solde) {
    this.solde = solde;
  }

  public String creer() {
    gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
    return "listeComptes?faces-redirect=true";
  }
}
