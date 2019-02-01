/**
 * WebServiceServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice1;

public interface WebServiceServerService extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceServerPortAddress();

    public webservice1.IWS_Server getWebServiceServerPort() throws javax.xml.rpc.ServiceException;

    public webservice1.IWS_Server getWebServiceServerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
