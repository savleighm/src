import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

//test2

public class JoustScreen extends KeyAdapter implements ActionListener {

	/**
	 * A simple method to make the game runnable. You should not modify 
	 * this main method: it should say nothing except "new JoustScreen();"
	 */
	public static void main(String[] args) {
		new JoustScreen();
	}

	
	// DO NOT CHANGE the next four fields (the window and timer)
	private JFrame window;         // the window itself
	private BufferedImage content; // the current game graphics
	private Graphics2D paintbrush; // for drawing things in the window
	private Timer gameTimer;       // for keeping track of time passing
	// DO NOT CHANGE the previous four fields (the window and timer)
	
	
	// TODO: add your own fields here
	private Bird birdRed;
	private Bird birdGreen;
	
	public JoustScreen() {
		// DO NOT CHANGE the window, content, and paintbrush lines below
		this.window = new JFrame("Joust Clone");
		this.content = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		this.paintbrush = (Graphics2D)this.content.getGraphics();
		this.window.setContentPane(new JLabel(new ImageIcon(this.content)));
		this.window.pack();
		this.window.setVisible(true);
		this.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.window.addKeyListener(this);
		// DO NOT CHANGE the window, content, and paintbrush lines above

		// TODO: add anything else you might need (e.g., a couple of Bird objects, some walls)
		birdRed = new Bird ("birdr");
		birdGreen = new Bird ("birdg");
		Rectangle wallOne = new Rectangle (50,100,300,10);
		Rectangle wallTwo = new Rectangle (25,50,150,50);
		
		birdRed.tick();
		birdGreen.tick();
		
		
		// DO NOT CHANGE the next two lines nor add lines after them
		this.gameTimer = new Timer(20, this); // tick at 1000/20 fps
		this.gameTimer.start();               // and start ticking now
		// DO NOT CHANGE the previous two lines nor add lines after them
	}
	

	/**
	 * This method gets called each time a player presses a key.
	 * You can find out what key the pressed by comparing event.getKeyCode() with KeyEvent.VK_...
	 */
	public void keyPressed(KeyEvent event) {
		
		// TODO: handle the keys you want to use to run your game

		if (event.getKeyCode() == KeyEvent.VK_A) { // example
			//birdRed.setXVelocity= 5;
			//birdRed.setYVelocity= ldkfjkd;
			System.out.println("The 'a' key was pressed");
		
		}
		
		if (event.getKeyCode() == KeyEvent.VK_K) { // example
			//birdGreen.setXVelocity= blahkls;
			//birdGreen.setYVelocity= ldkfjkd;
			System.out.println("The 'k' key was pressed");
		
		}

		if (event.getKeyCode() == KeyEvent.VK_S) { // example
			//birdRed.setXVelocity= blahkls;
			//birdRed.setYVelocity= ldkfjkd;
			System.out.println("The 's' key was pressed");
		
		}
		
		if (event.getKeyCode() == KeyEvent.VK_L) { // example
			//birdGreen.setXVelocity= blahkls;
			//birdGreen.setYVelocity= ldkfjkd;
			System.out.println("The 'l' key was pressed");
		}
		
	
	}

	/**
	 * Java will call this every time the gameTimer ticks (50 times a second).
	 * If you want to stop the game, invoke this.gameTimer.stop() in this method.
	 */
	public void actionPerformed(ActionEvent event) {
		// DO NOT CHANGE the next four lines, and add nothing above them
		if (! this.window.isValid()) { // the "close window" button
			this.gameTimer.stop();     // should stop the timer
			return;                    // and stop doing anything else
		}                              
		// DO NOT CHANGE the previous four lines
		
		// TODO: add every-frame logic in here (gravity, momentum, collisions, etc)
		// move the birds
		


//		double x = this.xPosition; 
//		double y = this.yPosition;
//		
//		return new Rectangle((int)x-10, (int)y-10, 20, 20);
//		this.xPosition = Math.random()*w;
//		this.yPosition = Math.random()*h;
//		xVelocity = (Math.random()*4)+ -2;
//		yVelocity = (Math.random()*4)+ -2;;
//		this.xPosition = this.xVelocity + this.xPosition;
//		this.yPosition = this.yVelocity + this.yPosition;
//		Rectangle firstRectangle = this.bounds();
//		Rectangle otherRectangle = other.bounds();
//		if (firstRectangle.intersects(otherRectangle)) {
//			return true;			
//		}
		
		
		
		// move the red bird and the Green bird
		//   - using velocity
		//   - change velocity (before or after moving? how does it change?)
		// check for collisions (does this need to be before moving?)
		//   - resolve them (somehow�)

		
		// DO NOT CHANGE the next line; it must be last in this method
		this.refreshScreen(); // redraws the screen after things move
		// DO NOT CHANGE the above line; it must be last in this method
	}

	/**
	 * Re-draws the screen. You should erase the old image and draw a 
	 * new one, but you should not change anything in this method
	 * (use actionPerformed instead if you need something to change).
	 */
	private void refreshScreen() {
		this.paintbrush.setColor(new Color(150, 210, 255)); // pale blue
		this.paintbrush.fillRect(0, 0, this.content.getWidth(), this.content.getHeight()); // erases the previous frame

		
		// TODO: replace the following example code with code that does 
		// the right thing (i.e., draw the birds, walls, and score)
		
		// example bird drawing; replace with something sensible instead of making a new bird every frame
		//birdRed.draw(this.paintbrush);
		//birdGreen.draw(this.paintbrush);
		new Bird ("birdr").draw(this.paintbrush);
		
		
		// example wall drawing; replace with something sensible instead of making a new wall every frame
		this.paintbrush.setColor(Color.BLACK);
		this.paintbrush.fill(new Rectangle(50,100,300,10));

		// example text drawing, for scores and/or other messages
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		this.paintbrush.setFont(f);
		this.paintbrush.setColor(new Color(127,0,0)); // dark red
		this.paintbrush.drawString("17", 30, 30);
		this.paintbrush.setColor(new Color(0,127,0)); // dark green
		this.paintbrush.drawString("-5", 760, 30);
		String msg = "Unimplemented";
		f = new Font(Font.SANS_SERIF, Font.BOLD, 90);
		Rectangle2D r = f.getStringBounds(msg, this.paintbrush.getFontRenderContext());
		this.paintbrush.setFont(f);
		this.paintbrush.setColor(Color.BLUE);
		this.paintbrush.drawString(msg, 400-(int)r.getWidth()/2, 300);
		
		
		
		// DO NOT CHANGE the next line; it must be last in this method
		this.window.repaint();  // displays the frame to the screen
		// DO NOT CHANGE the above line; it must be last in this method
	}


}
