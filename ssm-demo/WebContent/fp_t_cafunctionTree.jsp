<%@ page language="java" contentType="text/html;"   pageEncoding="utf-8"%>


<script type="text/javascript">


	
	
$(function(){
	$('#functionTree').tree({
		
		url:"${pageContext.request.contextPath }/Functions/loadFunctionTree.do?id=",
		/* data:[{
			"id":"1459c6da-8046-4da9-afb9-c33b08a94a14",
			"text":"根节点",
			"state":"closed",
			"children":[{
				"id":11,
				"text":"text2",
				"state":"closed",
			}]
		}],		 */		
		animate:true,
		lines:true,
		 loadFilter:function(data){
			if(data.d){
				return data.d;
			}else{
				return data;
			}
		}, 
		 /*formatter:function(node){
			return node.text;
		},*/

		onClick: function(node){
			//alert(node.text);  // 在用户点击的时候提示
			searchFunction(node.id);
			/* $("#dg").datagrid({
				queryParams: {
					sName:$("#s_functionName").val(),
					sClass:$("#s_method").val(),
					sParentId:node.id
				}
			});
			 $("#dg").datagrid('reload');   */
				
		}

		
	});


});

</script>


<ul id="functionTree" class="easyui-tree"  >
      
</ul>