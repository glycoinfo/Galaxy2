<%@ page contentType="application/octet-stream; charset=Shift_JIS"
         import="java.io.*,java.sql.*,java.util.zip.*" %>
<%
response.setHeader("Content-Disposition","attachment; filename=sample.zip");
Class.forName("org.gjt.mm.mysql.Driver");
Connection db=DriverManager.getConnection("jdbc:mysql://localhost/sample?user=
root&password =root&useUnicode=true&characterEncoding=Shift_JIS");
db.setReadOnly(true);
Statement objSql=db.createStatement();
ResultSet rs=objSql.executeQuery("SELECT * FROM books");
ByteArrayOutputStream objBos=new ByteArrayOutputStream();
OutputStreamWriter objOsw=new OutputStreamWriter(objBos,"Shift_JIS");
objOsw.write("‘–¼\t’˜ŽÒ–¼\to”ÅŽÐ\t’˜ŽÒ\t‰¿Ši\to”Å“ú");
objOsw.write(System.getProperty("line.separator"));
while(rs.next()){
  objOsw.write(rs.getString("title") + "\t");
  objOsw.write(rs.getString("author") + "\t");
  objOsw.write(rs.getString("published") + "\t");
  objOsw.write(rs.getString("price") + "\t");
  objOsw.write(rs.getString("publishDate") + "\t");
  objOsw.write(System.getProperty("line.separator"));
}
objOsw.close();
ZipOutputStream objZos=new ZipOutputStream(response.getOutputStream());
ZipEntry objZe=new ZipEntry("database.txt");
objZe.setMethod(ZipOutputStream.DEFLATED);
objZos.putNextEntry(objZe);
byte[] aryByt=objBos.toByteArray();
objZos.write(aryByt,0,aryByt.length);
objZos.closeEntry();
objZos.close();
objSql.close();
db.close();
%>