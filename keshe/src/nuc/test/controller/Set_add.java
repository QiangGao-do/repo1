package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Set_add")
public class Set_add extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public Set_add() {
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
	 *
	
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String meetingRoomid=request.getParameter("meetingRoomid").toString();
				out.println("<table>");
				out.println("<form action="+"DoSet_add"+" method=post>");
				out.println("<tr><td>会议室编号:</td><td><input type=text name=meetingRoomid value="+meetingRoomid+" readonly=readonly>此项不可被编辑 </td></tr>");
				out.println("<tr><td>设备id:</td><td><input type=text name=setid > </td></tr>");
				
				out.println("<tr><td colspan=2><input type=submit value=提交>");
				out.println("<input type=button name=submit value=返回 onclick=javascript:history.back(-1)></td></tr>");
				out.println("</form>");
//				out.print("<a href=set_guanli> 返回 </a>");
				out.println("</table>");
			
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
