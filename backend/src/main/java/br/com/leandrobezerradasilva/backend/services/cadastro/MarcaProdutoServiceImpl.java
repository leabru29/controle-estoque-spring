package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.MarcaProduto;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.MarcaProdutoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.MarcaProdutoService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class MarcaProdutoServiceImpl implements MarcaProdutoService {

    @Autowired
    private MarcaProdutoRepository marcaProdutoRepository;

    @Override
    public MarcaProduto save(MarcaProduto tipo) {
        return marcaProdutoRepository.save(tipo);
    }

    @Override
    public List<MarcaProduto> findAll() {
        return marcaProdutoRepository.findAll();
    }

    @Override
    public MarcaProduto findById(Long id) {
        Optional<MarcaProduto> marcaProduto = marcaProdutoRepository.findById(id);
        return marcaProduto.orElseThrow(
                () -> new EntidadeNaoEncontradaException("Marca de Produto não encontrada com o Id: " + id));
    }

    @Override
    public MarcaProduto update(MarcaProduto tipo) {
        MarcaProduto marcaProduto = findById(tipo.getId());
        marcaProduto.setMarca(tipo.getMarca());
        marcaProduto.setAtivo(tipo.getAtivo());
        MarcaProduto marcaProdutoatualizado = marcaProdutoRepository.save(marcaProduto);
        return marcaProdutoatualizado;
    }

    @Override
    public void deleteById(Long id) {
        MarcaProduto marcaProduto = findById(id);
        Long id_marcaProduto = marcaProduto.getId();
        marcaProdutoRepository.deleteById(id_marcaProduto);
    }

}
