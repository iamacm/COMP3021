package blog_system;
import java.util.ArrayList;

import blog_system.User;

public class Blog {
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
}
