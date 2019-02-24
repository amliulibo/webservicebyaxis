package com.java.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.entity.Functions;
import com.java.entity.PIFormDTO;
import com.java.entity.VMDefineDTO;
import com.java.service.PiFormService;
import com.java.service.VmDefineService;
import com.java.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/vmDefine")
public class VMDefineController
{
	@Resource
	private VmDefineService vmDefineService;
	
	@RequestMapping("/selectVmDefine")
	public String selectVmDefine(@RequestParam(value="sVoucherID",required=false) String voucherId
			,@RequestParam(value="sVoucherName") String voucherName
			,@RequestParam(value="page") String page
			,@RequestParam(value="rows") String rows
			,HttpServletResponse resp)throws Exception
	{
		List<VMDefineDTO> busiList=vmDefineService.selectVmDefine(voucherId, voucherName);
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(busiList);
        result.put("rows", jsonArray);
        result.put("total", busiList.size());
        ResponseUtil.write(resp, result);
        return null;
	
	}
	
	

}
