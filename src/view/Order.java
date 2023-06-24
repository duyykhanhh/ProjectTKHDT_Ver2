package view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import MilkTeaStore.Beverage;
import MilkTeaStore.Topping;
import MilkTeaStore.ToppingFactory;
import controller.OrderController;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class Order extends JFrame {
	private OrderController orderController;
//	khai bao nuoc
//	private Beverage be;
//	private IFlavourStrategy flavour;
//	private Drink dr;
//	private ISizeStrategy size;
//private String  size, flavour, topping;
	double totalPrice=0;
 String dr ;
 String size = "";
 String flavour = "";
 String topping = "";
 JLabel beverageType;

	private ArrayList<String> toppings;
//	private ArrayList<String> beverage;
	Beverage beverage;


	//	dem thoi gian tro giup trong lam hieu ung button, khong duoc xoa
	private javax.swing.Timer timer;
	private int count=0;


	//	khai bao thanh phan giao dien
	
	private JPanel pnOrder,pnProduct,pnPay,pnCustom,pnCustomOK, pnCoffeeFlavour;
	private JTable tblProductInfo;
	private JScrollPane sp;
	private DefaultTableModel model;
	private JLabel lblTotal, lblTotalPrice, lblReTotal, lblRePrice;
	private JButton btnMilktea, btnCoffee, btnSoftDrink, btnJuice, btnRemove,btnPay;
	private JPanel pnOrdering, pnCategory, pnMTCustom, pnFlavour, pnTopping, pnSize,pnCoffeeCustom, pnOK;
	private JLabel lblCategory;
	private JButton btnChocolate, btnMatcha, btnTaro, btnPearl,btnPudding, btnGrassjelly, btnS, btnM, btnL, btnOK;
	private JButton btnBlack, btnMilk;
	private JPanel pnCoffeeSize;
	private JButton btnCoffeeS, btnCoffeeL, btnCoffeeM;
	
	private JPanel pnSoftdrinkFlavour, pnSoftdrinkCustom;
	private JButton btnRedbull, btnCocaCola, btnSting, btn7Up;
	
	private JPanel pnJuiceCustom, pnJuiceFlavour, pnJuiceSize;
	private JButton btnOrange, btnLemonade;
	private JButton btnJuiceS, btnJuiceM, btnJuiceL;

	//	bien ho tro doi mau btn Topping
	private int countPearl=0;
	private int countPudding=0;
	private int countGrassJelly=0;
	private JLabel lblNumOfPearl;
	private JLabel lblNumOfPudding;
	private JLabel lblNumOfGrassJelly;
	Object[][] data;
	
//	bien ho tro tinh tien
	int quantityEach, quantityTotal=0;
	double price=0;
	private JPanel pnProductAndEdit;
	private JPanel pnEdit;
	private JButton btnPlus, btnMinus;
	private JPanel pnNull;
	private JLabel lblNull;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
//	bang mau
//	new Color(255, 204, 153) mau btnCategory mac dinh


	/**
	 * Create the frame.
	 */
	public Order() {
		beverageType = new JLabel();
//		countPearl=0;
//		countPudding=0;
//		countGrassJelly=0;
//		private int countPearl;
//		private int countPudding;
//		private int countGrassJelly;


		setTitle("Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1284, 600);
		setLocationRelativeTo(null);

		pnOrder = new JPanel();
		pnOrder.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnOrder.setLayout(new BorderLayout(0, 0));
		setContentPane(pnOrder);


//		************************************************
//		xu ly su kien
		ActionListener lis= new OrderController(this);
		orderController = new OrderController(this);

//		************************************************


//		************************************************

//		tao bang hien san pham da order, bang nay nam ben trai
		pnProduct = new JPanel();
		pnOrder.add(pnProduct, BorderLayout.EAST);
		pnProduct.setMinimumSize(new Dimension(380, 600));
		pnProduct.setMaximumSize(new Dimension(380, 600));
		pnProduct.setPreferredSize(new Dimension(380, 600));
		pnProduct.setLayout(new BoxLayout(pnProduct, BoxLayout.Y_AXIS));


		 data= new Object[][]{
//				 {"1.Tra sua chan chau", 20000, 4}
			 		
		 };
		 Class[] columnTypes = {
				 String.class, Double.class, Integer.class
		 };

		String[] column= {
				"Product", "Price Unit", "Qty"
		};


		model= new DefaultTableModel(data, column);
		tblProductInfo= new JTable(model);
		tblProductInfo.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tblProductInfo.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
		
		TableColumnModel columnModel = tblProductInfo.getColumnModel();
		 columnModel.getColumn(0).setPreferredWidth(220); 
	     columnModel.getColumn(1).setPreferredWidth(60);  
	     columnModel.getColumn(2).setPreferredWidth(40);  
	    
	      DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                JTextArea textArea = new JTextArea();
	                textArea.setText(value != null ? value.toString() : "");
	                textArea.setLineWrap(true);
	                textArea.setWrapStyleWord(true);
	                textArea.setBackground(table.getBackground());
	                textArea.setFont(table.getFont());

	                return textArea;
	            }
	        };
	        tblProductInfo.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	     
	     
	     
		 
		 tblProductInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnPlus.setEnabled(true);
				btnMinus.setEnabled(true);
				btnRemove.setEnabled(true);
				
			}
		});

		
		 
		tblProductInfo.getModel().addTableModelListener(new TableModelListener() {

			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				updateTable();
			}
			
		});

		sp= new JScrollPane(tblProductInfo);
