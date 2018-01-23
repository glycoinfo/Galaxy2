<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html; charset=Shift_JIS" %>

<HTML>
<HEAD>
<TITLE> Loading ... </TITLE>
</HEAD>
<BODY>
</BODY>
</HTML>

<%
	session.invalidate();
	try{
    	for( int i = 0 ; i < 1 ; i++ ){
         	// Waitˆ—A1000ƒ~ƒŠ•b‚P•bŽžŠÔ‚ðŽ~‚ß‚éB
         	Thread.sleep( 100 );
         	// System.out.println( i );
    	}
 	}catch( java.lang.Exception e ){
     	System.out.println(e.toString());
 	}
	response.sendRedirect("login.jsp");
%>