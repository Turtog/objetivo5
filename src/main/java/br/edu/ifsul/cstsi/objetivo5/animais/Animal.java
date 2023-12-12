package br.edu.ifsul.cstsi.objetivo5.animais;

import br.edu.ifsul.cstsi.objetivo5.model.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Animal")
@Table(name = "animais")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_animal;
    private int idade_animal;
    private int sexo_animal;

    @ManyToOne
    private Cliente cliente;

    @Override
    public String toString() {
        return "\nAnimal{" +
                "id=" + id +
                ", nome_animal='" + nome_animal + '\'' +
                ", idade_animal=" + idade_animal +
                ", sexo_animal=" + sexo_animal +
                '}';
    }
}
