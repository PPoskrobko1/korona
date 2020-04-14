package io.github.mat3e.order;

import java.util.stream.Collectors;
import io.github.mat3e.dto.OrderDTO;
import io.github.mat3e.model.Order;
import io.github.mat3e.model.OrderItem;
import io.github.mat3e.pc.ProductService;
import org.springframework.stereotype.Service;

@Service
class OrderService {

    private ProductService productService;

    private OrderRepository orderRepository;

    public OrderService() {
        this(new ProductService());
    }


    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Order createOrder(OrderDTO order) {
        validate(order);
        Order createdOrder = new Order();
        createdOrder.setItems(order.getItems()
                .stream()
                .map(item -> OrderItem.builder()
                        .number(item.getNumber()).build())
                .collect(Collectors.toList()));
        return orderRepository.save(createdOrder);
    }

    private void validate(OrderDTO order) {
        if(order.getItems()
                .stream()
                .filter(item -> !productService
                        .isProductAvailable(item.getProductCode(), item.getNumber()))
                .findAny().isPresent()) {
            throw new RuntimeException("Brak takiego produktu");
        }
    }
}
