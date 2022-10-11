package br.com.ifood.ifoodapi.service;

import br.com.ifood.ifoodapi.entity.Mercado;
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
