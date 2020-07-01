<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<script src="../resources/js/read.js"></script>
<form id="operForm" action="/kyh/board/modify" method="get">
	<input type='text' id='bno' name='bno' value='<c:out value="${board.bno}" />' >
	<input type='text' name="pageNum" value='<c:out value="${cri.pageNum}" />' >
	<input type='text' name='amount' value='<c:out value="${cri.amount}" />' >
	<input type='text' name='type' value='<c:out value="${cri.type}" />' >
	<input type='text' name='keyword' value='<c:out value="${cri.keyword}" />' >
	

</form>
   <div class="row">
      <div class="col-lg-12">
      <div class="panel panel-default">
       
       
       <div class="form-group">
       <label>bno</label>
        <input class="form-control "  name="bno" value="<c:out value='${board.bno}'/>" readonly="readonly">
          </div>   

       <div class="form-group">
       <label>Title</label>
        <input class="form-control "  name="title" value=" <c:out value='${board.title}'></c:out>" readonly="readonly">
          </div>
          <div class="form-group">
          <label>Content</label>
               <textarea rows="3" name="content" readonly><c:out value=" ${board.content }"/></textarea>
          
          </div>
          
          <div class="form-group">
          <label>Writer</label>
          <input class="form-control" name="writer" value=" <c:out value='${board.writer}'></c:out>" readonly="readonly">
          </div>
   <!--   <a href="/kyh/board/modify?bno=<c:out value='${board.bno}'/>" > <button data-oper="modify" class="btn-default">Modify Button</button></a>
    <a href="/kyh/board/list"><button data-oper="list" class="btn-default">List Button</button></a>  -->
   <button data-oper="modify" class="btn-default">Modify Button</button>
   <button data-oper="list" class="btn-default">List Button</button>
   
  
         </div>
      </div>  
   </div>

<%@ include file="../includes/footer.jsp" %>