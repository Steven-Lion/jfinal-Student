function doSearch(){

		var $uname = $('#searchByName')
	    var ByName = $uname.val()
	    if(ByName != null){
	    	$('#dg').datagrid({
		        //这个的作用类似 Ajax 了！向后台传递数据
		        queryParams: {          
		            ByName: ByName            
		          },   
			columns :[[
				
			{
				field :'id',//src data
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
		ByName :ByName,
		url :'/jfinal-Student/search'
		
		});
	    	
	    } 
	    
	    
	
}