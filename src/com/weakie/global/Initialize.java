package com.weakie.global;

import java.io.IOException;
import java.net.ServerSocket;

public class Initialize {

	private ServerSocket listen;
	private int listenPort;
	
	public static Initialize instance = new Initialize();
	private Initialize(){};
	
	public static Initialize getInstance(){
		return instance;
	}
	
	public void startup() throws IOException{
		listen = new ServerSocket(listenPort);
		//Socket socket = listen.accept();
		System.out.println("startup ");
	}
	
	public void shutdown() throws IOException{
		listen.close();
		System.out.println("shutdown ");
	}
	
	public int getListenPort(){
		return this.listenPort;
	}
	
	public void setListenPort(int port){
		this.listenPort = port;
	}
}
