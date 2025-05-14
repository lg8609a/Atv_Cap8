package br.com.fiap.AtvCap8.service;

import br.com.fiap.AtvCap8.dto.VagaDTO;
import br.com.fiap.AtvCap8.model.Vaga;
import br.com.fiap.AtvCap8.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga salvar(VagaDTO dto) {
        Vaga vaga = new Vaga(null, dto.getTitulo(), dto.getDescricao(), dto.isInclusiva());
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }
}