package com.test.mall3.address.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.member.service.MemberDao;

@Repository
public class AddressDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressDao.class);
	
	final String NS = "com.test.mall3.address.service.AddressMapper.";
	
	public List<Address> selectAddressList(Map<String, Integer> map){
		logger.info("DAO");
		return sqlSession.selectList(NS+"selectAddressList", map);
	}

	public int totalCountAddress(int memberNo) {
		return sqlSession.selectOne(NS+"totalCountAddress", memberNo);
	}
}
