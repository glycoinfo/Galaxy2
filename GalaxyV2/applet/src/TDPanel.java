import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TDPanel extends Panel implements ItemListener{
	CheckboxGroup cg;
	Checkbox cb1,cb2,cb3;
	String SimpleStructure;
	TDCanvas td = new TDCanvas();
	Panel control = new Panel();
	Panel tdpane = new Panel();
	Label label;
	int gtype;
	public TDPanel(int a,int b,int c,int d){
		gtype = 0;
		this.setBounds(a,b,c,d);
		setLayout(null);
		cg = new CheckboxGroup();
		
		//setFont(new Font("Serif",Font.ITALIC,10));
		setFont(new Font("Serif",Font.PLAIN,10));
		cb1 = new Checkbox("Type1",cg,true);
		cb2 = new Checkbox("Type2",cg,false);
		cb3 = new Checkbox("Type3",cg,false);
		label = new Label("Graph Type");
		control.add(label);
		control.add(cb1);
		control.add(cb2);
		control.add(cb3);
		control.setBounds(0,0,350,30);
		tdpane.setBounds(0,30,350,265);
		td.PlotSize(350,265);
		control.setBackground(Color.red);
		tdpane.setBackground(new Color(255,255,255));
		tdpane.add(td);
		add(control);
		add(tdpane);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		SimpleStructure = "";
		
	}
	public void SetStructure(String St){
		this.SimpleStructure = St;
		td.SetData(SimpleStructure,"TEST-ST");
		
	}
	public void SetData(String St,String Code){
		td.SetData(St,Code);
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getItemSelectable()==cb1){
			td.GraphType(0);
			gtype = 0;
		}
		else if(e.getItemSelectable()==cb2){
			td.GraphType(1);
			gtype = 1;
		}
		else if(e.getItemSelectable()==cb3){
			td.GraphType(2);
			gtype = 2;
		}
		else{}
	}
	
}