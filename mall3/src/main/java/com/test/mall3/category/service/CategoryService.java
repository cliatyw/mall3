package com.test.mall3.category.service;

import java.util.ArrayList;
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

	public List<Category> getCategoryList() {
		List<Category> list = new ArrayList<Category>();
		list = categorydao.selectCategoryList();
		return list;
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
