package io.github.mat3e.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class OrderDTO {
    private List<OrderItemDTO> items = new ArrayList<>();
}