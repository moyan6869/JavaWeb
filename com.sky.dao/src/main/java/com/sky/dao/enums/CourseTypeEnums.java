package com.sky.dao.enums;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: Kanger
 * @Description: 课程分类大类类型
 * @Date: 2016/12/26 11:01
 */
public enum  CourseTypeEnums {
    //课程分类（0，云商课程，1、云商视频，2、云商海报、3、云商分享[文章]）
    OpenClass(0,"云商课程"),
    VideoClass(1,"云商视频"),
    PosterClass(2,"云商海报"),
    ArticleClass(3,"云商分享[文章]");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }


    private   CourseTypeEnums(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public  static CourseTypeEnums valueOf(int code){
       switch (code){
           case 0:
               return OpenClass;
           case 1:
               return VideoClass;
           case 2:
               return PosterClass;
           case 3:
               return ArticleClass;
           default:
               return OpenClass;
       }
    }

}
