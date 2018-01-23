import java.applet.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.awt.Dialog.*;
import java.lang.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
import java.io.IOException;

public class GalaxySystem2 extends Applet implements ActionListener, MouseListener, ItemListener{	//, TextListener{

	private final int DATAREAD = 470;							//配列の長さ
	private final int ARRAY_LENGTH = 567;
	private final int POINT_SIZE = 6;								//表示されたグラフポイントのサイズ
	private final double ZX = 0.5;									//拡大縮小の係数
	private final int END_ZOOM = 4;   								//拡大 (default:3)
	private final int ENZIME_TYPES = 7;
	private final String URL_STRING = "../OligoHTML0/";
	private final double ODS_AMIDE_CONST = 0.05;
	private final double MW_CONSTANT = 3;

	private String setItem = AllFinals.SELECT;
	private String error = "";
	public String codeString = "";								//ＣｏｄｅＦｒａｍｅクラスのテキストフィールド履歴

	private int allMichiCounter = 0;
	private int michiTest = 0;

	//"DRAW WINDOW" PARAMETERS
	private double x1, y1, x2, y2;												//サポート変数メモリ上
	private int y1m, y2m, byYY1m;
	private double ZOOM;														//拡大と縮小の時XXとYYの値を作るために使ったパラメータ(OAの場合)
	private double ZOOM2;														//拡大と縮小の時XXとYYの値を作るために使ったパラメータ(OMの場合)
	private double ZOOM3;														//拡大と縮小の時XXとYYの値を作るために使ったパラメータ(AMの場合)
	private double XX1,YY1,XX2,YY2;												//グラフメモリの最大と最小
	private double byXX1, byYY1;												//グラフメモリセンター

	//VARIABLE TO HOLD `FOR` LOOPER VALUE
	private int testset = -1;
	private int choicePoint;
	private int delArrow = 0;

    //基本グラフを書くための値を保存するアレー
	private double[] amide = new double[ARRAY_LENGTH];
    //細かいグラフを書くために値を保存するアレー
	private double[] array0amide = new double[ARRAY_LENGTH];
	private double[] array1amide = new double[ARRAY_LENGTH];
	private double[] array2amide = new double[ARRAY_LENGTH];
	private double[] array3amide = new double[ARRAY_LENGTH];
	private double[] array4amide = new double[ARRAY_LENGTH];

    //基本グラフを書くための値を保存するアレー
	private double[] ods = new double[ARRAY_LENGTH];
    //細かいグラフを書くために値
	private double[] array0ods = new double[ARRAY_LENGTH];
	private double[] array1ods = new double[ARRAY_LENGTH];
	private double[] array2ods = new double[ARRAY_LENGTH];
	private double[] array3ods = new double[ARRAY_LENGTH];
	private double[] array4ods = new double[ARRAY_LENGTH];

    //基本グラフを書くための値を保存するアレー
    private double[] mw = new double[ARRAY_LENGTH];
    //細かいグラフを書くために値
	private double[] array0mw = new double[ARRAY_LENGTH];
	private double[] array1mw = new double[ARRAY_LENGTH];
	private double[] array2mw = new double[ARRAY_LENGTH];
	private double[] array3mw = new double[ARRAY_LENGTH];
	private double[] array4mw = new double[ARRAY_LENGTH];

	//基本グラフを書くための値を保存するアレー
	private String SimSt[] = new String[ARRAY_LENGTH];
	private String Code[] = new String[ARRAY_LENGTH];

	//基本グラフを書くための値を保存するアレー
	private int[][] enzimeData = new int[ENZIME_TYPES][ARRAY_LENGTH];
	private int[] michiDataNumber = new int[7];

	//コンボボックス
	private Choice selectGraph;													//基本グラフを選択するためにコンボボックス
	private Choice mono = new Choice();									//シアリックアシッドを選択するためにコンボボックス
	public Choice enzime = new Choice();									//エンザイム種類を選択するためにコンボボックス

	//COMBO BOX SWITCHES
	private int graphSwitch;														//基本グラフスイッチ変数

	//ボタン
	private Button zoomIn;														//拡大ボタン
	private Button zoomOut;														//縮小ボタン
	public Button buttonArrow = new Button("Show Product");		//矢印
	private Button buttonExp;													//研究値を表示されるボタン
	private Button arrowRight;													//マップのXXを変更する
	private Button arrowLeft;													//マップのXXを変更する
	private Button arrowUp;														//マップのYYを変更する
	private Button arrowDown;													//マップのYYを変更する
	private Button buttonCenter;												//選択したポイントをセンターにしてグラフを表示する
	private Button codeData;														//コードによってポイントを書く
	private Button resetButton;													//リセットボタン

	// TEXT FIELDS AND LABELS
	private TextField  fieldAmide;												//Amideテキストフィールド
	private TextField fieldOds;													//Odsテキストフィールド
	private TextField fieldMw;													//Mwテキストフィールド
	private Label lOds;																//Odsラベル
	private Label lAmide;															//Amideラベル
	private Label lMw;																//Mwラベル

	private TextField  erAmide;													//エラーテキストフィールド
	private TextField erOds;														//エラーテキストフィールド
	private TextField erMw;														//エラーテキストフィールド
	private Label loError;															//ラベル
	private Label laError;															//ラベル
	private Label lmError;															//ラベル
	private Label errorLabel;

	//テキストフィールドから取得した Stringの値
	private String graphType = "";												//選択したグラフの種類を持つ
	private String sAmide;
	private String sOds;
	private String sMw;
	private String serAmide;
	private String serOds;
	private String serMw;

	//研究の値をDoubleにして持つ変数
	private double setOds;
	private double setAmide;
	private double setMw;
	private double setErOds;
	private double setErAmide;
	private double setErMw;


	//カウンター
	private int mouseCounter;													//マウスクリックカウンター
	private int buttonCounter;													//ボタンクリックカウンター
	private int inCounter;  														//拡大カウンター
	private int arrowCounter;													//矢印カウンター
	private int errorCounter;														//エラー処理カウンター
	private int doubleClickCounter = 0;										//ダブルクリックカウンター
	private int enzimeCounter = 0;												//エンザイム処理カウンター
	private int dialogCounter = 0;												//重複の場合新しいダヤロッグを表示されるために使ったカウンター
	private int zenCounter = 0;													//全体カウンター
	private int michiCounter = 0;												//未知の矢印を書くために
	private int errorMsg = 0;														//ALL の場合エラーメッセージを出す。
	public int mouseMem = -1;
	public int historyPoint = -1;
	public int HistP = -1;
	public int sialicId = -1;
	
	// " Sialic専用パラメータ
	public int set1 =0;
	public int set2;
	public int sialicflag = 0;

	//"FOR" ループカウンター
	private int set;
	private int i;
	private int gr1;
	private int common;
	private int loopCounter = DATAREAD;

	//クラスオブジェクト
	private MonoSwitchSet monoSwitchSet;
	private Same s;																	//グラフデータをアプレットで保存する
	private rule r;																		//エンザイム処理と矢印を書くためのデータの判断
	private ArrowSetpoint arrow;												//矢印を書く
	private PopupMenu pmn;														//JAVA　API
	private MenuItem mn1;														//JAVA　API
	private MenuItem mn2;														//JAVA　API
	private MenuItem mn3;														//JAVA　API
	private MenuItem mn4;														//JAVA　API
	Frame f;																			//JAVA　API
	private Panel p;																	//JAVA　API
	private Panel component;													//JAVA　API
	public Panel allPanel = new Panel();										//JAVA　API
	private Panel upperPanel;													//JAVA　API
	private Panel bottomPanel;													//JAVA  API
	private Panel arrowColorPallette;											//JAVA  API
	private TDPanel td;																//Structureを書くクラス
	private ItemEvent ie;															//JAVA　API
	private GraphicMaker t;														//グラフの形を決まるクラス（ユーザークラス）
	private Graphics gg;

	public Checkbox showMichiSelect = new Checkbox("Show Unknown", false);
	//private ShowMichi showmichi = new ShowMichi(showMichiSelect);

	public CheckboxGroup group = new CheckboxGroup();
	public Checkbox upperArrow = new Checkbox("u", true, group);
	public Checkbox lowerArrow = new Checkbox("", false, group);

	private EnzimeLabel ep = new EnzimeLabel(20,515,340,75);
	public EnzimeSwitchSetUp test = new EnzimeSwitchSetUp(enzime);

	private CheckBoxEvent checkBoxEvent = new CheckBoxEvent(group, enzime, upperArrow, lowerArrow, buttonArrow, ep, allPanel, test);
	private CodeFrame codeFrame;


	//基本データを読む、テキストファイル名
	private String m_FileName = "outputNew.txt";
	private String d_FileName = "outputnuKnown.txt";

	//テキストファイルから読んだデータの長さ
	private int datanum;

	//マウスクリックのXとYの原点
	private double ansx = 0;					//GraphicsMakerクラスから計算されたマウスクリックのX原点
	private double ansy = 0;					//GraphicsMakerクラスから計算されたマウスクリックのY原点
	private double arrowx = 0;
	private double arrowy = 0;
	private int x,y;								//マウスクリックの計算される前の値

	//矢印のエンドポイント
	private double arrowX = 0;				//一つの種類を選択した時使ったX原点
	private double arrowY = 0;				//一つの種類を選択した時使ったY原点
	private double[] arrowXX = new double[7];	//ALLを選択した場合
	private double[] arrowYY = new double[7];	//ALLを選択した場合

	//重複の場合ダイアログに重複の値を渡すために使ったアレー
	private int[] frameArray;

	//研究結果の原点を書くために作った変数
	private double expx;
	private double expy;
	private double errorx;
	private double errory;

	private int xx1,yy1;
	private int[] xx1a = new int[7];
	private int[] yy1a = new int[7];
	private double xx2,xx3,yy2,yy3;
	private double[] xx2a = new double[7];
	private double[] xx3a = new double[7];
	private double[] yy2a = new double[7];
	private double[] yy3a = new double[7];
	Panel canUpper;
	
	
	// Version2 追加変数 デフォルトパラメータ
	private String user_id;
	private String mark1;
	private String mark2;
	private String mark3;
	private String markSt1;
	private String markSt2;
	private String markSt3;
	private String markC1;
	private String markC2;
	private String markC3;
	private String defaultmap;
	private String background;
	private String zoom_x;
	private String zoom_y;
	private String zoom_v;
	//
	
	// Version2 Optional Search Method + Component
	private MultiSearchFrame mySearch;
	Image TreeImage;
	Image CodeImage;
	private Button SearchButton;
	private Button markB1;
	private Button markB2;
	private Button markB3;
	private Button markBrs;
	
	/*
	// PASSWORD AUTHENTICATION
	private boolean isAuthenticate = false;
	String userName = "";
	String password = "";
	TextField name;
	TextField pass;
	Button check;
	*/
	
	public void loadParam(){
		
		// パラメータロード
		user_id = getParameter("user_id");
		mark1 = getParameter("mark1");
		mark2 = getParameter("mark2");
		mark3 = getParameter("mark3");
		markSt1 = getParameter("markSt1");
		markSt2 = getParameter("markSt2");
		markSt3 = getParameter("markSt3");
		markC1 = getParameter("markC1");
		markC2 = getParameter("markC2");
		markC3 = getParameter("markC3");
		defaultmap = getParameter("defaultmap");
		background = getParameter("background");
		
		zoom_x = getParameter("zoom_x");
		zoom_y = getParameter("zoom_y");
		zoom_v = getParameter("zoom_v");
	}
	public void init(){
		
		loadParam();
		
		/*	
		if(!isAuthenticate){
			setLayout(null);
			name = new TextField();
			name.setBounds(100, 100, 80, 20);
			add(name);
			pass = new TextField();
			pass.setBounds(100, 150, 80, 20);
			add(pass);
			check = new Button("AUTHENTICATE");
			check.setBounds(100, 200, 100, 20);
			add(check);
			check.addActionListener(this);
		}else{*/
		
		frameArray = new int[ARRAY_LENGTH];
		InputStream is = null;
		InputStream ds = null;
		try{
			is = new URL(getDocumentBase(),m_FileName).openStream();
			ds = new URL(getDocumentBase(),d_FileName).openStream();
			s = new Same(is, ds);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(is !=null)
				is.close();
		}catch(Exception e){
			System.out.println("ERROR IN READING INPUT DATA" + e);
		}
		r = new rule();
		arrow = new ArrowSetpoint();
		setLayout(null);
		this.setBackground(new Color(245,245,245));    			// グラフィック領域のカラー設定 default new Color(255,255,255)
		XX1 = 0;
		YY1 = 0;
		XX2 = 28;
		YY2 = 20;
		ZOOM = 14;
		ZOOM2 = 10;
		ZOOM3 = 2000;

		//SWITCH 初期化
		graphSwitch = 0;
		choicePoint = 0;

		//COUNTERS初期化
		mouseCounter = 0;
		buttonCounter = 0;
		//testCounter = 0;

		//set basic data
		this.ods = s.ods;
		this.amide = s.amide;
		this.mw = s.mw;

		//set mono data
		this.array0amide = s.array0amide;
		this.array1amide = s.array1amide;
		this.array2amide = s.array2amide;
		this.array3amide = s.array3amide;
		this.array4amide = s.array4amide;

		this.array0ods = s.array0ods;
		this.array1ods = s.array1ods;
		this.array2ods = s.array2ods;
		this.array3ods = s.array3ods;
		this.array4ods = s.array4ods;

		this.array0mw = s.array0mw;
		this.array1mw = s.array1mw;
		this.array2mw = s.array2mw;
		this.array3mw = s.array3mw;
		this.array4mw = s.array4mw;

		//SET ENZIME DATA
		enzimeData = s.enzime;

		//SET STRUCTURE DATA
		this.SimSt = s.SimSt;

		//SET CODE DATA
		this.Code = s.Code;

		addMouseListener(this);

		//MOUSE RIGHT CLICK MENU ADDED
		pmn = new PopupMenu();
		mn1 = new MenuItem("ZOOM++");
		mn1.addActionListener(this);
		mn2 = new MenuItem("ZOOM--");
		mn2.addActionListener(this);
		mn3 = new MenuItem("HTML Link");
		mn3.addActionListener(this);
		mn4 = new MenuItem("KEGG Glycan Link");
		mn4.addActionListener(this);
		pmn.add(mn1);
		pmn.addSeparator();
		pmn.add(mn2);
		pmn.addSeparator();
		pmn.add(mn3);
		pmn.addSeparator();
		pmn.add(mn4);
		add(pmn);

		Color color = Color.white;                       // コントロールのカラー設定 default new Color(255,255,255)

		//panel to shadow extreme left portion of grpah
		Panel leftPanel = new Panel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0,60,10,650);
		leftPanel.setBackground(color);
		add(leftPanel);

