package com.java.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Functions;
import com.java.entity.PIFormDTO;
import com.java.service.PiFormService;
import com.java.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/piForm")
public class PIFormController
{
	@Resource
	private PiFormService piFormService;
	
	@RequestMapping("/selectPiForm")
	public String selectPiForm(@RequestParam(value="sMenuid",required=false) String sMenuid
			,@RequestParam(value="sFormName") String formName
			,@RequestParam(value="page") String page
			,@RequestParam(value="rows") String rows
			,HttpServletResponse resp)throws Exception
	{
		List<PIFormDTO> busiList=piFormService.selectPiForm(sMenuid,formName);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(busiList);
        result.put("rows", jsonArray);
        result.put("total", busiList.size());
        ResponseUtil.write(resp, result);
        return null;
	
	}
	
	

}
