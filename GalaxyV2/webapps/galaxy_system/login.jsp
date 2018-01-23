<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html;charset=Shift_JIS"%>
<%@ page import="java.net.*" %>
<%

	Cookie[] cookies = request.getCookies();
	Cookie save1 = null;
	Cookie save2 = null;
	
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("galaxy_id")){
				save1 = cookies[i];
			}
			if(cookies[i].getName().equals("galaxy_pass")){
				save2 = cookies[i];
			}
		}
	}
	String galaxy_id = "";
	String galaxy_pass = "";
	String check = "0";
	if(save1 != null){
		galaxy_id = URLDecoder.decode(save1.getValue(),"Shift_JIS");
	}
	if(save2 != null){
		galaxy_pass = URLDecoder.decode(save2.getValue(),"Shift_JIS");
	}
	if(save1 != null || save2 != null){
		check="1";
	}

%>

<HTML>
<HEAD>
<TITLE>Galaxy Login</TITLE>
</HEAD>
<BODY marginwidth="0" marginheight="100" leftmargin="0" topmargin="100" bgcolor="#ffffff">
<FORM name="galaxyfrm" method="post" action="user_confirm">
<TABLE width="400" cellpadding="0" cellspacing="0" border="1" bordercolor="gray" align="center">
  <TBODY>
    <TR>
      <TD>
      <TABLE width="400" cellpadding="0" cellspacing="0" border="1" bordercolor="#8c8cff">
        <TBODY>
          <TR>
            <TD align="center" height="50" bgcolor="#8c8cff"><FONT size="+1" color="#ffff00"><B>Galaxy ログイン</B></FONT></TD>
          </TR>
          <TR>
            <TD align="center">
            <TABLE>
              <TBODY>
                <TR>
                  <TD width="100"><FONT size="2"><B>Ｇalaxy ID</B></FONT></TD>
                  <TD><INPUT size="30" type="text" name="galaxyid" maxlength="30" value="<%=galaxy_id%>"></TD>
                </TR>
                <TR>
                  <TD width="100"><FONT size="2"><B>パスワード</B></FONT></TD>
                  <TD><INPUT size="20" type="password" name="pass" maxlength="20" value="<%=galaxy_pass%>"></TD>
                </TR>
              </TBODY>
            </TABLE>
            </TD>
          </TR>
          <TR>
            <TD align="center"><FONT size="2"><B>Galaxy IDとパスワードを保存</B></FONT>　<INPUT type="checkbox" name="passwordsave" value="1" <%if(check.equals("1")){out.println("checked");}%>></TD>
          </TR>
          <TR>
            <TD height="50" align="center" bgcolor="#8c8cff"><INPUT type="submit" name="submit" value="ログイン">　<INPUT type="reset" name="reset" value="リセット"></TD>
          </TR>
        </TBODY>
      </TABLE>
      </TD>
    </TR>
    <TR>
      <TD align="right"><B><FONT size="2">ご利用が初めての方はこちら <A href="regist.html" title="Galaxy ID新規発行">Galaxy ID登録</A></FONT></B></TD>
    </TR>
  </TBODY>
</TABLE>
</FORM>
</BODY>
</HTML>
