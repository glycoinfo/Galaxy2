// ------------------------------------
// *     Tree Draw Turtle graphics     *
// ------------------------------------

import java.awt.*;

class TreeDrawMaker {
    public double Angle,             // 現在角   
                  LPX,LPY;           // 現在位置
    private double WX1,WY1,WX2,WY2,  // ワールド座標
                   VX1,VY1,VX2,VY2,  // ビュー座標
                   FACTX,FACTY;      // 倍率
	
	public double size;
	
    private Graphics g;

    public TreeDrawMaker(Graphics gg) {
        g=gg;
        Angle=0;
        LPX=LPY=0;
		size = 7;
        window(0,0,400,400);
        view(0,0,400,400);
    }

    public void view(int x1,int y1,int x2,int y2) {
        g.setClip(x1,y1,x2-x1,y2-y1);
        VX1=(double)x1;VY1=(double)y1;
        VX2=(double)x2;VY2=(double)y2;
        FACTX=(VX2-VX1)/(WX2-WX1);
        FACTY=(VY2-VY1)/(WY2-WY1);
    }

    public void window(double x1,double y1,double x2,double y2) {
        WX1=x1;WY1=y1;WX2=x2;WY2=y2;
        FACTX=(VX2-VX1)/(WX2-WX1);
        FACTY=(VY2-VY1)/(WY2-WY1);
    }

    public void move(double l) {
        double x,y,x1,y1,x2,y2;
        x=LPX+l*Math.cos(3.14159/180*Angle);
        y=LPY+l*Math.sin(3.14159/180*Angle);
        x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
        x2=(x-WX1)*FACTX+VX1;
        y2=(WY2-y)*FACTY+VY1;
        g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
        LPX=x;LPY=y;
    }

    public void moveto(double x,double y) {
        double x1,y1,x2,y2;
        x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
        x2=(x-WX1)*FACTX+VX1;
        y2=(WY2-y)*FACTY+VY1;
        g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
        LPX=x;LPY=y;
    }

    public void setpoint(double x,double y) {
        LPX=x;LPY=y;
    }

    public void pset(double x,double y) {
        setpoint(x,y);
        moveto(x,y);
    }

    public void line(double x1,double y1,double x2,double y2) {
        setpoint(x1,y1);
        moveto(x2,y2);
    }

    public void turn(double a) {
        Angle=Angle+a;
        Angle=Angle-(int)Angle+((int)Angle % 360);
    }
	
    public void setangle(double a) {
        Angle=a;
    }
	
	public int graphX(int x){
		int ansx;
		double lpx;
		lpx = (x-VX1)/FACTX + WX1;
		ansx = (int)lpx;
		return ansx;
	}
	public int graphY(int y){
		double lpy;
		int ansy;
		lpy = WY2-((y-VY1)/FACTY);
		ansy = (int)lpy;
		return ansy;
	}
	
	public void setcolor(int i){
		if (i == 0)
			g.setColor(Color.black);
		else if (i == 1)
			g.setColor(Color.blue);
		else 
			g.setColor(Color.red);
	}
	
