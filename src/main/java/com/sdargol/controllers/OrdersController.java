package com.sdargol.controllers;

import com.sdargol.dto.OrderDTO;
import com.sdargol.dto.msg.ContentMessageDTO;
import com.sdargol.dto.request.CreateOrderDTO;
import com.sdargol.service.api.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin("*")
public class OrdersController {
    private final IOrder orderService;

    @Autowired
    public OrdersController(IOrder orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ContentMessageDTO<OrderDTO>> createClient(@RequestBody CreateOrderDTO order){
        ContentMessageDTO<OrderDTO> msg = new ContentMessageDTO<>("Order successfully created", orderService.create(order));
        return ResponseEntity.ok(msg);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.getInfo(id));
    }

    @PutMapping
    public ResponseEntity<ContentMessageDTO<OrderDTO>> updateOrder(@RequestBody OrderDTO order){
        ContentMessageDTO<OrderDTO> msg = new ContentMessageDTO<>("Order successfully update", orderService.update(order));
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContentMessageDTO<OrderDTO>> deleteOrder(@PathVariable Integer id){
        ContentMessageDTO<OrderDTO> msg = new ContentMessageDTO<>("Order successfully delete", orderService.delete(id));
        return ResponseEntity.ok(msg);
    }

}
