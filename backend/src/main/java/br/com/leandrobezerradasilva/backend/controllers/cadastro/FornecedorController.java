package br.com.leandrobezerradasilva.backend.controllers.cadastro;

import java.util.List;
import java.util.UUID;

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

import br.com.leandrobezerradasilva.backend.models.cadastro.Fornecedor;
import br.com.leandrobezerradasilva.backend.services.cadastro.FornecedorServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorServiceImpl fornecedorServiceImpl;

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@Valid @RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorSalvo = fornecedorServiceImpl.save(fornecedor);
        return new ResponseEntity<>(fornecedorSalvo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedor() {
        List<Fornecedor> fornecedores = fornecedorServiceImpl.findAll();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> obterFornecedor(@PathVariable UUID id) {
        Fornecedor fornecedor = fornecedorServiceImpl.findById(id);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable UUID id,
            @Valid @RequestBody Fornecedor fornecedor) {
        fornecedor.setId(id);
        Fornecedor fornecedorAtualizado = fornecedorServiceImpl.update(fornecedor);
        return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public String deletaFornecedor(@PathVariable UUID id) {
        fornecedorServiceImpl.deleteById(id);
        return "Fornecedor deletado com sucesso!";
    }

}
