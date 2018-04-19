package com.test.mall3.category.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall3.item.service.Item;
import com.test.mall3.member.service.MemberService;
@Service
public class CategoryService { 
	@Autowired
	private CategoryDao categorydao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	public Map<String, Object> getCategoryList(Category category) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Category> list = categorydao.selectCategoryList(map);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		return returnMap;
	}
	
	public int addCategory(Category category) {
		int row = categorydao.insertCategory(category);
		return row;
	}

	public int deleteCategory(Category category) {
		int row = categorydao.deleteCategory(category);
		return row;
	}
	
	public int updateCategory(Category category) {
		int row = categorydao.updateCategory(category);
		return row;
	}
	
	public Category selectCategoryOne(Category category) {
		return categorydao.selectCategoryOne(category);
	}
}
