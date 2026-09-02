package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table (name="ORDER_ITEMS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @EmbeddedId
    private @Getter @Setter OrderItem key;
    private @Getter @Setter String productName;
    private @Getter @Setter double price;
    private @Getter @Setter int quantity;
}
