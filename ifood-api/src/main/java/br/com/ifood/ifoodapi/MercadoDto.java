package br.com.ifood.ifoodapi;

public class MercadoDto {
    private String nome;

    public MercadoDto (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
