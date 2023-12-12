package br.edu.ifsul.cstsi.objetivo5.model;

import br.edu.ifsul.cstsi.objetivo5.animais.Animal;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "Tratamento")
@Table(name = "tratamentos")
public class Tratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dat_ini;
    private Date dat_fin;
    @ManyToOne
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;
    @OneToMany(mappedBy = "tratamento")
    private List<Consulta> consultas;
}
