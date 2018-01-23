

/********************************************************************************/
//             Oligosaccharide Enzyme Rule
//
//    Type 0 : ƒ¿-Galactosidase
//    Type 1 : ƒ¿-Fucsidase
//    Type 2 : ƒÀ-Galactosidase
//    Type 3 : ƒÀ-hexosaminidase
//    Type 4 : Xylosidase
//    Type 5 : Sialidase
//
/*********************************************************************************/

import java.io.*;
import java.util.*;


class rule{

	final double ErrorCode = 99.9;
	final int DATAN = 65;
	final int MAXSimSt = 65;  //25
	final int BACKMAX = 2000;
	final int PATTERN = 13;

	double ODSData[] = new double[DATAN];
	double AmideData[] = new double[DATAN];
	double MwData[] = new double[DATAN];
	double ErrOData[] = new double[DATAN];
	double ErrAData[] = new double[DATAN];
	String BackSt[] = new String[BACKMAX];
	double BackMw[] = new double[BACKMAX];
	double BackODS[] = new double[BACKMAX];
	double BackAmide[] = new double[BACKMAX];
	double BackErrO[] = new double[BACKMAX];
	double BackErrA[] = new double[BACKMAX];
	int quicktarget[] = new int[MAXSimSt];
	int quickN;
	String quickString;
	String sa[] = new String[PATTERN];
	int Checker[] = new int[PATTERN + 1];
	int DATACOUNTER;
	double inMW;
	double inODS;
	double inAmide;
	double outErrO;
	double outErrA;
	double counter;
	String inSimSt;

