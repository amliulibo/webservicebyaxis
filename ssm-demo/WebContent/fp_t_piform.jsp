<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">

function addForm() {
	$("#dlgForm").dialog("open").dialog("setTitle","添加窗体");
	url="${pageContext.request.contextPath }/Functions/save.do";
}
function modifyForm() {
	var selRows=$("#tbForm").datagrid("getSelections");
	if (selRows.length>1) {
		$.messager.alert("系统提示","只能选择一条要编辑的数据");
		return;
	}
	var row=selRows[0];
	$("#dlgForm").dialog("open").dialog("setTitle","修改窗体");
	$("#fmForm").form("load",row);
	url="${pageContext.request.contextPath }/Functions/save.do?id="+row.id;
	
}

function resetFormQuery(){
	$("#s_formName").val("");
	
}

var bFirstLoadData=false;

function searchForm(pmenuid) {
	
	
	$('#tbForm').datagrid('options').url="${pageContext.request.contextPath }/piForm/selectPiForm.do";
		
	var argCount=arguments.length;
	$("#tbForm").datagrid('load',{
		sFormName:$("#s_formName").val(),
		sMenuid:argCount==0?"":pmenuid
		
		
	});
}



$(function(){
	
    $('#tbForm').datagrid({loadFilter:pagerFilter});
    
    $("#tbForm").datagrid({
		onClickRow:function( rowIndex, rowData){
			searchDefine(rowData.voucherId);
			searchButton(rowData.formId);
		} 
	});
    

    
});



</script>

<table id="tbForm" class="easyui-datagrid" fitColumns="true"
	pagination="true" showPageList="true" rownumbers="true" fit="true"  toolbar="#formTool" 
	striped="true"	 singleSelect="true"
>
	<thead>
		<tr>
				<th field="cb" checkbox="true" align="center"></th>
			
               <th field="formId" width="50" align="center"  >formid</th>
               <th field="name" width="100" align="center" >name</th>
               <th field="formGuid" width="200" align="center"  hidden="true">formguid</th>
               <th field="menuId" width="auto" align="center"  hidden="true">menuid</th>
               <th field="isShowDialogue" width="50" align="center">isshowdialogue</th>
               <th field="processId" width="50" align="center" >processid</th>
               <th field="voucherId" width="50" align="center"  >voucherid</th>
               <th field="stepDescId" width="50" align="center" >stepdescid</th>
               
              
		</tr>
	</thead>
</table>  


<div id="formTool">
	<a href="javascript:addForm()" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
		<a  href="javascript:modifyForm()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a> 
       <a href="javascript:deleteUser()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
        <div>
        &nbsp;窗体名&nbsp;
        <input type="text" id="s_formName" size="20" onkeydown="if(event.keyCode==13) searchForm()"/>
        
        <a href="javascript:searchForm()" class="easyui-linkbutton" 
        iconCls="icon-search" plain="true">查询</a>
        
        </div>
       <div id="formDlgButtons">
       <a href="javascript:saveUser()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
       <a href="javascript:closeDialog('dlgForm')" class="easyui-linkbutton"
       iconCls="icon-cancel">关闭</a>
       </div>
       
       
       <div id="dlgForm" class="easyui-dialog" style="width:730px;height:280px;padding:10px 10px;" 
	        closed="true" buttons="#formDlgButtons"  
	        data-options="iconCls:'icon-save',resizable:true,modal:true"> 
        	<form method="post" id="fmForm">
        		<table cellspacing="8px;">
        		<tr>
        			<td>用户名</td>
        			<td><input type="text" id="userName" name="userName" class="easyui-validatebox" required="true"/>&nbsp;<span style="color:red">*</span></td>
        			<td>密码</td>
        			<td><input type="password" id="password" name="password" class="easyui-validatebox" required="true"/>&nbsp;<span style="color:red">*</span></td>
        		</tr>
        		<tr>
                        <td>真实姓名：</td>
                        <td><input type="text" id="trueName" name="trueName"
                            class="easyui-validatebox" required="true" />&nbsp;<span
                            style="color: red">*</span>
                        </td>
                        
                        <td>邮箱：</td>
                        <td><input type="text" id="email" name="email"
                            validType="email" class="easyui-validatebox" required="true" />&nbsp;<span
                            style="color: red">*</span>
                        </td>
                    </tr>
                     <tr>
                        <td>联系电话：</td>
                        <td><input type="text" id="phone" name="phone"
                            class="easyui-validatebox" required="true" />&nbsp;<span
                            style="color: red">*</span>
                        </td>
                        
                       
                    </tr>
        		</table>
        	</form>
	        </div>
</div>			        
			         