package com.victxl.projetomongo.services;

import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
       return usuario.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
