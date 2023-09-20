package br.com.leandrobezerradasilva.backend.controllers.cadastro.User;

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
import java.util.UUID;

import br.com.leandrobezerradasilva.backend.models.cadastro.user.Usuario;
import br.com.leandrobezerradasilva.backend.services.cadastro.user.UsuarioServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioServiceImpl.save(usuario);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> listaUsuarios = usuarioServiceImpl.findAll();
        return new ResponseEntity<List<Usuario>>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable UUID id) {
        Usuario usuario = usuarioServiceImpl.findById(id);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> atualizaUsuario(@PathVariable UUID id, @Valid @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario usuarioAtualizado = usuarioServiceImpl.update(usuario);
        return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluiUsuario(@PathVariable UUID id) {
        usuarioServiceImpl.deleteById(id);
        return new ResponseEntity<String>("Usuario deletado com sucesso!", HttpStatus.OK);
    }
}
