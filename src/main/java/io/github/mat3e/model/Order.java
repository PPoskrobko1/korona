package io.github.mat3e.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private List<OrderItem> items = new ArrayList<>();
}
