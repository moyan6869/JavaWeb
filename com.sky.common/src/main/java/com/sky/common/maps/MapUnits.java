package com.sky.common.maps;

import com.sky.common.enums.*;
import com.sky.dao.enums.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Geoffrey
 * @Packager: com.dami.dao.DaMi.maps
 * @company: SIBU Kanger
 * @Description: 提供把枚举类型转换成map类型的服务
 * @Date: 2016/6/12 10:40
 */
public class MapUnits {

    /**
     * 根据订单枚举转换成页面需要的map
     * @return
     */
    public static Map<Integer,Object> getExpressTypeMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < ExpressTypeEnums.values().length; i++) {
            map.put(i, ExpressTypeEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getIsWriteBackMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < IsWriteBackEnums.values().length; i++) {
            map.put(i, IsWriteBackEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getExpressIdMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = -4; i < ExpressIdEnums.values().length; i++) {
            map.put(i, ExpressIdEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getOrderStatusMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < OrderStatusEnums.values().length; i++) {
            map.put(i, OrderStatusEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getOrderFromMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < OrderFromEnums.values().length; i++) {
            map.put(i, OrderFromEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getPushStatusMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < PushStatusEnums.values().length; i++) {
            map.put(i, PushStatusEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getProviceMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (int i = 0; i < ProviceEnums.values().length; i++) {
            map.put(i, ProviceEnums.valueOf(i).getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getWarehouseStockCountTypeMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (WarehouseStockCountType warehouseStockCountType : WarehouseStockCountType.values()) {
            map.put(warehouseStockCountType.getCode(),warehouseStockCountType.getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getWarehouseStockTypeMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (WarehouseStockType warehouseStockType : WarehouseStockType.values()) {
            map.put(warehouseStockType.getCode(),warehouseStockType.getMsg());
        }
        return map;
    }
    public static Map<Integer,Object> getEntryStatusEnumsMap(){
        Map<Integer,Object> map=new HashMap<>();
        for (EntryStatusEnums entryStatusEnums : EntryStatusEnums.values()) {
            map.put(entryStatusEnums.getCode(),entryStatusEnums.getMsg());
        }
        return map;
    }
}
