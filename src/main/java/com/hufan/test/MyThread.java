package com.hufan.test;

/**
 * 测试时间调度器而准备的线程
 * @author hufan
 *
 */
public class MyThread implements Runnable {

	public void run() {
		while (true) {
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
