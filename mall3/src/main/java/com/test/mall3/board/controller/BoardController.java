package com.test.mall3.board.controller;

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

import com.test.mall3.board.service.Board;
import com.test.mall3.board.service.BoardService;
import com.test.mall3.member.service.MemberService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
		
	@RequestMapping(value="/getBoardList", method=RequestMethod.GET)
	public String getBoardList(Model model
								,@RequestParam(value="currentPage",defaultValue="1") int currentPage
								,@RequestParam(value="pagePerRow",defaultValue="5") int pagePerRow) {
		Map<String, Object> map = boardService.getBoardList(currentPage,pagePerRow);
		model.addAttribute("list",map.get("list"));
		model.addAttribute("lastPage",map.get("lastPage"));
		model.addAttribute("currentPage",map.get("currentPage"));
		model.addAttribute("pagePerRow",pagePerRow);
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
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(@RequestParam("deleteBoardNo") int deleteBoardNo) {
		System.out.println(deleteBoardNo+"<--deleteBoardNo");
		boardService.foreignkeyBoard();
		boardService.deleteBoard(deleteBoardNo);
		return "redirect:/getBoardList";
	}
	
	/*화면수정완료된 화면을 보여주기*/
	@RequestMapping(value="/updateBoardList", method=RequestMethod.POST)
	public String updateBoardList(Model model,Board board) {
		boardService.updateBoard(board);
		List<Board> list = boardService.selectBoard1(board.getBoardNo());
		model.addAttribute("list", list);
		return "/boardcomment/updateBoardCommentList";
	}
	
}
