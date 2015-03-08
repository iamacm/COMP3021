package blog_system;

import java.util.Comparator;

public class PostSortByContentLength implements Comparator<Post>{
	@Override
	public int compare(Post p1, Post p2) {
		int p1_length = p1.getContent().length();
		int p2_length = p2.getContent().length();
		
		if (p1_length > p2_length) {
			return 1;
		} else if (p1_length < p2_length) {
			return -1;
		} else {
			return 0;
		}
	}
}
