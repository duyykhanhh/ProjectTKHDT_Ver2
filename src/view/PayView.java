package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import MilkTeaStore.Alarm;
import MilkTeaStore.BartenderModel;
import MilkTeaStore.FileRW;
import MilkTeaStore.IPayStrategy;
import MilkTeaStore.Ingredient;
import MilkTeaStore.Observer;
import MilkTeaStore.OrderData;
import MilkTeaStore.OrderModel;
import MilkTeaStore.RevenueToday;
import MilkTeaStore.Voucher;
import controller.BtnAlarmController;
import controller.ManagementController;
import controller.PayController;
import javax.swing.BoxLayout;

public class PayView extends JFrame {
	private JRadioButton cashPayment, cardPayment, onlinePayment;
    private JLabel cashDiscountLabel, cardDiscountLabel, onlineDiscountLabel;
    private String resultRandom; 
    private JButton payButton, backButton;
    private JLabel totalLabel, lblAlarmInfo, lblPreTotalPrice, lblPreAlarmInfo;
    private JTextField discountCodeField;
    private JButton checkCodeButton;
    private JTable drinksTable;
    private JLabel discountLabel;  
    private IPayStrategy ipay ;
    private JPanel pnAlarm, pnAlarmBtns;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,
    btn15,btn16,btn17,btn18,btn19,btn20;
    
	private DefaultTableModel model;
    private JScrollPane sp;
    Object[][] data;
    
    JPanel centerPanel, center1;
    JPanel pnPrice, pnAlarmNum;
    
    private FileRW fileAlarm, fileToday, fileVoucher;
	private List<Alarm> as = new ArrayList<>();
    private JButton createReamote;
    private JPanel panel;
    
    private List<JButton> alarmBtns = new ArrayList<>();
    
    private String drinks="";
    private int rowOfDrink;
    private int alarmNum=0;
    
    List<Voucher> vchs = new ArrayList<>();
    
    

	private static OrderData orderData;
	private static List<Observer> obs= new ArrayList<>();

    

    


