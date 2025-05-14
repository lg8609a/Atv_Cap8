package br.com.fiap.AtvCap8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_candidato")
    @SequenceGenerator(name = "seq_candidato", sequenceName = "seq_candidato", allocationSize = 1)
    private Long id;

    private String nome;

    private String email;

    private boolean marcadorDiversidade;


}
