package com.test.mall3.address.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	/*
	 * 
	 */
	public int deleteAddress(Address address) {
		int row = addressDao.deleteAddress(address);
		return row;
	}
	/*
	 * address를 매개변수로 받아 dao에서 insert를 하여 row로 리턴한다.
	 */
	public int addAddress(Address address) {
		int row = addressDao.insertAddress(address);
		return row;
	}

	public Map<String, Object> getAddressList(int currentPage, int pagePerRow, int memberNo) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		/*
		 * currentPage 와 pagePerRow 활용하여 beginRow를 구한다
		 */
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		map.put("memberNo", memberNo);
		List<Address> list = addressDao.selectAddressList(map);
		
		/*
		 * total 와 pagePerRow 활용하여 lastPage를 구한다
		 */
		int total = addressDao.totalCountAddress(memberNo);
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow+1;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}
}
