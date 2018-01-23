import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class load_user extends HttpServlet {

    private DBConnection dbCon;
    private String galaxyid;
	private String galaxynid;
    private String galaxy;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

	response.setContentType("text/html;charset=MS932");
	request.setCharacterEncoding("MS932");
	
	HttpSession session = request.getSession();
	
	try{
		galaxyid = (String)session.getAttribute("galaxy_id");
		galaxy = (String)session.getAttribute("galaxy");
		galaxynid = (String)session.getAttribute("n_id");
		
		
	    String sSQL = "SELECT user_mode,user_mail,user_group,user_number,galaxy_admin, user_first, user_last, user_country, user_zip, user_sex," + 
		 			  " user_graph, user_mark1_c, user_mark1, user_mark2_c, user_mark2, user_mark3_c, user_mark3, user_bg_c "
		            + " FROM regist_table " + " WHERE galaxy_id = '" + galaxyid + "' and user_number= " + galaxynid + ";";
		
	    dbCon = new DBConnection();
	    ResultSet rs = dbCon.executeQuery(sSQL);
	    if(rs.next()){
		    session.setAttribute("n_id",rs.getString("user_number"));
		    session.setAttribute("galaxy_id",galaxyid);
		    session.setAttribute("group",rs.getString("user_group"));
			session.setAttribute("mail",rs.getString("user_mail"));
			session.setAttribute("mode",rs.getString("user_mode")); // HPLC MASS LECTIN
			session.setAttribute("first",rs.getString("user_first"));
			session.setAttribute("last",rs.getString("user_last"));
			session.setAttribute("country",rs.getString("user_country"));
			session.setAttribute("zip",rs.getString("user_zip"));
			session.setAttribute("sex",rs.getString("user_sex"));
			
			session.setAttribute("graph",rs.getString("user_graph"));
			session.setAttribute("mark1c",rs.getString("user_mark1_c"));
			session.setAttribute("mark1",rs.getString("user_mark1"));
			session.setAttribute("mark2c",rs.getString("user_mark2_c"));
			session.setAttribute("mark2",rs.getString("user_mark2"));
			session.setAttribute("mark3c",rs.getString("user_mark3_c"));
			session.setAttribute("mark3",rs.getString("user_mark3"));
			session.setAttribute("bg",rs.getString("user_bg_c"));
			
			session.setAttribute("galaxy","authority");
		    response.sendRedirect("../update.jsp");
		}else{
		    System.out.println("Non Login");
			session.setAttribute("n_id",null);
			session.setAttribute("galaxy_id",null);
			session.setAttribute("group",null);
			session.setAttribute("mail",null);
			session.setAttribute("mode",null);
			session.setAttribute("first",null);
			session.setAttribute("last",null);
			session.setAttribute("country",null);
			session.setAttribute("zip",null);
			session.setAttribute("sex",null);
			
			session.setAttribute("graph",null);
			session.setAttribute("mark1c",null);
			session.setAttribute("mark1",null);
			session.setAttribute("mark2c",null);
			session.setAttribute("mark2",null);
			session.setAttribute("mark3c",null);
			session.setAttribute("mark3",null);
			session.setAttribute("bg",null);
			
			session.setAttribute("galaxy",null);
		    response.sendRedirect("../login.jsp");
		}
		
	}catch(Exception e){
	    System.out.println("Exception occoured " +e);
	}
    }//doGet ends here
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
    }//end of doPost
	
	public boolean insertToDatabase(String comment) throws Exception{
		long logid = 0;
		String sUser = "";
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
			String sInsertSQL = "";
	    	// String sInsertSQL = "INSERT INTO login_log VALUES(" + logid + ",'" + sUser + "','" + comment + "','"+ y + "/" + m + "/" + d + "','" + h + ":" + mi +"');";
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

