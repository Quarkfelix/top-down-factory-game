package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import infrastructure.Main;
import lobby.Lobby;

public class KeyHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		Lobby.buttonhandler.checkKeyInput(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
