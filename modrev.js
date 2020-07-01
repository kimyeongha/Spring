/**
 * 
 */

$(document).ready(function(){
	var formObj = $("form");    //form 태그를 통채로 formObj에 저장
	$("button").on("click",function(e){   //e는 click이벤트의 정보를 가지고 있다.
	  
	    e.preventDefault();   //싹다button 누르면 다 작동하니까 일단 안움직이게 함
	    
	     var operation =$(this).data("oper");  //this 없으면 button 눌렀을때  3개 다작동 됨
	    alert(operation);
	    if(operation==="remove"){
	    	
	    	formObj.attr("action","/kyh/board/remove");
	    	
	    }else if(operation==="list"){
	    //self.location="/kyh/board/list"
	   
	    	formObj.attr("action","/kyh/board/list").attr("method","get");
	    	
	    var pageNumTag =$("input[name='pageNum']").clone();  //jq 의 선택자 input tag name이 pageNum과 같은 것을 선택해라
	    var amountTag =$("input[name='amount']").clone();
	    var keywordTag =$("input[name='keyword']").clone();
	    var typeTag =$("input[name='type']").clone();  //.clone은 객체 복사
	      //일단 다 클론하고 
	      formObj.empty();//다없애고 
	      formObj.append(pageNumTag);  //필요한부분만 붙인다 . append 는 추가.
	      formObj.append(amountTag);   //필요한 부분만 생긴다.
	      formObj.append(keywordTag);
	      formObj.append(typeTag);
	     
	    
	    }
	    formObj.submit();
	});
	
});