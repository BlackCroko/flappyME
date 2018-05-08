package objet;

public class Rectangle {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean intersects(Rectangle other) {
		if(this.x >= other.getX()+other.getWidth())
			return false;
		if(this.x+this.width <= other.getX())
			return false;
		if(this.y + this.height <= other.getY())
			return false;
		if(this.y >= other.getY() + other.getHeight())
			return false;
		
		return true;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	

}
