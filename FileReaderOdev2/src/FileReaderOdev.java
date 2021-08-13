import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


import javax.swing.*;

public class FileReaderOdev extends Applet implements ActionListener {
	BufferedReader buff;
	File file2;
	TextArea text;
	String s;

	int x=0;
	public void init() {
		button1 = new Button("Button 1");
		add(button1);
		button1.addActionListener(this);
		text = new TextArea();
		add(text);
		
		
	}
	public void paint(Graphics g){
		super.paint(g);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) 
			file();
	}

	Button button1;
	public void file() {
		{
			JFileChooser chooser = new JFileChooser();
			try {
				int result = chooser.showOpenDialog(this);
				file2 = chooser.getSelectedFile();
				FileReader rd=new FileReader(file2);
				BufferedReader br = new BufferedReader(rd);
				String teixt = " ";
				String line = br.readLine();
				while(line !=null) {
					teixt += line;
					line = br.readLine();
				}
 				
					text.setText(teixt);
					
		rd.close();
			}catch(Exception e) {
				System.out.println(e);
			}
	}
	}
}
