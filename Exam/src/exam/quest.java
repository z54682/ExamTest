package exam;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class quest implements ClipboardOwner{
	private JTextArea textArea;
	private JRadioButton RadioButton_1, RadioButton_2, RadioButton_3, RadioButton_4;
	private int answer = 0;
	private String quest;
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	public void setRadioButto(JRadioButton rb1, JRadioButton rb2, JRadioButton rb3, JRadioButton rb4) {
		this.RadioButton_1 = rb1;
		this.RadioButton_2 = rb2;
		this.RadioButton_3 = rb3;
		this.RadioButton_4 = rb4;
	}
	
	public void setQuest(String str, String quest) {
		String Ans = str.substring(0, 3);
		String Quest = str.substring(3);
		this.quest = quest;
		switch(Ans) {
		case "(A)":
			answer = 1;
			break;
		case "(B)":
			answer = 2;
			break;
		case "(C)":
			answer = 3;
			break;
		case "(D)":
			answer = 4;
			break;
		}
		
		int a, b, c, d;
		a = Quest.indexOf("(A)");
		b = Quest.indexOf("(B)");
		c = Quest.indexOf("(C)");
		d = Quest.indexOf("(D)");
		
		if(answer == 0 || a == -1 || b == -1 || c == -1 || d == -1) {	//不符合規則的題目記錄
			try {
				File file = new File("errorLog.txt");
				file.delete();
				file.createNewFile();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file), "utf-8"));
				writer.write(str);
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.textArea.setText(Quest.substring(0, a));
		this.RadioButton_1.setText(Quest.substring(a + 3, b));
		this.RadioButton_2.setText(Quest.substring(b + 3, c));
		this.RadioButton_3.setText(Quest.substring(c + 3, d));
		this.RadioButton_4.setText(Quest.substring(d + 3));
	}
	
	public boolean checkAnswer()
	{
		if((this.RadioButton_1.isSelected() && answer == 1) ||
				(this.RadioButton_2.isSelected() && answer == 2) ||
				(this.RadioButton_3.isSelected() && answer == 3) ||
				(this.RadioButton_4.isSelected() && answer == 4))
		{
			switch(answer) {
			case 1: RadioButton_1.setText(RadioButton_1.getText() + "V"); break;
			case 2: RadioButton_2.setText(RadioButton_2.getText() + "V"); break;
			case 3: RadioButton_3.setText(RadioButton_3.getText() + "V"); break;
			case 4: RadioButton_4.setText(RadioButton_4.getText() + "V"); break;
			}
			return true;
		}

		switch(answer) {
		case 1: RadioButton_1.setForeground(Color.red); break;
		case 2: RadioButton_2.setForeground(Color.red); break;
		case 3: RadioButton_3.setForeground(Color.red); break;
		case 4: RadioButton_4.setForeground(Color.red); break;
		}
		return false;
	}
	
	public void copyQuest()
	{
		StringSelection contents = new StringSelection(quest);
        clipboard.setContents(contents, this);
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
}
