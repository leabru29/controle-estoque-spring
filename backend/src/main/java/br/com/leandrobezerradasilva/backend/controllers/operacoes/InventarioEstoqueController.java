package br.com.leandrobezerradasilva.backend.controllers.operacoes;

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

import br.com.leandrobezerradasilva.backend.models.operacoes.InventarioEstoque;
import br.com.leandrobezerradasilva.backend.services.operacoes.InventarioEstoqueServiceImpl;

@RestController
@RequestMapping(value = "/inventario-estoque")
public class InventarioEstoqueController {

    @Autowired
    private InventarioEstoqueServiceImpl inventarioEstoqueServiceImpl;

    @PostMapping
    public ResponseEntity<InventarioEstoque> salvarInventarioEstoque(@RequestBody InventarioEstoque inventarioEstoque) {
        InventarioEstoque inventarioEstoqueSalvo = inventarioEstoqueServiceImpl.save(inventarioEstoque);
        return new ResponseEntity<InventarioEstoque>(inventarioEstoqueSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InventarioEstoque>> listarInventarioEstoque() {
        List<InventarioEstoque> listaInventarioEstoque = inventarioEstoqueServiceImpl.findAll();
        return new ResponseEntity<List<InventarioEstoque>>(listaInventarioEstoque, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InventarioEstoque> obterInventarioEstoque(@PathVariable Long id) {
        InventarioEstoque inventarioEstoque = inventarioEstoqueServiceImpl.findById(id);
        return new ResponseEntity<InventarioEstoque>(inventarioEstoque, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<InventarioEstoque> atualizarInventarioEstoque(@PathVariable Long id,
            @RequestBody InventarioEstoque inventarioEstoque) {
        inventarioEstoque.setId(id);
        InventarioEstoque inventarioEstoqueAtualizado = inventarioEstoqueServiceImpl.update(inventarioEstoque);
        return new ResponseEntity<InventarioEstoque>(inventarioEstoqueAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirInventarioEstoque(@PathVariable Long id) {
        inventarioEstoqueServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Inventário deletado com sucesso!", HttpStatus.OK);
    }
}
