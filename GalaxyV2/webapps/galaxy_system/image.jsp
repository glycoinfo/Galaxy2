<%@ page contentType="image/jpeg; charset=Shift_JIS"
import="java.awt.*,java.awt.image.*,com.sun.image.codec.jpeg.*" %>
<%
	BufferedImage objBi=new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
	Graphics objGrh=objBi.getGraphics();
	objGrh.setColor(new Color(255,255,255));
	objGrh.fillRect(0,0,200,200);
	objGrh.setFont(new Font("HGŠÛºÞ¼¯¸M-PRO",Font.BOLD,11));
	objGrh.setColor(new Color(0,0,255));
	objGrh.drawString("http://www.wings.msn.to/",10,180);
	objGrh.setColor(new Color(230,230,180));
	objGrh.fillRect(10,10,100,100);
	objGrh.drawOval(5,5,180,180);
	JPEGImageEncoder objEnc=JPEGCodec.createJPEGEncoder(response.getOutputStream());
	objEnc.encode(objBi);
%>