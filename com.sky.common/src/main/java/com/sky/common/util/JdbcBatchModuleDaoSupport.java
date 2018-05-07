package com.sky.common.util;

import com.sky.common.bean.StatusBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.common.util
 * @company: SI Bu kanger
 * @Description: (批量jdbc)
 * @date 2016/4/18
 */
public class JdbcBatchModuleDaoSupport {

    private Map<String,List<JdbcCommandInfo>> moduleMap;
    
    public JdbcBatchModuleDaoSupport(){
        moduleMap = new HashMap<String,List<JdbcCommandInfo>>();
    }

    /**
     * 添加一条记录
     * @param memberId
     * @param commandInfo
     */
    public void addRecord(String memberId,JdbcCommandInfo commandInfo){
        if(StringUtils.isBlank(memberId) || null==commandInfo){
            return;
        }
        //memberId最后一位作为key
        String module = memberId.substring(memberId.length() - 1, memberId.length()).toLowerCase();
        List<JdbcCommandInfo> commandInfos = null;
        if(moduleMap.containsKey(module)){
            commandInfos = moduleMap.get(module);
        }else {
            commandInfos = new ArrayList<JdbcCommandInfo>();
            moduleMap.put(module,commandInfos);
        }
        commandInfos.add(commandInfo);
    }

    /**
     * 保存到数据库
     * @param dataBaseType
     * @return
     */
    public StatusBean<String> saveBatchTrans(int dataBaseType){
        //StringBuilder result = new StringBuilder();
        List<JdbcCommandInfo> commandInfos = null;
        List<JdbcCommandInfo> excuteBatchSaveDates = null;
        int fromIndex = 0,toIndex = 500;
        boolean excuteResult = false;
        int success = 0,fail = 0;
        for(Map.Entry<String,List<JdbcCommandInfo>> entry:moduleMap.entrySet()){
            commandInfos = entry.getValue();
            fromIndex = 0;
            toIndex = 500;
            while (true){
                if(toIndex>commandInfos.size()){
                    toIndex = commandInfos.size();
                }
                if(toIndex<=0 || toIndex<fromIndex || fromIndex>=commandInfos.size()){
                    break;
                }
                excuteBatchSaveDates = commandInfos.subList(fromIndex,toIndex);
                excuteResult = JdbcModuleDaoSupport2.saveBatchTrans(dataBaseType,excuteBatchSaveDates,entry.getKey());
                if(excuteResult){
                    //记录执行成功的条数
                    success++;
                }else {
                    //记录执行失败的条数
                    fail++;
                }
                fromIndex += toIndex;
                toIndex += 500;
            }
        }
        /*result.append(success);
        result.append("条记录执行成功!\n");
        result.append(fail);
        result.append("条记录执行失败!\n");*/
        if(success>0){
            return new StatusBean(true,"0000","",null);
        }else {
            return new StatusBean(false,"9999","",null);
        }
    }
}
