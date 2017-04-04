import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myClass extends JPanel {
	
	public myClass() {
		super();
		//New colors - pass RGBA 0~224
		//Color myColor = new Color(255 ,255, 255, 100);
		setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //You don't need to use this~
		g2.setStroke(new BasicStroke(10.0f, //Line width
				BasicStroke.CAP_ROUND, 	// End-Cap style
				BasicStroke.JOIN_ROUND));
		g.setColor(Color.WHITE);
		
		g2.drawLine(0, 0, 1000, 1000);
		g2.drawLine(1000, 0, 0, 1000);
		
		for(int x = 0; x < 2880; x+=25) {	
		g2.drawLine(x, 0, 1680, 1800);
	}
		
	}

	public void setupDisplay() {
		JFrame application = new JFrame();
		application.add(this);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(2880, 1800);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);

	}
	
	public static void main(String[] args) {
		myClass program = new myClass();
		program.setupDisplay();
		
	}
}
