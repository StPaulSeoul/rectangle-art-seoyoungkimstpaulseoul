import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myClass extends JPanel {
	private static final long serialVersionUID = 1L;
	public static Dimension size;
	
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
		
		//Rectangle2D r = new Rectangle2D.Double(100, 200, 100, 100);
		//fill. screen with rectangles
		int boxesWidth = 25;
		int boxesHeight = 13;
		
		for(int x = 0; x <boxesWidth; x++) {
			for(int y = 0; y < boxesHeight; y++) {
				
				int v = (int)((double)255 / (double)(boxesWidth + boxesHeight) * (x + y));
						
				Color c = new Color(0, v, 225, v); //RGBA - Red Green Blue Alpha, 0~255
				g2.setColor(c);
				
				//instantiate our rectangle
				Rectangle2D r = new Rectangle2D.Double(
						x * size.getWidth()  / boxesWidth,
						y * size.getHeight() / boxesHeight,
						size.getWidth()  / boxesWidth,
						size.getHeight() / boxesHeight
						);
				//Draw our rectangle
				g2.fill(r);
				
			}
		}
	}
		
	public void setupDisplay() {
		JFrame application = new JFrame();
		application.add(this);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();

	}
	
	public static void main(String[] args) {
		myClass program = new myClass();
		program.setupDisplay();
		
	}
}
