package br.com.ifood.ifoodapi.controller;

import br.com.ifood.ifoodapi.entity.Mercado;
import br.com.ifood.ifoodapi.dto.MercadoDto;
import br.com.ifood.ifoodapi.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public ResponseEntity<List<MercadoDto>> listarMercados() {

        List<MercadoDto> mercadosDto = new ArrayList<>();

        List<Mercado> mercados = this.mercadoService.listar();

        if(!mercados.isEmpty() || mercados != null) {
            for(Mercado mercado:mercados) {
                mercadosDto.add(new MercadoDto(mercado.getNome()));
            }
        }

        return ResponseEntity.ok(mercadosDto);
    }

    @GetMapping("/{index}")
    public ResponseEntity<MercadoDto> buscar(@PathVariable Integer index) {
        Mercado mercado = this.mercadoService.buscar(index);

        if(mercado == null) {
            return ResponseEntity.notFound().build();
        }

        MercadoDto mercadoDto = new MercadoDto(mercado.getNome());
        return ResponseEntity.status(HttpStatus.OK).body(mercadoDto);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Mercado mercado) {
        this.mercadoService.salvar(mercado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
