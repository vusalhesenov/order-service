package az.work.orderservice.controller;


import az.work.orderservice.dto.OrderRequest;
import az.work.orderservice.entity.Order;
import az.work.orderservice.kafka.Producer;
import az.work.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final Producer producer;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        producer.sendMessage("order-topic", "key", orderRequest.toString());
        return "Order Placed Successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> placeOrder() {
        return orderService.findAll();
    }

//    @PostMapping()
//    public void save(@RequestBody Request request) {
//        orderService.save(request);
//
//    }


}