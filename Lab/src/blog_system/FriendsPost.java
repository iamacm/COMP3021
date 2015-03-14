package blog_system;

import java.util.Date;

public class FriendsPost extends Post{
	private User friend;
	

	public FriendsPost(Date date, String content) {
		super(date, content);
	}
	
	public FriendsPost(Date date, String content, User u) {
		super(date, content);
		this.friend = u;
		
	}
	
	@Override
	public String toString() {
		String output;
		output = "User [userId="+friend.get_id()+", userName="+friend.getUserName()+", userEmail="+friend.get_email()+"]\n";
		output += super.toString();
		return output;
	}	
}
