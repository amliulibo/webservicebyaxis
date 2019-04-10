package freemakerdemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUtil {
	 public  Template getTemplate(String name) {
	        try {
	            // ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl
	            Configuration cfg = new Configuration();
	            // �趨ȥ�����ȡ��Ӧ��ftlģ���ļ�
	            cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
	            // ��ģ���ļ�Ŀ¼���ҵ����Ϊname���ļ�
	            Template temp = cfg.getTemplate(name);
	            return temp;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	 /**
	     * ����̨���
	     * 
	     * @param name
	     * @param root
	     */
	    public void print(String templateName, Map<String, Object> root) {
	        try {
	            // ͨ��Template���Խ�ģ���ļ��������Ӧ����
	            Template temp = this.getTemplate(templateName);
	            temp.process(root, new PrintWriter(System.out));
	        } catch (TemplateException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * ����ļ�
	     * 
	     * @param name
	     * @param root
	     * @param outFile
	     */
	    public void printFile(String templateName, Map<String, Object> root, String outFile) {
	        FileWriter out = null;
	        try {
	            
	        	String fileFullPath="D:/test/freemakerdir/" + outFile;
	            out = new FileWriter(new File(fileFullPath));
	            Template temp = this.getTemplate(templateName);
	            temp.process(root, out);
	            System.out.print("������ļ�:"+fileFullPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (TemplateException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (out != null)
	                    out.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
