package blog_system;
import java.io.Serializable;
import java.util.Date;

import blog_system.Post;

public class Post implements Comparable<Post>, Serializable{
	private Date date;
	private String content;
	
	/**
	 *	Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content) {
		// TODO
		this.date = date;
		this.content = content;
	}
	
	public Post(String content) {
		this.date = new Date();
		this.content = content;
	}
	
	/**
	 * @return the content of the blog
	 */
	public String getContent() {
		// TODO
		return this.content;
	}
	
	/**
	 * @param content
	 */
	public void setContent(String content) {
		// TODO
		this.content = content;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		String output;
		output = this.date.toString() + "\n";
		output += this.content;
		return output;
	}
	
	@Override
	/**
	 * Check if two objects are equal
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null) {
			return false;
		} else if (o.getClass() == this.getClass()) {
			Post post = (Post) o;
			return post.getContent().equals(this.getContent()) && post.date.equals(this.date);
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int hashCode = 37;
		hashCode += 11 * date.hashCode();
		hashCode += 79 * content.hashCode();
		
		return hashCode;
	}
	
	@Override
	public int compareTo(Post p) {
		return this.getDate().compareTo(p.getDate());
	}
	
	public boolean contains(String str) {
		if (str == null || this.content == null) {
			return false;
		} else {
			return this.content.contains(str);
		}
	}
}
