package ru.x5.demo.kafka.saga.ordersaga.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.x5.demo.kafka.saga.ordersaga.dto.Result;

import java.time.Duration;

@Service
public class KafkaResultListener {

    private final OrderService orderService;

    public KafkaResultListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @KafkaListener(topics = "${app.kafka.result-topic}")
    public void resultIncome(@Payload Result result, Acknowledgment acknowledgment) {
        try {
            Long orderId = result.getOrderId();
            if ("error".equalsIgnoreCase(result.getStatus())) {
                orderService.declineOrder(orderId);
            } else {
                orderService.updateOrder(result.getOrderId(), result.getAuthor(), result.getExtId());
            }
        } catch (Exception e) {
            acknowledgment.nack(Duration.ofSeconds(15));
        }
    }

}
