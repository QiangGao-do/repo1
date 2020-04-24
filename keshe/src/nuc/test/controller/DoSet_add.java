package nuc.test.controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.test.dao.MSDao;
import nuc.test.entity.meetset;

/**
 * Servlet implementation class DoCou_add
 */
@WebServlet("/DoSet_add")
public class DoSet_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSet_add() {
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
		meetset mset=new meetset();
		MSDao dao=new MSDao();
		mset.setsetid(request.getParameter("setid").toString());
		mset.setmeetingRoomid(request.getParameter("meetingRoomid").toString());
		int rs=dao.DoSet_add(mset);
		if(rs!=0){
			out.println("添加成功");
			response.setHeader("refresh","1;URL=MR_guanli");
		}
		else{
			out.println("添加失败");
			response.setHeader("refresh","1;URL=MR_guanli");
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
