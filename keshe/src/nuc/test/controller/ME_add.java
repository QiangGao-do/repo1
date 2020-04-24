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
import nuc.test.entity.meeting;

/**
 * Servlet implementation class ME_add
 */
@WebServlet("/ME_add")
public class ME_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ME_add() {
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
        HttpSession session=request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>！选择会议室！</TITLE></HEAD>");
		out.println("  <BODY>");
		try{
			MeetDao dao=new MeetDao();

			String userID=session.getAttribute("userID").toString();
			String meetingRoomid=request.getParameter("meetingRoomid").toString();
			String setid=request.getParameter("setid").toString();
			String partNumber=request.getParameter("seatingAmount").toString();
			String startDate=request.getParameter("startDate1").toString()+" "+request.getParameter("startDate2").toString();
			String endDate=request.getParameter("endDate1").toString()+" "+request.getParameter("endDate2").toString();
			meeting meet=new meeting();
			meet.setUserID(userID);
			meet.setMeetingRoomid(meetingRoomid);
			meet.setSetid(setid);
			meet.setPartNumber(partNumber);
			meet.setStartDate(startDate);
			meet.setEndDate(endDate);
			meeting mee1=dao.ME_pan1(meet);
			meeting mee2=dao.ME_pan2(meet);
			if(mee1.getMeetingRoomid()==null) {
				if(mee2.getMeetingRoomid()==null) 
				{
						int rs=dao.Me_add(userID, meetingRoomid,setid,partNumber,startDate,endDate);
						if(rs!=0){
							out.println("添加成功");
							response.setHeader("refresh", "1;URL=yonghu.jsp");
						}
						else{
							out.println("添加失败");
							response.setHeader("refresh"," 1;URL=yonghu.jsp");
						}
				}
				else {
					out.println("添加失败");
					response.setHeader("refresh"," 1;URL=yonghu.jsp");
				}
			}
			else{
				out.println("添加失败");
				response.setHeader("refresh"," 1;URL=yonghu.jsp");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
