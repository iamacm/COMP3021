package ip_test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("The IP address of the host: " + InetAddress.getLocalHost()); 
	}
}
