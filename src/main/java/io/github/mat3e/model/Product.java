package io.github.mat3e.model;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Product {
    private Long id;
    private String category;
    private String name;
    private Integer amount;
    private String info;
}
