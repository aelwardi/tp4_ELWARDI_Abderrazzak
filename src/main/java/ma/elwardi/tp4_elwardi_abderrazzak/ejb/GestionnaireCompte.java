package ma.elwardi.tp4_elwardi_abderrazzak.ejb;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import ma.elwardi.tp4_elwardi_abderrazzak.entities.CompteBancaire;

@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "Aa77441100", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true"
        }
)
@Stateless
public class GestionnaireCompte {

    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    public long nbComptes() {
        TypedQuery<Long> query = em.createQuery("select count(c) from CompteBancaire as c", Long.class);
        return query.getSingleResult();
    }

    public List<CompteBancaire> getAllComptes() {
        TypedQuery<CompteBancaire> query = em.createQuery("select cb from CompteBancaire as cb", CompteBancaire.class);
        return query.getResultList();
    }

    public void creerCompte(CompteBancaire compteBancaire) {
        em.persist(compteBancaire);
    }
}
