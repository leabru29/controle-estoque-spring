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

import br.com.leandrobezerradasilva.backend.models.cadastro.UnidadeMedida;
import br.com.leandrobezerradasilva.backend.services.cadastro.UnidadeMedidaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/unidade-medida")
public class UnidadeMedidaController {

    @Autowired
    private UnidadeMedidaServiceImpl unidadeMedidaServiceImpl;

    @PostMapping
    public ResponseEntity<UnidadeMedida> salvarUnidadeMedida(@Valid @RequestBody UnidadeMedida unidadeMedida) {
        UnidadeMedida unidadeMedidaSalva = unidadeMedidaServiceImpl.save(unidadeMedida);
        return new ResponseEntity<>(unidadeMedidaSalva, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UnidadeMedida>> listarUnidadeMedida() {
        List<UnidadeMedida> unidadeMedidaLista = unidadeMedidaServiceImpl.findAll();
        return new ResponseEntity<>(unidadeMedidaLista, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeMedida> obterUnidadeMedida(@PathVariable Long id) {
        UnidadeMedida unidadeMedida = unidadeMedidaServiceImpl.findById(id);
        return new ResponseEntity<>(unidadeMedida, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UnidadeMedida> atualizarUnidadeMedida(@PathVariable Long id,
            @RequestBody UnidadeMedida unidadeMedida) {
        unidadeMedida.setId(id);
        UnidadeMedida unidadeMedidaAtualizada = unidadeMedidaServiceImpl.update(unidadeMedida);
        return new ResponseEntity<>(unidadeMedidaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirUnidadeMedida(@PathVariable Long id) {
        unidadeMedidaServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Unidade de Medida deletada com sucesso!", HttpStatus.OK);
    }

}
