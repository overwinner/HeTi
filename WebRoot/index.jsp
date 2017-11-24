<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>knerl</title>
		<meta name="keywords" content="关键词，关键词">
		<meta name="description" content="">

		<style type="text/css">
			*{margin:0;padding:0;}
			body{font-size:12px;font-family:"微软雅黑";color:#666;}

			h1{text-align:center;line-height:100px;}

			/*import*/
			.import{width:800px;margin:0 auto;}
			.import .i-btn{width:140px;height:38px;display:block;background:#188eee;text-align:center;line-height:38px;text-decoration:none;color:#fff;font-size:14px;}
			.import .i-btn:hover{background:#1081dc;}
			.import .list p{font-size:14px;line-height:46px;padding-left:10px;}
			.import .i-con{border-top:1px solid #e2e2e2;border-bottom:1px solid #e2e2e2;margin:40px 0;}
			.import .i-con .i-list{margin:20px 0;}
			.import .i-con .i-list:hover{background:#f7f7f7;}
			/*import*/
		</style>

	</head>
	<body>

		<h1>knerl</h1>

		<div class="import">
			<a href="#" class="i-btn">上传</a>
			<div class="i-con">
				<!-- <div class="i-list">-->
					<!-- <p>第1节课</p>-->
					<!-- <p>第1节课描述</p> -->
				<!-- </div>-->
			</div>

		</div>
<!-- 引入jQuery 9000-->
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	jQuery(function(){
		
		//点击解析
		$(".i-btn").click(function(){
			$.ajax({
				type:"post",
				beforeSend:function(data){
					//数据解析中，请稍后。。。
				},
				url:"data.jsp",
				success:function(data){
					//alert(data);
					var jdata = eval("("+data+")");
					var html = "";
					for(var i=0;i<jdata.length;i++){
						    html+= "<div class='i-list'>"+
							"<p>第 "+(i+1)+" 个 No: "+jdata[i].No+"</p>"+
							"<p>第 "+(i+1)+" 个 PN: "+jdata[i].PN+"</p>"+
							"<p>第 "+(i+1)+" 个 Description: "+jdata[i].Description+"</p>"+
							"<p>第 "+(i+1)+" 个 BorrowDate: "+jdata[i].BorrowDate+"</p>"+
							"</div>";
					}
					//填充内容
					$(".i-con").html(html);
					//数据解析成功
					
				}
			});
		});
	});
</script>
	</body>
</html>


