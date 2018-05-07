package com.sky.web.model;
import java.io.Serializable;
/**
 * Created by 建帆 on 2015/11/20.
 */
public class DealCount implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分库模
     */
    private String module;

    /**
     * 显示名称
     */
    private String label;

    /**
     * 统计数
     */
    private int count;

    /**
     * @return module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module 要设置的 module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label 要设置的 label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count 要设置的 count
     */
    public void setCount(int count) {
        this.count = count;
    }
}
