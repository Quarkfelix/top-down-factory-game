package io;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import infrastructure.Main;
import lobby.Lobby;

public class MouseHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby.buttonhandler.checkMouseInput(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

}
