package com.example.demo;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjsectMapperTest {

	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		//string ==> vo //@RequestBody 쓰면 자동
		String str = """
					{
					"name" : "홍",
					"age" : 20
					}
				""";
		
		ObjectMapper om = new ObjectMapper();
		MemVO vo  = om.readValue(str, MemVO.class);
		assertThat(vo.getName()).isEqualTo("홍");
		
		//vo ==> string //@ResposneBody 쓰면 자동
		//vo.setAge(30);
		String data = om.writeValueAsString(vo);
		log.info(data);
	}

}
