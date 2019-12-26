<%@page import="pck.MemDto"%>
<%@page import="pck.ApplyDto"%>
<%@page import="pck.ApplyDao"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page contentType="appllication/json;charset=utf-8"%>
<% request.setCharacterEncoding("utf-8");%>

<%

//int Ano=0;
//if(request.getParameter("Ano") != ""){
int Ano = Integer.parseInt(request.getParameter("Ano"));
//}
ApplyDao appdao = ApplyDao.getInstance();
boolean istUpdated = appdao.update(Ano);
JSONObject obj = new JSONObject();

if(istUpdated){
	obj.put("result","ok");
}else{
	obj.put("result","fail");
}
out.print(obj.toString());
%>
