package com.test.mall3.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.member.service.MemberService;
@Service
public class ItemService {
	@Autowired
	private ItemDao itemdao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	public Map<String, Object> getItemList(int currentPage, int pagePerRow, int categoryNo) {
		//1
		Map<String, Integer> map = new HashMap<String, Integer>();
		//currentPage,pagePerRow --> beginRow 알고리즘 설계
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		map.put("categoryNo", categoryNo);
		List<Item> list = itemdao.selectItemList(map);
		//2
		int total = itemdao.totalCountItem(categoryNo);
		// total, pagePerRow --> lastPage 알고리즘
		int lastPage = 0;
		if(total%pagePerRow==0) {
			lastPage = total/pagePerRow;
		} else {
			lastPage = total/pagePerRow+1;
		}
		//...
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("categoryNo", categoryNo);
		return returnMap;
	}
	
	public int addItem(Item item) {
		int row = itemdao.insertItem(item);
		return row;
	}

	public int deleteItem(Item item) {
		int row = itemdao.deleteItem(item);
		return row;
	}
	
	public int updateItem(Item item) {
		int row = itemdao.updateItem(item);
		return row;
	}
	
	public Item selectItemOne(Item item) {
		return itemdao.selectItemOne(item);
	}
}
