package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // json형식으로 바뀜
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		return "안녕하세요";
	}
	@GetMapping(value = "/getTextEntity")
	public ResponseEntity<String> getTextEntity() {
		return new ResponseEntity<>("안녕하세요", HttpStatus.BAD_GATEWAY);
	}

	@GetMapping("/getSample")
	public SampleVO getSample() {//데이터만 넘어감
		return new SampleVO(100, "길동", "홍", new Date());
	}
	
	@GetMapping("/getSampleEntity")
	public ResponseEntity<SampleVO> getSampleEntity() {////데이터랑 상태값 같이 넘어감
		SampleVO sample = new SampleVO(100, "길동", "홍", new Date());
		return new ResponseEntity<>(sample, HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/getMap") //form
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("sample", new SampleVO(100, "길동", "홍", new Date()));
		map.put("total", 20);
		map.put("success", true);
		return map;
	}

	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, // 배열로 넘겨주기
			@PathVariable(name = "pid") Integer prdid) {// 이름 변경가능

		return new String[] { cat, "" + prdid };
	}

	@PostMapping("/ticket")
	public List<Ticket> convert(@RequestBody List<Ticket> ticket) {
		log.info("ticket: " + ticket);
		return ticket;
	}
	
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp){
		log.info("owner : " + comp.getList().get(0).getOwner());
		return comp;
	}
	
//	@PostMapping("/compMap")
//	public Map<String, Object> compMap(@RequestBody Map<String, Object> map){
//		
//		log.info("owner : " + ((Map<String, Object>) ((List<Object>)map.get("list")).get(0)).get("owner"));
//		//첫번째 티켓의 owner출력
//		return map;
//	}
	
	@PostMapping("/compMap")
	public JsonNode compMap(@RequestBody JsonNode node){
		
		//첫번째 티켓의 owner출력
		log.info("owner : " + node.get("list").get(0).get("owner").asText());
		return node;
	}
	
	@GetMapping("/movie")
	public List<String> movie(
		@RequestParam(defaultValue = "20240115", required=false) String date) {
		RestTemplate restTemplate = new RestTemplate();
		String url ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+date;
		JsonNode node = restTemplate.getForObject(url, JsonNode.class);
		
		List<String> asd = new ArrayList<>();
		
		for(int i=0; i<node.get("boxOfficeResult").get("dailyBoxOfficeList").size(); i++) {
		String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(i).get("movieNm").asText();
		asd.add(name);
		}
		return asd;
	}
}
