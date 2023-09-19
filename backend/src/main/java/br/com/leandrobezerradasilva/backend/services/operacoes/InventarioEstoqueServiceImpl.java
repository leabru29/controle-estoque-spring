package br.com.leandrobezerradasilva.backend.services.operacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.operacoes.InventarioEstoque;
import br.com.leandrobezerradasilva.backend.repositories.operacoes.InventarioEstoqueRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.InventarioEstoqueService;
import br.com.leandrobezerradasilva.backend.services.exceptions.EntidadeNaoEncontradaException;

@Service
public class InventarioEstoqueServiceImpl implements InventarioEstoqueService {

    @Autowired
    private InventarioEstoqueRepository inventarioEstoqueRepository;

    @Override
    public InventarioEstoque save(InventarioEstoque tipo) {
        return inventarioEstoqueRepository.save(tipo);
    }

    @Override
    public List<InventarioEstoque> findAll() {
        List<InventarioEstoque> list = inventarioEstoqueRepository.findAll();
        return list;
    }

    @Override
    public InventarioEstoque findById(Long id) {
        return inventarioEstoqueRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inventario não encontrado com o Id: " + id));
    }

    @Override
    public InventarioEstoque update(InventarioEstoque tipo) {
        InventarioEstoque inventarioEstoque = findById(tipo.getId());
        InventarioEstoque inventarioEstoqueAtualizado = inventarioEstoqueRepository.save(inventarioEstoque);
        return inventarioEstoqueAtualizado;
    }

    @Override
    public void deleteById(Long id) {
        InventarioEstoque inventarioEstoque = findById(id);
        inventarioEstoqueRepository.deleteById(inventarioEstoque.getId());
    }

}
