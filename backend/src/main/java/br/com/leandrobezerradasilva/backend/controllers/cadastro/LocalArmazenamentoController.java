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

import br.com.leandrobezerradasilva.backend.models.cadastro.LocalArmazenamento;
import br.com.leandrobezerradasilva.backend.services.cadastro.LocalArmazenamentoServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/local-armazenamento")
public class LocalArmazenamentoController {

    @Autowired
    private LocalArmazenamentoServiceImpl localArmazenamentoServiceImpl;

    @GetMapping
    public ResponseEntity<List<LocalArmazenamento>> listarLocaisArmazenamento() {
        List<LocalArmazenamento> locaiArmazenamento = localArmazenamentoServiceImpl.findAll();
        return new ResponseEntity<>(locaiArmazenamento, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LocalArmazenamento> salvarLocalArmazenamento(
            @Valid @RequestBody LocalArmazenamento localArmazenamento) {
        LocalArmazenamento localArmazenamentosSalvo = localArmazenamentoServiceImpl.save(localArmazenamento);
        return new ResponseEntity<>(localArmazenamentosSalvo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LocalArmazenamento> obterLocalPorId(@PathVariable UUID id) {
        LocalArmazenamento localArmazenamento = localArmazenamentoServiceImpl.findById(id);
        return new ResponseEntity<>(localArmazenamento, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LocalArmazenamento> atualizaLocalArmazenamento(@PathVariable UUID id,
            @Valid @RequestBody LocalArmazenamento localArmazenamento) {
        localArmazenamento.setId(id);
        LocalArmazenamento localArmazenamentoAtualizado = localArmazenamentoServiceImpl.update(localArmazenamento);
        return new ResponseEntity<>(localArmazenamentoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluiLocalArmazenamento(@PathVariable UUID id) {
        LocalArmazenamento localArmazenamento = localArmazenamentoServiceImpl.findById(id);
        localArmazenamentoServiceImpl.deleteById(localArmazenamento.getId());
        return new ResponseEntity<String>("Local deletado com sucesso!", HttpStatus.OK);

    }
}
