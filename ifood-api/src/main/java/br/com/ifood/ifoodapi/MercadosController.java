package br.com.ifood.ifoodapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mercados")
public class MercadosController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public List<Mercado> listarMercados() {
        return this.mercadoService.listar();
    }

    @GetMapping("/{index}")
    public ResponseEntity<MercadoDto> buscar(@PathVariable Integer index) {
        Mercado mercado = this.mercadoService.buscar(index);

        if(mercado == null) {
            return ResponseEntity.notFound().build();
        }

        MercadoDto mercadoDto = new MercadoDto(mercado.getNome());
        return ResponseEntity.ok(mercadoDto);
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Mercado mercado) {
        this.mercadoService.salvar(mercado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
