package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bean.PostBean;
import bean.UserBean;

public class SQLconnection {

	static Connection conn = null;
	static PreparedStatement statement = null;
	static ResultSet result = null;

	public static boolean connectSQL(String dbName) {

		try {
			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// handle the error
			System.out.println("Exception Driver: " + e);
			return false;
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javawebbutvecklingprojektdb_" + dbName + "?serverTimezone=UTC", "root",
					"");
			return true;

		} catch (SQLException e) {
			// handle any errors
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			return false;
		}

	}

	public static boolean validateUserSQL(UserBean bean) {

		// test a query
		try {
			String requestQuery = "SELECT user_name, password FROM javawebbutvecklingprojektdb_user WHERE user_name = ? and password = ?";

			statement = conn.prepareStatement(requestQuery);

			statement.setString(1, bean.getUsername());
			statement.setString(2, bean.getPassword());

			result = statement.executeQuery();
			// ResultSet return
			boolean valid=false;
			while (result.next()) {
				
				if (result.getString(1).equals(bean.getUsername()) && result.getString(2).equals(bean.getPassword())) {
					valid= true;
				} 

			}
			conn.endRequest();
			conn.close();
			
			return valid;
			
			// handle any errors
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());

		}
		return false;

	}

	// method to get post from DB
	public static ArrayList<PostBean> getPosts() {

		try {
			//teh query were testing to are DB
			String requestQuery = "SELECT title, content, creator, createdTime, hashtag FROM javawebbutvecklingprojektdb_posts";
			//created ArrayList to stor the posts we get out from database
			ArrayList<PostBean> posts = new ArrayList<>();

			statement = conn.prepareStatement(requestQuery);
			result = statement.executeQuery();

			//while loop how will provide us with posts aslong as there is any in the DB left
			while (result.next()) {

				// Create a new Bean with all the values
				PostBean postBean = new PostBean();
				postBean.setTitle(result.getString(1));
				postBean.setContent(result.getString(2));
				postBean.setCreator(result.getString(3));
				postBean.setCreatedTime(result.getDate(4).toString());
				postBean.setHashtag(result.getString(5));

				// add new postBeans to our arraylist
				posts.add(postBean);
			}
			conn.endRequest();
			conn.close();
			//returns arraylist
			return posts;
			
			// handle any errors
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return null;
	}

	// Method to set/send post to my DB
	public static ArrayList<PostBean> setPosts(PostBean postBean) {
		//create varibles and gets values from PostBean
		String title = postBean.getTitle();
		String content = postBean.getContent();
		String creator = postBean.getCreator();
		String createdTime = postBean.getCreatedTime();
		String hashtag = postBean.getHashtag();

		try {
			//our query 
			String requestQuery = "INSERT INTO javawebbutvecklingprojektdb_posts (title, content, creator, createdTime, hashtag) VALUES('"
					+ title + "','" + content + "','" + creator + "','" + createdTime + "','" + hashtag + "')";

			statement = conn.prepareStatement(requestQuery);
			int rowInsert = statement.executeUpdate();

			conn.endRequest();
			conn.close();
	
			// handle any errors
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}

		return null;
	}

}