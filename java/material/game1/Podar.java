import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ����� ��� ���������� ���������
public class Podar {
	public Image img;
	private int x, y;
	public boolean act;
	private Timer timerUpdate;
	
	// ����� - ����������� ������
	public Podar(Image img) {
		// �������� ������� � ������� ����� ����������� ������� ������� 
		timerUpdate = new Timer(500, new ActionListener() {
			// ����� ��� ������������ ������� � ���������� ��������
			public void actionPerformed(ActionEvent e) {
				vniz(); // �������
			}
		});
		this.img = img; // ���� �� ����������� �������
		act = false; // ����������� ������� ��� ��� �������������
	}
	// ����� ��� ������� �������
	public void start() {
		timerUpdate.start(); // ������ �������
		y = 0; // ������ � �������� ����
		x = (int)(Math.random() * 700); // ������ � ��������� ������� �� x
		act = true; // ��������� �������
	}
	// ����� ���������� �������
	public void vniz() {
		// ��� ��������� ������� �� �������� ������ �� 6 ��������
		if (act) y += 6;
		// ���� ��������� ������� + ��� ������ ��������� ������ �����, 
		// �� ������� ������������
		if (y + img.getHeight(null) > 470) timerUpdate.stop(); 
	}
	// ����� ����������� ��������� �������
	public void draw(Graphics gr) {
		// ���� ������� �������, �� �� �������������� �� ������ �� ��� ������� �����������
		if (act) gr.drawImage(img, x, y, null);
	}
}
