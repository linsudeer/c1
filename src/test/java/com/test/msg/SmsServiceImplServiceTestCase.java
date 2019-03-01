/**
 * SmsServiceImplServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.test.msg;

import com.czht.smartpark.tbweb.modular.webservice.msg.Sms;
import com.czht.smartpark.tbweb.modular.webservice.msg.SmsServiceImplServiceLocator;
import com.czht.smartpark.tbweb.modular.webservice.msg.SmsServiceImplServiceSoapBindingStub;
import junit.framework.TestCase;

public class SmsServiceImplServiceTestCase extends TestCase {
    public SmsServiceImplServiceTestCase(String name) {
        super(name);
    }

    public void testSmsServiceImplPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new SmsServiceImplServiceLocator().getSmsServiceImplPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new SmsServiceImplServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SmsServiceImplPortSendSms() throws Exception {
        SmsServiceImplServiceSoapBindingStub binding;
        try {
            binding = (SmsServiceImplServiceSoapBindingStub)
                          new SmsServiceImplServiceLocator().getSmsServiceImplPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.sendSms(new Sms());
        // TBD - validate results
    }

}
