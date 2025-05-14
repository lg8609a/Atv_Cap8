package br.com.fiap.AtvCap8.controller;

import br.com.fiap.AtvCap8.dto.VagaDTO;
import br.com.fiap.AtvCap8.model.Vaga;
import br.com.fiap.AtvCap8.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public ResponseEntity<Vaga> criar(@RequestBody VagaDTO dto) {
        return ResponseEntity.ok(vagaService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        return ResponseEntity.ok(vagaService.listarTodas());
    }
}