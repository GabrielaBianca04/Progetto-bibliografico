package DAO;

import Entities.Prestito;
import Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }


    public List<Prestito> findDocumentoPrestatoByUtente(Utente utente) {
       return em.createNamedQuery("findDocumentoPrestatoByUtente",Prestito.class).getResultList();
    }

    public List<Prestito> getPrestitoScaduto(Boolean scaduto){

        try {
            TypedQuery<Prestito> q = em.createQuery("SELECT 1 FROM Prestito 1 WHERE 1.scaduto = :scaduto", Prestito.class);
            q.setParameter("Prestiti scaduti", scaduto);
            return q.getResultList();
        } catch (Exception e) {
            System.err.println("Errore durante il recupero dei prestiti." + e);
            throw e;
        }
    }

    public Prestito getById(int id) {
        return em.find(Prestito.class, id);
    }
}
