package com.test.mall3.category.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.category.service.Category;
import com.test.mall3.category.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@RequestMapping(value="/addCategory", method=RequestMethod.GET)
	public String addCategory() {
		return "/category/addCategory";
	}

	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(Category category) {
		categoryService.addCategory(category);
		return "redirect:/getCategoryList";
	}
	
	@RequestMapping(value="/getCategoryList", method=RequestMethod.GET)
	public String getCategoryList(Model model) {
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("list",list);
		return "/category/getCategoryList";
	}
} 
