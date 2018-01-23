import java.awt.*;
import java.lang.*;
import java.net.*;
import java.awt.event.*;
import java.applet.*;

class MultiSearchFrame extends Frame implements ActionListener, ItemListener{
	private Button mbt1;
	private Button mbt2;
	private Button mbt3;
	private Button mbt4;
	
	private Panel mp1;
	private Panel mp2;
	private Panel mp3;
	private Panel mp4;
	
	private Panel mp21;
	private Panel mp22;
	private Panel mp23;
	private Panel mp24;
	
	private GalaxySystem2 ssmain2;
	private Image TreeImage;
	private Image CodeImage;
	
	private Checkbox tfazzy;
	private Checkbox tfit;
	private Checkbox cfazzy;
	private Checkbox cfit;
	
	private Checkbox ccb1;
	private Checkbox ccb2;
	private Checkbox ccb3;
	private Checkbox ccb4;
	private Checkbox ccb5;
	private Checkbox ccb11;
	private Checkbox ccb12;
	private Checkbox ccb13;
	private Checkbox ccb21;
	private Checkbox ccb22;
	private Checkbox ccb31;
	private Checkbox ccb32;
	
	private TextField ctf1;
	private TextField ctf2;
	private TextField ctf3;
	private TextField ctf4;
	private TextField ctf5;
	private TextField ctf11;
	private TextField ctf12;
	private TextField ctf13;
	private TextField ctf21;
	private TextField ctf22;
	private TextField ctf31;
	private TextField ctf32;
	
	private TextField codetf;
	private TextField stf;
	
	private TreeCanvas Tc;
	
	private int fwidth = 600;
	private int fheight = 560;
	
	public MultiSearchFrame(String title){
		super(title);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		this.setBounds((d.width-fwidth)/2,(d.height-fheight)/2,fwidth,fheight);
		load_component1();
	}
	
	public void load_component1(){
		Panel p = new Panel();
		p.setBackground(new Color(255,255,255));
		p.setLayout(null);
		
		int stx = 100;
		int sty = 5;
		
		mbt1 = new Button("Tree");
		mbt1.addActionListener(this);
		mbt1.setActionCommand("tree");
		mbt1.setBackground(new Color(255,255,255));
		mbt1.setForeground(new Color(0,0,255));
		mbt1.setBounds(stx,sty,100,20);
		
		mbt2 = new Button("Composition");
		mbt2.addActionListener(this);
		mbt2.setActionCommand("comp");
		mbt2.setBackground(new Color(100,100,100));
		mbt2.setForeground(new Color(0,0,0));
		mbt2.setBounds(stx+100,sty,100,20);
		
		mbt3 = new Button("Code No.");
		mbt3.addActionListener(this);
		mbt3.setActionCommand("code");
		mbt3.setBackground(new Color(100,100,100));
		mbt3.setForeground(new Color(0,0,0));
		mbt3.setBounds(stx+200,sty,100,20);
		
		mbt4 = new Button("Source");
		mbt4.addActionListener(this);
		mbt4.setActionCommand("sour");
		mbt4.setBackground(new Color(100,100,100));
		mbt4.setForeground(new Color(0,0,0));
		mbt4.setBounds(stx+300,sty,100,20);
		
		mp1 = new Panel();
		mp1.setLayout(null);
		mp1.setBackground(new Color(255,220,220));
		mp1.setBounds(0,sty+20,fwidth,fheight-(sty+20));
		mp1.setVisible(true);
		
		mp2 = new Panel();
		mp2.setLayout(null);
		mp2.setBackground(new Color(220,255,220));
		mp2.setBounds(0,sty+20,fwidth,fheight-(sty+20));
		mp2.setVisible(false);
		
		mp3 = new Panel();
		mp3.setLayout(null);
		mp3.setBackground(new Color(220,220,255));
		mp3.setBounds(0,sty+20,fwidth,fheight-(sty+20));
		mp3.setVisible(false);
		
		mp4 = new Panel();
		mp4.setLayout(null);
		mp4.setBackground(new Color(220,255,255));
		mp4.setBounds(0,sty+20,fwidth,fheight-(sty+20));
		mp4.setVisible(false);
		
		p.add(mbt1);
		p.add(mbt2);
		p.add(mbt3);
		p.add(mbt4);
		p.add(mp1);
		p.add(mp2);
		p.add(mp3);
		p.add(mp4);
		this.add(p);
	}
	
