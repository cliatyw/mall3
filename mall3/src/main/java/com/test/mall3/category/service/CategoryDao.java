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
	/*
	 * category전체 목록을 list로 담는 매서드
	 * return list
	 */
	public List<Category> selectCategoryList(){
		return sqlSession.selectList(NS+"selectCategoryList");
	}
	/*
	 * category를 매개변수로 받아 삽입하고 int타입으로 리턴받는 매서드
	 * param category
	 * return row
	 */
	public int insertCategory(Category category) {
		int row = sqlSession.insert(NS + "insertCategory", category);
		return row;
	}
}
