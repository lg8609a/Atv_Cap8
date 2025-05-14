package br.com.fiap.AtvCap8.controller;

import br.com.fiap.AtvCap8.dto.CandidatoDTO;
import br.com.fiap.AtvCap8.model.Candidato;
import br.com.fiap.AtvCap8.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
