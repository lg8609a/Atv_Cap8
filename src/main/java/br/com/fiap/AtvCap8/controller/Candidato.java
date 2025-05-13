package br.com.fiap.AtvCap8.controller;

import br.com.fiap.AtvCap8.dto.CandidatoDTO;
import br.com.fiap.AtvCap8.service.CandidatoService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private boolean marcadorDiversidade;

    @RestController
    @RequestMapping("/api/candidatos")
    public class CandidatoController {

        @Autowired
        private CandidatoService candidatoService;

        @PostMapping
        public ResponseEntity<Candidato> criar(@RequestBody CandidatoDTO dto) {
            return ResponseEntity.ok(candidatoService.salvar(dto));
        }

        @GetMapping
        public ResponseEntity<List<Candidato>> listar() {
            return ResponseEntity.ok(candidatoService.listarTodos());
        }
    }

}
