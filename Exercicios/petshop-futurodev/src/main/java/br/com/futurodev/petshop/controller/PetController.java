package br.com.futurodev.petshop.controller;


import br.com.futurodev.petshop.entity.Pet;
import br.com.futurodev.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet salvar(@RequestBody Pet pet){
        return petService.salvar(pet);
    }

    @GetMapping
    public List<Pet> listar(){
        return petService.buscarPets();
    }

    @GetMapping("/{id}")
    public Pet buscarPorId(Integer id){
        return petService.listarPorId(id);
    }

    @PutMapping
    public Pet atualizar(@RequestBody Pet pet){
        return petService.salvar(pet);
    }

    @DeleteMapping
    public void delete(@RequestBody Pet pet){
        petService.excluir(pet.getId());
    }

}
