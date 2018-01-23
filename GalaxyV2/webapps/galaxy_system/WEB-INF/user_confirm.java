import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class user_confirm extends HttpServlet {

    private DBConnection dbCon;
	private ShowToday sty;
	private long logid;
    private String sUser;
    private String sPass;
	private String sCheck;
	private boolean flag;
	private int target = 0;
	
	private int y;
	private int m;
	private int d;
	private int h;
	private int mi;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
	request.setCharacterEncoding("MS932");
	response.setContentType("text/html;charset=MS932");
	
	sty = new ShowToday();
	y = sty.nowY;
	m = sty.nowMO;
	d = sty.nowD;
	h = sty.nowH;
	mi = sty.nowMI;
	try{
	    //get username and password from user
	    sUser = request.getParameter("galaxyid");
	    sPass = request.getParameter("pass");
		sCheck = request.getParameter("passwordsave");
		// System.out.println("cookie : " + sCheck);
		
		String sUserC = URLEncoder.encode(sUser,"Shift_JIS");;
		String sUserP = URLEncoder.encode(sPass,"Shift_JIS");;
		if(sCheck != null && sCheck.equals("1")){
			Cookie cookie = new Cookie("galaxy_id",sUserC);
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
		    cookie = new Cookie("galaxy_pass",sUserP);
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
			// System.out.println("Cookie Save");
		}else{
			Cookie cookie = new Cookie("galaxy_id",sUserC);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			cookie = new Cookie("galaxy_pass",sUserP);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			// System.out.println("Cookie Del");
		}
		
	    //to get the next user id
		String admin;
		String mode;
	    String sSQL = "SELECT user_mode,user_mail,user_group,user_number,galaxy_admin, user_country, user_graph, user_mark1_c, user_mark1,"
		              + " user_mark2_c, user_mark2, user_mark3_c, user_mark3, user_bg_c "
		              + " FROM regist_table " + " WHERE galaxy_id = '" + sUser + "' AND user_pass = PASSWORD('" + sPass + "')";
		// System.out.println("SQL:" + sSQL);

	    dbCon = new DBConnection();
	    ResultSet rs = dbCon.executeQuery(sSQL);
	    if(rs.next()){
		    HttpSession session = request.getSession(true);
		    session.setAttribute("n_id",rs.getString("user_number"));
		    session.setAttribute("galaxy_id",sUser);
		    session.setAttribute("group",rs.getString("user_group"));
			session.setAttribute("mail",rs.getString("user_mail"));
			session.setAttribute("mode",rs.getString("user_mode"));
			
			session.setAttribute("country",rs.getString("user_country"));
			session.setAttribute("graph",rs.getString("user_graph"));
			session.setAttribute("mark1c",rs.getString("user_mark1_c"));
			session.setAttribute("mark1",rs.getString("user_mark1"));
			session.setAttribute("mark2c",rs.getString("user_mark2_c"));
			session.setAttribute("mark2",rs.getString("user_mark2"));
			session.setAttribute("mark3c",rs.getString("user_mark3_c"));
			session.setAttribute("mark3",rs.getString("user_mark3"));
			session.setAttribute("bg",rs.getString("user_bg_c"));
			
			session.setAttribute("admin",rs.getString("galaxy_admin"));
			session.setAttribute("galaxy","authority");
			mode = rs.getString("user_mode");
			admin = rs.getString("galaxy_admin");
		
			if(admin.equals("n")){
				flag = insertToDatabase("USER_LOGIN");
				response.sendRedirect("galaxy.jsp");
			}else if(admin.equals("y")){
				flag = insertToDatabase("ADMIN_LOGIN");
		    	response.sendRedirect("galaxy_admin.jsp");
			}
		}else{
			flag = insertToDatabase("Wrong : login");
		    System.out.println("Wrong Username Password ");
		    response.sendRedirect("login.jsp");
		}
		
	}catch(Exception e){
	    System.out.println("Exception occoured " +e);

	}
	
    }//doGet ends here

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		doGet(request,response);
    }//end of doPost
	
	public boolean insertToDatabase(String comment) throws Exception{
		try{
			
			String sSQL  = "select max(login_id) from login_log;";
			ResultSet rs = dbCon.executeQuery(sSQL);
			if(rs.isBeforeFirst()){
				if(rs.next()){
					logid = rs.getLong(1) + 1;
				}else{
					logid = 1;
				}
			}
			
	    	String sInsertSQL = "INSERT INTO login_log VALUES(" + logid + ",'" + sUser + "','" + comment + "','"+ y + "/" + m + "/" + d + "','" + h + ":" + mi +"');";
			dbCon.beginTrans();
	    	int i = dbCon.executeUpdate(sInsertSQL);
	    	dbCon.endTrans();

	    	if(i>0)
				return true;
            else
        		return false;
	   	}catch(Exception e){
		    System.out.println("Error" +e);
	    	dbCon.rollbackTrans();
	    	throw e;
	   	}
    }

}

