// ��������� ��� ������, ���� ����������!
// package game1;


// ����������� ����������� ���������
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ����� ����, � ������� ��������� ������� ����
class okno extends JFrame
{	
    private pole gameP; // �������� ���������� ������ - ������� ����
    
    // ���������� ������� ������� �� �������
	private class myKey implements KeyListener  
	{
		    // �����, ������� ����������� ��� �������
	   	    public void keyPressed(KeyEvent e)
	   	    {
	   	    	// ��������� ���� ������� �������
	   	    	int key_ = e.getKeyCode();
	   	    		   	    	
	   	    }
	   	    public void keyReleased(KeyEvent e) {}
	   	    public void keyTyped(KeyEvent e) {}
	   }            	
	
    // ����������� ������
    public okno()
    {
    	// ����������� ����������� ������� ��� ���������� � ����
 	    addKeyListener(new myKey());
 	    // ��������� ���������� ����
    	setFocusable(true);
    	
    	// ������� �������� � ��������� ����
        setBounds(0,0,800,600);
        // ������� ��������� ����
        setTitle("����: ���������� �����");
        // ������ ��������� �������� ����
        setResizable(false);
        
        // �������� ������� - �������� ����
        gameP = new pole();
        // ������������ (��������) ������ - �������� ���� � ����
        Container con = getContentPane();
        con.add(gameP);

        // ���������� ������ ���������� ��� ��������� ����
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ������� ���� ������� 
    	setVisible(true);
    }
}

