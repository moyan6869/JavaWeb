package com.sky.common.util;


import java.io.*;
import java.util.*;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * Created by zhangcp on 2016/4/20.11:30
 */
public class ExcelUtil {
    /*
  * 日志工具
  */
    private static Logger log = Logger.getLogger(ExcelUtil.class);
    private static final String DEFAULT_SHEET_NAME = "sheet";

    /**
     * 导出无动态表头的Excel文件
     * <p>
     * 参考重载的有动态表头注释
     * </p>
     * @param destOutputStream
     * @param templateInputStream
     * @param data
     * @param dataKey
     * @param maxRowPerSheet
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void generateExcelByTemplate(OutputStream destOutputStream,
                                               InputStream templateInputStream,
                                               List data, String dataKey,
                                               int maxRowPerSheet) throws Exception {
        generateExcelByTemplate(destOutputStream,
                templateInputStream,
                null, null,
                data, dataKey,
                maxRowPerSheet);
    }

    /**
     * 通过Excel模版生成Excel文件
     * <p>
     * 创建Excel模版，变量类似JSP tag风格。
     * 例如：
     * <ul>
     * <li>无动态表头
     * <pre>
     * 序号   名称  规格  创建时间    价格
     * &lt;jx:forEach items="${vms}" var="vm"&gt;
     * ${vm.id} ${vm.name} ${vm.scale} ${vm.created} ${vm.price}
     * &lt;/jx:forEach&gt;
     * </pre>
     * </li>
     * <li>有动态表头
     * <pre>
     * 项目/数量/时间    &lt;jx:forEach items="${dates}" var="date"&gt;    ${date} &lt;/jx:forEach&gt;
     * &lt;jx:forEach items="${itemsx}" var="item"&gt;
     * ${item.name}    &lt;jx:forEach items="${item.counts}" var="count"&gt; ${count}    &lt;/jx:forEach&gt;
     * &lt;/jx:forEach&gt;
     * </pre>
     * </li>
     * </ul>
     * 调用该方法则生成对应的Excel文件。
     * </p>
     * <p>
     * 注意：dataKey不能是items, items是保留字，如果用items则会提示：Collection is null并抛出NullPointerException
     * </p>
     * @param destOutputStream Excel输出流
     * @param templateInputStream Excel模版输入流
     * @param header 动态表头
     * @param headerKey 表头的变量
     * @param data 数据项
     * @param dataKey 数据项变量
     * @param maxRowPerSheet 每个sheet最多行数
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void generateExcelByTemplate(OutputStream destOutputStream,
                                               InputStream templateInputStream,
                                               List header, String headerKey,
                                               List data, String dataKey,
                                               int maxRowPerSheet) throws Exception {

        List<List> splitData = null;
        @SuppressWarnings("unchecked")
        Map<String, List> beanMap = new HashMap();
        List<String> sheetNames = new ArrayList<String>();
        if (data.size() > maxRowPerSheet) {
            splitData = splitList(data, maxRowPerSheet);
            sheetNames = new ArrayList<String>(splitData.size());
            for (int i = 0; i < splitData.size(); ++i) {
                sheetNames.add(DEFAULT_SHEET_NAME  + i);
            }
        } else {
            splitData = new ArrayList<List>();
            sheetNames.add(DEFAULT_SHEET_NAME + 0);
            splitData.add(data);
        }
        if (null != header) {
            beanMap.put(headerKey, header);
        }
        XLSTransformer transformer = new XLSTransformer();
        Workbook workbook = transformer.transformMultipleSheetsList(
                templateInputStream, splitData, sheetNames, dataKey, beanMap, 0);
        workbook.write(destOutputStream);
    }


    /**
     * 导出无动态表头的Excel文件，目标文件和模版文件均为文件路径
     * <p>
     * 参考重载的有动态表头注释
     * </p>
     * @param destFilePath
     * @param templateFilePath
     * @param data
     * @param dataKey
     * @param maxRowPerSheet
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void generateExcelByTemplate(String destFilePath,
                                               String templateFilePath,
                                               List data, String dataKey, int maxRowPerSheet) throws Exception {
        generateExcelByTemplate(destFilePath, templateFilePath, null, null, data, dataKey, maxRowPerSheet);
    }

    /**
     * 导出有动态表头的Excel文件，目标文件和模版文件均为文件路径
     * <p>
     * 参考重载的有动态表头注释
     * </p>
     * @param destFilePath
     * @param templateFilePath
     * @param header
     * @param headerKey
     * @param data
     * @param dataKey
     * @param maxRowPerSheet
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static void generateExcelByTemplate(String destFilePath,
                                               String templateFilePath,
                                               List header, String headerKey,
                                               List data, String dataKey, int maxRowPerSheet) throws Exception {
        generateExcelByTemplate(new FileOutputStream(destFilePath),
                new FileInputStream(templateFilePath),
                header, headerKey,
                data, dataKey, maxRowPerSheet);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static List<List> splitList(List data, int maxRowPerSheet) {
        List<List> splitData = new ArrayList<List>();
        List sdata = null;
        for (int i = 0; i < data.size(); ++i) {
            if (0 == i % maxRowPerSheet) {
                if (null != sdata) {
                    splitData.add(sdata);
                }
                sdata = new ArrayList(maxRowPerSheet);
            }
            sdata.add(data.get(i));
        }
        if (0 != maxRowPerSheet % data.size()) {
            splitData.add(sdata);
        }

        return splitData;
    }

    /**
     * 通过指定模板导出excel数据
     * @param map
     * @param templateFilePath 模板的绝对路径
     * @param os
     */
    public static void exportExcel(Map map,String templateFilePath,OutputStream os){
        XLSTransformer transformer = new XLSTransformer();
        try {
            //获得模板的输入流
            FileInputStream in = new FileInputStream(templateFilePath);
            //将beans通过模板输入流写到workbook中
            Workbook workbook = transformer.transformXLS(in, map);

            //将workbook中的内容用输出流写出去
            workbook.write(os);

        }catch (Exception e) {
            log.error("导出excel出错!" + e.getMessage() + Arrays.toString(e.getStackTrace()));
            throw new RuntimeException();
        }
    }
}
