package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PostBean;
import bean.UserBean;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create a PostBean
		PostBean postBean = new PostBean();

		// Create a ArrayList of datatype PostBean and sets it value to the method
		// getPost() from PostBean
		// the method checks if we can connect to the DB and returns the posts in the DB
		ArrayList<PostBean> myArrayList = postBean.getPosts();

		// stores the attribute to this request
		request.setAttribute("posts", myArrayList);

		// redirect and takes the values with it to wall.jsp
		RequestDispatcher rd = request.getRequestDispatcher("wall.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// get the input from the post form thru the parameters and sets to variables
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String hashtag = request.getParameter("hashtag");
		// creates a UserBean to reach the user
		UserBean user = (UserBean) request.getSession().getAttribute("user");

		// create a new postbean
		PostBean postBean = new PostBean();
		// adds current date thru using our method addNewTime in PostBean
		postBean.addNewTime();
		// sets the title
		postBean.setTitle(title);
		// sets the usernamne
		postBean.setCreator(user.getUsername());
		// sets content
		postBean.setContent(content);
		// sets the hashtag
		postBean.setHashtag(hashtag);

		// creates and sends the post we created to the method createPost in postBean,
		// and inserted to DB by another method in SQLconnection
		postBean.createPost(postBean);

		//Call doGet() after new post are created to reload the posts and redirect me to wall.jsp
		doGet(request, response);

	}

}