//		sp.setBackground(new Color(255, 235, 205));
		sp.setMinimumSize(new Dimension(320, 400));
		sp.setMaximumSize(new Dimension(320, 400));
		sp.setPreferredSize(new Dimension(320, 400));

		
		pnProductAndEdit = new JPanel();
		pnProductAndEdit.setLayout(new BorderLayout(0, 0));
		pnProductAndEdit.add(sp, BorderLayout.CENTER);
		pnProduct.add(pnProductAndEdit);
		
		
		pnEdit = new JPanel();
		pnProductAndEdit.add(pnEdit, BorderLayout.EAST);
		pnEdit.setLayout(new BoxLayout(pnEdit, BoxLayout.Y_AXIS));
		
		pnEdit.add(Box.createVerticalStrut(60));
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int selectedRow = tblProductInfo.getSelectedRow();
		            if (selectedRow != -1) {
		            	int qty = (int) tblProductInfo.getValueAt(selectedRow, 2);
		            	qty++;
		            	tblProductInfo.setValueAt(qty, selectedRow, 2);
//		                enableEditing(false);
		            }
			}
		});
		
		btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlus.setBackground(new Color(255,153,51));

			}


			@Override
			public void mouseExited(MouseEvent e) {
				btnPlus.setBackground(new Color(255, 204, 153));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				timer= new javax.swing.Timer(490, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						  int selectedRow = tblProductInfo.getSelectedRow();
				            if (selectedRow != -1) {
				            	int qty = (int) tblProductInfo.getValueAt(selectedRow, 2);
				            	qty+=9;
				            	tblProductInfo.setValueAt(qty, selectedRow, 2);
				            }

					}
				});

				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.stop();
			
			}
			
			
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlus.setMinimumSize(new Dimension(49, 60));
		btnPlus.setMaximumSize(new Dimension(49, 60));
		btnPlus.setPreferredSize(new Dimension(49, 60));
		pnEdit.add(btnPlus);
		
		pnEdit.add(Box.createVerticalStrut(30));
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int selectedRow = tblProductInfo.getSelectedRow();
		            if (selectedRow != -1) {
		            	int qty = (int) tblProductInfo.getValueAt(selectedRow, 2);
		            	qty--;
		              	if(qty<=0) {
		            		model.removeRow(selectedRow);
		            	}
		            	else
		            		tblProductInfo.setValueAt(qty, selectedRow, 2);
		            }
			}
		});
		
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinus.setBackground(new Color(255,153,51));
			}


			@Override
			public void mouseExited(MouseEvent e) {
				btnMinus.setBackground(new Color(255, 204, 153));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				timer= new javax.swing.Timer(490, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						  int selectedRow = tblProductInfo.getSelectedRow();
				            if (selectedRow != -1) {
				            	int qty = (int) tblProductInfo.getValueAt(selectedRow, 2);
				            	qty-=9;
				            	if(qty<=0) {
				            		model.removeRow(selectedRow);
				            	}
				            	else
				            		tblProductInfo.setValueAt(qty, selectedRow, 2);
				            }

					}
				});

				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.stop();
			
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMinus.setMinimumSize(new Dimension(49, 60));
		btnMinus.setMaximumSize(new Dimension(49, 60));
		btnMinus.setPreferredSize(new Dimension(49, 60));
		pnEdit.add(btnMinus);


		
		pnEdit.add(Box.createVerticalStrut(30));
		
		btnRemove = new JButton("X");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int selectedRow = tblProductInfo.getSelectedRow();
		            if (selectedRow != -1) {
		            	model.removeRow(selectedRow);
//		                enableEditing(false);
		            }
			}
		});
		
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRemove.setBackground(new Color(255,153,51));
			}


			@Override
			public void mouseExited(MouseEvent e) {
				btnRemove.setBackground(new Color(255, 204, 153));
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemove.setMinimumSize(new Dimension(49, 60));
		btnRemove.setMaximumSize(new Dimension(49, 60));
		btnRemove.setPreferredSize(new Dimension(49, 60));
		pnEdit.add(btnRemove);
	
//		btnRemove.addActionListener(e -> {
//            int selectedRow = tblProductInfo.getSelectedRow();
//            if (selectedRow != -1) {
//                model.removeRow(selectedRow);
//                enableEditing(false);
//            }
//        });


		pnPay = new JPanel();
		pnProduct.add(pnPay);

		lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblTotalPrice = new JLabel("Total price:");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 17));

		lblReTotal = new JLabel();
		lblReTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblRePrice = new JLabel();
		lblRePrice.setFont(new Font("Tahoma", Font.PLAIN, 17));

		btnPay = new JButton("PAY");
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPay.setBackground(new Color(255,153,51));
			}


			@Override
			public void mouseExited(MouseEvent e) {
				btnPay.setBackground(new Color(255, 204, 153));
			}
		});
		GroupLayout gpnPay = new GroupLayout(pnPay);
		gpnPay.setHorizontalGroup(
				gpnPay.createParallelGroup(Alignment.LEADING)
						.addGroup(gpnPay.createSequentialGroup()
								.addContainerGap()
								.addGroup(gpnPay.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTotalPrice))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gpnPay.createParallelGroup(Alignment.LEADING)
										.addComponent(lblReTotal, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRePrice, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnPay, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(26, Short.MAX_VALUE))
		);
		gpnPay.setVerticalGroup(
				gpnPay.createParallelGroup(Alignment.LEADING)
						.addGroup(gpnPay.createSequentialGroup()
								.addGap(29)
								.addGroup(gpnPay.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTotal)
										.addComponent(lblReTotal))
								.addGap(18)
								.addGroup(gpnPay.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTotalPrice)
										.addComponent(lblRePrice))
								.addContainerGap(18, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gpnPay.createSequentialGroup()
								.addGap(21)
								.addComponent(btnPay, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
								.addGap(19))
		);
		pnPay.setLayout(gpnPay);


//		************************************************

//		tao giao dien de order nuoc
		pnOrdering = new JPanel();
		Border bdOrdering= BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(255,153,51));
		pnOrdering.setBorder(bdOrdering);
		pnOrdering.setMinimumSize(new Dimension(860,600));
		pnOrdering.setMaximumSize(new Dimension(860,600));
		pnOrdering.setPreferredSize(new Dimension(860,600));

		pnOrder.add(pnOrdering, BorderLayout.WEST);
		pnOrdering.setLayout(new BoxLayout(pnOrdering, BoxLayout.X_AXIS));

		pnCategory = new JPanel();
		pnCategory.setMinimumSize(new Dimension(120,600));
		pnCategory.setMaximumSize(new Dimension(120,600));
		pnCategory.setPreferredSize(new Dimension(120,600));
		Border bdCategory= BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(255,153,51));
		pnCategory.setBorder(bdCategory);
		pnOrdering.add(pnCategory);
		pnCategory.setLayout(new BoxLayout(pnCategory, BoxLayout.Y_AXIS));

		lblCategory = new JLabel("Category");
		lblCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCategory.add(lblCategory);

		pnCategory.add(Box.createVerticalStrut(40));

		btnMilktea = new JButton("Milktea");
		btnMilktea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				beverageType.setText("Milktea");
