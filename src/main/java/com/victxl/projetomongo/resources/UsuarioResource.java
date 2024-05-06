package com.victxl.projetomongo.resources;

import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {

        List<Usuario> list = usuarioService.findAll();

        return ResponseEntity.ok().body(list);
    }

}
