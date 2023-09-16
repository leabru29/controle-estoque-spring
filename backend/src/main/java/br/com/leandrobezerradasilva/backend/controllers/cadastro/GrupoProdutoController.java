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

import br.com.leandrobezerradasilva.backend.models.cadastro.GrupoProduto;
import br.com.leandrobezerradasilva.backend.services.cadastro.GrupoProdutoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/grupo-produto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoServiceImpl grupoProdutoServiceImpl;

    @PostMapping
    public ResponseEntity<GrupoProduto> salvar(@Valid @RequestBody GrupoProduto grupoProduto) {
        GrupoProduto grupoProdutoSalvo = grupoProdutoServiceImpl.save(grupoProduto);
        return new ResponseEntity<>(grupoProdutoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrupoProduto>> listarGrupo() {
        List<GrupoProduto> grupoProdutos = grupoProdutoServiceImpl.findAll();
        return new ResponseEntity<>(grupoProdutos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoProduto> obterPorId(@PathVariable Long id) {

        GrupoProduto grupoProduto = grupoProdutoServiceImpl.findById(id);

        return new ResponseEntity<>(grupoProduto, HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GrupoProduto> atualizarGrupoProduto(@PathVariable Long id,
            @Valid @RequestBody GrupoProduto grupoProduto) {
        grupoProduto.setId(id);
        GrupoProduto grupoProdutoAtualizado = grupoProdutoServiceImpl.update(grupoProduto);
        return new ResponseEntity<GrupoProduto>(grupoProdutoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public String excluirGrupoProduto(@PathVariable Long id) {
        grupoProdutoServiceImpl.deleteById(id);
        return "Grupo de produto deletado com sucesso!";
    }
}
