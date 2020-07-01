<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<script type="text/javascript" src="../resources/js/modrev.js"></script>

<form role="form" action="/kyh/board/modify" method="post">
   <div class="row">
      <div class="col-lg-12">
      <div class="panel panel-default">
       <input type='text' id='bno' name='bno' value='<c:out value="${board.bno}" />' >
	  <input type='text' name="pageNum" value='<c:out value="${cri.pageNum}" />' >
	  <input type='text' name='amount' value='<c:out value="${cri.amount}" />' >
	   <input type='text' name='type' value='<c:out value="${cri.type}" />' >
	  <input type='text' name='keyword' value='<c:out value="${cri.keyword}" />' >
       
       <div class="form-group">
       <label>bno</label>
        <input class="form-control "  name="bno" value="<c:out value='${board.bno}'/>" readonly="readonly">
          </div>   

       <div class="form-group">
       <label>Title</label>
        <input class="form-control "  name="title" value=" <c:out value='${board.title}'></c:out>" >
          </div>
          <div class="form-group">
          <label>Content</label>
               <textarea rows="3" name="content"><c:out value=" ${board.content}"/></textarea>
          
          </div>
          
          <div class="form-group">
          <label>Writer</label>
          <input class="form-control" name="writer" value=" <c:out value='${board.writer}'></c:out>" >
           <input type="text" name="pageNum" value="<c:out value='${cri.pageNum}'/>">
            <input type="text" name="amount" value="<c:out value='${cri.amount}'/>">
          </div>
 <button type="submit" data-oper="modify"class="btn btn-default" id="modify">modifySubmit</button>
 
   <button type="submit" data-oper='remove'class="btn btn-default" id="remove">remove</button>  <!-- submit이 두개인데 위에 action은 modify 였다 -->
   <button type="submit" data-oper='list' class="btn btn-default" id="list">list</button>
  
         </div>
      </div>  
   </div>
</form>
<%@ include file="../includes/footer.jsp" %>