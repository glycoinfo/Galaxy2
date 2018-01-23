import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBConnection
{
 	private static DBConnectionPool pool;
	private static Connection oCon = null;
	
	public static Connection connect() throws Exception{
		try{
			pool = DBConnectionPool.getInstance();
			oCon = pool.getConnection();
 		}
 		catch(Exception e)
 		{
 		    System.out.println("Error  creating connection\n"+e);
             throw e;
 		}
 		return oCon;
     }

     public static void close()throws Exception{
         try
         {
            if (oCon != null)
            {
                 pool.freeConnection(oCon);
                 oCon = null;
            }
         }
         catch(Exception e)
 		{
 		    System.out.println("Error  closing connection\n"+e);
 		    throw e;
 		 }
     }

     public static void beginTrans() throws Exception
     {
         try
         {
             if (oCon == null)
             {
                 connect();
             }
             oCon.setAutoCommit(false);
         }
         catch(Exception e)
         {
             close();
             e.printStackTrace();
             throw e;
         }
     }

     public static void endTrans() throws Exception
     {
         try
         {
             if (oCon == null)
             {
                 connect();
             }
             oCon.commit();
             close();
         }
         catch(Exception e)
         {
             close();
             e.printStackTrace();
             throw e;
         }
     }

     public static void rollbackTrans() throws Exception
     {
         try
         {
             if (oCon == null)
             {
                 connect();
             }
             oCon.rollback();
         }
         catch(Exception e)
         {
             close();
             e.printStackTrace();
             throw e;
         }
     }

     public static int executeUpdate(String sSQL) throws Exception
     {
         Statement oStmt = null;
         int iRows = 0;

         try
         {
             if (oCon == null)
             {
                 connect();
             }

             oStmt = oCon.createStatement();
             iRows  = oStmt.executeUpdate(sSQL);
         }
         catch(Exception e)
         {
             close();
             System.out.println("Error in DBConnection.executeUpdate()");
             throw e;
         }
         return iRows;
     }

     public static int executeUpdate(String sSQL, InputStream oIS, int iLength) throws Exception
     {
         PreparedStatement oPStmt = null;
         int iRows = 0;

         try
         {
             if (oCon == null)
             {
                 connect();
             }
             oPStmt = oCon.prepareStatement(sSQL);
             oPStmt.setBinaryStream(1, oIS, iLength);
             iRows  = oPStmt.executeUpdate();
         }
         catch(Exception e)
         {
             close();
             System.out.println("Error in DBConnection.executeUpdate()");
             throw e;
         }
         return iRows;
     }


     public static ResultSet executeQuery(String sSQL) throws Exception
     {
         Statement oStmt = null;
         ResultSet oRs = null;

         try
         {
             if (oCon == null)
             {
                 connect();

             }

             oStmt = oCon.createStatement();
             oRs  = oStmt.executeQuery(sSQL);
         }
         catch(SQLException e)
         {
             close();
             e.printStackTrace();
             System.out.println(""+e.getErrorCode());
             System.out.println(""+e.getSQLState());
             throw e;
         }
         return oRs;
     }
}