//				dr = "Milktea";
				pressedCategory(btnMilktea);

			}
		});
		btnMilktea.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnMilktea.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnMilktea.setSize(100, 170);
		btnMilktea.setMinimumSize(new Dimension(100, 70));
		btnMilktea.setMaximumSize(new Dimension(100, 70));
		btnMilktea.setPreferredSize(new Dimension(100, 70));
		pnCategory.add(btnMilktea);

		pnCategory.add(Box.createVerticalStrut(20));

		btnCoffee = new JButton("Coffee");
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				beverageType.setText("Coffee");
//				dr = "Coffee";
				pressedCategory(btnCoffee);
			}
		});
		btnCoffee.setPreferredSize(new Dimension(100, 70));
		btnCoffee.setMinimumSize(new Dimension(100, 70));
		btnCoffee.setMaximumSize(new Dimension(100, 70));
		btnCoffee.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCoffee.setAlignmentX(0.5f);
		pnCategory.add(btnCoffee);

		pnCategory.add(Box.createVerticalStrut(20));

		btnSoftDrink = new JButton("Softdrink");
		btnSoftDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				beverageType.setText("SoftDrink");
//				dr = "SoftDrink";
				pressedCategory(btnSoftDrink);
			}
		});
		btnSoftDrink.setPreferredSize(new Dimension(100, 70));
		btnSoftDrink.setMinimumSize(new Dimension(100, 70));
		btnSoftDrink.setMaximumSize(new Dimension(100, 70));
		btnSoftDrink.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSoftDrink.setAlignmentX(0.5f);
		pnCategory.add(btnSoftDrink);

		pnCategory.add(Box.createVerticalStrut(20));

		btnJuice = new JButton("Juice");
		btnJuice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				beverageType.setText("Juice");
//				dr = "Juice";
				pressedCategory(btnJuice);
			}
		});
		btnJuice.setPreferredSize(new Dimension(100, 70));
		btnJuice.setMinimumSize(new Dimension(100, 70));
		btnJuice.setMaximumSize(new Dimension(100, 70));
		btnJuice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnJuice.setAlignmentX(0.5f);
		pnCategory.add(btnJuice);

		pnOrdering.add(Box.createHorizontalStrut(40));

		pnCustomOK= new JPanel();
		pnCustomOK.setLayout(new BorderLayout(0, 0));
		pnCustomOK.setPreferredSize(new Dimension(690,500));
		pnCustomOK.setMinimumSize(new Dimension(690, 500));
		pnCustomOK.setMaximumSize(new Dimension(690, 500));
//		Border bdCustomOK= BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(255,153,51));
//		pnCustomOK.setBorder(bdCustomOK);
		pnOrdering.add(pnCustomOK);
//		them border layout cho customOK


		pnOK = new JPanel();
		pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));

		pnCustomOK.add(pnOK, BorderLayout.SOUTH);


		btnOK = new JButton("OK");

		btnOK.setMinimumSize(new Dimension(100, 60));
		btnOK.setMaximumSize(new Dimension(100, 60));
		btnOK.setPreferredSize(new Dimension(100, 60));


		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOK.setBackground(new Color(255,153,51));
			}


			@Override
			public void mouseExited(MouseEvent e) {
				btnOK.setBackground(new Color(255, 204, 153));
			}
		});


//		btnOK.addActionListener(lis);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beverage = orderController.setBeverage(dr);
				ArrayList<Topping> toppingList = new ArrayList<>();

//				if(!lblNumOfPearl.getText().equalsIgnoreCase("0")){
				Topping topping;
				if(countPearl!=0){
//					Topping topping = factory.createTopping(btnPearl.getText(),Integer.parseInt(lblNumOfPearl.getText()));
//					Topping topping = beverage.getToppingFactory().createTopping(btnPearl.getText(),Integer.parseInt(lblNumOfPearl.getText()));
//					topping = orderController.createTopping(btnPearl.getText(),countPearl);
					 topping = orderController.createTopping(btnPearl.getText(),countPearl);

					toppingList.add(topping);

				}
//				if(!lblNumOfPudding.getText().equalsIgnoreCase("0")){
				if(countPudding!=0){
//					Topping topping = factory.createTopping(btnPudding.getText(),Integer.parseInt(lblNumOfPudding.getText()));
//					Topping topping = beverage.getToppingFactory().createTopping(btnPudding.getText(),Integer.parseInt(lblNumOfPudding.getText()));
//					topping = orderController.createTopping(btnPudding.getText(),countPudding);
				topping = orderController.createTopping(btnPudding.getText(),countPudding);

					toppingList.add(topping);
				}
//				if(!lblNumOfGrassJelly.getText().equalsIgnoreCase("0")){
				if(countGrassJelly!=0){
//					Topping topping = factory.createTopping(btnGrassjelly.getText(),Integer.parseInt(lblNumOfGrassJelly.getText()));
//					Topping topping = beverage.getToppingFactory().createTopping(btnGrassjelly.getText(),Integer.parseInt(lblNumOfGrassJelly.getText()));
//					topping = orderController.createTopping(btnGrassjelly.getText(),countGrassJelly);
					 topping = orderController.createTopping(btnGrassjelly.getText(),countGrassJelly);

					toppingList.add(topping);
				}
				

				double price=0;		
				price= orderController.getTotalPrice(beverage,flavour,toppingList,size);
			
			
				
				
				model.addRow(new Object[]{beverage.getFullDescription(),price,1});
				
				if(beverage.getFullDescription().length()>40) {
					int rowCurrent= tblProductInfo.getRowCount()-1;
					tblProductInfo.setRowHeight(rowCurrent, 40);
				}
				resetCustom();
				




			}
		});

		pnOK.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		btnOK.setPreferredSize(new Dimension(40, 40));
