package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	@Test
	@DisplayName("게시글 수정")
	public void update() {
		//given
		BoardDTO board = BoardDTO.builder()
								 .title("제목수정")
								 .content("내용수정")
								 .writer("작가수정")
								 .bno(2L)
								 .build();
		//when
		int cnt = boardMapper.update(board);
		//then
		assertThat(cnt).isEqualTo(1);
	}
	@Test
	@DisplayName("게시글 삭제")
	public void delete() {
		//given

		//when
		int cnt = boardMapper.delete(8L);
		//then
		
		assertThat(cnt).isEqualTo(1);
	}
	@Test
	@DisplayName("게시글 단건조회")
	public void read() {
		//given
		Long bno = 3L;
		//when
		BoardDTO board = boardMapper.read(bno);
		//then
		log.info(board.toString());
		//assertThat(board.getBno()).isEqualTo(bno);
		assertThat(board).isNotNull();
	}
	@Test
	@DisplayName("게시글 전체조회")
	public void getList() {
		//given
		//when
		List<BoardDTO> list = boardMapper.getList();
		//then
		list.forEach(board -> log.info(board.toString()));
		assertThat(list).isNotNull();
	}
}
