package lab8_server;

import java.io.IOException;
import java.net.UnknownHostException;

import blog_system.BlogGUI;
import blog_system.Network;

public class Lab8_Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow("Blog windows"); 
		Network.BlogServer.connect(blogGUI); 
		

	}

}
