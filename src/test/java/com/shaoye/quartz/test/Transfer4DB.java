package com.shaoye.quartz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shaoye.thread.test.MyThread;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class Transfer4DB {
	private static Logger logger = LoggerFactory.getLogger(Transfer4DB.class);

	@Test
	public void testJob() {
		logger.info("dasdasd");
		MyThread t = new MyThread();
		Thread t1 = new Thread(t, "线程1");
		t1.start();

	}
}