		//Panel to shadow upperPortion of the Graph
		upperPanel = new Panel();
		upperPanel.setLayout(null);
		upperPanel.setBounds(0,0,500,95);
		upperPanel.setBackground(color);
		add(upperPanel);

		canUpper = new Panel();
		canUpper.setBackground(color);
		canUpper.setSize(500,25);
		canUpper.setBounds(0,0,500,25);
		upperPanel.add(canUpper);

		//panel to shadow bottom of the graph
		bottomPanel = new Panel();
		bottomPanel.setLayout(null);
		bottomPanel.setBounds(0, 550, 500, 150);       // 0,580,500,150
		bottomPanel.setBackground(color);
		bottomPanel.setBackground(new Color(230,255,230));
		add(bottomPanel);

		//Panel to Shadow the applet frame
		allPanel.setLayout(null);
		allPanel.setBounds(500, 0, 560, 700);
		allPanel.setBackground(color);
		add(allPanel);
		Panel canUpper2 = new Panel();
		canUpper2.setBackground(color);
		canUpper2.setSize(500,25);
		canUpper2.setBounds(0,0,560,25);
		allPanel.add(canUpper2);

		Font titleFont = new Font("Times New Roman", Font.BOLD, 15);
		Label title = new Label(AllFinals.PROJECT_NAME);
		title.setForeground(Color.red);
		title.setBounds(0,5,20, 20);
		title.setFont(titleFont);
		canUpper.add(title);

		allPanel.add(ep);

		//システムリセットボタン
		resetButton = new Button("RESET ALL");
		resetButton.setBounds(5,30,80,20);
		resetButton.addActionListener(this);
		upperPanel.add(resetButton);

		//michi data diplay // non display
		//showMichiSelect.setBounds(50, 20, 110, 20);
		//bottomPanel.add(showMichiSelect);
		//showMichiSelect.addItemListener(this);

		//BASIC GRAPH COMBO BOX IS ADDED
		selectGraph = new Choice();
		selectGraph.setBounds(110, 30, 100, 30);
		selectGraph.addItemListener(this);
		//selectGraph.addItem(AllFinals.SELECT);
		selectGraph.addItem(AllFinals.OA);
		selectGraph.addItem(AllFinals.OM);
		selectGraph.addItem(AllFinals.AM);
		upperPanel.add(selectGraph);
		//add(selectGraph);

		Label sialic = new Label("Sialic Acid");
		sialic.setBounds(218, 32, 60, 20);
		upperPanel.add(sialic);
		sialic.setForeground(Color.black);

		monoSwitchSet = new MonoSwitchSet(mono, this);

		//SIALIC ACIDE COMBO BOX IS ADDED
		mono.setBounds(280, 30, 50, 30);
		mono.addItem("ALL");
		mono.addItem("0");
		mono.addItem("1");
		mono.addItem("2");
		mono.addItem("3");
		mono.addItem("4");
		upperPanel.add(mono);
		//add(mono);
		mono.addItemListener(monoSwitchSet);

		// "ZOOM ++" BUTTON IS ADDED
		String buttonName = "ZOOM++";
		zoomIn = new Button(buttonName);
		upperPanel.add(zoomIn);
		//add(zoomIn);
		zoomIn.setBounds(340, 30, 60, 20);
		zoomIn.addActionListener(this);

		//"ZOOM --" BUTTON IS ADDED
		buttonName = "ZOOM--";
		zoomOut = new Button(buttonName);
		upperPanel.add(zoomOut);
		//add(zoomOut);
		zoomOut.setBounds(410, 30, 60, 20);
		zoomOut.addActionListener(this);

		//ENZIME COMBO BOX IS ADDED
		enzime.add("\u03b1-Galactosidase");
		enzime.add("\u03b1-Fucsidase");
		enzime.add("\u03b2-Galactosidase");
		enzime.add("\u03b2-HexNAcase");
		enzime.add("\u03b2-Xylosidase");
		enzime.add("\u03b1-Sialidase");
		enzime.add("ALL");
		allPanel.add(enzime);
		enzime.setBounds(180,463,140,25);
		enzime.addItemListener(test);

		Font font = new Font("Arial Black", Font.BOLD, 15);

		//CHECK BOXES ARE ADDED
		Label up = new Label("\u2193");
		up.setFont(font);
		up.setBounds(46, 460, 20, 20);
		allPanel.add(up);
		allPanel.add(upperArrow);
		upperArrow.addItemListener(checkBoxEvent);
		upperArrow.setBounds(30, 460, 20, 20);

		Label down = new Label("\u2191");
		down.setFont(font);
		down.setBounds(126, 460, 20, 20);
		allPanel.add(down);
		allPanel.add(lowerArrow);
		lowerArrow.setBounds(110, 460, 20, 20);
		lowerArrow.addItemListener(checkBoxEvent);

		//BUTTON TO SHOW AN ARROW IS ADDED
		allPanel.add(buttonArrow);
		buttonArrow.setBounds(30, 490, 100, 20);
		buttonArrow.addActionListener(this);

		// TEXTFIELD AND LABELS ARE CREATED AND SET
		fieldOds = new TextField();
		allPanel.add(fieldOds);
		fieldOds.setBounds(200, 35, 50, 25);

		fieldAmide = new TextField();
		allPanel.add(fieldAmide);
		fieldAmide.setBounds(200, 70, 50, 25);

		fieldMw = new TextField();
		allPanel.add(fieldMw);
		fieldMw.setBounds(200, 105, 50, 25);

		erOds = new TextField();
		allPanel.add(erOds);
		erOds.setBounds(280, 35, 50, 25);

		erAmide = new TextField();
		allPanel.add(erAmide);
		erAmide.setBounds(280, 70, 50, 25);

		erMw = new TextField();
		allPanel.add(erMw);
		erMw.setBounds(280, 105, 50, 25);

		lOds = new Label("ODS");
		allPanel.add(lOds);
		lOds.setBounds(169, 35, 28, 20);

		lAmide = new Label("AMIDE");
		allPanel.add(lAmide);
		lAmide.setBounds(160, 70, 50, 20);

		lMw = new Label("MW");
		allPanel.add(lMw);
		lMw.setBounds(175, 105, 22, 20);

		loError = new Label("\u00b1");
		allPanel.add(loError);
		loError.setBounds(260, 40, 15, 20);

		laError = new Label("\u00b1");
		allPanel.add(laError);
		laError.setBounds(260, 75, 15, 20);

		lmError = new Label("\u00b1");
		allPanel.add(lmError);
		lmError.setBounds(260, 110, 15, 20);

		//SHOW MY POINTS BUTTON IS ADDED
		buttonName = "PLOT DATA ";
		buttonExp = new Button(buttonName);
		allPanel.add(buttonExp);
		buttonExp.setBounds(220, 140, 100, 20);
		buttonExp.addActionListener(this);

  		buttonName = "\u2192";
		arrowRight = new Button(buttonName);
		allPanel.add(arrowRight);
		arrowRight.setBounds(100, 65, 30, 20);
		arrowRight.addActionListener(this);

		buttonName = "\u2190";
		arrowLeft = new Button(buttonName);
		allPanel.add(arrowLeft);
		arrowLeft.setBounds(20, 65, 30, 20);
		arrowLeft.addActionListener(this);

		buttonName = "\u2191";
		arrowUp = new Button(buttonName);
		allPanel.add(arrowUp);
		arrowUp.setBounds(60, 35, 30, 20);
		arrowUp.addActionListener(this);

		buttonName = "\u2193";
		arrowDown = new Button(buttonName);
		allPanel.add(arrowDown);
		arrowDown.setBounds(60, 95, 30, 20);
		arrowDown.addActionListener(this);

		buttonName = "\u25ce";
		buttonCenter = new Button(buttonName);
		allPanel.add(buttonCenter);
		buttonCenter.setBounds(65, 65, 20, 20);
		buttonCenter.addActionListener(this);
		buttonCenter.setEnabled(false);

		//PANEL IS ADDED AND CANVAS IS ADDED TO THE PANEL
		td = new TDPanel(10, 165, 350, 295);
		allPanel.add(td);

		//error display code
		errorLabel  = new Label();
		font = new Font("Time new Roman", Font.BOLD, 17);
		errorLabel.setFont(font);
		Color errorColor = new Color(230, 10, 10);
		errorLabel.setForeground(errorColor);
		errorLabel.setBounds(15,70,450,20);
		upperPanel.add(errorLabel);

		//Button to set point according to CODE entered by the user
		/*
		codeData = new Button("Code No.Search");
		allPanel.add(codeData);
		codeData.setBounds(30, 140 , 100, 20);
		codeData.addActionListener(this);
		setTextEditable();
		codeData.setVisible(false);
		*/
		
		SearchButton = new Button("Optional Search");
		allPanel.add(SearchButton);
		SearchButton.setBounds(30,140,100,20);
		SearchButton.addActionListener(this);
		
