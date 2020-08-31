import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Stage {
	private BufferedImage Currentimage;
	private BufferedImage Runningimage;
	private BufferedImage Overimage;
   
    public Stage() {
    	try {
			this.Currentimage = ImageIO.read(new File("stage-normal.png"));
			this.Overimage   = ImageIO.read(new File("stage-gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	this.Runningimage = this.Currentimage;
   }

	
	public void setGameOverBackground() {
		this.Runningimage=this.Overimage;
		
	}

	public BufferedImage getCurrentImage() {
		return this.Runningimage;
		
	}

}
