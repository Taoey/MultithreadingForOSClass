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
<button onClick="show()">查看</button>




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
      var num= dates.num; 
      console.log(num)
       $("#mainContent").empty();
       for(var i=0;i<num;i++){
           $("#mainContent").append("<button>"+i+"</button>");
       }
       $("#mainContent").append(num);
	  console.log("YES");
	  },
	  error: function() {
		  console.log("Error");
	      }
	 });
	 }
</script>
</body>
</html>