package cn.com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.xml.rpc.ServiceException;

import cn.com.WebXml.WeatherWebService;
import cn.com.WebXml.WeatherWebServiceLocator;
import cn.com.WebXml.WeatherWebServiceSoap;
import webservice1.IWS_Server;
import webservice1.WebServiceServerService;
import webservice1.WebServiceServerServiceLocator;

public abstract class Test1 {

	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException {
		// TODO Auto-generated method stub

		test2();
		return;
		//test1();
		
	}


	private static void test1() throws ServiceException, RemoteException {
		WeatherWebService service1=new WeatherWebServiceLocator();
		WeatherWebServiceSoap serviceSoap= service1.getWeatherWebServiceSoap();
		String[] cityweather= serviceSoap.getWeatherbyCityName("北京");
		for (String s : cityweather) {
			System.out.println(s);
		}
	}
	
	
	static  void test2() throws MalformedURLException, ServiceException, RemoteException
	{
		WebServiceServerService service=new WebServiceServerServiceLocator();
		IWS_Server iws_Server= service.getWebServiceServerPort(new URL("http://localhost:8091/WebService/Server1"));
		String retstring= iws_Server.getHello2("张三");
		System.out.println(retstring);
		
	}

}
