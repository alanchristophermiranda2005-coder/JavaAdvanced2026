package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="SYS002_PROFILES")
@NoArgsConstructor
@AllArgsConstructor


public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name="BIOGRAPHY")
    private @Getter @Setter String bio;

    @Column(name="PICTURE")
    private @Getter @Setter String profilePicture;

    @OneToOne(fetch = FetchType.LAZY) // Um user tem um profile
    @JoinColumn(name="user_id")
    private @Getter @Setter User user;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", user=" + user +
                '}';
    }
}


