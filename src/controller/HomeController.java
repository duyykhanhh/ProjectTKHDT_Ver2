package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import MilkTeaStore.Employee;
import MilkTeaStore.Login;
import view.Home;
import view.Management;

public class HomeController implements ActionListener, MouseListener{
	private Home homeView;
	private Management managementView;

	
	
	public HomeController(Home homeView) {
		super();
		this.homeView = homeView;
//		this.managementView = new Management();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src= e.getActionCommand();
		if(src.equals("ORDER"))
			this.homeView.openOrder();
		if(src.equals("MANAGEMENT"))
			this.homeView.openManagement();
		if(src.equals("Back"))
			this.homeView.backToHome();
//		dang test log in va da thanh cong, hay chinh sua lai mot vai cho de tiep tuc
		if(src.equals("Log in")) {
			String id = this.homeView.getTxtID().getText();
			String pwd = this.homeView.getPassword();
			boolean pass = this.homeView.checkLogin(id, pwd);
			if(pass == true) {
				this.homeView.goToManagement();
				this.homeView.clearLogin();
			}
				
		
			else
		        JOptionPane.showMessageDialog(null, "Wrong inputs, please check.", "Message", JOptionPane.INFORMATION_MESSAGE);	
		}

				
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
		if(e.getSource() == homeView.getBtnOrder())
			homeView.hoverIn(homeView.getBtnOrder());
//			homeView.getBtnOrder().setBackground(new Color(255,153,51));
		if(e.getSource() == homeView.getBtnManagement())
			homeView.hoverIn(homeView.getBtnManagement());
		if(e.getSource() == homeView.getBtnBack())
			homeView.hoverIn(homeView.getBtnBack());
		if(e.getSource() == homeView.getBtnLogin())
			homeView.hoverIn(homeView.getBtnLogin());
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == homeView.getBtnOrder())
			homeView.hoverOut(homeView.getBtnOrder());
//			homeView.getBtnOrder().setBackground(new Color(255, 204, 153));
		if(e.getSource() == homeView.getBtnManagement())
			homeView.hoverOut(homeView.getBtnManagement());
		if(e.getSource() == homeView.getBtnBack())
			homeView.hoverOut(homeView.getBtnBack());
		if(e.getSource() == homeView.getBtnLogin())
			homeView.hoverOut(homeView.getBtnLogin());
		
	}
	
//	public String getUser() {
//		return user;
//	}

}
