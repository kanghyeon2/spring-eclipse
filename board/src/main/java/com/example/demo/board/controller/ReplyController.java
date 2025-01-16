package com.example.demo.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/replies/")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ReplyController {
	private final ReplyService replyservice;
	//등록처리
	@PostMapping("/new")
	public ReplyDTO register(@RequestBody ReplyDTO dto) {
		replyservice.register(dto);
		return dto;
	}
	
	//수정처리
	@PutMapping("/{rno}")
	public ResponseEntity<String>modify(
			@RequestBody ReplyDTO replyDTO,
			@PathVariable(name="rno") Long rno){
		replyDTO.setRno(rno);
		return replyservice.modify(replyDTO)==true
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	//삭제처리
	@DeleteMapping("/{rno}")
	public String remove(@PathVariable(name="rno") Long rno) {
		replyservice.remove(rno);
		return "success";
	}
		
	//단건조회
	@GetMapping("/{rno}")
	public ReplyDTO get(@PathVariable("rno") Long rno) {
		return replyservice.get(rno);
	}
	
	//댓글목록조회
	@GetMapping("/pages/{bno}/{page}")
	public ReplyPageDTO getList(@PathVariable(name="page") int page,
								@PathVariable(name="bno") Long bno) {
		ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 10);
		
		return replyservice.getList(replySearchDTO, bno);
	}
}
