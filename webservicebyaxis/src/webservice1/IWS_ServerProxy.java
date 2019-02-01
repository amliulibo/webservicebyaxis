package webservice1;

public class IWS_ServerProxy implements webservice1.IWS_Server {
  private String _endpoint = null;
  private webservice1.IWS_Server iWS_Server = null;
  
  public IWS_ServerProxy() {
    _initIWS_ServerProxy();
  }
  
  public IWS_ServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initIWS_ServerProxy();
  }
  
  private void _initIWS_ServerProxy() {
    try {
      iWS_Server = (new webservice1.WebServiceServerServiceLocator()).getWebServiceServerPort();
      if (iWS_Server != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iWS_Server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iWS_Server)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iWS_Server != null)
      ((javax.xml.rpc.Stub)iWS_Server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice1.IWS_Server getIWS_Server() {
    if (iWS_Server == null)
      _initIWS_ServerProxy();
    return iWS_Server;
  }
  
  public java.lang.String getHello1() throws java.rmi.RemoteException{
    if (iWS_Server == null)
      _initIWS_ServerProxy();
    return iWS_Server.getHello1();
  }
  
  public java.lang.String getServerName() throws java.rmi.RemoteException{
    if (iWS_Server == null)
      _initIWS_ServerProxy();
    return iWS_Server.getServerName();
  }
  
  public java.lang.String getHello2(java.lang.String yourname) throws java.rmi.RemoteException{
    if (iWS_Server == null)
      _initIWS_ServerProxy();
    return iWS_Server.getHello2(yourname);
  }
  
  
}