package com.java.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil
{
	public static void write(HttpServletResponse resp,Object object) throws Exception 
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(object);
		out.flush();
		out.close();
	}
}
