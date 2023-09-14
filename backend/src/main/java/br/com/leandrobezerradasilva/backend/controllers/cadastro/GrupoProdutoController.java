package br.com.leandrobezerradasilva.backend.controllers.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leandrobezerradasilva.backend.models.cadastro.GrupoProduto;
import br.com.leandrobezerradasilva.backend.services.cadastro.GrupoProdutoServiceImpl;

@RestController
@RequestMapping(value = "/grupo-produto")
public class GrupoProdutoController {

    @Autowired
    private GrupoProdutoServiceImpl grupoProdutoServiceImpl;

    @PostMapping
    public ResponseEntity<GrupoProduto> salvar(@RequestBody GrupoProduto grupoProduto) {
        GrupoProduto grupoProdutoSalvo = grupoProdutoServiceImpl.save(grupoProduto);
        return new ResponseEntity<>(grupoProdutoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GrupoProduto>> listGrupo() {
        List<GrupoProduto> grupoProdutos = grupoProdutoServiceImpl.findAll();
        return new ResponseEntity<>(grupoProdutos, HttpStatus.OK);
    }
}
