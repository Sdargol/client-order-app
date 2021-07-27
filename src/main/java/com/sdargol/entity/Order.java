package com.sdargol.entity;

import com.sdargol.dto.ClientDTO;
import com.sdargol.dto.OrderDTO;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "info")
    private String info;

    public Order() {
    }

    public Order(Integer id, String info) {
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

    public static Order dtoToEntity(OrderDTO order){
        Order o = new Order();
        o.setId(order.getId());
        o.setInfo(order.getInfo());
        return o;
    }
}
