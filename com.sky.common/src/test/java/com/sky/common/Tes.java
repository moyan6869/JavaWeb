package com.sky.common;

import java.math.BigDecimal;

/**
 * Created by 建帆 on 2016/1/20.
 */
public class Tes {
    public static void main( String[  ] ages){/*
        
        
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            InputStream input = Tes.class.getResource("testImport.xls").openStream();
            IOUtils.copy(input, output);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        Object data = DataExcelReader.INSTANCE.read(Tes.class.getName().replace(".", "/")+ "/memberDealPayBeanTpl.xml", output.toByteArray(), "memberDealPayBean", MemberDealPayBean.class);
        
        for(int i=0; i< 5; i++){
            for(int b = 2; b<7;b++){
                if(b==3){
                    break;
                }
                System.out.println("b:"+b);

            }
            System.out.println("i："+i);
        }*/
    	BigDecimal bigDatabase = new BigDecimal("100");
    	BigDecimal bigData = new BigDecimal("2253.24");
    	System.out.println(bigDatabase.multiply(bigData).intValue());

    }
}
