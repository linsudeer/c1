/**
 * Sms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.czht.smartpark.tbweb.modular.webservice.msg;

public class Sms  implements java.io.Serializable {
    private String content;

    private String mobile;

    private String receiveUserId;

    private String receiveUserName;

    private String sendUserId;

    private String sendUserName;

    private String systemName;

    public Sms() {
    }

    public Sms(
           String content,
           String mobile,
           String receiveUserId,
           String receiveUserName,
           String sendUserId,
           String sendUserName,
           String systemName) {
           this.content = content;
           this.mobile = mobile;
           this.receiveUserId = receiveUserId;
           this.receiveUserName = receiveUserName;
           this.sendUserId = sendUserId;
           this.sendUserName = sendUserName;
           this.systemName = systemName;
    }


    /**
     * Gets the content value for this Sms.
     *
     * @return content
     */
    public String getContent() {
        return content;
    }


    /**
     * Sets the content value for this Sms.
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Gets the mobile value for this Sms.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this Sms.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the receiveUserId value for this Sms.
     *
     * @return receiveUserId
     */
    public String getReceiveUserId() {
        return receiveUserId;
    }


    /**
     * Sets the receiveUserId value for this Sms.
     *
     * @param receiveUserId
     */
    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }


    /**
     * Gets the receiveUserName value for this Sms.
     *
     * @return receiveUserName
     */
    public String getReceiveUserName() {
        return receiveUserName;
    }


    /**
     * Sets the receiveUserName value for this Sms.
     *
     * @param receiveUserName
     */
    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }


    /**
     * Gets the sendUserId value for this Sms.
     *
     * @return sendUserId
     */
    public String getSendUserId() {
        return sendUserId;
    }


    /**
     * Sets the sendUserId value for this Sms.
     *
     * @param sendUserId
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }


    /**
     * Gets the sendUserName value for this Sms.
     *
     * @return sendUserName
     */
    public String getSendUserName() {
        return sendUserName;
    }


    /**
     * Sets the sendUserName value for this Sms.
     *
     * @param sendUserName
     */
    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }


    /**
     * Gets the systemName value for this Sms.
     *
     * @return systemName
     */
    public String getSystemName() {
        return systemName;
    }


    /**
     * Sets the systemName value for this Sms.
     *
     * @param systemName
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof Sms)) return false;
        Sms other = (Sms) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.content==null && other.getContent()==null) ||
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.mobile==null && other.getMobile()==null) ||
             (this.mobile!=null &&
              this.mobile.equals(other.getMobile()))) &&
            ((this.receiveUserId==null && other.getReceiveUserId()==null) ||
             (this.receiveUserId!=null &&
              this.receiveUserId.equals(other.getReceiveUserId()))) &&
            ((this.receiveUserName==null && other.getReceiveUserName()==null) ||
             (this.receiveUserName!=null &&
              this.receiveUserName.equals(other.getReceiveUserName()))) &&
            ((this.sendUserId==null && other.getSendUserId()==null) ||
             (this.sendUserId!=null &&
              this.sendUserId.equals(other.getSendUserId()))) &&
            ((this.sendUserName==null && other.getSendUserName()==null) ||
             (this.sendUserName!=null &&
              this.sendUserName.equals(other.getSendUserName()))) &&
            ((this.systemName==null && other.getSystemName()==null) ||
             (this.systemName!=null &&
              this.systemName.equals(other.getSystemName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getReceiveUserId() != null) {
            _hashCode += getReceiveUserId().hashCode();
        }
        if (getReceiveUserName() != null) {
            _hashCode += getReceiveUserName().hashCode();
        }
        if (getSendUserId() != null) {
            _hashCode += getSendUserId().hashCode();
        }
        if (getSendUserName() != null) {
            _hashCode += getSendUserName().hashCode();
        }
        if (getSystemName() != null) {
            _hashCode += getSystemName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Sms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ns.leadal.com/sms", "sms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiveUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiveUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiveUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiveUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendUserId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendUserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sendUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("systemName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "systemName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
