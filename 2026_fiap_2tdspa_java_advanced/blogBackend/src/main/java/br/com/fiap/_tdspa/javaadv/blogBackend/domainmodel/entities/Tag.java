package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="SYS004_TAG")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name="NAME", length=15)
    @NotBlank(message="O nome da tag é obrigatório.")
    @NotNull(message="O Valor não pode ser nulo")
    @Size(max=15,message="O tamanho máximo da tag é 15")
    private @Getter @Setter String name;

    @ManyToMany(mappedBy="tags", fetch = FetchType.LAZY)
    private @Getter @Setter Set<br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities.Post> posts;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
