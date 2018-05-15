package affichage;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

import objet.Paysage;
import objet.Player;
import objet.Text;
import objet.Tuyau;

public class Fenetre extends Canvas implements Runnable {
	private int w;
	private int h;
	private Image img;
	private Image temp;
	private boolean running = true;
	private boolean reset = false;

	private Handler handler;
	private Player player;

	public static int width = 400;
	public static int height = width * 12 / 9;

	public Fenetre() {
		
		init();
		new Thread(this).start();
	}

	public void init() {
		handler = new Handler();
		handler.addObject(new Paysage(0, 0, this.getWidth() * 4, this.getHeight(), 0));
		handler.addObject(new Player(30, 60, 25, 20, 1));
		handler.addObject(new Tuyau(140, 50, 30, 290, 2));
		handler.addObject(new Tuyau(280, 50, 30, 290, 2));
		handler.addObject(new Text((width/2)-30, 20, 300, 200, 3));

	}

	public void run() {
		long timeBefore = System.currentTimeMillis();
		double ups = 60.0;
		double ns = 1000 / ups;
		double delta = 0.0;
		while (running) {
			long timeNow = System.currentTimeMillis();
			delta += (timeNow - timeBefore) / ns;
			timeBefore = timeNow;
			while (delta >= 1) {
				update();
				delta--;
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.setColor(0x000000);

		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		//////////////////////////
		/////////// DESSIN //////
		////////////////////////

		handler.render(g);

	}
	
	

	protected void keyPressed(int keyCode) {
		if (!handler.IsUpdate()) {
			handler.setUpdate(true);
		} else {
			for (int i = 0; i < handler.objects.size(); i++) {
				if (((GameObject) handler.objects.elementAt(i)).getId() == 1) {
					player = (Player) handler.objects.elementAt(i);
					if (!player.isOver()) {
						if (!player.isJumping()) {
							player.setJumping(true);
							player.setvelY(-2.7f);
						} else {
							player.setvelY(player.getvelY() - 0.5f);
						}
					}
				}
			}
		}
	}

	protected void keyReleased(int keyCode) {
		for (int i = 0; i < handler.objects.size(); i++) {
			if (((GameObject) handler.objects.elementAt(i)).getId() == 1) {
				player = (Player) handler.objects.elementAt(i);
				player.setJumping(false);
			}
		}
	}

	public void update() {
		handler.update();
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	

}
