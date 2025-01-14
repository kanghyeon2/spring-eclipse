package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;

@SpringBootTest
public class BoardMapperTest {
	
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	@DisplayName("게시글 등록")
	public void register() {
		String title = "등록";
	   //given
	   BoardDTO board = BoardDTO.builder()
								.title(title)
								.content("내용")
								.writer("작성자")
								.build(); 
	   //when
	   int cnt = boardMapper.insert(board);
	   //then
	   assertThat(cnt).isEqualTo(1);
	}
}
