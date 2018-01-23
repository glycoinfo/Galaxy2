import java.awt.event.*;
import java.awt.*;

public class MonoSwitchSet implements ItemListener{

	Choice mono;
	int monoSwitch = 0;
	GalaxySystem2 applet;
	MonoSwitchSet(Choice c, GalaxySystem2 repnt){
		mono = c;
		applet = repnt;
	}

	public void itemStateChanged(ItemEvent item){
		//ENZIME SWITCH SETTING
		if(mono.getSelectedItem().equals("ALL")){
			monoSwitch = 0;
			applet.repaint();
		}else if(mono.getSelectedItem().equals("0")){
			monoSwitch = 1;
			applet.repaint();
		}else if(mono.getSelectedItem().equals("1")){
			monoSwitch = 2;
			applet.repaint();
		}else if(mono.getSelectedItem().equals("2")){
			monoSwitch = 3;
			applet.repaint();
		}else if(mono.getSelectedItem().equals("3")){
			monoSwitch = 4;
			applet.repaint();
		}else if(mono.getSelectedItem().equals("4")){
			monoSwitch = 5;
			applet.repaint();
		}
		System.out.println("MONO SWITCH CHANGED    " + monoSwitch);
	}
}