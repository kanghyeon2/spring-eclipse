package com.example.demo.board;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
@SpringBootTest
public class BoardControllerTest {

	@Autowired
	MockMvc mvc;
	
	//@Test
	@DisplayName("조회컨트롤러")
	void list() throws Exception {//get불러오기
		mvc.perform(get("/board/list"))
		.andExpect(status().isOk());
		//.andDo(MockMvcResultHandlers.print());
	}
	
	//@Test
    @DisplayName("등록 테스트")
    void main() throws Exception  {
    	String param = "title=moctest&content=내용&writer=kim";
    	mvc.perform(post("/board/register")
    	   .content(param)
    	   .contentType(MediaType.APPLICATION_FORM_URLENCODED)
    	)
//    	 .andExpect(status().isOk())
//         .andExpect((ResultMatcher) content().string("main"))
//         .andDo(MockMvcResultHandlers.print());
         ;  
    }
}
