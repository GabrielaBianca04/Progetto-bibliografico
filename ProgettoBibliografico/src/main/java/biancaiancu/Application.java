package biancaiancu;

import DAO.DocumentoDAO;
import DAO.PrestitoDAO;
import Entities.Documento;
import Entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoBibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        try {
        DocumentoDAO documentoDAO = new DocumentoDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        Documento documento1 = documentoDAO.getByISBN(123456789);
        Prestito p1 = prestitoDAO.getById(2);
       Prestito p2 = prestitoDAO.getById(3);


    }
        catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
            emf.close();
        }
    }
}
