package affichage;


import java.util.Vector;

import javax.microedition.lcdui.Graphics;

import objet.Rectangle;

public abstract class GameObject {
	
	protected float x, y;
	protected float velX, velY;
	protected int width, height;
	protected int id;
	
	public GameObject(float x, float y, int width, int height, int id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
	}
	
	public abstract void update(Vector objects);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX() {
		return x;
	}


	public float getY() {
		return y;
	}
	
	public int getId() {
		return id;
	}
	
	public int getwidth() {
		return width;
	}
	
	public int getheight() {
		return height;
	}


	public void setX(float x) {
		this.x = x;
	}


	public void setY(float y) {
		this.y = y;
	}


	public float getvelX() {
		return velX;
	}


	public float getvelY() {
		return velY;
	}


	public void setvelX(float velX) {
		this.velX = velX;
	}


	public void setvelY(float velY) {
		this.velY = velY;
	}
	public abstract void reset();

}