	public PayView() {
		orderData = new OrderData();
//		obs = orderData.getObs();
    	this.fileAlarm = new FileRW("src/data/alarm");
		as = this.fileAlarm.readAlarms();
		
		this.fileToday = new FileRW("src/data/revenueToday");
		
		this.fileVoucher = new FileRW("src/data/voucher");
		vchs = this.fileVoucher.readVouchers();

    	setTitle("Payment");
    	
		 data= new Object[][]{

		 		
	 };
	 Class[] columnTypes = {
			 String.class, Double.class, Integer.class
	 };

	String[] column= {
			"Product", "Price Unit", "Qty"
	};


	model= new DefaultTableModel(data, column);
	drinksTable= new JTable(model);
	drinksTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	drinksTable.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
	
	TableColumnModel columnModel = drinksTable.getColumnModel();
	 columnModel.getColumn(0).setPreferredWidth(220); 
     columnModel.getColumn(1).setPreferredWidth(60);  
     columnModel.getColumn(2).setPreferredWidth(40);  
    
     
		sp= new JScrollPane(drinksTable);
//		sp.setBackground(new Color(255, 235, 205));
		sp.setMinimumSize(new Dimension(320, 400));
		sp.setMaximumSize(new Dimension(320, 400));
		sp.setPreferredSize(new Dimension(320, 400));
    	
		
		 cashPayment = new JRadioButton("Cash Payment");
	     cardPayment = new JRadioButton("Card Payment");
	     onlinePayment = new JRadioButton("Online Payment");
	        
	        if (isEmptyTable()) {
	            cashPayment.setEnabled(false);
	            cardPayment.setEnabled(false);
	            onlinePayment.setEnabled(false);

	        }
	        
	        ButtonGroup group = new ButtonGroup();
	        group.add(cashPayment);
	        group.add(cardPayment);
	        group.add(onlinePayment);
	        
	        payButton = new JButton("Pay");

	        payButton.setBackground(new Color(255, 153, 51));
	        payButton.setPreferredSize(new Dimension(80, 30));

	        totalLabel = new JLabel();
	        lblPreTotalPrice = new JLabel("Total: ");


	        payButton.addActionListener(new PayController(this));

	        backButton = new JButton("BACK");
	        backButton.setBackground(new Color(255, 153, 51));
	        backButton.addActionListener(new ActionListener() {
				
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose();
	            }
	        });
	        createReamote = new JButton("Create remote");
	        createReamote.setBackground(new Color(255, 153, 51));
	        createReamote.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
//	                panelButton.init();
//	                pnAlarm.setVisible(true);
	            	pressedCreateAlarm();

	            }
	        });
	        
	        getContentPane().setLayout(new BorderLayout());
	        JPanel topPanel = new JPanel(new BorderLayout());
	        topPanel.add(backButton, BorderLayout.WEST);
	        getContentPane().add(topPanel, BorderLayout.NORTH);
	        topPanel.setBackground(new Color(255, 235, 205));
	        JPanel paymentPanel = new JPanel(new GridLayout(6, 1));
	        
	        cashDiscountLabel = new JLabel();
	        cardDiscountLabel = new JLabel();
	        onlineDiscountLabel = new JLabel();
	        

	        cashDiscountLabel.setVisible(false);
	        cardDiscountLabel.setVisible(false);
	        onlineDiscountLabel.setVisible(false);
	        
	        paymentPanel.add(cashPayment);
	        paymentPanel.add(cashDiscountLabel);
	        paymentPanel.add(cardPayment);
	        paymentPanel.add(cardDiscountLabel);
	        paymentPanel.add(onlinePayment);
	        paymentPanel.add(onlineDiscountLabel);

	        cashPayment.setOpaque(false);
	        cardPayment.setOpaque(false);
	        onlinePayment.setOpaque(false);
	        getContentPane().add(paymentPanel, BorderLayout.WEST);
	        paymentPanel.setBackground(new Color(255, 235, 205));
	        
	        pnPrice = new JPanel();
	        pnPrice.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
	        pnPrice.add(lblPreTotalPrice);
	        pnPrice.add(totalLabel);
	        
	        
//	        JPanel centerPanel = new JPanel(new BorderLayout());
	        centerPanel = new JPanel();
	        centerPanel.setLayout(new CardLayout(0, 0));
	        center1 = new JPanel(new BorderLayout());
	        center1.add(pnPrice, BorderLayout.NORTH);
