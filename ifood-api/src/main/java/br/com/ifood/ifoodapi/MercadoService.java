package br.com.ifood.ifoodapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MercadoService {

    private List<Mercado> mercados = new ArrayList<>();

    public List<Mercado> listar() {
        return this.mercados;
    }

    public Mercado buscar(Integer index) {
        Mercado mercado = null;
        try {
            mercado = this.mercados.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return mercado;
    }

    public void salvar(Mercado mercado) {
        this.mercados.add(mercado);
    }

}
