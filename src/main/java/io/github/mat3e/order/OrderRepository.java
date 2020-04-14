package io.github.mat3e.order;

import io.github.mat3e.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
