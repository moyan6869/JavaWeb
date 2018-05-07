package com.sky.api;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class TestStream {  
	  
    public static void main(String[] args) {  
        String reqXml = getXml();  
        XStream xs = new XStream(new DomDriver());   
        xs.processAnnotations(new Class[]{AllnewstateRQ.class,Client.class,Sign.class,Vientiance.class});  
        Object obj = xs.fromXML(reqXml);  
        AllnewstateRQ allnewstateRQ = (AllnewstateRQ) obj;  
        System.out.println(allnewstateRQ.getProtocol());  
        System.out.println(allnewstateRQ.getClient().getArea());  
        System.out.println(reqXml);  
  
    }  
      
    static String getXml(){  
        StringBuilder str = new StringBuilder();  
        str.append("")  
        .append("<config>")  
        .append("<client type=\"8888\" osversion=\"9999\" version=\"123\" oemtag=\"5555\"  area=\"areacode\" />")  
        .append("<protocol>1.10</protocol>")  
        .append("<sign value=\"asdfasdf\" />")  
        .append("<vientiance version=\"version\" />")  
        .append("</config>")  
        ;  
        return str.toString();  
    }  
  
}  
