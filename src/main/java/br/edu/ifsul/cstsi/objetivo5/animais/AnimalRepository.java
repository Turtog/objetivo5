package br.edu.ifsul.cstsi.objetivo5.animais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

    @Query(value = "SELECT c FROM Animal c where c.nome_animal like ?1")
    List<Animal> findByNome_animal(String nome_animal);
}