		mySearch = new MultiSearchFrame("Optional Search");
		mySearch.setResizable(false);
		mySearch.setMain(this);
		mySearch.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent eWinEvent){
				mySearch.dispose();
			}
		});
		setTextEditable();
		
		markB1 = new Button(mark1);
		markB1.setBackground(Color.pink);
		markB1.setBounds(10,10,100,20);
		bottomPanel.add(markB1);
		
		markB2 = new Button(mark2);
		markB2.setBackground(Color.cyan);
		markB2.setBounds(110,10,100,20);
		bottomPanel.add(markB2);
		
		markB3 = new Button(mark3);
		markB3.setBackground(new Color(255,255,200));
		markB3.setBounds(210,10,100,20);
		bottomPanel.add(markB3);
		
		markBrs = new Button("Erase");
		markBrs.setBounds(400,10,100,20);
		bottomPanel.add(markBrs);
		
	}
	//}
	
	public Image ImageLoad_tree(){
		TreeImage = getImage(getCodeBase(),"images/tree.jpg");
		return TreeImage;
	}
	
	public Image ImageLoad_code(){
		CodeImage = getImage(getCodeBase(),"images/code.jpg");
		return CodeImage;
	}

	public void actionPerformed(ActionEvent actionevent){
/*		if(actionevent.getSource() == check){
			if(name.getText().equals(userName) && pass.getText().equals(password)){
				System.out.println(name.getText() + "        " + pass.getText());
				isAuthenticate = true;
				remove(check);
				remove(name);
				remove(pass);
				init();
			}
		}*/
		buttonCounter++;
		sOds = fieldOds.getText();
		sAmide = fieldAmide.getText();
		sMw = fieldMw.getText();
		serOds = erOds.getText();
		serAmide = erAmide.getText();
		serMw = erMw.getText();
		
		/*
		//Display point according to CODE entered by User
		if(actionevent.getSource() == codeData){
			for(int clr = 0; clr < ods.length; clr++){
				frameArray[clr] = -1;
			}

			switch(graphSwitch){
				case 0:
					error = "";
					errorLabel.setText(error);
					Frame displayCode0 = new Frame();
					codeData.setEnabled(false);
					codeFrame = new CodeFrame(displayCode0, AllFinals.CODE_NUM_INPUT_FRAME_HEADER, true, Code, loopCounter, codeString);
					codeData.setEnabled(true);
					if(codeFrame.codeNumber == -1){
						error = AllFinals.ERROR_CODE_NOT_FOUND;
						errorLabel.setText(error);
						HistP = codeFrame.codeNumber;
					}else{
						testset = codeFrame.codeNumber;
						HistP = codeFrame.codeNumber;
						ansx = ods[testset];
						ansy = amide[testset];
						choicePoint = testset;
						historyPoint = testset;
						frameArray[testset] = testset;
						td.SetData(SimSt[testset], Code[testset]);
					}
				break;

				case 2:
					error = "";
					errorLabel.setText(error);
					Frame displayCode2 = new Frame();
					codeData.setEnabled(false);
					codeFrame = new CodeFrame(displayCode2, AllFinals.CODE_NUM_INPUT_FRAME_HEADER, true, Code, loopCounter,codeString);
					codeData.setEnabled(true);
					if(codeFrame.codeNumber == -1){
						error = AllFinals.ERROR_CODE_NOT_FOUND;
						errorLabel.setText(error);
						HistP = codeFrame.codeNumber;
					}else{
						testset = codeFrame.codeNumber;
						HistP = codeFrame.codeNumber;
						ansx = ods[testset];
						ansy = mw[testset];
						historyPoint = testset;
						choicePoint = testset;
						frameArray[testset] = testset;
						td.SetData(SimSt[testset], Code[testset]);
					}
				break;

				case 3:
					error = "";
					errorLabel.setText(error);
					Frame displayCode3 = new Frame();
					codeData.setEnabled(true);
					codeFrame = new CodeFrame(displayCode3, AllFinals.CODE_NUM_INPUT_FRAME_HEADER, true, Code, loopCounter,codeString);
					codeFrame.setEnabled(false);
					if(codeFrame.codeNumber == -1){
						error = AllFinals.ERROR_CODE_NOT_FOUND;
						errorLabel.setText(error);
						HistP = codeFrame.codeNumber;
					}else{
						testset = codeFrame.codeNumber;
						HistP = codeFrame.codeNumber;
						ansx = amide[testset];
						ansy = mw[testset];
						choicePoint = testset;
						historyPoint = testset;
						frameArray[testset] = testset;
						td.SetData(SimSt[testset], Code[testset]);
					}
				break;

				default:

			}
		 codeString  = codeFrame.textString;
		 repaint();
		}
		*/
		if(actionevent.getSource() == SearchButton){
			mySearch.setVisible(true);
		}
		
		//ZOOOOOM ++++++++++++++++++++++++++++++++
		if((actionevent.getSource() == zoomIn || actionevent.getSource() == mn1)){
			inCounter++;
			error = "";
			errorLabel.setText(error);
			if(inCounter <= END_ZOOM){
				switch(graphSwitch){
					case 0:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1;
						}*/
						ZOOM = ZOOM*ZX;
						ZOOM2 = ZOOM2*ZX;
						XX1=byXX1-ZOOM;
						YY1=byYY1-ZOOM2;
						XX2=byXX1+ZOOM;
						YY2=byYY1+ZOOM2;
						repaint();
					break;

					case 2:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1m;
						}*/
						ZOOM = ZOOM*ZX;
						ZOOM3 = ZOOM3*ZX;
					    XX1=byXX1-ZOOM;
					    YY1=byYY1m-ZOOM3;
					    XX2=byXX1+ZOOM;
					    YY2=byYY1m+ZOOM3;
						repaint();
					break;

					case 3:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1m;
						}*/
						ZOOM2 = ZOOM2*ZX;
						ZOOM3 = ZOOM3*ZX;
						XX1=byXX1-ZOOM2;
						YY1=byYY1m-ZOOM3;
						XX2=byXX1+ZOOM2;
						YY2=byYY1m+ZOOM3;
						repaint();
					break;

					default:
						errorCounter++;
						repaint();
				}
			}else{
				repaint();
			}
		}

		//ZOOOM ---------------------------
		if(actionevent.getSource() == zoomOut || actionevent.getSource() == mn2){
			error = "";
			errorLabel.setText(error);
			if(inCounter >= END_ZOOM){
				inCounter = END_ZOOM;
			}
			if(inCounter <= 0){
				setItem = "changed";
				//itemStateChanged(ie);
				repaint();
			}else{
				switch(graphSwitch){
					case 0:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1;
						}*/
						inCounter--;
						ZOOM = ZOOM/ZX;
						ZOOM2 = ZOOM2/ZX;
						XX1=byXX1-ZOOM;
						YY1=byYY1-ZOOM2;
						XX2=byXX1+ZOOM;
						YY2=byYY1+ZOOM2;
						repaint();
					break;

					case 2:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1m;
						}*/
						inCounter--;
						ZOOM = ZOOM/ZX;
						ZOOM3 = ZOOM3/ZX;
				    	XX1=byXX1-ZOOM;
				    	YY1=byYY1m-ZOOM3;
				    	XX2=byXX1+ZOOM;
				    	YY2=byYY1m+ZOOM3;
						repaint();
					break;
					case 3:
/*						if(ansx == 0 && ansy == 0){
							ansx = byXX1;
							ansy = byYY1m;
						}*/
						inCounter--;
						ZOOM2 = ZOOM2/ZX;
						ZOOM3 = ZOOM3/ZX;
						XX1=byXX1-ZOOM2;
						YY1=byYY1m-ZOOM3;
						XX2=byXX1+ZOOM2;
						YY2=byYY1m+ZOOM3;
						repaint();
					break;

					default:
						errorCounter++;
						repaint();
				}
			}
		}

		// ARROW DRAW CODE ACCORDING TO ARROW BUTTON
		if(actionevent.getSource() == buttonArrow){
			error = "";
			errorLabel.setText(error);
			loopCounter = DATAREAD;
			//enzimeCounter++;
			Frame f = new Frame();
			michiCounter = 0;
			zenCounter = 0;
			arrowx = 0;
			arrowy = 0;
			arrowx = ansx;
			arrowy = ansy;
			allMichiCounter = 0;
			michiTest = 0;
			//ALL ARROW INITIALIZES
			for(int multi = 0; multi < 7; multi++){
				arrowXX[multi] = -1;
				arrowYY[multi] = -1;
			}

			//michi arrow count holder array initialised
			for(int clr = 0; clr < 7; clr++){
				michiDataNumber[clr] = -1;
			}

			enzimeCounter = 0;
			if(group.getSelectedCheckbox() == upperArrow){
				switch(graphSwitch){
					case 0:
						if(test.enzimeSwitch == 6){
							enzimeCounter++;
							for(int multi = 0; multi < 7; multi ++){
								if(enzimeData[multi][choicePoint] >= 0){
									michiDataNumber[multi] = enzimeData[multi][choicePoint];
									if(michiDataNumber[multi] > DATAREAD){
										if(allMichiCounter <= 0){
											buttonArrow.setEnabled(false);
											VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
											buttonArrow.setEnabled(true);
											allMichiCounter++;
											if(virtual.drawArrowCounter > 0){
												michiTest++;
												loopCounter = ARRAY_LENGTH;
											}
										}
									}
									arrowXX[multi] = ods[enzimeData[multi][choicePoint]];
									arrowYY[multi] = amide[enzimeData[multi][choicePoint]];
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									xx1a[multi] = t.graphX2(arrowXX[multi]);
									yy1a[multi] = t.graphY2(arrowYY[multi]);
									arrow.set(x, y, xx1a[multi], yy1a[multi]);
									arrowXX[multi] = ods[enzimeData[multi][choicePoint]];
									arrowYY[multi] = amide[enzimeData[multi][choicePoint]];
									xx2a[multi] = t.graphX((int)(xx1a[multi] + arrow.x1));
									xx3a[multi] = t.graphX((int)(xx1a[multi] + arrow.x2));
									yy2a[multi] = t.graphY((int)(yy1a[multi] + arrow.y1));
									yy3a[multi] = t.graphY((int)(yy1a[multi] + arrow.y2));
								}else{
									arrowXX[multi] = -1;
									arrowYY[multi] = -1;
								}
							}
						//repaint();
						}else if(test.enzimeSwitch != 6){
							if(enzimeData[test.enzimeSwitch][choicePoint] == -1){
								enzimeCounter = 0;
								errorCounter = 5;
								error = AllFinals.ERROR_NO_PRODUCT + enzime.getSelectedItem();
								errorLabel.setText(error);
							}
/*
							if(enzimeData[test.enzimeSwitch][choicePoint] == -2){
								error = "No prediction is possible from Unknown data to unknown data";
								errorLabel.setText(error);
								error = "";
							}*/
							if(enzimeData[test.enzimeSwitch][choicePoint] > DATAREAD){
								error = "";
								errorLabel.setText(error);
								buttonArrow.setEnabled(false);
								VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
								buttonArrow.setEnabled(true);
								if(virtual.drawArrowCounter > 0){
									errorCounter = 0;
									michiCounter ++;
									loopCounter = ARRAY_LENGTH;
									enzimeCounter++;
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = amide[enzimeData[test.enzimeSwitch][choicePoint]];
									xx1 = t.graphX2(arrowX);
									yy1 = t.graphY2(arrowY);
									arrow.set(x, y, xx1, yy1);
									arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = amide[enzimeData[test.enzimeSwitch][choicePoint]];
									xx2 = t.graphX((int)(xx1 + arrow.x1));
									xx3 = t.graphX((int)(xx1 + arrow.x2));
									yy2 = t.graphY((int)(yy1 + arrow.y1));
									yy3 = t.graphY((int)(yy1 + arrow.y2));
									errorLabel.setText(AllFinals.PREDICTION_INFO);
								}else{
									errorLabel.setText(AllFinals.PREDICTION_CANCELLED);
									michiCounter = 0;
									enzimeCounter = 0;
									loopCounter = DATAREAD;
								}
							}
							if(enzimeData[test.enzimeSwitch][choicePoint] >= 0 && enzimeData[test.enzimeSwitch][choicePoint] < DATAREAD){
								errorCounter = 0;
								enzimeCounter++;
								x = t.graphX2(ansx);
								y = t.graphY2(ansy);
								xx1 = t.graphX2(ods[enzimeData[test.enzimeSwitch][choicePoint]]);
								yy1 = t.graphY2(amide[enzimeData[test.enzimeSwitch][choicePoint]]);
								arrow.set(x, y, xx1, yy1);
								arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
								arrowY = amide[enzimeData[test.enzimeSwitch][choicePoint]];
								xx2 = t.graphX((int)(xx1 + arrow.x1));
								xx3 = t.graphX((int)(xx1 + arrow.x2));
								yy2 = t.graphY((int)(yy1 + arrow.y1));
								yy3 = t.graphY((int)(yy1 + arrow.y2));
								errorLabel.setText("");
							}
						}
						repaint();
					break;

					case 2:
						if(test.enzimeSwitch == 6){
							enzimeCounter++;
							for(int multi = 0; multi < 7; multi ++){
								if(enzimeData[multi][choicePoint] >= 0){
									michiDataNumber[multi] = enzimeData[multi][choicePoint];
									if(michiDataNumber[multi] > DATAREAD){
										if(allMichiCounter <= 0){
											buttonArrow.setEnabled(false);
											VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
											buttonArrow.setEnabled(true);
											allMichiCounter++;
											if(virtual.drawArrowCounter > 0){
												michiTest++;
												loopCounter = ARRAY_LENGTH;
											}
										}
									}
									arrowXX[multi] = ods[enzimeData[multi][choicePoint]];
									arrowYY[multi] = mw[enzimeData[multi][choicePoint]];
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									xx1a[multi] = t.graphX2(arrowXX[multi]);
									yy1a[multi] = t.graphY2(arrowYY[multi]);
									arrow.set(x, y, xx1a[multi], yy1a[multi]);
									arrowXX[multi] = ods[enzimeData[multi][choicePoint]];
									arrowYY[multi] = mw[enzimeData[multi][choicePoint]];
									xx2a[multi] = t.graphX((int)(xx1a[multi] + arrow.x1));
									xx3a[multi] = t.graphX((int)(xx1a[multi] + arrow.x2));
									yy2a[multi] = t.graphY((int)(yy1a[multi] + arrow.y1));
									yy3a[multi] = t.graphY((int)(yy1a[multi] + arrow.y2));
								}else{
									arrowXX[multi] = -1;
									arrowYY[multi] = -1;
								}
							}
							//repaint();
						}else if(test.enzimeSwitch != 6){
							if(enzimeData[test.enzimeSwitch][choicePoint] == -1){
								enzimeCounter = 0;
								errorCounter = 5;
								error = AllFinals.ERROR_NO_PRODUCT + enzime.getSelectedItem();
								errorLabel.setText(error);
							}
							if(enzimeData[test.enzimeSwitch][choicePoint] > DATAREAD){
								error = "";
								errorLabel.setText(error);
								buttonArrow.setEnabled(false);
								VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
								buttonArrow.setEnabled(true);
								if(virtual.drawArrowCounter > 0){
									errorCounter = 0;
									michiCounter ++;
									loopCounter = ARRAY_LENGTH;
									enzimeCounter++;
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
									xx1 = t.graphX2(arrowX);
									yy1 = t.graphY2(arrowY);
									arrow.set(x, y, xx1, yy1);
									arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
									xx2 = t.graphX((int)(xx1 + arrow.x1));
									xx3 = t.graphX((int)(xx1 + arrow.x2));
									yy2 = t.graphY((int)(yy1 + arrow.y1));
									yy3 = t.graphY((int)(yy1 + arrow.y2));
									errorLabel.setText(AllFinals.PREDICTION_INFO);
								}else{
									errorLabel.setText(AllFinals.PREDICTION_CANCELLED);
									michiCounter = 0;
									enzimeCounter = 0;
									loopCounter = DATAREAD;
								}
							}
							if(enzimeData[test.enzimeSwitch][choicePoint] >= 0 && enzimeData[test.enzimeSwitch][choicePoint] < DATAREAD){
								enzimeCounter++;
								x = t.graphX2(ansx);
								y = t.graphY2(ansy);
								xx1 = t.graphX2(ods[enzimeData[test.enzimeSwitch][choicePoint]]);
								yy1 = t.graphY2(mw[enzimeData[test.enzimeSwitch][choicePoint]]);
								arrow.set(x, y, xx1, yy1);
								arrowX = ods[enzimeData[test.enzimeSwitch][choicePoint]];
								arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
								xx2 = t.graphX((int)(xx1 + arrow.x1));
								xx3 = t.graphX((int)(xx1 + arrow.x2));
								yy2 = t.graphY((int)(yy1 + arrow.y1));
								yy3 = t.graphY((int)(yy1 + arrow.y2));
								errorLabel.setText("");
							}
						}
						repaint();
					break;

					case 3:
						if(test.enzimeSwitch == 6){
							enzimeCounter++;
							for(int multi = 0; multi < 7; multi ++){
								if(enzimeData[multi][choicePoint] >= 0){
									michiDataNumber[multi] = enzimeData[multi][choicePoint];
									if(michiDataNumber[multi] > DATAREAD){
										if(allMichiCounter <= 0){
											buttonArrow.setEnabled(false);
											VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
											buttonArrow.setEnabled(true);
											allMichiCounter++;
											if(virtual.drawArrowCounter > 0){
												michiTest++;
												loopCounter = ARRAY_LENGTH;
											}
										}
									}
									arrowXX[multi] = amide[enzimeData[multi][choicePoint]];
									arrowYY[multi] = mw[enzimeData[multi][choicePoint]];
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									xx1a[multi] = t.graphX2(arrowXX[multi]);
									yy1a[multi] = t.graphY2(arrowYY[multi]);
									arrow.set(x, y, xx1a[multi], yy1a[multi]);
									arrowXX[multi] = amide[enzimeData[multi][choicePoint]];
									arrowYY[multi] = mw[enzimeData[multi][choicePoint]];
									xx2a[multi] = t.graphX((int)(xx1a[multi] + arrow.x1));
									xx3a[multi] = t.graphX((int)(xx1a[multi] + arrow.x2));
									yy2a[multi] = t.graphY((int)(yy1a[multi] + arrow.y1));
									yy3a[multi] = t.graphY((int)(yy1a[multi] + arrow.y2));
								}else{
									arrowXX[multi] = -1;
									arrowYY[multi] = -1;
								}
							}
						}else if(test.enzimeSwitch != 6){
							if(enzimeData[test.enzimeSwitch][choicePoint] == -1){
								enzimeCounter = 0;
								errorCounter = 5;
								error = AllFinals.ERROR_NO_PRODUCT + enzime.getSelectedItem();
								errorLabel.setText(error);
							}
							if(enzimeData[test.enzimeSwitch][choicePoint] > DATAREAD){
								error = "";
								errorLabel.setText(error);
								buttonArrow.setEnabled(false);
								VirtualArrowDialog virtual = new VirtualArrowDialog(f, AllFinals.MICHI_FRAME_HEADER, true);
								buttonArrow.setEnabled(true);
								if(virtual.drawArrowCounter > 0){
									errorCounter = 0;
									michiCounter ++;
									loopCounter = ARRAY_LENGTH;
									enzimeCounter++;
									x = t.graphX2(ansx);
									y = t.graphY2(ansy);
									arrowX = amide[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
									xx1 = t.graphX2(arrowX);
									yy1 = t.graphY2(arrowY);
									arrow.set(x, y, xx1, yy1);
									arrowX = amide[enzimeData[test.enzimeSwitch][choicePoint]];
									arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
									xx2 = t.graphX((int)(xx1 + arrow.x1));
									xx3 = t.graphX((int)(xx1 + arrow.x2));
									yy2 = t.graphY((int)(yy1 + arrow.y1));
									yy3 = t.graphY((int)(yy1 + arrow.y2));
									errorLabel.setText(AllFinals.PREDICTION_INFO);
								}else{
									errorLabel.setText(AllFinals.PREDICTION_CANCELLED);
									michiCounter = 0;
									enzimeCounter = 0;
									loopCounter = DATAREAD;
								}
							}
							if(enzimeData[test.enzimeSwitch][choicePoint] >= 0 && enzimeData[test.enzimeSwitch][choicePoint] < DATAREAD){
								enzimeCounter++;
								x = t.graphX2(ansx);
								y = t.graphY2(ansy);
								xx1 = t.graphX2(amide[enzimeData[test.enzimeSwitch][choicePoint]]);
								yy1 = t.graphY2(mw[enzimeData[test.enzimeSwitch][choicePoint]]);
								arrow.set(x, y, xx1, yy1);
								arrowX = amide[enzimeData[test.enzimeSwitch][choicePoint]];
								arrowY = mw[enzimeData[test.enzimeSwitch][choicePoint]];
								xx2 = t.graphX((int)(xx1 + arrow.x1));
								xx3 = t.graphX((int)(xx1 + arrow.x2));
								yy2 = t.graphY((int)(yy1 + arrow.y1));
								yy3 = t.graphY((int)(yy1 + arrow.y2));
								errorLabel.setText("");
							}
						}
						repaint();
					break;
					default:
						errorCounter++;
				}
			}

			if(group.getSelectedCheckbox() == lowerArrow){
				error = "";
				errorLabel.setText(error);
				switch(graphSwitch){
					case 0:
						for(set = 0; set < DATAREAD; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >=ansx)
							if((amide[set]-ODS_AMIDE_CONST) <= ansy && (amide[set] + ODS_AMIDE_CONST) >=ansy){
							//	if(mouseCounter != 0){
									r.ruleback(SimSt[choicePoint], ods[choicePoint], amide[choicePoint], mw[choicePoint], 0, 0, test.enzimeSwitch);
									System.out.println("EnzimeSwitch     " + test.enzimeSwitch);
									zenCounter++;
									enzimeCounter++;
									repaint();
							//	}else{
							//		enzimeCounter = 0;
							//	}
							}
						}
					break;

					case 2:
						for(set = 0; set < DATAREAD; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >= ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >= ansy){
								//if(mouseCounter != 0){
									r.ruleback(SimSt[choicePoint], ods[choicePoint], amide[choicePoint], mw[choicePoint], 0, 0, test.enzimeSwitch);
									enzimeCounter++;
									zenCounter++;
									repaint();
								//}else{
								//	enzimeCounter = 0;
								//}
							}
						}
					break;

					case 3:
						for(set = 0; set < DATAREAD; set++){
							if((amide[set] - ODS_AMIDE_CONST) <= ansx && (amide[set] + ODS_AMIDE_CONST) >= ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >= ansy){
								//if(mouseCounter != 0){
									r.ruleback(SimSt[choicePoint], ods[choicePoint], amide[choicePoint], mw[choicePoint], 0, 0, test.enzimeSwitch);
									enzimeCounter++;
									zenCounter++;
									repaint();
								//}else{
								//	enzimeCounter = 0;
								//}
							}
						}

					break;

					default:
				}
			}
		}

		//TEXT FIELD PROCESS ACCORDING TO BUTTON
		if(actionevent.getSource() == buttonExp){
			error = "";
			errorLabel.setText(error);
			expx = 0;
			expy = 0;
			errorx = 0;
			errory = 0;
			setOds = 0;
			setAmide = 0;
			setMw = 0;
			setErOds = 0;
			setErAmide = 0;
			setErMw = 0;
			sOds = "";
			sAmide = "";
			sMw = "";
			serOds = "";
			serAmide = "";
			serMw = "";

			sOds = fieldOds.getText();
			sAmide = fieldAmide.getText();
			sMw = fieldMw.getText();
			serOds = erOds.getText();
			serAmide = erAmide.getText();
			serMw = erMw.getText();
			buttonCounter--;
			doubleClickCounter = 0;
			for(int clr = 0; clr < DATAREAD; clr++){
				frameArray[clr] = -1;
			}
			f = new Frame();
			switch(graphSwitch){
				case 0:
					if(sOds.equals("")){
						sOds = "0.0";
						setOds = Double.valueOf(sOds).doubleValue();
					}else{
						setOds = Double.valueOf(sOds).doubleValue();
					}
					if(sAmide.equals("")){
						sAmide = "0.0";
						setAmide = Double.valueOf(sAmide).doubleValue();
					}else{
						setAmide = Double.valueOf(sAmide).doubleValue();
					}

					//error field values are read
					if(serOds.equals("")){
						serOds = "0.0";
						setErOds = Double.valueOf(serOds).doubleValue();
					}else{
						setErOds = Double.valueOf(serOds).doubleValue();
					}

					if(serAmide.equals("")){
						serAmide = "0.0";
						setErAmide = Double.valueOf(serAmide).doubleValue();
					}else{
						setErAmide = Double.valueOf(serAmide).doubleValue();
					}
					if(setErOds == 0 && setErAmide == 0){
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= setOds && (ods[set] + ODS_AMIDE_CONST) >= setOds)
							if((amide[set] - ODS_AMIDE_CONST) <= setAmide && (amide[set] + ODS_AMIDE_CONST) >= setAmide){
								ansx = setOds;
								ansy = setAmide;
								testset = set;
								//historyPoint = testset;
								choicePoint = testset;
							}
						}
					}
					if(setErOds == 0 && setErAmide == 0 && setOds != 0 && setAmide != 0){
						for(set = 0; set < loopCounter; set++){
							if(ods[set] - ODS_AMIDE_CONST <= ansx && ods[set] + ODS_AMIDE_CONST >= ansx)
							if(amide[set] - ODS_AMIDE_CONST <= ansy && amide[set] + ODS_AMIDE_CONST >= ansy){
								testset = set;
								choicePoint = testset;
								frameArray[set] = set;
								for(common = 0;common<testset;common++){
									if(ods[common] - ODS_AMIDE_CONST <= setOds && ods[common] + ODS_AMIDE_CONST >= setOds)
									if(amide[common] - ODS_AMIDE_CONST <= setAmide && amide[common] + ODS_AMIDE_CONST >= setAmide){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset+1; common<loopCounter; common++){
									if(ods[common] - ODS_AMIDE_CONST <= setOds && ods[common] + ODS_AMIDE_CONST >= setOds)
									if(amide[common] - ODS_AMIDE_CONST <= setAmide && amide[common] + ODS_AMIDE_CONST >= setAmide){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						if(dialogCounter > 1){
							buttonExp.setEnabled(false);
							this.removeMouseListener(this);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(f, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code, mouseMem, this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = ods[historyPoint];
									ansy = amide[historyPoint];
								}
								HistP = -1;
							}
							buttonExp.setEnabled(true);
							this.addMouseListener(this);
							choicePoint = testset;
							if(delArrow == testset){
								delArrow = delArrow;
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}
						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = -1;
						}else{
							td.SetData("","");
							HistP = -1;
							System.out.println("IN ELSE ERRRROOOOOOEEEEE");
						}
					}
					repaint();
				break;

				case 2:
					if(sOds.equals("")){
						sOds = "0.0";
						setOds = Double.valueOf(sOds).doubleValue();
					}else{
						setOds = Double.valueOf(sOds).doubleValue();
					}
					if(sMw.equals("")){
						sMw = "0.0";
						setMw = Double.valueOf(sMw).doubleValue();
					}else{
						setMw = Double.valueOf(sMw).doubleValue();
					}
					if(serOds.equals("")){
						serOds = "0.0";
					}else{
						setErOds = Double.valueOf(serOds).doubleValue();
					}
					if(serMw.equals("")){
						serMw = "0.0";
					}else{
						setErMw = Double.valueOf(serMw).doubleValue();
					}
					if(setErOds == 0 && setErMw == 0){
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= setOds && (ods[set] + ODS_AMIDE_CONST) >= setOds)
							if((mw[set] - MW_CONSTANT) <= setMw && (mw[set] + MW_CONSTANT) >= setMw){
								ansx = setOds;
								ansy = setMw;
								testset = set;
								choicePoint = testset;
							}
						}
					}
					//error field values are read
					if(setErOds == 0 && setErMw == 0 && setOds != 0 && setMw != 0){
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >=ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >=ansy && ansx != 0 && ansy != 0){
								testset = set;
								choicePoint = testset;
								frameArray[set] = set;
								for(common = 0;common<testset;common++){
									if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >= ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset + 1;common<loopCounter;common++){
									if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						if(dialogCounter > 1){
							buttonExp.setEnabled(false);
							this.removeMouseListener(this);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(f, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code,mouseMem, this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = ods[historyPoint];
									ansy = mw[historyPoint];
								}
								HistP = -1;
							}
							buttonExp.setEnabled(true);
							this.addMouseListener(this);
							choicePoint = testset;
							if(delArrow == testset){
								delArrow = delArrow;
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}
						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = testset;
						}else{
							td.SetData("","");
							HistP = -1;
						}
					}
					repaint();
				break;

				case 3:
					if(sAmide.equals("")){
						sAmide = "0.0";
						setAmide = Double.valueOf(sAmide).doubleValue();
					}else{
						setAmide = Double.valueOf(sAmide).doubleValue();
					}
					if(sMw.equals("")){
						sMw = "0.0";
						setMw = Double.valueOf(sMw).doubleValue();
					}else{
						setMw = Double.valueOf(sMw).doubleValue();
					}
					if(serAmide.equals("")){
						serAmide = "0.0";
					}else{
						setErAmide = Double.valueOf(serAmide).doubleValue();
					}
					if(serMw.equals("")){
						serMw = "0.0";
					}else{
						setErMw = Double.valueOf(serMw).doubleValue();
					}
					if(setErAmide == 0 && setErMw == 0){
						for(set = 0; set < loopCounter; set++){
							if((amide[set] - ODS_AMIDE_CONST) <= setAmide && (amide[set] + ODS_AMIDE_CONST) >= setAmide)
							if((mw[set] - MW_CONSTANT) <= setMw && (mw[set] + MW_CONSTANT) >= setMw){
								ansx = setAmide;
								ansy = setMw;
								testset = set;
								choicePoint = testset;
							}
						}
					}
					//error values are read
					if(setErAmide == 0 && setErMw == 0 && setAmide != 0 && setMw != 0){
						for(set = 0; set < loopCounter; set++){
							if((amide[set] - ODS_AMIDE_CONST) <= ansx && (amide[set] + ODS_AMIDE_CONST) >=ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >=ansy && ansx != 0 && ansy != 0){
								testset = set;
								choicePoint = testset;
								frameArray[set] = set;
								for(common = 0;common<=testset-1;common++){
									if(((amide[common] -ODS_AMIDE_CONST) <= ansx && (amide[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset + 1;common<loopCounter;common++){
									if(((amide[common] - ODS_AMIDE_CONST) <= ansx && (amide[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						if(dialogCounter > 1){
							buttonExp.setEnabled(false);
							this.removeMouseListener(this);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(f, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code,mouseMem, this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = amide[historyPoint];
									ansy = mw[historyPoint];
								}
							}
							buttonExp.setEnabled(true);
							this.addMouseListener(this);
							choicePoint = testset;
							if(delArrow == testset){
								delArrow = delArrow;
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}
						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = -1;
						}else{
							td.SetData("","");
							HistP = -1;
						}
					}
					repaint();
				break;

					default:
			}
		}

		if(actionevent.getSource() == arrowUp){
			error = "";
			errorLabel.setText(error);
			switch(graphSwitch){
				case 0:
					if(YY2 > 30) {

					}else{
						YY2 = YY2 + (YY2-YY1)/100*10;
						YY1 = YY1 + (YY2-YY1)/100*10;
						repaint();
					}
				break;

				case 2:
					if(YY2 > 6000) {

					}else{
						YY2 = YY2 + (YY2-YY1)/100*10;
						YY1 = YY1 + (YY2-YY1)/100*10;
						repaint();
					}
				break;

				case 3:
					if(YY2 > 6000) {

					}else{
						YY2 = YY2 + (YY2-YY1)/100*10;
						YY1 = YY1 + (YY2-YY1)/100*10;
						repaint();
					}
				break;

				default:

			}
		}
		if(actionevent.getSource() == arrowDown){
			error = "";
			errorLabel.setText(error);
			switch(graphSwitch){
				case 0:
					if(YY1 < -10){

					}else{
						YY2 = YY2 - (YY2-YY1)/100*10;
						YY1 = YY1 - (YY2-YY1)/100*10;
						repaint();
					}
				break;

				case 2:
					if(YY1 < -2000){

					}else{
						YY2 = YY2 - (YY2-YY1)/100*10;
						YY1 = YY1 - (YY2-YY1)/100*10;
						repaint();
					}
				break;

				case 3:
					if(YY1 < -2000){

					}else{
						YY2 = YY2 - (YY2-YY1)/100*10;
						YY1 = YY1 - (YY2-YY1)/100*10;
						repaint();
					}
				break;

				default:

			}
		}
		if(actionevent.getSource() == arrowRight){
			error = "";
			errorLabel.setText(error);
			switch(graphSwitch){
				case 0:
					if(XX2 > 42){

					}else{
						XX2 = XX2 + (XX2-XX1)/100*10;
						XX1 = XX1 + (XX2-XX1)/100*10;
						repaint();
					}
				break;

				case 2:
					if(XX2 > 42){

					}else{
						XX2 = XX2 + (XX2-XX1)/100*10;
						XX1 = XX1 + (XX2-XX1)/100*10;
						repaint();
					}
				break;

				case 3:
					if(XX2 > 30){

					}else{
						XX2 = XX2 + (XX2-XX1)/100*10;
						XX1 = XX1 + (XX2-XX1)/100*10;
						repaint();
					}
				break;

				default:

			}

		}
		if(actionevent.getSource() == arrowLeft){
			error = "";
			errorLabel.setText(error);
			switch(graphSwitch){
				case 0:
					if(XX1 > -14){
						XX2 = XX2 - (XX2-XX1)/100*10;
						XX1 = XX1 - (XX2-XX1)/100*10;
						repaint();
					}
				break;

				case 2:
					if(XX1 > -14){
						XX2 = XX2 - (XX2-XX1)/100*10;
						XX1 = XX1 - (XX2-XX1)/100*10;
						repaint();
					}
				break;

				case 3:
					if(XX1 > -10){
						XX2 = XX2 - (XX2-XX1)/100*10;
						XX1 = XX1 - (XX2-XX1)/100*10;
						repaint();
					}
				break;

				default:
			}
		}

		if(actionevent.getSource() == buttonCenter){
			error = "";
			errorLabel.setText(error);
			switch(graphSwitch){

					case 0:
					XX1 = ansx - ZOOM;
					XX2 = ansx + ZOOM;
					YY1 = ansy - ZOOM2;
					YY2 = ansy + ZOOM2;
					break;
					case 2:
					XX1 = ansx - ZOOM;
					XX2 = ansx + ZOOM;
					YY1 = ansy - ZOOM3;
					YY2 = ansy + ZOOM3;
					break;
					case 3:
					XX1 = ansx - ZOOM2;
					XX2 = ansx + ZOOM2;
					YY1 = ansy - ZOOM3;
					YY2 = ansy + ZOOM3;
					break;
					default:
			}
					repaint();
		}

		if(actionevent.getSource() == mn3){
			try{
				URL link;
				for(set = 0; set < loopCounter; set++){
					frameArray[set] = -1;
				}
				switch(graphSwitch){
					case 0:
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >=ansx)
							if((amide[set]-ODS_AMIDE_CONST) <= ansy && (amide[set] + ODS_AMIDE_CONST) >=ansy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common].replace('*', '_') + ".html";
								URL url = new URL(getDocumentBase(), URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = 0;
							}
						}
					break;

					case 2:
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >= ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >= ansy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common].replace('*', '_') + ".html";
								URL url = new URL(getDocumentBase(), URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = 0;
							}
						}
					break;

					case 3:
						for(set = 0; set < loopCounter; set++){
							if((amide[set] - ODS_AMIDE_CONST) <= ansx && (amide[set] + ODS_AMIDE_CONST) >= ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >= ansy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common].replace('*', '_') + ".html";
								URL url = new URL(getDocumentBase(), URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = 0;
							}
						}
					break;

					default:
						errorCounter--;
				}
			}catch(MalformedURLException mue){
				System.out.println("FAILED" + mue);
			}
		}
		
		if(actionevent.getSource() == mn4){
			String KEGG_BASE = "http://www.genome.jp/ligand/kcam/";
			try{
				URL url = new URL(getDocumentBase(), KEGG_BASE);
				getAppletContext().showDocument(url, "KEGG");
			}catch(MalformedURLException mue){
				System.out.println("FAILED" + mue);
			}
		}

		if(actionevent.getSource() == resetButton){
			mono.removeAll();
			mono.addItem("ALL");
			mono.addItem("0");
			mono.addItem("1");
			mono.addItem("2");
			mono.addItem("3");
			mono.addItem("4");
			monoSwitchSet.monoSwitch = 0;

			selectGraph.removeAll();
			selectGraph.addItem(AllFinals.OA);
			selectGraph.addItem(AllFinals.OM);
			selectGraph.addItem(AllFinals.AM);
			graphSwitch = 0;

			setTextEditable();
			mouseCounter = 0;
			buttonCounter = 0;
			arrowCounter = 0;
			inCounter = 0;
			enzimeCounter = 0;
			zenCounter = 0;
			ansx = 0;
			ansy = 0;
			setAmide = 0;
			setOds = 0;
			mouseMem = -1;
			historyPoint = -1;
			HistP = -1;
			setMw = 0;
			buttonCenter.setEnabled(false);
			erMw.setText("");
			erOds.setText("");
			erAmide.setText("");
			fieldOds.setText("");
			fieldAmide.setText("");
			fieldMw.setText("");
			buttonArrow.setEnabled(true);
			td.SetData("","");
			loopCounter = DATAREAD;
			XX1 = 0;
			YY1 = 0;
			XX2 = 28;
			YY2 = 20;
			ZOOM = 14;
			ZOOM2 = 10;
			ZOOM3 = 2000;
			repaint();
		}
		//enable center button
		if(ansx != 0 && ansy != 0){
			if(!buttonCenter.isEnabled()){
				buttonCenter.setEnabled(true);
			}
		}
	}//end of method actionPerformed(ActionEvent actionevent)

	public void itemStateChanged(ItemEvent itemevent){
		ie = itemevent;
		graphType = selectGraph.getSelectedItem();
		XX1 = 0;
		YY1 = 0;
		XX2 = 28;
		YY2 = 20;
		ZOOM = 14;
		ZOOM2 = 10;
		ZOOM3 = 2000;
		if(graphType.equals(AllFinals.OA)){
			graphSwitch = 0;
			setTextEditable();
			mouseCounter = 0;
			buttonCounter = 0;
			arrowCounter = 0;
			inCounter = 0;
			enzimeCounter = 0;
			zenCounter = 0;
			if(HistP >= 0){
				ansx = ods[HistP];
				ansy = amide[HistP];
			}else{
				ansx = 0;
				ansy = 0;
			}
			//historyPoint = -1;
			setAmide = 0;
			setOds = 0;
			setMw = 0;
			loopCounter = DATAREAD;
			buttonCenter.setEnabled(false);
			repaint();
		}else if(graphType.equals(AllFinals.OM)){
			graphSwitch = 2;
			setTextEditable();
			mouseCounter = 0;
			buttonCounter = 0;
			arrowCounter = 0;
			inCounter = 0;
			enzimeCounter = 0;
			zenCounter = 0;
			if(HistP >= 0){
				ansx = ods[HistP];
				ansy = mw[HistP];
			}else{
				ansx = 0;
				ansy = 0;
			}
			//historyPoint = -1;
			setAmide = 0;
			setOds = 0;
			setMw = 0;
			loopCounter = DATAREAD;
			buttonCenter.setEnabled(false);
			repaint();
		}else if(graphType.equals(AllFinals.AM)){
			graphSwitch = 3;
			setTextEditable();
			mouseCounter = 0;
			buttonCounter = 0;
			arrowCounter = 0;
			inCounter = 0;
			enzimeCounter = 0;
			zenCounter = 0;
			if(HistP >= 0){
				ansx = amide[HistP];
				ansy = mw[HistP];
			}else{
				ansx = 0;
				ansy = 0;
			}
			mouseMem = -1;
			//historyPoint = -1;
			setAmide = 0;
			setOds = 0;
			setMw = 0;
			loopCounter = DATAREAD;
			buttonCenter.setEnabled(false);
			repaint();
		}
		setItem = graphType;
	}

	//PAINTTTTTTT
	public void paint(Graphics g){
		if(monoSwitchSet.monoSwitch != set1 && historyPoint != 0){
			System.out.println("choicePointSASA : " + choicePoint);
			sialicflag = 1;
			set1 = monoSwitchSet.monoSwitch;
		}else{
			set1 = monoSwitchSet.monoSwitch;
		}
		gg = g;
		g.setColor(Color.black);
		g.drawLine(70,100,70,500);
		g.drawLine(70,500,470,500);
		if(buttonCounter == 0){
			XX1 = 0; YY1 = 0;
			switch(graphSwitch){
				case 0:
					XX2 = 28;
					YY2 = 20;
				break;

				case 2:
					XX2 = 28;
					YY2 = 4000;
				break;

				case 3:
					XX2 = 20;
					YY2 = 4000;
				break;

				default :
			}
		}
		//decide graph values
		switch(graphSwitch){
			case 0:
				y2 = Math.round(YY2*10.0)/10.0;
				y1 = Math.round(YY1*10.0)/10.0;
	    		x2 = Math.round(XX2*10.0)/10.0;
				x1 = Math.round(XX1*10.0)/10.0;
				byYY1 = Math.round(((YY2-YY1)/2+YY1)*10.0)/10.0;
				g.drawString("" +y2,40,105);
				g.drawString("" +byYY1 ,40,305);
				g.drawString("" +y1,40,505);
			break;

			case 2:
				y2m = (int)(Math.round(YY2*10.0)/10.0);
				y1m = (int)(Math.round(YY1*10.0)/10.0);
	    		x2 = Math.round(XX2*10.0)/10.0;
				x1 = Math.round(XX1*10.0)/10.0;
				byYY1m = (int)(Math.round(((YY2-YY1)/2+YY1)*10.0)/10.0);
				//show graph values
				g.drawString("" +y2m,35,105);
				g.drawString("" +byYY1m ,35,305);
				g.drawString("" +y1m,35,505);
			break;

			case 3:
				y2m = (int)Math.round((YY2*10.0)/10.0);
				y1m = (int)Math.round((YY1*10.0)/10.0);
	    		x2 = Math.round((XX2*10.0)/10.0);
				x1 = Math.round((XX1*10.0)/10.0);
				byYY1m = (int)(Math.round(((YY2-YY1)/2+YY1)*10.0)/10.0);
				g.drawString("" +y2m,35,105);
				g.drawString("" +byYY1m ,35,305);
				g.drawString("" +y1m,35,505);
			break;

			default:

		}

		byXX1 = Math.round(((XX2-XX1)/2+XX1)*10.0)/10.0;
		//show graph values
		g.drawString("" +x1,65,520);
		g.drawString("" +byXX1, 260, 520);
		g.drawString("" +x2,460,520);

		//graph divider
		g.drawLine(65,100,70,100);
		g.drawLine(65,500,70,500);
		g.drawLine(65,300,70,300);
		g.drawLine(70,500,70,505);
		g.drawLine(270, 500, 270, 505);
		g.drawLine(470, 500, 470, 505);

		switch(graphSwitch){
			case 0:
				g.drawString("Amide", 15, 290); /////tsuikaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
				g.drawString("ODS", 270, 535); /////tsuikaaaaaaaaaaa
			break;

			case 2:
				g.drawString("MW", 10, 290); /////tsuikaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
				g.drawString("ODS", 280, 535); /////tsuikaaaaaaaaaaa
			break;

			case 3:
				g.drawString("MW", 10, 290); /////tsuikaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
				g.drawString("Amide", 280, 535); /////tsuikaaaaaaaaaaa
			break;

			default:
		}

		t = new GraphicMaker(g);
 		//ポイントサイズ決定
		t.view(70,100,470,500);

		if(buttonCounter == 0 ){
			t.window(XX1,YY1,XX2,YY2);
			t.setsize(POINT_SIZE);
			switch(graphSwitch){
				case 0:
					//Experiment Data display
					drawError(g, setOds, setAmide, setErOds, setErAmide);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							g.setColor(Color.gray);
							drawGraph(ods, amide);
						break;

						case 1:
							g.setColor(Color.gray);
							drawGraph(array0ods, array0amide);
						break;

						case 2:
							g.setColor(Color.gray);
							drawGraph(array1ods, array1amide);
						break;

						case 3:
							g.setColor(Color.gray);
							drawGraph(array2ods, array2amide);
						break;

						case 4:
							g.setColor(Color.gray);
							drawGraph(array3ods, array3amide);
						break;

						case 5:
							g.setColor(Color.gray);
							drawGraph(array4ods, array4amide);
						break;
						default:
							errorCounter++;
					}
				break;

				case 2:
					drawError(g, setOds, setMw, setErOds, setErMw);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							g.setColor(Color.gray);
							drawGraph(ods, mw);
						break;

						case 1:
							g.setColor(Color.gray);
							drawGraph(array0ods, array0mw);
						break;

						case 2:
							g.setColor(Color.gray);
							drawGraph(array1ods, array1mw);
						break;

						case 3:
							g.setColor(Color.gray);
							drawGraph(array2ods, array2mw);
						break;

						case 4:
							g.setColor(Color.gray);
							drawGraph(array3ods, array3mw);
						break;

						case 5:
							g.setColor(Color.gray);
							drawGraph(array4ods, array4mw);
						break;

						default:
							errorCounter++;
					}
			break;

				case 3:
					drawError(g, setAmide, setMw, setErAmide, setErMw);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							g.setColor(Color.gray);
							drawGraph(amide, mw);
						break;

						case 1:
							g.setColor(Color.gray);
							drawGraph(array0amide, array0mw);
						break;

						case 2:
							g.setColor(Color.gray);
							drawGraph(array1amide, array1mw);
						break;

						case 3:
							g.setColor(Color.gray);
							drawGraph(array2amide, array2mw);
						break;

						case 4:
							g.setColor(Color.gray);
							drawGraph(array3amide, array3mw);
						break;

						case 5:
							g.setColor(Color.gray);
							drawGraph(array4amide, array4mw);
						break;

						default:
					}
			break;

				default:
			}
		}

		//ZZZZZOOOOMMMMM++++++++++++++++++
		if(inCounter >= 0) {
			t.window(XX1,YY1,XX2,YY2);
			t.setsize(POINT_SIZE);
			//ZOOM ABOVE THIS IS DISABLED MESSAGE DISPLAY
			if(inCounter > 3){
				g.setColor(Color.red);
				g.drawString("Maximum Zoom" , 100, 110);
			}
			switch(graphSwitch){
				case 0:
					drawError(g, setOds, setAmide, setErOds, setErAmide);
					if(inCounter == 1){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 2", 100, 110);
					}else if(inCounter == 2){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 4", 100, 110);
					}else if(inCounter == 3){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 8", 100, 110);
					}
					g.setColor(Color.blue);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawGraph(ods,amide);
						break;

						case 1:
							drawGraph(array0ods, array0amide);
						break;

						case 2:
							drawGraph(array1ods, array1amide);
						break;

						case 3:
							drawGraph(array2ods, array2amide);
						break;

						case 4:
							drawGraph(array3ods, array3amide);
						break;

						case 5:
							drawGraph(array4ods, array4amide);
						break;

						default:
					}
				break;

				case 2:
					drawError(g, setOds, setMw, setErOds, setErMw);
					if(inCounter == 1){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 2", 100, 110);
					}else if(inCounter == 2){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 4", 100, 110);
					}else if(inCounter == 3){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 8", 100, 110);
					}
					g.setColor(Color.blue);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawGraph(ods, mw);
						break;

						case 1:
							drawGraph(array0ods, array0mw);
						break;

						case 2:
							drawGraph(array1ods, array1mw);
						break;

						case 3:
							drawGraph(array2ods, array2mw);
						break;

						case 4:
							drawGraph(array3ods, array3mw);
						break;

						case 5:
							drawGraph(array4ods, array4mw);
						break;

						default:
					}
				break;

				case 3:
					drawError(g, setAmide, setMw, setErAmide, setErMw);
					if(inCounter == 1){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 2", 100, 110);
					}else if(inCounter == 2){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 4", 100, 110);
					}else if(inCounter == 3){
						g.setColor(Color.red);
						g.drawString("ZOOM : X 8", 100, 110);
					}
					g.setColor(Color.blue);
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawGraph(amide, mw);
						break;

						case 1:
							drawGraph(array0amide, array0mw);
						break;

						case 2:
							drawGraph(array1amide, array1mw);
						break;

						case 3:
							drawGraph(array2amide, array2mw);
						break;

						case 4:
							drawGraph(array3amide, array3mw);
						break;

						case 5:
							drawGraph(array4amide, array4mw);
						break;

						default:
							g.drawString("Reselect the Sialic value" ,100, 100);
					}
				break;

				default:
			}
		}

		//DISPLAYING AN ARROW
		System.out.println("CHOICE POINT   :" + choicePoint);
		if(enzimeCounter > 0){
			if(zenCounter <= 0){
				if(test.enzimeSwitch != 6){
					switch(graphSwitch){
						case 0:
							setArrowColor(g);
							if(michiCounter <= 0){
								t.line(arrowx,arrowy,arrowX,arrowY);
								t.line(arrowX, arrowY, xx2,yy2);
								t.line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.green);
							}else if(michiCounter > 0){
								t.dotted_line(arrowx,arrowy,arrowX,arrowY);
								t.dotted_line(arrowX, arrowY, xx2,yy2);
								t.dotted_line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.black);
								t.point(arrowX, arrowY);
							}
						break;

						case 2:
							setArrowColor(g);
							if(michiCounter <= 0){
								setArrowColor(g);
								t.line(arrowx,arrowy,arrowX,arrowY);
								t.line(arrowX, arrowY, xx2,yy2);
								t.line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.green);
							}else if(michiCounter > 0){
								t.dotted_line(arrowx,arrowy,arrowX,arrowY);
								t.dotted_line(arrowX, arrowY, xx2,yy2);
								t.dotted_line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.black);
								t.point(arrowX, arrowY);
							}
						break;

						case 3:
							setArrowColor(g);
							if(michiCounter <= 0){
								setArrowColor(g);
								t.line(arrowx,arrowy,arrowX,arrowY);
								t.line(arrowX, arrowY, xx2,yy2);
								t.line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.green);
							}else if(michiCounter > 0){
								t.dotted_line(arrowx,arrowy,arrowX,arrowY);
								t.dotted_line(arrowX, arrowY, xx2,yy2);
								t.dotted_line(arrowX, arrowY, xx3,yy3);
								g.setColor(Color.black);
								t.point(arrowX, arrowY);
							}
						break;

						default:
					}
				}else if(test.enzimeSwitch == 6){
					System.out.println("I AM PAINT ARROW");
					Frame f = new Frame();
					if(arrowXX[0] >= 0 && michiDataNumber[0] <= DATAREAD){
							g.setColor(Color.red);
							t.line(arrowx, arrowy, arrowXX[0], arrowYY[0]);
							t.line(arrowXX[0], arrowYY[0], xx2a[0],yy2a[0]);
							t.line(arrowXX[0], arrowYY[0], xx3a[0],yy3a[0]);
					}else if(michiDataNumber[0] > DATAREAD && michiTest > 0){
						g.setColor(Color.red);
						t.dotted_line(arrowx, arrowy, arrowXX[0], arrowYY[0]);
						t.dotted_line(arrowXX[0], arrowYY[0], xx2a[0],yy2a[0]);
						t.dotted_line(arrowXX[0], arrowYY[0], xx3a[0],yy3a[0]);
						g.setColor(Color.black);
						t.point(arrowXX[0], arrowYY[0]);
					}


					if(arrowXX[1] >= 0 && michiDataNumber[1] <= DATAREAD){
							g.setColor(Color.green);
							t.line(arrowx, arrowy, arrowXX[1], arrowYY[1]);
							t.line(arrowXX[1], arrowYY[1], xx2a[1],yy2a[1]);
							t.line(arrowXX[1], arrowYY[1], xx3a[1],yy3a[1]);
					}else if(michiDataNumber[1] > DATAREAD && michiTest > 0){
						g.setColor(Color.green);
						t.dotted_line(arrowx, arrowy, arrowXX[1], arrowYY[1]);
						t.dotted_line(arrowXX[1], arrowYY[1], xx2a[1],yy2a[1]);
						t.dotted_line(arrowXX[1], arrowYY[1], xx3a[1],yy3a[1]);
						g.setColor(Color.black);
						t.point(arrowXX[1], arrowYY[1]);
					}



					if(arrowXX[2] >= 0 && michiDataNumber[2] <= DATAREAD){
							g.setColor(Color.magenta);
							t.line(arrowx, arrowy, arrowXX[2], arrowYY[2]);
							t.line(arrowXX[2], arrowYY[2], xx2a[2],yy2a[2]);
							t.line(arrowXX[2], arrowYY[2], xx3a[2],yy3a[2]);
					}else if(michiDataNumber[2] > DATAREAD && michiTest > 0){
						g.setColor(Color.magenta);
						t.dotted_line(arrowx, arrowy, arrowXX[2], arrowYY[2]);
						t.dotted_line(arrowXX[2], arrowYY[2], xx2a[2],yy2a[2]);
						t.dotted_line(arrowXX[2], arrowYY[2], xx3a[2],yy3a[2]);
						g.setColor(Color.black);
						t.point(arrowXX[2], arrowYY[2]);
					}


					if(arrowXX[3] >= 0 && michiDataNumber[3] <= DATAREAD){
							g.setColor(Color.black);
							t.line(arrowx, arrowy, arrowXX[3], arrowYY[3]);
							t.line(arrowXX[3], arrowYY[3], xx2a[3],yy2a[3]);
							t.line(arrowXX[3], arrowYY[3], xx3a[3],yy3a[3]);
					}else if(michiDataNumber[3] > DATAREAD && michiTest > 0){
						g.setColor(Color.black);
						t.dotted_line(arrowx, arrowy, arrowXX[3], arrowYY[3]);
						t.dotted_line(arrowXX[3], arrowYY[3], xx2a[3],yy2a[3]);
						t.dotted_line(arrowXX[3], arrowYY[3], xx3a[3],yy3a[3]);
						g.setColor(Color.black);
						t.point(arrowXX[3], arrowYY[3]);
					}

					if(arrowXX[4] >= 0 && michiDataNumber[4] <= DATAREAD){
							g.setColor(Color.orange);
							t.line(arrowx, arrowy, arrowXX[4], arrowYY[4]);
							t.line(arrowXX[4], arrowYY[4], xx2a[4],yy2a[4]);
							t.line(arrowXX[4], arrowYY[4], xx3a[4],yy3a[4]);
					}else if(michiDataNumber[4] > DATAREAD && michiTest > 0){
						g.setColor(Color.orange);
						t.dotted_line(arrowx, arrowy, arrowXX[4], arrowYY[4]);
						t.dotted_line(arrowXX[4], arrowYY[4], xx2a[4],yy2a[4]);
						t.dotted_line(arrowXX[4], arrowYY[4], xx3a[4],yy3a[4]);
						g.setColor(Color.black);
						t.point(arrowXX[4], arrowYY[4]);
					}


					if(arrowXX[5] >= 0 && michiDataNumber[5] <= DATAREAD){
							g.setColor(Color.cyan);
							t.line(arrowx, arrowy, arrowXX[5], arrowYY[5]);
							t.line(arrowXX[5], arrowYY[5], xx2a[5],yy2a[5]);
							t.line(arrowXX[5], arrowYY[5], xx3a[5],yy3a[5]);
					}else if(michiDataNumber[5] > DATAREAD && michiTest > 0){
						g.setColor(Color.cyan);
						t.dotted_line(arrowx, arrowy, arrowXX[5], arrowYY[5]);
						t.dotted_line(arrowXX[5], arrowYY[5], xx2a[5],yy2a[5]);
						t.dotted_line(arrowXX[5], arrowYY[5], xx3a[5],yy3a[5]);
						g.setColor(Color.black);
						t.point(arrowXX[5], arrowYY[5]);
					}
				}
			}else{
				int flagpaint=0;
				switch(graphSwitch){
					case 0:
						for(int michi = 1; michi < r.DATACOUNTER; michi++){
							if(r.BackODS[michi] > 0 && r.BackAmide[michi] > 0){
								arrowX=-1; arrowY=-1; flagpaint = 0;
								for(int str = 0; str < DATAREAD; str++){
									if(r.BackSt[michi].equals(SimSt[str])){
										arrowX = ods[str];
										arrowY = amide[str];
									}
								}
								if(arrowX ==-1 && arrowY ==-1){
									arrowX = r.BackODS[michi];
									arrowY = r.BackAmide[michi];
									flagpaint = 1;
								}
								if(flagpaint ==0){
									g.setColor(Color.black);
									t.line(arrowX, arrowY, arrowx, arrowy);
								}
								if(flagpaint ==1){
									g.setColor(Color.red);
									t.line(arrowX, arrowY, arrowx, arrowy);
									g.setColor(Color.green);
									t.line(arrowX - r.BackErrO[michi], arrowY + r.BackErrA[michi], arrowX - r.BackErrO[michi], arrowY - r.BackErrA[michi]);
								    t.line(arrowX + r.BackErrO[michi], arrowY + r.BackErrA[michi], arrowX + r.BackErrO[michi], arrowY - r.BackErrA[michi]);
									t.line(arrowX - r.BackErrO[michi], arrowY + r.BackErrA[michi], arrowX + r.BackErrO[michi], arrowY + r.BackErrA[michi]);
									t.line(arrowX - r.BackErrO[michi], arrowY - r.BackErrA[michi], arrowX + r.BackErrO[michi], arrowY - r.BackErrA[michi]);
								}
							}
						}
					break;

					case 2:
						for(int michi = 1; michi < r.DATACOUNTER; michi++){
							if(r.BackODS[michi] > 0 && r.BackMw[michi] > 0){
								arrowX=-1; arrowY=-1; flagpaint = 0;
								for(int str = 0; str < DATAREAD; str++){
									if(r.BackSt[michi].equals(SimSt[str])){
										arrowX = ods[str];
										arrowY = mw[str];
									}
								}
								if(arrowX ==-1 && arrowY ==-1){
									arrowX = r.BackODS[michi];
									arrowY = r.BackMw[michi];
									flagpaint = 1;
								}
								if(flagpaint ==0){
									g.setColor(Color.black);
									t.line(arrowX, arrowY, arrowx, arrowy);
								}
								if(flagpaint ==1){
									g.setColor(Color.red);
									t.line(arrowX, arrowY, arrowx, arrowy);
									g.setColor(Color.green);
									t.line(arrowX - r.BackErrO[michi], arrowY + 0, arrowX - r.BackErrO[michi], arrowY - 0);
								    t.line(arrowX + r.BackErrO[michi], arrowY + 0, arrowX + r.BackErrO[michi], arrowY - 0);
									t.line(arrowX - r.BackErrO[michi], arrowY + 0, arrowX + r.BackErrO[michi], arrowY + 0);
									t.line(arrowX - r.BackErrO[michi], arrowY - 0, arrowX + r.BackErrO[michi], arrowY - 0);
								}
							}
						}
					break;

					case 3:
						for(int michi = 1; michi < r.DATACOUNTER; michi++){
							if(r.BackAmide[michi] > 0 && r.BackMw[michi] > 0){
								arrowX=-1; arrowY=-1; flagpaint = 0;
								for(int str = 0; str < DATAREAD; str++){
									if(r.BackSt[michi].equals(SimSt[str])){
										arrowX = amide[str];
										arrowY = mw[str];
									}
								}
								if(arrowX ==-1 && arrowY ==-1){
									arrowX = r.BackAmide[michi];
									arrowY = r.BackMw[michi];
									flagpaint = 1;
								}
								if(flagpaint ==0){
									g.setColor(Color.black);
									t.line(arrowX, arrowY, arrowx, arrowy);
								}
								if(flagpaint ==1){
									g.setColor(Color.red);
									t.line(arrowX, arrowY, arrowx, arrowy);
									g.setColor(Color.green);
									t.line(arrowX - r.BackErrO[michi], arrowY + 0, arrowX - r.BackErrO[michi], arrowY - 0);
								    t.line(arrowX + r.BackErrO[michi], arrowY + 0, arrowX + r.BackErrO[michi], arrowY - 0);
									t.line(arrowX - r.BackErrO[michi], arrowY + 0, arrowX + r.BackErrO[michi], arrowY + 0);
									t.line(arrowX - r.BackErrO[michi], arrowY - 0, arrowX + r.BackErrO[michi], arrowY - 0);
								}
							}
						}
					break;

					default:
				}
			}
		}

		//DISPLAYING SELECTED VALUES (X AND Y) ACCORDING TO GRAPH
		if(arrowCounter > 0){
			String xvalue, yvalue;
			Double xx, yy;
			String xval = "";
			String yval = "";
			switch(graphSwitch){
				case 0:
					xvalue = "ODS  =";
					yvalue = "AMIDE = ";
					g.drawString(xvalue + xval , 370, 410);
					g.drawString(yvalue + yval, 370, 425);
					if(ansx != 0 && ansy != 0){
						g.setColor(Color.red);
						xx = new Double(ansx);
						yy = new Double(ansy);
						xval = xx.toString();
						yval = yy.toString();
						g.drawString(xvalue + xval , 370, 410);
						g.drawString(yvalue + yval , 370, 425);
					}
					break;

				case 2:
					if(ansx != 0 && ansy != 0){
						g.setColor(Color.red);
						xvalue = "ODS  =";
						yvalue = "MW = ";
						 xx = new Double(ansx);
						 yy = new Double(ansy);
						g.drawString(xvalue +  xx.toString(), 370, 410);
						g.drawString(yvalue +  yy.toString(), 370, 425);
					}
					break;

				case 3:
					if(ansx != 0 && ansy != 0){
						g.setColor(Color.red);
						xvalue = "AMIDE  =";
						yvalue = "MW = ";
						 xx = new Double(ansx);
						 yy = new Double(ansy);
						g.drawString(xvalue +  xx.toString(), 370, 410);
						g.drawString(yvalue +  yy.toString(), 370, 425);
					}
					break;
				default:
			}
		}

		//DISPLAYING POINT AT MOUSE CLICK
		if(mouseCounter >= 0){
			switch(graphSwitch){
				case 0:
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawMousePoint(g, ods, amide);
						break;
						case 1:
							drawMousePoint(g, array0ods, array0amide);
						break;
						case 2:
							drawMousePoint(g, array1ods, array1amide);
						break;
						case 3:
							drawMousePoint(g, array2ods, array2amide);
						break;
						case 4:
							drawMousePoint(g, array3ods, array3amide);
						break;
						case 5:
							drawMousePoint(g, array4ods, array4amide);
						break;
						default:
					}
				break;

				case 2:
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawMousePoint(g, ods, mw);
						break;
						case 1:
							drawMousePoint(g, array0ods, array0mw);
						break;
						case 2:
							drawMousePoint(g, array1ods, array1mw);
						break;
						case 3:
							drawMousePoint(g, array2ods, array2mw);
						break;
						case 4:
							drawMousePoint(g, array3ods, array3mw);
						break;
						case 5:
							drawMousePoint(g, array4ods, array4mw);
						break;
						default:
					}
				break;

				case 3:
					switch(monoSwitchSet.monoSwitch){
						case 0:
							drawMousePoint(g, amide, mw);
						break;
						case 1:
							drawMousePoint(g, array0amide, array0mw);
						break;
						case 2:
							drawMousePoint(g, array1amide, array1mw);
						break;
						case 3:
							drawMousePoint(g, array2amide, array2mw);
						break;
						case 4:
							drawMousePoint(g, array3amide, array3mw);
						break;
						case 5:
							drawMousePoint(g, array4amide, array4mw);
						break;
						default:
					}
				default:
			}
		}

		//Switch to draw inlines of the graph
		int inX1,inX2,inY1,inY2;
		switch(graphSwitch){
			case 0:
				inX1 = (int)(Math.round(XX1*10)/10);
				inY1 = (int)(Math.round(YY1*10)/10);
				inX2 = (int)(Math.round(XX2*10)/10);
				inY2 = (int)(Math.round(YY2*10)/10);
				for( i = inX1;i <= inX2;i++){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 10)){
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*2);
					}else{
						g.setColor(Color.gray);
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*1);
					}
				}
				for(i = inY1;i <= inY2;i++){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 10)){
						t.line(XX1,i,XX1+(XX2-XX1)/100*2,i);
					}
					else{
						g.setColor(Color.gray);
						t.line(XX1,i,XX1+(XX2-XX1)/100*1,i);
					}
				}
			break;

			case 2:
				inX1 = (int)(Math.round(XX1*10)/10);
				inY1 = (int)(Math.round(YY1/100)*100);
				inX2 = (int)(Math.round(XX2*10)/10);
				inY2 = (int)(Math.round(YY2/100)*100);
				for( i = inX1;i <= inX2;i++){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 10)){
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*2);
					}else{
						g.setColor(Color.gray);
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*1);
					}
				}
				for( i = inY1;i <= inY2;i=i+100){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 500)){
						t.line(XX1,i,XX1+(XX2-XX1)/100*2,i);
					}else{
						g.setColor(Color.gray);
						t.line(XX1,i,XX1+(XX2-XX1)/100*1,i);
					}
				}
			break;

			case 3:
				inX1 = (int)(Math.round(XX1*10)/10);
				inY1 = (int)(Math.round(YY1/100)*100);
				inX2 = (int)(Math.round(XX2*10)/10);
				inY2 = (int)(Math.round(YY2/100)*100);
				for( i = inX1;i <= inX2;i++){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 10)){
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*2);
					}else{
						g.setColor(Color.gray);
						t.line(i,YY1,i,YY1+(YY2-YY1)/100*1);
					}
				}
				for( i = inY1;i <= inY2;i=i+100){
					g.setColor(Color.black);
					if(0 == Math.IEEEremainder(i, 500)){
						t.line(XX1,i,XX1+(XX2-XX1)/100*2,i);
					}else{
						g.setColor(Color.gray);
						t.line(XX1,i,XX1+(XX2-XX1)/100*1,i);
					}
				}
			break;

			default:
		}
	sialicflag = 0;
	}// end of paint method

	public void mouseClicked(MouseEvent e){
		//*******************************************
		buttonCenter.setEnabled(true);
		double ansxx = 0;
		double ansyy = 0;
		dialogCounter = 0;
		mouseCounter = 0;
		int AA = 1;
		int BB = 2;
		long aaa = 0;
		long bbb = 0;
		Date date = new Date();
		testset = -1;
		x = e.getX();
		ansx = t.graphX(x);
		ansx = Math.round((ansx*100.0))/100.0;
		y = e.getY();
		ansy = t.graphY(y);
		if(AA == e.getClickCount()){
			aaa = date.getTime();
		}
		if(BB == e.getClickCount()){
			bbb = date.getTime();
		}
		if((bbb - aaa) > 1 ){//&& inCounter > 0){
			doubleClickCounter++;
			ansxx = ansx;
			ansyy = ansy;
			for(set = 0; set < loopCounter; set++){
				frameArray[set] = -1;
			}

			try{
				URL link;
				switch(graphSwitch){
					case 0:
					System.out.println("in mouse click loopCounterCASE 00   "+loopCounter);
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansxx && (ods[set] + ODS_AMIDE_CONST) >= ansxx)
							if((amide[set] - ODS_AMIDE_CONST) <= ansyy && (amide[set] + ODS_AMIDE_CONST) >=ansyy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common] + ".html";
								URL url = new URL(getDocumentBase(),URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = -1;
							}
						}
					break;

					case 2:
					System.out.println("in mouse click loopCountercase 11   "+loopCounter);
						for(set = 0; set < loopCounter; set++){
							if((ods[set] - ODS_AMIDE_CONST) <= ansxx && (ods[set] + ODS_AMIDE_CONST) >= ansxx)
							if((mw[set] - MW_CONSTANT) <= ansyy && (mw[set] + MW_CONSTANT) >= ansyy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common] + ".html";
								URL url = new URL(getDocumentBase(),URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = -1;
							}
						}
					break;

					case 3:
						for(set = 0; set < loopCounter; set++){
							if((amide[set] -ODS_AMIDE_CONST) <= ansxx && (amide[set] + ODS_AMIDE_CONST) >= ansxx)
							if((mw[set] - MW_CONSTANT) <= ansyy && (mw[set] + MW_CONSTANT) >= ansyy){
								testset = set;
								frameArray[set] = set;
								dialogCounter = 0;
							}
						}
						for(int common = 0; common < loopCounter; common++){
							if(frameArray[common] >= 0){
								String tryUrl = Code[common] + ".html";
								URL url = new URL(getDocumentBase(),URL_STRING + tryUrl);
								// link = new URL(URL_STRING + tryUrl);
								getAppletContext().showDocument(url, "glycoanalysis" + common);
								frameArray[common] = -1;
							}
						}
					break;

					default:
						errorCounter--;
				}
			}catch(MalformedURLException mue){
				System.out.println("FAILED" + mue);
			}
		}else{
			for(int clr = 0; clr < ARRAY_LENGTH; clr++){
				frameArray[clr] = -1;
			}
			rule r = new rule();
			if((e.getModifiers() & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK){
				pmn.show(this, e.getX(),e.getY());
			}
			if(((e.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK)){
			mouseCounter++;
			ansy = Math.round((ansy*100.0))/100.0;
			Frame fff = new Frame();
				switch(graphSwitch){
					case 0:
					for(set = 0; set < loopCounter; set++){
						if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >=ansx)
						if((amide[set] - ODS_AMIDE_CONST) <= ansy && (amide[set] + ODS_AMIDE_CONST) >=ansy){
							testset = set;
							choicePoint = testset;
							frameArray[set] = set;
							ansx = ods[testset];
							ansy = amide[testset];
							for(common = 0;common<testset;common++){
								if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >= ansx)
									&&((amide[common] - ODS_AMIDE_CONST) <= ansy && (amide[common] + ODS_AMIDE_CONST) >= ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset + 1;common<loopCounter;common++){
									if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >=ansx)
										&&((amide[common] - ODS_AMIDE_CONST) <= ansy && (amide[common] + ODS_AMIDE_CONST) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						sialicId = -1;
						if(dialogCounter > 1){
							this.removeMouseListener(this);
							error = AllFinals.DIALOG_INFO;
							errorLabel.setText(error);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(fff, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code,mouseMem,this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
								sialicId = historyPoint;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = ods[historyPoint];
									ansy = amide[historyPoint];
								}
							}
						    this.addMouseListener(this);
							error = "";
							errorLabel.setText(error);
							choicePoint = testset;
							if(delArrow == testset){
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}

						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = -1;
						}else{
							HistP = -1;
							td.SetData("","");
						}
						//arrow button disable
						if(mouseMem > DATAREAD){
							buttonArrow.setEnabled(false);
						}else{
							buttonArrow.setEnabled(true);
						}
						//arrow button disable
						/*if(HistP < DATAREAD){
							buttonArrow.setEnabled(true);
							error = "";
							errorLabel.setText(error);
						}else if(HistP >= DATAREAD){
							buttonArrow.setEnabled(false);
							error = "";
							errorLabel.setText(error);
						}*/
					break;

					case 2:
					for(set = 0; set < loopCounter; set++){
						if((ods[set] - ODS_AMIDE_CONST) <= ansx && (ods[set] + ODS_AMIDE_CONST) >=ansx)
						if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >=ansy){
							testset = set;
							choicePoint = testset;
							frameArray[set] = set;
							ansx = ods[testset];
							ansy = mw[testset];
							for(common = 0;common<testset;common++){
								if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >= ansx)
									&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >= ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset + 1;common<loopCounter;common++){
									if(((ods[common] - ODS_AMIDE_CONST) <= ansx && (ods[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						if(dialogCounter > 1){
							this.removeMouseListener(this);
							error = AllFinals.DIALOG_INFO;
							errorLabel.setText(error);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(fff, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code,mouseMem,this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = ods[historyPoint];
									ansy = mw[historyPoint];
								}
							}
							this.addMouseListener(this);
							error = "";
							errorLabel.setText(error);
							choicePoint = testset;
							if(delArrow == testset){
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}

						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = -1;
						}else{
							td.SetData("","");
							HistP = -1;
						}
						//arrow button disable
						if(mouseMem > DATAREAD){
							buttonArrow.setEnabled(false);
						}else{
							buttonArrow.setEnabled(true);
						}/*
						//arrow button disable
						if(HistP < DATAREAD){
							buttonArrow.setEnabled(true);
							error = "";
							errorLabel.setText(error);
						}else if(HistP >= DATAREAD){
							buttonArrow.setEnabled(false);
							error = "";
							errorLabel.setText(error);
						}*/
					break;

					case 3:
						for(set = 0; set < loopCounter; set++){
							if((amide[set] - ODS_AMIDE_CONST) <= ansx && (amide[set] + ODS_AMIDE_CONST) >=ansx)
							if((mw[set] - MW_CONSTANT) <= ansy && (mw[set] + MW_CONSTANT) >=ansy){
								testset = set;
								choicePoint = testset;
								frameArray[set] = set;
								ansx = amide[testset];
								ansy = mw[testset];
								for(common = 0;common<=testset-1;common++){
									if(((amide[common] -ODS_AMIDE_CONST) <= ansx && (amide[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
								for(common = testset + 1;common<loopCounter;common++){
									if(((amide[common] - ODS_AMIDE_CONST) <= ansx && (amide[common] + ODS_AMIDE_CONST) >=ansx)
										&&((mw[common] - MW_CONSTANT) <= ansy && (mw[common] + MW_CONSTANT) >=ansy)){
										dialogCounter++;
										frameArray[common] = common;
									}else{
										frameArray[common] = -1;
									}
								}
							}
						}
						if(dialogCounter > 1){
							this.removeMouseListener(this);
							error = AllFinals.DIALOG_INFO;
							errorLabel.setText(error);
							dialogCounter = 0;
							Myframe ff;
						    ff = new Myframe(fff, AllFinals.MULTIPLE_POINT_FRAME_HEADER, true, frameArray, SimSt, Code,mouseMem,this);
							if(ff.returnM >= 0){
								testset = ff.returnM;
								historyPoint = testset;
							}else{
								if(historyPoint >= 0){
									testset = historyPoint;
									ansx = amide[historyPoint];
									ansy = mw[historyPoint];
								}
							}
							this.addMouseListener(this);
							error = "";
							errorLabel.setText(error);
							choicePoint = testset;
							if(delArrow == testset){
							}else{
								enzimeCounter = 0;
								delArrow = testset;
							}
						}
						arrowCounter++;
						if(testset != -1){
							td.SetData(SimSt[testset], Code[testset]);
							HistP = testset;
							testset = -1;
						}else{
							HistP = -1;
							td.SetData("","");
						}
						//arrow button disable
						/*
						if(HistP < DATAREAD){
							buttonArrow.setEnabled(true);
							error = "";
							errorLabel.setText(error);
						}else if(HistP >= DATAREAD){
							buttonArrow.setEnabled(false);
							error = "";
							errorLabel.setText(error);
						}*/
					break;

					default:
						errorCounter++;
				}
			}
		}
		if(ansx != 0 && ansy != 0){
			if(!buttonCenter.isEnabled()){
				buttonCenter.setEnabled(true);
			}
		}
		repaint();
	}

	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public void drawError(Graphics gg, double x, double y, double erx, double ery){
		gg.setColor(Color.green);
		expx = x;
		expy = y;
		errorx = erx;
		errory = ery;
		if(errorx != 0 && errory != 0 && expx != 0 && expy != 0){//ALL AVAILABLE // rectangle
			t.line(expx - errorx, expy + errory, expx - errorx, expy - errory);
			t.line(expx + errorx, expy + errory, expx + errorx, expy - errory);
			t.line(expx - errorx, expy + errory, expx + errorx, expy + errory);
			t.line(expx - errorx, expy - errory, expx + errorx, expy - errory);
		}else if(expx != 0 && expy != 0 && errorx != 0 && errory == 0){//Y AXIS ERROR FIELD ZERO // line only
			t.line(expx, expy, expx + errorx, expy);
			t.line(expx, expy, expx - errorx, expy);
		}else if(expx != 0 && expy != 0 && errorx == 0 && errory != 0){//X AXIS ERROR FIELD ZERO // line only
			t.line(expx, expy, expx, expy + errory);
			t.line(expx, expy, expx, expy - errory);
		}else if(expx != 0 && expy == 0 && errorx == 0 && errory == 0){//ONLY X FIELD IS AVAILABLE // full line
			t.line(expx, expx, expx, YY2);
			t.line(expx, expx, expx, YY1);
		}else if(expx == 0 && expy != 0 && errorx == 0 && errory == 0){//ONLY Y FIELD IS AVAILABLE // full line
			t.line(XX1, expy, expy, expy);
			t.line(XX2, expy, expy, expy);
		}else if(expx == 0 && expy != 0 && errorx == 0 && errory != 0){// Y FIELD AND Y ERROR FIELD IS AVAILABLE // full line
			t.line(XX1, expy, expy, expy);
			t.line(XX2, expy, expy, expy);
			t.line(XX1, expy + errory, expy + errory, expy + errory);
			t.line(XX2, expy + errory, expy + errory, expy + errory);
			t.line(XX1, expy - errory, expy - errory, expy - errory);
			t.line(XX2, expy - errory, expy - errory, expy - errory);
		}else if(expx != 0 && expy == 0 && errorx != 0 && errory == 0){// X FIELD AND X ERROR FIELD IS AVAILABLE // full line
			t.line(expx, expx, expx, YY1);
			t.line(expx, expx, expx, YY2);
			t.line(expx + errorx, expx + errorx, expx + errorx, YY1);
			t.line(expx + errorx, expx + errorx, expx + errorx, YY2);
			t.line(expx - errorx, expx - errorx, expx - errorx, YY1);
			t.line(expx - errorx, expx - errorx, expx - errorx, YY2);
		}else if(expx != 0 && expy != 0 && errorx == 0 && errory == 0){
			t.line(expx - ((XX2 - XX1)*1.5)/100, expy, expx + ((XX2 - XX1)*1.5)/100, expy);
			t.line(expx, expy - ((YY2 - YY1)*1.5)/100, expx, expy + ((YY2 - YY1)*1.5)/100);
		}
	}

	public void drawGraph(double[] x, double[] y){
		for (i = 0 ; i < DATAREAD; i ++){
			if(x[i] !=0 && y[i] !=0){
				t.point(x[i], y[i]);
			}
		}
	}

	public void drawMousePoint(Graphics gg, double[] x, double[] y){
		int dumy = 0;
		int isData = 0;
		dumy = choicePoint;
		choicePoint = 0;
		int forCounter = 0;
		if(ansx > 0 && ansy > 0){
			int counter = 0;
		switch(graphSwitch){
			case 0:
				for(int mouseClick = 0; mouseClick < loopCounter; mouseClick++){
					if((x[mouseClick] - ODS_AMIDE_CONST) <= ansx && (x[mouseClick] + ODS_AMIDE_CONST) >=ansx)
					if((y[mouseClick] - ODS_AMIDE_CONST) <= ansy && (y[mouseClick] +ODS_AMIDE_CONST) >=ansy){
						gg.setColor(Color.red);
						if(sialicflag == 0){
							if(HistP == mouseClick){
								t.point(x[mouseClick], y[mouseClick]);
								mouseMem = mouseClick;
								counter++;
								isData ++;
							}
						}
						if((setErOds != 0 || setErAmide != 0)&&mouseCounter == 0){
							//Do nothing
						}else{
							choicePoint = dumy;
						}
					}
				}
				if(counter <= 0){
					mouseMem = -1;
				}
				if(counter == 1){
					historyPoint = mouseMem;
				}
				if(sialicflag == 1 && HistP >= 0){
					if(x[HistP] != 0 && y[HistP] !=0){
						gg.setColor(Color.red);
						choicePoint = HistP;
						td.SetData(SimSt[HistP], Code[HistP]);
						t.point(x[HistP],y[HistP]);
						isData++;
					}
				}
				if(HistP >= DATAREAD){
					buttonArrow.setEnabled(false);
					t.point(ansx,ansy);
					isData ++;
				}else{
					buttonArrow.setEnabled(true);
				}
				System.out.println("HistP : " + HistP);
				if(isData == 0){
					gg.setColor(Color.red);
					td.SetData("","");
					t.line(ansx - ((XX2 - XX1)*1.5)/100, ansy, ansx + ((XX2 - XX1)*1.5)/100, ansy);
					t.line(ansx, ansy - ((YY2 - YY1)*1.5)/100, ansx, ansy + ((YY2 - YY1)*1.5)/100);
				}
			break;

			case 2:
				for(int mouseClick = 0; mouseClick < loopCounter; mouseClick++){
					if((x[mouseClick] - ODS_AMIDE_CONST) <= ansx && (x[mouseClick] + ODS_AMIDE_CONST) >=ansx)
					if((y[mouseClick] - MW_CONSTANT) <= ansy && (y[mouseClick] +MW_CONSTANT) >=ansy){
						gg.setColor(Color.red);
						if(sialicflag == 0){
							if(HistP == mouseClick){
								t.point(x[mouseClick], y[mouseClick]);
								mouseMem = mouseClick;
								counter++;
								isData ++;
							}
						}
						if((setErOds != 0 || setErMw != 0)&&mouseCounter == 0){
							//Do nothing
						}else{
							choicePoint = dumy;
						}
					}
				}
				if(counter <= 0){
					mouseMem = -1;
				}
				if(counter == 1){
					historyPoint = mouseMem;
				}
				if(sialicflag == 1 && HistP >= 0){
					if(x[HistP] != 0 && y[HistP] !=0){
						gg.setColor(Color.red);
						choicePoint = HistP;
						td.SetData(SimSt[HistP], Code[HistP]);
						t.point(x[HistP],y[HistP]);
						isData++;
					}
				}
				if(HistP >= DATAREAD){
					buttonArrow.setEnabled(false);
					t.point(ansx,ansy);
					isData ++;
				}else{
					buttonArrow.setEnabled(true);
				}
				
				if(isData == 0){
					gg.setColor(Color.red);
					td.SetData("","");
					t.line(ansx - ((XX2 - XX1)*1.5)/100, ansy, ansx + ((XX2 - XX1)*1.5)/100, ansy);
					t.line(ansx, ansy - ((YY2 - YY1)*1.5)/100, ansx, ansy + ((YY2 - YY1)*1.5)/100);
				}
			break;

			case 3:
				for(int mouseClick = 0; mouseClick < loopCounter; mouseClick++){
					if((x[mouseClick] - ODS_AMIDE_CONST) <= ansx && (x[mouseClick] + ODS_AMIDE_CONST) >=ansx)
					if((y[mouseClick] - MW_CONSTANT) <= ansy && (y[mouseClick] + MW_CONSTANT) >=ansy){
						gg.setColor(Color.red);
						if(sialicflag == 0){
							if(HistP == mouseClick){
								t.point(x[mouseClick], y[mouseClick]);
								mouseMem = mouseClick;
								counter ++;
								isData ++;
							}
						}
						if((setErAmide != 0 || setErMw != 0)&&mouseCounter == 0){
							//Do Nothing
						}else{
							choicePoint = dumy;
						}
					}
				}
				if(counter <= 0){
					mouseMem = -1;
				}
				if(counter == 1){
					historyPoint = mouseMem;
				}
				
				if(HistP >= DATAREAD){
					buttonArrow.setEnabled(false);
					t.point(ansx,ansy);
					isData ++;
				}else{
					buttonArrow.setEnabled(true);
				}
				
				if(sialicflag == 1 && HistP >= 0){
					if(x[HistP] != 0 && y[HistP] !=0 ){
						gg.setColor(Color.red);
						choicePoint = HistP;
						td.SetData(SimSt[HistP], Code[HistP]);
						t.point(x[HistP],y[HistP]);
						isData++;
					}
				}
				
				if(isData == 0){
					gg.setColor(Color.red);
					td.SetData("","");
					t.line(ansx - ((XX2 - XX1)*1.5)/100, ansy, ansx + ((XX2 - XX1)*1.5)/100, ansy);
					t.line(ansx, ansy - ((YY2 - YY1)*1.5)/100, ansx, ansy + ((YY2 - YY1)*1.5)/100);
				}
			break;

			default:
				errorCounter++;
		}
		}
	}

	public boolean isMousePoint(){
		boolean isPoint = false;
		switch(graphSwitch){
			case 0:
				if( setErOds != 0 || setErAmide != 0){
					isPoint = true;
				}else{
					isPoint = false;
				}
			break;

			case 2:
				if( setErOds != 0 || setErMw != 0){
					isPoint = true;
				}else{
					isPoint = false;
				}
			break;

			case 3:
				if( setErAmide != 0 || setErMw != 0){
					isPoint = true;
				}else{
					isPoint = false;
				}
			break;

			default:
				isPoint = true;
		}
		return isPoint;
	}

	public void setArrowColor(Graphics g){
		if(test.enzimeSwitch == 0){
			g.setColor(Color.red);
		}else if(test.enzimeSwitch == 1){
			g.setColor(Color.green);
		}else if(test.enzimeSwitch == 2){
			g.setColor(Color.magenta);
		}else if(test.enzimeSwitch == 3){
			g.setColor(Color.black);
		}else if(test.enzimeSwitch == 4){
			g.setColor(Color.orange);
		}else if(test.enzimeSwitch == 5){
			g.setColor(Color.cyan);
		}else{
			g.setColor(Color.black);
		}
	}

	public void setTextEditable(){
			Color disabled = new Color(155,155,155);
		switch(graphSwitch){
			case 0:
				fieldOds.setBackground(Color.white);
				erOds.setBackground(Color.white);

				fieldAmide.setBackground(Color.white);
				erAmide.setBackground(Color.white);

				fieldMw.setBackground(disabled);
				erMw.setBackground(disabled);
			break;

			case 2:
				fieldOds.setBackground(Color.white);
				erOds.setBackground(Color.white);

				fieldAmide.setBackground(disabled);
				erAmide.setBackground(disabled);

				fieldMw.setBackground(Color.white);
				erMw.setBackground(Color.white);
			break;

			case 3:
				fieldOds.setBackground(disabled);
				erOds.setBackground(disabled);

				fieldAmide.setBackground(Color.white);
				erAmide.setBackground(Color.white);

				fieldMw.setBackground(Color.white);
				erMw.setBackground(Color.white);
			break;

			default:
		}
	}
} // end of Applet