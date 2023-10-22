package az.work.orderservice.mapper;


import az.work.orderservice.dto.OrderLineItemsDto;
import az.work.orderservice.entity.OrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {


    OrderLineItems mapToEntity(OrderLineItemsDto orderLineItemsDto);
}
