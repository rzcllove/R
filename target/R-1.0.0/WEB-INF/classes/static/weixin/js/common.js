//请求前缀
var baseURL = "/";
function ajax(url,afterPost,async){
	 //默认为异步
   if (!async)
       async = false;
	 else
	     async = true; 
	 $.ajax(
	 {
	     type: "POST",
	     url: url,
	     data: {},
	     contentType: "application/x-www-form-urlencoded;charset=utf-8",
	     cache: false,
	     dataType: 'text',
	     async: async,
	     success: function (data) {		         
	         if(afterPost instanceof Function)
	         	afterPost(data);
	     },
	     error: function (xhr, data) { 
	    	 alert("请求失败!");		         
	         return false;
	     }
	 });
}