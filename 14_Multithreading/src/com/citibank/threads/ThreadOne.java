package com.citibank.threads;

import java.util.Iterator;

public class ThreadOne extends Thread {

	public void run() {
		System.out.println("ThreadOne start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("ThreadOne " + i);
		}
		System.out.println("ThreadOne end");
	}
}
