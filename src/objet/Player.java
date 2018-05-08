package objet;


import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import affichage.GameObject;

public class Player extends GameObject{
	
	private final int MAX_SPEED = 11;
	private float gravity = 0.13f;
	private boolean falling = true;
	private boolean jumping = false;
	private boolean over = false;
	
	private float anim = 0.0f;
	private float h = 0.0f;
	
	private Rectangle objectBox;
	private Image img;
	
	
	public Player(float x, float y, int width, int height, int id){
		super(x, y, width, height, id);
		init();
	}

	public void update(Vector objects) {
		if(falling || jumping){
			velY += gravity;
			if(velY >= MAX_SPEED)
				velY = MAX_SPEED;
		} 
		y += velY;
		collision(objects);
		
	}
	

	public void render(Graphics g) {

			//g.drawImage(img, (int) x, (int) y, (int) (x+width), (int) (y+height), (598*(int)anim), 0, (598*(int)anim)+598, 402, null);
//			g.setColor(0x000000);
//			g.drawRect((int)x,(int) y, 20, 8);
			g.drawImage(img, (int) x, (int) y, g.VCENTER | g.HCENTER);
//			g.setColor(0x777777);
//			g.drawRect((int)x-width/2, (int)y-height/2, width, height);
	}


	public Rectangle getBounds() {
		Rectangle box = new Rectangle((int)x-width/2, (int)y-height/2, width-3, height-3);
		return box;
	}

	public void collision(Vector objects){
		for(int i = 0; i<objects.size(); i++){
			if(((GameObject) objects.elementAt(i)).getId() == 2){
				objectBox = ((Tuyau) objects.elementAt(i)).getBounds();
				if(getBounds().intersects(objectBox)){
					over = true;
					System.out.println("touch�");
					/*
					for(int j = 0; j<objects.size(); j++){
						if(objects.get(j).getId() == GameObjectId.Text){
							((Text) objects.get(j)).fin = true;
						}
					}*/
				}
				objectBox = ((Tuyau) objects.elementAt(i)).getBounds2();
				if(getBounds().intersects(objectBox)){
					over = true;
					System.out.println("touch�");
					/*for(int j = 0; j<objects.size(); j++){
						if(objects.get(j).getId() == GameObjectId.Text){
							((Text) objects.get(j)).setfin(true);
						}
					}*/
				}
			}
		}
	}
	
	public boolean isOver(){
		return over;
	}
	
	public boolean isJumping(){
		return jumping;
	}
	
	public void setJumping(boolean jumping){
		this.jumping = jumping;
	}
	
	public boolean isFalling(){
		return falling;
	}
	
	public void setFalling(boolean falling){
		this.falling = falling;
	}
	
	public void init(){
		try {
			img = Image.createImage("/piafcarre2.png");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("CKC");
		}
		//img = createThumbnail(img);
		}
	
	private Image createThumbnail(Image image) {
		int sourceWidth = image.getWidth();
		int sourceHeight = image.getHeight();
		int thumbWidth = 25;
		int thumbHeight = 20;


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
	


}
