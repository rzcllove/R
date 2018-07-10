var vm = new Vue({
	el:'#rapp',
	data:{
		classList : {}
	},
	methods: {
		type_TabFun :function(){//分类下拉
			if(this.toggle){
				$(".type_change").hide();
			}else{
				$(".type_change").show();
			}
			this.toggle = !this.toggle;
		},
		bannerFun :function(){//导航图
			var mySwiper = new Swiper('.swiper-container', {
				autoplay:2000,
				spaceBetween :2,
                pagination: '.swiper-pagination',
                paginationClickable: true,
                loop:true,
                lazyLoading: true,
                onSlideChangeEnd: function (swiper) {
                    swiper.startAutoplay()
                },
                effect : 'flip',
                flip: {
                            slideShadows : true,
                            limitRotation : true,
                        }
				});
		},
		getClassList: function(){
			$.get(baseURL + "weixin/class/list", function(r){
				vm.classList = r.list;
			});
		},
		
	},
	created: function(){//创建前
		
	},
	mounted: function(){//创建后
		this.getClassList();
	}
});

$(function(){
	vm.bannerFun();
})

