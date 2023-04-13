package com.example.Express.Controller;

import com.example.Express.POJOS.OrderRequest;
import com.example.Express.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("/order/add")
    public void createOrder(@RequestBody OrderRequest orderRequest) throws Exception{
        orderService.createOrder(orderRequest);
    }
}
