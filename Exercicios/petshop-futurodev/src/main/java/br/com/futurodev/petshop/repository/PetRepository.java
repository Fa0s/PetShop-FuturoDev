package br.com.futurodev.petshop.repository;


import br.com.futurodev.petshop.entity.Pet;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PetRepository {

    private static int i = 1;
    private static List<Pet> pets = new ArrayList<>();

    private int gerarid(){
        return i++;
    }
    public Pet salvar(Pet pet){
        if(pet.getId() == null){
            pet.setId(gerarid());
        } else {
            deletar(pet.getId());
        }
        //try
        return pet;
    }
    public Pet listarPorId(Integer id){
        if(id == null)
            return null;
        for(Pet pet : pets){
            if(id.equals(pet.getId())){
                return pet;
            }
        }
        return null;
    }
    public List<Pet> listarPets(){
        return pets;
    }
    public void deletar(Integer id){
            Pet petSelecionado = listarPorId(id);
            pets.remove(petSelecionado);
    }
}

