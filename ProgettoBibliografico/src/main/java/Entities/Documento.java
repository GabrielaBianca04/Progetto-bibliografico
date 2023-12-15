package Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documenti")
public abstract class Documento {
    @Id
    @GeneratedValue
    private long codiceISBN;
    @Column(name="Titolo")
    private String titolo;
    @Column(name="AnnoPubblicazione")
    private LocalDate annoPubblicazione;
    @Column(name="NumeroPagine")
    private int numeroPagine;


    //GETTER-SETTER
    public long getCodiceISBN() {
        return codiceISBN;
    }
    public void setCodiceISBN(String codiceISBN) {
        codiceISBN = codiceISBN;}
    public String getTitolo() {
        return titolo;
    }
    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public int getNumeroPagine() {
        return numeroPagine;
    }

    @ManyToOne
    public Documento(long codiceISBN,String titolo,LocalDate annoPubblicazione,int numeroPagine) {
        this.codiceISBN= codiceISBN;
        this.titolo= titolo;
        this.annoPubblicazione= annoPubblicazione;
        this.numeroPagine= numeroPagine;
    }
}
