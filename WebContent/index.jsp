<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>学生管理系统</title>

	<script type="text/javascript" src="Jquery-easyUI/jquery.min.js"></script>
	<script type="text/javascript" src="Jquery-easyUI/jquery.easyui.min.js"></script>

	<!--  //使用外引入，加快的页面的加载速度，同时分离了不同类型的代码，查看的时候可以左右对照着看，查bug更方便 -->
	<script type="text/javascript" src="js/crud.js"></script>
	<script type="text/javascript" src="js/test.js"></script>
	<script type="text/javascript" src="js/search.js"></script>

    <link rel="stylesheet" type="text/css" href="Jquery-easyUI/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="Jquery-easyUI/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="Jquery-easyUI/demo/demo.css">
	
	
</head>

<body>
    <!--
    一、页面基本架构
    ①toolbar="#toolbar"指定已经写好的工具栏div
    ②singleSelect="true"点击每个行，只能单选
    ③fitColumns="true"每个列的大小适应父类
     -->
     
    <table id="dg" style="width:800px"  title="学生管理系统" rownumbers="true"
        data-options="fit:true" toolbar="#toolbar" fitColumns="true"
        singleSelect="true"></table>
    <div id="toolbar">
	        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
            onclick="newUser()">新建</a>

            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
            onclick="editUser()">编辑</a> 

            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
            onclick="destroyUser()">移除</a> 
            
            <label>按名字搜索：</label>
            <input id="searchByName" style="line-height:26px;border:1px solid #ccc">

            <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search"
            onclick="doSearch()">搜索</a>            

           <!-- 实时显示数据 -->
     <script>
     setTimeout("test()",520);
     </script>
    </div>
<!-- 增加 学生 -->
    <div id="dlg" class="easyui-dialog"
        style="width:630px;height:380px;padding:10px 20px" closed="true"
        buttons="#dlg-buttons">
        <div class="ftitle">学生管理信息系统</div>
        <form id="fm" method="post">
             <div style="margin-bottom:10px">
                <input name="name" class="easyui-textbox" required="true" label="Name:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="sex" class="easyui-textbox" required="true" label="sex" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="age" class="easyui-textbox" required="true" label="age" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="phone" class="easyui-textbox" required="true" label="phone" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="location" class="easyui-textbox" required="true"  label="location" style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok"
            onclick="saveUser()">保存</a>

         <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>

</body>
</html>
