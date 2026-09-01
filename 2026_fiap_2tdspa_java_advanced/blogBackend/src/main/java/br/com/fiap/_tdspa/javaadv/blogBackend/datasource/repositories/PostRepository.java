package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Post;
import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByUserId(UUID userId);
    List<Post> findByUser( User user);

    Page<Post> findByUser(User user, Pageable pageable);
}