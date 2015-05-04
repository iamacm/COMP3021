package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import blog_system.Main;
import blog_system.Network;

public class MultiThreadServer {
	private static int visitor_count = 0;
	private final static int PORT = 3021;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Main.lab3_main(args);
		System.out.println("Server side started");
		clientListener cListener = new clientListener(3021);
		Thread clientListenerThread = new Thread(cListener);
		clientListenerThread.start();
		
	}
	
	
}
