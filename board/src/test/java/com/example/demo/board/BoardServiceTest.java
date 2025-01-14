package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		BoardDTO board = BoardDTO.builder()
								 .title("수정된 제목")
								 .content("수정된 내용")
								 .writer("수정된 작가")
								 .bno(3L)
								 .build();
		//when
		boolean result = boardService.modify(board);
		//then
		assertThat(result).isEqualTo(true);
	}
}
