package com.test.mall3.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall3.category.service.Category;
@Repository
public class ItemDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall3.item.service.ItemMapper.";
	
	public int totalCountItem(int categoryNo) {
		return sqlSession.selectOne(NS+"totalCountItem", categoryNo);
		
	}	
	public List<Item> selectItemList(Map<String, Integer> map){
		return sqlSession.selectList(NS+"selectItemList", map);
	}
	
	public int insertItem(Item item) {
		int row = sqlSession.insert(NS + "insertItem", item);
		return row;
	}

	public int deleteItem(Item item) {
		int row = sqlSession.delete(NS + "deleteItem", item);
		return row;
	}
	
	public int updateItem(Item item) {
		int row = sqlSession.update(NS + "updateItem", item);
		return row;
	}
	
	public Item selectItemOne(Item item) {
		return sqlSession.selectOne(NS + "selectItemOne", item);
	}
}
