package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nuc.test.entity.User;

import nuc.test.dao.UserDao;
@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID =1L;

	/**
	 * Constructor of the object.
	 */
	public Login() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	         this.doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>登录</TITLE></HEAD>");
		out.println("  <BODY>");
		try{
			 HttpSession session =request.getSession();
			 String type=request.getParameter("type");
			 if(type.equals("0")){
				 User user=new User();
				 UserDao dao=new UserDao();
				 user.setuserID(request.getParameter("username"));
				 user.setpassword(request.getParameter("password"));
				 user.setutype("0");
				 User user1=dao.User_login(user);
				 if(user1.getuserID()!=null){
					 session.setAttribute("userID", user1.getuserID());
					 out.println("欢迎您"+user1.getuname()+"用户，即将进入会议室管理界面");
					 response.setHeader("refresh", "1;URL=yonghu.jsp");
					  
				 }
				 else{
					out.println("账号或密码输入错误，请重新输入");
				     response.setHeader("refresh", "1;URL=login.jsp");
					 
				 }
			 }
			 else if(type.equals("1")){
				 User user=new User();
				 UserDao dao=new UserDao();
				 user.setuserID(request.getParameter("username"));
				 user.setpassword(request.getParameter("password"));
				 user.setutype("1");
				 User user1=dao.User_login(user);
				 if(user1.getuserID()!=null){
					 session.setAttribute("userID", user1.getuserID());
					 out.println("欢迎您"+user1.getuname()+"管理员，即将进入会议室管理界面");
					 response.setHeader("refresh", "1;URL=guanliyuan.jsp");
					  
				 }
				 else{
					 out.println("账号或密码输入错误，请重新输入");
				     response.setHeader("refresh", "1;URL=login.jsp");
					 //request.getRequestDispatcher("login.jsp").forward(request, response);
				 }
			 }
		}
		catch(Exception e){
			System.out.println(e);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
