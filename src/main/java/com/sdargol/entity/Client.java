package com.sdargol.entity;

import com.sdargol.dto.ClientDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Order> orders;

    public Client() {
    }

    public Client(Integer id, String login, String name, List<Order> orders) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public static Client dtoToEntity(ClientDTO clientDTO){
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setLogin(clientDTO.getLogin());
        client.setName(clientDTO.getName());
        client.setOrders(clientDTO.getOrders());
        return client;
    }
}
