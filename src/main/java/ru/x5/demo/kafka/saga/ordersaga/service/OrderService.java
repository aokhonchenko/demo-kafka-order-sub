package ru.x5.demo.kafka.saga.ordersaga.service;

import org.springframework.stereotype.Service;
import ru.x5.demo.kafka.saga.ordersaga.model.Order;
import ru.x5.demo.kafka.saga.ordersaga.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder() {
        Order order = new Order();
        orderRepository.save(order);
    }

}
