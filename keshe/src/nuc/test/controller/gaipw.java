package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nuc.test.dao.UserDao;

/**
 * Servlet implementation class gaipw
 */
@WebServlet("/gaipw")
public class gaipw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gaipw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session =request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>修改密码</TITLE></HEAD>");
		out.println("  <BODY>");
		try{
			UserDao dao=new UserDao();
			String userID=session.getAttribute("userID").toString();
			String password=request.getParameter("upassword").toString();
			dao.PW_xiugai(userID,password);
			out.println("修改成功");
			response.setHeader("refresh","1;URL=login.jsp");
			}
			catch(Exception e){
				System.out.println(e);
			}
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
	}
}
