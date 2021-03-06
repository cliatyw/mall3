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
	/*
	 * address를 매개변수로 받아 업데이트를하고 row를 리턴하는 메서드
	 */
	public int updateAddress(Address address) {
		int row = sqlSession.update(NS+"updateAddress", address);
		return row;
	}
	/*
	 * address를 매개변수를 받아 한개의 address를 가져와 리턴하는 매서드
	 */
	public Address selectAddressOne(Address address) {
		return sqlSession.selectOne(NS+"selectAddressOne", address);
	}
	/*
	 * address를 매개변수로 받아 해당하는 주소를 삭제하고 row를 리턴받는 매서드
	 */
	public int deleteAddress(Address address) {
		int row = sqlSession.delete(NS+"deleteAddress", address);
		return row;
	}
	/*
	 * address를 매개변수로 받아 삽입하고 row로 리턴받는 매서드
	 */
	public int insertAddress(Address address) {
		int row = sqlSession.insert(NS+"insertAddress", address);
		return row;
	}
	/*
	 * map을 매개변수로 받아 address 리스트를 리턴받는 매서드
	 */
	public List<Address> selectAddressList(Map<String, Integer> map){
		return sqlSession.selectList(NS+"selectAddressList", map);
	}
	/*
	 * memberNo를 매개변수로 받아 전체 주소수를 세고 리턴하는 매서드
	 */
	public int totalCountAddress(int memberNo) {
		return sqlSession.selectOne(NS+"totalCountAddress", memberNo);
	}
}
