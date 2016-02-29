package com.hufan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4HuFan {
	public static ApplicationContext context;
	static {
		// 从类路径
		context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
	}

	public static void main(String[] args) {
		MyThread t = new MyThread();
		Thread t1 = new Thread(t, "线程1");
		t1.start();
	}
}
