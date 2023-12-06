package br.edu.ifsul.cstsi.objetivo5.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Consulta")
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dat_con;
    private String historico;
    @ManyToOne
    @JoinColumn(name = "tratamento_id", referencedColumnName = "id")
    private Tratamento tratamento;
}
