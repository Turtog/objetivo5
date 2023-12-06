package br.edu.ifsul.cstsi.objetivo5.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_cli;
    private String end_cli;
    private String tel_cli;
    private Long cep_cli;
    private String email_cli;
    @OneToMany(mappedBy = "cliente")
    private List<Animal> animais;
}
