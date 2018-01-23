import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.lang.Math;
import java.util.*;
import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;

public class Myframe extends Dialog implements ActionListener, ItemListener{
	private final int ENTER_KEY_CODE = 10;
	private final int DATAREAD = 567;
	private final String URL_STRING = "../OligoHTML0/";
	CheckboxGroup group;
	double[] a;
	double[] b;
	int[] holdArray;
	String[] Sim;
	String[] Co;
	int returnM = -1;
	int testInt = -1;
	int counter;
	Button submit;
	Button linkButton;
	Label errorLabel;
	Panel panel;
	Checkbox[] c1 = new Checkbox[DATAREAD];
	TDPanel tree;
	int history = 0;
	int common;
	int i = -1;

	String error = "";
	Dimension screenSize;
	GalaxySystem2 Myapplet;
	double height, width;
	Myframe(Frame f, String code, boolean b,int[] frameArray, String[] SimSt, String[] Code, int mouseMem, GalaxySystem2 myApplet){
		super(f,code,b);
		setModal(true);
		this.requestFocus();
		System.out.println("in frame mouseMem    "+mouseMem);
		Myapplet = myApplet;
		setModal(true);
		holdArray = frameArray;
		Sim = SimSt;
		Co = Code;
		setLayout(null);
		panel = new Panel();
		panel.setLayout(null);
		panel.setBounds(200,50,350,350);
		tree = new TDPanel(0,0,350,300);
		panel.add(tree);

		submit = new Button("SUBMIT");
		submit.setBounds(10,50,60,20);
		submit.addActionListener(this);
		add(submit);

		linkButton = new Button("Html Link");
		linkButton.setBounds(80, 50, 60, 20);
		linkButton.addActionListener(this);
		add(linkButton);

		errorLabel = new Label();
		errorLabel.setText(error);
		//errorLabel.setBounds(270, 350, 200, 20);
		errorLabel.setBounds(10,30,200,20);
		add(errorLabel);

		add(panel);
		history = mouseMem;
		setSize(600,400);
		setResizable(false);
		setLocation(250,250);
		counter = 0;
		group = new CheckboxGroup();
		c1[common] = new Checkbox(Code[common], false, group);
		for(common = 0; common < frameArray.length; common++){
			if(frameArray[common] > 0){
				c1[common] = new Checkbox(Code[common], false, group);
				c1[common].addItemListener(this);
				add(c1[common]);
				c1[common].setBounds(50,100+counter*20, 100,10);
				counter ++;
				frameArray[common] = 0;
			}
		}
		setLocation(200,200);
			//Window close
		    this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
	        		Window w = e.getWindow();
		 	    	returnM = i;
					error = "";
					errorLabel.setText(error);
		 		     w.dispose();
		        }
	    	});
	    	submit.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(ENTER_KEY_CODE == e.getKeyCode()){
						error = "";
						errorLabel.setText(error);
						returnM = i;
					}
				setVisible(false);
				}
			});
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent item){
		error = "";
		errorLabel.setText(error);
		Checkbox selected = group.getSelectedCheckbox();
		for(i =0; i < DATAREAD; i++){
			if(c1[i] == selected){
				testInt = i;
				returnM = i;
				submit.requestFocus();
				break;
			}
		}
		if(returnM >= 0){
			tree.SetData(Sim[returnM], Co[returnM]);
		}
	}

	public void actionPerformed(ActionEvent actionevent){
		if(actionevent.getSource() == linkButton){
			System.out.println(i);
			if(i < 0){
				error = "Please select Code";
				Font font = new Font("‚l‚r –¾’©", Font.BOLD, 17);
				errorLabel.setFont(font);
				errorLabel.setForeground(Color.red);
				errorLabel.setText(error);
			}else{
				error = "";
				errorLabel.setText(error);
				try{
				String tryUrl = Co[testInt] + ".html";
				URL url = new URL(Myapplet.getDocumentBase(), URL_STRING + tryUrl);
				// URL link = new URL(URL_STRING + tryUrl);
				Myapplet.getAppletContext().showDocument(url, "glycoanalysis" + testInt);
				}catch(MalformedURLException me){
					System.out.println("MALFUNCTIONEXCEPTION IN MYFRAME");
				}catch(IOException ioe){
					System.out.println("IOEXCEPTION IN MYFRAME");
				}
			}
		}
		if(actionevent.getSource() == submit){
			setVisible(false);
		}
	}

	public void paint(Graphics g){
		if(i == -1){
			g.setColor(Color.red);
		}
	}
}