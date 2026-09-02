package br.com.fiap._tdspa.javaadv.blogBackend.domainmodel.entities;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.*;

import java.util.Objects;
import java.util.UUID;


@Embeddable
@AllArgsConstructor
public class OrderItemKey {
    @Getter @Setter UUID orderId;
    @Getter @Setter UUID orderItemId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemKey that = (OrderItemKey) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(orderItemId, that.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderItemId);
    }

    @Override
    public String toString() {
        return "OrderItemKey{" +
                "orderId=" + orderId +
                ", orderItemId=" + orderItemId +
                '}';
    }
}


