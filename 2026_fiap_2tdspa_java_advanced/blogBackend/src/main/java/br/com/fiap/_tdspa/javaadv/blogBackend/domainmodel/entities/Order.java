package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table (name = "ORDER")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private @Getter @Setter String id;
    private @Getter @Setter double totalPrice;
    private @Getter @Setter int totalQuantity;

}
