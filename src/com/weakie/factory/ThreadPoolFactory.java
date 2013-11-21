package com.weakie.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolFactory {

	public static ExecutorService newFixedThreadPool(){
		return Executors.newFixedThreadPool(1);
	}
}
