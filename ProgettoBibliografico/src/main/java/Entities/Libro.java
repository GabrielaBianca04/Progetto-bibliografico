package Entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
@Entity
public class Libro extends Documento {

    @Column(name="autore")
    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public String getAutore() {
        return autore;
    }

    public Genere getGenere() {
        return genere;
    }
    public void setGenere(Genere genere) {
        this.genere = genere;
    }


    public Libro(String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore= autore;
        this.genere= genere;
    }
}
