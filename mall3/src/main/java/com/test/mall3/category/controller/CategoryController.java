package com.test.mall3.category.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.category.service.Category;
import com.test.mall3.category.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryservice;
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@RequestMapping(value="/addCategory", method=RequestMethod.GET)
	public String addCategory() {
		return "/category/addCategory";
	}

	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(Category category) {
		categoryservice.addCategory(category);
		return "redirect:/getCategoryList";
	}
	
	@RequestMapping(value="/getCategoryList", method=RequestMethod.GET)
	public String getCategoryList(Model model
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", required=true) int pagePerRow) {
		
		Map<String, Object> map = categoryservice.getCategoryList(currentPage,pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("total",map.get("lastPage"));
		model.addAttribute("pagePerRow",pagePerRow);
		return "/category/getCategoryList";
	}
} 