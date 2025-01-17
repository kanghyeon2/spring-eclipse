package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;
import com.example.demo.common.Paging;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper replyMapper;
	
	private final BoardMapper boardMapper;
	
	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Transactional
	@Override
	public boolean register(ReplyDTO reply) {
		
		boardMapper.updateReplyCnt(reply.getBno(), 1);
		
		return replyMapper.insert(reply)==1 ? true : false;
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return replyMapper.update(reply)==1 ? true : false;
	}

	@Transactional
	@Override
	public boolean remove(Long rno) {
		
		ReplyDTO reply = replyMapper.read(rno);
		boardMapper.updateReplyCnt(reply.getBno(), -1);
		
		return replyMapper.delete(rno)==1 ? true : false;
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO searchDTO, Long bno) {
		Paging paging = new Paging();
		int cnt = replyMapper.getCountByBno(bno);
		
		//paging - 전체건수, pageUnit, page
		paging.setPage(searchDTO.getPage());
		paging.setPageUnit(searchDTO.getAmount());
		paging.setTotalRecord(cnt);
		return new ReplyPageDTO(
				cnt,
				paging,
				replyMapper.getList(bno, searchDTO)
				);
	}


}
