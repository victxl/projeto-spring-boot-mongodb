package com.victxl.projetomongo.repository;

import com.victxl.projetomongo.domain.Post;
import com.victxl.projetomongo.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
