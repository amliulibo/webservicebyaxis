<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">


/* 
function searchDefine(id) {
	
	
	$('#tbVoucher').datagrid('options').url="${pageContext.request.contextPath }/vmDefine/selectVmDefine.do";
		
	var argCount=arguments.length;
	$("#tbVoucher").datagrid('load',{
		sVoucherName:$("#s_VoucherName").val(),
		sVoucherID:argCount==0?"":id
		
		
	});
} */

function searchTool(){
	
	$('#tbAdmdiv').treegrid('options').url="${pageContext.request.contextPath }/Functions/loadAdmdiv.do";
	// 读取并发送请求参数
	//$('#tbAdmdiv').treegrid('load',{id:"1"});
	
	
	/* $('#tbAdmdiv').tree({    
                    url: '/tree/son/ajax', 
                    queryParams:{isAll:isAll},/ */
                    
                    
	/* $('#tbAdmdiv').treegrid({
		url:"${pageContext.request.contextPath }/Functions/loadAdmdiv.do?id=1"
	}); */
	
	
	 $.post("${pageContext.request.contextPath }/Functions/loadAdmdiv.do",{id:'1'},function(data){
		  $('#tbAdmdiv').treegrid('loadData',data);
		},'json');   
	
}


$(function(){
	
	
	$('#tbAdmdiv').treegrid({
		loadFilter:function(data,parentid){
			for (var i = 0; i < data.length; i++) {
				var row=data[i];
				if(row.attributes.CSRecordDTO){
					row.itemCode=row.attributes.CSRecordDTO.itemCode;
					row.levelNo=row.attributes.CSRecordDTO.levelNo;
					row.isLeaf=row.attributes.CSRecordDTO.isLeaf;
					row.divType=row.attributes.CSRecordDTO.divType;
					row.attributes.CSRecordDTO=undefined;
				}
			}
			return data;
		}			
	});

	
    
});
</script>

<table id="tbAdmdiv" class="easyui-treegrid"   toolbar="#toolTool"  
		rownumbers="true"
        data-options=" idField:'id',treeField:'text'">   
    <thead>   
        <tr>
        	<th data-options="field:'id',width:50">id</th>   
            <th data-options="field:'text',width:320">Name</th>  
            <th data-options="field:'itemCode',width:100">itemCode</th> 
            <th data-options="field:'levelNo',width:100">levelNo</th> 
            <th data-options="field:'isLeaf',width:100">isLeaf</th> 
            <th data-options="field:'divType',width:100">divtype</th> 
            
            
        </tr>   
    </thead>   
</table>  
        
<div id="toolTool">
	<a href="javascript:addForm()" class="easyui-linkbutton"
	iconCls="icon-add" plain="true">添加</a>
		<a  href="javascript:modifyForm()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a> 
       <a href="javascript:deleteUser()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
        <div>
        &nbsp;区划编码&nbsp;
        <input type="text" id="s_admdivCode" size="20" onkeydown="if(event.keyCode==13) searchTool()"/>
        &nbsp;区划名称&nbsp;
        <input type="text" id="s_admdivName" size="20" onkeydown="if(event.keyCode==13) searchTool()"/>
        <a href="javascript:searchTool()" class="easyui-linkbutton" 
        iconCls="icon-search" plain="true">查询</a>
        
        </div>
      

</div>				         