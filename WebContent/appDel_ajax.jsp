<%@page import="pck.MemDto"%>
<%@page import="pck.ApplyDto"%>
<%@page import="pck.ApplyDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="appllication/json;charset=utf-8"%>
<% request.setCharacterEncoding("utf-8");%>

<%

int Ano = Integer.parseInt(request.getParameter("Ano"));
ApplyDao appdao = ApplyDao.getInstance();
boolean isSuccess = appdao.delete(Ano);
JSONObject obj = new JSONObject();

if(isSuccess){
	obj.put("result","ok");
}else{
	obj.put("result","fail");
}
out.print(obj.toString());
%>

