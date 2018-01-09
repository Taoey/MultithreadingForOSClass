<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="jquery.min.js"></script>
</head>
<body>
<div id="mainContent"></div>

<a href="MainServlet"><button >启动</button></a>
<button onClick="ajaxShow()">ajax启动</button>
<button onClick="pause()">暂停</button>
<button onClick="reset()">重置</button>
<button onClick="rerun()">继续</button>
<button onClick="show()">查看</button>
<button onClick="saveData()">保存数据</button>
<script type="text/javascript">

function pause(){
	   $.ajax({
        url : 'DownServlet',
        async : true,
        type : "POST",
    });
}
function ajaxShow(){
	   $.ajax({
           url : 'MainServlet',
           async : true,
           type : "POST",
       });
}
function rerun(){
	   $.ajax({
        url : 'RerunServlet',
        async : true,
        type : "POST",
    });
}
function reset() {
	   $.ajax({
           url : 'ResetServlet',
           async : true,
           type : "POST",
       });
}
function saveData(){
	   $.ajax({
           url : 'SaveDataServlet',
           async : true,
           type : "POST",
       });
}
</script>

<script language="JavaScript"> 
window.setInterval(show,100); 
function show(){
	 
	 var url = "DataServlet";
	 var data = {type:1};
	 $.ajax({
	  type : "get",
	  dataType:"json",
	  async : false, //同步请求
	  url : url,
	  //data : data,
	  timeout:1000,
	  success:function(dates){
	  console.log(dates);
      $("#mainContent").empty();
      $("#mainContent").append(""+dates.num1+dates.num2+dates.num3+dates.num4+dates.num5);
      $("#mainContent").append("</br>"+dates.freeBox1+dates.freeBox2+dates.freeBox3);
      $("#mainContent").append("</br>"+dates.box4Size);
	  },
	  error: function() {
		  console.log("Error");
	      }
	 });
	 }
</script>

</body>
</html>