import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;

class TreeCanvas extends Canvas implements MouseListener{
	Image TI;
	
	String SimSti = "";
	String Codei = "";
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
	final static int sx = 30;
	final static int sy = 8;
	
	final static int DATANUM = 61;
	
	int UnitX[] = new int[70];
	int UnitY[] = new int[70];
	int UnitLine[] = new int[70];
	
	String Unit[] = new String[70];
	String SplitSim[] = new String[70];
	
	boolean viewflag[] = new boolean[70];
	
	public TreeCanvas(Image img){
		TI = img;
		addMouseListener(this);
		setUpData();
		for(int i =0; i<70; i++){
			viewflag[i] = false;
		}
	}
	
	public void SetData(String SimSt, String Code){
		this.SimSti = SimSt;
		this.Codei = Code;
		repaint();
	}
	public void DClean(){
		SimSti = "";
		repaint();
	}
	
	public void paint(Graphics g){
		int i;
		int count;
		int SplitInt;
		
		// g.drawImage(TI,0,0,400,400,this);
		g.setFont(new Font("Dialog",Font.PLAIN | Font.BOLD,9));
		g.setColor(Color.white);
		Tr = new TreeDrawMaker(g);
		Tr.window(-10,-10,330,300);   // 4,-20,324,300
		Tr.view(0,0,400,400);
		g.fillRect(0,0,400,400);
		
		for(i=1;i<DATANUM;i++){
			g.setColor(Color.black);
			SplitInt = i;
			if(viewflag[i] != true){
				if(SplitInt == 1){
					Tr.setString("" + Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
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
				// Tr.point(UnitX[SplitInt],UnitY[SplitInt]);
			}
		}
		
		if(SimSti.equals("")){
			g.setFont(new Font("Serif",Font.PLAIN | Font.BOLD,10));
			g.setColor(Color.white);
			
		}else{
			i = 0;
			StringTokenizer st = new StringTokenizer(SimSti,"-");
			while(st.hasMoreTokens()){
				SplitSim[i] = st.nextToken();
				i++;
			}
			g.setColor(Color.red);
			g.setFont(new Font("Serif",Font.ITALIC + Font.BOLD,10));
			count = i;
			for(i=0;i<count;i++){
				SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				if(SplitInt == 1){
					Tr.setString("" + Unit[SplitInt],UnitX[SplitInt],UnitY[SplitInt]);
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
	}
	
	public void mouseClicked(MouseEvent e){
		int x,y;
		x = Tr.graphX(e.getX());
		y = Tr.graphY(e.getY());
		if(300 <=x && 300+sx >= x)
			if(150 <=y && 150+sy >= y){
				if(viewflag[1] == true){
					viewflag[1] = false;
				}else{
					viewflag[1] = true;
				}
			}
		if(260 <= x && 260+sx >=x)
			if(150 <=y && 150+sy >= y){
				if(viewflag[1] == true){
					viewflag[1] = false;
				}else{
					viewflag[1] = true;
				}
			}
		for(int i = 1; i<=DATANUM; i++){
			if((UnitX[i]) <= x && (UnitX[i]+sx) >=x){
				if((UnitY[i]-sy/2) <= y && (UnitY[i]+sy/2) >=y){
					if(viewflag[i] == true){
						viewflag[i] = false;
					}else{
						viewflag[i] = true;
					}
					
					System.out.print((UnitX[i]) + " - " + (UnitY[i]+sy/2) + ":");
					System.out.println((UnitX[i]+sx) + " - " + (UnitY[i]+sy/2));
				}
			}
		}
		
		SimSti = "";
		for(int i = 1; i<=DATANUM; i++){
			if(viewflag[i] == true){
				if(SimSti.equals("")){
					SimSti = "" + i;
				}else{
					SimSti = SimSti + "-" + i;
				}
			}
		}
		repaint();
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	
	public void setUpData(){
		
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
		UnitX[1] = sss1; UnitY[1] = 150; Unit[1]= "ManƒÀGlcNƒÀGlcN-PA"; UnitLine[1] = 1;
		UnitX[2] = sss2; UnitY[2] = 170; Unit[2]= "Fucƒ¿1,6"; UnitLine[2] = 69;
		UnitX[3] = sss2; UnitY[3] = 130; Unit[3]= "Fucƒ¿1,3"; UnitLine[3] = 69;
		UnitX[4] = ss0; UnitY[4] = 230; Unit[4]= "Manƒ¿1,6"; UnitLine[4] = 0;
		UnitX[5] = ss0; UnitY[5] = 160; Unit[5]= "GlcNƒÀ1,4"; UnitLine[5] = 0;
		UnitX[6] = ss0; UnitY[6] = 140; Unit[6]= "XylƒÀ1,2"; UnitLine[6] = 0;
		UnitX[7] = ss0; UnitY[7] = 60; Unit[7]= "Manƒ¿1,3"; UnitLine[7] = 0;
		UnitX[8] = ss1; UnitY[8] = 290; Unit[8]= "Manƒ¿1,6"; UnitLine[8] = 4;
		UnitX[9] = ss1; UnitY[9] = 270; Unit[9]= "GlcNƒÀ1,6"; UnitLine[9] = 4;
		UnitX[10] = ss1; UnitY[10] = 240; Unit[10]= "GlcNƒÀ1,4"; UnitLine[10] = 4;
		UnitX[11] = ss1; UnitY[11] = 220; Unit[11]= "Manƒ¿1,3"; UnitLine[11] = 4;
		UnitX[12] = ss1; UnitY[12] = 190; Unit[12]= "GlcNƒÀ1,2"; UnitLine[12] = 4;
		UnitX[13] = ss1; UnitY[13] = 120; Unit[13]= "GlcNƒÀ1,4"; UnitLine[13] = 7;
		UnitX[14] = ss1; UnitY[14] = 60; Unit[14]= "GlcNƒÀ1,2"; UnitLine[14] = 7;
		UnitX[15] = ss1; UnitY[15] = 0; Unit[15]= "Manƒ¿1,2"; UnitLine[15] = 7;
		UnitX[16] = ss2; UnitY[16] = 290; Unit[16]= "Manƒ¿1,2"; UnitLine[16] = 8;
		UnitX[17] = ss2; UnitY[17] = 280; Unit[17]= "GalƒÀ1,4"; UnitLine[17] = 9;
		UnitX[18] = ss2; UnitY[18] = 270; Unit[18]= "GalNƒÀ1,4"; UnitLine[18] = 9;
		UnitX[19] = ss2; UnitY[19] = 220; Unit[19]= "Manƒ¿1,2"; UnitLine[19] = 11;
		UnitX[20] = ss2; UnitY[20] = 200; Unit[20]= "Fucƒ¿1,6"; UnitLine[20] = 12;
		UnitX[21] = ss2; UnitY[21] = 190; Unit[21]= "GalƒÀ1,4"; UnitLine[21] = 12;
		UnitX[22] = ss2; UnitY[22] = 180; Unit[22]= "GalNƒÀ1,4"; UnitLine[22] = 12;
		UnitX[23] = ss2; UnitY[23] = 130; Unit[23]= "NeuAcƒ¿2,6"; UnitLine[23] = 13;
		UnitX[24] = ss2; UnitY[24] = 120; Unit[24]= "GalƒÀ1,4"; UnitLine[24] = 13;
		UnitX[25] = ss2; UnitY[25] = 110; Unit[25]= "Fucƒ¿1,3"; UnitLine[25] = 13;
		UnitX[26] = ss2; UnitY[26] = 100; Unit[26]= "GalƒÀ1,3"; UnitLine[26] = 13;
		UnitX[27] = ss2; UnitY[27] = 70; Unit[27]= "Fucƒ¿1,4"; UnitLine[27] = 14;
		UnitX[28] = ss2; UnitY[28] = 60; Unit[28]= "GalƒÀ1,4"; UnitLine[28] = 14;
		UnitX[29] = ss2; UnitY[29] = 50; Unit[29]= "GalNƒÀ1,4"; UnitLine[29] = 14;
		UnitX[30] = ss2; UnitY[30] = 0; Unit[30]= "Manƒ¿1,2"; UnitLine[30] = 15;
		UnitX[31] = ss3; UnitY[31] = 280; Unit[31]= "NeuAcƒ¿2,4"; UnitLine[31] = 17;
		UnitX[32] = ss3; UnitY[32] = 270; Unit[32]= "NeuAcƒ¿2,3"; UnitLine[32] = 17;
		UnitX[33] = ss3; UnitY[33] = 260; Unit[33]= "GlcNƒÀ1,3"; UnitLine[33] = 17;
		UnitX[34] = ss3; UnitY[34] = 220; Unit[34]= "NeuGcƒ¿2,6"; UnitLine[34] = 21;
		UnitX[35] = ss3; UnitY[35] = 210; Unit[35]= "NeuAcƒ¿2,6"; UnitLine[35] = 21;
		UnitX[36] = ss3; UnitY[36] = 200; Unit[36]= "NeuAcƒ¿2,3"; UnitLine[36] = 21;
		UnitX[37] = ss3; UnitY[37] = 190; Unit[37]= "NeuGcƒ¿2,3"; UnitLine[37] = 21;
		UnitX[38] = ss3; UnitY[38] = 180; Unit[38]= "Galƒ¿1,3"; UnitLine[38] = 21;
		UnitX[39] = ss3; UnitY[39] = 170; Unit[39]= "GlcNƒÀ1,3"; UnitLine[39] = 21;
		UnitX[40] = ss3; UnitY[40] = 140; Unit[40]= "NeuAcƒ¿2,6"; UnitLine[40] = 24;
		UnitX[41] = ss3; UnitY[41] = 130; Unit[41]= "NeuAcƒ¿2,3"; UnitLine[41] = 24;
		UnitX[42] = ss3; UnitY[42] = 120; Unit[42]= "Galƒ¿1,3"; UnitLine[42] = 24;
		UnitX[43] = ss3; UnitY[43] = 100; Unit[43]= "NeuAcƒ¿2,3"; UnitLine[43] = 26;
		UnitX[44] = ss3; UnitY[44] = 90; Unit[44]= "Galƒ¿1,3"; UnitLine[44] = 26;
		UnitX[45] = ss3; UnitY[45] = 80; Unit[45]= "NeuGcƒ¿2,6"; UnitLine[45] = 28;
		UnitX[46] = ss3; UnitY[46] = 70; Unit[46]= "NeuAcƒ¿2,6"; UnitLine[46] = 28;
		UnitX[47] = ss3; UnitY[47] = 60; Unit[47]= "NeuAcƒ¿2,3"; UnitLine[47] = 28;
		UnitX[48] = ss3; UnitY[48] = 50; Unit[48]= "Galƒ¿1,3"; UnitLine[48] = 28;
		UnitX[49] = ss3; UnitY[49] = 40; Unit[49]= "GlcNƒÀ1,3"; UnitLine[49] = 28;
		UnitX[50] = ss3; UnitY[50] = 30; Unit[50]= "Fucƒ¿1,2"; UnitLine[50] = 28;
		UnitX[51] = ss3; UnitY[51] = 0; Unit[51]= "Glcƒ¿1,3"; UnitLine[51] = 30;
		UnitX[52] = ss4; UnitY[52] = 260; Unit[52]= "GalƒÀ1,4"; UnitLine[52] = 33;
		UnitX[53] = ss4; UnitY[53] = 170; Unit[53]= "GalƒÀ1,4"; UnitLine[53] = 39;
		UnitX[54] = ss4; UnitY[54] = 40; Unit[54]= "GalƒÀ1,4"; UnitLine[54] = 49;
		UnitX[55] = sss3; UnitY[55] = 170; Unit[55]= "GalƒÀ1,4"; UnitLine[55] = 2;
		UnitX[56] = ss2; UnitY[56] = 240; Unit[56]= "GalƒÀ1,4"; UnitLine[56] = 10;
		UnitX[57] = ss3; UnitY[57] = 290; Unit[57]= "Galƒ¿1,4"; UnitLine[57] = 17;
		UnitX[58] = ss3; UnitY[58] = 240; Unit[58]= "Galƒ¿1,4"; UnitLine[58] = 56;
		UnitX[59] = ss3; UnitY[59] = 160; Unit[59]= "Galƒ¿1,4"; UnitLine[59] = 21;
		UnitX[60] = ss3; UnitY[60] = 110; Unit[60]= "Galƒ¿1,4"; UnitLine[60] = 24;
		UnitX[61] = ss3; UnitY[61] = 20; Unit[61]= "Galƒ¿1,4"; UnitLine[61] = 28;
		//UnitX[62] = -1; UnitY[62] = -1; Unit[62]= "?"; UnitLine[62] = 1;
		//UnitX[63] = -1; UnitY[63] = -1; Unit[63]= "?"; UnitLine[63] = 1;
		//UnitX[64] = -1; UnitY[64] = -1; Unit[64]= "?"; UnitLine[64] = 1;
		//UnitX[65] = -1; UnitY[65] = -1; Unit[65]= "?"; UnitLine[65] = 1;
		//UnitX[66] = -1; UnitY[66] = -1; Unit[66]= "?"; UnitLine[66] = 1;
		//UnitX[67] = -1; UnitY[67] = -1; Unit[67]= "?"; UnitLine[67] = 1;
		//UnitX[68] = -1; UnitY[68] = -1; Unit[68]= "?"; UnitLine[68] = 1;
		UnitX[69] = sss4; UnitY[69] = 150;
	}
}