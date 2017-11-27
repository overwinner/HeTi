<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@ page language="java" import="java.util.*,com.lenovo.util.*" pageEncoding="UTF-8"%>
<%
List<HashMap<String, Object>> list = DataDownUtil.getJobInfo("file:///F:/Noname1--ANSI.html","gbk");
String path = request.getRealPath("/")+"lenovo_mmweb.xls";
ExcelUtil.exportData(list, path);
out.println(JSONUtil.serialize(list));
out.println(path);
%>


