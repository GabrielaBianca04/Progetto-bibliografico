package DAO;

import Entities.Documento;
import Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Utente x) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(x);
            transaction.commit();
            System.out.println("Utente salvatao correttamente: " + x);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'utente" + e);
            throw e;
        }
    }

    public Utente deleteUtenteByNumeroTessera(long numeroTessera) {
        Documento x = em.find(Documento.class, numeroTessera);
        if (x != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(x);
                transaction.commit();
                System.out.println("Utente eliminato correttamente: " + x);
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Errore durante l'eliminazione dell'utente." + e);
                throw e;
            }

            public Utente getByNumeroTessera(long numeroTessera){
                return em.find(Utente.class, numeroTessera);
            }
        }
    }
}
