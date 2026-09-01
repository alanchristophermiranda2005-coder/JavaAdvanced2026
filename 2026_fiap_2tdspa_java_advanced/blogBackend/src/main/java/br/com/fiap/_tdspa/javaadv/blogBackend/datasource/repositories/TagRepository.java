package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
