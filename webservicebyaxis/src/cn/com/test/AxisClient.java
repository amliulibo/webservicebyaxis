package cn.com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.message.RPCElement;

public class AxisClient {

	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException {
		// TODO Auto-generated method stub

		axistest();
		return;
		
		/*
		Service service1=new Service();
		org.apache.axis.client.Call  call1=(org.apache.axis.client.Call) service1.createCall();
		//call1.setTargetEndpointAddress("http://localhost:8091/WebService/Server1?wsdl");
		call1.setTargetEndpointAddress("http://localhost:8091/WebService/Server1");
		call1.setOperationName("http://localhost:8091/WebService/Server1/getServerName");
		//call1.setOperationName(opName);
		//call1.setOperation(new QName("webservice1","getServerName"));
		//call1.addParameter("yourname", org.apache.axis.encoding.XMLType.XSD_DATE, javax.xml.rpc.ParameterMode.IN);
		//javax.activation.DataHandler
		
		//call1.setReturnType(XMLType.XSD_STRING);
		String tmp="张三";
		String result=(String) call1.invoke(new Object[] {tmp});
		//String result=(String) call1.invoke(new Object[] {tmp});
		System.out.println(result);*/
		 
	}
	
	static void axistest() throws ServiceException, MalformedURLException, RemoteException
	{
		String endpoint="http://localhost:8091/WebService/Server1";
		String targetNamespace="http://webservice1";
		String method="getHello2";
		Service service1=new Service();
		org.apache.axis.client.Call  call1=(org.apache.axis.client.Call) service1.createCall();
		call1.setTargetEndpointAddress(new URL(endpoint));
		call1.setOperationName(new QName(targetNamespace,method));
		call1.setUseSOAPAction(true);
		
		call1.addParameter(new QName(targetNamespace, "yourname"),XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
		call1.setReturnType(XMLType.XSD_STRING);
		String jsonstring=(String) call1.invoke(new Object[] {"张三"});
		System.out.println(jsonstring);
		
		
		
	}

}
