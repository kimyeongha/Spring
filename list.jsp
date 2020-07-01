<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>
<!-- Begin Page Content -->

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var result = '<c:out value="${result}"/>';

						history.replaceState({}, null, null);

						$("#regBtn").on("click", function() {
							self.loction = "/board/register";
						});
						var actionForm = $("#actionForm");
						$(".paginate_button a").on(
								"click",
								function(e) { //클릭한 .paginate_button 버튼의 하위 속성 a 가 a태그 말하라는 거  
									e.preventDefault(); //기본 a태그 능력지우고
									console.log('click');
									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href")); //page num이라는 네임찾아라 그리고 그것의 값을 href 에 넣어라  <<밑에 있음
									actionForm.submit();
								});

					
						$(".move").on(
										"click",
										function(e) {
											e.preventDefault();
											actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
											actionForm.attr("action","/kyh/board/read");
											actionForm.submit();
										});
                         
						var searchForm = $('#searchForm');
						$("#searchForm button").on("click",function(e){
							if(!searchForm.find("option:selected").val()){   //val()가 매개변수 있으면 setter 없으면 getter
								alert('검색종류를 선택하세요');
							     return false;  //이걸 호출한데는 button 이니까 botton 으로 감
							}
						    if(!searchForm.find("input[name='keyword']").val()){
						    	 alert("키워드를 입력하세요");
						    	 return false;
						    }
					      	//검색후 무조건 1페이지로 이동하도록
					      	searchForm.find("input'[name='pageNum']").val("1");
										e.preventDefault();
										searchForm.submit;
						});
						
						
					});
</script>


<div class="container-fluid">


	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>

						</tr>
					</thead>
					<tfoot>
						<tr>

						</tr>
					</tfoot>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno }"></c:out></td>

								<!-- <td><a href="/kyh/board/read?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum} &amount=${pageMaker.cri.amount}"><c:out
											value="${board.title }"></c:out></a></td> -->
								<td><a class='move' href="<c:out value='${board.bno}'/>">
										<c:out value="${board.title}"></c:out>
								</a></td>
								<td><c:out value="${board.writer}"></c:out></td>

								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regdate}" /></td>

								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate}" /></td>
							</tr>



						</c:forEach>

					</tbody>
					<tr>
						<td colspan="5"><a href="/kyh/board/register">글쓰기</a>
							${pageMaker.startPage} ${pageMaker.endPage}</td>
					</tr>
				</table>

				<!-- 검색을 위한 처리 -->
				<div class='row'>
					<div class='col-lg-12'>
						<form id='searchForm' action='/kyh/board/list' method='get'>
							<select name='type'>
								<option value=" "<c:out value='${pageMaker.cri.type==null?"selected":" "}'/>> --</option>
								<!-- value값 없으면 전체 -->
								<option value="T" <c:out value="${pageMaker.cri.type eq 'T'? 'selected':' '}"/>>제목</option>
								<option value="C"<c:out value="${pageMaker.cri.type eq 'C'? 'selected':' '}"/>>내용</option>
								<option value="W"<c:out value="${pageMaker.cri.type eq 'W'? 'selected':' '}"/>>작성자</option>
								<option value="TC"<c:out value="${pageMaker.cri.type eq 'TC'? 'selected':' '}"/>>제목+내용</option>
								<option value="TW"<c:out value="${pageMaker.cri.type eq 'TW'? 'selected':' '}"/>>제목+작성자</option>
								<option value="TWC"<c:out value="${pageMaker.cri.type eq 'TWC'? 'selected':' '}"/>>제목+내용+작성자</option>

							</select> <input type="text" name='keyword' value="${pageMaker.cri.keyword}"> 
							<input type="hidden" name='pageNum' value="${pageMaker.cri.pageNum}">
							 <input type="hidden" name='amount' value="${pageMaker.cri.amount}">
							<button class="btn btn-defalut">Search</button>

						</form>

					</div>
				</div>
				<div class="pull-right">
					<ul class="pagination">
						<c:if test='${pageMaker.prev}'>
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1}">previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">

								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage +1} ">Next</a></li>
						</c:if>
					</ul>

				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<form id="actionForm" action="/kyh/board/list" method="get">
	<input type='hidden' name="pageNum" value='${pageMaker.cri.pageNum}'>
	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
    <input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type}"/>'>
     <input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
    
     

</form>
<!-- End of Main Content -->
<%@include file="../includes/footer.jsp"%>