	public void load_componentTree(){
		TreeImage = ssmain2.ImageLoad_tree();
		Tc = new TreeCanvas(TreeImage);
		Tc.setBounds(100,5,400,400);
		mp1.add(Tc);
		
		Button tbt1 = new Button("Hex");
		tbt1.addActionListener(this);
		tbt1.setActionCommand("hex");
		tbt1.setBounds(510,305,60,20);
		mp1.add(tbt1);
		
		Button tbt2 = new Button("HexNac");
		tbt2.addActionListener(this);
		tbt2.setActionCommand("hexn");
		tbt2.setBounds(510,325,60,20);
		mp1.add(tbt2);
		
		Button tbt3 = new Button("Sia");
		tbt3.addActionListener(this);
		tbt3.setActionCommand("sia");
		tbt3.setBounds(510,345,60,20);
		mp1.add(tbt3);
		
		Button tbt4 = new Button("Fuc");
		tbt4.addActionListener(this);
		tbt4.setActionCommand("fuc");
		tbt4.setBounds(510,365,60,20);
		mp1.add(tbt4);
		
		Button tbt5 = new Button("Xyl");
		tbt5.addActionListener(this);
		tbt5.setActionCommand("xyl");
		tbt5.setBounds(510,385,60,20);
		mp1.add(tbt5);
		
		Button tbtr = new Button("Reset");
		tbtr.addActionListener(this);
		tbtr.setActionCommand("trest");
		tbtr.setBounds(10,10,60,20);
		mp1.add(tbtr);
		
		Label tla = new Label("Search Mode");
		tla.setBounds(10,50,80,20);
		mp1.add(tla);
		
		CheckboxGroup tgr = new CheckboxGroup();
		
		tfit = new Checkbox("fit");
		tfit.setCheckboxGroup(tgr);
		tfit.addItemListener(this);
		tfit.setBounds(10,80,60,20);
		tfit.setState(true);
		mp1.add(tfit);
		
		tfazzy = new Checkbox("fuzzy");
		tfazzy.setCheckboxGroup(tgr);
		tfazzy.addItemListener(this);
		tfazzy.setBounds(10,110,60,20);
		mp1.add(tfazzy);
	}
	
