package objet;


import java.util.Random;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import affichage.GameObject;

public class Tuyau extends GameObject{
	
	private int h;
	
	private Image img;
	private Image img2;
	private int y2 = -400;
	private boolean point = false;
	private float xinit;
	

	public Tuyau(float x, float y, int width, int height, int id) {
		super(x, y, width, height, id);
		xinit = x;
		velX = 1.36f;
		init();
		reset2();
	}


	public void update(Vector objects) {
		if(x <= -30){
			x = 240;
			reset2();
			point = false;
		}
		x -= velX;
		//getBounds();
		if(!point)
		point(objects);
	}


	public void render(Graphics g) {

			g.drawImage(img, (int) x, (int) y, g.BOTTOM|g.LEFT);
			g.drawImage(img2, (int) x, (int) y+60, g.TOP|g.LEFT);
			
	}


	public Rectangle getBounds() {
		Rectangle box = new Rectangle((int) x, (int) y-this.height, this.width, this.height);
		return box;
	}
	
	public Rectangle getBounds2() {
		Rectangle box = new Rectangle((int) x, (int) y + 60, this.width, this.height);
		return box;
	}
	
	public void init(){
		try {
				img2 = Image.createImage("/tuyau.png");
				img = Image.createImage("/tuyau2.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	
	public void point(Vector objects){
		if(x <= 35){
			for(int i = 0; i<objects.size(); i++){
				if(((GameObject) objects.elementAt(i)).getId() == 3){
				((Text) objects.elementAt(i)).win();
				point = true;
				}
			}
		}
	}
	
	public void reset2(){
		Random r = new Random();
		int nb = (int) (r.nextFloat()*180+40);
		y = nb;
		point = false;
	}


	public void reset() {
		x = xinit;
		reset2();
		
	}
	
	
	
}