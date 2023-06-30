package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import view.Bartender;

public class BartenderController implements ActionListener, MouseListener{
	private Bartender ba;

	public BartenderController(Bartender ba) {
		super();
		this.ba = ba;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ba.getBtnAlarm())
			ba.hoverIn(ba.getBtnAlarm());
		if(e.getSource() == ba.getBtnFinished())
			ba.hoverIn(ba.getBtnFinished());
		ba.hoverIn((JButton) e.getSource());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ba.getBtnAlarm())
			ba.hoverOut(ba.getBtnAlarm());
		if(e.getSource() == ba.getBtnFinished())
			ba.hoverOut(ba.getBtnFinished());
		ba.hoverOut((JButton) e.getSource());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ba.getBtnAlarm()) {
			
		}
	}
	
}
