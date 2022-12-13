package ru.x5.demo.kafka.saga.ordersaga.dto;

import ru.x5.demo.kafka.saga.ordersaga.domain.Order;
import ru.x5.demo.kafka.saga.ordersaga.enums.OrderStatus;

public class OrderUpdate {

    private Long orderId;
    private OrderStatus status;

    //region constructors
    public OrderUpdate() {
    }

    public OrderUpdate(Order order) {
        setOrderId(order.getId());
        setStatus(order.getOrderStatus());
    }
    //endregion

    //region g/s

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //endregion

}
