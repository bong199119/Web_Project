<%@page import="dto.CommentDto"%>
<%@page import="dao.CommentDao"%>
<%@page import="dao.TotalrateDao"%>
<%@page import="dto.TotalrateDto"%>
<%@page import="dto.ShopinfoDto"%>
<%@page import="dao.ShopinfoDao"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file ="../inc/header.jsp"%>
 
 
 <%

 /*  String sname = request.getParameter("sname"); */
 String sname = "스타벅스";


 CommentDao comdao = CommentDao.getInstance();
 ArrayList<CommentDto> list = comdao.select(sname);
 
 ShopinfoDao infodao = ShopinfoDao.getInstance();
 ShopinfoDto infodto = infodao.select(sname);
 
 TotalrateDao totaldao = TotalrateDao.getInstance();
 TotalrateDto totaldto = totaldao.select(sname); 

 %>
 	<style>
			img { display: block; margin: 0px auto; }
			textarea  { display: block; margin: 0px auto; }
		</style>
 
 <nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="#">Home</a></li>
      <li class="breadcrumb-item active" aria-current="page">Library</li>
    </ol>
  </nav>
	
   <div class="card bg-dark text-white">
  <img src="../image/cafe.jpg"   style = "width : 1200px; height : 700px;" class="card-img" alt="...">
  <div class="card-img-overlay">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
    <p class="card-text">Last updated 3 mins ago</p>
  </div>
</div> 
 
<!--  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../image/cafe.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="../image/1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="../image/2.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
 -->


<table class="table table-borderless">
				<colgroup>
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
					<col width="10%" />
				
					
				</colgroup>
	<thead>
	 <%if(infodto != null) {%>
		
		<tr>
			<th scope="col"><h2> <%=infodto.getSname() %></h2></th>
			<td></td>
		</tr>
		<tr>
		
			<th scope="col">opertime</th>
			<td> <%=infodto.getOpertime()%></td>
			<td></td>
			<td></td>
			
		</tr>
		<tr>
			<th scope="col">location</th>
			<td><%=infodto.getLoc()%> </td>
		</tr>
		<tr>
			<th scope="col">phone</th>
			<td> <%=infodto.getPhone()%> </td>
		</tr>
		<%}else{ %>
		<tr>
			<td colspan="4">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} %> 
	
		
	</thead>
</table>
<table class="table table-borderless">
  <thead>
    <tr>
  
    </tr>
  </thead>
	<tbody>
		<%if(totaldto != null) {%> 
		<tr>
			<th scope="col">mood</th>
			<td>
				<%=totaldto.getMood() %> 
			</td>
			<td></td><td></td><td></td><td></td><td></td>
		</tr>
		<tr>
			<th scope="col">light</th>
			<td> <%=totaldto.getLight() %> </td>

		</tr>
		<tr>
			<th scope="col">price</th>

			<td><%=totaldto.getPrice() %></td>
		</tr>
		<tr>
			<th scope="col">taste</th>

			<td><%=totaldto.getTaste() %> </td>
		</tr>
		<%}else{ %>
		<tr>
			<td colspan="4">데이터가 존재하지 않습니다.</td>
		</tr>
		<%} %> 
	</tbody>

</table>
<div class="text-right">	
						<a href="index.jsp" type="button" class="btn btn-outline-secondary">메인</a>
						  <%--  <%
      	
      	MemberDto memberDto = (MemberDto)session.getAttribute("member");
      	if(memberDto == null){
      		
     
      	
      %>
       --%>
						<a href="write.jsp" type="button" class="btn btn-outline-secondary">글작성</a>
						  <%--    <%} else {%> --%>
						<a href="write.jsp" type="button" class="btn btn-outline-secondary">내글 수정하기</a>
						      <%-- <%} %> --%>
				
			</div> 
<form>
<!-- MemberDto memberDto = (MemberDto)session.getAttribute("member"); 
	MemberDto.getId();
-->

<%
 	if(list.size() != 0){
%>
<%for(CommentDto comdto : list){ %>
 <%-- <%if(MemberDto.getId() == comdto.getId()){ %> --%>
  <div class="form-group" readonly="readonly" >
    <label for="exampleFormControlTextarea1"><%=comdto.getId()%></label>
    <textarea class="form-control"  style = "width : 1570px;" id="exampleFormControlTextarea1" rows="3" readonly="readonly"> <%=comdto.getComm()%></textarea>
  </div>
 <%--  <%} %> --%>
 
  <%-- <%} %>
  <%for(CommentDto comdto : list){ %>
  <%if(MemberDto.getId() != comdto.getId()) {%>
  <div class="form-group" readonly="readonly" >
    <label for="exampleFormControlTextarea1"><%=comdto.getId()%></label>
    <textarea class="form-control"  style = "width : 1570px;" id="exampleFormControlTextarea1" rows="3" readonly="readonly"> <%=comdto.getComm()%></textarea>
  </div>
     <%} %> --%>
    <%} %>
  <%}else{%>
 			 <tr>
			     <td colspan="3">리뷰가 존재하지 않습니다.</td>
			 </tr>
  <%} %>
  
</form>

<div class="text-right" >	
						<a href="index.jsp" type="button" class="btn btn-outline-secondary" style = "width : 80px; ">메인</a>
		
						<a href="view.jsp" type="button" class="btn btn-outline-secondary" style = "width : 95px; ">맨 위로</a>
						
			</div> 



	<!-- <div class="card text-center">
  <div class="card-header">
    Featured
  </div>
  <div class="card-body">
    <h5 class="card-title">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  <div class="card-footer text-muted">
    2 days ago
  </div>
</div>
 -->
<%-- 
<%@ include file="../inc/footer.jsp"%>
 --%>

 
