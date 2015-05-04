package lab9_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Lab9_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (
				Socket echoSocket = new Socket("127.0.0.1", 3021);
				PrintWriter out =
					new PrintWriter(echoSocket.getOutputStream(), true);
				BufferedReader in = 
					new BufferedReader(
						new InputStreamReader(echoSocket.getInputStream()));
				BufferedReader stdIn = 
					new BufferedReader(
						new InputStreamReader(System.in));
				
			) {
				System.out.println("Socket opened...");
				String stdInput;
				String inputLine;
				while ((stdInput = stdIn.readLine()) != null) {
					out.println(stdInput);
					if (stdInput.equals("quit")) {
						break;
					}
					System.out.println(in.readLine());
				}
				
				
			} catch (IOException e) {
				System.err.print("IOException caught: " + e.getMessage());
			} 
	}

}
