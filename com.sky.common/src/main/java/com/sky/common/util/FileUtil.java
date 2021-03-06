package com.sky.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016-1-25
 * Description:处理字符串
 */
public class FileUtil {

    //记录各个文件头信息及对应的文件类型

    public static Map<String, String> mFileTypes = new ConcurrentHashMap<>();

    static {
        // images
        mFileTypes.put("FFD8FFE0", "jpg");
        mFileTypes.put("89504E47", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492A00", "tif");
        mFileTypes.put("424D", "bmp");

        //PS和CAD
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("41433130", "dwg"); // CAD
        mFileTypes.put("252150532D41646F6265","ps");

        //办公文档类
        mFileTypes.put("D0CF11E0", "doc"); //ppt、doc、xls
        mFileTypes.put("504B0304", "docx");//pptx、docx、xlsx

        /**注意由于文本文档录入内容过多，则读取文件头时较为多变-START**/
        mFileTypes.put("0D0A0D0A", "txt");//txt
        mFileTypes.put("0D0A2D2D", "txt");//txt
        mFileTypes.put("0D0AB4B4", "txt");//txt
        mFileTypes.put("B4B4BDA8", "txt");//文件头部为汉字
        mFileTypes.put("73646673", "txt");//txt,文件头部为英文字母
        mFileTypes.put("32323232", "txt");//txt,文件头部内容为数字
        mFileTypes.put("0D0A09B4", "txt");//txt,文件头部内容为数字
        mFileTypes.put("3132330D", "txt");//txt,文件头部内容为数字
        mFileTypes.put("C6BDCCA8","txt");
        mFileTypes.put("B0B2C8AB","txt");
        mFileTypes.put("EFBBBF23","txt");


        /**注意由于文本文档录入内容过多，则读取文件头时较为多变-END**/

        mFileTypes.put("7B5C727466", "rtf"); // 日记本

        mFileTypes.put("255044462D312E", "pdf");

        //视频或音频类
        mFileTypes.put("3026B275","wma");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("2E524D46", "rm");
        mFileTypes.put("000001BA", "mpg");
        mFileTypes.put("000001B3", "mpg");
        mFileTypes.put("6D6F6F76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");

        //压缩包
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("1F8B08", "gz");

        //程序文件
        mFileTypes.put("3C3F786D6C", "xml");
        mFileTypes.put("68746D6C3E", "html");
        mFileTypes.put("7061636B", "java");
        mFileTypes.put("3C252D2D", "jsp");//3C252D2D 3C254020
        mFileTypes.put("4D5A9000", "exe");


        mFileTypes.put("44656C69766572792D646174653A", "eml"); // 邮件
        mFileTypes.put("5374616E64617264204A", "mdb");//Access数据库文件

        mFileTypes.put("46726F6D", "mht");
        mFileTypes.put("4D494D45", "mhtml");
    }

    /**
     * 根据文件的输入流获取文件头信息
     *
     * @param bytes 文件内容前4位
     * @return 文件头信息
     */
    public static String getFileType(byte[] bytes) {
        return mFileTypes.get(getFileHeader(bytes));
    }


    /**
     * 根据文件转换成的字节数组获取文件头信息
     *
     * @param bytes 文件内容前4位
     * @return 文件头信息
     */
    public static String getFileHeader(byte[] bytes) {
        String value = bytesToHexString(bytes);
        return value;
    }


    /**
     * 将要读取文件头信息的文件的byte数组转换成string类型表示
     * <p/>
     * 下面这段代码就是用来对文件类型作验证的方法，
     * <p/>
     * 将字节数组的前四位转换成16进制字符串，并且转换的时候，要先和0xFF做一次与运算。
     * <p/>
     * 这是因为，整个文件流的字节数组中，有很多是负数，进行了与运算后，可以将前面的符号位都去掉，
     * <p/>
     * 这样转换成的16进制字符串最多保留两位，如果是正数又小于10，那么转换后只有一位，
     * <p/>
     * 需要在前面补0，这样做的目的是方便比较，取完前四位这个循环就可以终止了
     *
     * @param src 要读取文件头信息的文件的byte数组
     * @return 文件头信息
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            // 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式，并转换为大写
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        //log.info("获取文件头信息:" + builder.toString());
        return builder.toString();
    }



}
