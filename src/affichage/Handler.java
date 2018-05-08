package affichage;

import java.util.Vector;

import javax.microedition.lcdui.Graphics;


import game.Game;
import objet.Player;

public class Handler {
	
	public Vector objects;
	
	private GameObject object;

	private boolean update = false;
	private boolean reset = false;
	
	public Handler(){
		objects = new Vector();
	}
	
	public void update(){
		if(update){
			for(int i = 0; i< objects.size(); i++){
				object = (GameObject) objects.elementAt(i);
				object.update(objects);
				if(((GameObject) objects.elementAt(i)).getId() == 1){
					if( ((Player) objects.elementAt(i)).isOver() == true)
						update = false;
				}
					
			}
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i< objects.size(); i++){
			object = (GameObject) objects.elementAt(i);
			object.render(g);
		}
		
	}
	
	public void addObject(GameObject object){
		objects.addElement(object);
	}
	
	public void removeObject(GameObject object){
		objects.removeElement(object);
	}
	
	public boolean IsUpdate(){
		return update;
	}
	
	public void setUpdate(boolean update){
		this.update = update;
	}
	
	public boolean IsReset(){
		return reset;
	}
	
	public void setReset(boolean reset){
		this.reset = reset;
	}
	

}
