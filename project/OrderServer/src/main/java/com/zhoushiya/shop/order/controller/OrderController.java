package com.zhoushiya.shop.order.controller;

import com.zhoushiya.shop.order.service.OrderService;
import com.zhoushiya.shop.order.vo.OrderVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 19:56
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public long create(@RequestBody OrderVO orderVO){
        orderService.create(orderVO);
        return orderVO.getId();
    }

    @GetMapping("/getAll")
    public List<OrderVO> getAll(){
        return orderService.list();
    }
}
