package br.com.futurodev.petshop.service;

import br.com.futurodev.petshop.entity.Pet;
import br.com.futurodev.petshop.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    public PetRepository petRepository;

    public Pet salvar(Pet pet){
        return petRepository.salvar(pet);
    }
    public List<Pet> buscarPets(){
        return petRepository.listarPets();
    }

    public Pet listarPorId (Integer id){
        return petRepository.listarPorId(id);
    }

    public void excluir(Integer id){
        petRepository.deletar(id);
    }
}
