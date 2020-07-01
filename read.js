/**
 * 
 */

$(document).ready(function(){
	
var operForm =	$("#operForm");
//사용자가 modify버튼을 클릭하면 
//사용자가 modify 버튼을 클릭하면 분기를 시킴 전부 form 안에 있는데 갈수 있는거는 하나밖에 없으니까.
$("button[data-oper='modify']").on("click",function(){   //[]는 속성 선택자
  
	operForm.attr("action","/kyh/board/modify") //action의 속성값을 뒤에 무장으로 바꿔라	
	 operForm.submit();
})
//사용자가 list를 클릭하면
//사용자가  버튼을 클릭하면 분기를 시킴 전부 form 안에 있는데 갈수 있는거는 하나밖에 없으니까.
$("button[data-oper='list']").on("click",function(){   //[]는 속성 선택자

	operForm.find("#bno").remove() //수정할떄와 다르게 list에는 번호가 필요없으니까.
	operForm.attr("action","/kyh/board/list") //action의 속성값을 뒤에 무장으로 바꿔라	
	 operForm.submit();
})

})