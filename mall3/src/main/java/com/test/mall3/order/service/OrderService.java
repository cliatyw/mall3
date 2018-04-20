package com.test.mall3.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderDao OrderDao;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public int deleteOrder(Order order) {
		int row = OrderDao.deleteOrder(order);
		return row;
	}
	
	public List<Order> getOrderList(int memberNo, String previous) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberNo", memberNo);
		map.put("previous", previous);
		List<Order> list = OrderDao.selectOrderList(map);
		return list;
	}
	
	public int addOrder(Order order) {
		int row = OrderDao.insertOrder(order);
		return row;
	}

}
