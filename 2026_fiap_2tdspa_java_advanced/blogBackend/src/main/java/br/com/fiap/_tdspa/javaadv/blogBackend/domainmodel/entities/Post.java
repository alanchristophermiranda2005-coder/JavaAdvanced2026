package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYS003_POSTS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name="TITLE", length=60)
    @NotBlank(message="O Titulo é obrigatório")
    @Size(max=60,min=5,message="O titulo deve ter entre 5 a 60 caracteres")
    private @Getter @Setter String title;

    @Column(name="CONTENT", length=255)
    @Size(max=255,message="O tamanho máximo do Post deve ser de 255 caracteres")
    private @Getter @Setter String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private @Getter @Setter br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="SYS006_POSTS_TAGS",
            joinColumns = @JoinColumn(name="POST_ID"),
            inverseJoinColumns = @JoinColumn(name="TAG_ID")
    )
    private @Getter @Setter Set<br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Tag> tags;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", tags=" + tags +
                '}';
    }
}
