package KillAll;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class JFrame1 {
	private JFrame frame;
	private Canvas canvas;
	
	
	private String title;
	private int width, hight;
	
	public JFrame1(String title, int width, int hight) {
		this.title=title;
		this.width=width;
		this.hight=hight;
		
		CreateJFrame1();	
	}
	
	private void CreateJFrame1() {
		frame = new JFrame(title);
		frame.setSize(width, hight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas =new Canvas();
		canvas.setPreferredSize(new Dimension(width ,hight));
		canvas.setMaximumSize(new Dimension(width ,hight));
		canvas.setMaximumSize(new Dimension(width ,hight));
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas(){
		return canvas;
		
	}
	
}
