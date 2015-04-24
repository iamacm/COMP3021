package blog_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Network {
	public static final String IP = "192.168.0.100";
	public static final int PORT = 3021;
	
	public static class BlogServer {
		public static void connect(BlogGUI blogGui) throws IOException 
		{
			try (
				ServerSocket serverSocket = 
					new ServerSocket(Network.PORT); 
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = 
					new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream())
					);
			) {
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println("Received " + inputLine);
					System.out.println("New post received from client: " + inputLine);
					if (blogGui != null) {
						blogGui.post(inputLine);
					}
				}
			} catch (IOException e) {
				System.err.print("IOException caught: " + e.getMessage());
			}
		}
	}
	
	
	public static class Client {
		
		public static void connect() throws UnknownHostException, IOException {
			try (
				Socket echoSocket = new Socket(IP, PORT);
				PrintWriter out =
					new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = 
					new BufferedReader(
						new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = 
					new BufferedReader(
						new InputStreamReader(System.in));
				
			) {
				System.out.println("Socket opened, please enter post: ");
				String stdInput;
				while ((stdInput = stdIn.readLine()) != null) {
					out.println(stdInput);
				}
			} catch (IOException e) {
				System.err.print("IOException caught: " + e.getMessage());
			} 
		}
	}
}
