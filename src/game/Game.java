package game;


import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import affichage.Fenetre;

public class Game extends MIDlet implements CommandListener {
	
	private Display monDisplay;

	
	
	private Fenetre mc;
	private Command maCommande;
	
	public Game() {
		monDisplay = Display.getDisplay(this);
		
		maCommande = new Command("Recommencer", Command.OK, 0);
		
		mc = new Fenetre();
		mc.addCommand(maCommande);
		
	}
		 
	
	protected void startApp() { 
		mc.setCommandListener(this);
		monDisplay.setCurrent(mc); 
		} 
	
	public void commandAction(Command c, Displayable d) {   
			if(c == maCommande) {
				mc.getHandler().setReset(true);
			}
		}
	
	  protected void pauseApp() { 
	    // TODO Raccord de méthode auto-généré 
	  } 


	  protected void destroyApp(boolean arg0) throws MIDletStateChangeException { 
	    // TODO Raccord de méthode auto-généré 
	  }

}