//		btnOK.setMinimumSize(new Dimension(40, 40));
//		btnOK.setMaximumSize(new Dimension(40, 40));
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnOK.add(btnOK);
		pnOK.add(Box.createHorizontalStrut(20));
		pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));

		pnCustom = new JPanel();
//		pnCustom.setPreferredSize(new Dimension(440, 400));
		pnCustom.setPreferredSize(new Dimension(490, 400));
		pnCustom.setMinimumSize(new Dimension(490, 400));
		pnCustom.setMaximumSize(new Dimension(490, 400));
//		pnCustom.setAlignmentY(CENTER_ALIGNMENT);
		pnCustom.setAlignmentX(RIGHT_ALIGNMENT);
		pnCustom.setBounds(0,0,490,400);
//		pnOrdering.add(pnCustom);
		pnCustomOK.add(pnCustom,BorderLayout.CENTER);


//		CardLayout ca
		pnCustom.setLayout(new CardLayout(0, 0));
		pnMTCustom = new JPanel();
		pnMTCustom.setPreferredSize(new Dimension(490, 400));
		pnMTCustom.setMinimumSize(new Dimension(490, 400));
		pnMTCustom.setMaximumSize(new Dimension(490, 400));

		pnCustom.add(pnMTCustom, "Milktea");
		pnMTCustom.setLayout(new BoxLayout(pnMTCustom, BoxLayout.Y_AXIS));


//		pnMTCustom.add(Box.createVerticalStrut(20));

//		JLabel lblMTFlavour = new JLabel("Flavour");
//		lblMTFlavour.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		lblMTFlavour.setBounds(0, 0, WIDTH, HEIGHT);
//		pnMTCustom.add(lblMTFlavour);

		pnFlavour = new JPanel();
		pnFlavour.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnFlavour.setPreferredSize(new Dimension(670, 100));
		pnFlavour.setMinimumSize(new Dimension(670, 100));
		pnFlavour.setMaximumSize(new Dimension(670, 100));

		Border bdFlavour = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
		TitledBorder ttBdFlavour= BorderFactory.createTitledBorder(bdFlavour, "Flavour", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdFlavour.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdFlavour.setTitleColor(Color.gray);
		ttBdFlavour.setTitleJustification(TitledBorder.LEFT);
		pnFlavour.setBorder(ttBdFlavour);

		pnMTCustom.add(pnFlavour);
		pnFlavour.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		btnChocolate = new JButton("Chocolate");
		btnChocolate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnChocolate);
			}
		});
		btnChocolate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChocolate.setPreferredSize(new Dimension(120, 40));
		btnChocolate.setMinimumSize(new Dimension(120, 40));
		btnChocolate.setMaximumSize(new Dimension(120, 40));
		pnFlavour.add(btnChocolate);

		btnMatcha = new JButton("Matcha");
		btnMatcha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnMatcha);
			}
		});
		btnMatcha.setPreferredSize(new Dimension(120, 40));
		btnMatcha.setMinimumSize(new Dimension(120, 40));
		btnMatcha.setMaximumSize(new Dimension(120, 40));
		btnMatcha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnFlavour.add(btnMatcha);

		btnTaro = new JButton("Taro");
		btnTaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnTaro);
			}
		});
		btnTaro.setPreferredSize(new Dimension(120, 40));
		btnTaro.setMinimumSize(new Dimension(120, 40));
		btnTaro.setMaximumSize(new Dimension(120, 40));
		btnTaro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnFlavour.add(btnTaro);

		pnMTCustom.add(Box.createVerticalStrut(20));

