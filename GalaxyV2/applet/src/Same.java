import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog.*;
import java.util.*;
import java.lang.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
import java.io.IOException;
public class Same{

	private final int DATAREAD = 470;
	private final int SET_AXIS = 10;
	private final int ARRAY_LENGTH = 567;

    double[] amide = new double[ARRAY_LENGTH];

	double[] array0amide = new double[ARRAY_LENGTH];
	double[] array1amide = new double[ARRAY_LENGTH];
	double[] array2amide = new double[ARRAY_LENGTH];
	double[] array3amide = new double[ARRAY_LENGTH];
	double[] array4amide = new double[ARRAY_LENGTH];

	double[] ods = new double[ARRAY_LENGTH];

	double[] array0ods = new double[ARRAY_LENGTH];
	double[] array1ods = new double[ARRAY_LENGTH];
	double[] array2ods = new double[ARRAY_LENGTH];
	double[] array3ods = new double[ARRAY_LENGTH];
	double[] array4ods = new double[ARRAY_LENGTH];

	double[] mw = new double[ARRAY_LENGTH];

	double[] array0mw = new double[ARRAY_LENGTH];
	double[] array1mw = new double[ARRAY_LENGTH];
	double[] array2mw = new double[ARRAY_LENGTH];
	double[] array3mw = new double[ARRAY_LENGTH];
	double[] array4mw = new double[ARRAY_LENGTH];

	int datanum;
	int itemFound = 0;
	int man = 0;
	rule r = new rule();
	String SimSt[] = new String[ARRAY_LENGTH];
	String Code[] = new String[ARRAY_LENGTH];

	double[] errorOdsArray = new double[99];
	double[] errorAmideArray = new double[99];

	//enzime arrays
	int[][] enzime = new int[7][ARRAY_LENGTH];

	//return and for loop counters
	int aa = 0;
	int add = 0;
	int i = 0;

	String m_FileName = "output";
	String samefName = "output11";
	String difffName = "diff11";
	File sameFile;
	File diffFile;
	RandomAccessFile raf;
	RandomAccessFile daf;
	FileOutputStream fos;
	FileOutputStream dos;
	PrintStream ps;
	PrintStream ds;

	int total = 0;

	Same( InputStream is, InputStream ds) throws Exception{
		String Co,Ss;
		Co = ""; Ss = "";
		double x,y,z;
		int e0,e1,e2,e3,e4,e5;
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
		st.eolIsSignificant(true);
		st.commentChar('#');
		int token;
		int i = 0;
		try{
			st.nextToken();
			while((token = st.nextToken()) != StreamTokenizer.TT_EOF)
			{
				Co = (String)st.sval; st.nextToken();
				Ss =(String)st.sval; st.nextToken();
				x = (double)st.nval; st.nextToken();
				y = (double)st.nval; st.nextToken();
				z = (double)st.nval; st.nextToken();
				e0 = (int)st.nval; st.nextToken();
				e1 = (int)st.nval; st.nextToken();
				e2 = (int)st.nval; st.nextToken();
				e3 = (int)st.nval; st.nextToken();
				e4 = (int)st.nval; st.nextToken();
				e5 = (int)st.nval; st.nextToken();
				Code[i] = Co;	SimSt[i] = Ss;
				ods[i] = x; amide[i] = y; mw[i] = z;
				if(i < DATAREAD){
					if(Code[i].startsWith("A", 1) || Code[i].startsWith("G", 1)){
						char a = Code[i].charAt(0);
						String test = Code[i].valueOf(a);
						if(test.equals("1")){
							array1ods[i] = x;
							array1amide[i] = y;
							array1mw[i] = z;
						}else if(test.equals("2")){
							array2ods[i] = x;
							array2amide[i] = y;
							array2mw[i] = z;
						}else if(test.equals("3")){
							array3ods[i] = x;
							array3amide[i] = y;
							array3mw[i] = z;
						}else if(test.equals("4")){
							array4ods[i] = x;
							array4amide[i] = y;
							array4mw[i] = z;
						}
					}else{
						array0ods[i] = x;
						array0amide[i] = y;
						array0mw[i] = z;
					}
				}
				ods[i] = (x) ; amide[i] = (y); mw[i] =( z);
				enzime[0][i] = e0; enzime[1][i] = e1; enzime[2][i] = e2;
				enzime[3][i] = e3; enzime[4][i] = e4; enzime[5][i] = e5;
				i ++;
			}
			datanum = i;
		}catch(Exception e)	{
			System.out.println("Error " + e);
		}

		//Unknown data reading
/*
		StreamTokenizer dt = new StreamTokenizer(new BufferedReader(new InputStreamReader(ds)));
		dt.eolIsSignificant(true);
		dt.commentChar('#');
		int token;
		try{
			dt.nextToken();
			while((token = dt.nextToken()) != StreamTokenizer.TT_EOF)
			{
				Co = (String)dt.sval; dt.nextToken();
				Ss =(String)dt.sval; dt.nextToken();
				x = (double)dt.nval; dt.nextToken();
				y = (double)dt.nval; dt.nextToken();
				z = (double)dt.nval; dt.nextToken();
				errorOds = (double)dt.nval; dt.nextToken();
				errorAmide = (double)dt.nval; dt.nextToken();
				Code[i] = Co;	SimSt[i] = Ss;
				ods[i] = x; amide[i] = y; mw[i] = z;
				if(Code[i].startsWith("A", 1) || Code[i].startsWith("G", 1)){
					ods[i] = x;
					amide[i] = y;
					mw[i] = z;

				}
				ods[i] = (x) ; amide[i] = (y); mw[i] =( z);
				enzime[0][i] = e0; enzime[1][i] = e1; enzime[2][i] = e2;
				enzime[3][i] = e3; enzime[4][i] = e4; enzime[5][i] = e5;
				i ++;
			}
			datanum = i;
		}catch(Exception e)	{
			System.out.println("Error " + e);
		}*/
	}
}