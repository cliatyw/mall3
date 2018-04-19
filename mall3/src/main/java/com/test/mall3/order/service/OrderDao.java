package com.test.mall3.order.service;

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
	
	public int insertOrder(Order order) {
		int row = sqlSession.insert(NS+"insertOrder", order);
		return row;
	}

}
