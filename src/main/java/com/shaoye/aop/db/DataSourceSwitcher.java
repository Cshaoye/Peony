package com.shaoye.aop.db;

import org.springframework.util.Assert;

/**
 * 数据源选择类
 * @author hufan
 */
public class DataSourceSwitcher {

	/**  使用 ThreadLocal是为了线程安全  **/
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/** 主库（写库） **/
	public static final String MASTER_DATA_SOURCE = "master";

	/** 从库(读库) **/
	public static final String SLAVE_DATA_SOURCE = "slave";

	public static void setDataSource(String dataSource) {
		Assert.notNull(dataSource, "dataSource cannot be null");
		contextHolder.set(dataSource);
	}

	public static void setMaster() {
		clearDataSource();
	}

	public static void setSlave() {
		setDataSource(SLAVE_DATA_SOURCE);
	}

	public static String getDataSource() {
		return (String) contextHolder.get();
	}

	public static void clearDataSource() {
		contextHolder.remove();
	}
}
