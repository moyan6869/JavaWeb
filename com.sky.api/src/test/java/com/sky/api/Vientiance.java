package com.sky.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("vientiance")  
public class Vientiance {  
    @XStreamAsAttribute  
    private String version;  
    public String getVersion() {  
        return version;  
    }  
    public void setVersion(String version) {  
        this.version = version;  
    }  
}  