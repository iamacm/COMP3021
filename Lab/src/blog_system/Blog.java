package blog_system;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

import blog_system.User;


public class Blog implements Serializable {
	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * @brief Constructor
	 * @param user
	 */
	public Blog(User user) {
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	/**
	 * @brief Set the user of the blog
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * @brief Get the current user
	 * @return
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * @brief Create a new post in the blog
	 * @param p
	 */
	public void post(Post p) {
		this.allPosts.add(p);
		System.out.println("A new post: ");
		System.out.println(p);
	}
	
	/**
	 * @brief List all posts in the blog.
	 */
	public void list() {
		System.out.print(this);
	}
	
	/**
	 * @brief Dete a post from the blog
	 * @param index
	 */
	public void delete(int index) {
		index -= 1;
		if (index >= 0 && index < allPosts.size()) {
			allPosts.remove(index);
		} else {
			System.out.println("Illegal deletion!");
		}
	}
	
	public void setPosts(ArrayList<Post> allPosts) {
		this.allPosts = allPosts;
	}
	@Override
	public String toString() {
		String output = "";
		int i = 0;
		for (final Post p: allPosts) {
			++i;
			output += "Post[" + i + "]:" + p + "\n";
		}
		return output;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.getClass() != o.getClass()) {
			return false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	public void search(int month, String someone) {
		Calendar cal = Calendar.getInstance();
		for (Post p: this.allPosts) {
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH) + 1;
			if (postMonth == month) {
				if (p.getContent().indexOf("@" + someone) != -1) {
					System.out.println(p);
				}
			}
		}
	}
	
	public void save(String filepath) {
		try {
			FileOutputStream fout = new FileOutputStream(filepath);
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(this);
			oout.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void load(String filepath) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
			Blog tmp_blog = (Blog) ois.readObject();
			this.user = tmp_blog.user;
			this.allPosts = tmp_blog.allPosts;
			
		} catch (Exception ex) {
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
	}
}
