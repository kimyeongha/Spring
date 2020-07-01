<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

   <div class="row">
      <div class="col-lg-12">
      <div class="panel panel-default">
   
   <form role="form" action="/kyh/board/register" method="post">
       <div class="form-group">
       <label>Title</label>
        <input class="form-control "  name="title">
          </div>
          <div class="form-group">
          <label>Content</label>
               <textarea rows="3" name="content"></textarea>
          
          </div>
          
          <div class="form-group">
          <label>Writer</label>
          <input class="form-control" name="writer">
          </div>
   <button type="submit" class="btn-default">Submit Button</button>
    <button type="reset" class="btn-default">Reset Button</button>
   
   </form>
         </div>
      </div>  
   </div>

<%@ include file="../includes/footer.jsp" %>