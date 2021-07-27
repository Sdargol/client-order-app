package com.sdargol.dto;

import com.sdargol.entity.Client;
import com.sdargol.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDTO {
    private Integer id;
    private String login;
    private String name;
    private List<Order> orders;

    public ClientDTO() {
    }

    public ClientDTO(Integer id, String login, String name, List<Order> orders) {
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

    public static ClientDTO entityToDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setLogin(client.getLogin());
        clientDTO.setName(client.getName());
        clientDTO.setOrders(client.getOrders());
        return clientDTO;
    }

    public static List<ClientDTO> entitiesToListDTO(List<Client> clients){
        return clients.stream()
                .map(ClientDTO::entityToDTO)
                .collect(Collectors.toList());
    }
}
