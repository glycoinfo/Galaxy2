import java.awt.event.*;
import java.awt.*;

public class EnzimeSwitchSetUp implements ItemListener{

	Choice enzime;
	int enzimeSwitch = 0;
	EnzimeSwitchSetUp(Choice c){
		enzime = c;
	}

	public void itemStateChanged(ItemEvent item){
		//ENZIME SWITCH SETTING
		enzimeSwitch = -1;
		System.out.println("ENZIME SWITCH CHANGED IN TEST");
		if(enzime.getSelectedItem().equals("\u03b1-Galactosidase")){
			enzimeSwitch = 0;
		}else if(enzime.getSelectedItem().equals("\u03b1-Fucsidase")){
			enzimeSwitch = 1;
		}else if(enzime.getSelectedItem().equals("\u03b2-Galactosidase")){
			enzimeSwitch = 2;
		}else if(enzime.getSelectedItem().equals("\u03b2-HexNAcase")){
			enzimeSwitch = 3;
		}else if(enzime.getSelectedItem().equals("\u03b2-Xylosidase")){
			enzimeSwitch = 4;
		}else if(enzime.getSelectedItem().equals("\u03b1-Sialidase")){
			enzimeSwitch = 5;
		}else if(enzime.getSelectedItem().equals("ALL")){
			enzimeSwitch = 6;
		}

	}
}

