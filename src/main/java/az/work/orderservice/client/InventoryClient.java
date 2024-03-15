package az.work.orderservice.client;

import az.work.orderservice.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "inventory-service",url = "http://inventory-service/api/inventory")
public interface InventoryClient {

    @GetMapping()
    List<InventoryResponse> isInStock(@RequestParam List<String> skuCode);
}
