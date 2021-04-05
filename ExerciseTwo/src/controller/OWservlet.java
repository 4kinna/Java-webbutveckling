package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetApiResponse;
import model.WeatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OWservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		WeatherBean wBean = new WeatherBean(cityStr, countryStr);
		//WeatherBean wBean = new WeatherBean("stockholm", "se");
		
		GetApiResponse.getWeather(wBean);

		request.setAttribute("wBean", wBean);		


		
		//create cookie
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String myCity = request.getParameter("city");
			
			//encode city incase of å,ä ö
			myCity = myCity.replace("[åä]", "a");
			String myCookie = myCity.replace("ö", "o"); 

			Cookie ck = new Cookie(myCookie, myCookie);// creating cookie object, första =namn på stringen, andra = innehållet (cookiename)
			response.addCookie(ck);
			

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);

	}

}