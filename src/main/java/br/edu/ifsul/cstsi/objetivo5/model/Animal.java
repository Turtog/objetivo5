package br.edu.ifsul.cstsi.objetivo5.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Animal")
@Table(name = "animais")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_animal;
    private int idade_animal;
    private int sexo_animal;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    Cliente cliente;
    @OneToMany(mappedBy = "animal")
    private List<Tratamento> tratamentos;
}
