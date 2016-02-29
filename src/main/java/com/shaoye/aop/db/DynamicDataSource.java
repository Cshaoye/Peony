package com.shaoye.aop.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源动态切换类
 * @author hufan
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private static Logger logger = LoggerFactory
			.getLogger(DynamicDataSource.class);

	@Override
	protected Object determineCurrentLookupKey() {
		logger.info("current select db is {}", DataSourceSwitcher.getDataSource());
		return DataSourceSwitcher.getDataSource();
	}

}
