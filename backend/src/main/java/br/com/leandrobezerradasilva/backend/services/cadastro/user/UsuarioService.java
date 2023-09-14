package br.com.leandrobezerradasilva.backend.services.cadastro.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leandrobezerradasilva.backend.models.cadastro.user.Usuario;
import br.com.leandrobezerradasilva.backend.repositories.cadastro.user.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario) {

        return usuarioRepository.save(usuario);

    }

    public Usuario findById(UUID id) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.get();

    }

    public List<Usuario> findAll() {

        return usuarioRepository.findAll();

    }

    public Usuario update(Usuario usuario) {

        var id = usuario.getId();
        Usuario usuarioEncontrado = findById(id);
        usuarioEncontrado.setNome(usuarioEncontrado.getNome());
        usuarioEncontrado.setSobrenome(usuarioEncontrado.getSobrenome());
        usuarioEncontrado.setEmail(usuarioEncontrado.getEmail());
        usuarioEncontrado.setSenha(usuarioEncontrado.getSenha());
        Usuario usuarioAtualizado = usuarioRepository.save(usuarioEncontrado);
        return usuarioAtualizado;

    }

    public String delete(UUID id) {

        Usuario idUsuario = findById(id);
        this.usuarioRepository.deleteById(idUsuario.getId());
        return "Usuario deletado com sucesso!";

    }

}
