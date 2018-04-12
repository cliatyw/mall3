package com.test.mall3.category.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	final String NS = "com.test.mall3.category.service.CategoryMapper.";
		
	public int totalCountCategory() {
		return sqlSession.selectOne(NS+"totalCountCategory");
		
	}
	
	public List<Category> selectCategoryList(Map<String, Integer> map){
		return sqlSession.selectList(NS+"selectCategoryList", map);
	}
	
	public int insertCategory(Category category) {
		int row = sqlSession.insert(NS + "insertCategory", category);
		return row;
	}

	public int deleteCategory(Category category) {
		int row = sqlSession.delete(NS + "deleteCategory", category);
		return row;
	}
	
	public int updateCategory(Category category) {
		int row = sqlSession.update(NS + "updateCategory", category);
		return row;
	}
	
	public Category selectCategoryOne(Category category) {
		return sqlSession.selectOne(NS + "selectCategoryOne", category);
	}
}
