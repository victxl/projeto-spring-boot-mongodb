package com.victxl.projetomongo.services;

import com.victxl.projetomongo.domain.Post;
import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.dto.UsuarioDTO;
import com.victxl.projetomongo.repository.PostRepository;
import com.victxl.projetomongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {



    @Autowired

    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitulo(String texto) {
        return postRepository.pesquisaTitulo(texto);
    }

    public List<Post> pesquisaCompleta(String texto, Date dataInicial, Date dataFinal) {
        dataFinal = new Date(dataFinal.getTime()/ 24*60*60*1000);
        return postRepository.pesquisaCompleta(texto, dataInicial, dataFinal);
    }


}
