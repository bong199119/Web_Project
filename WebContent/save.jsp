<%@page import="pck.MemDto"%>
<%@page import="pck.MemDao"%>
<%@ page pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("password");
	String phone = request.getParameter("phone");
	String loc = request.getParameter("loc");

	MemDao memDao = MemDao.getInstance();
	MemDto memDto = new MemDto(id,pwd,phone,loc);
	boolean isSuccess = memDao.insert(memDto);

	if (isSuccess) {
%>
<script>
	alert('회원 가입이 성공했습니다,메인 페이지에서 다시 로그인해주세요.');
	location.href = "<%=request.getContextPath()%>/index.jsp";
</script>

<%
	} else {
%>
<script>
	alert('DB ERROR : 입력 사항을 다시 확인해주세요.');
	history.back(-1);
</script>
<%
	}
%>