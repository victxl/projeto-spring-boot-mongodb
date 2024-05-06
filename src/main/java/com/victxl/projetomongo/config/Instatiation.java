package com.victxl.projetomongo.config;

import com.victxl.projetomongo.domain.Post;
import com.victxl.projetomongo.domain.Usuario;
import com.victxl.projetomongo.dto.AutorDTO;
import com.victxl.projetomongo.dto.ComentarioDTO;
import com.victxl.projetomongo.repository.PostRepository;
import com.victxl.projetomongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        usuarioRepository.deleteAll();
        postRepository.deleteAll();

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu Viagem","Vou viajar para São Pualo. Abraços!!!",new AutorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje???",new AutorDTO(maria));


        ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!",sdf.parse("21/03/2018"),new AutorDTO(alex));
        ComentarioDTO c2 = new ComentarioDTO("Aproveite",sdf.parse("23/03/2018"),new AutorDTO(bob));
        ComentarioDTO c3 = new ComentarioDTO("Tenha um otimo dia!",sdf.parse("21/03/2018"),new AutorDTO(alex));

        post1.getComentarios().addAll(Arrays.asList(c1,c2));
        post2.getComentarios().addAll(Arrays.asList(c3));
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        usuarioRepository.save(maria);

    }
}
