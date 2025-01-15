package com.example.demo.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardContorller {	
	private BoardService boardService;

//	//전체조회
//	@GetMapping("/list")
//	@ResponseBody //조회한 값을 리턴
//	public List<BoardDTO> list(Model model) {
//		
//		log.info("list");
//		//model.addAttribute("list", boardService.getList());
//		return boardService.getList();
//	}
	//전체조회
	@GetMapping("/list")
	public void list(Model model, 
					 BoardSearchDTO searchDTO,
					 Paging paging) {
		
		log.info("list");
		
		//페이징처리
		paging.setTotalRecord(boardService.getCount(searchDTO));
		
		//목록조회
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		model.addAttribute("list", boardService.getList(searchDTO)); 
	}
	
	//등록페이지가는곳
	@GetMapping("/register")
	public void register(BoardDTO board) {}
	
	//등록처리
	@PostMapping("/register")
	public String register(@Validated BoardDTO board,
						   BindingResult bindingResult,
			               RedirectAttributes rttr) {
		if(bindingResult.hasErrors()) {
			return "board/register";
		}
		
		log.info("register" + board);
		
		boardService.register(board);
		
		//rttr.addAttribute("result", true); //파라미터 붙어서 나오는거
		rttr.addFlashAttribute("result", true); //휘발성
		return "redirect:/board/list";
	}
	//수정
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam(name="bno") Long bno, Model model) {
		BoardDTO board = boardService.get(bno);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("modify" + board);
		
		boardService.modify(board);
		
		//rttr.addAttribute("result", true); //파라미터 붙어서 나오는거
		rttr.addFlashAttribute("result", true); //휘발성
		return "redirect:/board/list";
	}
	//삭제
//	@GetMapping("/remove")
//	public String remove(@RequestParam(name="bno") Long bno, Model model) {
//		boardService.remove(bno);
//		
//		return "redirect:/board/list";
//	}
	@GetMapping("/remove")
	public String remove(BoardDTO board, RedirectAttributes rttr) {
		log.info("remove : " + board);
		boardService.remove(board.getBno());	
		
		//rttr.addAttribute("result", true); = 사라지지않고 계속 남아있음
		rttr.addFlashAttribute("remove", true);	// 회발성으로 한번만 출력되고 새로고침되면 사라짐
		return "redirect:/board/list";
	}
	

}
