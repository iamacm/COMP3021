package blog_system;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
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
	
	public String getUserName() {
		return this.username;
	}
	
	public String get_email() {
		return this.email;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null) {
			return false;
		} else if (o.getClass() == this.getClass()) {
			User u = (User) o;
			return this.id == u.get_id() && this.username.equals(u.getUserName()) && this.email.equals(u.get_email());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "User [userId="+this.get_id()+", userName="+this.getUserName()+", userEmail="+this.get_email()+"]";
	}
	
	@Override
	public int hashCode() {
		int hashCode = 7;
		hashCode += this.id * 17;
		hashCode += this.username.hashCode() * 31;
		hashCode += this.email.hashCode() * 59;
		return hashCode;
	}
	
	@Override
	public int compareTo(User u) {
		if (this.get_id() > u.get_id()) {
			return 1;
		} else if (this.get_id() < u.get_id()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
