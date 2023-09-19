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

import br.com.leandrobezerradasilva.backend.models.cadastro.MarcaProduto;
import br.com.leandrobezerradasilva.backend.services.cadastro.MarcaProdutoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/marca-produto")
public class MarcaProdutoController {

    @Autowired
    private MarcaProdutoServiceImpl marcaProdutoServiceImpl;

    @GetMapping
    public ResponseEntity<List<MarcaProduto>> listarMarcaProduto() {
        List<MarcaProduto> marcaProduto = marcaProdutoServiceImpl.findAll();
        return new ResponseEntity<>(marcaProduto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MarcaProduto> obterPorIdMarca(@PathVariable Long id) {
        MarcaProduto marcaProduto = marcaProdutoServiceImpl.findById(id);
        return new ResponseEntity<>(marcaProduto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MarcaProduto> salvarMarcaProduto(@Valid @RequestBody MarcaProduto marcaProduto) {
        MarcaProduto marcaProdutoSalvo = marcaProdutoServiceImpl.save(marcaProduto);
        return new ResponseEntity<>(marcaProdutoSalvo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MarcaProduto> atualizarMarcaProduto(@PathVariable Long id,
            @Valid @RequestBody MarcaProduto marcaProduto) {
        marcaProduto.setId(id);
        MarcaProduto marcaProdutoAtualizado = marcaProdutoServiceImpl.update(marcaProduto);
        return new ResponseEntity<>(marcaProdutoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluiMarcaProduto(@PathVariable Long id) {
        marcaProdutoServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Marca de produto deletado com sucesso!", HttpStatus.OK);
    }

}
