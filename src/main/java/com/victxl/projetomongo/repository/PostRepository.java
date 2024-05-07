package com.victxl.projetomongo.repository;

import com.victxl.projetomongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{ 'titulo':  { $regex: ?0, $options: 'i' }}")
    List<Post> pesquisaTitulo(String texto);

   // List<Post> findByTituloContainingIgnoreCase(String texto);

    @Query("{ $and: [{data: {$gte: ?1}},{data: {$lte: ?2}} , " +
            "{ $or: [{'titulo': { $regex: ?0, $options: 'i'}}," +
            "{'conteudo': { $regex: ?0, $options: 'i'}}, {'comentarios': { $elemMatch: { 'comentario': { $regex: ?0, $options: 'i'}}}}] }]  }")
    List<Post> pesquisaCompleta(String texto, Date dataInicial, Date dataFinal);

}
