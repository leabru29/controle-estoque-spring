package br.com.leandrobezerradasilva.backend.controllers.operacoes;

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
import java.util.List;

import br.com.leandrobezerradasilva.backend.models.operacoes.EntradaProduto;
import br.com.leandrobezerradasilva.backend.services.operacoes.EntradaProdutoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/entrada-produto")
public class EntradaProdutoController {

    @Autowired
    private EntradaProdutoServiceImpl entradaProdutoServiceImpl;

    @PostMapping
    public ResponseEntity<EntradaProduto> salvarEntradaProduto(@Valid @RequestBody EntradaProduto entradaProduto) {
        EntradaProduto entradaProdutoSalvar = entradaProdutoServiceImpl.save(entradaProduto);
        return new ResponseEntity<EntradaProduto>(entradaProdutoSalvar, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EntradaProduto>> listaEntradaProduto() {
        List<EntradaProduto> entradaProdutoLista = entradaProdutoServiceImpl.findAll();
        return new ResponseEntity<List<EntradaProduto>>(entradaProdutoLista, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntradaProduto> obterEntradaProduto(@PathVariable Long id) {
        EntradaProduto entradaProduto = entradaProdutoServiceImpl.findById(id);
        return new ResponseEntity<>(entradaProduto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EntradaProduto> atualizarEntradaProduto(@PathVariable Long id,
            @Valid @RequestBody EntradaProduto entradaProduto) {
        entradaProduto.setId(id);
        EntradaProduto entradaProdutoAtualizada = entradaProdutoServiceImpl.update(entradaProduto);
        return new ResponseEntity<>(entradaProdutoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirEntradaProduto(@PathVariable Long id) {
        entradaProdutoServiceImpl.deleteById(id);
        return new ResponseEntity<>("Entrada de Produto deletada com sucesso!", HttpStatus.OK);
    }
}
