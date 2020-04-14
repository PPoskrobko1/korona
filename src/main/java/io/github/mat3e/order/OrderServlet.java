package io.github.mat3e.order;

import io.github.mat3e.dto.OrderDTO;
import io.github.mat3e.dto.OrderItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

@RestController
class OrderServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";
    private final Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    private OrderService service;

    OrderServlet(OrderService service) {
        this.service = service;
    }

    @GetMapping(value = "/order")
    String welcome(@RequestParam(value = "name") String name, @RequestParam(value = "amount") Long amount) {
        logger.info("Got request");
        OrderDTO orderDTO = OrderDTO.builder().build();
        orderDTO.getItems().add(OrderItemDTO.builder().productCode(name).number(amount).build());
        return service.createOrder(orderDTO).toString();
    }
}
