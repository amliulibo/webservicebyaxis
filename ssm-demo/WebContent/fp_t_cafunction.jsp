<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">





function searchFunction(id) {
	
	
	$('#dg').datagrid('options').url="${pageContext.request.contextPath }/Functions/selectFunctionsInApp.do";
	
	var argCount=arguments.length;
	$("#dg").datagrid('load',{
		
		AppId:"1459c6da-8046-4da9-afb9-c33b08a94a14",
		sName:$("#s_functionName").val(),
		sClass:$("#s_method").val(),
		sParentId:argCount==0?"":id
	});
}

function addFunction() {
	$("#dlg").dialog("open").dialog("setTitle","添加菜单");
	url="${pageContext.request.contextPath }/Functions/save.do";
}
function modifyFunction() {
	var selRows=$("#dg").datagrid("getSelections");
	if (selRows.length!=1) {
		$.messager.alert("系统提示","只能选择一跳要编辑的数据");
		return;
	}
	var row=selRows[0];
	$("#dlg").dialog("open").dialog("setTitle","修改菜单");
	$("#fm").form("load",row);
	url="${pageContext.request.contextPath }/Functions/save.do?id="+row.id;
	
}
function saveFunction(){
	$("#fm").form("submit",{
		url:url,
		onSubmit:function(){
			if ($("#roleName").combobox("getValue")=="") {
				$.messager.alert("系统提示","请选择角色");
				return false;
			}
			return $(this).form("validate");
		},
		success:function(result){
			var result=eval("("+result+")");
			if (result.success) {
				$.messager.alert("系统提示","保存成功");
				resetValue();
				$("#dlg").dialog("close");
				$("#dg").datagrid("reload");
				
			}else{
				$.messager.alert("系统提示","保存失败");
				return;
			}
		}
	});
}
function resetFunctionQuery(){
	$("#s_functionName").val("");
	//$("#roleName").combobox("setValue","");
}


function delFunction(){
	var selRows=$("#dg").datagrid("getSelections");
	if (selRows.length==0) {
		$.messager.alert("系统提示","请选择要删除的数据");
		return;
	}
	var strIds=[];
	for (var i = 0; i < selRows.length; i++) {
		strIds.push(selRows[i].id);
	}
	var ids=strIds.join(",");
	$.messager.confirm("系统提示","确定要删除这<font color=red>"+
		selRows.length+"</font>条数据么?",function(r){
			if(r){
				$.post("${pageContext.request.contextPath }/Functions/delete.do",{
					ids:ids
				},function(result){
					if (result.success) {
						$.messager.alert("系统提示","数据已删除");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","数据删除失败");
					}
				},'json');
			}
		});
}



/////////////////////////




//添加行
//{name:"name",codeName:"codeName"}
function insert(index,rowData){
	var dg=$("#dg");
	
		dg.datagrid("insertRow",{
			index:index,
			row:rowData
		});
	
	
	//editIdx=index-1;
	//dg.datagrid("selectRow",editIdx).datagrid("beginEdit",editIdx);
	
	
}
//复制行
function copyRow(fromRow,toRow){
	var dg=$("#dg");
	var fromRowData;
		if (arguments[0]==-1) {
			fromRowData=dg.datagrid("getSelections");
			if(fromRowData.length==0) return;
			fromRowData=fromRowData [0];
		}else {
			
			
			fromRowData=dg.datagrid("getData").rows[fromRow-1];
			
		}
		
		
		insert(toRow-1,fromRowData);
		//dg.datagrid("selectRow",toRow-1).datagrid("beginEdit",toRow-1);
	
	
}





$(function(){
	$("#dg").datagrid({
		onClickRow:function( rowIndex, rowData){
			searchForm(rowData.id);
		} 
	});
	
	
	$('#dg').datagrid({loadFilter:pagerFilter});
	
	
	
});

</script>



  <table id="dg" class="easyui-datagrid" fitColumns="true"
				pagination="true" rownumbers="true" fit="true"  toolbar="#tb" 
				striped="true"	 singleSelect="true" pageSize="100" >
				
	<thead>
		<tr>
			<th field="cb" checkbox="true" align="center"></th>
			<th field="id" width="50" align="center" hidden="true">id</th>
               <th field="appID" width="50" align="center" hidden="true" >app_id</th>
               
               <th field="codeName" width="200" align="center"  >code_name</th>
               <th field="name" width="250" align="center" editor="text" >name</th>
               <th field="description" width="350" align="center"  editor="text"  >description</th>
               <th field="sortID" width="50" align="center" hidden="true">sort_id</th>
               <th field="inherited" width="50" align="center" hidden="true">inherited</th>
               <th field="classify" width="50" align="center" hidden="true">classify</th>
               <th field="parentid" width="50" align="center" hidden="true">parentid</th>
               <th field="assembly" width="350" align="center"  editor="text">assembly</th>
               <th field="className" width="500" align="center"  editor="text">classname</th>
               <th field="p1" width="150" align="center" editor="text">p1</th>
               <th field="p2" width="150" align="center" editor="text">p2</th>
               <th field="p3" width="150" align="center" editor="text">p3</th>
               <th field="p4" width="150" align="center" editor="text">p4</th>
               <th field="p5" width="150" align="center" editor="text">p5</th>
               <th field="useYears" width="50" align="center" hidden="true">useyears</th>
		</tr>
	</thead>
</table>  

<div id="tb">
	<a href="javascript:copyRow(1,2)" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
	<a
           href="javascript:modifyFunction()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a> 
       <a
       href="javascript:delFunction()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
       <div>
       &nbsp;菜单名&nbsp;
       <input type="text" id="s_functionName" size="20" onkeydown="if(event.keyCode==13) searchFunction()"/>
       &nbsp;类名
       <input type="text" id="s_method" size="20"  onkeydown="if(event.keyCode==13) searchFunction()"/> 
       <a href="javascript:searchFunction()" class="easyui-linkbutton" 
       iconCls="icon-search" plain="true">查询</a>
       
       </div>
       <div id="dlg-buttons">
       <a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
       <a href="javascript:closeDialog('dlg')" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
       </div>
       <div id="dlg" class="easyui-dialog" style="width:730px;height:280px;padding:10px 10px;"
       data-options="iconCls:'icon-save',resizable:true,modal:true" 
       closed="true" buttons="#dlg-buttons">
       	<form method="post" id="fm">
       		<table cellspacing="8px;">
       		<tr>
       			<td>id</td>
       			<td><input type="text"   name="id" /></td>
       			<td></td>
       			<td></td>
       		</tr>
       		
       		<tr>
                       <td>name：</td>
                       <td><input type="text"   name="name"
                           class="easyui-validatebox" required="true" />&nbsp;<span
                           style="color: red">*</span>
                       </td>
                       
                       <td>className：</td>
                       <td><input type="text"   name="className"
                            class="easyui-validatebox" required="true" />&nbsp;<span
                           style="color: red">*</span>
                       </td>
                       
                       <!-- <td><select name="roleName" class="easyui-combobox"
                           id="roleName" style="width: 154px;" editable="false"
                           panelHeight="auto">
                               <option value="">请选择角色</option>
                               <option value="系统管理员">系统管理员</option>
                               <option value="销售主管">销售主管</option>
                               <option value="客户经理">客户经理</option>
                               <option value="高管">高管</option>
                       </select> &nbsp;<span style="color: red">*</span>
                       </td> -->
                   </tr>
                   
       		</table>
       	</form>
       </div>
</div>