//	        center1.add(totalLabel, BorderLayout.NORTH);
	        
	        center1.add(sp, BorderLayout.CENTER);
	        centerPanel.add(center1, "Info");
	        
	        pnAlarmNum = new JPanel();
	        
	        lblPreAlarmInfo = new JLabel("Alarm: ");
	        lblAlarmInfo = new JLabel();
	        pnAlarmNum.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
	        pnAlarmNum.add(lblPreAlarmInfo);
	        pnAlarmNum.add(lblAlarmInfo);
	        
	     
	
	        
	        center1.add(pnAlarmNum, BorderLayout.SOUTH);

	        
	        
	        pnAlarm = new JPanel();
	        pnAlarm.setLayout(new BoxLayout(pnAlarm, BoxLayout.Y_AXIS));
	        
	        pnAlarm.add(Box.createVerticalGlue());
	        
	        pnAlarmBtns = new JPanel();
	        pnAlarmBtns.setMinimumSize(new Dimension(400,300));
	        pnAlarmBtns.setMaximumSize(new Dimension(400,300));
	        pnAlarmBtns.setPreferredSize(new Dimension(400,300));
	        pnAlarmBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
	      
	        btn1 = new JButton("1");    
	        btn2 = new JButton("2");       
	        btn3 = new JButton("3");
	        btn4 = new JButton("4");
	        btn5 = new JButton("5");
	        btn6 = new JButton("6");
	        btn7 = new JButton("7");
	        btn8 = new JButton("8");
	        btn9 = new JButton("9");
	        btn10 = new JButton("10");
	        btn11 = new JButton("11");
	        btn12 = new JButton("12");
	        btn13 = new JButton("13");
	        btn14 = new JButton("14");
	        btn15 = new JButton("15");
	        btn16 = new JButton("16");
	        btn17 = new JButton("17");
	        btn18 = new JButton("18");
	        btn19 = new JButton("19");
	        btn20= new JButton("20");
	        pnAlarmBtns.add(btn1);
	        pnAlarmBtns.add(btn2);
	        pnAlarmBtns.add(btn3);
	        pnAlarmBtns.add(btn4);
	        pnAlarmBtns.add(btn5);
	        pnAlarmBtns.add(btn6);
	        pnAlarmBtns.add(btn7);
	        pnAlarmBtns.add(btn8);
	        pnAlarmBtns.add(btn9);
	        pnAlarmBtns.add(btn10);
	        pnAlarmBtns.add(btn11);
	        pnAlarmBtns.add(btn12);
	        pnAlarmBtns.add(btn13);
	        pnAlarmBtns.add(btn14);
	        pnAlarmBtns.add(btn15);
	        pnAlarmBtns.add(btn16);
	        pnAlarmBtns.add(btn17);
	        pnAlarmBtns.add(btn18);
	        pnAlarmBtns.add(btn19);
	        pnAlarmBtns.add(btn20);
	        
	        pnAlarm.add(pnAlarmBtns);
	        
	        pnAlarm.add(Box.createVerticalGlue());
	        
	        centerPanel.add(pnAlarm, "pnAlarm");
	        
	        
	        getContentPane().add(centerPanel, BorderLayout.CENTER);
	        centerPanel.setBackground(new Color(255, 235, 205));
	        
	       
	       
	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        buttonPanel.add(payButton);
	        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
	        buttonPanel.setBackground(new Color(255, 235, 205));
	        discountCodeField = new JTextField(15);
	        checkCodeButton = new JButton("Check Discount Code");
	        checkCodeButton.setBackground(new Color(255, 153, 51));
	        checkCodeButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String inputCode = discountCodeField.getText();
	                boolean isValid = checkDiscountCode(inputCode);

	                if (inputCode.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Press voucher");
	                } else if (isValid) {
	                    JOptionPane.showMessageDialog(null, "Your has voucher 50% !");

	                    double money = Double.parseDouble(totalLabel.getText()) /2;
	  
	                    totalLabel.setText(money+"");
	                    checkCodeButton.setEnabled(false);
	                    discountCodeField.setEnabled(false);

	                } else {
	                    JOptionPane.showMessageDialog(null, "Incorrect, please try again");
	                }
	            }
	        });
	        
	        JPanel discountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        discountPanel.add(new JLabel("Press voucher "));
	        discountPanel.add(discountCodeField);
	        discountPanel.add(checkCodeButton);
	        discountPanel.add(createReamote); 

	        cashPayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	                buttonPanel.add(discountPanel);
	                buttonPanel.revalidate();
	                buttonPanel.repaint();
	            }
	        });
	        
	        cardPayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttonPanel.add(discountPanel);
	                buttonPanel.revalidate();
	                buttonPanel.repaint();
	            }
	        });
	        
	        onlinePayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                buttonPanel.add(discountPanel);
	                buttonPanel.revalidate();
	                buttonPanel.repaint();
	            }
	        });
	        
	     
	        
	        cashPayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resultRandom = generateRandomCode();
//	                cashDiscountLabel.setText("Voucher: " + resultRandom);  
//	                cashDiscountLabel.setVisible(true); 
//
//	              
//	                cardDiscountLabel.setVisible(false);
//	                onlineDiscountLabel.setVisible(false);
	            }
	        });
	        

	        cardPayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resultRandom = generateRandomCode();
