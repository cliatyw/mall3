package com.test.mall3.order.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	final String NS = "com.test.mall3.order.service.OrderMapper.";
	
	public int deleteOrder(Order order) {
		int row = sqlSession.insert(NS+"deleteOrder", order);
		return row;
	}
	
	public List<Order> selectOrderList(Map<String, Object> map) {
		return sqlSession.selectList(NS+"selectOrderList", map);
	}
	
	public int insertOrder(Order order) {
		int row = sqlSession.insert(NS+"insertOrder", order);
		return row;
	}

}
