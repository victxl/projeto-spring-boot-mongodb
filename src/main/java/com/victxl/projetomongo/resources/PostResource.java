package com.victxl.projetomongo.resources;

import com.victxl.projetomongo.domain.Post;
import com.victxl.projetomongo.resources.util.URL;
import com.victxl.projetomongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;


    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value="/pesquisatitulo", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto",defaultValue = "") String texto) {
        texto = URL.decodParam(texto);
        List<Post> posts = postService.findByTitulo(texto);
        return ResponseEntity.ok().body(posts);
    }
    @RequestMapping(value="/pesquisacompleta", method= RequestMethod.GET)
    public ResponseEntity<List<Post>> pesquisaCompleta(
            @RequestParam(value = "texto",defaultValue = "") String texto,
            @RequestParam(value = "dataInicial",defaultValue = "") String dataInicial,
            @RequestParam(value = "dataFinal",defaultValue = "") String dataFinal) {
        texto = URL.decodParam(texto);
        Date inicial = URL.convertDate(dataInicial, new Date(0L));
        Date fin = URL.convertDate(dataFinal, new Date());
        List<Post> posts = postService.pesquisaCompleta(texto, inicial, fin);
        return ResponseEntity.ok().body(posts);
    }





}