	public void load_componentComp(){
		Button cbtr = new Button("Reset");
		cbtr.addActionListener(this);
		cbtr.setActionCommand("crest");
		cbtr.setBounds(10,10,60,20);
		mp2.add(cbtr);
		
		Label cla = new Label("Search Mode");
		cla.setBounds(10,50,80,20);
		mp2.add(cla);
		
		CheckboxGroup cgr = new CheckboxGroup();
		
		cfit = new Checkbox("fit");
		cfit.setCheckboxGroup(cgr);
		cfit.addItemListener(this);
		cfit.setBounds(10,80,60,20);
		cfit.setState(true);
		mp2.add(cfit);
		
		cfazzy = new Checkbox("fuzzy");
		cfazzy.setCheckboxGroup(cgr);
		cfazzy.addItemListener(this);
		cfazzy.setBounds(10,110,60,20);
		mp2.add(cfazzy);
		
		mp21 = new Panel();
		mp21.setLayout(null);
		mp21.setBackground(new Color(255,255,255));
		mp21.setBounds(100,10,200,200);
		mp21.setVisible(true);
		
		mp22 = new Panel();
		mp22.setLayout(null);
		mp22.setBackground(new Color(255,200,255));
		mp22.setBounds(310,10,200,150);
		mp22.setVisible(false);
		
		mp23 = new Panel();
		mp23.setLayout(null);
		mp23.setBackground(new Color(255,255,200));
		mp23.setBounds(310,170,200,100);
		mp23.setVisible(false);
		
		mp24 = new Panel();
		mp24.setLayout(null);
		mp24.setBackground(new Color(200,255,255));
		mp24.setBounds(310,280,200,100);
		mp24.setVisible(false);
		
		// Composition
		
		Label cla1 = new Label("- Composition -");
		cla1.setBounds(10,1,100,20);
		mp21.add(cla1);
		
		Label cla11 = new Label("Hex");
		cla11.setBounds(10,30,50,20);
		cla11.setBackground(new Color(255,200,255));
		mp21.add(cla11);
		
		ccb1 = new Checkbox("");
		ccb1.addItemListener(this);
		ccb1.setBounds(65,30,20,20);
		mp21.add(ccb1);
		
		ctf1 = new TextField("",10);
		ctf1.setBounds(90,30,70,20);
		mp21.add(ctf1);
		
		Label cla12 = new Label("HexNAc");
		cla12.setBounds(10,60,50,20);
		cla12.setBackground(new Color(255,255,200));
		mp21.add(cla12);
		
		ccb2 = new Checkbox("");
		ccb2.addItemListener(this);
		ccb2.setBounds(65,60,20,20);
		mp21.add(ccb2);
		
		ctf2 = new TextField("",10);
		ctf2.setBounds(90,60,70,20);
		mp21.add(ctf2);

		Label cla13 = new Label("Sia");
		cla13.setBounds(10,90,50,20);
		cla13.setBackground(new Color(200,255,255));
		mp21.add(cla13);
		
		ccb3 = new Checkbox("");
		ccb3.addItemListener(this);
		ccb3.setBounds(65,90,20,20);
		mp21.add(ccb3);
		
		ctf3 = new TextField("",10);
		ctf3.setBounds(90,90,70,20);
		mp21.add(ctf3);
		
		Label cla14 = new Label("Fuc");
		cla14.setBounds(10,120,50,20);
		mp21.add(cla14);
		
		ccb4 = new Checkbox("");
		ccb4.addItemListener(this);
		ccb4.setBounds(65,120,20,20);
		mp21.add(ccb4);
		
		ctf4 = new TextField("",10);
		ctf4.setBounds(90,120,70,20);
		mp21.add(ctf4);
		
		Label cla15 = new Label("Xyl");
		cla15.setBounds(10,150,50,20);
		mp21.add(cla15);
		
		ccb5 = new Checkbox("");
		ccb5.addItemListener(this);
		ccb5.setBounds(65,150,20,20);
		mp21.add(ccb5);
		
		ctf5 = new TextField("",10);
		ctf5.setBounds(90,150,70,20);
		mp21.add(ctf5);
		
		// Hex
		
		Label cla2 = new Label("- Hex -");
		cla2.setBounds(5,1,100,20);
		mp22.add(cla2);
		
		Label cla21 = new Label("Man");
		cla21.setBounds(10,30,50,20);
		mp22.add(cla21);
		
		ccb11 = new Checkbox("");
		ccb11.addItemListener(this);
		ccb11.setBounds(65,30,20,20);
		mp22.add(ccb11);
		
		ctf11 = new TextField("",10);
		ctf11.setBounds(90,30,70,20);
		mp22.add(ctf11);
		
		Label cla22 = new Label("Gal");
		cla22.setBounds(10,60,50,20);
		mp22.add(cla22);
		
		ccb12 = new Checkbox("");
		ccb12.addItemListener(this);
		ccb12.setBounds(65,60,20,20);
		mp22.add(ccb12);
		
		ctf12 = new TextField("",10);
		ctf12.setBounds(90,60,70,20);
		mp22.add(ctf12);

		Label cla23 = new Label("Glc");
		cla23.setBounds(10,90,50,20);
		mp22.add(cla23);
		
		ccb13 = new Checkbox("");
		ccb13.addItemListener(this);
		ccb13.setBounds(65,90,20,20);
		mp22.add(ccb13);
		
		ctf13 = new TextField("",10);
		ctf13.setBounds(90,90,70,20);
		mp22.add(ctf13);
		
		// HexNAc
		
		Label cla3 = new Label("- HexNAc -");
		cla3.setBounds(5,1,100,20);
		mp23.add(cla3);
		
		Label cla31 = new Label("GlcNAc");
		cla31.setBounds(10,30,50,20);
		mp23.add(cla31);
		
		ccb21 = new Checkbox("");
		ccb21.addItemListener(this);
		ccb21.setBounds(65,30,20,20);
		mp23.add(ccb21);
		
		ctf21 = new TextField("",10);
		ctf21.setBounds(90,30,70,20);
		mp23.add(ctf21);
		
		Label cla32 = new Label("GalNAc");
		cla32.setBounds(10,60,50,20);
		mp23.add(cla32);
		
		ccb22 = new Checkbox("");
		ccb22.addItemListener(this);
		ccb22.setBounds(65,60,20,20);
		mp23.add(ccb22);
		
		ctf22 = new TextField("",10);
		ctf22.setBounds(90,60,70,20);
		mp23.add(ctf22);
		
		// Sia
		
		Label cla4 = new Label("- Sia -");
		cla4.setBounds(5,1,100,20);
		mp24.add(cla4);
		
		Label cla41 = new Label("NeuAc");
		cla41.setBounds(10,30,50,20);
		mp24.add(cla41);
		
		ccb31 = new Checkbox("");
		ccb31.addItemListener(this);
		ccb31.setBounds(65,30,20,20);
		mp24.add(ccb31);
		
		ctf31 = new TextField("",10);
		ctf31.setBounds(90,30,70,20);
		mp24.add(ctf31);
		
		Label cla42 = new Label("NeuGc");
		cla42.setBounds(10,60,50,20);
		mp24.add(cla42);
		
		ccb32 = new Checkbox("");
		ccb32.addItemListener(this);
		ccb32.setBounds(65,60,20,20);
		mp24.add(ccb32);
		
		ctf32 = new TextField("",10);
		ctf32.setBounds(90,60,70,20);
		mp24.add(ctf32);
		
		
		// ã§í 
		
		Label lbn1 = new Label("n");
		lbn1.setFont(new Font("Dialog",Font.BOLD,11));
		lbn1.setBounds(115,10,20,20);
		mp21.add(lbn1);
		Label lbn2 = new Label("n");
		lbn2.setFont(new Font("Dialog",Font.BOLD,11));
		lbn2.setBounds(115,10,20,20);
		mp22.add(lbn2);
		Label lbn3 = new Label("n");
		lbn3.setFont(new Font("Dialog",Font.BOLD,11));
		lbn3.setBounds(115,10,20,20);
		mp23.add(lbn3);
		Label lbn4 = new Label("n");
		lbn4.setFont(new Font("Dialog",Font.BOLD,11));
		lbn4.setBounds(115,10,20,20);
		mp24.add(lbn4);
		
		mp2.add(mp21);
		mp2.add(mp22);
		mp2.add(mp23);
		mp2.add(mp24);
		
	}
	
