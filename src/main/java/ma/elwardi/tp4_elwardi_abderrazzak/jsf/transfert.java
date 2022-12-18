package ma.elwardi.tp4_elwardi_abderrazzak.jsf;

import ma.elwardi.tp4_elwardi_abderrazzak.ejb.GestionnaireCompte;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.inject.Named;
import jakarta.faces.bean.RequestScoped;

/**
 * Backing bean pour la page transfert.xhtml.
 *
 * @author grin
 */
@Named(value = "transfert")
@RequestScoped
public class transfert {

    @EJB
    private GestionnaireCompte gestionnaireCompte;

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

        CompteBancaire source = gestionnaireCompte.findById(idSource);
        if (source == null) {
            erreur = true;
        } else {
        }

        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (destination == null) {
            erreur = true;
        }

        if (erreur) {
            return null;
        }

        try {
            gestionnaireCompte.transferer(source, destination, montant);
        } catch (EJBTransactionRolledbackException ex) {
            return null;
        }
        return null;
    }
}