//		lblTopping = new JLabel("Topping");
//		lblTopping.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		pnMTCustom.add(lblTopping);

		pnTopping = new JPanel();
		pnTopping.setPreferredSize(new Dimension(670, 100));
		pnTopping.setMinimumSize(new Dimension(670, 100));
		pnTopping.setMaximumSize(new Dimension(670, 100));
		pnTopping.setAlignmentX(0.0f);
		pnMTCustom.add(pnTopping);
		pnTopping.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		Border bdTopping = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
		TitledBorder ttBdTopping= BorderFactory.createTitledBorder(bdTopping, "Topping", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdTopping.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdTopping.setTitleColor(Color.gray);
		ttBdTopping.setTitleJustification(TitledBorder.LEFT);
		pnTopping.setBorder(ttBdTopping);

		btnPearl = new JButton("Pearl");

		btnPearl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countPearl();
				lblNumOfPearl.setText(countPearl+"");
				changeBtnToppingColor(btnPearl, countPearl);
			}
		});


		btnPearl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				timer= new javax.swing.Timer(490, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						countPearl=-1;

					}
				});

				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.stop();
			}
		});


		btnPearl.setPreferredSize(new Dimension(120, 40));
		btnPearl.setMinimumSize(new Dimension(120, 40));
		btnPearl.setMaximumSize(new Dimension(120, 40));
		btnPearl.setFont(new Font("Tahoma", Font.PLAIN, 20));


		pnTopping.add(btnPearl);

		btnPudding = new JButton("Pudding");
		btnPudding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countPudding();
				lblNumOfPudding.setText(countPudding+"");
				changeBtnToppingColor(btnPudding, countPudding);
			}
		});


		btnPudding.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				timer= new javax.swing.Timer(490, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						countPudding=-1;

					}
				});

				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.stop();
			}
		});

		lblNumOfPearl = new JLabel("0");
		lblNumOfPearl.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 153), 2));
		lblNumOfPearl.setPreferredSize(new Dimension(30, 40));
		lblNumOfPearl.setMinimumSize(new Dimension(30, 40));
		lblNumOfPearl.setMaximumSize(new Dimension(30, 40));
		lblNumOfPearl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnTopping.add(lblNumOfPearl);

		pnTopping.add(Box.createHorizontalStrut(3));
		JLabel line = new JLabel();
        line.setOpaque(true);
        line.setBackground(new Color(255,153,51));
        line.setPreferredSize(new Dimension(2, 60));
        line.setMinimumSize(new Dimension(2, 60));
        line.setMaximumSize(new Dimension(2, 60));       
        pnTopping.add(line);
        
        pnTopping.add(Box.createHorizontalStrut(3));
		btnPudding.setPreferredSize(new Dimension(120, 40));
		btnPudding.setMinimumSize(new Dimension(120, 40));
		btnPudding.setMaximumSize(new Dimension(120, 40));
		btnPudding.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTopping.add(btnPudding);

		lblNumOfPudding = new JLabel("0");
		lblNumOfPudding.setPreferredSize(new Dimension(30, 40));
		lblNumOfPudding.setMinimumSize(new Dimension(30, 40));
		lblNumOfPudding.setMaximumSize(new Dimension(30, 40));
		lblNumOfPudding.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumOfPudding.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 153), 2));
		pnTopping.add(lblNumOfPudding);

		pnTopping.add(Box.createHorizontalStrut(3));
		JLabel line2 = new JLabel();
        line2.setOpaque(true);
        line2.setBackground(new Color(255,153,51));
        line2.setPreferredSize(new Dimension(2, 60));
        line2.setMinimumSize(new Dimension(2, 60));
        line2.setMaximumSize(new Dimension(2, 60));       
        pnTopping.add(line2);
        
        pnTopping.add(Box.createHorizontalStrut(3));


		btnGrassjelly = new JButton("GrassJelly");
		btnGrassjelly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countGrassJelly();
				lblNumOfGrassJelly.setText(countGrassJelly+"");
				changeBtnToppingColor(btnGrassjelly, countGrassJelly);
			}
		});


		btnGrassjelly.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				timer= new javax.swing.Timer(490, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						countGrassJelly=-1;

					}
				});

				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.stop();
			}
		});
		btnGrassjelly.setPreferredSize(new Dimension(120, 40));
		btnGrassjelly.setMinimumSize(new Dimension(120, 40));
		btnGrassjelly.setMaximumSize(new Dimension(120, 40));
		btnGrassjelly.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTopping.add(btnGrassjelly);

		pnMTCustom.add(Box.createVerticalStrut(20));

//		JLabel lblSize = new JLabel("Size");
//		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		pnMTCustom.add(lblSize);

		pnSize = new JPanel();
		pnSize.setPreferredSize(new Dimension(670, 100));
		pnSize.setMinimumSize(new Dimension(670, 100));
		pnSize.setMaximumSize(new Dimension(670, 100));
		pnSize.setAlignmentX(0.0f);
		pnMTCustom.add(pnSize);
		pnSize.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		Border bdSize = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
		TitledBorder ttBdSize= BorderFactory.createTitledBorder(bdSize, "Size", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdSize.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdSize.setTitleColor(Color.gray);
		ttBdSize.setTitleJustification(TitledBorder.LEFT);
		pnSize.setBorder(ttBdSize);

		btnS = new JButton("S");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnS);
			}
		});
		btnS.setPreferredSize(new Dimension(120, 40));
		btnS.setMinimumSize(new Dimension(120, 40));
		btnS.setMaximumSize(new Dimension(120, 40));
		btnS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSize.add(btnS);

		btnM = new JButton("M");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnM);
			}
		});
		btnM.setPreferredSize(new Dimension(120, 40));
		btnM.setMinimumSize(new Dimension(120, 40));
		btnM.setMaximumSize(new Dimension(120, 40));
		btnM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSize.add(btnM);

		btnL = new JButton("L");
		btnL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnL);
			}
		});
		btnL.setPreferredSize(new Dimension(120, 40));
		btnL.setMinimumSize(new Dimension(120, 40));
		btnL.setMaximumSize(new Dimension(120, 40));
		btnL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSize.add(btnL);

		
		
//		********************************************************
//		custom coffee
		pnCoffeeCustom = new JPanel();
		pnCustom.add(pnCoffeeCustom, "Coffee");
		pnCoffeeCustom.setLayout(new BoxLayout(pnCoffeeCustom, BoxLayout.Y_AXIS));
		
		pnCoffeeFlavour = new JPanel();
		pnCoffeeFlavour.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnCoffeeFlavour.setPreferredSize(new Dimension(670, 100));
		pnCoffeeFlavour.setMinimumSize(new Dimension(670, 100));
		pnCoffeeFlavour.setMaximumSize(new Dimension(670, 100));

//		Border bdCoffeeFlavour = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
//		TitledBorder ttBdFlavour= BorderFactory.createTitledBorder(bdFlavour, "Flavour", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdFlavour.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdFlavour.setTitleColor(Color.gray);
		ttBdFlavour.setTitleJustification(TitledBorder.LEFT);
		pnCoffeeFlavour.setBorder(ttBdFlavour);

		pnCoffeeCustom.add(pnCoffeeFlavour);
		pnCoffeeFlavour.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		btnBlack = new JButton("Black");
		btnBlack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnBlack);
			}
		});
		btnBlack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBlack.setPreferredSize(new Dimension(120, 40));
		btnBlack.setMinimumSize(new Dimension(120, 40));
		btnBlack.setMaximumSize(new Dimension(120, 40));
		pnCoffeeFlavour.add(btnBlack);

		btnMilk = new JButton("Milk");
		btnMilk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnMilk);
			}
		});
		btnMilk.setPreferredSize(new Dimension(120, 40));
		btnMilk.setMinimumSize(new Dimension(120, 40));
		btnMilk.setMaximumSize(new Dimension(120, 40));
		btnMilk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCoffeeFlavour.add(btnMilk);


		pnMTCustom.add(Box.createVerticalStrut(20));



		pnCoffeeSize = new JPanel();
		pnCoffeeSize.setPreferredSize(new Dimension(670, 100));
		pnCoffeeSize.setMinimumSize(new Dimension(670, 100));
		pnCoffeeSize.setMaximumSize(new Dimension(670, 100));
		pnCoffeeSize.setAlignmentX(0.0f);
		pnCoffeeCustom.add(pnCoffeeSize);
		pnCoffeeSize.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

