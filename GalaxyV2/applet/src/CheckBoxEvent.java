import java.awt.*;
import java.awt.event.*;

public class CheckBoxEvent implements ItemListener{

	CheckboxGroup grp;
	Choice enz;
	int allAdd = 0;
	Checkbox up;
	Checkbox low;
	Button arrow;
	int upCount = 10;
	int lowCount = 0;
	private EnzimeSwitchSetUp test;
	Panel allPanel;
	EnzimeLabel ep;

	public String arrowButtonString = "Show Product";
	CheckBoxEvent(CheckboxGroup group, Choice choice, Checkbox upperArrow, Checkbox lowerArrow, Button buttonArrow, EnzimeLabel enzPane, Panel p, EnzimeSwitchSetUp enzSetup){
		grp = group;
		enz = choice;
		up = upperArrow;
		low = lowerArrow;
		arrow = buttonArrow;
		ep = enzPane;
		allPanel = p;
		test = enzSetup;
	}
	public void itemStateChanged(ItemEvent item){
		//ALL option is added or removed according to checkbox option/////
		if(grp.getSelectedCheckbox() == up){
			upCount++;
			lowCount = 0;
			ep.EnzimeLabelSet(0);
			arrowButtonString = "Show Product";
			arrow.setLabel(arrowButtonString);
			if(enz.getItemCount() == 6)
				enz.insert("ALL", 7);
		}
		if(grp.getSelectedCheckbox() == low){
			upCount = 0;
			lowCount++;
			ep.EnzimeLabelSet(1);
			arrowButtonString = "Show Precursor";
			arrow.setLabel(arrowButtonString);
			if(enz.getItemCount() > 6){
				if(enz.getSelectedIndex() == 6){
					test.enzimeSwitch = 0;
					System.out.println("111111111111111111111 : " + test.enzimeSwitch);
				}
				enz.remove("ALL");
			}
		}// ALL option ends here
	}
}
