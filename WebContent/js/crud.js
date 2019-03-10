//删除指定用户
function destroyUser(){
	var row = $('#dg').datagrid('getSelected');
	if(row){
		$.messager.confirm('Confirm','你确定删除所选的用户吗!',function(r){
			if(r){
				$.post('/jfinal-Student/delete',{
					//传递选中的行中的指定的列，注意名字与id相同!
					id:row.id
				},function(result){
					if(result.success){
						$('#dg').datagrid('reload');//重载用户数据
					}
					else{
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					}
				},'json');
			}
		});
	}
}
//保存用户。
function saveUser(){
		$('#fm').form('submit',{
			url : "/jfinal-Student/save",
			onSubmit : function(){
				return $(this).form('validate')
				$('#dlg').dialog('close');//关闭 dialog
				$('#dg').dialog('reload');//重载用户数据
				
			},
			success : function(result){
				var result = eval('('+result+')');
				if(result.errorMsg){
					$.messager.show({
						title : 'Error',
						Msg : result.errorMsg
					});
				}
				else{
					$('#dlg').dialog('close');//关闭 dialog
					$('#dg').dialog('reload');//重载用户数据
				}
			}
			
		});
}
//创建新用户
function newUser(){
	$('#dlg').dialog('open').dialog('center').dialog('setTitle','新用户');
	$('#fm').form('clear');
	url = "/jfinal-Student/save";
}
//编辑用户
function editUser(){
	var row = $('#dg').datagrid('getSelected');
	if(row){
		$('#dlg').dialog('open').dialog('setTitle','编辑用户');
		$('#fm').form('load',row);
		url = '/jfinal-Student/edit?id=' +row.id;
	}
}

$('#dg').datagrid({
	columns :[[ //添加 列
		{
			field :'id',
			title : 'id',
			align : 'center',
			width : 100
		},
		{
			field : 'name',
			title : 'Name',
			align : 'center',
			width : 100
		},
		{
			field : 'sex',
			title : 'Sex',
			align : 'center',
			width : 100
		},
		{
			field : 'age',
			title : 'Age',
			align : 'center',
			width : 100
		},
		{
			field : 'phone',
			title : 'Phone',
			align : 'center',
			width : 100
		},
		{
			field : 'location',
			title : 'Location',
			align : 'center',
			width : 100
		},
	]],	
	pagination :true, //开启分页.
	url :"/jfinal-Student/DB",
	loadFilter :pagerFilter,//调用分页函数.
});
//分页函数.

function pagerFilter(data){
	if(typeof data.length == 'number' && typeof data.splice == 'function'){
		data = {
				total : data.length,
				rows : data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('optionns');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage :function(pageNum,pageSize){
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh',{
				pageNumber :pageNum,
				pageSize :pageSize
			});
			dg.datagrid('loadData',data);

		}
	});
	if(!data.originalRows){
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1)* parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start,end));
	return data;

}