	public void setsize(double size){
		this.size = size;
	}
	public void point(double x, double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		x1 = x1-size/2;
		y1 = y1-size/2;
		g.fillOval((int)x1,(int)y1,(int)size,(int)size);
	}
	public void point2(double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
		y1=(WY2-LPY)*FACTY+VY1;
		x1 = x1-size/2;
		y1 = y1-size/2;
		g.drawOval((int)x1,(int)y1,(int)size,(int)size);
	}
	public void glc(double x,double y){
		double line;
		double xm[] = new double[3];
		double ym[] = new double[3];
		int xm2[] = new int[3];
		int ym2[] = new int[3];
		line = size/2;
		xm[0] = x; ym[0] = y + line;
		xm[1] = x - line; ym[1] = y - line;
		xm[2] = x + line; ym[2] = y - line;
		setpoint(xm[0],ym[0]);
		xm2[0]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[0]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[1],ym[1]);
		xm2[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[1]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[2],ym[2]);
		xm2[2]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[2]=(int)((WY2-LPY)*FACTY+VY1);
		g.fillPolygon(xm2,ym2,3);
	}
	public void man(double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		x1=x1-size/2;
		y1=y1-size/2;
		g.drawOval((int)x1,(int)y1,(int)size,(int)size);
	}
	public void gal(double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		x1 = x1-size/2;
		y1 = y1-size/2;
		g.fillOval((int)x1,(int)y1,(int)size,(int)size);
	}
	public void glcnac(double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		x1 = x1 -size/2;
		y1 = y1 -size/2;
		g.fillRect((int)x1,(int)y1,(int)size,(int)size);
	}
	public void galnac(double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		x1 = x1 -size/2;
		y1 = y1 -size/2;
		g.drawRect((int)x1,(int)y1,(int)size,(int)size);
	}
	public void fuc(double x, double y){
		double line;
		double xm[] = new double[3];
		double ym[] = new double[3];
		int xm2[] = new int[3];
		int ym2[] = new int[3];
		line = size/2;
		xm[0] = x; ym[0] = y + line;
		xm[1] = x - line; ym[1] = y - line;
		xm[2] = x + line; ym[2] = y - line;
		setpoint(xm[0],ym[0]);
		xm2[0]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[0]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[1],ym[1]);
		xm2[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[1]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[2],ym[2]);
		xm2[2]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[2]=(int)((WY2-LPY)*FACTY+VY1);
		g.drawPolygon(xm2,ym2,3);
	}
	public void xyl(double x, double y){
		double line;
		double xm[] = new double[3];
		double ym[] = new double[3];
		int xm2[] = new int[3];
		int ym2[] = new int[3];
		line = size/2;
		xm[0] = x; ym[0] = y - line;
		xm[1] = x + line; ym[1] = y + line;
		xm[2] = x - line; ym[2] = y + line;
		setpoint(xm[0],ym[0]);
		xm2[0]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[0]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[1],ym[1]);
		xm2[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[1]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[2],ym[2]);
		xm2[2]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[2]=(int)((WY2-LPY)*FACTY+VY1);
		g.drawPolygon(xm2,ym2,3);
	}
	public void neuac(double x, double y){
		double line;
		double xm[] = new double[4];
		double ym[] = new double[4];
		int xm2[] = new int[4];
		int ym2[] = new int[4];
		line = size/2;
		xm[0] = x; ym[0] = y + line;
		xm[1] = x - line; ym[1] =y;
		xm[2] = x; ym[2] =y -line;
		xm[3] = x + line; ym[3] = y;
		setpoint(xm[0],ym[0]);
		xm2[0]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[0]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[1],ym[1]);
		xm2[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[1]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[2],ym[2]);
		xm2[2]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[2]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[3],ym[3]);
		xm2[3]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[3]=(int)((WY2-LPY)*FACTY+VY1);
		g.drawPolygon(xm2,ym2,4);
	}
	public void neugc(double x, double y){
		double line;
		double xm[] = new double[4];
		double ym[] = new double[4];
		int xm2[] = new int[3];
		int ym2[] = new int[3];
		int xm3[] = new int[3];
		int ym3[] = new int[3];
		line = size/2;
		xm[0] = x; ym[0] = y + line;
		xm[1] = x - line; ym[1] =y;
		xm[2] = x; ym[2] = y - line;
		xm[3] = x + line; ym[3] = y;
		setpoint(xm[0],ym[0]);
		xm2[0]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[0]=(int)((WY2-LPY)*FACTY+VY1);
		xm3[0]= xm2[0]; ym3[0] = ym2[0];
		setpoint(xm[1],ym[1]);
		xm2[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[1]=(int)((WY2-LPY)*FACTY+VY1);
		setpoint(xm[2],ym[2]);
		xm2[2]=(int)((LPX-WX1)*FACTX+VX1);
        ym2[2]=(int)((WY2-LPY)*FACTY+VY1);
		xm3[2]= xm2[2]; ym3[2] = ym2[2];
		setpoint(xm[3],ym[3]);
		xm3[1]=(int)((LPX-WX1)*FACTX+VX1);
        ym3[1]=(int)((WY2-LPY)*FACTY+VY1);
		g.fillPolygon(xm2,ym2,3);
		g.drawPolygon(xm3,ym3,3);
	}
	public void setString(String st, double x,double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		y1= y1 + size/2;
		g.drawString(st,(int)x1,(int)y1);
	}
}


