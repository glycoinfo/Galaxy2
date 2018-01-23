<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html; charset=Windows-31J"%>
<%
%>


<HTML lang="ja">
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<META name="robots" content="noindex,nofollow">
<TITLE>GALAXY SYSTEM Version2</TITLE>
<SCRIPT LANGUAGE="JavaScript">
<!--
	function winopen(stuff,morestuff){
		var agent = navigator.userAgent;
		var userOs = null;
		if (agent.indexOf('Win') !=-1 ){
			userOs = "Win";
		}
		else if( agent.indexOf('Mac') !=-1){
			userOs = "Mac";
		}
		else{
			userOs = "other";
		}
		if(userOs == "Win"){
			if(navigator.appName == "Microsoft Internet Explorer"){
				// url1 = "http://www.glycoanalysis.info/IE/index.html";
				url1 = "http://localhost:8080/galaxy_system/";
				stuff = stuff + Math.floor(Math.random()*100);
				window.open(url1,stuff,morestuff).focus();
			}
			else{
				// url2 = "http://www.glycoanalysis.info/NETSCAPE/index.html";
				url2 = "http://localhost:8080/galaxy_system/";
				stuff = stuff + Math.floor(Math.random()*100);
				window.open(url2,stuff,morestuff).focus();
			}
		}
		else if(userOs == "Mac"){
			if(navigator.appName == "Microsoft Internet Explorer"){
				// url3 = "http://www.glycoanalysis.info/Mac/index.html";
				url3 = "http://localhost:8080/galaxy_system/";
				stuff = stuff + Math.floor(Math.random()*100);
				window.open(url3,stuff,morestuff).focus();
			}
		}
		else if(userOs = "other"){
			// url4 = "http://www.glycoanalysis.info/Unix/index.html";
			url4 = "http://localhost:8080/galaxy_system/";
			stuff = stuff + Math.floor(Math.random()*100);
			window.open(url4,stuff,morestuff).focus();
		}
	}
-->
</SCRIPT>
<style type="text/css">
<!--
a {	color:#44AAFF; } a:hover { color:#4D2B57; background-color:#99BBFF; text-decoration:none; }
-->
</style>
</HEAD>
<BODY marginwidth="0px" marginheight="10px" leftMargin="0px" topMargin="10px" bgcolor="#ffffff">
<CENTER>
<TABLE cellpadding="0" cellspacing="0" border="0" bordercolor="yellow" width="950">
  <TBODY>
    <TR>
      <TD align="center">
      <TABLE cellpadding="0" cellspacing="0" border="0" bordercolor="red" width="950">
        <TBODY>
          <TR>
            <TD colspan="3" align="center" bgcolor="blue">
			<%@ include file="include/header.htm" %>
            </TD>
          </TR>
		  <TR>
		  	<TD colspan="3" height="2" align="center" bgcolor="white">
			</TD>
		  </TR>
          <TR>
		  <TD width="200" valign="top" background="image/background.jpg">
			<%@ include file="include/menu.htm" %>
			</TD>
			<TD width="740" height="700">
<P align="center"><B><FONT size="+3">Galaxy システム 2</FONT></B></P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"><BR>
</P>
<P align="center">
<A class="lnk" href="javascript:winopen('SYSTEM2','width=900,height=675,menubar=yes,scrollbars=yes,resizable=yes,location=no');">
<IMG src="image/start.png" width="191" height="42" border="0" alt="GALAXY : Glycoanalysis by the three-axes of MS and chromatography."></A><BR><BR><BR>
<A href="list.html" target="_blank"><IMG src="image/code.png" width="191" height="42" border="0" alt="Oligosaccharides Code No. List"></A><BR>
</P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"><BR>
		    </TD>
            <TD width="10">&nbsp;</TD>
          </TR>
		  <TR>
		  	<TD colspan="3" height="2" align="center" bgcolor="white">
			</TD>
		  </TR>
          <TR>
            <TD colspan="10" align="center" bgcolor="blue">
			<%@ include file="include/footer.htm" %>
	        </TD>
          </TR>
        </TBODY>
      </TABLE>
      </TD>
    </TR>
  </TBODY>
</TABLE>
</CENTER>
</BODY>
</HTML>

