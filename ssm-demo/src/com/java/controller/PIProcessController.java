package com.java.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.java.entity.Functions;
import com.java.entity.PIFormDTO;
import com.java.entity.PIProcessDTO;
import com.java.entity.VMDefineDTO;
import com.java.service.CommonService;
import com.java.service.PIProcessService;
import com.java.service.PiFormService;
import com.java.service.VmDefineService;
import com.java.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/piProcess")
public class PIProcessController extends ControllerBase
{
	@Resource
	private PIProcessService piProcessService;
	@Resource
	private CommonService commonService;
	
	
	@RequestMapping("/selectProcess")
	public String selectVmDefine(@RequestParam(value="sProcessID",required=false) String voucherId
			,@RequestParam(value="sProcessName") String voucherName
			,@RequestParam(value="page") String page
			,@RequestParam(value="rows") String rows
			,HttpServletResponse resp)throws Exception
	{
		List busiList=piProcessService.selectProcess(voucherId, voucherName);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(busiList);
        result.put("rows", jsonArray);
        result.put("total", busiList.size());
        ResponseUtil.write(resp, result);
        return null;
	
	}
	
	
	
	
	@RequestMapping( value="/saveProcess")
	@ResponseBody
	 @SuppressWarnings("unused")
	public String insertProcess(@RequestBody String  data)throws Exception
	{
		
		System.out.println("data="+data);
		com.alibaba.fastjson.JSONObject jsonObject=com.alibaba.fastjson.JSONObject.parseObject(data);
		Object insertJson=jsonObject.get("inserted");
		Object updateJson=jsonObject.get("updated");
		Object deleteJson=jsonObject.get("deleted");

		List<PIProcessDTO> insertList=null,updateList=null,deleteList=null;
		if (insertJson!=null)
		{
			insertList= JSON.parseArray(insertJson.toString(),PIProcessDTO.class);
			
			for (PIProcessDTO dto : insertList)
			{
				String xzqhcode= getXzqhinfo().getCode();  //(String) commonService.selectXZQHCode().get(0).get("XZQHCode");
				dto.setAdmdivCode(xzqhcode);
				int ret= piProcessService.insertProcess(dto);
			}
			
		}
		if (updateJson!=null)
		{
			updateList= JSON.parseArray(updateJson.toString(),PIProcessDTO.class);
			for (PIProcessDTO dto : updateList)
			{
				int ret= piProcessService.updateProcess(dto);
			}
		}
		if (deleteJson!=null)
		{
			
			deleteList= JSON.parseArray(deleteJson.toString(),PIProcessDTO.class);
			for (PIProcessDTO dto : deleteList)
			{
				int ret= piProcessService.deleteProcess(dto);
			}
		}
		 
	        
	        
	        return "";
	        

	
	}
	
	

}
