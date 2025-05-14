package br.com.fiap.AtvCap8.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vaga")
    @SequenceGenerator(name = "seq_vaga", sequenceName = "seq_vaga", allocationSize = 1)
    private Long id;

    private String titulo;
    private String descricao;
    private boolean inclusiva;
}