	public void dataClean(){
		inMW = 0.0;
		inODS = 0.0;
		inAmide = 0.0;
		inSimSt = "";
		outErrO = 0.0;
		outErrA = 0.0;
		counter = 0.0;
	}
	public void printdata(){
//		System.out.println(inSimSt + " " + inODS + " " + inAmide + " " + inMW+ " "+ outErrO +" "+ outErrA);
	}
	public rule(){
		//System.out.println("rule2");
		SetData();
		//57,58,38,59,42,60,44,48,61
		//boolean b = rule("1-2-3-4-5-6-59-44-48-62",inODS,inAmide,inMW,outErrO,outErrA,0);
		//boolean c = AGalactosidase("1-2-3-4-5-6-7",inODS,inAmide,inMW,outErrO,outErrA);
		//System.out.println(inSimSt + " " + inODS + " " + inAmide + " " + inMW+ " "+ outErrO +" "+ outErrA);
	}
	public boolean rule(String SimStM,double ODSM,double AmideM, double MWM, double outErrOM,double outErrAM,int type){
		boolean boo;
		boo = false;
		switch (type){
			case 0:
				boo = AGalactosidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 1:
				boo = AFucsidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 2:
				boo = BGalactosidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 3:
				boo = Bhexosaminidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 4:
				boo = Xylosidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 5:
				boo = Sialidase(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			default :
				System.out.println("ERROR Enzyme TYPE!!");
		}

		return boo;
	}
	public boolean ruleback(String SimStM,double ODSM,double AmideM, double MWM,double outErrOM,double outErrAM,int type) {
		boolean boo;
		boo = false;
		for(int i = 0; i< BACKMAX; i++){
			BackSt[i] = "";
			BackMw[i] = 0.0;
			BackODS[i] = 0.0;
			BackAmide[i] = 0.0;
			BackErrO[i] = 0.0;
			BackErrA[i] = 0.0;
		}
		switch (type){
			case 0:
				boo = AGalactosidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 1:
				boo = AFucsidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 2:
				boo = BGalactosidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 3:
				boo = BhexosaminidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 4:
				boo = XylosidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			case 5:
				boo = SialidaseBack(SimStM,ODSM,AmideM,MWM,outErrOM,outErrAM);
				break;
			default :
				System.out.println("ERROR Enzyme TYPE!!");
		}
		return boo;
	}

	// FORWARD ENZYME ROLE //////////////////////////////////////////////////////////////////////////////////////////////

	public boolean AGalactosidase(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){

		int i=0,count;
		int SplitInt;
		boolean boo;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			switch (SplitInt){
			case 57:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[57];
				AmideM = AmideM - AmideData[57];
				MwM = MwM - MwData[57];
				ErrOM = ErrOM + ErrOData[57];
				ErrAM = ErrAM + ErrAData[57];
				break;
			case 58:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[58];
				AmideM = AmideM - AmideData[58];
				MwM = MwM - MwData[58];
				ErrOM = ErrOM + ErrOData[58];
				ErrAM = ErrAM + ErrAData[58];

				break;
			case 38:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[38];
				AmideM = AmideM - AmideData[38];
				MwM = MwM - MwData[57];
				ErrOM = ErrOM + ErrOData[38];
				ErrAM = ErrAM + ErrAData[38];
				break;
			case 59:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[59];
				AmideM = AmideM - AmideData[59];
				MwM = MwM - MwData[59];
				ErrOM = ErrOM + ErrOData[59];
				ErrAM = ErrAM + ErrAData[59];
				break;
			case 42:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[42];
				AmideM = AmideM - AmideData[42];
				MwM = MwM - MwData[42];
				ErrOM = ErrOM + ErrOData[42];
				ErrAM = ErrAM + ErrAData[42];
				break;
			case 60:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[60];
				AmideM = AmideM - AmideData[60];
				MwM = MwM - MwData[60];
				ErrOM = ErrOM + ErrOData[60];
				ErrAM = ErrAM + ErrAData[60];
				break;
			case 44:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[44];
				AmideM = AmideM - AmideData[44];
				MwM = MwM - MwData[44];
				ErrOM = ErrOM + ErrOData[44];
				ErrAM = ErrAM + ErrAData[44];
				break;
			case 48:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[48];
				AmideM = AmideM - AmideData[48];
				MwM = MwM - MwData[48];
				ErrOM = ErrOM + ErrOData[48];
				ErrAM = ErrAM + ErrAData[48];
				break;
			case 61:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[61];
				AmideM = AmideM - AmideData[61];
				MwM = MwM - MwData[61];
				ErrOM = ErrOM + ErrOData[61];
				ErrAM = ErrAM + ErrAData[61];
				break;
			default:
				break;
			}
		}

		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;

		//57,58,38,59,42,60,44,48,61

		return boo;
	}
	public boolean AFucsidase(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){
		int i=0,count,j,flag = 0;
		int SplitInt;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;
		for(i=0;i<count;i++){
			flag = 0;
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			switch (SplitInt){
			case 20:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[20];
				AmideM = AmideM - AmideData[20];
				MwM = MwM - MwData[20];
				ErrOM = ErrOM + ErrOData[20];
				ErrAM = ErrAM + ErrAData[20];
				break;
			case 25:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[25];
				AmideM = AmideM - AmideData[25];
				MwM = MwM - MwData[25];
				ErrOM = ErrOM + ErrOData[25];
				ErrAM = ErrAM + ErrAData[25];
				break;
			case 27:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[27];
				AmideM = AmideM - AmideData[27];
				MwM = MwM - MwData[27];
				ErrOM = ErrOM + ErrOData[27];
				ErrAM = ErrAM + ErrAData[27];
				break;
			case 3:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[3];
				AmideM = AmideM - AmideData[3];
				MwM = MwM - MwData[3];
				ErrOM = ErrOM + ErrOData[3];
				ErrAM = ErrAM + ErrAData[3];
				break;
			case 2:
				for(j=0; j < count; j++){
					if(SplitSim[j].equals("55"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[2];
					AmideM = AmideM - AmideData[2];
					MwM = MwM - MwData[2];
					ErrOM = ErrOM + ErrOData[2];
					ErrAM = ErrAM + ErrAData[2];
				}
				break;
			default:
				break;
			}
		}
		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		//20,25,27,2,3;
		return boo;
	}
	public boolean BGalactosidase(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count,j,flag = 0;
		int SplitInt;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;
		for(i=0;i<count;i++){
			flag = 0;
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			// 55,17,56,21,24,28,52,53,54
			switch (SplitInt){
			case 55:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[55];
				AmideM = AmideM - AmideData[55];
				MwM = MwM - MwData[55];
				ErrOM = ErrOM + ErrOData[55];
				ErrAM = ErrAM + ErrAData[55];
				break;
			case 17:
			    for(j=0;j<count;j++){
					if(SplitSim[j].equals("57") || SplitSim[j].equals("31") ||
					 SplitSim[j].equals("32") || SplitSim[j].equals("33"))
					 flag = 1;
			    }
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[17];
					AmideM = AmideM - AmideData[17];
					MwM = MwM - MwData[17];
					ErrOM = ErrOM + ErrOData[17];
					ErrAM = ErrAM + ErrAData[17];
				}
				break;
			case 56:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("58"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[56];
					AmideM = AmideM - AmideData[56];
					MwM = MwM - MwData[56];
					ErrOM = ErrOM + ErrOData[56];
					ErrAM = ErrAM + ErrAData[56];
				}
				break;
			case 21:
				for(j = 0; j<count;j++){
					if(SplitSim[j].equals("34") || SplitSim[j].equals("35") ||
					 SplitSim[j].equals("36") || SplitSim[j].equals("37") ||
					 SplitSim[j].equals("38") || SplitSim[j].equals("39") ||
					 SplitSim[j].equals("59") || SplitSim[j].equals("20"))
					 flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[21];
					AmideM = AmideM - AmideData[21];
					MwM = MwM - MwData[21];
					ErrOM = ErrOM + ErrOData[21];
					ErrAM = ErrAM + ErrAData[21];
				}
				break;
			case 24:
				for(j=0; j<count;j++){
					if(SplitSim[j].equals("40") || SplitSim[j].equals("41") ||
					 SplitSim[j].equals("42") || SplitSim[j].equals("60") ||
					 SplitSim[j].equals("25"))
					 flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[24];
					AmideM = AmideM - AmideData[24];
					MwM = MwM - MwData[24];
					ErrOM = ErrOM + ErrOData[24];
					ErrAM = ErrAM + ErrAData[24];
				}
				break;
			case 28:
				for(j=0; j<count;j++){
					if(SplitSim[j].equals("45") || SplitSim[j].equals("46") ||
					 SplitSim[j].equals("47") || SplitSim[j].equals("48") ||
					 SplitSim[j].equals("49") || SplitSim[j].equals("50") ||
					 SplitSim[j].equals("61") || SplitSim[j].equals("27"))
					 flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[28];
					AmideM = AmideM - AmideData[28];
					MwM = MwM - MwData[28];
					ErrOM = ErrOM + ErrOData[28];
					ErrAM = ErrAM + ErrAData[28];
				}
				break;
			case 52:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[52];
				AmideM = AmideM - AmideData[52];
				MwM = MwM - MwData[52];
				ErrOM = ErrOM + ErrOData[52];
				ErrAM = ErrAM + ErrAData[52];
				break;
			case 53:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[53];
				AmideM = AmideM - AmideData[53];
				MwM = MwM - MwData[53];
				ErrOM = ErrOM + ErrOData[53];
				ErrAM = ErrAM + ErrAData[53];
				break;
			case 54:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[54];
				AmideM = AmideM - AmideData[54];
				MwM = MwM - MwData[54];
				ErrOM = ErrOM + ErrOData[54];
				ErrAM = ErrAM + ErrAData[54];
				break;
			default:
				break;
			}
		}
		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;

		return boo;
	}
	public boolean Bhexosaminidase(String SimStM,double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count,flag=0,j;
		int SplitInt;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;
		for(i=0;i<count;i++){
			flag = 0;
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			// 5,9,10,12,13,14,18,22,29,33,39,49
			switch (SplitInt){
			case 5:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[5];
				AmideM = AmideM - AmideData[5];
				MwM = MwM - MwData[5];
				ErrOM = ErrOM + ErrOData[5];
				ErrAM = ErrAM + ErrAData[5];
				break;
			case 9:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("17") || SplitSim[j].equals("18"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[9];
					AmideM = AmideM - AmideData[9];
					MwM = MwM - MwData[9];
					ErrOM = ErrOM + ErrOData[9];
					ErrAM = ErrAM + ErrAData[9];
				}
				break;
			case 10:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("56"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[10];
					AmideM = AmideM - AmideData[10];
					MwM = MwM - MwData[10];
					ErrOM = ErrOM + ErrOData[10];
					ErrAM = ErrAM + ErrAData[10];
				}
				break;
			case 12:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("20") || SplitSim[j].equals("21") || SplitSim[j].equals("22"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[12];
					AmideM = AmideM - AmideData[12];
					MwM = MwM - MwData[12];
					ErrOM = ErrOM + ErrOData[12];
					ErrAM = ErrAM + ErrAData[12];
				}
				break;
			case 13:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("23") || SplitSim[j].equals("24") || SplitSim[j].equals("25") || SplitSim[j].equals("26"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[13];
					AmideM = AmideM - AmideData[13];
					MwM = MwM - MwData[13];
					ErrOM = ErrOM + ErrOData[13];
					ErrAM = ErrAM + ErrAData[13];
				}
				break;
			case 14:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("27") || SplitSim[j].equals("28") || SplitSim[j].equals("29"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[14];
					AmideM = AmideM - AmideData[14];
					MwM = MwM - MwData[14];
					ErrOM = ErrOM + ErrOData[14];
					ErrAM = ErrAM + ErrAData[14];
				}
				break;
			case 18:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[18];
				AmideM = AmideM - AmideData[18];
				MwM = MwM - MwData[18];
				ErrOM = ErrOM + ErrOData[18];
				ErrAM = ErrAM + ErrAData[18];
				break;
			case 22:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[22];
				AmideM = AmideM - AmideData[22];
				MwM = MwM - MwData[22];
				ErrOM = ErrOM + ErrOData[22];
				ErrAM = ErrAM + ErrAData[22];
				break;
			case 29:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[29];
				AmideM = AmideM - AmideData[29];
				MwM = MwM - MwData[29];
				ErrOM = ErrOM + ErrOData[29];
				ErrAM = ErrAM + ErrAData[29];
				break;
			case 33:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("52"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[33];
					AmideM = AmideM - AmideData[33];
					MwM = MwM - MwData[33];
					ErrOM = ErrOM + ErrOData[33];
					ErrAM = ErrAM + ErrAData[33];
				}
				break;
			case 39:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("53"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[39];
					AmideM = AmideM - AmideData[39];
					MwM = MwM - MwData[39];
					ErrOM = ErrOM + ErrOData[39];
					ErrAM = ErrAM + ErrAData[39];
				}
				break;
			case 49:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("54"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[49];
					AmideM = AmideM - AmideData[49];
					MwM = MwM - MwData[49];
					ErrOM = ErrOM + ErrOData[49];
					ErrAM = ErrAM + ErrAData[49];
				}
				break;
			default:
				break;
			}
		}
		// Retry Enzyme
		for(i=0;i<count;i++){
			flag = 0;
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			// 5,9,10,12,13,14,18,22,29,33,39,49
			switch (SplitInt){
			case 5:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[5];
				AmideM = AmideM - AmideData[5];
				MwM = MwM - MwData[5];
				ErrOM = ErrOM + ErrOData[5];
				ErrAM = ErrAM + ErrAData[5];
				break;
			case 9:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("17") || SplitSim[j].equals("18"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[9];
					AmideM = AmideM - AmideData[9];
					MwM = MwM - MwData[9];
					ErrOM = ErrOM + ErrOData[9];
					ErrAM = ErrAM + ErrAData[9];
				}
				break;
			case 10:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("56"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[10];
					AmideM = AmideM - AmideData[10];
					MwM = MwM - MwData[10];
					ErrOM = ErrOM + ErrOData[10];
					ErrAM = ErrAM + ErrAData[10];
				}
				break;
			case 12:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("20") || SplitSim[j].equals("21") || SplitSim[j].equals("22"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[12];
					AmideM = AmideM - AmideData[12];
					MwM = MwM - MwData[12];
					ErrOM = ErrOM + ErrOData[12];
					ErrAM = ErrAM + ErrAData[12];
				}
				break;
			case 13:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("23") || SplitSim[j].equals("24") || SplitSim[j].equals("25") || SplitSim[j].equals("26"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[13];
					AmideM = AmideM - AmideData[13];
					MwM = MwM - MwData[13];
					ErrOM = ErrOM + ErrOData[13];
					ErrAM = ErrAM + ErrAData[13];
				}
				break;
			case 14:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("27") || SplitSim[j].equals("28") || SplitSim[j].equals("29"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[14];
					AmideM = AmideM - AmideData[14];
					MwM = MwM - MwData[14];
					ErrOM = ErrOM + ErrOData[14];
					ErrAM = ErrAM + ErrAData[14];
				}
				break;
			case 18:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[18];
				AmideM = AmideM - AmideData[18];
				MwM = MwM - MwData[18];
				ErrOM = ErrOM + ErrOData[18];
				ErrAM = ErrAM + ErrAData[18];
				break;
			case 22:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[22];
				AmideM = AmideM - AmideData[22];
				MwM = MwM - MwData[22];
				ErrOM = ErrOM + ErrOData[22];
				ErrAM = ErrAM + ErrAData[22];
				break;
			case 29:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[29];
				AmideM = AmideM - AmideData[29];
				MwM = MwM - MwData[29];
				ErrOM = ErrOM + ErrOData[29];
				ErrAM = ErrAM + ErrAData[29];
				break;
			case 33:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("52"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[33];
					AmideM = AmideM - AmideData[33];
					MwM = MwM - MwData[33];
					ErrOM = ErrOM + ErrOData[33];
					ErrAM = ErrAM + ErrAData[33];
				}
				break;
			case 39:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("53"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[39];
					AmideM = AmideM - AmideData[39];
					MwM = MwM - MwData[39];
					ErrOM = ErrOM + ErrOData[39];
					ErrAM = ErrAM + ErrAData[39];
				}
				break;
			case 49:
				for(j = 0;j<count;j++){
					if(SplitSim[j].equals("54"))
						flag = 1;
				}
				if(flag == 0){
					boo = true;
					SplitSim[i] = "0";
					ODSM = ODSM - ODSData[49];
					AmideM = AmideM - AmideData[49];
					MwM = MwM - MwData[49];
					ErrOM = ErrOM + ErrOData[49];
					ErrAM = ErrAM + ErrAData[49];
				}
				break;
			default:
				break;
			}
		}
		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;

		return boo;
	}
	public boolean Xylosidase(String SimStM,double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		int SplitInt;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;
		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			switch (SplitInt){
			case 6:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[6];
				AmideM = AmideM - AmideData[6];
				MwM = MwM - MwData[6];
				ErrOM = ErrOM + ErrOData[6];
				ErrAM = ErrAM + ErrAData[6];
				break;
			default:
				break;
			}
		}
		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		//6

		return boo;
	}
	public boolean Sialidase(String SimStM, double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		int SplitInt;
		dataClean();
		ErrOM = 0.0;
		ErrAM = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;
		for(i=0;i<count;i++){
			//System.out.println(i +" "+SplitSim[i]);
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			switch (SplitInt){
			case 23:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[23];
				AmideM = AmideM - AmideData[23];
				MwM = MwM - MwData[23];
				ErrOM = ErrOM + ErrOData[23];
				ErrAM = ErrAM + ErrAData[23];
				break;
			case 31:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[31];
				AmideM = AmideM - AmideData[31];
				MwM = MwM - MwData[31];
				ErrOM = ErrOM + ErrOData[31];
				ErrAM = ErrAM + ErrAData[31];
				break;
			case 32:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[32];
				AmideM = AmideM - AmideData[32];
				MwM = MwM - MwData[32];
				ErrOM = ErrOM + ErrOData[32];
				ErrAM = ErrAM + ErrAData[32];
				break;
			case 34:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[34];
				AmideM = AmideM - AmideData[34];
				MwM = MwM - MwData[34];
				ErrOM = ErrOM + ErrOData[34];
				ErrAM = ErrAM + ErrAData[34];
				break;
			case 35:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[35];
				AmideM = AmideM - AmideData[35];
				MwM = MwM - MwData[35];
				ErrOM = ErrOM + ErrOData[35];
				ErrAM = ErrAM + ErrAData[35];
				break;
			case 36:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[36];
				AmideM = AmideM - AmideData[36];
				MwM = MwM - MwData[36];
				ErrOM = ErrOM + ErrOData[36];
				ErrAM = ErrAM + ErrAData[36];
				break;
			case 37:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[37];
				AmideM = AmideM - AmideData[37];
				MwM = MwM - MwData[37];
				ErrOM = ErrOM + ErrOData[37];
				ErrAM = ErrAM + ErrAData[37];
				break;
			case 40:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[40];
				AmideM = AmideM - AmideData[40];
				MwM = MwM - MwData[40];
				ErrOM = ErrOM + ErrOData[40];
				ErrAM = ErrAM + ErrAData[40];
				break;
			case 41:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[41];
				AmideM = AmideM - AmideData[41];
				MwM = MwM - MwData[41];
				ErrOM = ErrOM + ErrOData[41];
				ErrAM = ErrAM + ErrAData[41];
				break;
			case 43:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[43];
				AmideM = AmideM - AmideData[43];
				MwM = MwM - MwData[43];
				ErrOM = ErrOM + ErrOData[43];
				ErrAM = ErrAM + ErrAData[43];
				break;
			case 45:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[45];
				AmideM = AmideM - AmideData[45];
				MwM = MwM - MwData[45];
				ErrOM = ErrOM + ErrOData[45];
				ErrAM = ErrAM + ErrAData[45];
				break;
			case 46:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[46];
				AmideM = AmideM - AmideData[46];
				MwM = MwM - MwData[46];
				ErrOM = ErrOM + ErrOData[46];
				ErrAM = ErrAM + ErrAData[46];
				break;
			case 47:
				boo = true;
				SplitSim[i] = "0";
				ODSM = ODSM - ODSData[47];
				AmideM = AmideM - AmideData[47];
				MwM = MwM - MwData[47];
				ErrOM = ErrOM + ErrOData[47];
				ErrAM = ErrAM + ErrAData[47];
				break;
			default:
				break;
			}
		}
		for(i=0;i<count;i++){
			if(SplitSim[i].equals("0")){
			}
			else{
				if(i==0){
					SimStM = SplitSim[i];
				}
				else{
					SimStM = SimStM + "-" + SplitSim[i];
				}
			}
		}
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		//31,32,34,35,36,37,40,41,43,45,46,47

		return boo;
	}


