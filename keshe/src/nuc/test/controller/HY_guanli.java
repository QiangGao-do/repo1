package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.test.dao.UserDao;
import nuc.test.entity.User;

/**
 * Servlet implementation class HY_guanli
 */
@WebServlet("/HY_guanli")
public class HY_guanli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HY_guanli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
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
		out.println("  <HEAD><TITLE>用户管理</TITLE></HEAD>");
		try {
				   	UserDao dao=new UserDao();
				   	List<User> list=new ArrayList<User>();
				   	list=dao.Select();
				   	Iterator<User> listall=list.iterator();//迭代器
			   		out.print("<table border=1 align=center>");
				   	out.print("<caption>普通用户</caption>");
				   	out.print("<a href="+"YH_add"+">添加用户</a>");
					out.print("<tr>");
					out.print("<th>用户id</th>");
					out.print("<th>用户名</th>");
					out.print("<th>操作</th>");
					out.print("</tr>");

				   	while(listall.hasNext()){
				   		User user =listall.next();

					   	out.print("<tr>");
					   	out.print("<td>"+user.getuserID()+"</td>");
					   	out.print("<td>"+user.getuname()+"</td>");		
					   	out.print("<td><a href="+"YH_del?userID="+user.getuserID()+">删除用户</a>&nbsp;");
				   	}
				   	   
				   	 out.print("</table>");
				   	 
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<a href=guanliyuan.jsp> 返回 </a>	");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
