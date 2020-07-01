package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller 
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	   //BoardServic service = new BoardService(); 역할을 해주는게 autowired
	@Autowired 
	private BoardService service;
    /* 
	@GetMapping("/list")
     public void list(Model model) {
    	 logger.info(""+"list");
         //Model객체는 controller ->jsp로 데이터를 보내기 위해 사용.    
    	model.addAttribute("list", service.getList());
          
     }
     */
     @GetMapping("/list")
     public void list(Criteria cri,Model model) {
    	 logger.info("list:"+cri);
    	 model.addAttribute("list",service.getList(cri));
         //model.addAttribute("pageMaker",new PageDTO(cri,123));     
            int total= service.getTotal(cri);
            logger.info("total==="+total);
         model.addAttribute("pageMaker",new PageDTO(cri,total));
     }
     
     //글쓰기 화면으로 이동하기 위한@getMapping
     @GetMapping("/register")
     public void register() {
    	 logger.info("----------------------register로 이동----------------------------");
     }
     
     //insert를 하기 위한 service
     @PostMapping("/register")
     public String register(BoardVO board , RedirectAttributes rttr) {
    	   logger.info("register************"+board);
    	   rttr.addFlashAttribute("result",board.getBno()); 
    	   service.register(board);
    	    
    	 
    	 return "redirect:/board/list";
    	 //다시 select하지 않으면 그냥 화면 이동해도 등록 된글이 없다.
     }
     //제목을 클릭했을때 상세페이지.
     @GetMapping("/read")
     public void read(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri,Model model  ) {  //criteria에 page정보랑 등등 들었는데 addAttribute 로 같이 보낸다.
    	 logger.info("read의 bno..........." +bno);
    	 service.get(bno);
    	 //select 된 결과를 model 이라는 객체를 통해서 jsp화면 이동
    	 model.addAttribute("board",service.get(bno));
    	 
     }
     @PostMapping("/modify")
     public String modify(BoardVO board,RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri) {
    	 logger.info("modify"+board);
       //성공하고 list에서 성공했습니다. 라고 하기 위해서 
    	 if(service.modify(board)) {
    	   rttr.addFlashAttribute("result", "성공했습니다.");  //post방식
       }
    	  rttr.addAttribute("pageNum",cri.getPageNum());  //list url에는 get방식처럼 url주소 남기고 싶으므로 addAttribute 로 한다.
		   rttr.addAttribute("amount", cri.getAmount());
    	    rttr.addAttribute("type", cri.getType());
    	    rttr.addAttribute("keyword", cri.getKeyword());
    	    return "redirect:/board/list";
    	    //return "redirect:/board/list"+cri.getListLink();//348p의 uricomponentsBuiler
     
     
     
     
     }
     @PostMapping("/remove")
     public String remove(@RequestParam("bno") int bno,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {   //매개변수로 BoardVO도 틀리지 않음.
    	   logger.info("remove........."+bno);
    	   service.remove(bno);
    	   if(service.remove(bno)) {
    		   rttr.addFlashAttribute("result", "삭제실패!");
    		  
    		  
    		   
    	   }
    	   rttr.addAttribute("pageNum",cri.getPageNum());  //list url에는 get방식처럼 url주소 남기고 싶으므로 addAttribute 로 한다.
		   rttr.addAttribute("amount", cri.getAmount());
		   rttr.addAttribute("type", cri.getType());
   	        rttr.addAttribute("keyword", cri.getKeyword());
    	 
    	   return "redirect:/board/list";
     }
   @GetMapping("/modify")
   public void modify(@RequestParam("bno") int bno ,@ModelAttribute("cri") Criteria cri, Model model) {  //@ModelAttribute("cri) criteria cri 가 있어야  board에 이것도 싣어 보낸다)
	   logger.info("변경modify로 이동");
	   service.get(bno);
	   model.addAttribute("board",service.get(bno));
	   
   }
     
}