//	                cardDiscountLabel.setText("Voucher: " + resultRandom);  
//	                cardDiscountLabel.setVisible(true);  
//
//	       
//	                cashDiscountLabel.setVisible(false);
//	                onlineDiscountLabel.setVisible(false);
	            }
	        });
	        
	        onlinePayment.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                resultRandom = generateRandomCode();
//	                onlineDiscountLabel.setText("Voucher: " + resultRandom);  
//	                onlineDiscountLabel.setVisible(true);  
//
//	             
//	                cashDiscountLabel.setVisible(false);
//	                cardDiscountLabel.setVisible(false);
	            }
	        });
	        
	        Font labelFont = new Font("Arial", Font.PLAIN, 10); 
	        cashDiscountLabel.setFont(labelFont);
	        cardDiscountLabel.setFont(labelFont);
	        onlineDiscountLabel.setFont(labelFont);
//	        JPanel radioPanel = new JPanel(new GridLayout(6, 1));
//
//	        radioPanel.add(cashPayment);
//	        radioPanel.add(cashDiscountLabel); 
//	        radioPanel.add(cardPayment);
//	        radioPanel.add(cardDiscountLabel);  
//	        radioPanel.add(onlinePayment);
//	        radioPanel.add(onlineDiscountLabel);
//	        
//	        add(radioPanel, BorderLayout.WEST);
	        
	        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        getContentPane().setBackground(new Color(255, 235, 205));
	        setSize(1224, 600);
	        this.setLocationRelativeTo(null);
	        setVisible(true);
	        
	        alarmBtns = groupBtnAlarms(pnAlarmBtns);
	        for(JButton btn : alarmBtns) {
	        	btn.setBackground(new Color(255, 153, 51));
	        }
	        for(JButton btn : alarmBtns) {
	        	settingBtnAlarms(btn);
	        }
	       
	        
	        checkBtnAlarm(alarmBtns);
	        
	        ActionListener ac = new BtnAlarmController(this);
	        for(JButton btn : alarmBtns) {
	        	btn.addActionListener(ac);
	        }

	        
    }
    
    public boolean checkDiscountCode(String inputCode) {
    	
//        return (inputCode.equals(resultRandom));
    	boolean result = false;
    	for(Voucher vch : vchs) {
    		if(vch.getStr().equals(inputCode)) {
    			if(vch.isAvailable()==true) {
    				result=true;
    				vch.setAvailable(false);
    				this.fileVoucher.reWriteVoucher(vchs);
    			}
    			
    			
    		}
    			
    				
    	}
    	return result;
    }

	public JTable getDrinksTable() {
		return drinksTable;
	}

	public void setDrinksTable(JTable drinksTable) {
		this.drinksTable = drinksTable;
	}

	public JRadioButton getCashPayment() {
		return cashPayment;
	}

	public void setCashPayment(JRadioButton cashPayment) {
		this.cashPayment = cashPayment;
	}

	public JRadioButton getCardPayment() {
		return cardPayment;
	}

	public void setCardPayment(JRadioButton cardPayment) {
		this.cardPayment = cardPayment;
	}

	public JLabel getCashDiscountLabel() {
		return cashDiscountLabel;
	}

	public void setCashDiscountLabel(JLabel cashDiscountLabel) {
		this.cashDiscountLabel = cashDiscountLabel;
	}

	public JLabel getCardDiscountLabel() {
		return cardDiscountLabel;
	}

	public void setCardDiscountLabel(JLabel cardDiscountLabel) {
		this.cardDiscountLabel = cardDiscountLabel;
	}

	public JRadioButton getOnlinePayment() {
		return onlinePayment;
	}

	public void setOnlinePayment(JRadioButton onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public JLabel getOnlineDiscountLabel() {
		return onlineDiscountLabel;
	}

	public void setOnlineDiscountLabel(JLabel onlineDiscountLabel) {
		this.onlineDiscountLabel = onlineDiscountLabel;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}
	
	public boolean isEmptyTable() {
	    if (drinksTable.getRowCount() == 0) {
	            return false;
	     }
	     return true;
	}
	
	public void pressedCreateAlarm() {

		CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
		cardLayout.show(centerPanel, "pnAlarm");
		
	}
	
	public void backToPay() {
		CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
		cardLayout.show(centerPanel, "Info");
	}

	public JLabel getTotalLabel() {
		return totalLabel;
	}

	public void setTotalLabel(JLabel totalLabel) {
		this.totalLabel = totalLabel;
	}
	
	  public String generateRandomCode() {
	        String rs = "";
	        for (int i = 1; i <= 2; i++) {
	            char a = (char) (int) ((Math.random() * 25) + 66);
	            char b = (char) (int) ((Math.random() * 25) + 98);
	            char c = (char) (int) ((Math.random() * 9) + 48);
	            rs += a + "" + b + "" + c;

	        }
	        return resultRandom = rs;
	    }
	
	  
	  public JButton getPayButton() {
		return payButton;
	}

	public void setPayButton(JButton payButton) {
		this.payButton = payButton;
	}
	
	
	public void backToOrder() {
		Order o = new Order();
		o.getModel().setRowCount(0);
		o.getLblRePrice().setText(0.0 + "VND");
		o.getLblReTotal().setText(0+"");
	}
	
	

	public JButton getCheckCodeButton() {
		return checkCodeButton;
	}

	public void setCheckCodeButton(JButton checkCodeButton) {
		this.checkCodeButton = checkCodeButton;
	}

	public JButton getCreateReamote() {
		return createReamote;
	}

	public void setCreateReamote(JButton createReamote) {
		this.createReamote = createReamote;
	}

	public static void main(String[] args) {
		PayView pay = new PayView();
//		pay.enableAlarmDevice(2);
//		System.out.println(pay.getAs());
	}
	

    public JTextField getDiscountCodeField() {
        return discountCodeField;
    }
    
    public List<JButton> groupBtnAlarms(JPanel pn) {
    	List<JButton> btns = new ArrayList<>();
    	Component[] cps = pn.getComponents();
    	for(Component cp : cps) {
    		if(cp instanceof JButton)
    			btns.add((JButton) cp);
    			
    	}
    	return btns;
    
    }
    
    public void settingBtnAlarms(JButton btn) {
        btn.setMinimumSize(new Dimension(70, 40));
        btn.setMaximumSize(new Dimension(70, 40));
        btn.setPreferredSize(new Dimension(70, 40));
        btn.setFont(new Font("Tahoma", Font.BOLD, 14));
    }
    
    public void enableBtnAlarm(JButton btn) {
    	for(Alarm a : as) {
    		if(a.getNumber() == Integer.parseInt(btn.getText())) {
    			if(a.isAvailable()==true)
    				btn.setEnabled(true);
    			if(a.isAvailable()==false)
    				btn.setEnabled(false);
    		}
    			
    	}
    }
    
    public void checkBtnAlarm(List<JButton> btns) {
    	for(JButton btn : btns) {
    		enableBtnAlarm(btn);
    	}
    	
    }

	public FileRW getFileAlarm() {
		return fileAlarm;
	}

	public void setFileAlarm(FileRW fileAlarm) {
		this.fileAlarm = fileAlarm;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public JButton getBtn9() {
		return btn9;
	}

	public JButton getBtn10() {
		return btn10;
	}

	public JButton getBtn11() {
		return btn11;
	}

	public JButton getBtn12() {
		return btn12;
	}

	public JButton getBtn13() {
		return btn13;
	}

	public JButton getBtn14() {
		return btn14;
	}

	public JButton getBtn15() {
		return btn15;
	}

	public JButton getBtn16() {
		return btn16;
	}

	public JButton getBtn17() {
		return btn17;
	}

	public JButton getBtn18() {
		return btn18;
	}

	public JButton getBtn19() {
		return btn19;
	}

	public JButton getBtn20() {
		return btn20;
	}

	public JPanel getCenter1() {
		return center1;
	}

	public List<Alarm> getAs() {
		return as;
	}
	
	public void enableAlarmDevice(int num) {
		
		for(Alarm al : as)
			if(al.getNumber() == num) {
				al.setAvailable(true);
				break;
			}
		fileAlarm.reWriteAlarm(as);
				
		
	}
	
	public void unenableAlarmDevice(int num) {
		
		for(Alarm al : as)
			if(al.getNumber() == num) {
				al.setAvailable(false);
				break;
			}
		fileAlarm.reWriteAlarm(as);
				
		
	}

	public String getDrinks() {
		return drinks;
	}

	public void setDrinks() {		
		int rowCount = drinksTable.getRowCount();
		String drink="";
		Integer qty;

        for (int row = 0; row < rowCount; row++) {
        	 drink = (String) drinksTable.getValueAt(row, 0);
        	 
        	 qty =	(Integer) drinksTable.getValueAt(row, 2);
        	 if(drink.length() >= 64) {
        		 String dr1 = drink.substring(0, 64);
        		 String dr2 = drink.substring(64);
        		 drinks = drinks + dr1 + "\n" + dr2 + " || " + qty + "\n";
        	 }
        	 else
        		 drinks = drinks + drink + " || " + qty +"\n";
       
        }

		
	}
	


	public Alarm newAlarm(int num) {
		for(Alarm a : as) {
			if(a.getNumber() == num) {
				a.setAvailable(false);
				this.fileAlarm.reWriteAlarm(as);
				return a;
			}
				
		}
		return null;
	}
	
	
	
	public JLabel getLblAlarmInfo() {
		return lblAlarmInfo;
	}

	public void setLblAlarmInfo(JLabel lblAlarmInfo) {
		this.lblAlarmInfo = lblAlarmInfo;
	}

	public void moveOrderToObserver() {
		int num = Integer.parseInt(lblAlarmInfo.getText());
		OrderModel orderModel = new OrderModel(drinks, newAlarm(num));
		setOrder(orderModel);
//		System.out.println(orderModel);
//		System.out.println(orderData.getOrder());
//		System.out.println(obs);

		
	}
	
	public void notifyToObserver() {
		for(Observer ob : obs) {
			ob.update(orderData.getOrder());
		}
	}
	
	
	public void setOrder(OrderModel ordelModel) {
		PayView.orderData.setOrder(ordelModel);
		notifyToObserver();
	}
	
	public static void registerObserver(Observer o) {
		PayView.obs.add(o);
		PayView.orderData.registerObserver(o);
	}
	
	public static void removeObserver(Observer o) {
//		PayView.orderData.getObs().remove(o);
		PayView.obs.remove(o);
		PayView.orderData.removeObserver(o);
	}
	public void unableAlarm(int num) {
		
	}
	
	
	public void addToToday() {
		String str = this.totalLabel.getText();
	
		double money = Double.parseDouble(str);
		RevenueToday today = new RevenueToday(money);
		fileToday.writeRevenueToday(today);
//		System.out.println(money);
//		System.out.println(str);
		
		
	}
	
    public static OrderData getOrderData() {
		return PayView.orderData;
	}

	public static void setOrderData(OrderData orderData) {
		PayView.orderData = orderData;
	}

	public int getAlarmNum() {
		return alarmNum;
	}

	public void setAlarmNum(int alarmNum) {
		this.alarmNum = alarmNum;
	}
	
	public void updateBaternderData() {
		
	}
	
	
	
	
	
	

    
    
	  
	  

	
    
    

}
