// ��������� ��� ������, ���� ����������!
// package game1;

// ����������� ����������� ���������
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// ����� ������, ������� �������� ������� �����
class pole extends JPanel
{
       // ������ ��� ����������� �������� ����
       public Timer timerDraw;
	  	  
	   // ����������� ������ 
	   public pole()
	   {		   
		   // �������� �������, ������� ����� �������������� ������� ���� 20 ��� � ������� 	   
		   timerDraw = new Timer(50,new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
		           repaint(); // ������ ������ ����������� ���� (public void paintComponent(Graphics gr))
				}
			});		    
		   timerDraw.start(); // ������ ������� ��� �����������
		    			    		    		    		    		    
	   }
	   	   
	   // �����, ������� ������������ ����������� ������� �� ������
	   public void paintComponent(Graphics gr)
	   {
		   // ��������� ��������� ������� ������ ����
		   // (������ ��������)
		   super.paintComponent(gr);

	   }	   
}