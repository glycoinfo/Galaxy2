<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html;charset=Shift_JIS"%>
<%
	String id       = (String)session.getAttribute("n_id");
	String galaxyid = (String)session.getAttribute("galaxy_id");
	String group    = (String)session.getAttribute("group");
	String mail     = (String)session.getAttribute("mail");
	String mode     = (String)session.getAttribute("mode");
	String first    = (String)session.getAttribute("first");
	String last     = (String)session.getAttribute("last");
	String country  = (String)session.getAttribute("country");
	String zip      = (String)session.getAttribute("zip");
	String sex      = (String)session.getAttribute("sex");
	
	String graph    = (String)session.getAttribute("graph");
	String mark1c   = (String)session.getAttribute("mark1c"); //終了、重要、一時マーク
	String mark1    = (String)session.getAttribute("mark1");
	String mark2c   = (String)session.getAttribute("mark2c");
	String mark2    = (String)session.getAttribute("mark2");
	String mark3c   = (String)session.getAttribute("mark3c");
	String mark3    = (String)session.getAttribute("mark3");
	String bg       = (String)session.getAttribute("bg");
%>
<HTML><HEAD>
<TITLE>Galaxy 個人情報更新</TITLE>
</HEAD>
<BODY marginwidth="0" marginheight="50" leftmargin="0" topmargin="50" bgcolor="#ffffff">
<FORM name="galaxyfrm" method="post" action="servlet/update_user">
<CENTER>
<TABLE border="1" width="500" cellpadding="0" cellspacing="0" bordercolor="gray" bgcolor="#979fee">
  <TBODY>
    <TR>
      <TD align="center">
      <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="#979fee" width="700">
        <TBODY>
          <TR>
            <TD align="center" height="50" bgcolor="#979fee" colspan="2"><B><FONT size="+1" color="#ffff00">Galaxy ユーザ情報　更新</FONT></B></TD>
          </TR>
          <TR>
            <TD align="center" bgcolor="#ffffff">
            <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff" width="350">
              <TBODY>
                <TR>
                  <TD><B><FONT size="-1">Galaxy ID (readonly)</FONT></B></TD>
                  <TD>
                  <INPUT size="30" type="text" name="galaxyid" maxlength="30" value="<%=galaxyid%>" readonly>
                  </TD>
                </TR>
                <TR>
                  <TD><B><FONT size="-1">パスワード</FONT></B></TD>
                  <TD>
                  <INPUT size="20" type="password" name="pass1" maxlength="20">
                  </TD>
                </TR>
                <TR>
                  <TD><B><FONT size="-1">パスワード再入力</FONT></B></TD>
                  <TD>
                  <INPUT size="20" type="password" name="pass2" maxlength="20">
                  </TD>
                </TR>
              </TBODY>
            </TABLE>
            </TD>
            <TD width="200"><B><FONT size="-1">Galaxy ID</FONT></B><BR>
            <FONT size="-1" color="#ffffff">半角の英数字にて入力して下さい。<BR>
            日本語は利用できません。</FONT><FONT color="#ffff00"><BR>
            </FONT><BR>
            <FONT size="-1"><B>パスワード</B></FONT><BR>
            <FONT size="-1" color="#ffffff">半角の英数字　6文字以上でパスワードを設定してください。<BR>
            数字、大文字、記号などを混合すると、安全です。</FONT><BR>
            <FONT size="-1" color="#ff8000">Caps Lockに注意してください。</FONT></TD>
          </TR>
          <TR>
            <TD colspan="2">&nbsp;</TD>
          </TR>
          <TR>
            <TD bgcolor="#ffffff" align="center">
            <TABLE border="0" cellpadding="0" cellspacing="0" width="400">
              <TBODY>
                <TR>
                  <TD><B>姓</B> :</TD>
                  <TD><INPUT size="20" type="text" name="sei" value="<%=last%>"></TD>
                  <TD><B>名</B> :</TD>
                  <TD><INPUT size="20" type="text" name="mei" value="<%=first%>"></TD>
                </TR>
                <TR>
                  <TD><B>国</B></TD>
                  <TD colspan="3" align="left"><B><%=country%></B></TD>
                </TR>
                <TR>
                  <TD><B>郵便番号</B></TD>
                  <TD><INPUT size="10" type="text" name="zip" maxlength="7" value="<%=zip%>"></TD>
                  <TD><B>性別</B></TD>
                  <TD><SELECT name="sex">
                    <OPTION value="-" <%if(sex.equals("-")){out.print("selected");}%> >---</OPTION>
                    <OPTION value="m" <%if(sex.equals("m")){out.print("selected");}%> >男性</OPTION>
                    <OPTION value="f" <%if(sex.equals("f")){out.print("selected");}%> >女性</OPTION>
                  </SELECT></TD>
                </TR>
                <TR>
                  <TD><B>所属</B></TD>
                  <TD colspan="3"><INPUT size="20" type="text" name="syozoku" maxlength="100" value="<%=group%>"></TD>
                </TR>
                <TR>
                  <TD><B>e-mail</B></TD>
                  <TD colspan="3"><INPUT size="30" type="text" name="email" maxlength="30" value="<%=mail%>"></TD>
                </TR>
              </TBODY>
            </TABLE>
            </TD>
            <TD width="200"><B><FONT size="-1">郵便番号</FONT></B><BR>
            <FONT size="-1" color="#ffffff">海外にお住まいの方は、郵便番号&quot;0000000&quot;と入力して下さい。</FONT><BR>
            <BR>
            <B><FONT size="-1">所属</FONT></B><BR>
            <FONT color="#ffffff" size="-1">学校名、研究室名などを入力して下さい。空白でも問題ございません。</FONT><BR>
            <BR>
            </TD>
          </TR>
          <TR>
            <TD colspan="2" align="center" height="50"><B><FONT color="#ffff00" size="+1">Galaxy 動作設定</FONT></B></TD>
          </TR>
          <TR>
            <TD bgcolor="#ffffff" align="center">
            <TABLE border="0" cellpadding="0" cellspacing="0" width="350">
              <TBODY>
			  	<TR>
					<TD align="left"><FONT size="-1"><B>モード</B></FONT></TD>
					<TD align="left" colspan="2">
					<SELECT name="mode">
						<OPTION value="HPLC" <%if(mode.equals("HPLC")){out.print("selected");}%> >HPLC</OPTION>
						<OPTION value="MASS" <%if(mode.equals("MASS")){out.print("selected");}%> >MASS</OPTION>
						<OPTION value="LECTIN" <%if(mode.equals("LECTIN")){out.print("selected");}%> >LECTIN</OPTION>
					</SELECT>
					</TD>
				</TR>
				<TR><TD>&nbsp;</TD></TR>
				<TR>
                  <TD align="left"><FONT size="-1"><B>デフォルトグラフ</B></FONT></TD>
                  <TD align="left" colspan="2"><SELECT name="type">
                    <OPTION value="o-a" <%if(graph.equals("o-a")){out.print("selected");}%> >ODS-AMIDE</OPTION>
                    <OPTION value="o-m" <%if(graph.equals("o-m")){out.print("selected");}%> >ODS-MW</OPTION>
                    <OPTION value="a-m" <%if(graph.equals("a-m")){out.print("selected");}%> >AMIDE-MW</OPTION>
                  </SELECT></TD>
                </TR>
				<TR><TD>&nbsp;</TD></TR>
                <TR>
                  <TD><B><FONT size="-1">Mark1</FONT></B></TD>
                  <TD align="center">
				  <SELECT name="markc1">
                    <OPTION value="black" <%if(mark1c.equals("black")){out.print("selected");}%> >黒</OPTION>
                    <OPTION value="red" <%if(mark1c.equals("red")){out.print("selected");}%> >赤</OPTION>
                    <OPTION value="blue" <%if(mark1c.equals("blue")){out.print("selected");}%> >青</OPTION>
                    <OPTION value="yellow" <%if(mark1c.equals("yellow")){out.print("selected");}%> >黄</OPTION>
                  </SELECT></TD>
                  <TD><INPUT size="20" type="text" name="mark1" value="<%=mark1%>"></TD>
                </TR>
                <TR>
                  <TD><B><FONT size="-1">Mark2</FONT></B></TD>
                  <TD align="center">
				  <SELECT name="markc2">
                    <OPTION value="black" <%if(mark2c.equals("black")){out.print("selected");}%> >黒</OPTION>
                    <OPTION value="red" <%if(mark2c.equals("red")){out.print("selected");}%> >赤</OPTION>
                    <OPTION value="blue" <%if(mark2c.equals("blue")){out.print("selected");}%> >青</OPTION>
                    <OPTION value="yellow" <%if(mark2c.equals("yellow")){out.print("selected");}%> >黄</OPTION>
                  </SELECT></TD>
                  <TD><INPUT size="20" type="text" name="mark2" value="<%=mark2%>"></TD>
                </TR>
                <TR>
                  <TD><B><FONT size="-1">Mark3</FONT></B></TD>
                  <TD align="center">
				  <SELECT name="markc3">
                    <OPTION value="black" <%if(mark3c.equals("black")){out.print("selected");}%> >黒</OPTION>
                    <OPTION value="red" <%if(mark3c.equals("red")){out.print("selected");}%> >赤</OPTION>
                    <OPTION value="blue" <%if(mark3c.equals("blue")){out.print("selected");}%> >青</OPTION>
                    <OPTION value="yellow" <%if(mark3c.equals("yellow")){out.print("selected");}%> >黄</OPTION>
                  </SELECT></TD>
                  <TD><INPUT size="20" type="text" name="mark3" value="<%=mark3%>"></TD>
                </TR>
				<TR><TD>&nbsp;</TD></TR>
                <TR>
                  <TD><B><FONT size="-1">バックグラウンド</FONT></B></TD>
                  <TD colspan="2" align="center">
				  <INPUT type="radio" name="back" value="white" <%if(bg.equals("white")){out.print("checked");}%> > <B>白</B>
				  <INPUT type="radio" name="back" value="black" <%if(bg.equals("black")){out.print("checked");}%> > <B>黒</B>
				  <INPUT type="radio" name="back" value="blue" <%if(bg.equals("blue")){out.print("checked");}%> > <B>青</B>
				  </TD>
                </TR>
              </TBODY>
            </TABLE>
            </TD>
            <TD width="200"><B>Mark</B> <FONT size="-1"><B>1,2,3</B></FONT><BR>
            <FONT size="-1" color="#ffffff">システムに表示されるボタンの文字列、マークされた場合のターゲットの色を設定できます。</FONT><BR><BR>
            <B><FONT size="-1">デフォルトグラフ</FONT></B><BR>
            <FONT color="#ffffff" size="-1">システムがロードされたときの初期グラフタイプを設定できます。<BR>
            (amide-ods, ods-mw, amide-mw)</FONT><BR>
            <BR>
            <FONT size="-1"><B>バックグランド</B></FONT><BR>
            <FONT size="-1" color="#ffffff">システムのデフォルトカラーを設定できます。</FONT></TD>
          </TR>
          <TR>
            <TD align="center" height="50" bgcolor="#979fee" colspan="2"><INPUT type="submit" name="submit" value="更新">　<INPUT type="reset" name="reset" value="リセット"></TD>
          </TR>
        </TBODY>
      </TABLE>
      </TD>
    </TR>
  </TBODY>
</TABLE>
</CENTER>
</FORM>
</BODY></HTML>
