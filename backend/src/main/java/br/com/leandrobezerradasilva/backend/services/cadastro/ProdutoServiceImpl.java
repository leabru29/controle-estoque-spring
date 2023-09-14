package br.com.leandrobezerradasilva.backend.services.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.Produto;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.ProdutoRepository;
import br.com.leandrobezerradasilva.backend.services.contracts.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto tipo) {
        return produtoRepository.save(tipo);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {

        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        return optionalProduto.get();

    }

    @Override
    public Produto update(Produto tipo) {

        Produto produto = findById(tipo.getId());

        produto.setCodigo(tipo.getCodigo());
        produto.setNome(tipo.getNome());
        produto.setPreco(tipo.getPreco());
        produto.setQuantidade_estoque(tipo.getQuantidade_estoque());
        produto.setAtivo(tipo.getAtivo());
        produto.setFornecedor(tipo.getFornecedor());
        produto.setGrupoProduto(tipo.getGrupoProduto());
        produto.setLocalArmazenamento(tipo.getLocalArmazenamento());
        produto.setMarcaProduto(tipo.getMarcaProduto());
        produto.setUnidadeMedida(tipo.getUnidadeMedida());

        Produto produtoAtualizado = produtoRepository.save(produto);

        return produtoAtualizado;
    }

    @Override
    public void deleteById(Long id) {
        Produto produto = findById(id);
        produtoRepository.deleteById(produto.getId());
    }

}
