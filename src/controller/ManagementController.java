package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import MilkTeaStore.Customer;
import MilkTeaStore.Employee;
import MilkTeaStore.Login;
import MilkTeaStore.ManagementModel;
import view.Management;

public class ManagementController implements ActionListener, MouseListener{
	private Management managementView;
	private ManagementModel manage;
	private javax.swing.Timer timer;
	private Login login;

	public ManagementController(Login login) {
		super();
		this.login = login;
	}

	public ManagementController(Management managementView) {
		super();
		this.managementView = managementView;
//		this.manage = new ManagementModel(null, manage, null, null)
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		timer= new javax.swing.Timer(490, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				countPearl=-1;

			}
		});

		timer.start();
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		timer.stop();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == managementView.getBtnAddIngr())
			managementView.hoverIn(managementView.getBtnAddIngr());
		if(e.getSource() == managementView.getBtnOutOf())
			managementView.hoverIn(managementView.getBtnOutOf());
		if(e.getSource() == managementView.getBtnFill())
			managementView.hoverIn(managementView.getBtnFill());
		managementView.hoverIn((JButton) e.getSource());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == managementView.getBtnAddIngr())
			managementView.hoverOut(managementView.getBtnAddIngr());
		if(e.getSource() == managementView.getBtnOutOf())
			managementView.hoverOut(managementView.getBtnOutOf());
		if(e.getSource() == managementView.getBtnFill())
			managementView.hoverOut(managementView.getBtnFill());
		managementView.hoverOut((JButton) e.getSource());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == managementView.getBtnIngr()) {
			managementView.pressedBtnItem(managementView.getBtnIngr());

		}
		if(e.getSource() == managementView.getBtnEm()) {
			managementView.pressedBtnItem(managementView.getBtnEm());
		}
		if(e.getSource() == managementView.getBtnCus()) {
			managementView.pressedBtnItem(managementView.getBtnCus());

		}
		if(e.getSource() == managementView.getBtnRevenueToday()) {
			managementView.pressedBtnItem(managementView.getBtnRevenueToday());
			managementView.getLblReMoney().setText(managementView.totalMoneyOfDay()+ " VND");
			managementView.getLblReToday().setText(managementView.getDateToday()+"");
		}
			
		if(e.getSource() == managementView.getBtnRevenue()) {
			managementView.pressedBtnItem(managementView.getBtnRevenue());
			managementView.getLblReMoneyTotal().setText(managementView.totalMoney()+" VND");
		}
		
//		them ingredient
		if(e.getSource() == managementView.getBtnAddIngr()) {
			String name = managementView.getTxtNameIngredient().getText();
			double amount = Integer.valueOf(managementView.getTxtAmount().getText());
			String unit = managementView.getTxtUnit().getText();
			if(!name.equals("") && !unit.equals("") && !managementView.getTxtAmount().getText().equals("")) {
			
				managementView.getModelIngr().addRow(new Object[]{name, amount, unit, true});
				managementView.getTxtNameIngredient().setText(null);
				managementView.getTxtAmount().setText(null);
				managementView.getTxtUnit().setText(null);
			}
			
			else {
				doNothing();
	
			}
		
			
		}
		
		
//		danh dau het nguyen lieu
		if(e.getSource() == managementView.getBtnOutOf()) {
			int selectedRow = managementView.getTblIngr().getSelectedRow();
			if(selectedRow<0)
				doNothing();
			else {
				managementView.getTblIngr().setValueAt(false, selectedRow, 3);
				managementView.getTblIngr().setValueAt(0, selectedRow, 1);
			}		
		}
		
