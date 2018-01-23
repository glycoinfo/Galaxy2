import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class user_regist extends HttpServlet {

    private DBConnection dbCon;
	private ShowToday sty;
	private long logid;
	private long galid;
	private String galaxyid;
	private String pass1;
	private String pass2;
	private String sei;
	private String mei;
	private String country = "JP";
	private String zip;
	private String sex;
	private String syozoku;
	private String email;
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
	    galaxyid = request.getParameter("galaxyid");
	    pass1 = request.getParameter("pass1");
		pass2 = request.getParameter("pass2");
		sei = request.getParameter("sei");
		mei = request.getParameter("mei");
		zip = request.getParameter("zip");
		sex = request.getParameter("sex");
		syozoku = request.getParameter("syozoku");
		email = request.getParameter("email");
		
		flag = true;
		if(galaxyid.equals("") || galaxyid.length() < 6){
			response.sendRedirect("../regist.html?GalaxIDerror1");
			flag = false;
		}
		
		if(pass1.equals("") || pass1.length() < 6){
			response.sendRedirect("../regist.html?Pass1Error");
			flag = false;
		}
		
		if(!pass1.equals(pass2)){
			response.sendRedirect("../regist.html?Pass12Error");
			flag = false;
		}
		
		if(selectToDatabaseGalaxyId(galaxyid) == true){
			response.sendRedirect("../regist.html?GalaxIDError2");
			flag = false;
		}
		if(flag){
			galid = selectToDatabaseId();
	    	//to get the next user id
			String admin = "n";
			String mode = "HPLC";
			String graph = "o-a";
			String mark1c = "black";
			String mark1 = "Mark1";
			String mark2c = "red";
			String mark2 = "Mark2";
			String mark3c = "blue";
			String mark3 = "Mark3";
			String bg = "white";
	    	String SQL = "INSERT INTO regist_table VALUES(" + galid + ",'" + galaxyid + "','" + mei + "','" + sei + "','" + country + "','"
		    	       + zip + "','" + syozoku + "','" + sex + "','" + email + "','" + mode + "',PASSWORD('" + pass1 + "'),'" + admin + "','"
					   + graph + "','" + mark1c + "','" + mark1 + "','" + mark2c + "','" + mark2 + "','" + mark3c + "','" + mark3 + "','" + bg + "');";
 			// System.out.println("SQL:" + SQL);

	    	dbCon = new DBConnection();
			if(flag = insertToDatabase(SQL)){
				flag = insertToDatabaseLog("USER_REGIST");
				response.sendRedirect("../login.jsp?regist_ok");
			}else{
				response.sendRedirect("../regist.html?MainError");
			}
		}
	}catch(Exception e){
	    System.out.println("Exception occoured " +e);

	}
	
    }//doGet ends here

    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		doGet(request,response);
    }//end of doPost
	
	public long selectToDatabaseId() throws Exception{
		long id = 0;
		try{
			String sSQL = "select max(user_number) from regist_table";
			ResultSet rs = dbCon.executeQuery(sSQL);
			if(rs.isBeforeFirst()){
				if(rs.next()){
					id = rs.getLong(1)+1;
				}else{
					id = 1;
				}
			}
			return id;
			
		}catch(Exception e){
			System.out.println("Error user_regist(1) " + e);
			dbCon.rollbackTrans();
			throw e;
		}
	}
	
	public boolean selectToDatabaseGalaxyId(String sGal) throws Exception{
		boolean check;
		try{
			String sSQL = "select galaxy_id from regist_table where galaxy_id = '" + sGal + "';";
			ResultSet rs = dbCon.executeQuery(sSQL);
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println("Error user_regist(2) " + e);
			dbCon.rollbackTrans();
			throw e;
		}
	}
	
	public boolean insertToDatabase(String SQL) throws Exception{
		try{
			dbCon.beginTrans();
			int i = dbCon.executeUpdate(SQL);
			dbCon.endTrans();
			
			if(i>0)
				return true;
			else
				return false;
		}catch(Exception e){
			System.out.println("Error user_regist(3) " + e);
			dbCon.rollbackTrans();
			throw e;
		}
	}
	
	public boolean insertToDatabaseLog(String comment) throws Exception{
		try{
			
			String sSQL  = "select max(login_id) from login_log;";
			ResultSet rs = dbCon.executeQuery(sSQL);
			if(rs.isBeforeFirst()){
				if(rs.next()){
					logid = rs.getLong(1)+1;
				}else{
					logid = 1;
				}
			}
			
	    	String sInsertSQL = "INSERT INTO login_log VALUES(" + logid + ",'" + galaxyid + "','" + comment + "','"+ y + "/" + m + "/" + d + "','" + h + ":" + mi +"');";
	    	dbCon.beginTrans();
	    	int i = dbCon.executeUpdate(sInsertSQL);
	    	dbCon.endTrans();

	    	if(i>0)
				return true;
            else
        		return false;
	   	}catch(Exception e){
		    System.out.println("Error user_regist(4) " +e);
	    	dbCon.rollbackTrans();
	    	throw e;
	   	}
    }

}

