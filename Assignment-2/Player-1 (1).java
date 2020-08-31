import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private int x;
	private int y;
	
	private BufferedImage Currentimage;
	private BufferedImage Runningimage;
	private BufferedImage Overimage;
    private char c;
    private boolean b;
	
	private int stepSize;
	
	 public Player(int i, int j) {
	    	try {
				this.Currentimage = ImageIO.read(new File("player-alive.png"));
				this.Overimage   = ImageIO.read(new File("player-dead.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	this.x=i;
	    	this.y=j;
	    	this.stepSize=12;

	    	
	    	this.Runningimage = this.Currentimage;
	   }

	

	public void performAction() {
		if(c == 'L' && b == true) {
			x = x - stepSize;	
		}
		if(c == 'R' && b == true) {
			x = x + stepSize;
		}
		if(c == 'U' && b == true) {
			y = y - stepSize;
		}
		if(c == 'D' && b == true) {
			y = y + stepSize;		
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public BufferedImage getCurrentImage() {
		return this.Runningimage;
	}

	public void die() {
		this.Runningimage=this.Overimage;
		
	}

	public void setKey(char c, boolean b) {
		this.c=c;
		this.b=b;
		
	}
	

}
