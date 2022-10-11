package br.com.ifood.ifoodapi.controller;

import br.com.ifood.ifoodapi.entity.Restaurante;
import br.com.ifood.ifoodapi.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private RestauranteService restauranteService = new RestauranteService();

    public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.restauranteService.salvar(restaurante));
    }
}
