<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">



function searchDefine(id) {
	
	
	$('#tbVoucher').datagrid('options').url="${pageContext.request.contextPath }/vmDefine/selectVmDefine.do";
		
	var argCount=arguments.length;
	$("#tbVoucher").datagrid('load',{
		sVoucherName:$("#s_VoucherName").val(),
		sVoucherID:argCount==0?"":id
		
		
	});
}

$(function(){
	
	
	$('#tbVoucher').datagrid({loadFilter:pagerFilter});

	
    
});
</script>

<table id="tbVoucher" class="easyui-datagrid" fitColumns="true"
	pagination="true"  rownumbers="true" fit="true"  toolbar="#defineTool" 
	striped="true"	 singleSelect="true"
>
	<thead>
		<tr>
				<th field="cb" checkbox="true" align="center"></th>
			
               <th field="voucherid" width="50" align="center"  >voucherid</th>
               <th field="vouchercode" width="50" align="vouchercode"  >vouchercode</th>
               <th field="vouchername" width="80" align="center">vouchername</th>
               <th field="vouchertypeid" width="50" align="center"  hidden="true">vouchertypeid</th>
               <th field="bctypeid" width="20" align="center" >bctypeid</th>
               
               <th field="vouchercaption" width="50" align="center"  hidden="true">vouchercaption</th>
               <th field="voucherstyle" width="50" align="center"  >voucherstyle</th>
               <th field="mainvchtable" width="100" align="center" >mainvchtable</th>
               <th field="detailvchtable" width="100" align="center" >detailvchtable</th>
               <th field="isvmsource" width="50" align="center"  hidden="true">isvmsource</th>
               <th field="isrefund" width="50" align="center" >isrefund</th>
               <th field="remark" width="150" align="center" >remark</th>
               
               
              
		</tr>
	</thead>
</table>  


<div id="defineTool">
	<a href="javascript:addForm()" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
		<a  href="javascript:modifyForm()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a> 
       <a href="javascript:deleteUser()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
        <div>
        &nbsp;单据名&nbsp;
        <input type="text" id="s_VoucherName" size="20" onkeydown="if(event.keyCode==13) searchDefine()"/>
        
        <a href="javascript:searchDefine()" class="easyui-linkbutton" 
        iconCls="icon-search" plain="true">查询</a>
        
        </div>
       <div id="defineDlgButtons">
       <a href="javascript:saveUser()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
       <a href="javascript:closeDialog('dlgForm')" class="easyui-linkbutton"
       iconCls="icon-cancel">关闭</a>
       </div>
       
       
       <div id="dlgDefine" class="easyui-dialog" style="width:730px;height:280px;padding:10px 10px;" 
	        closed="true" buttons="#defineDlgButtons"  
	        data-options="iconCls:'icon-save',resizable:true,modal:true"> 
        	<form method="post" id="fmDefine">
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
			         