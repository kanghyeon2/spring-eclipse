package com.example.demo.board.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	  private Long bno;
	  private String title;
	  private String content;
	  private String writer;
	  private Date regdate;
	  private Date updatedate;

}
