package objet;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

import com.sun.perseus.j2d.RGB;

import affichage.GameObject;

public class Text extends GameObject{
	
	private String T = "Score : ";
	private String T2 = "Best Score : ";
	private String TF = "GAME OVER !";
	private String TF2 = "PRESS ENTER TO TRY AGAIN";
	private int s = 0;
	private int bs = 0;
	private Font f;
	public boolean fin= false;


	public Text(float x, float y, int width, int height, int id) {
		super(x, y, width, height, id);
		//Lecture();
		//System.out.println(bs);
	}


	public void update(Vector objects) {
		if(fin){
			if(s > bs){
				Ecriture();
				bs = s;
			}
		}
			
		
	}


	public void render(Graphics g) {
		g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE));
		if(fin){
			g.setColor(0x000000);
			g.fillRect(30, 54, 180, 183);
			g.setColor(0xffffff);
			g.drawString(TF, (int) x-80, (int) y+100, g.TOP|g.LEFT); 
			g.drawString(T+s, (int) x-80, (int) y+140, g.TOP|g.LEFT);
			g.drawString(T2+bs, (int) x-80, (int) y+160, g.TOP|g.LEFT);
			g.drawString(TF2, (int) x-140, (int) y+1800, g.TOP|g.LEFT); 
		}
		else {
			g.setColor(0xffffff);
			g.drawString(T+s, (int) 102, (int) 11, g.TOP|g.LEFT);
		}
	}

	public Rectangle getBounds() {
		return null;
	}
	public void win(){
		s++;
	}
	
	public int getScore(){
		return s;
	}
	public void setfin(boolean fin){
		this.fin = fin;
	}
	
	
	public void Lecture(){
		String fichier ="score.fic";

		
		//lecture du fichier texte	
		
	}
	
	public void Ecriture(){
		String fichier ="score.fic";
		//création ou ajout dans le fichier texte

	}


	public void reset() {
		// TODO Auto-generated method stub
		s = 0;
		fin = false;
	}

}
