package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
