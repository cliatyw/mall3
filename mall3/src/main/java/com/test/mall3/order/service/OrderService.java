package com.test.mall3.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderDao OrderDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public int addOrder(Order order) {
		int row = OrderDao.insertOrder(order);
		return row;
	}

}
