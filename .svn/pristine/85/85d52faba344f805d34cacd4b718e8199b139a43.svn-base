$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/weixinshopclass/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,hidden : true },
			{ label: '分类名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '分类图标 186*83', name: 'img', index: 'img', width: 80,formatter:function(v,o,r){
				return '<img src="'+v+'" height="83" width="186"/>'
			}}, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }			
        ],
		viewrecords: true,
        height: 500,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){//所有数据都加载完 走该条数据
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
    
    new AjaxUpload('#upload', {
        action: baseURL + 'sys/oss/upload?token=' + token,
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if(vm.config.type == null){
                alert("云存储配置未配置");
                return false;
            }
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))){
                alert('只支持jpg、png、gif格式的图片！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
            	$("#img").attr("src",r.url);
            }else{
                alert(r.msg);
            }
        }
    });
    
});




var vm = new Vue({
	el:'#r',
	data:{
		showList: true,
		title: null,
		weixinShopClass: {},
		flat: true,
		config: {}
	},
	created: function(){
        this.getConfig();
    },
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.weixinShopClass = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id);
		},
		getConfig: function () {
            $.getJSON(baseURL + "sys/oss/config", function(r){
				vm.config = r.config;
            });
        },
		saveOrUpdate: function (event) {
			var url = vm.weixinShopClass.id == null ? "sys/weixinshopclass/save" : "sys/weixinshopclass/update";
			vm.weixinShopClass.img=$("#img")[0].src;
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.weixinShopClass),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/weixinshopclass/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/weixinshopclass/info/"+id, function(r){
                vm.weixinShopClass = r.weixinShopClass;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
		imgFun: function (e) {
			 var id = $(e.target).attr("id");  
			 if(vm.flat && $("#"+id)[0].src!=''){
				 $("#"+id).height($("#"+id).height()*2);
				 $("#"+id).width($("#"+id).width()*2);
				 vm.flat = false;
			 }else if(!vm.flat && $("#"+id)[0].src!=''){
				 $("#"+id).height($("#"+id).height()/2);
				 $("#"+id).width($("#"+id).width()/2);
				 vm.flat = true;
			 }
		}
	}
});