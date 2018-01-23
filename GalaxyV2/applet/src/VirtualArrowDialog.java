import java.awt.*;
import java.awt.event.*;

public class VirtualArrowDialog extends Dialog implements ActionListener{
	private final int ENTER_KEY_CODE = 10;
	private final int ESCAPE_KEY_CODE = 27;

	Button yes;
	Button no;
	int drawArrowCounter;
	Label message, message2;
	VirtualArrowDialog(Frame f, String head, boolean access){
		super(f, head, access);
		setLayout(null);
		setSize(470,160);
		yes = new Button("Yes");
		yes.setBounds(100, 100, 60, 20);
		add(yes);
		yes.addActionListener(this);
		yes.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(ENTER_KEY_CODE == e.getKeyCode()){
					drawArrowCounter ++;
					setVisible(false);
				}else if(ESCAPE_KEY_CODE == e.getKeyCode()){
					drawArrowCounter = 0;
					setVisible(false);
				}
			}
		});
		no = new Button("No");
		no.setBounds(250, 100, 60, 20);
		add(no);
		no.addActionListener(this);
		drawArrowCounter = 0;
		message = new Label("This Oligosaccharide is digestable but the digestion product has not been identified.");
		message.setForeground(Color.red);
		message.setBounds(20,40, 500, 20);
		message2 = new Label("Would you display deduced product?");
		message2.setForeground(Color.red);
		message2.setBounds(20,65, 300, 20);
		add(message);
		add(message2);

		//Window close
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		 	    Window w = e.getWindow();
		 	    drawArrowCounter = 0;
		 		w.dispose();
		    }
	    });
		setLocation(200,200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent action){
		if(action.getSource() == no){
			drawArrowCounter = 0;
			setVisible(false);
		}
		if(action.getSource() == yes){
			drawArrowCounter ++;
			setVisible(false);
		}
	}
}
