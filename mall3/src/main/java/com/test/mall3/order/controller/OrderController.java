package com.test.mall3.order.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.address.service.AddressService;
import com.test.mall3.category.service.Category;
import com.test.mall3.category.service.CategoryService;
import com.test.mall3.member.service.Member;
import com.test.mall3.order.service.Order;
import com.test.mall3.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AddressService addressService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value="/deleteOrder", method=RequestMethod.GET)
	public String deleteOrder(Order order) {
		orderService.deleteOrder(order);
		return "redirect:/myInfo";
	}
	
	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public String getOrderList(Model model, HttpSession session
			, @RequestParam(value="previous", defaultValue="90") String previous
			, @RequestParam(value="currentPage", defaultValue="1") int currentPage
			, @RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("cateList", list);
		Member member = (Member) session.getAttribute("loginMember");
		model.addAttribute("list", orderService.getOrderList(member.getMemberNo(), previous));
		model.addAttribute("addressList", addressService.getAddressList(currentPage, pagePerRow, member.getMemberNo()));
		return "/order/myInfo";
	}
	
	@RequestMapping(value="/addOrder", method=RequestMethod.GET)
	public String addOrder(Order order) {
		orderService.addOrder(order);
		return "redirect:/myInfo";
	}
}