//		Border bdSize = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
//		TitledBorder ttBdSize= BorderFactory.createTitledBorder(bdSize, "Size", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
//		ttBdSize.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
//		ttBdSize.setTitleColor(Color.gray);
//		ttBdSize.setTitleJustification(TitledBorder.LEFT);
		pnCoffeeSize.setBorder(ttBdSize);
//
		btnCoffeeS = new JButton("S");
		btnCoffeeS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnCoffeeS);
			}
		});
		btnCoffeeS.setPreferredSize(new Dimension(120, 40));
		btnCoffeeS.setMinimumSize(new Dimension(120, 40));
		btnCoffeeS.setMaximumSize(new Dimension(120, 40));
		btnCoffeeS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCoffeeSize.add(btnCoffeeS);

		btnCoffeeM = new JButton("M");
		btnCoffeeM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnCoffeeM);
			}
		});
		btnCoffeeM.setPreferredSize(new Dimension(120, 40));
		btnCoffeeM.setMinimumSize(new Dimension(120, 40));
		btnCoffeeM.setMaximumSize(new Dimension(120, 40));
		btnCoffeeM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCoffeeSize.add(btnCoffeeM);

		btnCoffeeL = new JButton("L");
		btnCoffeeL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnCoffeeL);
			}
		});
		btnCoffeeL.setPreferredSize(new Dimension(120, 40));
		btnCoffeeL.setMinimumSize(new Dimension(120, 40));
		btnCoffeeL.setMaximumSize(new Dimension(120, 40));
		btnCoffeeL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCoffeeSize.add(btnCoffeeL);
		
//		********************************************************
//		custom softdrink
		pnSoftdrinkCustom = new JPanel();
		pnCustom.add(pnSoftdrinkCustom, "Softdrink");
		pnSoftdrinkCustom.setLayout(new BoxLayout(pnSoftdrinkCustom, BoxLayout.Y_AXIS));
		
		pnSoftdrinkFlavour = new JPanel();
		pnSoftdrinkFlavour.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnSoftdrinkFlavour.setPreferredSize(new Dimension(670, 100));
		pnSoftdrinkFlavour.setMinimumSize(new Dimension(670, 100));
		pnSoftdrinkFlavour.setMaximumSize(new Dimension(670, 100));

//		Border bdCoffeeFlavour = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
//		TitledBorder ttBdFlavour= BorderFactory.createTitledBorder(bdFlavour, "Flavour", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdFlavour.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdFlavour.setTitleColor(Color.gray);
		ttBdFlavour.setTitleJustification(TitledBorder.LEFT);
		pnSoftdrinkFlavour.setBorder(ttBdFlavour);

		pnSoftdrinkCustom.add(pnSoftdrinkFlavour);
		pnSoftdrinkFlavour.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		btnRedbull = new JButton("Redbull");
		btnRedbull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnRedbull);
			}
		});
		btnRedbull.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRedbull.setPreferredSize(new Dimension(120, 40));
		btnRedbull.setMinimumSize(new Dimension(120, 40));
		btnRedbull.setMaximumSize(new Dimension(120, 40));
		pnSoftdrinkFlavour.add(btnRedbull);

		btnCocaCola = new JButton("CocaCola");
		btnCocaCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnCocaCola);
			}
		});
		btnCocaCola.setPreferredSize(new Dimension(120, 40));
		btnCocaCola.setMinimumSize(new Dimension(120, 40));
		btnCocaCola.setMaximumSize(new Dimension(120, 40));
		btnCocaCola.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSoftdrinkFlavour.add(btnCocaCola);
		
		btnSting = new JButton("Sting");
		btnSting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnSting);
			}
		});
		btnSting.setPreferredSize(new Dimension(120, 40));
		btnSting.setMinimumSize(new Dimension(120, 40));
		btnSting.setMaximumSize(new Dimension(120, 40));
		btnSting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSoftdrinkFlavour.add(btnSting);
		
		btn7Up = new JButton("7Up");
		btn7Up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btn7Up);
			}
		});
		btn7Up.setPreferredSize(new Dimension(120, 40));
		btn7Up.setMinimumSize(new Dimension(120, 40));
		btn7Up.setMaximumSize(new Dimension(120, 40));
		btn7Up.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnSoftdrinkFlavour.add(btn7Up);
		
//		********************************************************
//		custom juice
		pnJuiceCustom = new JPanel();
		pnCustom.add(pnJuiceCustom, "Juice");
		pnJuiceCustom.setLayout(new BoxLayout(pnJuiceCustom, BoxLayout.Y_AXIS));
		
		pnJuiceFlavour = new JPanel();
		pnJuiceFlavour.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnJuiceFlavour.setPreferredSize(new Dimension(670, 100));
		pnJuiceFlavour.setMinimumSize(new Dimension(670, 100));
		pnJuiceFlavour.setMaximumSize(new Dimension(670, 100));

//		Border bdCoffeeFlavour = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
//		TitledBorder ttBdFlavour= BorderFactory.createTitledBorder(bdFlavour, "Flavour", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
		ttBdFlavour.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
		ttBdFlavour.setTitleColor(Color.gray);
		ttBdFlavour.setTitleJustification(TitledBorder.LEFT);
		pnJuiceFlavour.setBorder(ttBdFlavour);

		pnJuiceCustom.add(pnJuiceFlavour);
		pnJuiceFlavour.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		btnOrange = new JButton("Orange");
		btnOrange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnOrange);
			}
		});
		btnOrange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOrange.setPreferredSize(new Dimension(120, 40));
		btnOrange.setMinimumSize(new Dimension(120, 40));
		btnOrange.setMaximumSize(new Dimension(120, 40));
		pnJuiceFlavour.add(btnOrange);

		btnLemonade = new JButton("Lemonade");
		btnLemonade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedFlavour(btnLemonade);
			}
		});
		btnLemonade.setPreferredSize(new Dimension(120, 40));
		btnLemonade.setMinimumSize(new Dimension(120, 40));
		btnLemonade.setMaximumSize(new Dimension(120, 40));
		btnLemonade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnJuiceFlavour.add(btnLemonade);


		pnJuiceCustom.add(Box.createVerticalStrut(20));



		pnJuiceSize = new JPanel();
		pnJuiceSize.setPreferredSize(new Dimension(670, 100));
		pnJuiceSize.setMinimumSize(new Dimension(670, 100));
		pnJuiceSize.setMaximumSize(new Dimension(670, 100));
		pnJuiceSize.setAlignmentX(0.0f);
		pnJuiceCustom.add(pnJuiceSize);
		pnJuiceSize.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