//		lam day nguyen lieu
		if(e.getSource() == managementView.getBtnFill()) {
			int selectedRow = managementView.getTblIngr().getSelectedRow();
			if(selectedRow<0)
				doNothing();
			else {
				managementView.getTblIngr().setValueAt(true, selectedRow, 3);
				if(managementView.getTblIngr().getValueAt(selectedRow, 2).equals("kg"))
					managementView.getTblIngr().setValueAt(managementView.getMaxKg(), selectedRow, 1);
				if(managementView.getTblIngr().getValueAt(selectedRow, 2).equals("L"))
					managementView.getTblIngr().setValueAt(managementView.getMaxLit(), selectedRow, 1);
				if(managementView.getTblIngr().getValueAt(selectedRow, 2).equals("can"))
					managementView.getTblIngr().setValueAt(managementView.getMaxCan(), selectedRow, 1);
				if(managementView.getTblIngr().getValueAt(selectedRow, 2).equals("fruit"))
					managementView.getTblIngr().setValueAt(managementView.getMaxFruit(), selectedRow, 1);
				
			}
			
		}
		
//		them Employee
		if(e.getSource() == managementView.getBtnAddEm()) {
			String id = managementView.getTxtIdEm().getText();
			String name = managementView.getTxtNameEm().getText();	
			char[] pw = managementView.getTxtPwEm().getPassword();
            String pwString = new String(pw);
          
            if(!id.equals("") && !name.equals("") && !pwString.equals("")) {
            	managementView.getModelEm().addRow(new Object[]{id, name, 1, true});
            	Employee em = new Employee(id, name, 1, true, pwString);
            	managementView.addEm(em);
            	
    			managementView.getTxtIdEm().setText(null);
    			managementView.getTxtNameEm().setText(null);
    			managementView.getTxtPwEm().setText(null);
            }
            	
            else {
            	doNothing();
            }
			
		}
		
//		nghi viec employee
		if(e.getSource() == managementView.getBtnStop()) {
			int selectedRow = managementView.getTblEm().getSelectedRow();
			if(selectedRow<0)
				doNothing();
			else {
				managementView.getTblEm().setValueAt(false, selectedRow, 3);
			}
		}

		
		
//		tang grade employee
		if(e.getSource() == managementView.getBtnUpGradeEm()) {
			int selectedRow = managementView.getTblEm().getSelectedRow();
			if(selectedRow<0)
				doNothing();
			else {
				int grade = (int) managementView.getTblEm().getValueAt(selectedRow, 2);

				grade++;
				if(grade >10)
					grade=1;
				managementView.getTblEm().setValueAt(grade, selectedRow, 2);
			}
	
			
			
		}
		
//		them customer
		if(e.getSource() == managementView.getBtnAddCus()) {
			String id = managementView.getTxtCusId().getText();
			char[] pw = managementView.getTxtCusPwd().getPassword();
            String pwString = new String(pw);
          
            if(!id.equals("") && !pwString.equals("")) {
            	managementView.getModelCus().addRow(new Object[]{id,0});
            	Customer cus = new Customer(id, 0, pwString);
            	managementView.addCus(cus);
            	
    			managementView.getTxtCusId().setText(null);
    			managementView.getTxtCusPwd().setText(null);
            }
            	
            else {
            	doNothing();
            }
			
		}
		
//		print doanh thu today
		if(e.getSource() == managementView.getBtnRevenueTodayPrint()) {
	        JOptionPane.showMessageDialog(null, "Printed", "Message", JOptionPane.INFORMATION_MESSAGE);

		}
		
//		tong tien mot ngay
		if(e.getSource() == managementView.getBtnEndDay()) {
			if(managementView.isNewDate()==true) {
				int result = JOptionPane.showConfirmDialog(null,
	                    "Are you sure that the working day was end?\nThis cannot be undo.",
	                    "Confirm",
	                    JOptionPane.YES_NO_OPTION,
	                    JOptionPane.QUESTION_MESSAGE);
	            if(result == JOptionPane.YES_OPTION)
	            	managementView.endDay();
			}
			else
				JOptionPane.showMessageDialog(null, "You have already end day.", "Message", JOptionPane.INFORMATION_MESSAGE);
				
            System.out.println(managementView.isNewDate());


			
		}
		
//		print doanh thu total
		if(e.getSource() == managementView.getBtnRevenueTotalPrint()) {
	        JOptionPane.showMessageDialog(null, "Printed", "Message", JOptionPane.INFORMATION_MESSAGE);

		}
		
		
	}
	
	public void doNothing() {
		
	}
	


}
