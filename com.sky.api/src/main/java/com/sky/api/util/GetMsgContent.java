package com.sky.api.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

/**
 * Created by Administrator on 2017/3/16 0016.
 */
@Controller
@RequestMapping(value = "getMsgContent",produces = "application/json")
public class GetMsgContent {

    @RequestMapping("get")
    @ResponseBody
    public String get(String content) throws Exception{
        Writer writer = new FileWriter("e:/file.txt",true);
        writer.write(content);
        writer.close();
        return "";
    }
}
