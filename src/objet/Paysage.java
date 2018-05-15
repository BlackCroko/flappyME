package objet;


import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import affichage.GameObject;

public class Paysage extends GameObject{
	
	private Image img;
	private float x2;
	private int xinit;
	private int x2init;


	public Paysage(float x, float y, int width, int height, int id) {
		super(0, y, 480*2, 291, id);
		xinit = 0;
		x2init = 480*2;
		velX = 0.3f;
		x2 = 480*2;
		init();
	}


	public void update(Vector objects) {
		
		if((int)(-x) >= 480*2){
			x = 480*2;
		}
		if((int)(-x2) >= 480*2){
			x2 = 480*2;
		}
		x -= velX;
		x2 -= velX;
	}


	public void render(Graphics g) {
		g.drawImage(img,(int) x,(int) 0, g.LEFT | g.TOP);
		g.drawImage(img,(int) x2,(int) y, g.LEFT | g.TOP);
	}


	public Rectangle getBounds() {
		Rectangle box = new Rectangle((int) x, (int) y, width, height);
		return box;
	}
	
	public void init(){
		try {
			img = Image.createImage("/paysage.jpg");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CKC");
		}
		img = createThumbnail(img);
		}
	
	private Image createThumbnail(Image image) {
		int sourceWidth = image.getWidth();
		int sourceHeight = image.getHeight();
		int thumbWidth = 480*2;
		int thumbHeight = 291;


		Image thumb = Image.createImage(thumbWidth, thumbHeight);
		Graphics g = thumb.getGraphics();

		for (int y = 0; y < thumbHeight; y++) {
			for (int x = 0; x < thumbWidth; x++) {
				g.setClip(x, y, 1, 1);
				int dx = x * sourceWidth / thumbWidth;
				int dy = y * sourceHeight / thumbHeight;
				g.drawImage(image, x - dx, y - dy, Graphics.LEFT | Graphics.TOP);
			}
		}

		Image immutableThumb = Image.createImage(thumb);

		return immutableThumb;
	}


	public void reset() {
		x= xinit;
		x2 = x2init;
		velX = 0.3f;
		x2 = 480*2;
	}
	
	}