function test(){
$('#dg').datagrid({
	columns :[[ //添加 列
		{ field :'id',
			title : 'id',
			align : 'center',
			width : 100 },
		{ field : 'name',
			title : 'Name',
			align : 'center',
			width : 100 },
		{ field : 'sex',
			title : 'Sex',
			align : 'center',
			width : 100 },
		{ field : 'age',
			title : 'Age',
			align : 'center',
			width : 100 },
		{ field : 'phone',
			title : 'Phone',
			align : 'center',
			width : 100 },
		{ field : 'location',
			title : 'Location',
			align : 'center',
			width : 100 },
			]],	
		url:"/jfinal-Student/DB",
		dataType:'json'
});
}