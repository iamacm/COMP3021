package lab2;
import java.util.Date;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User(1, "HELLO", "cmauaa@connect.ust.hk");
		Date date = new Date();
		String content = "This is my first post!";
		
		FriendsPost postFromFriend = new FriendsPost(date, content, user);
		System.out.println(postFromFriend);
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));
		
	}

}
