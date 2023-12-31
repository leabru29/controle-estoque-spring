package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.UnidadeMedida;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.UnidadeMedidaRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.UnidadeMedidaService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class UnidadeMedidaServiceImpl implements UnidadeMedidaService {

    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @Override
    public UnidadeMedida save(UnidadeMedida tipo) {
        return unidadeMedidaRepository.save(tipo);
    }

    @Override
    public List<UnidadeMedida> findAll() {
        return unidadeMedidaRepository.findAll();
    }

    @Override
    public UnidadeMedida findById(Long id) {
        Optional<UnidadeMedida> optionalUnidadeMedida = unidadeMedidaRepository.findById(id);
        return optionalUnidadeMedida.orElseThrow(
                () -> new EntidadeNaoEncontradaException("Unidade de Medida não encontrada com o Id: " + id));
    }

    @Override
    public UnidadeMedida update(UnidadeMedida tipo) {

        UnidadeMedida unidadeMedida = findById(tipo.getId());

        unidadeMedida.setNome_unidade(tipo.getNome_unidade());
        unidadeMedida.setSigla(tipo.getSigla());
        unidadeMedida.setAtivo(tipo.getAtivo());

        return unidadeMedidaRepository.save(unidadeMedida);
    }

    public void deleteById(Long id) {
        UnidadeMedida unidadeMedida = findById(id);
        unidadeMedidaRepository.deleteById(unidadeMedida.getId());
    }

}
