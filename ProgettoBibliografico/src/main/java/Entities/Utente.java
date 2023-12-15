package Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class Utente {
    @Column(name="Nome")
    private String nome;
    @Column(name="DataNascita")
    private LocalDate dataNascita;
    @Id
    @GeneratedValue
    private long numeroTessera;

    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }
    public void setNumeroTessera(long numeroTessera) {
        numeroTessera = numeroTessera;
    }

    @OneToMany
    public Utente(String nome,LocalDate dataNascita,long numeroTessera) {
        this.nome = nome;
        this.dataNascita= dataNascita;
        this.numeroTessera= numeroTessera;
    }
}
