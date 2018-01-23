import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.*;

class TDCanvas extends Canvas implements MouseListener{
	int x,y=-20;
	int type =0;
	double ODS;
	double Amide;
	double Mw;
	int setX,setY;
	int dataset;
	String SimSti = "";
	String Codei = "";
	int UnitX[] = new int[70];
	int UnitY[] = new int[70];
	int UnitLine[] = new int[70];
	String Unit[] = new String[70];
	String SplitSim[] = new String[61];
	TreeDrawMaker Tr;

	final static int s0 = 200; //200  //160
	final static int s1 = 155; //220  //130
	final static int s2 = 110; //190   //90
	final static int s3 = 60; //160   //40
	final static int s4 = 25;  //130  //20
	final static int ss1 =270; //270
	final static int ss2 =290; //230
	final static int ss3 =250; //210
	final static int ss4 =290;
	final static int ss5 =250;
	final static int datanum = 61;
	final static int size1 = 6;
	final static int sz = size1/2;

	public TDCanvas(){
		setX = 360;
		setY = 265;
		setBounds(0,0,setX,setY);
		setUpData2();
		setFont(new Font("Time New Roman",Font.ITALIC,10));  //Time New Roman
		addMouseListener(this);
	}
	
	public void GraphType(int i){
		type = i;
		switch (i){
			case 2 :
				setUpData();
			break;
			case 1 :
				setUpData();
			break;
			case 0:
				setUpData2();
			break;
			default:
		}
		repaint();
	}
	public void SetData(String SimSt ,String Code){
		//System.out.println(SimSt);
		this.SimSti = SimSt;
		this.Codei = Code;
		repaint();
	}
	public void DClean(){
		SimSti = "";
		repaint();
	}
	public void PlotSize(int X,int Y){
		this.setX = X;
		this.setY = Y;
		setBounds(0,0,setX,setY);
	}

