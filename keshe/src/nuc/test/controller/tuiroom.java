package nuc.test.controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nuc.test.dao.MeetDao;

/**
 * Servlet implementation class Stu_tuike
 */
@WebServlet("/tuiroom")
public class tuiroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tuiroom() {
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
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
  
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		try{
			HttpSession session=request.getSession();
			String userID=session.getAttribute("userID").toString();
			MeetDao dao=new MeetDao();
			String meetid=request.getParameter("meetid");
			int rs=dao.M_tuiroom(userID,meetid);
			if(rs!=0){
				out.println("取消预约成功");
				response.setHeader("refresh", "1;URL=yonghu.jsp");
			}
			else{
				out.println("取消预约失败");
				response.setHeader("refresh"," 1;URL=tuiroom.jsp");
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