//		Border bdSize = BorderFactory.createMatteBorder(0,0, 2, 0, new Color(255, 153, 51));
//		TitledBorder ttBdSize= BorderFactory.createTitledBorder(bdSize, "Size", TitledBorder.LEFT, TitledBorder.ABOVE_TOP);
//		ttBdSize.setTitleFont((new Font("Tahoma", Font.PLAIN, 14)));
//		ttBdSize.setTitleColor(Color.gray);
//		ttBdSize.setTitleJustification(TitledBorder.LEFT);
		pnJuiceSize.setBorder(ttBdSize);
//
		btnJuiceS = new JButton("S");
		btnJuiceS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnJuiceS);
			}
		});
		btnJuiceS.setPreferredSize(new Dimension(120, 40));
		btnJuiceS.setMinimumSize(new Dimension(120, 40));
		btnJuiceS.setMaximumSize(new Dimension(120, 40));
		btnJuiceS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnJuiceSize.add(btnJuiceS);

		btnJuiceM = new JButton("M");
		btnJuiceM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnJuiceM);
			}
		});
		btnJuiceM.setPreferredSize(new Dimension(120, 40));
		btnJuiceM.setMinimumSize(new Dimension(120, 40));
		btnJuiceM.setMaximumSize(new Dimension(120, 40));
		btnJuiceM.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnJuiceSize.add(btnJuiceM);

		btnJuiceL = new JButton("L");
		btnJuiceL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressedSize(btnJuiceL);
			}
		});
		btnJuiceL.setPreferredSize(new Dimension(120, 40));
		btnJuiceL.setMinimumSize(new Dimension(120, 40));
		btnJuiceL.setMaximumSize(new Dimension(120, 40));
		btnJuiceL.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnJuiceSize.add(btnJuiceL);



		btnMilktea.setBackground(new Color(255, 204, 153));
		btnCoffee.setBackground(new Color(255, 204, 153));
		btnSoftDrink.setBackground(new Color(255, 204, 153));
		btnJuice.setBackground(new Color(255, 204, 153));

//		mau btnFlavours
		btnChocolate.setBackground(new Color(255, 204, 153));
		btnMatcha.setBackground(new Color(255, 204, 153));
		btnTaro.setBackground(new Color(255, 204, 153));
		
		btnBlack.setBackground(new Color(255, 204, 153));
		btnMilk.setBackground(new Color(255, 204, 153));
		
		btnRedbull.setBackground(new Color(255, 204, 153));
		btnCocaCola.setBackground(new Color(255, 204, 153));
		btnSting.setBackground(new Color(255, 204, 153));
		btn7Up.setBackground(new Color(255, 204, 153));
		
		btnOrange.setBackground(new Color(255, 204, 153));
		btnLemonade.setBackground(new Color(255, 204, 153));

//		btnChocolate.setBackground(new Color(255, 204, 153));
//		btnMatcha.setBackground(new Color(255, 204, 153));
//		btnTaro.setBackground(new Color(255, 204, 153));

		btnPearl.setBackground(new Color(255, 204, 153));
		btnPudding.setBackground(new Color(255, 204, 153));
		btnGrassjelly.setBackground(new Color(255, 204, 153));

		lblNumOfGrassJelly = new JLabel("0");
		lblNumOfGrassJelly.setPreferredSize(new Dimension(30, 40));
		lblNumOfGrassJelly.setMinimumSize(new Dimension(30, 40));
		lblNumOfGrassJelly.setMaximumSize(new Dimension(30, 40));
		lblNumOfGrassJelly.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumOfGrassJelly.setBorder(BorderFactory.createLineBorder(new Color(255, 204, 153), 2));
		pnTopping.add(lblNumOfGrassJelly);

		btnS.setBackground(new Color(255, 204, 153));
		btnM.setBackground(new Color(255, 204, 153));
		btnL.setBackground(new Color(255, 204, 153));
		
		btnCoffeeS.setBackground(new Color(255, 204, 153));
		btnCoffeeM.setBackground(new Color(255, 204, 153));
		btnCoffeeL.setBackground(new Color(255, 204, 153));
		
		btnJuiceS.setBackground(new Color(255, 204, 153));
		btnJuiceM.setBackground(new Color(255, 204, 153));
		btnJuiceL.setBackground(new Color(255, 204, 153));

		

		btnOK.setBackground(new Color(255, 204, 153));
		
		btnPlus.setBackground(new Color(255, 204, 153));
		btnMinus.setBackground(new Color(255, 204, 153));
		btnRemove.setBackground(new Color(255, 204, 153));

		btnPay.setBackground(new Color(255, 204, 153));
		
	

//		set background
		setPanelBackground(pnOrder, new Color(255, 235, 205));
	}

//	*******************************************************

	//	ham dat mau nen
	public static void setPanelBackground(JPanel panel, Color color) {
		panel.setBackground(color);
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JPanel) {
				setPanelBackground((JPanel)component, color);
			}
		}
	}


//	ham xu ly btnCategory

	//	ham doi mau btn
	private void changeBtnCategoriesColorToDefault() {
		btnMilktea.setBackground(new Color(255, 204, 153));
		btnCoffee.setBackground(new Color(255, 204, 153));
		btnSoftDrink.setBackground(new Color(255, 204, 153));
		btnJuice.setBackground(new Color(255, 204, 153));

	}

	private void changeBtnCategoriesColor(JButton button) {
		changeBtnCategoriesColorToDefault();
		button.setBackground(new Color(255,153,51));

	}
