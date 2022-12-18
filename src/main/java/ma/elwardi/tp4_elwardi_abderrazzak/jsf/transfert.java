package ma.elwardi.tp4_elwardi_abderrazzak.jsf;

import ma.elwardi.tp4_elwardi_abderrazzak.ejb.GestionnaireCompte;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.inject.Named;
import jakarta.faces.bean.RequestScoped;
import ma.elwardi.tp4_elwardi_abderrazzak.jsf.util.Util;

/**
 * Backing bean pour la page transfert.xhtml.
 *
 * @author grin
 */
@Named(value = "transfert")
@RequestScoped
public class transfert {

    @EJB
    private GestionnaireCompte gc;

    private long idSource;
    private long idDestination;
    private int montant;

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long id) {
        this.idSource = id;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long id) {
        this.idDestination = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String enregistrer() {
        boolean erreur = false;

        CompteBancaire source = gc.findById(idSource);
        if (source == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:source");
            erreur = true;
        } else {
        }

        CompteBancaire destination = gc.findById(idDestination);
        if (destination == null) {
            Util.messageErreur("Aucun compte avec cet id !", "Aucun compte avec cet id !", "form:destination");
            erreur = true;
        }

        if (erreur) {
            return null;
        }

        try {
            gc.transferer(source, destination, montant);
            Util.addFlashInfoMessage("Transfert de " + source.getNom() + " vers "
                    + destination.getNom()
                    + " pour un montant de " + montant + " correctement effectué");
            return "listeComptes?faces-redirect=true";
        } catch (EJBTransactionRolledbackException ex) {
            Util.messageErreur(ex.getMessage(), ex.getMessage(), "form:montant");
            return null;
        }
    }
}