	public void paint(Graphics g){
		int i;
		int count;
		int SplitInt;
		g.setFont(new Font("Time New Roman",Font.PLAIN,10));
		g.setColor(Color.red);
		g.drawRect(0,0,setX-2,setY-6);
		if(!SimSti.equals("")){
			switch(type){
				case 0:
						g.setColor(Color.black);
						g.setFont(new Font("Time New Roman",Font.PLAIN,12));
						g.drawString("Code : " + Codei,240,250);
				break;
				
				case 1:
					g.setColor(Color.black);
					g.setFont(new Font("Time New Roman",Font.PLAIN,12));
					if(dataset > 0) {
						g.drawString(dataset + " : " + Unit[dataset],10,250);
					}
					g.setFont(new Font("Time New Roman",Font.PLAIN,12));
					g.drawString("Code : " + Codei,240,250);
				break;
			
				case 2:
					g.setColor(Color.black);
					g.setFont(new Font("Time New Roman",Font.PLAIN,12));
					if(dataset > 0) {
						g.drawString(dataset + " : " + Unit[dataset],10,250);
					}
					g.setFont(new Font("Time New Roman",Font.PLAIN,12));
					g.drawString("Code : " + Codei,240,250);
				break;
				
				default:
				break;
			}
		}
		
		g.setColor(Color.blue);
		g.setFont(new Font("Time New Roman",Font.PLAIN,10));
		Tr = new TreeDrawMaker(g);
		Tr.window(4,-20,324,300); //ポイントサイズ決定
		Tr.view(0,0,setX,setY-30);
		switch(type){
			case 2:

				if(SimSti.equals("")){
					g.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,20));
					Tr.setString("TreeView Type 3" ,100,150);
				}
				else{
					Tr.setsize(7);
					Tr.point2(ss4,150);
					Tr.point2(ss5,150);
					for(i = 1; i <=datanum; i ++){
						Tr.point2(UnitX[i],UnitY[i]);
					}
					g.setColor(Color.blue);
					i = 0;
					StringTokenizer st = new StringTokenizer(SimSti,"-");
					while(st.hasMoreTokens())
					{
						SplitSim[i] = st.nextToken();
						i++;
					}
					count = i;
					for(i=0;i<count;i++){
						SplitInt = Integer.valueOf(SplitSim[i]).intValue();
						if(SplitInt == 1){
							//Tr.setString("-PA",UnitX[SplitInt]+28,UnitY[SplitInt]);
							Tr.point(UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt],UnitX[0],UnitY[0]);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt],UnitX[69],UnitY[69]);
							Tr.point(ss4,150);
							Tr.point(ss5,150);
						}
						else{
							Tr.point(UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt],UnitX[UnitLine[SplitInt]],UnitY[UnitLine[SplitInt]]);
						}
					}
				}
				break;

			case 1:
				int ka = 0;
				int kb = 0;
				String number;
				if(SimSti.equals("")){
					g.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,20));
					Tr.setString("TreeView Type 2",100,150);
				}
				else{
					g.setColor(Color.blue);
					i = 0;
					StringTokenizer st = new StringTokenizer(SimSti,"-");
					while(st.hasMoreTokens())
					{
						SplitSim[i] = st.nextToken();
						i++;
					}
					count = i;
					for(i=0;i<count;i++){
						Tr.setsize(8);
						SplitInt = Integer.valueOf(SplitSim[i]).intValue();
						if(SplitInt == 1){
							//Tr.setString("-PA",UnitX[SplitInt]+28,UnitY[SplitInt]);
							Tr.glcnac(UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt],UnitX[0],UnitY[0]);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt],UnitX[69],UnitY[69]);
							Tr.glcnac(ss4,150);
							Tr.man(ss5,150);
						}
						else if(SplitInt == 2){
							Tr.fuc(UnitX[SplitInt],UnitY[SplitInt]);
							Tr.setString("α1,6",UnitX[SplitInt]+5,UnitY[SplitInt]+3);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt]-5,UnitX[UnitLine[SplitInt]],UnitY[UnitLine[SplitInt]]+5);
						}
						else if(SplitInt == 3){
							Tr.fuc(UnitX[SplitInt],UnitY[SplitInt]);
							Tr.setString("α1,3",UnitX[SplitInt]+5,UnitY[SplitInt]+3);
							Tr.line(UnitX[SplitInt],UnitY[SplitInt]+5,UnitX[UnitLine[SplitInt]],UnitY[UnitLine[SplitInt]]-5);
						}
						else{
							ka = Unit[SplitInt].indexOf("α");
							kb = Unit[SplitInt].indexOf("β");
							if(ka > -1){
								number = Unit[SplitInt].substring(ka);
								Tr.setString(""+number,UnitX[SplitInt]+5,UnitY[SplitInt]+3);
							}
							else{
								number = Unit[SplitInt].substring(kb);
								Tr.setString(""+number,UnitX[SplitInt]+5,UnitY[SplitInt]+3);
							}

							if(Unit[SplitInt].startsWith("Fuc")){
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.fuc(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("GalN")){
								Tr.setsize(7);
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.galnac(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("Gal")){
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.gal(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("GlcN")){
								Tr.setsize(7);
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.glcnac(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("Glc")){
								Tr.setsize(10);
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.glc(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("NeuAc")){
								Tr.setsize(10);
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.neuac(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("NeuGc")){
								Tr.setsize(10);
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.neugc(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("Man")){
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.man(UnitX[SplitInt],UnitY[SplitInt]);
							}
							else if(Unit[SplitInt].startsWith("Xyl")){
								Tr.line(UnitX[SplitInt]+25,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-5,UnitY[UnitLine[SplitInt]]);
								Tr.xyl(UnitX[SplitInt],UnitY[SplitInt]);
							}
						}
					}
				}

				break;
			case 0:
				if(SimSti.equals("")){
					g.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,20));
					Tr.setString("TreeView Type 1",100,150);
				}
				else{
					i = 0;
					StringTokenizer st = new StringTokenizer(SimSti,"-");
					while(st.hasMoreTokens())
					{
						SplitSim[i] = st.nextToken();
						i++;
					}
					count = i;
					for(i=0;i<count;i++){
						g.setColor(Color.blue);
						SplitInt = Integer.valueOf(SplitSim[i]).intValue();
						if(SplitInt == 1){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
						}
						else if(SplitInt == 2){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+29,UnitY[SplitInt]-5,UnitX[UnitLine[SplitInt]]+29,UnitY[UnitLine[SplitInt]]+ 6);
						}
						else if(SplitInt == 3){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+29,UnitY[SplitInt]+5,UnitX[UnitLine[SplitInt]]+29,UnitY[UnitLine[SplitInt]]- 6);
						}
						else if(SplitInt == 23){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+40,UnitY[SplitInt]-4,UnitX[UnitLine[SplitInt]]-1,UnitY[UnitLine[SplitInt]]);
						}
						else if(SplitInt >=52 && SplitInt <=55){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+35,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-1,UnitY[UnitLine[SplitInt]]);
						}
						else if(SplitInt >=31 && SplitInt <=51 || SplitInt >= 57 && SplitInt <=61){
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+46,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-1,UnitY[UnitLine[SplitInt]]);
						}
						else{
							Tr.setString(""+ Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
							Tr.line(UnitX[SplitInt]+40,UnitY[SplitInt],UnitX[UnitLine[SplitInt]]-1,UnitY[UnitLine[SplitInt]]);
						}
					}
				}
				break;
			default:
				break;
		}
	}
	public void mouseClicked(MouseEvent e){
		int i,j;
		dataset = 0;
		x = Tr.graphX(e.getX());
		y = Tr.graphY(e.getY());
		i = j = 1;
		if(ss4-sz <=x && ss4+sz >= x)
			if(150-sz <=y && 150+sz >= y)
				dataset = 1;
		if(ss5-sz <= x && ss5+sz >=x)
			if(150-sz <=y && 150+sz >= y)
				dataset = 1;
		for(i = 1; i<=datanum; i++){
			if(UnitX[i]-sz <= x && UnitX[i]+sz >=x){
				if(UnitY[i]-sz <= y && UnitY[i]+sz >=y){
					dataset = i;
				}
			}
		}
		repaint();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void setUpData2(){
		/*final static int s0 = 200;
		final static int s1 = 155;
		final static int s2 = 110;
		final static int s3 = 60;
		final static int s4 = 20;
		final static int ss1 = 270;
		final static int ss2 = 290;
		final static int ss3 = 250;
		final static int ss4 = 290;
		final static int ss5 = 250;
		*/
		int sa = 20;
		int sss5 = ss5 - sa;
		int sss4 = ss4 - sa;
		int sss3 = ss3 - sa;
		int sss2 = ss2 - sa;
		//int sss1 = ss1 - sa;
		int sss1 = 230;
		int ss4 = s4 -sa;
		int ss3 = s3 -sa;
		int ss2 = s2 -sa;
		int ss1 = s1 -sa;
		int ss0 = s0 -sa;
		UnitX[0] = sss5; UnitY[0] = 150;
		UnitX[1] = sss1; UnitY[1] = 150; Unit[1]= "ManβGlcNβGlcN-PA"; UnitLine[1] = 1;
		UnitX[2] = sss2; UnitY[2] = 170; Unit[2]= "Fucα1,6"; UnitLine[2] = 69;
		UnitX[3] = sss2; UnitY[3] = 130; Unit[3]= "Fucα1,3"; UnitLine[3] = 69;
		UnitX[4] = ss0; UnitY[4] = 230; Unit[4]= "Manα1,6"; UnitLine[4] = 0;
		UnitX[5] = ss0; UnitY[5] = 160; Unit[5]= "GlcNβ1,4"; UnitLine[5] = 0;
		UnitX[6] = ss0; UnitY[6] = 140; Unit[6]= "Xylβ1,2"; UnitLine[6] = 0;
		UnitX[7] = ss0; UnitY[7] = 80; Unit[7]= "Manα1,3"; UnitLine[7] = 0;
		UnitX[8] = ss1; UnitY[8] = 260; Unit[8]= "Manα1,6"; UnitLine[8] = 4;
		UnitX[9] = ss1; UnitY[9] = 260; Unit[9]= "GlcNβ1,6"; UnitLine[9] = 4;
		UnitX[10] = ss1; UnitY[10] = 230; Unit[10]= "GlcNβ1,4"; UnitLine[10] = 4;
		UnitX[11] = ss1; UnitY[11] = 210; Unit[11]= "Manα1,3"; UnitLine[11] = 4;
		UnitX[12] = ss1; UnitY[12] = 180; Unit[12]= "GlcNβ1,2"; UnitLine[12] = 4;
		UnitX[13] = ss1; UnitY[13] = 130; Unit[13]= "GlcNβ1,4"; UnitLine[13] = 7;
		UnitX[14] = ss1; UnitY[14] = 80; Unit[14]= "GlcNβ1,2"; UnitLine[14] = 7;
		UnitX[15] = ss1; UnitY[15] = 40; Unit[15]= "Manα1,2"; UnitLine[15] = 7;
		UnitX[16] = ss2; UnitY[16] = 260; Unit[16]= "Manα1,2"; UnitLine[16] = 8;
		UnitX[17] = ss2; UnitY[17] = 260; Unit[17]= "Galβ1,4"; UnitLine[17] = 9;
		UnitX[18] = ss2; UnitY[18] = 260; Unit[18]= "GalNβ1,4"; UnitLine[18] = 9;
		UnitX[19] = ss2; UnitY[19] = 210; Unit[19]= "Manα1,2"; UnitLine[19] = 11;
		UnitX[20] = ss2; UnitY[20] = 190; Unit[20]= "Fucα1,6"; UnitLine[20] = 12;
		UnitX[21] = ss2; UnitY[21] = 180; Unit[21]= "Galβ1,4"; UnitLine[21] = 12;
		UnitX[22] = ss2; UnitY[22] = 180; Unit[22]= "GalNβ1,4"; UnitLine[22] = 12;
		UnitX[23] = ss2; UnitY[23] = 140; Unit[23]= "NeuAcα2,6"; UnitLine[23] = 13;
		UnitX[24] = ss2; UnitY[24] = 130; Unit[24]= "Galβ1,4"; UnitLine[24] = 13;
		UnitX[25] = ss2; UnitY[25] = 110; Unit[25]= "Fucα1,3"; UnitLine[25] = 13;
		UnitX[26] = ss2; UnitY[26] = 110; Unit[26]= "Galβ1,3"; UnitLine[26] = 13;
		UnitX[27] = ss2; UnitY[27] = 90; Unit[27]= "Fucα1,4"; UnitLine[27] = 14;
		UnitX[28] = ss2; UnitY[28] = 80; Unit[28]= "Galβ1,4"; UnitLine[28] = 14;
		UnitX[29] = ss2; UnitY[29] = 80; Unit[29]= "GalNβ1,4"; UnitLine[29] = 14;
		UnitX[30] = ss2; UnitY[30] = 40; Unit[30]= "Manα1,2"; UnitLine[30] = 15;
		UnitX[31] = ss3; UnitY[31] = 260; Unit[31]= "NeuAcα2,4"; UnitLine[31] = 17;
		UnitX[32] = ss3; UnitY[32] = 250; Unit[32]= "NeuAcα2,3"; UnitLine[32] = 17;
		UnitX[33] = ss3; UnitY[33] = 250; Unit[33]= "GlcNβ1,3"; UnitLine[33] = 17;
		UnitX[34] = ss3; UnitY[34] = 190; Unit[34]= "NeuGcα2,6"; UnitLine[34] = 21;
		UnitX[35] = ss3; UnitY[35] = 190; Unit[35]= "NeuAcα2,6"; UnitLine[35] = 21;
		UnitX[36] = ss3; UnitY[36] = 180; Unit[36]= "NeuAcα2,3"; UnitLine[36] = 21;
		UnitX[37] = ss3; UnitY[37] = 180; Unit[37]= "NeuGcα2,3"; UnitLine[37] = 21;
		UnitX[38] = ss3; UnitY[38] = 170; Unit[38]= "Galα1,3"; UnitLine[38] = 21;
		UnitX[39] = ss3; UnitY[39] = 170; Unit[39]= "GlcNβ1,3"; UnitLine[39] = 21;
		UnitX[40] = ss3; UnitY[40] = 140; Unit[40]= "NeuAcα2,6"; UnitLine[40] = 24;
		UnitX[41] = ss3; UnitY[41] = 130; Unit[41]= "NeuAcα2,3"; UnitLine[41] = 24;
		UnitX[42] = ss3; UnitY[42] = 130; Unit[42]= "Galα1,3"; UnitLine[42] = 24;
		UnitX[43] = ss3; UnitY[43] = 110; Unit[43]= "NeuAcα2,3"; UnitLine[43] = 26;
		UnitX[44] = ss3; UnitY[44] = 110; Unit[44]= "Galα1,3"; UnitLine[44] = 26;
		UnitX[45] = ss3; UnitY[45] = 90; Unit[45]= "NeuGcα2,6"; UnitLine[45] = 28;
		UnitX[46] = ss3; UnitY[46] = 90; Unit[46]= "NeuAcα2,6"; UnitLine[46] = 28;
		UnitX[47] = ss3; UnitY[47] = 80; Unit[47]= "NeuAcα2,3"; UnitLine[47] = 28;
		UnitX[48] = ss3; UnitY[48] = 80; Unit[48]= "Galα1,3"; UnitLine[48] = 28;
		UnitX[49] = ss3; UnitY[49] = 80; Unit[49]= "GlcNβ1,3"; UnitLine[49] = 28;
		UnitX[50] = ss3; UnitY[50] = 70; Unit[50]= "Fucα1,2"; UnitLine[50] = 28;
		UnitX[51] = ss3; UnitY[51] = 40; Unit[51]= "Glcα1,3"; UnitLine[51] = 30;
		UnitX[52] = ss4; UnitY[52] = 250; Unit[52]= "Galβ1,4"; UnitLine[52] = 33;
		UnitX[53] = ss4; UnitY[53] = 170; Unit[53]= "Galβ1,4"; UnitLine[53] = 39;
		UnitX[54] = ss4; UnitY[54] = 80; Unit[54]= "Galβ1,4"; UnitLine[54] = 49;
		UnitX[55] = sss3; UnitY[55] = 170; Unit[55]= "Galβ1,4"; UnitLine[55] = 2;
		UnitX[56] = ss2; UnitY[56] = 230; Unit[56]= "Galβ1,4"; UnitLine[56] = 10;
		UnitX[57] = ss3; UnitY[57] = 270; Unit[57]= "Galα1,4"; UnitLine[57] = 17;
		UnitX[58] = ss3; UnitY[58] = 230; Unit[58]= "Galα1,4"; UnitLine[58] = 56;
		UnitX[59] = ss3; UnitY[59] = 160; Unit[59]= "Galα1,4"; UnitLine[59] = 21;
		UnitX[60] = ss3; UnitY[60] = 120; Unit[60]= "Galα1,4"; UnitLine[60] = 24;
		UnitX[61] = ss3; UnitY[61] = 60; Unit[61]= "Galα1,4"; UnitLine[61] = 28;
		//UnitX[62] = -1; UnitY[62] = -1; Unit[62]= "?"; UnitLine[62] = 1;
		//UnitX[63] = -1; UnitY[63] = -1; Unit[63]= "?"; UnitLine[63] = 1;
		//UnitX[64] = -1; UnitY[64] = -1; Unit[64]= "?"; UnitLine[64] = 1;
		//UnitX[65] = -1; UnitY[65] = -1; Unit[65]= "?"; UnitLine[65] = 1;
		//UnitX[66] = -1; UnitY[66] = -1; Unit[66]= "?"; UnitLine[66] = 1;
		//UnitX[67] = -1; UnitY[67] = -1; Unit[67]= "?"; UnitLine[67] = 1;
		//UnitX[68] = -1; UnitY[68] = -1; Unit[68]= "?"; UnitLine[68] = 1;
		UnitX[69] = sss4; UnitY[69] = 150;
	}
	public void setUpData(){
		UnitX[0] = ss5; UnitY[0] = 150;
		UnitX[1] = ss1; UnitY[1] = 150; Unit[1]= "Manβ1,4GlcNAcβ1,4GlcNAc-PA"; UnitLine[1] = 1;
		UnitX[2] = ss2; UnitY[2] = 170; Unit[2]= "Fucα1,6"; UnitLine[2] = 69;
		UnitX[3] = ss2; UnitY[3] = 130; Unit[3]= "Fucα1,3"; UnitLine[3] = 69;
		UnitX[4] = s0; UnitY[4] = 230; Unit[4]= "Manα1,6"; UnitLine[4] = 0;
		UnitX[5] = s0; UnitY[5] = 160; Unit[5]= "GlcNAcβ1,4"; UnitLine[5] = 0;
		UnitX[6] = s0; UnitY[6] = 140; Unit[6]= "Xylβ1,2"; UnitLine[6] = 0;
		UnitX[7] = s0; UnitY[7] = 60; Unit[7]= "Manα1,3"; UnitLine[7] = 0;
		UnitX[8] = s1; UnitY[8] = 290; Unit[8]= "Manα1,6"; UnitLine[8] = 4;
		UnitX[9] = s1; UnitY[9] = 270; Unit[9]= "GlcNAcβ1,6"; UnitLine[9] = 4;
		UnitX[10] = s1; UnitY[10] = 240; Unit[10]= "GlcNAcβ1,4"; UnitLine[10] = 4;
		UnitX[11] = s1; UnitY[11] = 220; Unit[11]= "Manα1,3"; UnitLine[11] = 4;
		UnitX[12] = s1; UnitY[12] = 190; Unit[12]= "GlcNAcβ1,2"; UnitLine[12] = 4;
		UnitX[13] = s1; UnitY[13] = 120; Unit[13]= "GlcNAcβ1,4"; UnitLine[13] = 7;
		UnitX[14] = s1; UnitY[14] = 60; Unit[14]= "GlcNAcβ1,2"; UnitLine[14] = 7;
		UnitX[15] = s1; UnitY[15] = 0; Unit[15]= "Manα1,2"; UnitLine[15] = 7;
		UnitX[16] = s2; UnitY[16] = 290; Unit[16]= "Manα1,2"; UnitLine[16] = 8;
		UnitX[17] = s2; UnitY[17] = 280; Unit[17]= "Galβ1,4"; UnitLine[17] = 9;
		UnitX[18] = s2; UnitY[18] = 270; Unit[18]= "GalNAcβ1,4"; UnitLine[18] = 9;
		UnitX[19] = s2; UnitY[19] = 220; Unit[19]= "Manα1,2"; UnitLine[19] = 11;
		UnitX[20] = s2; UnitY[20] = 200; Unit[20]= "Fucα1,6"; UnitLine[20] = 12;
		UnitX[21] = s2; UnitY[21] = 190; Unit[21]= "Galβ1,4"; UnitLine[21] = 12;
		UnitX[22] = s2; UnitY[22] = 180; Unit[22]= "GalNAcβ1,4"; UnitLine[22] = 12;
		UnitX[23] = s2; UnitY[23] = 130; Unit[23]= "NeuAcα2,6"; UnitLine[23] = 13;
		UnitX[24] = s2; UnitY[24] = 120; Unit[24]= "Galβ1,4"; UnitLine[24] = 13;
		UnitX[25] = s2; UnitY[25] = 110; Unit[25]= "Fucα1,3"; UnitLine[25] = 13;
		UnitX[26] = s2; UnitY[26] = 100; Unit[26]= "Galβ1,3"; UnitLine[26] = 13;
		UnitX[27] = s2; UnitY[27] = 70; Unit[27]= "Fucα1,4"; UnitLine[27] = 14;
		UnitX[28] = s2; UnitY[28] = 60; Unit[28]= "Galβ1,4"; UnitLine[28] = 14;
		UnitX[29] = s2; UnitY[29] = 50; Unit[29]= "GalNAcβ1,4"; UnitLine[29] = 14;
		UnitX[30] = s2; UnitY[30] = 0; Unit[30]= "Manα1,2"; UnitLine[30] = 15;
		UnitX[31] = s3; UnitY[31] = 280; Unit[31]= "NeuAcα2,4"; UnitLine[31] = 17;
		UnitX[32] = s3; UnitY[32] = 270; Unit[32]= "NeuAcα2,3"; UnitLine[32] = 17;
		UnitX[33] = s3; UnitY[33] = 260; Unit[33]= "GlcNAcβ1,3"; UnitLine[33] = 17;
		UnitX[34] = s3; UnitY[34] = 220; Unit[34]= "NeuGcα2,6"; UnitLine[34] = 21;
		UnitX[35] = s3; UnitY[35] = 210; Unit[35]= "NeuAcα2,6"; UnitLine[35] = 21;
		UnitX[36] = s3; UnitY[36] = 200; Unit[36]= "NeuAcα2,3"; UnitLine[36] = 21;
		UnitX[37] = s3; UnitY[37] = 190; Unit[37]= "NeuGcα2,3"; UnitLine[37] = 21;
		UnitX[38] = s3; UnitY[38] = 180; Unit[38]= "Galα1,3"; UnitLine[38] = 21;
		UnitX[39] = s3; UnitY[39] = 170; Unit[39]= "GlcNAcβ1,3"; UnitLine[39] = 21;
		UnitX[40] = s3; UnitY[40] = 140; Unit[40]= "NeuAcα2,6"; UnitLine[40] = 24;
		UnitX[41] = s3; UnitY[41] = 130; Unit[41]= "NeuAcα2,3"; UnitLine[41] = 24;
		UnitX[42] = s3; UnitY[42] = 120; Unit[42]= "Galα1,3"; UnitLine[42] = 24;
		UnitX[43] = s3; UnitY[43] = 100; Unit[43]= "NeuAcα2,3"; UnitLine[43] = 26;
		UnitX[44] = s3; UnitY[44] = 90; Unit[44]= "Galα1,3"; UnitLine[44] = 26;
		UnitX[45] = s3; UnitY[45] = 80; Unit[45]= "NeuGcα2,6"; UnitLine[45] = 28;
		UnitX[46] = s3; UnitY[46] = 70; Unit[46]= "NeuAcα2,6"; UnitLine[46] = 28;
		UnitX[47] = s3; UnitY[47] = 60; Unit[47]= "NeuAcα2,3"; UnitLine[47] = 28;
		UnitX[48] = s3; UnitY[48] = 50; Unit[48]= "Galα1,3"; UnitLine[48] = 28;
		UnitX[49] = s3; UnitY[49] = 40; Unit[49]= "GlcNAcβ1,3"; UnitLine[49] = 28;
		UnitX[50] = s3; UnitY[50] = 30; Unit[50]= "Fucα1,2"; UnitLine[50] = 28;
		UnitX[51] = s3; UnitY[51] = 0; Unit[51]= "Glcα1,3"; UnitLine[51] = 30;
		UnitX[52] = s4; UnitY[52] = 260; Unit[52]= "Galβ1,4"; UnitLine[52] = 33;
		UnitX[53] = s4; UnitY[53] = 170; Unit[53]= "Galβ1,4"; UnitLine[53] = 39;
		UnitX[54] = s4; UnitY[54] = 40; Unit[54]= "Galβ1,4"; UnitLine[54] = 49;
		UnitX[55] = 258; UnitY[55] = 170; Unit[55]= "Galβ1,4"; UnitLine[55] = 2;
		UnitX[56] = s2; UnitY[56] = 240; Unit[56]= "Galβ1,4"; UnitLine[56] = 10;
		UnitX[57] = s3; UnitY[57] = 290; Unit[57]= "Galα1,4"; UnitLine[57] = 17;
		UnitX[58] = s3; UnitY[58] = 240; Unit[58]= "Galα1,4"; UnitLine[58] = 56;
		UnitX[59] = s3; UnitY[59] = 160; Unit[59]= "Galα1,4"; UnitLine[59] = 21;
		UnitX[60] = s3; UnitY[60] = 110; Unit[60]= "Galα1,4"; UnitLine[60] = 24;
		UnitX[61] = s3; UnitY[61] = 20; Unit[61]= "Galα1,4"; UnitLine[61] = 28;
		//UnitX[62] = -1; UnitY[62] = -1; Unit[62]= "?"; UnitLine[62] = 1;
		//UnitX[63] = -1; UnitY[63] = -1; Unit[63]= "?"; UnitLine[63] = 1;
		//UnitX[64] = -1; UnitY[64] = -1; Unit[64]= "?"; UnitLine[64] = 1;
		//UnitX[65] = -1; UnitY[65] = -1; Unit[65]= "?"; UnitLine[65] = 1;
		//UnitX[66] = -1; UnitY[66] = -1; Unit[66]= "?"; UnitLine[66] = 1;
		//UnitX[67] = -1; UnitY[67] = -1; Unit[67]= "?"; UnitLine[67] = 1;
		//UnitX[68] = -1; UnitY[68] = -1; Unit[68]= "?"; UnitLine[68] = 1;
		UnitX[69] = ss4; UnitY[69] = 150;
	}
}
