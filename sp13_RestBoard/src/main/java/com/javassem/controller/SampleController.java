package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;

//@Controller
@RestController
public class SampleController {

	//1. 문자열 반환
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	//@ResponseBody
	public String getTest() {
		return "내가 보냄@@@";
	}
	
	//2.객체 반환
	@GetMapping(value="/getObject")
	public SampleVO getObejct(Model model) {
		SampleVO vo = new SampleVO("김연아",33,"우리는 지금 REST TEST");
		model.addAttribute("vo",vo);
		return vo;
	}
	
	//3.배열 반환
	@GetMapping(value="/getList")
	public List<SampleVO> getList(Model model){
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("김연아",33,"우리는 지금 REST TEST"));
		list.add(new SampleVO("양승윤",27,"신림 메이플 왕"));
		list.add(new SampleVO("윤성호",29,"의정부 칼잡이"));
		
		return list;
	}
	
	//4.URL에서 정보 얻기	/sample/{cate}/{no}
	@GetMapping(value="/sample/{cate}/{cno}")
	public String[] getPath(@PathVariable String cate, @PathVariable Integer cno) {
		return new String[] {"카테고리 :"+cate,"번호: "+cno};
	}
	
	//5.POST 전송
	@PostMapping(value="/sample/data")
	public SampleVO post(@RequestBody SampleVO vo) { //Body에 숨겨서 옮
		System.out.println(vo);
		System.out.println("[확인]");
		return vo;
	}
	
}
	