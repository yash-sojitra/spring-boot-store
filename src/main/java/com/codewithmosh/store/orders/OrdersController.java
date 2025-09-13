package com.codewithmosh.store.orders;

import com.codewithmosh.store.common.ErrorDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> Orders() {
        var ordersDto = orderService.getAllOrders();
        return ResponseEntity.ok(ordersDto);
    }

    @GetMapping("/{orderId}")
    public OrderDto getOrder(
            @PathVariable("orderId") Long orderId
    ) {
        return orderService.getOrder(orderId);
    }

    @ExceptionHandler(OrderNotfoundException.class)
    public ResponseEntity<Void> handleOrdersNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        System.out.println("AccessDeniedException: " + ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorDto(ex.getMessage()));
    }
}
