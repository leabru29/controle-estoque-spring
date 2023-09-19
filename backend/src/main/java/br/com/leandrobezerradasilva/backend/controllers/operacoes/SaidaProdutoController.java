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

import br.com.leandrobezerradasilva.backend.models.operacoes.SaidaProduto;
import br.com.leandrobezerradasilva.backend.services.operacoes.SaidaProdutoServiceImpl;

@RestController
@RequestMapping(value = "/saida-produto")
public class SaidaProdutoController {

    @Autowired
    private SaidaProdutoServiceImpl saidaProdutoServiceImpl;

    @PostMapping
    public ResponseEntity<SaidaProduto> salvarSaidaProduto(SaidaProduto saidaProduto) {
        SaidaProduto saidaProdutoSalvo = saidaProdutoServiceImpl.save(saidaProduto);
        return new ResponseEntity<SaidaProduto>(saidaProdutoSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaidaProduto>> listaSaidaProduto() {
        List<SaidaProduto> listaSaidaProduto = saidaProdutoServiceImpl.findAll();
        return new ResponseEntity<List<SaidaProduto>>(listaSaidaProduto, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaidaProduto> obterSaidaProduto(@PathVariable Long id) {
        SaidaProduto saidaProduto = saidaProdutoServiceImpl.findById(id);
        return new ResponseEntity<>(saidaProduto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SaidaProduto> atualizarSaidaProduto(@PathVariable Long id,
            @RequestBody SaidaProduto saidaProduto) {
        saidaProduto.setId(id);
        SaidaProduto saidaProdutoAtualizada = saidaProdutoServiceImpl.update(saidaProduto);
        return new ResponseEntity<SaidaProduto>(saidaProdutoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirSaidaProduto(@PathVariable Long id) {
        saidaProdutoServiceImpl.deleteById(id);
        return new ResponseEntity<>("Saída deletada com sucesso!", HttpStatus.OK);
    }
}
