package org.zerock.controller;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/sample")
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sample/abc", method = RequestMethod.GET)  //주소창에 넣는것이나 a태그는 get 방식이다. post방식은 form으로 밖에 못한다.
	public void sample() {
		logger.info("-----------------------------------sample");   //logger.info ==System.out.println();
		
	   //forward로 가버려
	
	  //만약 return 값이 없이면 그냥 value 가 그대로 return 되어 버린다.  forward방식으로 
	        //만약 @RuquestMapping 이 두개면 전에꺼 + 뒤에꺼가 경로가 된다.  또 만약 리턴 없으면 가장 최근에꺼 가 리턴이 되어버림.
	}
	//@RequestMapping의 속성으로 get 을 하는 방법
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST})
	public String basicGet1() {
		logger.info("basic111--------------------------both----------------------------------");
	   return "sample/papa2";  //return 값으면 value값 그대로 사용.
	}
	//@GetMapping으로 get 하는 방법
	  @GetMapping("/basicOnlyGet")
	  public void basicGet() {
		  logger.info("basic2-------------only-------222222222222222222-2222-22");
	  }
	  // SampleDto를 매개변수로 선언하여, 자동으로 setter메소드 동작하여 데이터 수집
	  // name 변수와 age변수로 선언하여 데이터 수집
	  @GetMapping("/ex03")
	  public String ex3(@RequestParam("name") String name,
			  @RequestParam("age") String age) {
		  logger.info("name="+name);
		  logger.info("age="+age);
		  return "ex03";
	  }
	
	  @GetMapping("/ex02")
	  public String ex3(SampleDTO dto) {
		  logger.info(""+dto);
		  
		  return "ex02";
	  }
	  //매개변수로 배열로 입력받아서 처리
	  @GetMapping("/ex02List")
	  public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		 logger.info(""+ids);
		  return "ex02List";
	  }
	  @GetMapping("/ex02Array")
	  public String ex02Array(@RequestParam("ids") String[] ids) {
		 logger.info(""+Arrays.toString(ids));
		  return "ex02Array";
	  }  
	  @GetMapping("/ex02Bean")
	  public String ex02Bean(SampleDTOList list) {
		 logger.info("list dto:"+list);
		  return "ex02Bean";
	  }
	  @GetMapping("/ex04")
	  public String ex04(TodoDTO todo) {
		  logger.info("list dtos:" + todo);
		  return "ex04"; //forward방식으로 보내고.
	  }
	/*
	  @InitBinder
	  public void initBinder(WebDataBinder binder) {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM--dd");
		  binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat,false));
	  }
	  */
	 // @GetMapping("/ex05")
	 // public String ex05(SampleDTO dto,int page) {
	   // logger.info("dto:" +dto);
	    //logger.info("page:"+page);
		 // return "sample/ex05";
		  
	 // }
	  @GetMapping("/ex05")
	  public String ex05(SampleDTO dto,@ModelAttribute("page")int page) {  //굳이 sampleDTO에 없을경우 그래도 출력하고 싶다 !
	    logger.info("dto:" +dto);
	    logger.info("page:"+page);
		  return "sample/ex05";
		  
	  }
	 //redirect 방식으로 데이터 전달 
	  @GetMapping("/ex06")
	  public String ex06(RedirectAttributes rttr) {
		  rttr.addFlashAttribute("name", "kakaka");   //redirect방식이니까 뭐 그 전에데이터는 됫고 이거만 보내줘라
		  return "redirect:/ex07";  //return 할떄 redirect:을 꼭붙혀 줘야한다.
	  }    //redirect 방식은 ex06>ex06 jsp로 못가니까 06 >07(forward) >07.jsp로
	  @GetMapping("/ex07")
	  public String ex07(@ModelAttribute("name") String name) {
		  return "/ex07";
	  }
	  @GetMapping("/ex08")
    public @ResponseBody SampleDTO ex06() {  //return하기 위해서는 어너테이션 필요
         logger.info("/ex08.................");
		  SampleDTO dto = new SampleDTO();
         dto.setAge(10);
         dto.setName("홍길동");
		  return dto;
		  
	  }
	  @GetMapping("/ex09")
	  public ResponseEntity<String>ex09(){
		  logger.info("/ex09.......................");
		  String msg="{\"name\":\"홍길동\"}";
		  HttpHeaders header = new HttpHeaders();
		  header.add("Content-type","application/json;charset=UTF-8");
		  return new ResponseEntity<>(msg,header,HttpStatus.OK);  //상태가 원할할떄 msg할 header보내라 
	  }
	  //exUpload.jsp를 실행하기 위한 용도
     @GetMapping("/exUpload")
     public void exUpload() {
    	 logger.info("/exUpload........................");
     }
	  // 파일upload를 하기 위한 용도(서버) :post upload는 get방식 지원 안함.
	  @PostMapping("/exUploadPost")
	  public void exUploadPost(ArrayList<MultipartFile>files) {      //사진이 여러장이니까 배열로 저장
		  files.forEach(file ->{
			  logger.info("--------------------------------------------------");
			  logger.info("name:"+file.getOriginalFilename() );
			  logger.info("size:"+file.getSize());
			  
		  });
	  }
	  
	  
	  
}

