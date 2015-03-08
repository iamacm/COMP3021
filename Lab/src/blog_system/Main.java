package blog_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import blog_system.FriendsPost;
import blog_system.User;


public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.lab3_main(args);

	}

	public String getInput() {
		String line = "";
		System.out.print("Enter the prompt: ");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	private static void lab2_main(String[] args) {
		User user = new User(1, "HELLO", "cmauaa@connect.ust.hk");
		Date date = new Date();
		String content = "This is my first post!";
		
		FriendsPost postFromFriend = new FriendsPost(date, content, user);
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));		
	}
	
	private static void lab3_main(String[] args) {
		Main main = new Main();
		User user = new User(1, "HELLO", "cmauaa@connect.ust.hk");
		Date date = new Date();
		Blog myblog = new Blog(user);
		String prompt = null;
		while (!(prompt = main.getInput()).equals("exit")) {
			String[] inputs = prompt.split(" ");
			
			if (prompt.startsWith("list")) {
				myblog.list();
			} else if (prompt.startsWith("post")) {
				String content = prompt.substring(5);
				Post post = new Post(content);
				myblog.post(post);
			} else if (prompt.startsWith("delete")) {
				String index_str = prompt.substring(7);
				int index = Integer.parseInt(index_str);
				myblog.delete(index);
			}
		}
	}
}