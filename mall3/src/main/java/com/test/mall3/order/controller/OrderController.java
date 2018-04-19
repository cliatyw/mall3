package com.test.mall3.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.order.service.Order;
import com.test.mall3.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String addOrder(Order order) {
		System.out.println(order);
		orderService.addOrder(order);
		return "redirect:/";
	}
}
