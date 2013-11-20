package com.weakie.initialize;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.weakie.global.SpringBeanUtil;
import com.weakie.listener.SocketDispatcher;

public class Initialize {
	private static Initialize instance;
	private ExecutorService excutor;
	private SocketDispatcher dispatcher;
	
	public Initialize(){};
	
	public static Initialize getInstance(){
		//get the object from spring framework, avoid get it twice.
		if(instance == null){
			synchronized(Initialize.class){
				if(instance == null){
					instance = (Initialize) SpringBeanUtil.getBeans("initialize");
				}
			}
		}
		return instance;
	}
	
	public void startup() throws IOException{
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
	
	public SocketDispatcher getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(SocketDispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
}
