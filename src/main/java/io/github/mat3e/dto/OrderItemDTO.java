package io.github.mat3e.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDTO {
    private String productCode;
    private Long number;
}
