<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html;charset=Shift_JIS"%>
<%
	String id       = (String)session.getAttribute("n_id");
	String galaxyid = (String)session.getAttribute("galaxy_id");
	String mail     = (String)session.getAttribute("mail");
	String group    = (String)session.getAttribute("group");
	String mode     = (String)session.getAttribute("mode");
	String country  = (String)session.getAttribute("country");
	
	String graph    = (String)session.getAttribute("graph");
	String mark1c   = (String)session.getAttribute("mark1c");
	String mark1    = (String)session.getAttribute("mark1");
	String mark2c   = (String)session.getAttribute("mark2c");
	String mark2    = (String)session.getAttribute("mark2");
	String mark3c   = (String)session.getAttribute("mark3c");
	String mark3    = (String)session.getAttribute("mark3");
	String bg       = (String)session.getAttribute("bg");
%>
<HTML>
<HEAD>
<TITLE>Galaxy Admin Page</TITLE>
</HEAD>
<BODY>
<CENTER>
<TABLE border="1" cellpadding="0" cellspacing="0" bordercolor="gray">
  <TBODY>
    <TR>
      <TD valign="middle" align="center" width="800" height="600">
	  	<B><FONT size="+2" color="#ffff00">Galaxy Admin</FONT></B>
		<applet archive="Oligosaccharide.jar" code="GalaxySystem2.class" codebase="./GalaxyV2/" width="860" height="590">
			<param name="user_id" value="<%=galaxyid%>">
			<param name="mark1" value="<%=mark1%>">
			<param name="mark2" value="<%=mark2%>">
			<param name="mark3" value="<%=mark3%>">
			<param name="markSt1" value="non">
			<param name="markSt2" value="non">
			<param name="markSt3" value="non">
			<param name="markC1" value="<%=mark1c%>">
			<param name="markC2" value="<%=mark2c%>">
			<param name="markC3" value="<%=mark3c%>">
			<param name="defaultmap" value="<%=graph%>">
			<param name="background" value="<%=bg%>">
			<param name="defaultcode" value="0">
			<param name="zoom_x" value="0">
			<param name="zoom_y" value="0">
			<param name="zoom_v" value="0">
		</applet>
	  </TD>
    </TR>
  </TBODY>
</TABLE>
<A href="servlet/load_user">カスタマイズ</A>
<A href="logout.jsp">LOGOUT</A>
</CENTER>
</BODY>
</HTML>
