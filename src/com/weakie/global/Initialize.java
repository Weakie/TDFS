package com.weakie.global;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Initialize {

	private ServerSocket listen;
	private int listenPort;
	
	private Initialize(){};
	
	
	public void startup() throws IOException{
		listen = new ServerSocket(listenPort);
		Socket socket = listen.accept();
		
	}
	
	public void shutdown() throws IOException{
		listen.close();
	}
	
	public int getListenPort(){
		return this.listenPort;
	}
	
	public void setListenPort(int port){
		this.listenPort = port;
	}
}
