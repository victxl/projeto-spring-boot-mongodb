package com.victxl.projetomongo.services;

import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.dto.UsuarioDTO;
import com.victxl.projetomongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();


    }

    public Usuario findById(String id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Usuario insert(Usuario usuario) {
        return usuarioRepository.insert(usuario);
    }

    public void delete(String id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Usuario obj) {
        try {
            Optional<Usuario> newUser = usuarioRepository.findById(obj.getId());
            Usuario user = newUser.get();
            updateData(user, obj);
            return usuarioRepository.save(user);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Object not found.");
        }
    }

    // AUXILIAR METHOD FOR USER UPDATE
    private void updateData(Usuario user, Usuario obj) {
        user.setNome(obj.getNome());
        user.setEmail(obj.getEmail());

    }

    public Usuario fromDTO(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getId(), usuarioDTO.getNome(), usuarioDTO.getEmail());
    }


}
