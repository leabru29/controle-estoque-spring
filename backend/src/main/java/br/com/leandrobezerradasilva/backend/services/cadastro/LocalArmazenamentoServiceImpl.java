package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.LocalArmazenamento;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.LocalArmazenamentoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.LocalArmazenamentoService;

@Service
public class LocalArmazenamentoServiceImpl implements LocalArmazenamentoService {

    @Autowired
    private LocalArmazenamentoRepository localArmazenamentoRepository;

    @Override
    public LocalArmazenamento save(LocalArmazenamento tipo) {

        return localArmazenamentoRepository.save(tipo);
    }

    @Override
    public List<LocalArmazenamento> findAll() {

        return localArmazenamentoRepository.findAll();
    }

    public LocalArmazenamento findById(UUID id) {

        Optional<LocalArmazenamento> localOptional = localArmazenamentoRepository.findById(id);

        return localOptional.get();
    }

    @Override
    public LocalArmazenamento update(LocalArmazenamento tipo) {
        LocalArmazenamento localArmazenamento = findById(tipo.getId());
        localArmazenamento.setNome_local(tipo.getNome_local());
        localArmazenamento.setAtivo(tipo.getAtivo());
        LocalArmazenamento localArmazenamentoAtualizado = localArmazenamentoRepository.save(localArmazenamento);
        return localArmazenamentoAtualizado;
    }

    @Override
    public void deleteById(UUID id) {
        LocalArmazenamento localArmazenamento = findById(id);

        UUID id_local = localArmazenamento.getId();
        localArmazenamentoRepository.deleteById(id_local);
    }

}
