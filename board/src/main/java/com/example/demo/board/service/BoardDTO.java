package com.example.demo.board.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	  @NotBlank(message = "이름입력")
	  @NotNull
	  private String title;
	  @NotBlank
	  @NotNull
	  private String content;
	  @NotBlank
	  @NotNull
	  private String writer;
	  private Date regdate;

	  private Date updatedate;
	  
	  //댓글수 업데이트
	  private int replyCnt;

}
