package com.victxl.projetomongo.repository;

import com.victxl.projetomongo.domain.Post;
import com.victxl.projetomongo.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'titulo':  { $regex: ?0, $options: 'i' }}")
    List<Post> pesquisaTitulo (String texto);

    List<Post> findByTituloContainingIgnoreCase(String texto);
}