	// BACK ENZYME ROLE  //////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean AGalactosidaseBack(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		int flaga = 0; // 57
		int flagb = 0; // 58
		int flagc = 0; // 38
		int flagd = 0; // 59
		int flage = 0; // 42
		int flagf = 0; // 60
		int flagg = 0; // 44
		int flagh = 0; // 48
		int flagi = 0; // 61
		int SplitInt;
		String valBin;
		int num,num2;
		int Spbase[] = new int[9];
		String DumySt = "";
		double DumyODS = 0.0;
		double DumyAmide = 0.0;
		double DumyMw = 0.0;
		double DumyErrO = 0.0;
		double DumyErrA = 0.0;
		boolean boo;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}
		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 17:
						flaga = 1;
						break;
					case 56:
						flagb = 1;
						break;
					case 21:
						flagc = 1;
						flagd = 1;
						break;
					case 24:
						flage = 1;
						flagf = 1;
						break;
					case 26:
						flagg = 1;
						break;
					case 28:
						flagh = 1;
						flagi = 1;
						break;
					default:
						break;
				}
		}

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 57:
						flaga = 0;
						break;
					case 58:
						flagb = 0;
						break;
					case 38:
						flagc = 0;
						break;
					case 36:
						flagc = 0;
						break;
					case 37:
						flagc = 0;
						break;
					case 39:
						flagc = 0;
						break;
					case 59:
						flagd = 0;
						break;
					case 42:
						flage = 0;
						break;
					case 41:
						flage = 0;
						break;
					case 60:
						flagf = 0;
						break;
					case 44:
						flagg = 0;
						break;
					case 43:
						flagg = 0;
						break;
					case 48:
						flagh = 0;
						break;
					case 47:
						flagh = 0;
						break;
					case 49:
						flagh = 0;
						break;
					case 61:
						flagi = 0;
					default:
					break;
				}
		}
		num = flaga + flagb + flagc + flagd + flage + flagf + flagg + flagh + flagi;
		if(num > 0){
			boo = true;
		}
		int k = 0;
		if(flaga == 1){
			Spbase[k] = 57;
			k++;
		}
		if(flagb == 1){
			Spbase[k] = 58;
			k++;
		}
		if(flagc == 1){
			Spbase[k] = 38;
			k++;
		}
		if(flagd == 1){
			Spbase[k] = 59;
			k++;
		}
		if(flage == 1){
			Spbase[k] = 42;
			k++;
		}
		if(flagf == 1){
			Spbase[k] = 60;
			k++;
		}
		if(flagg == 1){
			Spbase[k] = 44;
			k++;
		}
		if(flagh == 1){
			Spbase[k] = 48;
			k++;
		}
		if(flagi == 1){
			Spbase[k] = 61;
			k++;
		}

		num2=(int)(Math.pow(2,num))-1;
		int len;
		String valBinchar;
		System.out.println(" NUM = " + num);
		for(i = 0; i<=num2; i++){
			DumySt = SimStM;
			DumyAmide = AmideM;
			DumyMw = MwM;
			DumyODS = ODSM;
			DumyErrO = ErrOM;
			DumyErrA = ErrAM;
			valBin = Integer.toBinaryString(i);
			len = valBin.length();
			if((num - len) > 0){
				valBin = sa[num-len] + valBin;
			}
			for(int j = 0; j < num; j++ ){
				valBinchar = valBin.substring(j,j+1);
				if(valBinchar.equals("1")){
					DumySt = DumySt + "-" + Spbase[j];
					DumyAmide = DumyAmide + AmideData[Spbase[j]];
					DumyODS = DumyODS + ODSData[Spbase[j]];
					DumyMw = DumyMw + MwData[Spbase[j]];
					DumyErrA = DumyErrA + ErrAData[Spbase[j]];
					DumyErrO = DumyErrO + ErrOData[Spbase[j]];
				}
				//System.out.print(" " + valBin.substring(j,j+1));
			}
			//System.out.println("");
			//System.out.println(" NUM BAL = " + valBin);
			//System.out.println(DumySt + " " + DumyODS + " " + DumyAmide + " " + DumyMw+ " "+ DumyErrA +" "+ DumyErrO);
			BackSt[i] = Spliter(DumySt);
			BackAmide[i] = DumyAmide;
			BackODS[i] = DumyODS;
			BackMw[i] = DumyMw;
			BackErrA[i] = DumyErrA;
			BackErrO[i] = DumyErrO;
		}

		this.DATACOUNTER = i;

		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		//?
		return boo;
	}


	public boolean AFucsidaseBack(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		int flaga = 0;  //2
		int flagb = 0;  //3
		int flagc = 0;  //20
		int flagd = 0;  //25
		int flage = 0;  //27
		int SplitInt;
		String valBin;
		int num,num2;
		boolean boo;
		int Spbase[] = new int[5];
		String DumySt = "";
		double DumyODS = 0.0;
		double DumyAmide = 0.0;
		double DumyMw = 0.0;
		double DumyErrO = 0.0;
		double DumyErrA = 0.0;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}

		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 1:
						flaga = 1;
						flagb = 1;
						break;
					case 12:
						flagc = 1;
						break;
					case 13:
						flagd = 1;
						break;
					case 14:
						flage = 1;
						break;
					default:
						break;
				}
		}

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 2:
						flaga = 0;
					break;
					case 3:
						flagb = 0;
					break;
					case 20:
						flagc = 0;
					break;
					case 25:
						flagd = 0;
					break;
					case 26:
						flagd = 0;
					break;
					case 27:
						flage = 0;
					break;
					default:
					break;
				}
		}
		num = flaga + flagb + flagc + flagd + flage;
		System.out.println("NUM = " +num);
		if(num > 0){
			boo = true;
		}
		int k = 0;
		if(flaga == 1){
			Spbase[k] = 2;
			k++;
		}
		if(flagb == 1){
			Spbase[k] = 3;
			k++;
		}
		if(flagc == 1){
			Spbase[k] = 20;
			k++;
		}
		if(flagd == 1){
			Spbase[k] = 25;
			k++;
		}
		if(flage == 1){
			Spbase[k] = 27;
			k++;
		}

		num2=(int)(Math.pow(2,num))-1;
		int len;
		String valBinchar;
		System.out.println(" NUM = " + num);
		for(i = 0; i<=num2; i++){
			DumySt = SimStM;
			DumyAmide = AmideM;
			DumyMw = MwM;
			DumyODS = ODSM;
			DumyErrO = ErrOM;
			DumyErrA = ErrAM;
			valBin = Integer.toBinaryString(i);
			len = valBin.length();
			if((num - len) > 0){
				valBin = sa[num-len] + valBin;
			}
			for(int j = 0; j < num; j++ ){
				valBinchar = valBin.substring(j,j+1);
				if(valBinchar.equals("1")){
					DumySt = DumySt + "-" + Spbase[j];
					DumyAmide = DumyAmide + AmideData[Spbase[j]];
					DumyODS = DumyODS + ODSData[Spbase[j]];
					DumyMw = DumyMw + MwData[Spbase[j]];
					DumyErrA = DumyErrA + ErrAData[Spbase[j]];
					DumyErrO = DumyErrO + ErrOData[Spbase[j]];
				}
				//System.out.print(" " + valBin.substring(j,j+1));
			}
			//System.out.println("");
			//System.out.println(" NUM BAL = " + valBin);
			//System.out.println(DumySt + " " + DumyODS + " " + DumyAmide + " " + DumyMw+ " "+ DumyErrA +" "+ DumyErrO);
			BackSt[i] = Spliter(DumySt);
			BackAmide[i] = DumyAmide;
			BackODS[i] = DumyODS;
			BackMw[i] = DumyMw;
			BackErrA[i] = DumyErrA;
			BackErrO[i] = DumyErrO;
		}
		this.DATACOUNTER = i;

		//System.out.println(" NUM BAL = " + Integer.toBinaryString(num));

		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		//20,25,27

		return boo;
	}

	public boolean BGalactosidaseBack(String SimStM,double ODSM,double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		int flaga = 0; //55
		int flagb = 0; //17
		int flagc = 0; //56
		int flagd = 0; //21
		int flage = 0; //24
		int flagf = 0; //28
		int flagg = 0; //52
		int flagh = 0; //53
		int flagi = 0; //54
		int SplitInt;
		String valBin;
		int num,num2;
		int Spbase[] = new int[9];
		boolean boo;
		String DumySt = "";
		double DumyODS = 0.0;
		double DumyAmide = 0.0;
		double DumyMw = 0.0;
		double DumyErrO = 0.0;
		double DumyErrA = 0.0;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
		//	System.out.print(" "+SplitSim[i]);
			i++;
		}
		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 2:
						flaga = 1;
						break;
					case 9:
						flagb = 1;
						break;
					case 10:
						flagc = 1;
						break;
					case 12:
						flagd = 1;
						break;
					case 13:
						flage = 1;
						break;
					case 14:
						flagf = 1;
						break;
					case 33:
						flagg = 1;
						break;
					case 39:
						flagh = 1;
						break;
					case 49:
						flagi = 1;
						break;
					default:
						break;
				}
		}

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 55:
						flaga = 0;
						break;
					case 17:
						flagb = 0;
						break;
					case 18:
						flagb = 0;
						break;
					case 56:
						flagc = 0;
						break;
					case 21:
						flagd = 0;
						break;
					case 22:
						flagd = 0;
						break;
					case 24:
						flage = 0;
						break;
					case 28:
						flagf = 0;
						break;
					case 29:
						flagf = 0;
						break;
					case 52:
						flagg = 0;
						break;
					case 53:
						flagh = 0;
						break;
					case 54:
						flagi = 0;
					default:
					break;
				}
		}
		num = flaga + flagb + flagc + flagd + flage + flagf + flagg + flagh + flagi;
		if(num > 0){
			boo = true;
		}

		int k = 0;
		if(flaga == 1){
			Spbase[k] = 55;
			k++;
		}
		if(flagb == 1){
			Spbase[k] = 17;
			k++;
		}
		if(flagc == 1){
			Spbase[k] = 56;
			k++;
		}
		if(flagd == 1){
			Spbase[k] = 21;
			k++;
		}
		if(flage == 1){
			Spbase[k] = 24;
			k++;
		}
		if(flagf == 1){
			Spbase[k] = 28;
			k++;
		}
		if(flagg == 1){
			Spbase[k] = 52;
			k++;
		}
		if(flagh == 1){
			Spbase[k] = 53;
			k++;
		}
		if(flagi == 1){
			Spbase[k] = 54;
			k++;
		}

		num2=(int)(Math.pow(2,num))-1;
		int len;
		String valBinchar;
		System.out.println(" NUM = " + num);
		for(i = 0; i<=num2; i++){
			DumySt = SimStM;
			DumyAmide = AmideM;
			DumyMw = MwM;
			DumyODS = ODSM;
			DumyErrO = ErrOM;
			DumyErrA = ErrAM;
			valBin = Integer.toBinaryString(i);
			len = valBin.length();
			if((num - len) > 0){
				valBin = sa[num-len] + valBin;
			}
			for(int j = 0; j < num; j++ ){
				valBinchar = valBin.substring(j,j+1);
				if(valBinchar.equals("1")){
					DumySt = DumySt + "-" + Spbase[j];
					DumyAmide = DumyAmide + AmideData[Spbase[j]];
					DumyODS = DumyODS + ODSData[Spbase[j]];
					DumyMw = DumyMw + MwData[Spbase[j]];
					DumyErrA = DumyErrA + ErrAData[Spbase[j]];
					DumyErrO = DumyErrO + ErrOData[Spbase[j]];
				}
				//System.out.print(" " + valBin.substring(j,j+1));
			}
			//System.out.println("");
			//System.out.println(" NUM BAL = " + valBin);
			//System.out.println(DumySt + " " + DumyODS + " " + DumyAmide + " " + DumyMw+ " "+ DumyErrA +" "+ DumyErrO);
			BackSt[i] = Spliter(DumySt);
			BackAmide[i] = DumyAmide;
			BackODS[i] = DumyODS;
			BackMw[i] = DumyMw;
			BackErrA[i] = DumyErrA;
			BackErrO[i] = DumyErrO;
		}
		this.DATACOUNTER = i;

		//57,58,38,59,42,60,44,48,61
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		System.out.println("num = " + count);

		return boo;
	}

	public boolean BhexosaminidaseBack(String SimStM,double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		boolean boo;
		boo = false;
		int flaga = 0; //5
		int flagb = 0; //9
		int flagc = 0; //10
		int flagd = 0; //12
		int flage = 0; //13
		int flagf = 0; //14
		int flagg = 0; //18
		int flagh = 0; //22
		int flagi = 0; //29
		int flagj = 0; //33
		int flagk = 0; //39
		int flagl = 0; //49
		int flagx,flagy,flagz;
		int xpoint1,xpoint2;
		int ypoint1,ypoint2;
		int zpoint1,zpoint2;
		xpoint1 = 0; xpoint2 = 0;
		ypoint1 = 0; ypoint2 = 0;
		zpoint1 = 0; zpoint2 = 0;
		flagx = 0; flagy = 0; flagz = 0;
		int SplitInt;
		String valBin;
		int num,num2;
		int Spbase[] = new int[12];
		String DumySt = "";
		double DumyODS = 0.0;
		double DumyAmide = 0.0;
		double DumyMw = 0.0;
		double DumyErrO = 0.0;
		double DumyErrA = 0.0;

		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}
		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 1:
						flaga = 1;
						break;
					case 4:
						flagb = 1;
						flagc = 1;
						flagd = 1;
						flagg = 1;
						flagh = 1;
						break;
					case 7:
						flage = 1;
						flagf = 1;
						flagi = 1;
						break;
					case 17:
						flagj = 1;
						break;
					case 21:
						flagk = 1;
						break;
					case 28:
						flagl = 1;
						break;
					default:
						break;
				}
		}

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 5:
						flaga = 0;
						break;
					case 9:
						flagb = 0;
						break;
					case 8:
						flagb = 0;
						break;
					case 10:
						flagc = 0;
						break;
					case 12:
						flagd = 0;
						break;
					case 13:
						flage = 0;
						break;
					case 14:
						flagf = 0;
						break;
					case 18:
						flagg = 0;
						break;
					case 17:
						flagg = 0;
						break;
					case 22:
						flagh = 0;
						break;
					case 21:
						flagh = 0;
						break;
					case 29:
						flagi = 0;
						break;
					case 28:
						flagi = 0;
						break;
					case 33:
						flagj = 0;
						break;
					case 32:
						flagj = 0;
						break;
					case 39:
						flagk = 0;
						break;
					case 36:
						flagk = 0;
						break;
					case 37:
						flagk = 0;
						break;
					case 38:
						flagk = 0;
						break;
					case 49:
						flagl = 0;
						break;
					case 47:
						flagl = 0;
						break;
					case 48:
						flagl = 0;
						break;
					default:
					break;
				}
		}
		num = flaga + flagb + flagc + flagd + flage + flagf + flagg + flagh + flagi + flagj + flagk + flagl;
		if(num > 0){
			boo = true;
		}

		if(flagb == 1 && flagg == 1){
			flagx = 1;
		}
		if(flagd == 1 && flagh == 1){
			flagy = 1;
		}
		if(flagf == 1 && flagi == 1){
			flagz = 1;
		}

		int k = 0;
		if(flaga == 1){
			Spbase[k] =5;
			k++;
		}
		if(flagb == 1){
			Spbase[k] = 9;
			xpoint1 = k;
			k++;
		}
		if(flagc == 1){
			Spbase[k] = 10;
			k++;
		}
		if(flagd == 1){
			Spbase[k] = 12;
			ypoint1 = k;
			k++;
		}
		if(flage == 1){
			Spbase[k] = 13;
			k++;
		}
		if(flagf == 1){
			Spbase[k] = 14;
			zpoint1 = k;
			k++;
		}
		if(flagg == 1){
			Spbase[k] = 18;
			xpoint2 = k;
			k++;
		}
		if(flagh == 1){
			Spbase[k] = 22;
			ypoint2 = k;
			k++;
		}
		if(flagi == 1){
			Spbase[k] = 29;
			zpoint2 = k;
			k++;
		}
		if(flagj == 1){
			Spbase[k] = 33;
			k++;
		}
		if(flagk == 1){
			Spbase[k] = 39;
			k++;
		}
		if(flagl == 1){
			Spbase[k] = 49;
			k++;
		}

		num2=(int)(Math.pow(2,num))-1;
		int len;
		String valBinchar;
		System.out.println(" NUM = " + num);
		int t,flagfinal;
		t = 0; flagfinal = 0;
		for(i = 0; i<=num2; i++){
			DumySt = SimStM;
			DumyAmide = AmideM;
			DumyMw = MwM;
			DumyODS = ODSM;
			DumyErrO = ErrOM;
			DumyErrA = ErrAM;
			valBin = Integer.toBinaryString(i);
			len = valBin.length();
			flagfinal = 0;
			if((num - len) > 0){
				valBin = sa[num-len] + valBin;
			}
			for(int j = 0; j < num; j++ ){
				valBinchar = valBin.substring(j,j+1);
				Checker[j] = Integer.valueOf(valBinchar).intValue();
				if(valBinchar.equals("1")){
					DumySt = DumySt + "-" + Spbase[j];
					DumyAmide = DumyAmide + AmideData[Spbase[j]];
					DumyODS = DumyODS + ODSData[Spbase[j]];
					DumyMw = DumyMw + MwData[Spbase[j]];
					DumyErrA = DumyErrA + ErrAData[Spbase[j]];
					DumyErrO = DumyErrO + ErrOData[Spbase[j]];
				}
				//System.out.print(" " + valBin.substring(j,j+1));
			}

			if(flagx == 1 && Checker[xpoint1] == 0 && Checker[xpoint2] == 1){
				flagfinal = 1;
			}
			if(flagy == 1 && Checker[ypoint1] == 0 && Checker[ypoint2] == 1){
				flagfinal = 1;
			}
			if(flagz == 1 && Checker[zpoint1] == 0 && Checker[zpoint2] == 1){
				flagfinal = 1;
			}
			//System.out.println("");
			//System.out.println(" NUM BAL = " + valBin);
			//System.out.println(DumySt + " " + DumyODS + " " + DumyAmide + " " + DumyMw+ " "+ DumyErrA +" "+ DumyErrO);
			if(flagfinal == 0){
				BackSt[t] = Spliter(DumySt);
				BackAmide[t] = DumyAmide;
				BackODS[t] = DumyODS;
				BackMw[t] = DumyMw;
				BackErrA[t] = DumyErrA;
				BackErrO[t] = DumyErrO;
				t++;
			}
		}
		this.DATACOUNTER = t;
		//?
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		return boo;
	}
	public boolean XylosidaseBack(String SimStM,double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		boolean boo;
		int SplitInt;
		int flag = 0;
		counter = 0.0;
		boo = false;
		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		System.out.println("Xylosidase");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}
		count = i;
		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			if(SplitInt == 1){
				flag = 1;
			}
		}
		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
			if(SplitInt == 6){
				flag = 0;
			}
		}
		for(i=0;i<count;i++){
			if(i==0){
				SimStM = SplitSim[i];
			}
			else{
				SimStM = SimStM + "-" + SplitSim[i];
			}
		}
		if(flag == 1){
			boo = true;
			SimStM = SimStM + "-6";
			ODSM = ODSM +ODSData[6];
			AmideM = AmideM +AmideData[6];
			MwM = MwM +MwData[6];

			BackSt[1] = Spliter(SimStM);
			BackAmide[1] = AmideM;
			BackODS[1] = ODSM;
			BackMw[1] = MwM;
			BackErrA[1] = ErrAM + ErrAData[6];
			BackErrO[1] = ErrOM + ErrOData[6];
			counter ++;
			this.DATACOUNTER = 2;
		}
		//6
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		return boo;
	}
	public boolean SialidaseBack(String SimStM, double ODSM, double AmideM, double MwM, double ErrOM, double ErrAM){
		int i = 0, count;
		boolean boo;
		boo = false;

		int flaga = 0; //23
		int flagb = 0; //31
		int flagc = 0; //32
		int flagd = 0; //34
		int flage = 0; //35
		int flagf = 0; //36
		int flagg = 0; //37
		int flagh = 0; //40
		int flagi = 0; //41
		int flagj = 0; //43
		int flagk = 0; //45
		int flagl = 0; //46
		int flagm = 0; //47
		int flagx,flagy,flagz;
		int xpoint1,xpoint2;
		int ypoint1,ypoint2;
		int zpoint1,zpoint2;
		xpoint1 = 0; xpoint2 = 0;
		ypoint1 = 0; ypoint2 = 0;
		zpoint1 = 0; zpoint2 = 0;
		flagx = 0; flagy = 0; flagz = 0;

		int SplitInt;
		String valBin;
		int num,num2;
		int Spbase[] = new int[13];
		String DumySt = "";
		double DumyODS = 0.0;
		double DumyAmide = 0.0;
		double DumyMw = 0.0;
		double DumyErrO = 0.0;
		double DumyErrA = 0.0;

		String SplitSim[] = new String[MAXSimSt];
		StringTokenizer st = new StringTokenizer(SimStM,"-");
		while(st.hasMoreTokens())
		{
			SplitSim[i] = st.nextToken();
			i++;
		}
		count = i;

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 13:
						flaga = 1;
						break;
					case 17:
						flagb = 1;
						flagc = 1;
						break;
					case 21:
						flagd = 1;
						flage = 1;
						flagf = 1;
						flagg = 1;
						break;
					case 24:
						flagh = 1;
						flagi = 1;
						break;
					case 26:
						flagj = 1;
						break;
					case 28:
						flagk = 1;
						flagl = 1;
						flagm = 1;
						break;
					default:
						break;
				}
		}

		for(i=0;i<count;i++){
			SplitInt = Integer.valueOf(SplitSim[i]).intValue();
				switch (SplitInt){
					case 23:
						flaga = 0;
						break;
					case 31:
						flagb = 0;
						break;
					case 32:
						flagc = 0;
						break;
					case 33:
						flagc = 0;
						break;
					case 34:
						flagd = 0;
						flage = 0;
						break;
					case 35:
						flage = 0;
						flagd = 0;
						break;
					case 36:
						flagf = 0;
						flagg = 0;
						break;
					case 37:
						flagf = 0;
						flagg = 0;
						break;
					case 38:
						flagf = 0;
						flagg = 0;
						break;
					case 39:
						flagf = 0;
						flagg = 0;
						break;
					case 40:
						flagh = 0;
						break;
					case 41:
						flagi = 0;
						break;
					case 42:
						flagi = 0;
						break;
					case 43:
						flagj = 0;
						break;
					case 44:
						flagj = 0;
						break;
					case 45:
						flagk = 0;
						flagl = 0;
						break;
					case 46:
						flagk = 0;
						flagl = 0;
						break;
					case 47:
						flagm = 0;
						break;
					case 48:
						flagm = 0;
						break;
					case 49:
						flagm = 0;
						break;
					default:
					break;
				}
		}
		num = flaga + flagb + flagc + flagd + flage + flagf + flagg + flagh + flagi + flagj + flagk + flagl + flagm;
		if(num > 0){
			boo = true;
		}

		if(flagd == 1 && flage == 1){
			flagx = 1;
		}
		if(flagf == 1 && flagg == 1){
			flagy = 1;
		}
		if(flagk == 1 && flagl == 1){
			flagz = 1;
		}
		int k = 0;

		if(flaga == 1){
			Spbase[k] = 23;
			k++;
		}
		if(flagb == 1){
			Spbase[k] = 31;
			k++;
		}
		if(flagc == 1){
			Spbase[k] = 32;
			k++;
		}
		if(flagd == 1){
			Spbase[k] = 34;
			xpoint1 = k;
			k++;
		}
		if(flage == 1){
			Spbase[k] = 35;
			xpoint2 = k;
			k++;
		}
		if(flagf == 1){
			Spbase[k] = 36;
			ypoint1 = k;
			k++;
		}
		if(flagg == 1){
			Spbase[k] = 37;
			ypoint2 = k;
			k++;
		}
		if(flagh == 1){
			Spbase[k] = 40;
			k++;
		}
		if(flagi == 1){
			Spbase[k] = 41;
			k++;
		}
		if(flagj == 1){
			Spbase[k] = 43;
			k++;
		}
		if(flagk == 1){
			Spbase[k] = 45;
			zpoint1 = k;
			k++;
		}
		if(flagl == 1){
			Spbase[k] = 46;
			zpoint2 = k;
			k++;
		}
		if(flagm == 1){
			Spbase[k] = 47;
			k++;
		}

		num2=(int)(Math.pow(2,num))-1;
		int len;
		String valBinchar;
		System.out.println(" NUM = " + num);
		int t,flagfinal;
		t = 0; flagfinal = 0;
		for(i = 0; i<=num2; i++){
			DumySt = SimStM;
			DumyAmide = AmideM;
			DumyMw = MwM;
			DumyODS = ODSM;
			DumyErrO = ErrOM;
			DumyErrA = ErrAM;
			valBin = Integer.toBinaryString(i);
			len = valBin.length();
			flagfinal = 0;
			if((num - len) > 0){
				valBin = sa[num-len] + valBin;
			}
			for(int j = 0; j < num; j++ ){
				valBinchar = valBin.substring(j,j+1);
				Checker[j] = Integer.valueOf(valBinchar).intValue();
				if(valBinchar.equals("1")){
					DumySt = DumySt + "-" + Spbase[j];
					DumyAmide = DumyAmide + AmideData[Spbase[j]];
					DumyODS = DumyODS + ODSData[Spbase[j]];
					DumyMw = DumyMw + MwData[Spbase[j]];
					DumyErrA = DumyErrA + ErrAData[Spbase[j]];
					DumyErrO = DumyErrO + ErrOData[Spbase[j]];
				}
				//System.out.print(" " + valBin.substring(j,j+1));
			}
			if(flagx == 1 && Checker[xpoint1] == 1 && Checker[xpoint2] == 1){
				flagfinal = 1;
			}
			if(flagy == 1 && Checker[ypoint1] == 1 && Checker[ypoint2] == 1){
				flagfinal = 1;
			}
			if(flagz == 1 && Checker[zpoint1] == 1 && Checker[zpoint2] == 1){
				flagfinal = 1;
			}
			//System.out.println("");
			//System.out.println(" NUM BAL = " + valBin);
			//System.out.println(DumySt + " " + DumyODS + " " + DumyAmide + " " + DumyMw+ " "+ DumyErrA +" "+ DumyErrO);
			if(flagfinal == 0){
				BackSt[t] = Spliter(DumySt);
				BackAmide[t] = DumyAmide;
				BackODS[t] = DumyODS;
				BackMw[t] = DumyMw;
				BackErrA[t] = DumyErrA;
				BackErrO[t] = DumyErrO;
				t++;
			}
		}
		this.DATACOUNTER = t;

		//31,32,34,35,36,37,40,41,43,45,46,47
		inSimSt = SimStM;
		inODS = ODSM;
		inAmide = AmideM;
		inMW = MwM;
		outErrO = ErrOM;
		outErrA = ErrAM;
		return boo;
	}
	public void SetData(){
		//System.out.println("SetData");
		ODSData[0] = 1.11; AmideData[0] = 1.11; MwData[0]= 1.11; ErrOData[0]= 1.11; ErrAData[0] = 1.11;
		ODSData[1] = 7.20; AmideData[1] = 2.10; MwData[1]= 664.6684; ErrOData[1]= 0.0; ErrAData[1] = 0.0;
		ODSData[2] = 3.43; AmideData[2] = 0.45; MwData[2]= 146.1430; ErrOData[2]= 0.0; ErrAData[2] = 0.0;
		ODSData[3] = -1.96; AmideData[3] = 0.96; MwData[3]= 146.1430; ErrOData[3]= 0.0; ErrAData[3] = 0.0;
		ODSData[4] = 0.72; AmideData[4] = 1.08; MwData[4]= 162.1424; ErrOData[4]= 0.0; ErrAData[4] = 0.0;
		ODSData[5] = 4.44; AmideData[5] = 0.21; MwData[5]= 203.1950; ErrOData[5]= 0.0; ErrAData[5] = 0.0;
		ODSData[6] = 0.09; AmideData[6] = 0.37; MwData[6]= 132.1161; ErrOData[6]= 0.0; ErrAData[6] = 0.0;
		ODSData[7] = -0.53; AmideData[7] = 1.18; MwData[7]= 162.1424; ErrOData[7]= 0.0; ErrAData[7] = 0.0;
		ODSData[8] = -0.19; AmideData[8] = 1.04; MwData[8]= 162.1424; ErrOData[8]= 0.0; ErrAData[8] = 0.0;
		ODSData[9] = -2.21; AmideData[9] = 0.70; MwData[9]= 203.1950; ErrOData[9]= 0.0; ErrAData[9] = 0.0;
		ODSData[10] = 1.21; AmideData[10] = 0.58; MwData[10]= 203.1950; ErrOData[10]= 0.0; ErrAData[10] = 0.0;
		ODSData[11] = -0.67; AmideData[11] = 0.89; MwData[11]= 162.1424; ErrOData[11]= 0.0; ErrAData[11] = 0.0;
		ODSData[12] = 1.75; AmideData[12] = 0.35; MwData[12]= 203.1950; ErrOData[12]= 0.0; ErrAData[12] = 0.0;
		ODSData[13] = 2.03; AmideData[13] = 0.38; MwData[13]= 203.1950; ErrOData[13]= 0.0; ErrAData[13] = 0.0;
		ODSData[14] = 0.06; AmideData[14] = 0.33; MwData[14]= 203.1950; ErrOData[14]= 0.0; ErrAData[14] = 0.0;
		ODSData[15] = -0.48; AmideData[15] = 0.81; MwData[15]= 162.1424; ErrOData[15]= 0.0; ErrAData[15] = 0.0;
		ODSData[16] = -1.00; AmideData[16] = 1.06; MwData[16]= 162.1424; ErrOData[16]= 0.0; ErrAData[16] = 0.0;
		ODSData[17] = 0.24; AmideData[17] = 0.81; MwData[17]= 162.1424; ErrOData[17]= 0.0; ErrAData[17] = 0.0;
		ODSData[18] = 0.33; AmideData[18] = 0.44; MwData[18]= 203.1950; ErrOData[18]= 0.0; ErrAData[18] = 0.0;
		ODSData[19] = 0.86; AmideData[19] = 0.58; MwData[19]= 162.1424; ErrOData[19]= 0.0; ErrAData[19] = 0.0;
		ODSData[20] = -0.20; AmideData[20] = 1.06; MwData[20]= 146.1430; ErrOData[20]= 0.0; ErrAData[20] = 0.0;
		ODSData[21] = 0.13; AmideData[21] = 0.89; MwData[21]= 162.1424; ErrOData[21]= 0.0; ErrAData[21] = 0.0;
		ODSData[22] = 1.04; AmideData[22] = 0.56; MwData[22]= 203.1950; ErrOData[22]= 0.0; ErrAData[22] = 0.0;
		ODSData[23] = 0.49; AmideData[23] = -0.33; MwData[23]= 291.2579; ErrOData[23]= 0.0; ErrAData[23] = 0.0;
		ODSData[24] = 0.54; AmideData[24] = 0.91; MwData[24]= 162.1424; ErrOData[24]= 0.0; ErrAData[24] = 0.0;
		ODSData[25] = -0.15; AmideData[25] = 0.79; MwData[25]= 146.1430; ErrOData[25]= 0.0; ErrAData[25] = 0.0;
		ODSData[26] = 0.67; AmideData[26] = 0.77; MwData[26]= 162.1424; ErrOData[26]= 0.0; ErrAData[26] = 0.0;
		ODSData[27] = -0.75; AmideData[27] = 1.05; MwData[27]= 146.1430; ErrOData[27]= 0.0; ErrAData[27] = 0.0;
		ODSData[28] = 1.33; AmideData[28] = 0.93; MwData[28]= 162.1424; ErrOData[28]= 0.0; ErrAData[28] = 0.0;
		ODSData[29] = 0.98; AmideData[29] = 0.52; MwData[29]= 203.1950; ErrOData[29]= 0.0; ErrAData[29] = 0.0;
		ODSData[30] = -0.40; AmideData[30] = 0.90; MwData[30]= 162.1424; ErrOData[30]= 0.0; ErrAData[30] = 0.0;
		ODSData[31] = -0.51; AmideData[31] = 0.36; MwData[31]= 291.2579; ErrOData[31]= 0.0; ErrAData[31] = 0.0;
		ODSData[32] = 0.38; AmideData[32] = -0.61; MwData[32]= 291.2579; ErrOData[32]= 0.0; ErrAData[32] = 0.0;
		ODSData[33] = 1.52; AmideData[33] = 0.45; MwData[33]= 203.1950; ErrOData[33]= 0.0; ErrAData[33] = 0.0;
		ODSData[34] = -0.90; AmideData[34] = 0.37; MwData[34]= 307.2573; ErrOData[34]= 0.0; ErrAData[34] = 0.0;
		ODSData[35] = 1.63; AmideData[35] = 0.14; MwData[35]= 291.2579; ErrOData[35]= 0.0; ErrAData[35] = 0.0;
		ODSData[36] = 0.92; AmideData[36] = -0.40; MwData[36]= 291.2579; ErrOData[36]= 0.0; ErrAData[36] = 0.0;
		ODSData[37] = 1.10; AmideData[37] = 0.03; MwData[37]= 307.2573; ErrOData[37]= 0.0; ErrAData[37] = 0.0;
		ODSData[38] = 2.74; AmideData[38] = 0.76; MwData[38]= 162.1424; ErrOData[38]= 0.0; ErrAData[38] = 0.0;
		ODSData[39] = 0.88; AmideData[39] = 0.32; MwData[39]= 203.1950; ErrOData[39]= 0.0; ErrAData[39] = 0.0;
		ODSData[40] = 2.46; AmideData[40] = 0.26; MwData[40]= 291.2579; ErrOData[40]= 0.0; ErrAData[40] = 0.0;
		ODSData[41] = 0.31; AmideData[41] = -0.38; MwData[41]= 291.2579; ErrOData[41]= 0.0; ErrAData[41] = 0.0;
		ODSData[42] = 2.01; AmideData[42] = 0.89; MwData[42]= 162.1424; ErrOData[42]= 0.0; ErrAData[42] = 0.0;
		ODSData[43] = 1.89; AmideData[43] = -0.31; MwData[43]= 291.2579; ErrOData[43]= 0.0; ErrAData[43] = 0.0;
		ODSData[44] = 2.79; AmideData[44] = 0.83; MwData[44]= 162.1424; ErrOData[44]= 0.0; ErrAData[44] = 0.0;
		ODSData[45] = -3.06; AmideData[45] = 0.51; MwData[45]= 307.2579; ErrOData[45]= 0.0; ErrAData[45] = 0.0;
		ODSData[46] = -1.88; AmideData[46] = 0.17; MwData[46]= 291.2579; ErrOData[46]= 0.0; ErrAData[46] = 0.0;
		ODSData[47] = 0.31; AmideData[47] = -0.46; MwData[47]= 291.2579; ErrOData[47]= 0.0; ErrAData[47] = 0.0;
		ODSData[48] = -2.62; AmideData[48] = 0.97; MwData[48]= 162.1424; ErrOData[48]= 0.0; ErrAData[48] = 0.0;
		ODSData[49] = 1.30; AmideData[49] = -0.29; MwData[49]= 203.1950; ErrOData[49]= 0.0; ErrAData[49] = 0.0;
		ODSData[50] = 8.87; AmideData[50] = 0.30; MwData[50]= 146.1430; ErrOData[50]= 0.0; ErrAData[50] = 0.0;
		ODSData[51] = 0.80; AmideData[51] = 0.69; MwData[51]= 203.1950; ErrOData[51]= 0.0; ErrAData[51] = 0.0;
		ODSData[52] = -0.05; AmideData[52] = 0.90; MwData[52]= 162.1424; ErrOData[52]= 0.0; ErrAData[52] = 0.0;
		ODSData[53] = 0.39; AmideData[53] = 1.09; MwData[53]= 162.1424; ErrOData[53]= 0.0; ErrAData[53] = 0.0;
		ODSData[54] = 1.24; AmideData[54] = 1.36; MwData[54]= 162.1424; ErrOData[54]= 0.0; ErrAData[54] = 0.0;
		ODSData[55] = 0.61; AmideData[55] = 1.01; MwData[55]= 162.1424; ErrOData[55]= 0.0; ErrAData[55] = 0.0;
		ODSData[56] = -1.07; AmideData[56] = 0.98; MwData[56]= 162.1424; ErrOData[56]= 0.0; ErrAData[56] = 0.0;
		ODSData[57] = -0.39; AmideData[57] = 0.85; MwData[57]= 162.1424; ErrOData[57]= 0.0; ErrAData[57] = 0.0;
		ODSData[58] = 1.25; AmideData[58] = 0.37; MwData[58]= 162.1424; ErrOData[58]= 0.0; ErrAData[58] = 0.0;
		ODSData[59] = -0.29; AmideData[59] = 0.90; MwData[59]= 162.1424; ErrOData[59]= 0.0; ErrAData[59] = 0.0;
		ODSData[60] = -0.58; AmideData[60] = 0.75; MwData[60]= 162.1424; ErrOData[60]= 0.0; ErrAData[60] = 0.0;
		ODSData[61] = -2.00; AmideData[61] = 0.71; MwData[61]= 162.1424; ErrOData[61]= 0.0; ErrAData[61] = 0.0;
		//ODSData[62] = 1.11; AmideData[62] = 1.11; MwData[62]= 1.11; ErrOData[62]= 1.11; ErrAData[62] = 1.11;
		//ODSData[63] = 1.11; AmideData[63] = 1.11; MwData[63]= 1.11; ErrOData[63]= 1.11; ErrAData[63] = 1.11;
		//ODSData[64] = 1.11; AmideData[64] = 1.11; MwData[64]= 1.11; ErrOData[64]= 1.11; ErrAData[64] = 1.11;
		//ODSData[65] = 1.11; AmideData[65] = 1.11; MwData[65]= 1.11; ErrOData[65]= 1.11; ErrAData[65] = 1.11;
		//ODSData[66] = 1.11; AmideData[66] = 1.11; MwData[66]= 1.11; ErrOData[66]= 1.11; ErrAData[66] = 1.11;
		//ODSData[67] = 1.11; AmideData[67] = 1.11; MwData[67]= 1.11; ErrOData[67]= 1.11; ErrAData[67] = 1.11;
		//ODSData[68] = 1.11; AmideData[68] = 1.11; MwData[68]= 1.11; ErrOData[68]= 1.11; ErrAData[68] = 1.11;
		//ODSData[69] = 1.11; AmideData[69] = 1.11; MwData[69]= 1.11; ErrOData[69]= 1.11; ErrAData[69] = 1.11;


		sa[0] = "";
		sa[1] = "0";
		sa[2] = "00";
		sa[3] = "000";
		sa[4] = "0000";
		sa[5] = "00000";
		sa[6] = "000000";
		sa[7] = "0000000";
		sa[8] = "00000000";
		sa[9] = "000000000";
		sa[10] = "0000000000";
		sa[11] = "00000000000";
		sa[12] = "000000000000";
	}

	void quick(int a[],int left,int right){
		int s,t,i,j;
		if(left<right){
			s=a[(left+right)/2];
			i=left-1;j=right+1;
			while(true){
				while (a[++i]<s);
				while (a[--j]>s);
				if(i>=j)break;
				t=a[i];a[i]=a[j];a[j]=t;
			}
			quick(a,left,i-1);
			quick(a,j+1,right);
		}

	}

	String Spliter(String target){
		String dumysplit;
		String returnString = "";
		int i = 0;
		StringTokenizer st = new StringTokenizer(target,"-");
		while(st.hasMoreTokens())
		{
			dumysplit = st.nextToken();
			quicktarget[i] = Integer.valueOf(dumysplit).intValue();
			i++;
		}
		quickN = i;
		quick(quicktarget,0,quickN-1);
		for(i=0;i<quickN;i++){
			System.out.println(quicktarget[i]);
			if(i==0){
				dumysplit = String.valueOf(quicktarget[i]);
				returnString = dumysplit;
			}
			else{
				dumysplit = String.valueOf(quicktarget[i]);
				returnString = returnString + "-" + dumysplit;
			}
		}

		return returnString;

	}
}