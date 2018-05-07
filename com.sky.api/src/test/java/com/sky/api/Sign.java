package com.sky.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("sign") //此处要对应节点的名称  
public class Sign {  
    @XStreamAsAttribute  
    private String value;//此处对应节点内属性名称  
    public String getValue() {  
        return value;  
    }  
    public void setValue(String value) {  
        this.value = value;  
    }  
}  
