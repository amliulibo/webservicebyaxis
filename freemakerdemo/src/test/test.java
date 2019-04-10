package test;

import java.io.File;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Attribute;

import freemakerdemo.FreemarkerUtil;
import freemakerdemo.VoucherDTO;
import freemakerdemo.db;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;





public class test {

	 
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
	

	public static void main(String[] args) throws IOException, TemplateException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		TestHelper helper=  new  TestHelper();
		helper.tablename="EP_T_QYAcctStatement".toUpperCase();
		helper.shortname="QYAcctStatement";
		helper.drivername="oracle";
		helper.schema="FASP13000000";
		helper.init();
		//helper.makeDTO();
		//helper.makeIDAO();
		helper.makeDAO();
		//helper.makeRowmapper();
		//helper.makeConfig();
		//helper.makeIBO();
		//helper.makeBO();
		
		System.out.println();
		System.out.println(">>>>>>>>>>OK ");
		
		
		return;
		
	}

}


class TestHelper{
	 public TestHelper(){ 
	 }
	 
	 public String  tablename,shortname,drivername,schema;
	 
	 List<Map> tablecolumnList ;//物理表结构
	 List<Map> dtocolumnList =new ArrayList<>() ;//用于生成DTO
	 
	 public  void makeBO() throws ClassNotFoundException, SQLException
		{
			
		 String table=tablename.toUpperCase();
			Map<String, Object> map=new HashMap<>();
			map.put("shortname", shortname);
			map.put("tablename", table);
			//map.put("tablecolumnlist", lst1);
			map.put("dtocolumnList", dtocolumnList);
			
			Template temp =new FreemarkerUtil().getTemplate( "BO.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("BO.ftl",map);
		}
	 public  void makeIBO() throws ClassNotFoundException, SQLException
		{
			
		 String table=tablename.toUpperCase();
			Map<String, Object> map=new HashMap<>();
			map.put("shortname", shortname);
			map.put("tablename", table);
			//map.put("tablecolumnlist", lst1);
			map.put("dtocolumnList", dtocolumnList);
			
			Template temp =new FreemarkerUtil().getTemplate( "IBO.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("IBO.ftl",map);
		}
	 
	 
	 public  void init() throws ClassNotFoundException, SQLException
	 {
		 String table=tablename.toUpperCase();
			
		 tablecolumnList= db.getTableColumn( drivername,schema, table);
		 
		 Map<String, String> voucherdtofieldMap=new HashMap<>();
		 
			Field[] fields2=VoucherDTO.class.getDeclaredFields();
			for (int i = 0; i < fields2.length; i++) {
				voucherdtofieldMap.put(fields2[i].getName().toUpperCase(),fields2[i].getName());
			}
			
			for (int i = 0; i < tablecolumnList.size(); i++) {
				Map<String, String> item=tablecolumnList.get(i);
				String colname=item.get("COLUMN_NAME").toString();
				if (voucherdtofieldMap.containsKey(colname.toUpperCase() )) {
					item.put("COLUMN_NAME", voucherdtofieldMap.get(colname.toUpperCase()));
					 
				} else {
					dtocolumnList.add(item);
				}
				
			}
		 
		 
	 }
	 
	 
	 
	 public  void makeDTO() throws ClassNotFoundException, SQLException
		{
			
		 String table=tablename.toUpperCase();
			Map<String, Object> map=new HashMap<>();
			map.put("shortname", shortname);
			map.put("tablename", table);
			//map.put("tablecolumnlist", lst1);
			map.put("dtocolumnList", dtocolumnList);
			
			Template temp =new FreemarkerUtil().getTemplate( "DTO.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("DTO.ftl",map);
		}
	 public  void makeConfig() throws ClassNotFoundException, SQLException
		{
			String table=tablename.toUpperCase();
			 
			Map<String, Object> map=new HashMap();
			
			map.put("tablename", tablename);
			map.put("tablecolumnlist", tablecolumnList);
			map.put("shortname", shortname);
			
			
			Template temp =new FreemarkerUtil().getTemplate( "CONFIG.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("CONFIG.ftl",map);
		}
	 public  void makeRowmapper() throws ClassNotFoundException, SQLException
		{
			String table=tablename.toUpperCase();
			
			List<Map> lst1= db.getTableColumn( drivername,schema, table);
			Map<String, Object> map=new HashMap();
			
			map.put("tablename", tablename);
			map.put("tablecolumnlist", tablecolumnList);
			map.put("shortname", shortname);
			
			
			Template temp =new FreemarkerUtil().getTemplate( "ROWMAPPER.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("ROWMAPPER.ftl",map);
		}
	 public  void makeDAO() throws ClassNotFoundException, SQLException
		{
			String table=tablename.toUpperCase();
			
			List<Map> lst1= db.getTableColumn( drivername,schema, table);
			Map<String, Object> map=new HashMap();
			
			map.put("tablename", tablename);
			map.put("tablecolumnlist", tablecolumnList);
			map.put("shortname", shortname);
			
			
			Template temp =new FreemarkerUtil().getTemplate( "DAO.ftl");// cfg.getTemplate("dao.ftl");
			new FreemarkerUtil().print("DAO.ftl",map);
		}
	
	
	public  void makeIDAO() throws ClassNotFoundException, SQLException
	{
		String table=tablename.toUpperCase();
		
		List<Map> lst1= db.getTableColumn( drivername,schema, table);
		Map<String, Object> map=new HashMap();
		
		//map.put("tablename", tablename);
		map.put("tablecolumnlist", lst1);
		map.put("shortname", shortname);
		
		
		Template temp =new FreemarkerUtil().getTemplate( "IDAO.ftl");// cfg.getTemplate("dao.ftl");
		new FreemarkerUtil().print("IDAO.ftl",map);
	}
	
}
