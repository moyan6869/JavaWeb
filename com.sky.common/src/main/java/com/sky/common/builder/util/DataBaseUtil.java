package com.sky.common.builder.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sky.common.builder.bean.FieldBean;

/**
 * 数据库工具</br>
 * 注意：如果需要修改，请联系 进行修改，联系电话： ，联系QQ：100992995，联系邮箱： </br>
 * @version 1.0
 * @author  
 */
public class DataBaseUtil {
	/**
	 * 获取指定表的所有字段名
	 * 
	 * @param tableName
	 * @return List<FieldBean>
	 * @throws SQLException
	 */
	public static List<FieldBean> getTableField(String tableName, Connection con)
			throws SQLException {
		List<FieldBean> fieldBeanList = new ArrayList<FieldBean>();
		PreparedStatement pstmt = null;
		ResultSetMetaData rsmd = null;
		String sql = "select * from " + tableName + " limit 1";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			rsmd = pstmt.getMetaData();

			FieldBean bean = null;
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				bean = new FieldBean();
				bean.setName(rsmd.getColumnName(i).toLowerCase());
				bean.setType(rsmd.getColumnType(i));
				bean.setTypeName(rsmd.getColumnTypeName(i));
				bean.setCatalogName(rsmd.getCatalogName(i));
				bean.setClassName(rsmd.getColumnClassName(i));
				bean.setSize(rsmd.getColumnDisplaySize(i));
				bean.setLabel(rsmd.getColumnLabel(i).toLowerCase());
				bean.setSchemaName(rsmd.getSchemaName(i));
				bean.setPrecision(rsmd.getPrecision(i));
				bean.setScale(rsmd.getScale(i));
				bean.setTableName(rsmd.getTableName(i));
				bean.setAutoIncrement(rsmd.isAutoIncrement(i));
				bean.setCurrency(rsmd.isCurrency(i));
				bean.setNullable(rsmd.isNullable(i));
				bean.setReadOnly(rsmd.isReadOnly(i));
				bean.setSearchable(rsmd.isSearchable(i));

				fieldBeanList.add(bean);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return fieldBeanList;
	}

	/**
	 * 获取所有表的集合
	 * 
	 * @param con
	 *            数据库连接
	 * @return List<String> 所有表集合
	 */
	public static List<String> getTableList(Connection con) {
		List<String> list = new ArrayList<String>();
		String sql = "show TABLES;";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					list.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
