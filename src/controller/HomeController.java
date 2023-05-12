package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Home;

public class HomeController implements ActionListener{
	private Home homeView;
	
	
	public HomeController(Home homeView) {
		super();
		this.homeView = homeView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src= e.getActionCommand();
		if(src.equals("ORDER"))
			this.homeView.openOrder();
	}

}
