package com.test.mall3.boardcomment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall3.boardcomment.service.BoardComment;
import com.test.mall3.boardcomment.service.BoardCommentService;

@Controller
public class BoardCommentController {

	@Autowired
	private BoardCommentService boardCommentService;
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.GET)
	public String getBoardCommentList() {
		return "/boardcomment/getBoardCommentList";
	}
	
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.POST)
	public String getBoardCommentList(BoardComment boardComment) {
		boardCommentService.addBoardComment(boardComment);
		return "/boardcomment/getBoardCommentList";
	}
	
}
