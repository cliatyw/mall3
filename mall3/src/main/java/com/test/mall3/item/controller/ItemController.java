package com.test.mall3.item.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.category.controller.CategoryController;
import com.test.mall3.category.service.Category;
import com.test.mall3.category.service.CategoryService;
import com.test.mall3.item.service.Item;
import com.test.mall3.item.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemservice;
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@RequestMapping(value="/updateItem", method=RequestMethod.GET )
	public String updateCategory(Model model, Item item) {
		model.addAttribute("item", itemservice.selectItemOne(item));
		return "/item/updateItem";
	}
	
	@RequestMapping(value="/updateItem", method=RequestMethod.POST )
	public String updateCategory(Item item) {
		itemservice.updateItem(item);
		return "redirect:/getItemList?categoryNo="+item.getCategoryNo();
	}
	
	@RequestMapping(value="/deleteItem", method=RequestMethod.GET )
	public String deleteItem(Item item) {
		itemservice.deleteItem(item);
		return "redirect:/getItemList?categoryNo="+item.getCategoryNo();
	}
		
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String addItem(Model model, @RequestParam(value="categoryNo") int categoryNo) {
		model.addAttribute("categoryNo",categoryNo);
		return "/item/addItem";
	}

	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public String addItem(Model model, Item item, @RequestParam(value="categoryNo") int categoryNo) {
		model.addAttribute("categoryNo",categoryNo);
		itemservice.addItem(item);
		return "redirect:/getItemList?pagePerRow=10";
	}
	
	
	@RequestMapping(value="/getItemList", method=RequestMethod.GET)
	public String getItemList(Model model
									,@RequestParam(value="categoryName") String categoryName
									,@RequestParam(value="categoryNo") int categoryNo
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		
		Map<String, Object> map = itemservice.getItemList(currentPage,pagePerRow,categoryNo);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage",map.get("lastPage"));
		model.addAttribute("currentPage",map.get("currentPage"));
		model.addAttribute("categoryNo",categoryNo);
		model.addAttribute("categoryName",categoryName);
		model.addAttribute("pagePerRow",pagePerRow);
		return "/item/getItemList";
	}
}
