<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">

var editIndex = undefined;

function searchProcess(id) {
	
	
	$('#tbprocess').datagrid('options').url="${pageContext.request.contextPath }/piProcess/selectProcess.do";
	
		
	var argCount=arguments.length;
	$("#tbprocess").datagrid('load',{
		sProcessName:$("#s_processName").val(),
		sProcessID:argCount==0?"":id
		
		
	});
}


function tool_save(){
	var url="${pageContext.request.contextPath }/piProcess/saveProcess.do";

	tool_endedit();
	
	if($("#tbprocess").datagrid("getChanges").length){
		var inserted=$("#tbprocess").datagrid("getChanges","inserted");
		var updated=$("#tbprocess").datagrid("getChanges","updated");
		var deleted=$("#tbprocess").datagrid("getChanges","deleted");
		
		var effectRow=new Object();
		if (inserted.length) {
			effectRow.inserted=(inserted);
		}
		if (updated.length) {
			effectRow.updated=updated;
		}
		if (deleted.length) {
			effectRow.deleted=(deleted);
		}
		
		$.ajax({
			  type: 'POST',
			  url: url,
			  data: JSON.stringify(effectRow),
			  success: function (data){
				  alert("save success");
			  },
			  contentType:'application/json;charset=utf-8',
			  dataType: 'json',
			  
		});
	}
	
	
}

function tool_endedit(){
	var rows=$('#tbprocess').datagrid("getRows");
	for(var i=0;i<rows.length;i++){
		$('#tbprocess').datagrid('endEdit', i);
	}
}


function onClickRow(index) {
	if (editIndex != index) {
		if(endEditing()){
			$('#tbprocess').datagrid('beginEdit', index);
			editIndex=index;
		}
		else{
			$('#tbprocess').datagrid('selectRow', editIndex);
		}
	}
	
}


function tool_append() {
    if (tool_endedit()) {
        $('#tbprocess').datagrid('appendRow',{});
        var maxRowIdx = $('#tbprocess').datagrid('getRows').length-1 ;
        $('#tbprocess').datagrid('beginEdit', maxRowIdx);
		
    }
    
    
    
}


function tool_remove() {
	
    
    var row= $('#tbprocess').datagrid('getSelected')
    if (row) {
    	var rowIndex = $('#tbprocess').datagrid('getRowIndex', row);
    	$('#tbprocess').datagrid('deleteRow', rowIndex);
	}
    
            
    
}

function tool_edit() {
	var row = $('#tbprocess').datagrid('getSelected');
	 if (row) 
	 {
		 var rowIndex = $('#tbprocess').datagrid('getRowIndex', row);
		 $('#tbprocess').datagrid('beginEdit', rowIndex);
	 }
}


function onDblClickRow (rowIndex, rowData) {  
	
	tool_endedit();
	$('#tbprocess').datagrid('beginEdit', rowIndex);
}


$(function(){
	
	
	$('#tbprocess').datagrid({loadFilter:pagerFilter});


    
});
</script>

<table id="tbprocess" class="easyui-datagrid" fitColumns="true"
	pagination="true"  rownumbers="true" fit="true"  toolbar="#processTool" 
	striped="true"	 singleSelect="true"  
	data-options="onDblClickRow:onDblClickRow" >
	<!-- data-options=" onClickRow: onClickRow" -->
	

	<thead>
		<tr>
				<!-- <th field="cb" checkbox="true" align="center"></th> -->
				<th field="editFlag"  hidden="true"></th>
			
               <th field="processId" width="30" align="center"  >processid</th>
               <th field="code" width="50" align="vouchercode"  editor="text" >code</th>
               <th field="name" width="50"  editor="text">name</th>
               <th data-options="field:'assemblyOrPackage',width:70,editor:'text'"
               >assemblyOrPackage</th>
               
               
               <th field="method" width="200" align="center" editor="text" >method</th>
               <th field="type" width="20" align="center" editor="text">type</th>
               <th field="isNet" width="20" align="center"  editor="text">isNet</th>
               <th field="description" width="50" align="center"  editor="text">description</th>
               <th field="admdivCode" width="50" align="center"  editor="text" >description</th>
              

               
              
		</tr>
	</thead>
</table>  


<div id="processTool">
	<a href="javascript:tool_append()" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
	<a href="javascript:tool_edit()" class="easyui-linkbutton"
	iconCls="icon-edit" plain="true">编辑</a>
	<a href="javascript:tool_endedit()" class="easyui-linkbutton"
	iconCls="icon-cancel" plain="true">结束编辑</a>
	<a  href="javascript:tool_save()" class="easyui-linkbutton"
    iconCls="icon-save" plain="true">保存</a> 
           
       <a href="javascript:tool_remove()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
        <div>
        &nbsp;处理对象名&nbsp;
        <input type="text" id="s_processName" size="20" onkeydown="if(event.keyCode==13) searchProcess()"/>
        
        <a href="javascript:searchProcess()" class="easyui-linkbutton" 
        iconCls="icon-search" plain="true">查询</a>
        
        </div>
      

</div>			        
			         