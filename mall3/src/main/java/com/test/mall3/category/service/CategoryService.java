package com.test.mall3.category.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.member.service.MemberService;
@Service
public class CategoryService { 
	@Autowired
	private CategoryDao categorydao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	public Category getCategoryById(Category category) {
		return categorydao.selectCategoryById(category);
		
	}
	public Map<String, Object> getCategoryList(int currentPage, int pagePerRow) {
		//1
		Map<String, Integer> map = new HashMap<String, Integer>();
		//currentPage,pagePerRow --> beginRow 알고리즘 설계
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Category> list = categorydao.selectCategoryList(map);
		//2
		int total = categorydao.totalCountCategory();
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
		return returnMap;
	}
	
	public int addCategory(Category category) {
		int row = categorydao.insertCategory(category);
		return row;
	}
}
