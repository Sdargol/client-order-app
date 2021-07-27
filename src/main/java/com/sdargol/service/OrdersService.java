package com.sdargol.service;

import com.sdargol.dto.OrderDTO;
import com.sdargol.dto.request.CreateOrderDTO;
import com.sdargol.entity.Client;
import com.sdargol.entity.Order;
import com.sdargol.repository.ClientRepository;
import com.sdargol.repository.OrderRepository;
import com.sdargol.service.api.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService implements IOrder {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public OrdersService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public OrderDTO create(CreateOrderDTO order) {
        Client client = clientRepository.findByLogin(order.getClientLogin());
        client.getOrders().add(Order.dtoToEntity(order.getOrder()));
        clientRepository.save(client);
        return order.getOrder();
    }

    @Override
    public OrderDTO getInfo(Integer id) {
        return OrderDTO.entityToDTO(orderRepository.getById(id));
    }

    @Override
    @Transactional
    public OrderDTO update(OrderDTO order) {
        Order o = orderRepository.getById(order.getId());
        o.setInfo(order.getInfo());
        orderRepository.save(o);
        return OrderDTO.entityToDTO(o);
    }

    @Override
    @Transactional
    public OrderDTO delete(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        orderRepository.deleteById(id);
        return OrderDTO.entityToDTO(order.get());
    }

    @Override
    public List<OrderDTO> getAll() {
        return OrderDTO.entitiesToListDTO(orderRepository.findAll());
    }
}
