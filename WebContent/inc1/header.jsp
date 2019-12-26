<%@page import="pck.MemDto"%>
<%@ page pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>

<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

  <title>Cafe</title>
</head>

<%
	String uri = request.getRequestURI();
String contextPath = request.getContextPath();
%>

<body>
  <!--nav bar start-->
  <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #563d7c;">
    <a class="navbar-brand" href="<%=contextPath %>/index.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
      aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <li class="nav-item <%if(uri.startsWith("/dept")){ %> active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/dept/list.jsp">부서관리 </a>
        </li>
       <li class="nav-item <%if(uri.startsWith("/emp")){ %> active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/emp/list.jsp">사원관리 </a>
        </li>
       <!-- <li class="nav-item <%if(uri.startsWith("/notice")){ %> active<%} %>">
          <a class="nav-link" href="/notice/notice.jsp">공지사항 <span class="sr-only">(current)</span></a>
        </li>-->
        <li class="nav-item <%if(uri.startsWith("/crawling")){ %> active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/crawling/list.jsp">크롤링</a>
        </li>
        <!--<li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
              </li>-->
       <li class="nav-item <%if(uri.startsWith("/member")){ %> active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/member/list.jsp">회원관리</a>
        </li>
        <li class="nav-item <%if(uri.startsWith("/file")){ %> active<%} %>">
          <a class="nav-link" href="<%=contextPath %>/apply.jsp">어플라이</a>
        </li>
      </ul>
      <ul class="navbar-nav">
      
       <% MemDto mdto = (MemDto)session.getAttribute("member");
      if(mdto == null){
    	  
      %>
      <li class ="nav-item">
      <a class="nav-link" href="<%=contextPath %>/regst.jsp">회원가입 </a>
      </li>
      <li class ="nav-item">
      <a class="nav-link" href="<%=contextPath %>/login.jsp">로그인</a>
      </li>
      
      <%}else{ %>
      <li class ="nav-item">
      <a class="nav-link" href="#"><%=mdto.getId() %>님 환영합니다.</a>
      </li>
      <li class ="nav-item">
      <a class="nav-link" href="<%=contextPath %>/logout.jsp">로그아웃 </a>
      </li>
      
      
      <%} %>
      
      </ul>
      
    </div>
  </nav>
  <!--nav bar end-->
