import java.lang.Math;


// 矢印、X,Yポイント設定Class

class ArrowSetpoint{
	double  x1;
	double  y1;
	double  x2;
	double  y2;
	double rad = 180/Math.PI;
	int r1set, r2set;
	double set;

	public ArrowSetpoint(){
		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 0.0;
		double y2 = 0.0;
		r1set = 20;                 // 角度調整 x1,y1
		r2set = 20;                 // 角度調整 x2,y2
		//set = 10;                   // 矢印の長さ調整
	}
	public ArrowSetpoint(double i){
		set = i;
	}
	public void set(double xx1,double yy1,double xx2, double yy2){
		if(yy2 <= 29){
			set = 0.1;
		}else{
			set = 10;
		}
		double r,r1,r2;
		double a;
		double newx, newy;
		newx = xx2 - xx1;
		newy = yy2 - yy1;
		System.out.println("I AM IN SET ");
		a = newy / newx;
		r = Math.atan(a)*rad;
		r1 = (r + r1set);
		r2 = (r - r2set);
		r1 = r1/rad;
		r2 = r2/rad;
		y1 = set*(Math.sin(r1));
		y2 = set*(Math.sin(r2));
		x1 = set*(Math.cos(r1));
		x2 = set*(Math.cos(r2));

		if(xx1 == xx2 && yy1 == yy2){
			x1 = 0.0;
			y1 = 0.0;
			x2 = 0.0;
			y2 = 0.0;
		}
		else if(xx2 > xx1 && yy2 > yy1 || xx2 > xx1 && yy2 < yy1
		        || xx1 == xx2 || yy1 == yy2 && xx2 > xx1){
			x1 = x1*(-1);
			y1 = y1*(-1);
			x2 = x2*(-1);
			y2 = y2*(-1);
		}
		else{
		}
		System.out.println("I AM IN ARROWCLASSYY1YY2" + y1 +"   "+y2);
	}
}