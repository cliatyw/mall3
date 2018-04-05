package com.test.mall3.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.board.service.Board;
import com.test.mall3.board.service.BoardService;
import com.test.mall3.member.service.MemberService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
		
	@RequestMapping(value="/getBoardList", method=RequestMethod.GET)
	public String getBoardList(Model model) {
		List<Board> list = boardService.getBoardList();
		model.addAttribute("list",list);
		return "/board/getBoardList";
	}

	@RequestMapping(value="/addBoard", method=RequestMethod.GET)
	public String addBoard() {
		return "/board/addBoard";
	}
	
	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
	public String addBoard(Board board) {
		boardService.addBoard(board);
		return "redirect:/getBoardList";
	}
}
