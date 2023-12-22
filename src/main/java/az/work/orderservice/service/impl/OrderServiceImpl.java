package az.work.orderservice.service.impl;

import az.work.orderservice.dto.InventoryResponse;
import az.work.orderservice.dto.OrderRequest;
import az.work.orderservice.entity.Order;
import az.work.orderservice.entity.OrderLineItems;
import az.work.orderservice.exception.DataNotFoundException;
import az.work.orderservice.mapper.OrderMapper;
import az.work.orderservice.repository.OrderRepository;
import az.work.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    private final OrderMapper orderMapper;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderLineItemsDto -> orderMapper.mapToEntity(orderLineItemsDto)).toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCode = orderLineItems.stream().map(orderLineItem -> orderLineItem.getSkuCode()).toList();

        InventoryResponse[] inventoryResponsesArray = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory", urlBuilder -> urlBuilder.queryParam("skuCode", skuCode).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        boolean allProductInStock = Arrays.stream(inventoryResponsesArray).allMatch(inventoryResponse -> inventoryResponse.getIsInStock());
        if (allProductInStock) {
            orderRepository.save(order);
        } else {
            throw DataNotFoundException.productNotInStockException();
        }
    }

}
