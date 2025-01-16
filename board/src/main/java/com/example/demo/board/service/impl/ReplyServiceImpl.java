package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyDTO;
import com.example.demo.board.service.ReplyPageDTO;
import com.example.demo.board.service.ReplySearchDTO;
import com.example.demo.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper replyMapper;
	
	@Override
	public ReplyDTO get(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public boolean register(ReplyDTO reply) {
		return replyMapper.insert(reply)==1 ? true : false;
	}

	@Override
	public boolean modify(ReplyDTO reply) {
		return replyMapper.update(reply)==1 ? true : false;
	}

	@Override
	public boolean remove(Long rno) {
		return replyMapper.delete(rno)==1 ? true : false;
	}

	@Override
	public ReplyPageDTO getList(ReplySearchDTO searchDTO, Long bno) {
		return new ReplyPageDTO(
				replyMapper.getCountByBno(bno),
				replyMapper.getList(bno, searchDTO)
				);
	}

}
