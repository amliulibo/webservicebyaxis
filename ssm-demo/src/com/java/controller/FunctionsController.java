package com.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.CSRecordDTO;
import com.java.entity.Functions;
import com.java.entity.TreeNodeInfo;
import com.java.service.FunctionsService;
import com.java.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/Functions")
public class FunctionsController
{
	@Resource
	private FunctionsService functionsService;
	/**
	 * @throws Exception 
	* 得到指定应用下的所有功能菜单
	* @param schema 数据库schema
	* @param AppId 应用标识
	* @return  功能对象列表  
	* @throws
	 */
	@RequestMapping("/selectFunctionsInApp")
	public String selectFunctionsInApp(@RequestParam(value="AppId")  String AppId,@RequestParam(value="sName") String sName
			,@RequestParam(value="sClass") String sClass,@RequestParam(value="sParentId") String sParentId,
			HttpServletResponse resp) throws Exception
	{
	
        List<Functions> userList=functionsService.selectFunctionsInApp( AppId,sName,sClass,sParentId);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(userList);
        result.put("rows", jsonArray);
        result.put("total", userList.size());
        ResponseUtil.write(resp, result);
        return null;
	}
	
	@RequestMapping("/selectFunctions")
	public String selectFunctions(@RequestParam(value="id")  String id
			,HttpServletResponse resp) throws Exception
	{
	
        List<Functions> userList=functionsService.selectFunctions( id);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(userList);
      /*  result.put("rows", jsonArray);
        result.put("total", userList.size());*/
        ResponseUtil.write(resp, jsonArray);
        return null;
	}
	
	@RequestMapping("/loadFunctionTree")
	public String loadFunctionTree(@RequestParam(value="id")  String id
			,HttpServletResponse resp) throws Exception
	{
		List<TreeNodeInfo> treelist=new ArrayList<>();
		if ((id==null)||"".equals(id))
		{//首次加载tree节点
			 List<Functions> userList=functionsService.selectFunctionSet(id);
			 TreeNodeInfo treeNodeInfo;
			 for (Functions functions : userList)
			{
				 treeNodeInfo=new TreeNodeInfo();
				 treeNodeInfo.setId(functions.getId());
				 treeNodeInfo.setText(functions.getName());
				 //treeNodeInfo.setIconCls("");
				 treeNodeInfo.setState("closed");
				 treeNodeInfo.set_parentId(functions.getParentId());
				 Map<String, Object> attributes=new HashMap<>();
				 attributes.put("functionDTO", functions);
				 treeNodeInfo.setAttributes(attributes);
				 treelist.add(treeNodeInfo);
			}
			 
			 
		        JSONObject result=new JSONObject();
		        JSONArray jsonArray=JSONArray.fromObject(treelist);
		      
		        
		        
		        ResponseUtil.write(resp, jsonArray);
		}else {
			boolean isEnd=false;
			id=id.replace(",", "");
			 List<Functions> functionList=functionsService.selectFunctionSet(id);
			 
			 if (functionList==null || functionList.size()==0)
			{
				 functionList=functionsService.selectFunctions(id);
				 isEnd=true;
			}
			 TreeNodeInfo treeNodeInfo;
			 for (Functions functions : functionList)
			{
				 treeNodeInfo=new TreeNodeInfo();
				 treeNodeInfo.setId(functions.getId());
				 treeNodeInfo.setText(functions.getName()+"("+functions.getCodeName()+")");
				 //treeNodeInfo.setIconCls("");
				 treeNodeInfo.setState( isEnd==true? "open": "closed");
				 treeNodeInfo.set_parentId(functions.getParentId());
				 Map<String, Object> attributes=new HashMap<>();
				 attributes.put("functionDTO", functions);
				 treeNodeInfo.setAttributes(attributes);
				 treelist.add(treeNodeInfo);
			}
			 JSONObject result=new JSONObject();
		        JSONArray jsonArray=JSONArray.fromObject(treelist);
		      
		        ResponseUtil.write(resp, jsonArray);
		}
		
		return null;
	}
	
	
	@RequestMapping("/loadAdmdiv")
	public String loadAdmdiv(@RequestParam(value="id")  String id
			,HttpServletResponse resp) throws Exception
	{
		
			List<TreeNodeInfo> treelist=new ArrayList<>();
			
			
			 List<CSRecordDTO> functionList=functionsService.selectAdmdiv(id);
			 
			 
			 TreeNodeInfo treeNodeInfo;
			 for (CSRecordDTO functions : functionList)
			{
				 treeNodeInfo=new TreeNodeInfo();
				 treeNodeInfo.setId( String.valueOf(functions.getItemId()) );
				 treeNodeInfo.setText(functions.getItemName()+"("+functions.getItemCode()+")");
				 //treeNodeInfo.setIconCls("");
				 treeNodeInfo.setState( functions.getIsLeaf() ==1 ? "open": "closed");
				 treeNodeInfo.set_parentId(String.valueOf(functions.getParentId()));
				 Map<String, Object> attributes=new HashMap<>();
				 attributes.put("CSRecordDTO", functions);
				 treeNodeInfo.setAttributes(attributes);
				 treelist.add(treeNodeInfo);
			}
			 JSONObject result=new JSONObject();
		        JSONArray jsonArray=JSONArray.fromObject(treelist);
		      
		        ResponseUtil.write(resp, jsonArray);
		
		
		return null;
	}
	
}
