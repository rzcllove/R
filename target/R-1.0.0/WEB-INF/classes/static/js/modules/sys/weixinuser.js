$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/weixinuser/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true,hidden : true},
			{ label: '用户的唯一标识', name: 'openid', index: 'openid', width: 80 }, 			
			{ label: '用户昵称', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '性别', name: 'sex', index: 'sex', width: 80 ,formatter:function(value,option,rowdata){
				if(value==1){
					return '<span class="label label-success">男</span>';
				}else if(value==2){
					return '<span class="label label-success">女</span>';
				}else{
					return '<span class="label label-danger">未知</span>';
				}
			}}, 			
			{ label: '省份', name: 'province', index: 'province', width: 80 }, 			
			{ label: '城市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '国家代码', name: 'country', index: 'country', width: 80 }, 			
			{ label: '用户头像', name: 'headimgurl', index: 'headimgurl', width: 80,formatter:function(value,option,rowdata){
				return '<img src="'+value+'" height="100" width="100"/>'
			}}, 			
			{ label: '用户特权信息', name: 'privilege', index: 'privilege', width: 80 }, 			
			{ label: 'unionid', name: 'unionid', index: 'unionid', width: 80 }, 			
			{ label: '凭证', name: 'accessToken', index: 'access_token', width: 80 }			
        ],
		viewrecords: true,
        height: 500,
        rowNum: 3,
		rowList : [3,5,10],
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
});

var vm = new Vue({
	el:'#r',
	data:{
		showList: true,
		title: null,
		weixinUser: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			alert("用户均来自微信自动录入 不允许新增");
			return;
			vm.showList = false;
			vm.title = "新增";
			vm.weixinUser = {};
		},
		update: function (event) {
			alert("用户均来自微信自动录入 不允许修改");
			return;
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.weixinUser.id == null ? "sys/weixinuser/save" : "sys/weixinuser/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.weixinUser),
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
				    url: baseURL + "sys/weixinuser/delete",
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
			$.get(baseURL + "sys/weixinuser/info/"+id, function(r){
                vm.weixinUser = r.weixinUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});