<%@ page language="java"  import="java.util.*"    pageEncoding="utf-8"%>
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%= basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ssm主页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">


//表格数据源  
var data = [];  
var data2=[];
// 用代码造30条数据  
for (var i = 1; i < 31; ++i) {  
    data.push({  
        "id":i,  
        "name":"Student" + i  
    })  
}  


function searchUser() {
	$("#dg2").datagrid('load',{
		schema:"FASP130100000",
		AppId:"1459c6da-8046-4da9-afb9-c33b08a94a14"
		
	});
}

$(function () {  

    $("#dd").datagrid({  
        title:"测试本地分页",  
        rownumbers:true,  
        fitColumns:true,  
        pagination:true,  
        data:data.slice(0,10),  
        columns:[  
            [  
                {field:'id', align:"center", title:"编号", width:100},  
                {field:'name', align:"center", title:"姓名", width:100}  
            ]  
        ]  
    });  

    var pager = $("#dd").datagrid("getPager");  
    pager.pagination({  
        total:data.length,  
        onSelectPage:function (pageNo, pageSize) {  
            var start = (pageNo - 1) * pageSize;  
            var end = start + pageSize;  
            $("#dd").datagrid("loadData", data.slice(start, end));  
            pager.pagination('refresh', {  
                total:data.length,  
                pageNumber:pageNo  
            });  
        }  
    });  
    
    
    
    $("#dg2").datagrid({  
        title:"测试本地分页2",  
        rownumbers:true,  
        fitColumns:true,  
        pagination:true, 
    
        url:"localhost:8080/ssm-demo/Functions/selectFunctionsInApp.do", 
        method:"get",
        /* dataType:"jsonp", */
        columns:[  
            [  
                {field:'code_Name', align:"center", title:"code_Name", width:100},  
                {field:'name', align:"center", title:"name", width:100}  
            ]  
        ]  
    }); 
    var pager = $("#dg2").datagrid("getPager");  
    pager.pagination({  
        total:data2.length,  
        onSelectPage:function (pageNo, pageSize) {  
            var start = (pageNo - 1) * pageSize;  
            var end = start + pageSize;  
            $("#dg2").datagrid("loadData", data2.slice(start, end));  
            pager.pagination('refresh', {  
                total:data2.length,  
                pageNumber:pageNo  
            });  
        }  
    });  

});  



function searchUser() {
	$("#dg2").datagrid('load',{
		"userName":"llb"
	});
}
	
</script>
</head>


<body class="easyui-layout">   
<div data-options="region:'north'" style="height:100px"></div>   
<div data-options="region:'center'">   
    <div class="easyui-layout" data-options="fit:true">   
        <div data-options="region:'west',collapsed:false" style="width:180px">
        <a onClick="addPanel('hello')">addPanel</a>
        </div>   
        <div data-options="region:'center'">
        	<div id="tt" class="easyui-tabs" style="width:auto;height:auto;">   
		    <div title="首页" >   
		        <table id="dd" class="easyui-datagrid"></table>   
		    </div>   
		    <div title="Tab2" data-options="closable:true" >   
		    
		        <table id="dg2" class="easyui-datagrid" toolbar="#tb"></table>   
		        <div id="tb">
				<a href="javascript:searchUser()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> 
				</div>
		    </div>   
		    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" >   
		        tab3    
		    </div>   
		</div>  
        	
        </div>   
    </div>   
</div>   
</body>  
</html> 