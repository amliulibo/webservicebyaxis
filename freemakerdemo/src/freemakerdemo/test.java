package freemakerdemo;

import java.io.File;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Attribute;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;





public class test {

	
	public static void main(String[] args) throws IOException, TemplateException {
		// TODO Auto-generated method stub

		try {
			
			List<Map> lst1= db.getTableColumn_mysql("test", "t1");
			Map<String, Object> map=new HashMap();
			
			map.put("tablename", "t1");
			map.put("tablecolumnlist", lst1);
			
			
			Template temp =new FreemarkerUtil().getTemplate( "DAO.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("DAO.ftl",map);
			new FreemarkerUtil().printFile("DAO.ftl",map,"DAO.java");
			System.out.print("daoda ");
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return;
		
	}
	
	public static void test1() throws IOException, TemplateException
	{
		Configuration cfg=new Configuration(Configuration.VERSION_2_3_22);
		cfg.setDirectoryForTemplateLoading(new File("D:\\test\\freemakerdir"));
		cfg.setClassForTemplateLoading(test.class, "/ftl");
		cfg.setDefaultEncoding("UTF-8");
		//cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		/* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        root.put("table", "EP_T_t1");
		
		Template temp =cfg.getTemplate("dao.ftl");
		
		Writer out = new OutputStreamWriter(System.out);
		temp.process(root, out);
	}

}
