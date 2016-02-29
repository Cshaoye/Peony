package com.shaoye.quartz.db;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author hufan
 *
 */
public class DBTansfer {
	private static Logger logger = LoggerFactory.getLogger(DBTansfer.class);
	public void execute() {
		logger.info("current date is: "
				+ new Date(System.currentTimeMillis()).toString());
	}
}
