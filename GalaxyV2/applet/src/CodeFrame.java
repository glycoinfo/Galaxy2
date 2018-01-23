import java.awt.*;
import java.awt.event.*;

public class CodeFrame extends Dialog implements ActionListener{
	private final int ENTER_KEY_CODE = 10;
	private final String LABEL_TEXT = "Please Enter Code No.";
	String[] codeBase;
	TextField codeText;
	Button submit;
	Label setInfo;
	String textString;
	int codeNumber = -1;
	int loop = 0;
	CodeFrame(Frame f, String header, boolean isModal, String Code[], int loopCounter, String codeHistory){
		super(f, header, isModal);
		codeBase = Code;
		loop = loopCounter;
		setLayout(null);
		setSize(200,200);
		setResizable(false);
		setLocation(200,200);
		//テキストフィールド
		codeText = new TextField();
		codeText.setBounds(60, 70, 80, 25);
		add(codeText);
		codeText.setText(codeHistory);
		codeText.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == ENTER_KEY_CODE){
					textString = codeText.getText();
					if(textString.equals("")){
						codeNumber = -1;
					}else{
						for(int loop1 = 0; loop1 < loop; loop1++ ){
							if(textString.equalsIgnoreCase(codeBase[loop1])){
								codeNumber = loop1;
								System.out.println("CODE NUMBER IN NEW CLASS  " + codeNumber);
							}
						}
					}
					setVisible(false);
				}
			}
		});

		setInfo = new Label();
		setInfo.setText(LABEL_TEXT);
		setInfo.setForeground(Color.red);
		setInfo.setBounds(40, 40, 130, 20);
		add(setInfo);


		//ボタン
		submit = new Button("Submit");
		submit.setBounds(60, 120, 60, 20);
		add(submit);
		submit.addActionListener(this);
		submit.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == ENTER_KEY_CODE){
					textString = codeText.getText();
					if(textString.equals("")){
						codeNumber = -1;
					}else{
						for(int loop1 = 0; loop1 < loop; loop1++ ){
							if(textString.equalsIgnoreCase(codeBase[loop1])){
								codeNumber = loop1;
								System.out.println("CODE NUMBER IN NEW CLASS  " + codeNumber);
							}
						}
					}
					setVisible(false);
				}
			}
		});

		//Window close
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        Window w = e.getWindow();
		        w.dispose();
		    }
	    });
		setVisible(true);
	}

	public void actionPerformed(ActionEvent actionevent){
		textString = codeText.getText();
		if(textString.equals("")){
			codeNumber = -1;
		}else{
			for(int loop1 = 0; loop1 < loop; loop1++ ){
				if(textString.equalsIgnoreCase(codeBase[loop1])){
					codeNumber = loop1;
					System.out.println("CODE NUMBER IN NEW CLASS  " + codeNumber);
				}
			}
		}
		setVisible(false);
	}
}