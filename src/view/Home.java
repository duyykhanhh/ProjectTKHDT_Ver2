package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomeController;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

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
					frame.setSize(1224, 600);
					frame.setLocationRelativeTo(null);
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
		setBounds(100, 100, 1224, 600);
		pnHome = new JPanel();
		pnHome.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnHome);
		pnHome.setLayout(null);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBounds(88, 107, 793, 398);
		pnLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//		pnHome.add(pnLogin);
		pnLogin.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTitle = new JPanel();
		pnLogin.add(pnTitle, BorderLayout.NORTH);
		pnTitle.setLayout(new BorderLayout(0, 0));
		
		pnTitle.add(Box.createVerticalStrut(20),BorderLayout.WEST);
		
		JLabel lblTitle = new JLabel("Management - Login");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblTitle.setBounds(20, 0, 200, 20);
		pnTitle.add(lblTitle, BorderLayout.WEST);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnTitle.add(btnBack, BorderLayout.EAST);
		
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
		Pointer.setCurrentOrder(order);//lấy địa chỉ đối tượng hiện tại bằng hàm set (static)(vì mỗi order là mỗi bảng khascc nhau
		order.setSize(1224, 600);
		order.setLocationRelativeTo(null);
		order.setVisible(true);
	}

}
