package bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import database.SQLconnection;

//UserBean is a access modelclass,  holds and communicate data about users

public class PostBean {
	private String title, content, creator, hashtag, createdTime;
	private int postID;

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	//check if we can connect to DB
	public ArrayList<PostBean> getPosts() {

		//make us connect to database that has the name "posts"
		if (SQLconnection.connectSQL("posts")) {
			return SQLconnection.getPosts();
		}

		return null;
	}
	
	//method to set current time
	public void addNewTime() {
		this.createdTime = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	}

	// method to reach my SQLconnection and create the post (from postController)
	public void createPost(PostBean postBean) {
		if(SQLconnection.connectSQL("posts")) {
			SQLconnection.setPosts(postBean);
		}
	}
}
