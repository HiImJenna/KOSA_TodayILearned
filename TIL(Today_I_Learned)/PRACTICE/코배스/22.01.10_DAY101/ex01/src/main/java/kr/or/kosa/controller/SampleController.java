package kr.or.kosa.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosa.domain.SampleDTO;
import kr.or.kosa.domain.SampleDTOList;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/")
@Log4j
public class SampleController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		System.out.println("basic get ............ ");
	}

	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		System.out.println("basic get ............ ");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println("" + dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List") 
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		System.out.println("ids : " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		System.out.println("array ids : " + Arrays.toString(ids));

		return "ex02Array";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {	
		return "ex02Bean";
	}
	
	//int인 page는 화면 출력 안됨
//	@GetMapping("/ex04")
//	public String ex04(SampleDTO dto, int page) {
//		return "/sample/ex04";
//	}
	//해결하려면 아래처럼 어노테이션
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		return "/sample/ex04";
	}

	@GetMapping("/ex05")
	public void ex05() {
		log.info("ex05...");
	}
	
	//dto 자체를 return -> json 타입으로
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06....");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	

}
