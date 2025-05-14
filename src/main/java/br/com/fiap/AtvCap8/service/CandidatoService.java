package br.com.fiap.AtvCap8.service;

import br.com.fiap.AtvCap8.dto.CandidatoDTO;
import br.com.fiap.AtvCap8.model.Candidato;
import br.com.fiap.AtvCap8.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato salvar(CandidatoDTO dto) {
        Candidato candidato = new Candidato(null, dto.getNome(), dto.getEmail(), dto.isMarcadorDiversidade());
        return candidatoRepository.save(candidato);
    }

    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }
}