	public void load_componentCode(){
		CodeImage = ssmain2.ImageLoad_code();
		CodeCanvas Cc = new CodeCanvas(CodeImage);
		Cc.setBounds(100,55,400,170);
		mp3.add(Cc);
		
		Button codebtr = new Button("Reset");
		codebtr.addActionListener(this);
		codebtr.setActionCommand("coderest");
		codebtr.setBounds(10,10,60,20);
		mp3.add(codebtr);
		
		Label codel = new Label("Code: ");
		codel.setBounds(100,20,50,20);
		mp3.add(codel);
		
		codetf = new TextField();
		codetf.setBounds(150,20,150,20);
		mp3.add(codetf);
		
		Button codebts = new Button("Search");
		codebts.addActionListener(this);
		codebts.setActionCommand("codebts");
		codebts.setBounds(300,20,70,20);
		mp3.add(codebts);
	}
	
	public void load_componentSour(){
		Button sbtr = new Button("Reset");
		sbtr.addActionListener(this);
		sbtr.setActionCommand("srest");
		sbtr.setBounds(10,10,60,20);
		mp4.add(sbtr);
		
		Label slb = new Label("Source: ");
		slb.setBounds(100,20,50,20);
		mp4.add(slb);
		
		stf = new TextField();
		stf.setBounds(150,20,150,20);
		mp4.add(stf);
		
		TextArea SourceInfo = new TextArea(getSourceSt(),350,300);
		SourceInfo.setBounds(100,100,350,300);
		mp4.add(SourceInfo);
		
		Button sbts = new Button("Search");
		sbts.addActionListener(this);
		sbts.setActionCommand("sbts");
		sbts.setBounds(300,20,70,20);
		mp4.add(sbts);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.blue);
	}
	
	public void setMain(GalaxySystem2 ssmain){
		this.ssmain2 = ssmain;
		load_componentTree();
		load_componentComp();
		load_componentCode();
		load_componentSour();
	}
	
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		if(action.equals("tree")){
			Menu_Bt_Clear();
			mbt1.setBackground(Color.white);
			mbt1.setForeground(Color.blue);
			mp1.setVisible(true);
			
		}else if(action.equals("comp")){
			Menu_Bt_Clear();
			mbt2.setBackground(Color.white);
			mbt2.setForeground(Color.blue);
			mp2.setVisible(true);
			
		}else if(action.equals("code")){
			Menu_Bt_Clear();
			mbt3.setBackground(Color.white);
			mbt3.setForeground(Color.blue);
			mp3.setVisible(true);
			
		}else if(action.equals("sour")){
			Menu_Bt_Clear();
			mbt4.setBackground(Color.white);
			mbt4.setForeground(Color.blue);
			mp4.setVisible(true);
		}
		
		if(action.equals("hex")){
			System.out.println("hex");
			Tc.setHex();
		}else if(action.equals("hexn")){
			System.out.println("hexn");
			Tc.setHexN();
		}else if(action.equals("sia")){
			System.out.println("sia");
			Tc.setSia();
		}else if(action.equals("fuc")){
			System.out.println("fuc");
			Tc.setFuc();
		}else if(action.equals("xyl")){
			System.out.println("xyl");
			Tc.setXyl();
		}else if(action.equals("trest")){
			tfit.setState(true);
			//èâä˙âªèàóù
			System.out.println("trest");
			Tc.DClean();
		}
		
		if(action.equals("crest")){
			//èâä˙âªèàóù
			cfit.setState(true);
			mp22.setVisible(false);
			mp23.setVisible(false);
			mp24.setVisible(false);
			
			ccb1.setState(false);
			ccb2.setState(false);
			ccb3.setState(false);
			ccb4.setState(false);
			ccb5.setState(false);
			ccb11.setState(false);
			ccb12.setState(false);
			ccb13.setState(false);
			ccb21.setState(false);
			ccb22.setState(false);
			ccb31.setState(false);
			ccb32.setState(false);
			ctf1.setText("");
			ctf2.setText("");
			ctf3.setText("");
			ctf4.setText("");
			ctf5.setText("");
			ctf11.setText("");
			ctf12.setText("");
			ctf13.setText("");
			ctf21.setText("");
			ctf22.setText("");
			ctf31.setText("");
			ctf32.setText("");

			System.out.println("crest");
		}
		
		if(action.equals("coderest")){
			//èâä˙âªèàóù
			codetf.setText("");
			System.out.println("coderest");
		}
		
		if(action.equals("srest")){
			stf.setText("");
			System.out.println("srest");
		}
	}
	
	public void Menu_Bt_Clear(){
		mbt1.setBackground(Color.gray);
		mbt1.setForeground(Color.black);
		mp1.setVisible(false);
		mbt2.setBackground(Color.gray);
		mbt2.setForeground(Color.black);
		mp2.setVisible(false);
		mbt3.setBackground(Color.gray);
		mbt3.setForeground(Color.black);
		mp3.setVisible(false);
		mbt4.setBackground(Color.gray);
		mbt4.setForeground(Color.black);
		mp4.setVisible(false);
	}
	
	public void itemStateChanged(ItemEvent e){
		Object object = e.getSource();
		if(object == tfazzy){
			System.out.println("tfazzy");
		}else if(object == tfit){
			System.out.println("tfit");
		}
		
		if(object == cfazzy){
			System.out.println("cfazzy");
		}else if(object == cfit){
			System.out.println("cfit");
		}
		
		if(object == ccb1){
			if(ccb1.getState()){
				mp22.setVisible(true);
			}else{
				mp22.setVisible(false);
			}
		}
		if(object == ccb2){
			if(ccb2.getState()){
				mp23.setVisible(true);
			}else{
				mp23.setVisible(false);
			}
		}
		if(object == ccb3){
			if(ccb3.getState()){
				mp24.setVisible(true);
			}else{
				mp24.setVisible(false);
			}
		}
		if(object == ccb4){
		}
		if(object == ccb5){
		}
		if(object == ccb11){
		}
		if(object == ccb12){
		}
		if(object == ccb13){
		}
		if(object == ccb21){
		}
		if(object == ccb22){
		}
		if(object == ccb31){
		}
		if(object == ccb32){
		}
	}
	
	public String getSourceSt(){
		String source = "ê≥éÆñº                             ó™åÍ\n" +
						"Bovine Thyroglobulin               TyB\n" +
						"Bromelain                          Br\n" +
						"Erythropoietin                     Epo\n" +
						"Fetuin                             Fet\n" +
						"Human urinary kallidinogenase      HUK\n" +
						"Immunoglobulin G = IgG             Ig\n" +
						"Integrin                           Int\n" +
						"Insect IgG                         Ig-i\n" +
						"Mouse IgG                          Ig-m\n" +
						"Pigeon Egg White                   PEW\n" +
						"Porcine pancreatic kallidinogenase PPK\n" +
						"Neuropsin                          Neu\n" +
						"Saposin                            Sa\n" +
						"Serum                              Se\n" +
						"soluble FcÉ¡-receptor II           sFII\n" +
						"soluble FcÉ¡-receptor III          sFIII\n" +
						"Squid Rhodopsion                   Rho\n" +
						"Synthesis                          Syn\n" +
						"Transferrin                        Tra\n" +
						"Duck Ovomucoid                     OVo-D\n" +
						"Chikin Ovomucoid                   OVo-C\n" +
						"Acetylcholine receptor             Acr\n" +
						"alpha1 acid glycoprotein           Alp\n" +
						"Ovalbumin(Chikin)                  Ova-C ( default )\n" +
						"Ovalbumin(Quail)                   Ova-Q\n" +
						"Ovalbumin(Duck)                    Ova-D\n" +
						"Whale Thyroglobulin                ThyW\n" +
						"Pig Thyroglobulin                  ThyP\n" +
						"Berunuda grass                     Bg\n" +
						"Amylcse                            Amy\n" +
						"Peanut lectin receptor             Plr\n" +
						"Sycamore Cell                      Syc\n" +
						"Miraculin                          Mir\n" +
						"Laccase                            Lac\n" +
						"Mouse Fibrinogen                   Fi-m\n" +
						"Locust lipophorin                  Loc";
		return source;
	}
}

class CodeCanvas extends Canvas{
	Image CI;
	public CodeCanvas(Image img){
		CI = img;
	}
	
	public void paint(Graphics g){
		g.drawImage(CI,0,0,400,170,this);
	}
}
