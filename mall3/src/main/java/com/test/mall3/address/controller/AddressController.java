package com.test.mall3.address.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.address.service.Address;
import com.test.mall3.address.service.AddressService;
import com.test.mall3.category.service.Category;
import com.test.mall3.category.service.CategoryService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private CategoryService categoryService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	/*
	 * address를 매개변수로 받아 한개의 주소를 수정한 후 목록으로 돌아간다.
	 */
	@RequestMapping(value="/updateAddress", method=RequestMethod.POST)
	public String updateAddress(Address address) {
		addressService.updateAddress(address);
		return "redirect:/getAddressList?memberNo="+address.getMemberNo();
	}
	/*
	 * address를 매개변수로 받아 한개의 목록을 가져와 model에 셋팅하고 업데이트 폼으로 이동한다.
	 */
	@RequestMapping(value="/updateAddress", method=RequestMethod.GET)
	public String selectAddressOne(Model model, Address address) {
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("cateList", list);
		model.addAttribute("address", addressService.selectAddressOne(address));
		return "/address/updateAddress";
	}
	/*
	 * address받아 삭제하는 서비스를 호출하고 목록으로 돌아간다.
	 */
	@RequestMapping(value="/deleteAddress", method=RequestMethod.GET)
	public String deleteAddress(Address address) {
		addressService.deleteAddress(address);
		return "redirect:/getAddressList?memberNo="+address.getMemberNo();
	}
	/*
	 * 주소 추가
	 */
	@RequestMapping(value="/addAddress", method=RequestMethod.GET)
	public String getAddressList(Model model, @RequestParam(value="memberNo") int memberNo) {
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("cateList", list);
		model.addAttribute("memberNo", memberNo);
		return "/address/addAddress";
	}
	
	@RequestMapping(value="/addAddress", method=RequestMethod.POST)
	public String getAddressList(Address address) {
		addressService.addAddress(address);
		return "redirect:/getAddressList?memberNo="+address.getMemberNo();
	}
	/*
	 * memberNo를 받아 서비스를 호출한다.
	 * 페이징을 위한 여러 변수들
	 */
	@RequestMapping(value="/getAddressList", method=RequestMethod.GET)
	public String getAddressList(Model model
			, @RequestParam(value="memberNo") int memberNo
			, @RequestParam(value="currentPage", defaultValue="1") int currentPage
			, @RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		List<Category> list = categoryService.getCategoryList();
		model.addAttribute("cateList", list);
		Map<String, Object> map = addressService.getAddressList(currentPage, pagePerRow, memberNo);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("memberNo", memberNo);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "/address/getAddressList";
	}
}
