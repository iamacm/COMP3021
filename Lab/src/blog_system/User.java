package blog_system;

public class User {
	private int id;
	private String username;
	private String email;
	
	public User(int id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}
	
	
	public int get_id() {
		return this.id;
	}
	
	public String get_username() {
		return this.username;
	}
	
	public String get_email() {
		return this.email;
	}
	
}
