import javax.swing.*;

public class game {

	public static void main(String[] args) {
		String chose = JOptionPane.showInputDialog(null, "������� ��������� ���� �� 1 �� 3", "���������", 1);
		int hard = Integer.parseInt(chose);
		
		if(hard > 0 && hard < 4) {
			window win = new window(hard);
		}
		else {
			JOptionPane.showMessageDialog(null, "���... ���, ��������, ������ �� 1 �� 3, �����! XD");
		}

	}//main

}//class game
