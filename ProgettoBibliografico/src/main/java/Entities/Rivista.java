package Entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Rivista extends Documento {
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;
    public Rivista(String codiceISBN, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità= periodicità;
    }
}