//	 xu ly du lieu
public void getCategory(JButton btn) {
	dr = btn.getText();

}

	public void pressedCategory(JButton btn) {
		resetCustom();
		changeBtnCategoriesColor(btn);
		
		
		getCategory(btn);
		CardLayout cardLayout = (CardLayout) pnCustom.getLayout();
		String str= btn.getText();
		cardLayout.show(pnCustom, str);
	}

//	ham xu ly btnFlavour

	//	ham doi mau btn
	private void changeBtnFlavoursColorToDefault() {
		btnChocolate.setBackground(new Color(255, 204, 153));
		btnMatcha.setBackground(new Color(255, 204, 153));
		btnTaro.setBackground(new Color(255, 204, 153));
		
		btnBlack.setBackground(new Color(255, 204, 153));
		btnMilk.setBackground(new Color(255, 204, 153));
		
		btnRedbull.setBackground(new Color(255, 204, 153));
		btnCocaCola.setBackground(new Color(255, 204, 153));		
		btnSting.setBackground(new Color(255, 204, 153));
		btn7Up.setBackground(new Color(255, 204, 153));
		
		btnOrange.setBackground(new Color(255, 204, 153));
		btnLemonade.setBackground(new Color(255, 204, 153));
		
		

	}

	private void changeBtnFlavourColor(JButton button) {
		changeBtnFlavoursColorToDefault();
		button.setBackground(new Color(255,153,51));
	}

	//	ham xu ly du lieu
	public void getFlavour(JButton btn) {
		flavour= btn.getText();
	}

	public void pressedFlavour(JButton btn) {
		changeBtnFlavourColor(btn);
		getFlavour(btn);
	}


//	ham xu ly btnTopping

	//	ham doi mau btn
	private void countNumOfTopping(int num) {
		num++;
		if(num>9)
			num=0;
	}


	private void countPearl() {
		this.countPearl++;
		if(countPearl>9)
			countPearl=0;
	}

	private void countPudding() {
		this.countPudding++;
		if(countPudding>9)
			countPudding=0;
	}

	private void countGrassJelly() {
		this.countGrassJelly++;
		if(countGrassJelly>9)
			countGrassJelly=0;
	}

	private void changeBtnToppingColor(JButton btn, int n) {
		if(n==0)
			btn.setBackground(new Color(255, 204, 153));
		else
			btn.setBackground(new Color(255,153,51));

	}


//	ham xu ly btnSize

	//	ham doi mau btn
	private void changeBtnSizesColorToDefault() {
		btnS.setBackground(new Color(255, 204, 153));
		btnM.setBackground(new Color(255, 204, 153));
		btnL.setBackground(new Color(255, 204, 153));

		btnCoffeeS.setBackground(new Color(255, 204, 153));
		btnCoffeeM.setBackground(new Color(255, 204, 153));
		btnCoffeeL.setBackground(new Color(255, 204, 153));
		
		btnJuiceS.setBackground(new Color(255, 204, 153));
		btnJuiceM.setBackground(new Color(255, 204, 153));
		btnJuiceL.setBackground(new Color(255, 204, 153));
	}

	private void changeBtnSizeColor(JButton button) {
		changeBtnSizesColorToDefault();
		button.setBackground(new Color(255,153,51));
	}

	//	ham xu ly du lieu
	public void getSize(JButton btn) {
		size= btn.getText();
	}

	public void pressedSize(JButton btn) {
		changeBtnSizeColor(btn);
		getSize(btn);
	}
	
	
    private void enableEditing(boolean enable) {
        btnRemove.setEnabled(enable);
//        tblProductInfo.setEnabled(enable);
        
//        tblProductInfo.setedi(enable);
//        tblProductInfo.getTableHeader().setReorderingAllowed(enable);
//        tblProductInfo.getTableHeader().setResizingAllowed(enable);
//        tblProductInfo.getColumnModel().setColumnSelectionAllowed(enable);
//        tblProductInfo.getColumnModel().getColumn(0).setResizable(enable);
//        tblProductInfo.getColumnModel().getColumn(1).setResizable(enable);
//        tblProductInfo.getColumnModel().getColumn(2).setResizable(enable);
        
//        model.setRowCount(0);  // Xóa tất cả các hàng trước khi cập nhật chế độ chỉnh sửa
//        model.addRow(new Object[] {"", ""});  // Thêm một hàng trống mới
//        model.setRowCount(model.getRowCount() - 1);  // Xóa hàng trống mới vừa thêm
//        model.fireTableStructureChanged();  // Cập nhật lại cấu trúc bảng
    }
    private void updateTable() {
    	price=0;
		quantityEach=0;
		quantityTotal=0;
		totalPrice=0;
		for(int i=0; i<tblProductInfo.getRowCount();i++) {
			price= (double) tblProductInfo.getValueAt(i, 1);
			quantityEach= (int) tblProductInfo.getValueAt(i, 2);
			price= price*quantityEach;
			quantityTotal+=quantityEach;
			totalPrice+= price;
			
		}
		lblReTotal.setText(quantityTotal+"");
		lblRePrice.setText(totalPrice+"");
    }
    
    private void changeBtnToppingsToDefault() {
    	btnPudding.setBackground(new Color(255, 204, 153));
    	btnPearl.setBackground(new Color(255, 204, 153));
    	btnGrassjelly.setBackground(new Color(255, 204, 153));
    }
    
    private void resetCustom() {
    	countPudding=0;
    	countGrassJelly=0;
    	countPearl=0;
    	lblNumOfGrassJelly.setText(0+"");
    	lblNumOfPearl.setText(0+"");
    	lblNumOfPudding.setText(0+"");
    	
    	changeBtnFlavoursColorToDefault();
    	changeBtnToppingsToDefault();
    	changeBtnSizesColorToDefault();
    	
    }
    
    private void doNothing() {
    	
    }
    

    
//    private void upProduct(double)
}
