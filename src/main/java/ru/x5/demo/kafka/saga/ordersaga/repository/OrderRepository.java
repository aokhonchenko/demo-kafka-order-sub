package ru.x5.demo.kafka.saga.ordersaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.x5.demo.kafka.saga.ordersaga.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
