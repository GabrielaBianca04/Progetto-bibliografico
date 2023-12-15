package DAO;

import Entities.Documento;
import Entities.Genere;
import Entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class DocumentoDAO {
    private final EntityManager em;

    public DocumentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Documento x) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(x);
            transaction.commit();
            System.out.println("Documento salvatao correttamente: " + x);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio del documento" + e);
            throw e;
        }
    }

    public Documento getByISBN(long codiceISBN) {
        return em.find(Documento.class, codiceISBN);
    }
    public Documento findByISBN(long codiceISBN) {
        return em.find(Documento.class, codiceISBN);
    }

    public Documento findByAnnoPubblicazione(LocalDate annoPubblicazione) {
        return em.find(Documento.class, annoPubblicazione);
    }

    public Documento findByTitolo(String titolo) {
        return em.find(Documento.class, titolo);
    }

    public Libro findByAutore(String autore) {
        return em.find(Libro.class, autore);
    }

    public void deleteDocumentoByISBN(String codiceISBN) {
        Documento x = em.find(Documento.class, codiceISBN);
        if (x != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(x);
                transaction.commit();
                System.out.println("Documento eliminato correttamente: " + x);
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Errore durante l'eliminazione dell'Evento." + e);
                throw e;
            }
        }
    }
}



