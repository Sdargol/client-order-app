package com.sdargol.dto;

import com.sdargol.entity.Client;
import com.sdargol.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {
    private Integer id;
    private String info;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, String info) {
        this.id = id;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static OrderDTO entityToDTO(Order order){
        OrderDTO o = new OrderDTO();
        o.setId(order.getId());
        o.setInfo(order.getInfo());
        return o;
    }

    public static List<OrderDTO> entitiesToListDTO(List<Order> orders){
        return orders.stream()
                .map(OrderDTO::entityToDTO)
                .collect(Collectors.toList());
    }
}
