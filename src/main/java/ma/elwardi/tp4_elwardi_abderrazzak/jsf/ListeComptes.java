
package ma.elwardi.tp4_elwardi_abderrazzak.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import ma.elwardi.tp4_elwardi_abderrazzak.ejb.GestionnaireCompte;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;


@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {
    private List<CompteBancaire> ListeComptes;
    
    @EJB
    private GestionnaireCompte gc;
    
    public ListeComptes() {
    }
    
    public List<CompteBancaire> getAllComptes(){
        if(ListeComptes != null){
            ListeComptes = gc.getAllComptes();
        }
        return ListeComptes;
    }
}
