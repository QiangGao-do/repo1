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

import nuc.test.dao.SetDao;
import nuc.test.entity.seting;

/**
 * Servlet implementation class S_guanli
 */
@WebServlet("/S_guanli")
public class S_guanli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_guanli() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>设备管理</TITLE></HEAD>");
		try {
					SetDao dao=new SetDao();
				   	List<seting> list=new ArrayList<seting>();
				   	list=dao.S_qinfo();
				   	Iterator<seting> listall=list.iterator();//迭代器
			   		out.print("<table border=1 align=center>");
				   	out.print("<caption>设备信息</caption>");
				   	out.print("<a href="+"S_add"+">添加设备</a>");
					out.print("<tr>");
					out.print("<th>设备编号</th>");
					out.print("<th>设备名</th>");
					out.print("<th>操作</th>");
					out.print("</tr>");

				   	while(listall.hasNext()){
				   		seting set =listall.next();

					   	out.print("<tr>");
					   	out.print("<td>"+set.getsetid()+"</td>");
					   	out.print("<td>"+set.getsetname()+"</td>");	
						out.print("<td><a href="+"S_del?setid="+set.getsetid()+">删除</a>&nbsp;");
					   	out.print("</tr>");
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
