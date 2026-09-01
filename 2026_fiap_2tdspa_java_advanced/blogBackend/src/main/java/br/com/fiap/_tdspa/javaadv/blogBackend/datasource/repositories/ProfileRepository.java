package br.com.fiap._tdspa.javaadv.blogBackend.datasource.repositories;

import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Profile;
import br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;


public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    public Optional<Profile> findByUserId(UUID userId);
    public Optional<Profile> findByUser(User user);


}
