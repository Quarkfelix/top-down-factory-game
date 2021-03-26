package lobby;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

import libary.Button;
import libary.DropDownMenu;
import libary.TextInputField;
import ui.LobbyGUI;

public class Lobby {
	private LobbyGUI gui;
	public static LobbyButtonHandler buttonhandler;
	private HashMap<String, Button> buttons = new HashMap<>();
	private TextInputField lobbycodeinput;
	
// ======================================== CONSTRUCTOR ========================================
	public Lobby() {
		buttonsetup();
		Lobby.buttonhandler = new LobbyButtonHandler(buttons, lobbycodeinput); 
		this.gui = new LobbyGUI();
	}
// ======================================== RUN-METHOD =========================================
	private void buttonsetup() {
		buttons.put("connect" , new Button(70, 250, 150, 40));
		buttons.get("connect").setText("connect");
		buttons.get("connect").setBorderActive(false);
		buttons.get("connect").setTextFontSize(25);
		buttons.get("connect").setColor(new Color(25,25,25));
		buttons.get("connect").setTextColor(new Color(255,42,0));
		
		
		lobbycodeinput = new TextInputField(50, 100, 140, 50);
	}
// ======================================== METHODS ============================================
	//connects to server -> to game with gamenumber
	public void connectToGame(int gamenumber) {
		
	}
// ======================================== GET/SET METHODS ====================================
	
// ======================================== PAINT-METHODS ======================================
	public void paint(Graphics2D g) {
		buttons.forEach((k,v) -> {
			v.paint(g);
		});
		lobbycodeinput.paint(g);
	}
}
