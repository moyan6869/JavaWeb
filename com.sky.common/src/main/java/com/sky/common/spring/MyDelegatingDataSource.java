package com.sky.common.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import com.jolbox.bonecp.BoneCPDataSource;

public class MyDelegatingDataSource extends DelegatingDataSource {

	/** Logging. */
	private static final Log logger = LogFactory.getLog(LazyConnectionDataSourceProxy.class);
	
	/**
	 * Create a new DynamicDataSourceProxy.
	 * @param targetDataSource the target DataSource
	 */
	public MyDelegatingDataSource(DataSource targetDataSource) {
		setTargetDataSource(targetDataSource);
		afterPropertiesSet();
	}
	
	/**
	 * Default constructor.
	 */
	public MyDelegatingDataSource(){
		// default constructor
	}
	
	/** Switch to a new DataSource using the given configuration.
	 * @param newConfig BoneCP DataSource to use.
	 * @throws SQLException
	 */
	public void switchDataSource(BoneCPDataSource newConfig) throws SQLException {
		logger.info("Switch to new datasource requested. New Config: "+newConfig);
		DataSource oldDS = getTargetDataSource();
 
		if (!(oldDS instanceof BoneCPDataSource)){
			throw new SQLException("Unknown datasource type! Was expecting BoneCPDataSource but received "+oldDS.getClass()+". Not switching datasource!");
		}
		
		oldDS.getConnection().close(); // initialize a connection (+ throw it away) to force the datasource to initialize the pool
//		((BoneCPDataSource)oldDS).close();
		
		// force application to start using the new one 
		setTargetDataSource(newConfig);
		afterPropertiesSet();
		//logger.info("Shutting down old datasource slowly. Old Config: "+oldDS);
		// tell the old datasource to terminate. This terminates the pool lazily so existing checked out connections can still be used.
	}
	
}
