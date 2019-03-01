/**
 * SmsServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.czht.smartpark.tbweb.modular.webservice.msg;

public class SmsServiceImplServiceLocator extends org.apache.axis.client.Service implements SmsServiceImplService {

    public SmsServiceImplServiceLocator() {
    }


    public SmsServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SmsServiceImplServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SmsServiceImplPort
    private String SmsServiceImplPort_address = "http://192.168.2.50:8080/services/SmsService";

    public String getSmsServiceImplPortAddress() {
        return SmsServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String SmsServiceImplPortWSDDServiceName = "SmsServiceImplPort";

    public String getSmsServiceImplPortWSDDServiceName() {
        return SmsServiceImplPortWSDDServiceName;
    }

    public void setSmsServiceImplPortWSDDServiceName(String name) {
        SmsServiceImplPortWSDDServiceName = name;
    }

    public SmsService getSmsServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SmsServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSmsServiceImplPort(endpoint);
    }

    public SmsService getSmsServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SmsServiceImplServiceSoapBindingStub _stub = new SmsServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSmsServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSmsServiceImplPortEndpointAddress(String address) {
        SmsServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SmsService.class.isAssignableFrom(serviceEndpointInterface)) {
                SmsServiceImplServiceSoapBindingStub _stub = new SmsServiceImplServiceSoapBindingStub(new java.net.URL(SmsServiceImplPort_address), this);
                _stub.setPortName(getSmsServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("SmsServiceImplPort".equals(inputPortName)) {
            return getSmsServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ns.leadal.com/sms", "SmsServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ns.leadal.com/sms", "SmsServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

if ("SmsServiceImplPort".equals(portName)) {
            setSmsServiceImplPortEndpointAddress(address);
        }
        else
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
