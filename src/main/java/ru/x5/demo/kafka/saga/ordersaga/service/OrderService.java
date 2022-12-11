package ru.x5.demo.kafka.saga.ordersaga.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.x5.demo.kafka.saga.ordersaga.config.AppProperties;
import ru.x5.demo.kafka.saga.ordersaga.model.Order;
import ru.x5.demo.kafka.saga.ordersaga.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final AppProperties appProperties;

    public OrderService(
            OrderRepository orderRepository,
            KafkaTemplate<String, String> kafkaTemplate,
            AppProperties appProperties) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.appProperties = appProperties;
    }

    @Transactional
    public void createOrder() {
        Order order = new Order();
        order = orderRepository.save(order);
        sendToKafka(order);
    }

    public void sendToKafka(Order order) {
        kafkaTemplate.send(appProperties.getOrderTopic(), order.getId().toString());
    }

}
