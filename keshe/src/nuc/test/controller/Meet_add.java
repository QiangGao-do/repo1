package nuc.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nuc.test.dao.MeetDao;

/**
 * Servlet implementation class Meet_add
 */
@WebServlet("/Meet_add")
public class Meet_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Meet_add() {
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
		out.println("  <HEAD><TITLE>ѡ��</TITLE></HEAD>");
		out.println("  <BODY>");
		String seatingAmount=request.getParameter("seatingAmount").toString();
		String meetingRoomid=request.getParameter("meetingRoomid").toString();
		String setid=request.getParameter("setid").toString();
		
		try{
			MeetDao dao=new MeetDao();			
			ResultSet rs=dao.M_xuanze(meetingRoomid);
			out.print("<table border=1 align=center>");
			out.print("<caption>��������</caption>");
			out.print("<tr>");
			out.print("<th>�����</th>");
			out.print("<th>��ʼʱ��</th>");
			out.print("<th>����ʱ��</th>");
			out.print("</tr>");
			while(rs.next()){
				
				out.println("<tr><td>"+rs.getInt("meetid")+"</td>");
				out.println("<td>"+rs.getString("startDate")+"</td>");
				out.println("<td>"+rs.getString("endDate")+"</td></tr>"); 
				
			}
			out.print("</table>");
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		out.println("<table border=1 align=center>");
		out.print("<caption>����ʱ��</caption>");
		out.println("<form action="+"ME_add"+" method=post>");
		out.println("<tr><td>�����ұ��:</td><td><input type=text name=meetingRoomid value="+meetingRoomid+" readonly=readonly>����ɱ��༭ </td></tr>");
		out.println("<tr><td>�豸���:</td><td><input type=text name=setid value="+setid+" readonly=readonly>����ɱ��༭ </td></tr>");
		out.println("<tr><td>�μ�����:</td><td><input type=text name=seatingAmount value="+seatingAmount+" readonly=readonly>����ɱ��༭ </td></tr>");
		out.println("<tr><td>��ʼʱ��:</td><td><input type=date name=startDate1 > </td><td><input type=time name=startDate2 > </td></tr>");
		out.println("<tr><td>����ʱ��:</td><td><input type=date name=endDate1 ></td><td><input type=time name=endDate2 ></td></tr>");
		out.println("<tr><td colspan=2><input type=submit value=�ύ><input type=reset  value=����> ");
		out.println("</form>");
		out.println("</table>");
		out.println("<tr><a href=xuanroom.jsp>����</a></tr>");
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
