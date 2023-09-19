package br.com.leandrobezerradasilva.backend.services.operacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.operacoes.EntradaProduto;
import br.com.leandrobezerradasilva.backend.repositories.operacoes.EntradaProdutoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.EntradaProdutoService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class EntradaProdutoServiceImpl implements EntradaProdutoService {

    @Autowired
    private EntradaProdutoRepository entradaProdutoRepository;

    @Override
    public EntradaProduto save(EntradaProduto tipo) {
        EntradaProduto entradaProduto = entradaProdutoRepository.save(tipo);
        return entradaProduto;
    }

    @Override
    public List<EntradaProduto> findAll() {
        List<EntradaProduto> entradaProdutoList = entradaProdutoRepository.findAll();
        return entradaProdutoList;
    }

    @Override
    public EntradaProduto findById(Long id) {
        EntradaProduto entradaProduto = entradaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        "Não foi possível encontrar a Entrada de produto com o Id: " + id));
        return entradaProduto;
    }

    @Override
    public EntradaProduto update(EntradaProduto tipo) {
        EntradaProduto entradaProduto = findById(tipo.getId());
        entradaProduto.setProduto(tipo.getProduto());
        entradaProduto.setQuantidade(tipo.getQuantidade());
        EntradaProduto entradaProdutoUpdate = entradaProdutoRepository.save(entradaProduto);
        return entradaProdutoUpdate;
    }

    @Override
    public void deleteById(Long id) {
        EntradaProduto entradaProduto = findById(id);
        entradaProdutoRepository.deleteById(entradaProduto.getId());
    }

}
