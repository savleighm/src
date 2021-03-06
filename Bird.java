import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {

	private static final double E = 2.71828;

	// / imgs: default storage for the pictures of the bird
	private BufferedImage[] imgs;

	// TODO: add your own fields here
	private int iValue;
	private double xPosition = 100.3;
	private double yPosition = 204.1;
	private double yVelocity = 0;
	private double xVelocity = 0;
	// private double xAccel = 0;
	private double yAccel = 0.2;

	private double xAccel = 0.12;
	private Rectangle birdHead;
	private Rectangle birdBody;

	/**
	 * Creates a bird object with the given image set
	 * 
	 * @param basename
	 *            should be "birdg" or "birdr" (assuming you use the provided
	 *            images)
	 */
	public Bird(String basename) {
		// You may change this method if you wish, including adding
		// parameters if you want; however, the existing image code works as is.
		this.imgs = new BufferedImage[6];
		try {
			// 0-2: right-facing (folded, back, and forward wings)
			this.imgs[0] = ImageIO.read(new File(basename + ".png"));
			this.imgs[1] = ImageIO.read(new File(basename + "f.png"));
			this.imgs[2] = ImageIO.read(new File(basename + "b.png"));
			// 3-5: left-facing (folded, back, and forward wings)
			this.imgs[3] = Bird.makeFlipped(this.imgs[0]);
			this.imgs[4] = Bird.makeFlipped(this.imgs[1]);
			this.imgs[5] = Bird.makeFlipped(this.imgs[2]);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * A helper method for flipping in image left-to-right into a mirror image.
	 * There is no reason to change this method.
	 * 
	 * @param original
	 *            The image to flip
	 * @return A left-right mirrored copy of the original image
	 */
	private static BufferedImage makeFlipped(BufferedImage original) {
		AffineTransform af = AffineTransform.getScaleInstance(-1, 1);
		af.translate(-original.getWidth(), 0);
		BufferedImage ans = new BufferedImage(original.getWidth(),
				original.getHeight(), original.getType());
		Graphics2D g = (Graphics2D) ans.getGraphics();
		g.drawImage(original, af, null);
		return ans;
	}

	/**
	 * Draws this bird
	 * 
	 * @param g
	 *            the paintbrush to use for the drawing
	 */
	public void draw(Graphics g) {

		// TODO: fix i value
		int i = this.iValue; // between 0 and 6, depending on facing and wing
								// state
		double x = this.xPosition;// where to center the picture
		double y = this.yPosition;

		g.drawImage(this.imgs[i], (int) x - this.imgs[i].getWidth() / 2,
				(int) y - this.imgs[i].getHeight() / 2, null);
	}

	public void tick(Rectangle obstacle, Bird other) {
		this.bounds();
		this.yVelocity = this.yVelocity + this.yAccel;

		this.xPosition = this.xVelocity + this.xPosition;
		this.yPosition = this.yVelocity + this.yPosition;

		// creates the bottom line
		if (this.yPosition > 580) {
			this.yPosition = 578;
			this.yVelocity = -(this.yVelocity) / 1.25;
		}
		// creates the top boundary
		if (this.yPosition < 20) {
			this.yPosition = 22;
			this.yVelocity = -(this.yVelocity - this.yAccel) / 1.25;
		}

		// creates right boundaries
		if (this.xPosition >= 780) {
			this.xPosition = 778;
			this.xVelocity = -(this.xVelocity) / 1.25;
		}
		// creates left boundary
		if (this.xPosition <= 20 && !(this.xVelocity == 4)) {
			this.xPosition = 22;
			this.xVelocity = -(this.xVelocity) / 1.25;
		}

		this.xVelocity = this.xVelocity - (this.xVelocity / (10));
		this.xVelocity = this.xVelocity - (this.xVelocity / (10));
		// touchesOtherBird(this, other);
	}

	public void bounds() {
		double x = this.getxPosition();
		double y = this.getyPosition();
		this.birdBody = new Rectangle((int) x - 30, (int) y - 15, 60, 50);
		this.birdHead = new Rectangle((int) x - 30, (int) y - 30, 60, 15);

	}
	
	public Rectangle touches (Bird other) {
		if(this.birdBody.intersects(other.birdBody)) {
			Rectangle intersection = new Rectangle (birdBody.intersection(other.birdBody));
			return intersection;
			
		}
		if(this.birdHead.intersects(other.birdBody)) {
			Rectangle intersection = new Rectangle (birdHead.intersection(other.birdBody));
			return intersection;
			
		}	
		if(this.birdBody.intersects(other.birdHead)) {
			Rectangle intersection = new Rectangle (birdBody.intersection(other.birdHead));
			return intersection;
			
		}if(this.birdHead.intersects(other.birdHead)) {
			Rectangle intersection = new Rectangle (birdHead.intersection(other.birdHead));
			return intersection;
			
		}
		return new Rectangle (0,0,0,0);
	}

	// getters and setters for i value, x and y velocities, and x and y
	// positions

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyAccel() {
		return yAccel;
	}

	public void setyAccel(double yAccel) {
		this.yAccel = yAccel;
	}

	public Rectangle getBirdHead() {
		return birdHead;
	}

	public void setBirdHead(Rectangle birdHead) {
		this.birdHead = birdHead;
	}

	public Rectangle getBirdBody() {
		return birdBody;
	}

	public void setBirdBody(Rectangle birdBody) {
		this.birdBody = birdBody;
	}

}
