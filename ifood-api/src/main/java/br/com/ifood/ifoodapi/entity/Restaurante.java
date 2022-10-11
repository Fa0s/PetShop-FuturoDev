package br.com.ifood.ifoodapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurante {

    @Id
    private Long id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
