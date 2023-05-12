package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomeController;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel pnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		pnHome = new JPanel();
		pnHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnHome);
		pnHome.setLayout(null);
		
//		************************************************
//		xu ly su kien
		ActionListener lis= new HomeController(this);
		
		JButton btnOrder = new JButton("ORDER");
		btnOrder.addActionListener(lis);
		btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnOrder.setBounds(283, 258, 151, 57);
		pnHome.add(btnOrder);
		
		JButton btnManagement = new JButton("MANAGEMENT");
		btnManagement.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnManagement.setBounds(546, 258, 151, 57);
		pnHome.add(btnManagement);
	}
	
	public void openOrder() {
		Order order= new Order();
		order.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		order.setVisible(true);
	}

}
