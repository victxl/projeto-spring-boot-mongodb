package com.victxl.projetomongo.resources;

import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.dto.UsuarioDTO;
import com.victxl.projetomongo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> list = usuarioService.findAll();
        List<UsuarioDTO> listDTO = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario = usuarioService.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        usuario.setId(id);
        usuario = usuarioService.update(usuario);
        return ResponseEntity.noContent().build();
    }






}
