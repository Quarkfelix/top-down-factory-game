package lobby;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import infrastructure.Main;
import libary.Button;
import libary.TextInputField;

public class LobbyButtonHandler {
	private HashMap<String, Button> buttons = new HashMap<>();
	private TextInputField lobbycodeinput;

// ======================================== CONSTRUCTOR ========================================
	public LobbyButtonHandler(HashMap<String, Button> buttons, TextInputField lobbycodeinput) {
		this.buttons = buttons;
		this.lobbycodeinput = lobbycodeinput;
	}

// ======================================== METHODS ============================================
	public void checkMouseInput(MouseEvent e) {
		int x = e.getX();
		int y = e.getY() - 31;
		if (lobbycodeinput.contains(x, y)) {
			System.out.println("tif");
		} else {
			if (buttons.get("connect").contains(x, y)) {
				Main.lobby.connectToGame(Integer.parseInt(lobbycodeinput.getText()));
				lobbycodeinput.setText("");
			}
		}

	}

	public void checkKeyInput(KeyEvent e) {
		if (lobbycodeinput.getText().length() < 5) {
			// nuber
			if (e.getKeyCode() >= 48 && e.getKeyCode() <= 57) {
				lobbycodeinput.setText(e);
			}
			// numpad
			if (e.getKeyCode() >= 96 && e.getKeyCode() <= 105) {
				lobbycodeinput.setText(e);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			lobbycodeinput.setText(e);
		}

	}
// ======================================== GET/SET METHODS ====================================

// ======================================== PAINT-METHODS ======================================

}
