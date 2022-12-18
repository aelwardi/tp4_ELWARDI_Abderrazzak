package ma.elwardi.tp4_elwardi_abderrazzak.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;

@Singleton
@Startup
public class Init {

    @EJB
    private GestionnaireCompte gc;

    @PostConstruct
    public void InitiCB() {
        if (gc.nbComptes() != 0) {
            return;
        }
        gc.creerCompte(new CompteBancaire("John Lennon", 150000));
        gc.creerCompte(new CompteBancaire("Paul McCartney", 950000));
        gc.creerCompte(new CompteBancaire("Ringo Starr", 20000));
        gc.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }
}
