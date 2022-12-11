package ru.x5.demo.kafka.saga.ordersaga.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.kafka")
public class AppProperties {

    private String orderTopic;

    //region getters / setters

    public String getOrderTopic() {
        return orderTopic;
    }

    public void setOrderTopic(String orderTopic) {
        this.orderTopic = orderTopic;
    }

    //endregion


}
