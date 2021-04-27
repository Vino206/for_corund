import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.imageio.*;

public class Pole extends JPanel {
	
	private Image shapka;
	private Image fon;
	public int x = 350; // ���������� x �����
	
	// ����������� ������
	public Pole() {
		try {
			fon = ImageIO.read(new File("./fon.png"));
		}
		catch(Exception e) {}
		
		try {
			shapka = ImageIO.read(new File("./shapka.png"));
		}
		catch(Exception e) {}
		
		Timer timerDraw = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				
			}
		});
		timerDraw.start();
		
	}
	
	// ����� ��� ������� ������
	public void paint(Graphics gr) {
		super.paint(gr);
		gr.drawImage(fon, 0, 0, null);
		gr.drawImage(shapka, x, 465, null);
	}

}
