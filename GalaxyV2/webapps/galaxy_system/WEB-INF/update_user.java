import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class update_user extends HttpServlet {

    private DBConnection dbCon;
	private String galid;
    private String user;
    private String pass1;
	private String pass2;
	private String sei;
	private String mei;
	private String country = "JP";
	private String zip;
	private String sex;
	private String syozoku;
	private String email;
	private String mode;
	private String type;
	private String markc1;
	private String mark1;
	private String markc2;
	private String mark2;
	private String markc3;
	private String mark3;
	private String back;
	private String admin;
	
	private boolean flag;
	private int target = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("MS932");
		response.setContentType("text/html;charset=MS932");
		HttpSession session = request.getSession();
		try{
			galid = (String)session.getAttribute("n_id");
			admin = (String)session.getAttribute("admin");
	    	user = request.getParameter("galaxyid");
	    	pass1 = request.getParameter("pass1");
			pass2 = request.getParameter("pass2");
			sei = request.getParameter("sei");
			mei = request.getParameter("mei");
			zip = request.getParameter("zip");
			sex = request.getParameter("sex");
			syozoku = request.getParameter("syozoku");
			email = request.getParameter("email");
			mode = request.getParameter("mode");
			type = request.getParameter("type");
			markc1 = request.getParameter("markc1");
			mark1 = request.getParameter("mark1");
			markc2 = request.getParameter("markc2");
			mark2 = request.getParameter("mark2");
			markc3 = request.getParameter("markc3");
			mark3 = request.getParameter("mark3");
			back = request.getParameter("back");
			
			flag = true;
			if(pass1.equals("") || pass1.length() < 6){
				response.sendRedirect("../update.jsp?Pass1Error");
				flag = false;
			}
			if(!pass1.equals(pass2)){
				response.sendRedirect("../update.jsp?Pass12Error");
				flag = false;
			}
			if(flag){
	    		dbCon = new DBConnection();
				boolean upFlag = updateToDatabase();
				if(upFlag == true){
					if(admin.equals("n")){
						response.sendRedirect("../galaxy.jsp");
					}else if(admin.equals("y")){
		    			response.sendRedirect("../galaxy_admin.jsp");
					}
				}else{
		    		response.sendRedirect("../login.jsp?updateError");
				}
			}
		}catch(Exception e){
	    	System.out.println("Exception occoured " +e);
		}
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
    }
	
	public boolean updateToDatabase() throws Exception{
		try{
			// String updateSQL = "UPDATE regist_table SET xxx = '" + + "' WHERE yyy = "" and ;";
			String updateSQL = "UPDATE regist_table SET user_first = '" + mei + "', user_last= '" + sei + "', user_country = '" + country 
			                   + "', user_zip = '" + zip + "', user_group = '" + syozoku + "', user_sex = '" + sex +  "', user_mail = '" + email
							   + "', user_mode = '" + mode + "', user_pass = PASSWORD('" + pass1 + "'), user_graph = '" + type
							   + "', user_mark1_c = '" + markc1 + "', user_mark1 = '" + mark1 + "', user_mark2_c = '" + markc2 + "', user_mark2 = '" + mark2
							   + "', user_mark3_c = '" + markc3 + "', user_mark3 = '" + mark3 + "', user_bg_c = '" + back
							   + "' WHERE user_number = " + galid + " and galaxy_id = '" + user + "';";
			// System.out.println(updateSQL);
			dbCon.beginTrans();
			int i = dbCon.executeUpdate(updateSQL);
			dbCon.endTrans();
			if(i>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println("ERROR update_user " + e);
			dbCon.rollbackTrans();
			throw e;
		}
	}
}

