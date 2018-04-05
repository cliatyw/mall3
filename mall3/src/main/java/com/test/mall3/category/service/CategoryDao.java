package com.test.mall3.category.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS = "com.test.mall3.category.service.CategoryMapper.";
	
	
	public List<Category> selectCategoryList(){
		return sqlSession.selectList(NS+"selectCategoryList");
	}
	
	public int insertCategory(Category category) {
		int row = sqlSession.insert(NS + "insertCategory", category);
		return row;
	}
}
