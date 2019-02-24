<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">



function searchButton(id) {
	
	
	$('#tbButton').datagrid('options').url="${pageContext.request.contextPath }/piButton/selectPiButton.do";
		
	var argCount=arguments.length;
	$("#tbButton").datagrid('load',{
		sButtonName:$("#s_ButtonName").val(),
		sFormID:argCount==0?"":id
		
		
	});
}
$(function(){
	
	
	
	$('#tbButton').datagrid({loadFilter:pagerFilter});
	
});

</script>

<table id="tbButton" class="easyui-datagrid" fitColumns="true"
	pagination="true"  rownumbers="true" fit="true"  toolbar="#buttonTool" 
	striped="true"	 singleSelect="true" pageSize="100"
>
	<thead>
		<tr>
  				<th field="cb" checkbox="true" align="center"></th>
               <th field="buttonId" width="50" align="center"  >buttonId</th>
               <th field="buttonGuid" width="50" align="center"  hidden="true" >buttonGuid</th>
               <th field="formId" width="50" align="center">formId</th>
               <th field="name" width="50" align="center"  >name</th>
               <th field="processId" width="50" align="center" >processId</th>
               
               <th field="actionDescId" width="50" align="center" >actionDescId</th>
               <th field="buttonOrder" width="50" align="center"  >buttonOrder</th>
               <th field="buttonType" width="50" align="center" >buttonType</th>
               <th field="mergename" width="50" align="center" >mergename</th>
               
               
              
		</tr>
	</thead>
</table>  


<div id="buttonTool">
	<a href="javascript:addForm()" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
		<a  href="javascript:modifyForm()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a> 
       <a href="javascript:deleteUser()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
        <div>
        &nbsp;按钮名&nbsp;
        <input type="text" id="s_ButtonName" size="20" onkeydown="if(event.keyCode==13) searchButton()"/>
        
        <a href="javascript:searchButton()" class="easyui-linkbutton" 
        iconCls="icon-search" plain="true">查询</a>
        
        </div>
        
       <div id="buttonDlgButtons">
	       <a href="javascript:saveUser()" class="easyui-linkbutton"
	       iconCls="icon-ok">保存</a>
	       <a href="javascript:closeDialog('dlgForm')" class="easyui-linkbutton"
	       iconCls="icon-cancel">关闭</a>
       </div>
       
       
       <div id="dlgButton" class="easyui-dialog" style="width:730px;height:280px;padding:10px 10px;" 
	        closed="true" buttons="#buttonDlgButtons"  
	        data-options="iconCls:'icon-save',resizable:true,modal:true"> 
        	<form method="post" id="fmButton">
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
			         