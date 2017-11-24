<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.lenovo.util.DataDownUtil" pageEncoding="UTF-8"%>
<%
List<HashMap<String, Object>> list = DataDownUtil.getJobInfo("file:///F:/Noname1--ANSI.html","gbk");
out.println(JSONUtil.serialize(list));
%>


