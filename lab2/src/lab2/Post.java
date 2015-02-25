package lab2;
import java.util.Date;

public class Post {
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
		// TODO
		boolean ans = true;
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		
		if (o.getClass() == this.getClass()) {
			Post post = (Post) o;
			if (!post.getContent().equals(this.getContent())) {
				ans = false;
			}
			if (!post.date.equals(this.date)) {
				ans = false;
			}
			
		}
		return ans;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 0;
		date.hashCode();
		content.hashCode();
		
		return hashCode;
	}
	
	public boolean contains(String str) {
		if (str == null || this.content == null) {
			return false;
		} else {
			return this.content.contains(str);
		}
	}
}
