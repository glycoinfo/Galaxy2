import java.awt.*;
import java.awt.event.*;

class EnzimeLabel extends Canvas implements MouseListener{
	private int xx;
	private int yy;
	private int xx1;
	private int yy1;
	public int st;
	public EnzimeLabel(int x,int y,int x1,int y1){
		setBounds(x,y,x1,y1);
		this.xx = x;
		this.yy = y;
		this.xx1 = x1;
		this.yy1 = y1;
		addMouseListener(this);
		repaint();
	}
	public void EnzimeLabelSet(int i){
		st = i;
		repaint();
	}
	public void paint(Graphics g){
		g.setFont(new Font("Time New Roman",Font.BOLD,17));
		if(st == 0){
			g.setColor(Color.white);
			g.fillRect(0,0,xx1,yy1);
			g.setColor(Color.gray);
			g.fillRect(0,0,xx1,yy1);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,xx1-2,yy1-2,5,5);
			g.setColor(Color.red);
			g.drawString("\u2190 \u03b1-Galactosidase",10,20);
			g.setColor(Color.green);
			g.drawString("\u2190 \u03b1-Fucsidase",10,40);
			g.setColor(Color.magenta);
			g.drawString("\u2190 \u03b2-Galactosidase",10,60);
			g.setColor(Color.black);
			g.drawString("\u2190 \u03b2-HexNAcase",195,20);
			g.setColor(Color.orange);
			g.drawString("\u2190 \u03b2-Xylosidase",195,40);
			g.setColor(Color.cyan);
			g.drawString("\u2190 \u03b1-Sialidase",195,60);
		}else if(st != 0){
			g.setColor(Color.white);
			g.fillRect(0,0,xx1,yy1);
			g.setColor(Color.lightGray);
			g.fillRect(0,0,xx1,yy1-40);
			g.setColor(Color.black);
			g.drawRoundRect(0,0,xx1-2,yy1-42,5,5);
			g.setColor(Color.black);
			g.drawString("\u2190 known",10,20);
			g.setColor(Color.red);
			g.drawString("\u2190 unknown",195,20);
		}
	}
	public void mouseClicked(MouseEvent e){
		repaint();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){
		repaint();
	}
	public void mouseExited(MouseEvent e){}
}