package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.test.dao.UserDao;
import nuc.test.entity.User;;

/**
 * Servlet implementation class DoYH_add
 */
@WebServlet("/AM_add")
public class AM_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AM_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session= request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		try{
		User user=new User();
		UserDao dao=new UserDao();
		user.setuserID(request.getParameter("userID").toString());
		user.setpassword(request.getParameter("upassword").toString());
		user.setuname(request.getParameter("uname").toString());
		int rs=dao.AM_add(user);
		if(rs!=0){
			out.println("添加成功");
			response.setHeader("refresh","2;URL=login.jsp");
		}
		else{
			out.println("添加失败");
			response.setHeader("refresh","2;URL=register.jsp");
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

	

}
