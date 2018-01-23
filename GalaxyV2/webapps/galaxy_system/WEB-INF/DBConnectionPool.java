import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Properties;

public class DBConnectionPool{
	private static final String PROPERTY = "galaxy.properties";
	private static String sDB = "galaxy?useUnicode=true&characterEncoding=MS932";
	private static String driver = "org.gjt.mm.mysql.Driver";
	private static String url ="jdbc:mysql://localhost:3306/";
	private static String user = "DBmaster";
	private static String password = "GingaSystem";
	private int maxConnection;
	private int checkedOut;
	private Vector connectionPool = new Vector();
	private static DBConnectionPool instance;
	
	static File fileParentDirectory = new File(".").getAbsoluteFile().getParentFile();
	static String PropPath=fileParentDirectory.getAbsolutePath() + "/prop/";
	
	static{
		try{
			Properties prop = new Properties();
			prop.load(new FileInputStream(PropPath + PROPERTY));
			sDB = prop.getProperty("galaxy.jdbc.db");
			driver = prop.getProperty("galaxy.jdbc.driver");
			url = prop.getProperty("galaxy.jdbc.url");
			user = prop.getProperty("galaxy.jdbc.user");
			password = prop.getProperty("galaxy.jdbc.password");
		}catch(Exception e){
			System.out.println("Error in Opening Database Property file \n" + e);
		}
	}
	
	/* インスタンスを処理 */
	public static synchronized DBConnectionPool getInstance(){
		if(instance == null){
			instance = new DBConnectionPool();
		}
		return instance;
	}
	
	/* コンストラクタ */
	private DBConnectionPool(){
		this.maxConnection = 10;
		System.out.println("Values are...");
 	   	System.out.println("db       = "+ sDB);
        System.out.println("driver   = "+ driver);
        System.out.println("url      = "+ url);
		System.out.println("user     = "+ user);
		System.out.println("password = "+ password);
	}
	
	/* コネクションを取得 */
	public synchronized Connection getConnection() throws Exception{
		Connection con = null;
		if(connectionPool.size() > 0){
			con = (Connection) connectionPool.firstElement();
			connectionPool.removeElementAt(0);
			try{
				if(con.isClosed()){
					con = getConnection();
				}
			}catch(SQLException e){
				con = getConnection();
			}
		}else if(maxConnection == 0 || checkedOut < maxConnection){
			con = newConnection();
		}
		if(con != null){
			checkedOut ++;
		}
		return con;
	}
	
	private Connection newConnection() throws Exception{
		Class.forName(driver);
		return DriverManager.getConnection(url+sDB,user,password);
	}
	/* 新規にコネクションを返却 */
	
	public synchronized void freeConnection(Connection con){
		connectionPool.addElement(con);
		checkedOut --;
		notifyAll();
	}
	
	/* すべてのコネクションを開放する */
	public synchronized void release(){
		Enumeration enumConnections = connectionPool.elements();
		while(enumConnections.hasMoreElements()){
			Connection con = (Connection) enumConnections.nextElement();
			try{
				con.close();
			}catch (SQLException e){
			}
		}
		connectionPool.removeAllElements();
	}
}