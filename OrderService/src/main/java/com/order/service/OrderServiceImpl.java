package com.order.service;

import com.order.entity.Order;
import com.order.exception.CustomException;
import com.order.model.OrderRequest;
import com.order.model.OrderResponse;
import com.order.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

  //  @Autowired
   // private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        //TODO Order Entity -> Save the data with Status Order Created
        //TODO Product Service -> Block Products (Reduce the Quantity)
        //TODO Payment Service -> Payment -> Success-> Complete ,Else Cancelled
        log.info("Placeing Order Request : {}", orderRequest);
//        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        log.info("Creating Order with Status CREATED");
        Order order = Order.builder().amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity()).build();
        order = orderRepository.save(order);
        log.info("Calling Payment Service to Complete the payment" );
        orderRepository.save(order);
        log.info("Order Places Successfully " +order.getId());
        return order.getId();
    }

    @Override
    public OrderResponse getOrderDetails(long orderId) {
        log.info("Get order Details for Order id :{}", orderId);
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new CustomException("Order not Fount for the Order" + orderId, "NOT_FOUNT", 404));
        log.info("Invoking Product Service to fetch the product for id : {}", order.getProductId());
      log.info("Getting Payment information from the Payment Service");


        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .orderDate(order.getOrderDate())
                .amount(order.getAmount())
                .build();
        return orderResponse;
    }
}
