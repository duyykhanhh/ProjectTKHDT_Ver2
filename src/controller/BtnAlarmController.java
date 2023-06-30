package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.PayView;

public class BtnAlarmController implements ActionListener, MouseListener{
	private PayView pay;
	
	
	public BtnAlarmController(PayView pay) {
		super();
		this.pay = pay;
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == pay.getBtn1()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn1().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn1().getText());
			pay.backToPay();
		}
			
		if(e.getSource() == pay.getBtn2()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn2().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn2().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn3()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn3().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn3().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn4()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn4().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn4().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn5()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn5().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn5().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn6()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn6().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn6().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn7()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn7().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn7().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn8()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn8().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn8().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn9()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn9().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn9().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn10()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn10().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn10().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn11()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn11().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn11().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn12()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn12().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn12().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn13()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn13().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn13().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn14()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn14().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn14().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn15()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn15().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn15().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn16()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn16().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn16().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn17()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn17().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn17().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn18()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn18().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn18().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn19()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn19().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn19().getText());
			pay.backToPay();

		}
		
		if(e.getSource() == pay.getBtn20()) {
			pay.setAlarmNum(Integer.parseInt(pay.getBtn20().getText()));
			pay.getLblAlarmInfo().setText(pay.getBtn20().getText());
			pay.backToPay();

		}
			
		
		
	}

}
