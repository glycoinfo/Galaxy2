<%@ page language="Java" session="true" buffer="12kb" autoFlush="true" contentType="text/html; charset=Windows-31J"%>
<%
%>

<HTML>
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<META name="robots" content="noindex,follow">
<TITLE>お問い合わせ</TITLE>
<SCRIPT language="JavaScript">
<!--HPB_SCRIPT_ROV_50
//
// Licensed Materials - Property of IBM
// 83H7391, 42L1820
// (C) Copyright IBM Corp. 1995, 1999  All Rights Reserved.
//
// Version: 5.0.1
//

// HpbImgPreload: 画像のプリロードを行ないます
//
function HpbImgPreload()
{
  var appVer=parseInt(navigator.appVersion);
  var isNC=(document.layers && (appVer >= 4)); // Netscape Navigator 4.0 or later
  var isIE=(document.all    && (appVer >= 4)); // Internet Explorer  4.0 or later
  if (isNC || isIE)
  {
    if (document.images)
    {
      var imgName = HpbImgPreload.arguments[0];
      var cnt;
      swImg[imgName] = new Array;
      for (cnt = 1; cnt < HpbImgPreload.arguments.length; cnt++)
      {
        swImg[imgName][HpbImgPreload.arguments[cnt]] = new Image();
        swImg[imgName][HpbImgPreload.arguments[cnt]].src = HpbImgPreload.arguments[cnt];
      }
    }
  }
}
// HpbImgFind: Imageオブジェクトを探します
//
function HpbImgFind(doc, imgName)
{
  for (var i=0; i < doc.layers.length; i++)
  {
    var img = doc.layers[i].document.images[imgName];
    if (!img) img = HpbImgFind(doc.layers[i], imgName);
    if (img) return img;
  }
  return null;
}
// HpbImgSwap: 画像を入れ換えます
//
function HpbImgSwap(imgName, imgSrc)
{
  var appVer=parseInt(navigator.appVersion);
  var isNC=(document.layers && (appVer >= 4)); // Netscape Navigator 4.0 or later
  var isIE=(document.all    && (appVer >= 4)); // Internet Explorer  4.0 or later
  if (isNC || isIE)
  {
    if (document.images)
    {
      var img = document.images[imgName];
      if (!img) img = HpbImgFind(document, imgName);
      if (img) img.src = imgSrc;
    }
  }
}
var swImg; swImg=new Array;
//-->
</SCRIPT>
<SCRIPT language="JavaScript">
<!--HPB_SCRIPT_PLD_50
HpbImgPreload('_HPB_ROLLOVER1', 'image/n_imagepraim.png', 'image/m_imageprime.png');
//-->
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
<P align="center"><B><FONT size="+3">お問い合わせ</FONT></B></P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"></P>
<P><BR><BR>
</P>
<CENTER>
<TABLE>
  <TBODY>
    <TR>
      <TD><B>糖鎖解析部門<BR>
      株式会社グライエンス<BR>
      <BR>
      〒460-8690 <BR>
      名古屋市中区正木一丁目４番地６号<BR>
      (中電CTI内)<BR>
      <BR>
      電話 : <BR>
      FAX : <BR>
      E-mail : <A href="mailto:contact_us@glyence.com?Subject=GALAXYについて">contact_us@glyence.com</A></B></TD>
    </TR>
  </TBODY>
</TABLE>
</CENTER>
<P align="center"><A href="http://glyence.com/" target="_blank"><IMG src="image/glyence_logo.jpg" alt="グライエンス" border="0"></A><BR>
</P>
<P align="center"><IMG src="image/beau_l2.gif" width="685" height="3" border="0"></P>
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

