package com.example.demo.board.mapper;

import java.util.List;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

public interface BoardMapper {
	
	//등록
	int insert(BoardDTO boardDTO);
	//수정
	int update(BoardDTO boardDTO);
	//삭제
	int delete(Long bno);
	//단건조회
	BoardDTO read(Long bno);
	//전체조회
	List<BoardDTO> getList(BoardSearchDTO searchDTO);
	//페이징
	int getCount(BoardSearchDTO searchDTO);
}
