package com.example.Express.Controller;

import com.example.Express.Model.Orders;
import com.example.Express.POJOS.CustomerData;
import com.example.Express.POJOS.OrderRequest;
import com.example.Express.Service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/express")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) throws Exception{
        log.info("In Order Controller");
        log.info("In Create Order function");
        return orderService.createOrder(orderRequest);
    }
}
