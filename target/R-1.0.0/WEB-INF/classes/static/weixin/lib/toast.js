(function($){
	var timer=null;
	var time=null;
	$.tost=function(text){
		clearTimeout(timer)	;
		clearTimeout(time)	;
		if($(".toastContent").length==0){
			$("body").append('<div class="toastContent"><div class="toast">'+ text +'</div><style>.toast{ line-height:1.5rem; visibility:hidden; position:fixed; top:50%; left:50%;-webkit-transform:translate(-50%,-50%); -webkit-transition:all ease .5s; color:#FFF; background-color:rgba(102,102,102,0); padding:.5rem 1rem;z-index: 1000; border-radius: 4px; }.toast.active{ visibility: visible; background-color:rgba(102,102,102,1); }</style></div>')
		}
		time=setTimeout(function(){
			$(".toast").addClass("active")
		});
		timer=setTimeout(function(){
			$(".toast").removeClass("active");
			$(".toast").on("webkitTransitionEnd",function(){
				$(this).parent().remove();
			})
		},3000)
	}
})(Zepto);


	
		
		