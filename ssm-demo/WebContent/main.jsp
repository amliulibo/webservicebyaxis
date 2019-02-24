<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新平台</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.3.3/themes/bootstrap/easyui.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" 
	src="${pageContext.request.contextPath }/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" 	src="${pageContext.request.contextPath }/js/mycommon.js?version=20170621"></script>
	
	
	
<script type="text/javascript">


function addPanel(title){
	//add a new tab panel    
		$('#tt').tabs('add',{    
		    title:title,    
		    content:'Tab Body',    
		    closable:true,    
		    tools:[{    
		        iconCls:'icon-mini-refresh',    
		        handler:function(){    
		            alert('refresh');    
		        }    
		    }]    
		});  
	}
 



</script>	
<style type="text/css">

/* 列宽溢出显示省略号 */
/* .datagrid-btable .datagrid-cell{padding:6px 4px;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}
*/
.datagrid-btable .datagrid-cell:hover
{
text-overflow:inherit;
overflow:visible;
/* background-color:white;
transparent:false; */
} 


</style>

	
</head>
<body class="easyui-layout">   
<div data-options="region:'north'" style="height:100px"></div>   
<div data-options="region:'center'">   
    <div class="easyui-layout" data-options="fit:true">
       
        <div title="导航菜单"  data-options="region:'west',collapsed:false"  split=true 
        	 style="width:220px">
        	<a onClick="addPanel('hello')">addPanel</a>
        	
        	<jsp:include page="fp_t_cafunctionTree.jsp"></jsp:include> 
        	
        </div>   
        <div data-options="region:'center'">
        	<div id="tt" class="easyui-tabs" style="width:auto;height:500px;"> 
        	                                          
		    <div title="菜单"  >   
		    	
		       <jsp:include page="fp_t_cafunction.jsp"></jsp:include> 
				
				
		    </div>   
		    <div title="窗体" data-options="closable:false" style="overflow:auto;padding:0;margin:0;">   
		    
		    	<jsp:include page="fp_t_piform.jsp"></jsp:include> 
			    	
		    </div>   
		    
		    <div title="单据" data-options="closable:false" style="padding:0;margin:0;">
		    
		    	
		        <jsp:include page="fp_t_vmdefine.jsp"></jsp:include> 
		    </div> 
		    
		    <div title="按钮" data-options="closable:false" style="padding:0;margin:0;">   
		        <jsp:include page="fp_t_pibutton.jsp"></jsp:include>
		    </div> 
		    
		    <div title="处理对象" data-options="closable:false" style="padding:0;margin:0;">
		    	<jsp:include page="fp_t_piprocess.jsp"></jsp:include>
		    </div> 
		    
		    <div title="工作流" data-options="closable:false" style="padding:0;margin:0;">   
		        tab33456    
		    </div>   
		    <div title="其他" data-options="closable:false" style="padding:0;margin:0;">   
		        <jsp:include page="fp_tool.jsp"></jsp:include> 
		    </div>  
		</div>  
        	
        </div>   
    </div>   
</div>   
</body>  
</html>