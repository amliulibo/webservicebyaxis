package com.java.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Functions;
import com.java.entity.PIButtonDTO;
import com.java.entity.PIFormDTO;
import com.java.service.PIButtonService;
import com.java.service.PiFormService;
import com.java.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/piButton")
public class PIButtonController
{
	@Resource
	private PIButtonService piButtonService;
	
	@RequestMapping("/selectPiButton")
	public String selectPiForm(@RequestParam(value="sFormID",required=false) String sFormID
			,@RequestParam(value="sButtonName") String sName
			,@RequestParam(value="page") String page
			,@RequestParam(value="rows") String rows
			,HttpServletResponse resp)throws Exception
	{
		List<PIButtonDTO> busiList=piButtonService.selectPiButton(sFormID,sName);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(busiList);
        result.put("rows", jsonArray);
        result.put("total", busiList.size());
        ResponseUtil.write(resp, result);
        return null;
	
	}
	
	

}
