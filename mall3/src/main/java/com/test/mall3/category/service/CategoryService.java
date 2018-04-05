package com.test.mall3.category.service;

import java.util.List;

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

	public List<Category> getCategoryList() {
		return categorydao.selectCategoryList();
	}
	
	public int addCategory(Category category) {
		int row = categorydao.insertCategory(category);
		return row;
	}
}
