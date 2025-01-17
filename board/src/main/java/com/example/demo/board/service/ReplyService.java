package com.example.demo.board.service;

public interface ReplyService {
	public ReplyPageDTO getList(ReplySearchDTO searchDTO, Long bno);
	
	public ReplyDTO get(Long rno);
	
	public boolean register(ReplyDTO reply);

	public boolean modify(ReplyDTO reply);

	public boolean remove(Long rno);
	
}
