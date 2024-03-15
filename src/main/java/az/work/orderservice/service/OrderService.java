package az.work.orderservice.service;

import az.work.orderservice.controller.Request;
import az.work.orderservice.dto.OrderLineItemsDto;
import az.work.orderservice.dto.OrderRequest;
import az.work.orderservice.entity.Order;

import java.util.List;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

    List<Order> findAll();

    void save(Request request);
}
