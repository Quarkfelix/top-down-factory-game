package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import infrastructure.Main;
import infrastructure.Settings;
import io.KeyHandler;
import io.MouseHandler;

public class LobbyGUI {
	private JFrame jf;
	private Draw draw;

// ======================================== CONSTRUCTOR ========================================
	public LobbyGUI() {
		setupJFrame();
	}

// ======================================== METHODS ============================================
	private void setupJFrame() {
		jf = new JFrame();
		draw = new Draw();
		jf.setResizable(false);
		jf.setSize(new Dimension(Settings.loginDim.width, Settings.loginDim.height));
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(draw);
		jf.addMouseListener(new MouseHandler());
		jf.addKeyListener(new KeyHandler());
		jf.setVisible(true);
	}
// ======================================== GET/SET METHODS ====================================

// ======================================== PAINT-METHODS ======================================
}




class Draw extends JPanel implements Runnable {
	private Thread t;
	private Graphics2D g;
	private boolean running = true;
	
	//fps
	private long time1 = 0;
	private long time2 = 0;
	private int fps = 60;
	
// ======================================== CONSTRUCTOR ========================================
	public Draw() {
		t = new Thread(this);
		t.start();
	}
// ======================================== RUN-METHOD =========================================	
	@Override
	public void run() {
		fps = Settings.lobbyFPS;
		while(running) {
			time1 = System.nanoTime();
			super.repaint();
			time2 = System.nanoTime();
			try {
				//time to redraw
				long timediff = time2-time1; 
				//zeit die für ein frame benötigt werden soll - zeit die gebraucht wurde = zeit die gewartet werden muss
				long timetosleep = (1000000000/fps)-timediff; 
				Thread.sleep(timetosleep/1000000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
// ======================================== METHODS ============================================

// ======================================== GET/SET METHODS ====================================

// ======================================== PAINT-METHODS ======================================
	@Override
	public void paint(Graphics graphics) {
		g = (Graphics2D)graphics;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		g.setColor(new Color(48,48,48));
		g.fillRect(0, 0, Settings.loginDim.width, Settings.loginDim.height);
		Main.lobby.paint(g);
	}
}









