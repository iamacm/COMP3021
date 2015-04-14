package blog_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class BlogGUI {
	private JFrame mainFrame;
	private JPanel subFrame;
	
	private JLabel textTips;
	private JTextArea textArea;
	private final int textAreaLimit = 140;
	private JPanel buttonsArea;
	private JButton refreshButton;
	private JButton postButton;
	private JTextArea postsArea;
	private Blog myBlog;
	private String blogFile = "blog.txt";
	
	public BlogGUI() {
		// Init blog
		myBlog = new Blog(null);
	}
	
	public BlogGUI setWindow() {
		return this.setWindow("Blog");
	}
	
	public BlogGUI setWindow(String title) {
		/** MainFrame config begins **/
		this.mainFrame = new JFrame(title);
		this.mainFrame.setSize(400, 400);
		//this.mainFrame.setResizable(false);
		this.mainFrame.setLayout(new GridLayout(2, 1));  // 2 rows * 1 column
		
		/** SubFrame config begins **/
		this.subFrame = new JPanel();
		this.subFrame.setLayout(new BorderLayout(0, 0));
		this.subFrame.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(5,5,0,5), 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)
				));
		
		/** TextTips config begins  **/
		this.textTips = new JLabel();
		this.textTips.setVisible(true);
		this.subFrame.add(this.textTips, BorderLayout.NORTH);
		/** TextTips config ends  **/
		
		/** TextArea config begins  **/
		this.textArea = new JTextArea();
		this.textArea.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));	// Border
		this.textArea.setBackground(new Color(255, 255, 220));	// Light yellow background
		this.textArea.setLineWrap(true);	// Prevent text overflow
		this.textArea.setVisible(true);
		this.textArea.addKeyListener(new textAreaKeyListener());
		this.subFrame.add(this.textArea, BorderLayout.CENTER);
		/** TextTips config ends  **/
		
		/** ButtonsArea config begins **/
		this.buttonsArea = new JPanel();
		this.buttonsArea.setLayout(new GridLayout(1, 2)); // 2 columns
		
		/** PostButton config begins **/
		this.refreshButton = new JButton("Refresh");
		this.refreshButton.setBackground(new Color(180, 255, 180));
		this.refreshButton.setVisible(true);
		this.refreshButton.addActionListener(new refreshListener());
		this.buttonsArea.add(this.refreshButton);
		/** PostButton config ends **/
		
		/** RefreshButton config begins **/
		this.postButton = new JButton("Post");
		this.postButton.setBackground(new Color(255, 180, 255));
		this.postButton.setVisible(true);
		this.postButton.addActionListener(new postListener());
		this.buttonsArea.add(this.postButton);
		/** RefreshButton config ends **/
		
		
		this.buttonsArea.setVisible(true);
		this.subFrame.add(this.buttonsArea, BorderLayout.SOUTH);
		/** ButtonsArea config ends **/
		
		this.subFrame.setVisible(true);
		this.mainFrame.add(this.subFrame);
		/** SubFrame config ends **/
		
		/** PostsArea config begins **/
		this.postsArea = new JTextArea("Post Area");
		this.postsArea.setEditable(false);	// Not editable
		//this.postsArea.setHorizontalAlignment(JTextField.CENTER);
		this.postsArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(0,5,5,5), 
				BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)
				));
		this.postsArea.setLineWrap(true);
		this.postsArea.setVisible(true);
		this.mainFrame.add(this.postsArea);
		/** PostsArea config ends **/
		
		this.mainFrame.setVisible(true); 
		/** MainFrame config ends **/
		
		
		
		this.textAreaCheck(); 
		
		return this;
		
	}
	
	private void refresh() {
		this.postsArea.setText("Refreshed!");
		textAreaCheck();
	}
	
	
	private int textAreaCheck() {
		int char_available = this.textAreaLimit - this.textArea.getText().length();
		float char_available_percentage = (float) char_available / this.textAreaLimit;
		if (char_available > 0) {
			this.textTips.setText("You can still input " + char_available + " characters.");
			this.textTips.setForeground(new Color((int) ((1-char_available_percentage) * 225), (int) (char_available_percentage * 160), 0));
		} else {
			this.textTips.setText("Text full!");
			this.textTips.setForeground(new Color(225, 0, 0));
			//this.textArea.setEditable(false);
			//this.textArea.setText(this.previous_text);
			this.textArea.setText(this.textArea.getText().substring(0, this.textAreaLimit));
		}
		return char_available;
	}
	
	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.refreshButton) {
			this.refresh();
		} else if (e.getSource() == this.postButton) {
			this.post();
		}
	}
	*/
	
	private class postListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String content = textArea.getText();
			if (content.length() <= textAreaLimit) {
				postsArea.setText("New post: " + content);
				myBlog.post(new Post(content));
				myBlog.save(blogFile);
			}
			
		}
		
	}
	
	private class refreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			myBlog.load(blogFile);
			postsArea.setText(myBlog.toString());
		}
		
	}
	
	private class textAreaKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			textAreaCheck(); 
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			textAreaCheck();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			textAreaCheck();
		}
		
	}

}
