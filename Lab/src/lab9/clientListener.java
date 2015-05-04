package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class clientListener implements Runnable {
	private int PORT = 0;
	private Socket clientSocket;
	private static int visitor_count = 0;
	private int visitor_id = 0;
	PrintWriter out;
	BufferedReader in;
	public clientListener(int p) {
		this.PORT = p;
		this.connect();
		clientSocket = null;
	}
	
	private clientListener(Socket s) throws IOException {
		this.clientSocket = s;
		++visitor_count;
		visitor_id = visitor_count;
	}
	
	private void connect() {
		try {
			ServerSocket serverSocket = 
				new ServerSocket(this.PORT); 
			
			while (true) {
				Socket clientSocket = serverSocket.accept();
				/*
				PrintWriter out = 
					new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream())
					);
				*/
				Thread newClient = new Thread(new clientListener(clientSocket));
				newClient.start();
				//System.out.println("New visitor!");
			}
		} catch (IOException e) {
			System.err.print("IOException caught: " + e.getMessage());
		}				
	}
	
	@Override
	public void run() {

		if (clientSocket != null) {
			String inputLine;
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream())
					);
				while ((inputLine = in.readLine()) != null) {
					if (inputLine.equals("visitor")) {
						out.println("You're the " + visitor_id + " visitor today");
					} else if (inputLine.equals("quit")) {
						break;
					} else {
						out.println("Echo: " + inputLine);
					}
					
					//System.out.println("New post received from client: " + inputLine);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
