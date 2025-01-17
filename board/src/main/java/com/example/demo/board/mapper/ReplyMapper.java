package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplySearchDTO;

public interface ReplyMapper {
	//전체조회
	public List<ReplyDTO> getList(@Param("bno") Long bno,
								  @Param("cri") ReplySearchDTO cri);
	//단건조회
	public ReplyDTO read(Long rno);
	//등록
	public int insert(ReplyDTO replyDTO);
	//수정
	public int update(ReplyDTO replyDTO);
	//삭제
	public int delete(Long rno);
	
	public int getCountByBno(Long bno);
	
	public int deleteByBno(Long bno);
}
