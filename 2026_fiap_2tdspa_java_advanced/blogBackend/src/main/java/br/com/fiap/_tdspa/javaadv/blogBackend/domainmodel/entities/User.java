package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "SYS001_USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotBlank(message="O ID é Obrigatório")
    private @Getter @Setter UUID id;

    @Column(name="NAME", length=60)
    @NotBlank(message="O Nome é Obrigatório")
    @Size(max=60, message="O tamanho máximo do nome é 60 caracteres")
    private @Getter @Setter String name;

    @Column(name="EMAIL", length=60)
    @Size(max=60,min=8, message="O email deve ter entre 8 e 60 caracteres")
    @NotBlank(message="O email é Obrigatório") // caso esteja em branco
    private @Getter @Setter String email;

    @Column(name="PASSWORD", length=20)
    @Size(max=20, min=8, message="A senha deve ter entre 8 e 20 caracteres")
    @NotBlank(message="A senha é Obrigatória")
    private @Getter @Setter String password;

    @OneToOne(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private @Getter @Setter Profile profile; // 1 usuário tem exatamente 1 profile

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private @Getter @Setter Set<Post> posts = new HashSet<>(); // mais rápido

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="SYS008_SYSTEM_USERS_ROLES",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private @Getter @Setter Set<Role> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", posts=" + posts +
                ", roles=" + roles +
                '}';
    }
}
// TreeSet + lento + ordenação;
// linkedList<"nome">; List<"nome">; Set<"nome">
