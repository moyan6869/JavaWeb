package com.sky.common.datasource;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import com.sky.common.util.StringUtil;

public class ClusterDatasource implements FactoryBean<ClusterDatasource>, InitializingBean {


    private static Logger log = Logger.getLogger("ClusterDatasource");

    private Map<String, BoneCPDataSource> mapsource;

    private Integer idleConnectionTestPeriod;
    private Integer idleMaxAge;
    private Integer maxConnectionsPerPartition;
    private Integer minConnectionsPerPartition;
    private Integer partitionCount;
    private Integer statementsCacheSize;
    private Integer releaseHelperThreads;
    private Integer statementReleaseHelperThreads;
    private Integer acquireIncrement;

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        if (StringUtil.isNull(mapsource)) {
            mapsource = new HashMap<String, BoneCPDataSource>();
        }
    }

    @Override
    public ClusterDatasource getObject() throws Exception {
        // TODO Auto-generated method stub
        return this;
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public BoneCPDataSource getBoneCPDataSource(int dataBaseType, String module, String url, String userName, String password) {
        BoneCPDataSource mbds = null;
        String key = module + "_" + dataBaseType + "";
        mbds = mapsource.get(key);
        if (StringUtil.isNull(mbds)) {
            mbds = creanBoneCPDataSource(key, url, userName, password);
        }
        return mbds;
    }


    /**
     * 创建 新的连接
     *
     * @param key
     * @param url
     * @param userName
     * @param password
     * @return
     */
    public BoneCPDataSource creanBoneCPDataSource(String key, String url, String userName, String password) {
        BoneCPDataSource mbds = null;
        BoneCPConfig jdbcconfig = null;
        jdbcconfig = new BoneCPConfig();
        jdbcconfig.setJdbcUrl(url);
        jdbcconfig.setUsername(userName);
        jdbcconfig.setPassword(password);
        jdbcconfig.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
        jdbcconfig.setMinConnectionsPerPartition(minConnectionsPerPartition);
        jdbcconfig.setPartitionCount(partitionCount);
        jdbcconfig.setStatementsCacheSize(statementsCacheSize);
        jdbcconfig.setReleaseHelperThreads(releaseHelperThreads);
        jdbcconfig.setStatementReleaseHelperThreads(statementReleaseHelperThreads);
        jdbcconfig.setAcquireIncrement(acquireIncrement);
        mbds = new BoneCPDataSource(jdbcconfig);
        mapsource.put(key, mbds);
        return mbds;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

    public Map<String, BoneCPDataSource> getMapsource() {
        return mapsource;
    }

    public void setMapsource(Map<String, BoneCPDataSource> mapsource) {
        this.mapsource = mapsource;
    }

    public Integer getIdleConnectionTestPeriod() {
        return idleConnectionTestPeriod;
    }

    public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
        this.idleConnectionTestPeriod = idleConnectionTestPeriod;
    }

    public Integer getIdleMaxAge() {
        return idleMaxAge;
    }

    public void setIdleMaxAge(Integer idleMaxAge) {
        this.idleMaxAge = idleMaxAge;
    }

    public Integer getMaxConnectionsPerPartition() {
        return maxConnectionsPerPartition;
    }

    public void setMaxConnectionsPerPartition(Integer maxConnectionsPerPartition) {
        this.maxConnectionsPerPartition = maxConnectionsPerPartition;
    }

    public Integer getMinConnectionsPerPartition() {
        return minConnectionsPerPartition;
    }

    public void setMinConnectionsPerPartition(Integer minConnectionsPerPartition) {
        this.minConnectionsPerPartition = minConnectionsPerPartition;
    }

    public Integer getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(Integer partitionCount) {
        this.partitionCount = partitionCount;
    }

    public Integer getStatementsCacheSize() {
        return statementsCacheSize;
    }

    public void setStatementsCacheSize(Integer statementsCacheSize) {
        this.statementsCacheSize = statementsCacheSize;
    }

    public Integer getReleaseHelperThreads() {
        return releaseHelperThreads;
    }

    public void setReleaseHelperThreads(Integer releaseHelperThreads) {
        this.releaseHelperThreads = releaseHelperThreads;
    }

    public Integer getStatementReleaseHelperThreads() {
        return statementReleaseHelperThreads;
    }

    public void setStatementReleaseHelperThreads(Integer statementReleaseHelperThreads) {
        this.statementReleaseHelperThreads = statementReleaseHelperThreads;
    }

    public Integer getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(Integer acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }


}
