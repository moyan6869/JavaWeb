package com.sky.api;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("config")  
public class AllnewstateRQ {  
    //当节点下有独立属性的时候，需要创建一个独立的类用来保存节点内的属性  
    private Client client = new Client();  
    private Sign sign = new Sign();  
    private Vientiance vientiance = new Vientiance();  
    //当节点下没有属性，直接由StringValue的时候可直接创建String类型属性  
    private String protocol;  
    public Client getClient() {  
        return client;  
    }  
    public void setClient(Client client) {  
        this.client = client;  
    }  
    public Sign getSign() {  
        return sign;  
    }  
    public void setSign(Sign sign) {  
        this.sign = sign;  
    }  
    public Vientiance getVientiance() {  
        return vientiance;  
    }  
    public void setVientiance(Vientiance vientiance) {  
        this.vientiance = vientiance;  
    }  
    public String getProtocol() {  
        return protocol;  
    }  
    public void setProtocol(String protocol) {  
        this.protocol = protocol;  
    }  
}  
