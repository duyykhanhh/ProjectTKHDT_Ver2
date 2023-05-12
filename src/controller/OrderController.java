package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.Order;

public class OrderController implements ActionListener{
	private Order orderView;
	
	public OrderController(Order orderView) {
		super();
		this.orderView = orderView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String beverage;
		ArrayList<String> toppings= new ArrayList<>();
		beverage=e.getActionCommand();
		
	}

}
