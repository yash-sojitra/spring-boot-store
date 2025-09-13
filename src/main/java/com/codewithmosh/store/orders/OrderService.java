package com.codewithmosh.store.orders;

import com.codewithmosh.store.auth.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        var user = authService.getCurrentUser();
        var orders = orderRepository.getOrdersByCustomer(user);
//        if (orders.isEmpty()) {
//            throw new OrdersNotFoundException();
//        }

        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }

    public OrderDto getOrder(Long orderId) {
        var order = orderRepository.getOrderWithItems(orderId)
                    .orElseThrow(OrderNotfoundException::new);

        var user = authService.getCurrentUser();
        if(!order.isPlacedBy(user)) {
            throw new AccessDeniedException("You are not authorized to view this order.");
        }

        return orderMapper.toDto(order);
    }
}
