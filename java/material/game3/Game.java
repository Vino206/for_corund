import javax.swing.*;

public class Game {
	public static void main(String[] args) {
		// ������� ����� ���������
		String rez = JOptionPane.showInputDialog(null, "������� ��������� ���� �� 1 �� 7", "���������", 2);
		int slogn = Integer.parseInt(rez);
		
		// ������� �������� �� ���������, ������� ����� ���������� � ����
		if (slogn > 0 && slogn < 8) new Okno(slogn);
		else JOptionPane.showMessageDialog(null, "�������� ���������");
	}
}
