import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	private int x;
	private int y;
	
	//
	private int a;
	private int b; 
	
	private BufferedImage Currentimage;
	private BufferedImage Runningimage;
	private BufferedImage Overimage;
	
	private int stepSize;
	
	private GameManager gm;
	
	
	public Enemy(GameManager gm, int i, int j) {
    	try {
			this.Currentimage = ImageIO.read(new File("enemy-alive.png"));
			this.Overimage   = ImageIO.read(new File("enemy-dead.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	this.x=i;
    	this.y=j;
    	this.stepSize=5;
        this.gm=gm;
    	
    	this.Runningimage = this.Currentimage;
   }


	
	public void performAction() {
		//
		a = gm.getPlayer().getX();
		b = gm.getPlayer().getY();
		
		if(this.x < a && this.y < b) {
			this.x = this.x + stepSize;
			this.y = this.y+ stepSize;
		}
		if(this.x < a && this.y > b) {
			this.x = this.x + stepSize;
			this.y = this.y - stepSize;
		}
		if(this.x > a && this.y > b) {
			this.x = this.x - stepSize;
			this.y = this.y - stepSize;
		}
		if(this.x > a && this.y < b) {
			this.x = this.x - stepSize;
			this.y = this.y + stepSize;
		}
		if(this.x == a && this.y > b) {
			this.y = this.y - stepSize;
		}
		if(this.x == a && this.y < b) {
			this.y = this.y + stepSize;
		}
		if(this.x < a && this.y == b) {
			this.x = this.x + stepSize;
		}
		if(this.x > a && this.y == b) {
			this.x = this.x - stepSize;
		}
		
	}

	public void die() {
		this.Runningimage=this.Overimage;
		
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

}
