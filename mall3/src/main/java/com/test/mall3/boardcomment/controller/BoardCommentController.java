package com.test.mall3.boardcomment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall3.board.service.Board;
import com.test.mall3.boardcomment.service.BoardComment;
import com.test.mall3.boardcomment.service.BoardCommentService;

@Controller
public class BoardCommentController {
	
	@Autowired
	private BoardCommentService boardCommentService;
	/*게시판, 댓글목록*/
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.GET)
	public String getBoardCommentList(Model model,Board board) {
		model.addAttribute("board", board);
		List<BoardComment> list = boardCommentService.selectBoardComment(board.getBoardNo());
		model.addAttribute("list", list);
		return "/boardcomment/getBoardCommentList";
	}
	
	/*댓글등록*/
	@RequestMapping(value="/getBoardCommentList", method=RequestMethod.POST)
	public String insertBoardCommentList(Model model,BoardComment boardComment,Board board) {
		model.addAttribute("board", board);	
		boardCommentService.insertrBoardComment(boardComment);
		List<BoardComment> list = boardCommentService.selectBoardComment(boardComment.getBoardNo());
		model.addAttribute("list", list);
		model.addAttribute("boardComment", boardComment);
		System.out.println(boardComment);
		return "/boardcomment/getBoardCommentList";
	}
	
	
}
