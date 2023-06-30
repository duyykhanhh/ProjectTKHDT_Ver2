package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import view.Bartender;

public class BartenderController implements ActionListener, MouseListener{
	private Bartender ba;
	private javax.swing.Timer timer;
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
//		if(e.getSource() == ba.getBtnAlarm()) {
//			timer = new javax.swing.Timer(490, new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					ba.alarming();
//
//				}
//			});
//			timer.start();
//		}
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			timer.stop();
//		}
	}
	


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource() == ba.getBtnAlarm()) {
//			timer.stop();
//		}
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
			  ba.alarming();
		}
		
		if(e.getSource() == ba.getBtnFinished()) {
			ba.finishOrder();
		}
	}
	
}
