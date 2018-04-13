package com.test.mall3.address.controller;

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

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
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
		Map<String, Object> map = addressService.getAddressList(currentPage, pagePerRow, memberNo);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("memberNo", memberNo);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		return "/address/getAddressList";
	}
}
