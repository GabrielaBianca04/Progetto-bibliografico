package Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@NamedQuery(name = "findDocumentoPrestatoByUtente", query = "SELECT documentoPrestato FROM Prestito x WHERE x.utente=x.utente")
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    @JoinColumn(name = "Utente_numeroTessera", referencedColumnName = "numeroTessera", nullable = false)
    private Utente utente;
   @OneToMany
   @JoinColumn(name = "Documento_codiceISBN", referencedColumnName = "codiceISBN", nullable = false)
    private Documento documentoPrestato;
    @Column(name = "DataInizio")
    private LocalDate dataInizio;
    @Column(name = "DataFinePrevvista")
    private LocalDate dataFinePrevvista;
    @Column(name = "DataRestituzione")
    private LocalDate dataRestituzione;

    private boolean scaduto;

    public Entities.Utente getUtente() {
        return utente;
    }

    public void setUtente(Entities.Utente utente) {
        utente = utente;
    }

    public void setScaduto(boolean scaduto) {
        this.scaduto = false;
    }

    public Documento getDocumentoPrestato() {
        return documentoPrestato;
    }

    public void setDocumentoPrestato(Documento documentoPrestato) {
        documentoPrestato = documentoPrestato;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        dataInizio = dataInizio;
    }

    public LocalDate getDataFinePrevvista() {
        return dataFinePrevvista;
    }

    public void setDataFinePrevvista(LocalDate dataFinePrevvista) {
        dataFinePrevvista = dataFinePrevvista;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        dataRestituzione = dataRestituzione;
    }

    public Prestito(int id,Utente utente, Documento documentoPrestato, LocalDate dataInizio, LocalDate dataFinePrevvista, LocalDate dataResttituzione) {
        this.id=id;
        this.utente = utente;
        this.documentoPrestato = documentoPrestato;
        this.dataInizio = dataInizio;
        this.dataFinePrevvista = dataFinePrevvista;
        this.dataRestituzione = dataResttituzione;
    }

    public void PrestitoScaduto() {
        if (dataRestituzione == dataFinePrevvista.plus(31, ChronoUnit.DAYS)){
            System.out.println("Prestito scaduto");
            this.scaduto=true;
        }
    }
}
