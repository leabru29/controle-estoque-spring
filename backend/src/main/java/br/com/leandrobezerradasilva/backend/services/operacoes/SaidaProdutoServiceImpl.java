package br.com.leandrobezerradasilva.backend.services.operacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.operacoes.SaidaProduto;
import br.com.leandrobezerradasilva.backend.repositories.operacoes.SaidaProdutoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.SaidaProdutoService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class SaidaProdutoServiceImpl implements SaidaProdutoService {

    @Autowired
    private SaidaProdutoRepository saidaProdutoRepository;

    @Override
    public SaidaProduto save(SaidaProduto tipo) {
        return saidaProdutoRepository.save(tipo);
    }

    @Override
    public List<SaidaProduto> findAll() {
        return saidaProdutoRepository.findAll();
    }

    @Override
    public SaidaProduto findById(Long id) {
        return saidaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Não encontrada a saída com o Id: " + id));
    }

    @Override
    public SaidaProduto update(SaidaProduto tipo) {
        SaidaProduto saidaProduto = findById(tipo.getId());
        saidaProduto.setProduto(tipo.getProduto());
        saidaProduto.setQuantidade(tipo.getQuantidade());
        saidaProduto.setData_saida(tipo.getData_saida());
        SaidaProduto updateSaidaProduto = saidaProdutoRepository.save(saidaProduto);
        return updateSaidaProduto;
    }

    @Override
    public void deleteById(Long id) {
        SaidaProduto saidaProduto = findById(id);
        saidaProdutoRepository.deleteById(saidaProduto.getId());
    }

}
