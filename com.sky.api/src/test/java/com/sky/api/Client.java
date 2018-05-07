package com.sky.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("client")  
public class Client {  
  
    @XStreamAsAttribute //对属性值进行注解  
    private String type;//此时类中的属性名要和xml内的属性名相对应  
  
    @XStreamAsAttribute  
    private String osversion;  
  
    @XStreamAsAttribute  
    private String version;  
  
    @XStreamAsAttribute  
    private String oemtag;  
  
    @XStreamAsAttribute  
    private String area;  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getOsversion() {  
        return osversion;  
    }  
  
    public void setOsversion(String osversion) {  
        this.osversion = osversion;  
    }  
  
    public String getVersion() {  
        return version;  
    }  
  
    public void setVersion(String version) {  
        this.version = version;  
    }  
  
    public String getOemtag() {  
        return oemtag;  
    }  
  
    public void setOemtag(String oemtag) {  
        this.oemtag = oemtag;  
    }  
  
    public String getArea() {  
        return area;  
    }  
  
    public void setArea(String area) {  
        this.area = area;  
    }  
  
}  
