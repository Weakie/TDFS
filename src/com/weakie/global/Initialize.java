package com.weakie.global;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.weakie.listener.SocketDispatcher;

public class Initialize {
	private static Initialize instance = new Initialize();
	private ExecutorService excutor;
	private SocketDispatcher dispatcher;
	
	private Initialize(){};
	public static Initialize getInstance(){
		return instance;
	}
	
	public void startup() throws IOException{
		this.dispatcher = new SocketDispatcher();
		this.dispatcher.initialize(10031);
		this.excutor = Executors.newFixedThreadPool(1);
		this.excutor.execute(dispatcher);
		System.out.println("startup ");
	}
	
	public void shutdown() throws IOException{
		this.dispatcher.destroy();
		this.excutor.shutdown();
		System.out.println("shutdown ");
	}
	
}
