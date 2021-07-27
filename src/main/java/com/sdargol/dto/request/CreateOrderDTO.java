package com.sdargol.dto.request;

import com.sdargol.dto.OrderDTO;

public class CreateOrderDTO {
    private String clientLogin;
    private OrderDTO order;

    public CreateOrderDTO() {
    }

    public CreateOrderDTO(String clientLogin, OrderDTO order) {
        this.clientLogin = clientLogin;
        this.order = order;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}
