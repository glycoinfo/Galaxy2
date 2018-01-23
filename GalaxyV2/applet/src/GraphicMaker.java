// ------------------------------------
// *     Tree Draw Turtle graphics     *
// ------------------------------------

import java.awt.*;

class GraphicMaker {
    public double Angle,             // 現在角
                  LPX,LPY;           // 現在位置
    private double WX1,WY1,WX2,WY2,  // ワールド座標
                   VX1,VY1,VX2,VY2,  // ビュー座標
                   FACTX,FACTY;      // 倍率

	public double size;

    private Graphics g;
	int milterlimita;                //点線 プロット
	int milterlimitb;                //点線 空白

    public GraphicMaker(Graphics gg) {
        g=gg;
        Angle=0;
        LPX=LPY=0;
        window(0,0,400,400);
        view(0,0,400,400);
		milterlimita = 7;
		milterlimitb = 7;
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

	public void dotted_line(double x1, double y1, double x2, double y2){

		double xx1,yy1,xx2,yy2,sax,say;
		double r;
		double px1,py1,px2,py2;
		int count= 0;
		xx1=(x1-WX1)*FACTX+VX1;
		yy1=(WY2-y1)*FACTY+VY1;
        xx2=(x2-WX1)*FACTX+VX1;
        yy2=(WY2-y2)*FACTY+VY1;
		//g.drawLine((int)xx1,(int)yy1,(int)xx2,(int)yy2);
		sax = xx2 -xx1;
		say = yy2 -yy1;
		r = Math.atan((say/sax));
		//System.out.println("θ = " + r);
		//System.out.println(sax + " " + say);

		//milterlimit PaintYes
		py1 = (milterlimita*(Math.sin(r)));
		px1 = (milterlimita*(Math.cos(r)));
		//milterlimit PaintNo
		py2 = (milterlimitb*(Math.sin(r)));
		px2 = (milterlimitb*(Math.cos(r)));
		if(sax > 0){
			for(count = 0; xx2 > xx1; count++){
				if(count % 2 == 0){
					if((xx1 + px1) > xx2){
						g.drawLine((int)xx1,(int)yy1,(int)xx2,(int)yy2);
					}else{
						g.drawLine((int)xx1,(int)yy1,(int)(xx1 + px1),(int)(yy1 + py1));
					}
					xx1 = xx1 + px1;
					yy1 = yy1 + py1;
				}
				else{
					xx1 = xx1 + px2;
					yy1 = yy1 + py2;
				}
			}
		}
		else if(sax < 0){
			for(count = 0; xx2 < xx1; count++){
				if(count % 2 == 0){
					if((xx1 - px1) < xx2){
						g.drawLine((int)xx1,(int)yy1,(int)xx2,(int)yy2);
					}else{
						g.drawLine((int)xx1,(int)yy1,(int)(xx1 - px1),(int)(yy1 - py1));
					}
					xx1 = xx1 - px1;
					yy1 = yy1 - py1;
				}
				else{
					xx1 = xx1 - px2;
					yy1 = yy1 - py2;
				}
			}
		}else{
			if(yy2 > yy1){
				for(count = 0; yy2 > yy1; count++){
					if(count % 2 == 0){
						if((yy1 + py1) > yy2){
							g.drawLine((int)xx1,(int)yy1,(int)xx2,(int)yy2);
						}else{
							g.drawLine((int)xx1,(int)yy1,(int)(xx1 + px1),(int)(yy1 + py1));
						}
						xx1 = xx1 + px1;
						yy1 = yy1 + py1;
					}
					else{
						xx1 = xx1 + px2;
						yy1 = yy1 + py2;
					}
				}
			}else if(yy2 < yy1){
				for(count = 0; yy2 < yy1; count++){
					if(count %2 == 0){
						if((yy1 + py1) < yy2){
							g.drawLine((int)xx1,(int)yy1,(int)xx2,(int)yy2);
						}else{
							g.drawLine((int)xx1,(int)yy1,(int)(xx1 + px1),(int)(yy1 + py1));
						}
						xx1 = xx1 + px1;
						yy1 = yy1 + py1;
					}
					else{
						xx1 = xx1 + px2;
						yy1 = yy1 + py2;
					}
				}
			}else{
				//System.out.println("ELSE");
			}
		}
	}

    public void turn(double a) {
        Angle=Angle+a;
        Angle=Angle-(int)Angle+((int)Angle % 360);
    }

    public void setangle(double a) {
        Angle=a;
    }

	public double graphX(int x){
		double ansx;
		double lpx;
		lpx = (x-VX1)/FACTX + WX1;
		ansx = lpx;
		return ansx;
	}
	public double graphY(int y){
		double lpy;
		double ansy;
		lpy = WY2-((y-VY1)/FACTY);
		ansy = lpy;
		return ansy;
	}
	public int graphX2(double x){
		int x2;
		x2=(int)((x-WX1)*FACTX+VX1);
		return x2;
	}
	public int graphY2(double y){
		int y2;
		y2=(int)((WY2-y)*FACTY+VY1);
		return y2;
	}


/*	public void setcolor(int i){
		if (i == 0)
			g.setColor(Color.black);
		else if (i == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
	}*/

	public void setsize(double size){
		this.size = size;
	}
	public void point(double x, double y){
		setpoint(x,y);
		double x1,y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
        x1 = x1 - size/2;
        y1 = y1 - size/2;
		g.fillOval((int)x1,(int)y1,(int)size,(int)size);
	}

	public void writeString(String s, double x, double y){
		setpoint(x,y);
		double x1, y1;
		x1=(LPX-WX1)*FACTX+VX1;
        y1=(WY2-LPY)*FACTY+VY1;
		g.drawString(s,(int)x1,(int)y1);
		System.out.println(s);
	}
}


