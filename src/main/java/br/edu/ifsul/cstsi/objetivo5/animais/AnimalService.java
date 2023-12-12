package br.edu.ifsul.cstsi.objetivo5.animais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository rep;

    public List<Animal> getAnimais() {
        return rep.findAll();
    }

    public Animal getAnimalById(Long id) {
        Optional<Animal> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Animal> getAnimaisByNome(String nome) {
        return new ArrayList<>(rep.findByNome_animal(nome + "%"));
    }

    public Animal insert(Animal animal) {
        Assert.isNull(animal.getId(), "Não foi possível inserir o registro");

        Optional<Animal> optional = rep.findById(animal.getId());
        if (optional.isPresent()) {
            Animal db = optional.get();
            db.setNome_animal(animal.getNome_animal());
            db.setIdade_animal(animal.getIdade_animal());
            db.setSexo_animal(animal.getSexo_animal());
            return rep.save(db);
        } else {
            return rep.save(animal);
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }

}
