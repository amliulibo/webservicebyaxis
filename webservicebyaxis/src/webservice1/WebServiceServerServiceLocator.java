/**
 * WebServiceServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice1;

public class WebServiceServerServiceLocator extends org.apache.axis.client.Service implements webservice1.WebServiceServerService {

    public WebServiceServerServiceLocator() {
    }


    public WebServiceServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceServerPort
    private java.lang.String WebServiceServerPort_address = "http://localhost:8091/WebService/Server1";

    public java.lang.String getWebServiceServerPortAddress() {
        return WebServiceServerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceServerPortWSDDServiceName = "WebServiceServerPort";

    public java.lang.String getWebServiceServerPortWSDDServiceName() {
        return WebServiceServerPortWSDDServiceName;
    }

    public void setWebServiceServerPortWSDDServiceName(java.lang.String name) {
        WebServiceServerPortWSDDServiceName = name;
    }

    public webservice1.IWS_Server getWebServiceServerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceServerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceServerPort(endpoint);
    }

    public webservice1.IWS_Server getWebServiceServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservice1.WebServiceServerServiceSoapBindingStub _stub = new webservice1.WebServiceServerServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceServerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceServerPortEndpointAddress(java.lang.String address) {
        WebServiceServerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservice1.IWS_Server.class.isAssignableFrom(serviceEndpointInterface)) {
                webservice1.WebServiceServerServiceSoapBindingStub _stub = new webservice1.WebServiceServerServiceSoapBindingStub(new java.net.URL(WebServiceServerPort_address), this);
                _stub.setPortName(getWebServiceServerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceServerPort".equals(inputPortName)) {
            return getWebServiceServerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice1/", "WebServiceServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice1/", "WebServiceServerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceServerPort".equals(portName)) {
            setWebServiceServerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
