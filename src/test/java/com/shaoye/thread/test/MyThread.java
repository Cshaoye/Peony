package com.shaoye.thread.test;

public class MyThread implements Runnable {
	
	public void run() {
		System.out.println("**********************");
		while (true) {
			System.out.println("before sleeping 5 seconds........");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("after sleeping 5 seconds........");
		}
	}
}
