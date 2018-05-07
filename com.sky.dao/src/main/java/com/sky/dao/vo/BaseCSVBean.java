package com.sky.dao.vo;


import org.supercsv.cellprocessor.ift.CellProcessor;

import java.util.List;

/**
 * @Author: suzheng
 * @Version:
 * @Package: com.sibu.dao.directsale.vo
 * @Company: SIBU_KANGER
 * @Description: cvs文件基本抽象类包括csv文件的基本内容：文件名，每一列的名称，每行内容
 * @Date: 2016/05/27
 */
public abstract class BaseCSVBean {

    /**
     * csv文件名称
     */
    private String fileName;

    /**
     * 列字段名称
     */
    private String[] headerNames;

    /**
     * 要显示的内容字段
     */
    private String[] beanFields;

    /**
     * 内容
     */
    private List<?> beanList;

    /**
     * 内容处理器：请在org.supercsv.cellprocessor.ift中选用合适的处理器
     * 每个处理器按照顺序一一对应处理beanFields中的值；
     * 如果需要自定义自己的处理器请继承CellProcessorAdaptor；参考FmtNumberToStringProcessor
     */
    private CellProcessor[] processors;

    public BaseCSVBean(String fileName, String[] headerNames, String[] beanFields, List<?> beanList, CellProcessor[] processors) {
        this.fileName = fileName;
        this.headerNames = headerNames;
        this.beanFields = beanFields;
        this.beanList = beanList;
        this.processors = processors;
    }

    public BaseCSVBean() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getHeaderNames() {
        return headerNames;
    }

    public void setHeaderNames(String[] headerNames) {
        this.headerNames = headerNames;
    }

    public String[] getBeanFields() {
        return beanFields;
    }

    public void setBeanFields(String[] beanFields) {
        this.beanFields = beanFields;
    }

    public List<?> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<?> beanList) {
        this.beanList = beanList;
    }

    public CellProcessor[] getProcessors() {
        return processors;
    }

    public void setProcessors(CellProcessor[] processors) {
        this.processors = processors;
    }
}
