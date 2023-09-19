package br.com.leandrobezerradasilva.backend.controllers.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandrobezerradasilva.backend.models.cadastro.Produto;
import br.com.leandrobezerradasilva.backend.services.cadastro.ProdutoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoServiceImpl;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@Valid @RequestBody Produto produto) {
        Produto produtoSalvo = produtoServiceImpl.save(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtoLista = produtoServiceImpl.findAll();
        return new ResponseEntity<List<Produto>>(produtoLista, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
        Produto produto = produtoServiceImpl.findById(id);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        produto.setId(id);
        Produto produtoAtualizado = produtoServiceImpl.update(produto);
        return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirProduto(@PathVariable Long id) {
        produtoServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);
    }
}
