package com.sky.common.util;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

/**
 * @Author: suzheng
 * @Version:
 * @Package: com.sibu.common.util
 * @Company: SIBU_KANGER
 * @Description:
 * @Date: 2016/05/30
 */
public class FmtNumberToStringProcessor extends CellProcessorAdaptor{
    private String regex = "[0-9]\\d*";

    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);
        if (!(value instanceof String)) {
            throw new SuperCsvCellProcessorException(String.class, value, context, this);
        }
        if (value.toString().matches(regex)){
            return next.execute("'" + value.toString(), context);
        }
        return next.execute(value, context);
    }
}
