package com.sky.common.util;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.util.CsvContext;

import java.util.Map;
import java.util.Set;

/**
 * @Author: yezilin
 * @Version:
 * @Package: com.sky.common.util
 * @Description:
 */
public class FmtTypeOrStatusProcessor extends CellProcessorAdaptor{

    private final Map<Integer,Object> mapUnit;

    public FmtTypeOrStatusProcessor(Map<Integer,Object> map) {
        this.mapUnit = map;
    }

    public <T> T execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);
        /*if (!(value instanceof )) {
            throw new SuperCsvCellProcessorException(String.class, value, context, this);
        }*/
        Set set = mapUnit.keySet();
        for(Object key : set)
        {
            if (value.toString().equals(key+"")){
                return next.execute(mapUnit.get(key).toString(), context);
            }
        }
        return next.execute(value, context);
    }
}
