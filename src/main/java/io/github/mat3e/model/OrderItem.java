package io.github.mat3e.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OrderItem {

    private long id;
    private Product product;
    private long number;
}
