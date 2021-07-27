package com.sdargol.service.api;

import com.sdargol.dto.OrderDTO;
import com.sdargol.dto.request.CreateOrderDTO;

import java.util.List;

public interface IOrder {
    OrderDTO create(CreateOrderDTO order);
    OrderDTO getInfo(Integer id);
    OrderDTO update(OrderDTO order);
    OrderDTO delete(Integer id);
    List<OrderDTO> getAll();
}
