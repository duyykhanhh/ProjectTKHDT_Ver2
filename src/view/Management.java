package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import MilkTeaStore.Customer;
import MilkTeaStore.Datee;
import MilkTeaStore.Employee;
import MilkTeaStore.FileRW;
import MilkTeaStore.Ingredient;
import MilkTeaStore.MilkTeaStore;
import MilkTeaStore.RevenueToday;
import MilkTeaStore.RevenueTotal;
import controller.HomeController;
import controller.ManagementController;

import javax.swing.table.TableColumnModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;

public class Management extends JFrame {

	private JPanel pnManagement, pnItem, pnInfo,pnIngr,pnEm, pnCus, pnRevenueToday, pnRevenueTotal;
	private JButton btnIngr;
	private JButton btnEm;
	private JButton btnCus;
	private JButton btnRevenueToday;
	private JButton btnRevenue;
	private JPanel pnIngrTitle, pnTitle, pnEmTitle, pnCusTitle, pnRevenueTodayTitle, pnRevenueTotalTitle;
	private JLabel lblIngr, lblEm, lblCus, lblTitle, lblRevenueToday, lblRevenueTotal;
	private JPanel pntblIngr, pntblEm, pntblCus, pntblRevenueToday, pntblRevenueTotal;
	private DefaultTableModel modelIngr, modelEm, modelCus, modelRevenueToday, modelRevenueTotal;
	Object[][] dataIngr, dataEm, dataCus, dataRevenueToday, dataRevenueTotal;
	private JTable tblIngr, tblEm, tblCus, tblRevenueToday, tblRevenueTotal;
	private JScrollPane spIngr, spEm, spCus, spRevenueToday, spRevenueTotal;
	private JPanel pnIngrBtnEdit,pnEmBtnEdit, pnCusBtnEdit,pnRevenueTotalPrint, pnRevenueTodayPrint;
	private JButton btnAddIngr, btnRevenueTodayPrint, btnRevenueTotalPrint;
	private JButton btnStop;
	private JButton btnOutOf;
	private JPanel panel;
	private JPanel pnAddIngredient;
	private JButton btnFill;
	private JTextField txtNameIngredient;
	private JTextField txtAmount;
	private JLabel lblUnit;
	private JTextField txtUnit;
	private double maxKg=10;
	private double maxLit=40;
	private int maxCan=40;
	private int maxFruit=40;
	private JLabel lblUser;
	private JButton btnUpGradeEm;
	private JPanel pnAddEm;
	private JTextField txtNameEm;
	private JLabel lblNameEm;
	private JLabel lblIdEm;
	private JTextField txtIdEm;
	private JLabel lblPwEm;
	private JPasswordField txtPwEm;
	private JButton btnAddEm;
	private JPanel pnReToday, pnReTotal;
	private JLabel lblNewLabel, lblNewLabel2;
	private JLabel lblMoneyToday, lblMoneyTotal;
	private double reToday=0;
	private double reTotal=0;
	private HomeController home;

	private JPanel pnAddCus;
	private JTextField txtCusId;
	private JPasswordField txtCusPwd;
	private JButton btnAddCus;
	private JButton btnEndDay;
	private JLabel lblReToday;
	private JLabel lblReMoney;
	private JLabel lblReMoneyTotal;
	private MilkTeaStore mn = new MilkTeaStore();
//	private List<Ingredient> ins = mn.getIns();
//	private List<Employee> ems = mn.getEms();
//	private List<Customer> cuses = mn.getCuses();
//	private List<RevenueToday> todays = mn.getTodays();
//	private List<RevenueTotal> totals = mn.getTotals();
	private String urlRoot="";
	
	private String urlEm, urlCus, urlIngre, urlToday, urlTotal;
	
	private FileRW fileEm, fileCus, fileIngre, fileToday, fileTotal;
	private List<Ingredient> ins = new ArrayList<>();
	private List<Employee> ems = new ArrayList<>();
	private List<Customer> cuses = new ArrayList<>();
	private List<RevenueToday> todays = new ArrayList<>();
	private List<RevenueTotal> totals = new ArrayList<>();
	

	


//	private JPanel pnEmTitle;
//	private JLabel lblEms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		
		urlRoot= Home.getUrlRoot();
		urlIngre = urlRoot +"/ingredient";
//		this.fileIngre = new FileRW("src/data/ingredient");
		this.fileIngre = new FileRW(urlIngre);
		ins = this.fileIngre.readIngre();
		mn.setIns(ins);
		urlEm = urlRoot + "/employee";
//		this.fileEm = new FileRW("src/data/employee");
		this.fileEm = new FileRW(urlEm);
		ems = this.fileEm.readEm();
		mn.setEms(ems);
		
		urlCus = urlRoot + "/customer";
//		this.fileCus = new FileRW("src/data/customer");
		this.fileCus = new FileRW(urlCus);
		cuses = this.fileCus.readCus();
		mn.setCuses(cuses);
		
		urlToday = urlRoot + "/revenueToday";
//		this.fileToday = new FileRW("src/data/revenueToday");
		this.fileToday = new FileRW(urlToday);
		todays = this.fileToday.readToday();
		mn.setTodays(todays);
		
		urlTotal = urlRoot + "/revenueTotal";
//		this.fileTotal = new FileRW("src/data/revenueTotal");
		this.fileTotal = new FileRW(urlTotal);
		totals = this.fileTotal.readTotal();
		mn.setTotals(totals);
		
		
		
		
		setTitle("Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1284, 600);
		setLocationRelativeTo(null);
		pnManagement = new JPanel();
		pnManagement.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnManagement);
		pnManagement.setLayout(new BorderLayout(0, 0));
		
		pnInfo = new JPanel();
		pnInfo.setPreferredSize(new Dimension(700,600));
		pnInfo.setMinimumSize(new Dimension(700, 600));
		pnInfo.setMaximumSize(new Dimension(700, 600));
		pnManagement.add(pnInfo, BorderLayout.CENTER);
		pnInfo.setLayout(new CardLayout(0, 0));
		
		pnIngr = new JPanel();
		pnIngr.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		pnInfo.add(pnIngr, "Ingredient");
		pnIngr.setLayout(new BorderLayout(0, 0));
		
		pnIngrTitle = new JPanel();
		pnIngrTitle.setPreferredSize(new Dimension(700,49));
		pnIngrTitle.setMinimumSize(new Dimension(700, 49));
		pnIngrTitle.setMaximumSize(new Dimension(700, 49));
		pnIngr.add(pnIngrTitle, BorderLayout.NORTH);
		
		lblIngr = new JLabel("Ingredient");
		lblIngr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnIngrTitle.add(lblIngr);
		
		pntblIngr = new JPanel();
		pntblIngr.setPreferredSize(new Dimension(700,490));
		pntblIngr.setMinimumSize(new Dimension(700, 490));
		pntblIngr.setMaximumSize(new Dimension(700,490));
		pnIngr.add(pntblIngr, BorderLayout.CENTER);
		
		 dataIngr= new Object[][]{
//			 {"1.Tra sua chan chau", 20000, 4}
		 		
	 };
	 Class[] colTypesIngr = {
			 String.class, Double.class, String.class, Boolean.class
	 };

	String[] ColumnIngr= {
			"Name", "Amount", "Unit", "Stock"
	};


	modelIngr= new DefaultTableModel(dataIngr, ColumnIngr);
	
	this.writeIngreToTable(ins);
	tblIngr= new JTable(modelIngr);
	tblIngr.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	tblIngr.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
	
	TableColumnModel columnModelIngr = tblIngr.getColumnModel();
	columnModelIngr.getColumn(0).setPreferredWidth(240); 
	columnModelIngr.getColumn(1).setPreferredWidth(60);  
	columnModelIngr.getColumn(2).setPreferredWidth(20);   
    
      DefaultTableCellRenderer cellRendererIngr = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int IngrColumn) {
                JTextArea textArea = new JTextArea();
                textArea.setText(value != null ? value.toString() : "");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setBackground(table.getBackground());
                textArea.setFont(table.getFont());

                return textArea;
            }
        };
        tblIngr.getColumnModel().getColumn(0).setCellRenderer(cellRendererIngr);
     
     
     
	 
        tblIngr.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
//			btnPlus.setEnabled(true);
//			btnMinus.setEnabled(true);
//			btnRemove.setEnabled(true);
			
		}
	});

	
	 
        tblIngr.getModel().addTableModelListener(new TableModelListener() {

		
		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
//			updateTable();
		}
		
	});
        pntblIngr.setLayout(new BoxLayout(pntblIngr, BoxLayout.X_AXIS));

        spIngr= new JScrollPane(tblIngr);
//	sp.setBackground(new Color(255, 235, 205));
//        spIngr.setMinimumSize(new Dimension(450, 449));
//        spIngr.setMaximumSize(new Dimension(450, 449));
//        spIngr.setPreferredSize(new Dimension(450, 449));
        pntblIngr.add(spIngr);
        
        pnAddIngredient = new JPanel();
        pnAddIngredient.setMinimumSize(new Dimension(270, 490));
        pnAddIngredient.setMaximumSize(new Dimension(270, 490));
        pnAddIngredient.setPreferredSize(new Dimension(270, 490));
        pntblIngr.add(pnAddIngredient);
        
        JLabel lblNameIngredient = new JLabel("Name");
        
        txtNameIngredient = new JTextField();
        txtNameIngredient.setColumns(10);
        
        JLabel lblAmount = new JLabel("Amount");
        
        txtAmount = new JTextField();
        txtAmount.setColumns(10);
        
        btnAddIngr = new JButton("Add");
//        btnAddIngr.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//    			String name = getTxtNameIngredient().getText();
//    			double amount = Integer.valueOf(txtAmount.getText());
//    			String unit = txtUnit.getText();
//    			modelIngr.addRow(new Object[]{name, amount, unit, true});
//        	}
//        });
        btnAddIngr.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnAddIngr.setMinimumSize(new Dimension(100, 30));
        btnAddIngr.setMaximumSize(new Dimension(100, 30));
        btnAddIngr.setPreferredSize(new Dimension(100, 30));
        btnAddIngr.setBackground(new Color(175, 238, 238));
        
        lblUnit = new JLabel("Unit");
        
        txtUnit = new JTextField();
        txtUnit.setColumns(10);
        GroupLayout gl_pnAddIngredient = new GroupLayout(pnAddIngredient);
        gl_pnAddIngredient.setHorizontalGroup(
        	gl_pnAddIngredient.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnAddIngredient.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnAddIngredient.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNameIngredient, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblAmount, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtNameIngredient, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(50, Short.MAX_VALUE))
        		.addGroup(gl_pnAddIngredient.createSequentialGroup()
        			.addContainerGap(147, Short.MAX_VALUE)
        			.addComponent(btnAddIngr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(23))
        		.addGroup(Alignment.LEADING, gl_pnAddIngredient.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(211, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, gl_pnAddIngredient.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(164, Short.MAX_VALUE))
        );
        gl_pnAddIngredient.setVerticalGroup(
        	gl_pnAddIngredient.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnAddIngredient.createSequentialGroup()
        			.addGap(89)
        			.addComponent(lblNameIngredient)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtNameIngredient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(lblAmount)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(lblUnit)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
        			.addComponent(btnAddIngr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(69))
        );
        pnAddIngredient.setLayout(gl_pnAddIngredient);
        
//        *****************************************
//        Employee
    	pnEm = new JPanel();
    	pnEm.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		pnInfo.add(pnEm, "Employee");
		pnEm.setLayout(new BorderLayout(0, 0));
		
		pnEmTitle = new JPanel();
		pnEmTitle.setPreferredSize(new Dimension(700,70));
		pnEmTitle.setMinimumSize(new Dimension(700, 70));
		pnEmTitle.setMaximumSize(new Dimension(700, 70));
		pnEm.add(pnEmTitle, BorderLayout.NORTH);
		
		lblEm = new JLabel("Employee");
		lblEm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnEmTitle.add(lblEm);
		
		pntblEm = new JPanel();
		pntblEm.setPreferredSize(new Dimension(700,490));
		pntblEm.setMinimumSize(new Dimension(700, 490));
		pntblEm.setMaximumSize(new Dimension(700,490));
		pnEm.add(pntblEm, BorderLayout.CENTER);
		
		 dataEm= new Object[][]{
//			 {"1.Tra sua chan chau", 20000, 4}
		 		
	 };
	 Class[] olTypesEm = {
			 String.class, String.class, Double.class, Boolean.class
	 };

	String[] ColumnEm= {
			"ID", "Name", "Grade", "Working"
	};


	modelEm= new DefaultTableModel(dataEm, ColumnEm);
//  them du lieu vao table employee
	this.writeEmToTable(ems);
	tblEm= new JTable(modelEm);
	tblEm.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	tblEm.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
	
	TableColumnModel columnModelEm = tblEm.getColumnModel();
	columnModelEm.getColumn(0).setPreferredWidth(60); 
	columnModelEm.getColumn(1).setPreferredWidth(240);  
	columnModelEm.getColumn(2).setPreferredWidth(60);   
	columnModelEm.getColumn(3).setPreferredWidth(60);   
    
      DefaultTableCellRenderer cellRendererEm = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int IngrColumn) {
                JTextArea textArea = new JTextArea();
                textArea.setText(value != null ? value.toString() : "");
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setBackground(table.getBackground());
                textArea.setFont(table.getFont());

                return textArea;
            }
        };
        tblEm.getColumnModel().getColumn(0).setCellRenderer(cellRendererEm);
     
     
     
	 
        tblEm.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
//			btnPlus.setEnabled(true);
//			btnMinus.setEnabled(true);
//			btnRemove.setEnabled(true);
			
		}
	});

	
	 
        tblEm.getModel().addTableModelListener(new TableModelListener() {

		
		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
//			updateTable();
		}
		
	});
        
        pntblEm.add(Box.createHorizontalGlue());
        pntblEm.setLayout(new BoxLayout(pntblEm, BoxLayout.X_AXIS));

        spEm= new JScrollPane(tblEm);
//	sp.setBackground(new Color(255, 235, 205));
//        spEm.setMinimumSize(new Dimension(500, 490));
//        spEm.setMaximumSize(new Dimension(500, 490));
//        spEm.setPreferredSize(new Dimension(500, 490));
        pntblEm.add(spEm);

        
        pnAddEm = new JPanel();
        pnAddEm.setPreferredSize(new Dimension(200, 490));
        pnAddEm.setMinimumSize(new Dimension(200, 490));
        pnAddEm.setMaximumSize(new Dimension(200, 490));
        pntblEm.add(pnAddEm);
        
        txtNameEm = new JTextField();
        txtNameEm.setColumns(10);
        
        lblNameEm = new JLabel("Name");
        
        lblIdEm = new JLabel("ID");
        
        txtIdEm = new JTextField();
        txtIdEm.setColumns(10);
        
        lblPwEm = new JLabel("Password");
        
        txtPwEm = new JPasswordField();
        
        btnAddEm = new JButton("Add");
        btnAddEm.setPreferredSize(new Dimension(100, 30));
        btnAddEm.setMinimumSize(new Dimension(100, 30));
        btnAddEm.setMaximumSize(new Dimension(100, 30));
        btnAddEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
        GroupLayout gl_pnAddEm = new GroupLayout(pnAddEm);
        gl_pnAddEm.setHorizontalGroup(
        	gl_pnAddEm.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnAddEm.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnAddEm.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNameEm, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblIdEm, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtIdEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPwEm, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPwEm, 100, 100, 100)
        				.addGroup(gl_pnAddEm.createParallelGroup(Alignment.TRAILING)
        					.addComponent(btnAddEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(txtNameEm, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_pnAddEm.setVerticalGroup(
        	gl_pnAddEm.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnAddEm.createSequentialGroup()
        			.addContainerGap(73, Short.MAX_VALUE)
        			.addComponent(lblNameEm)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtNameEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblIdEm)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtIdEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblPwEm)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtPwEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(123)
        			.addComponent(btnAddEm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(57))
        );
        pnAddEm.setLayout(gl_pnAddEm);
        
        pntblEm.add(Box.createHorizontalGlue());
            
        pnEmBtnEdit = new JPanel();
        pnEm.add(pnEmBtnEdit, BorderLayout.SOUTH);
        
        btnStop = new JButton("Stop");       
        btnStop.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnStop.setMinimumSize(new Dimension(100, 30));
        btnStop.setMaximumSize(new Dimension(100, 30));
        btnStop.setPreferredSize(new Dimension(100, 30));
        pnEmBtnEdit.add(btnStop);
        
        pnEmBtnEdit.add(Box.createHorizontalStrut(30));
        
        btnUpGradeEm = new JButton("Up grade");
        btnUpGradeEm.setPreferredSize(new Dimension(100, 30));
        btnUpGradeEm.setMinimumSize(new Dimension(100, 30));
        btnUpGradeEm.setMaximumSize(new Dimension(100, 30));
        btnUpGradeEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnEmBtnEdit.add(btnUpGradeEm);
        
//      *****************************************
//      Customer
        pnCus = new JPanel();
        pnCus.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		pnInfo.add(pnCus, "Customer");
		pnCus.setLayout(new BorderLayout(0, 0));
		
		pnCusTitle = new JPanel();
		pnCusTitle.setPreferredSize(new Dimension(700,70));
		pnCusTitle.setMinimumSize(new Dimension(700, 70));
		pnCusTitle.setMaximumSize(new Dimension(700, 70));
		pnCus.add(pnCusTitle, BorderLayout.NORTH);
		
		lblCus = new JLabel("Customer");
		lblCus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnCusTitle.add(lblCus);
		
		pntblCus = new JPanel();
		pntblCus.setPreferredSize(new Dimension(700,490));
		pntblCus.setMinimumSize(new Dimension(700, 490));
		pntblCus.setMaximumSize(new Dimension(700,490));
		pnCus.add(pntblCus, BorderLayout.CENTER);
		
		 dataCus= new Object[][]{

		 		
	 };
	 Class[] colTypesCus = {
			 String.class, Integer.class
	 };

	String[] ColumnCus= {
			"ID", "Point"
	};


	modelCus= new DefaultTableModel(dataCus, ColumnCus);
	
	this.writeCusToTable(cuses);
	
	tblCus= new JTable(modelCus);
	tblCus.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	tblCus.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
	
	TableColumnModel columnModelCus = tblCus.getColumnModel();
//	columnModelCus.getColumn(0).setPreferredWidth(40); 
//	columnModelCus.getColumn(1).setPreferredWidth(240);  
//	columnModelCus.getColumn(2).setPreferredWidth(100);   
//	columnModelCus.getColumn(3).setPreferredWidth(200);   
//	columnModelCus.getColumn(4).setPreferredWidth(20);   
  
    DefaultTableCellRenderer cellRendererCus = new DefaultTableCellRenderer() {
          @Override
          public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int IngrColumn) {
              JTextArea textArea = new JTextArea();
              textArea.setText(value != null ? value.toString() : "");
              textArea.setLineWrap(true);
              textArea.setWrapStyleWord(true);
              textArea.setBackground(table.getBackground());
              textArea.setFont(table.getFont());

              return textArea;
          }
      };
      tblCus.getColumnModel().getColumn(0).setCellRenderer(cellRendererCus);
   
   
   
	 
      tblCus.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
//			btnPlus.setEnabled(true);
//			btnMinus.setEnabled(true);
//			btnRemove.setEnabled(true);
			
		}
	});

	
	 
      tblCus.getModel().addTableModelListener(new TableModelListener() {

		
		@Override
		public void tableChanged(TableModelEvent e) {
			// TODO Auto-generated method stub
//			updateTable();
		}
		
	});

      spCus= new JScrollPane(tblCus);
//	sp.setBackground(new Color(255, 235, 205));
//      spIngr.setMinimumSize(new Dimension(600, 490));
//      spIngr.setMaximumSize(new Dimension(600, 490));
//      spIngr.setPreferredSize(new Dimension(600, 490));
      pntblCus.add(spCus);
      
      pnAddCus = new JPanel(); 
      pnAddCus.setMinimumSize(new Dimension(300, 300));
      pnAddCus.setMaximumSize(new Dimension(300, 300));
      pnAddCus.setPreferredSize(new Dimension(300, 300));
      pntblCus.add(pnAddCus);
      
      
      
      JLabel lblCusId = new JLabel("ID");
      
      txtCusId = new JTextField();
      txtCusId.setColumns(10);
      
      JLabel lblCusPwd = new JLabel("Password");
      
      txtCusPwd = new JPasswordField();
      
      btnAddCus = new JButton("Add");
      btnAddCus.setPreferredSize(new Dimension(100, 30));
      btnAddCus.setMinimumSize(new Dimension(100, 30));
      btnAddCus.setMaximumSize(new Dimension(100, 30));
      btnAddCus.setFont(new Font("Tahoma", Font.PLAIN, 17));
      GroupLayout gl_pnAddCus = new GroupLayout(pnAddCus);
      gl_pnAddCus.setHorizontalGroup(
      	gl_pnAddCus.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_pnAddCus.createSequentialGroup()
      			.addContainerGap(155, Short.MAX_VALUE)
      			.addComponent(btnAddCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      			.addGap(45))
      		.addGroup(Alignment.LEADING, gl_pnAddCus.createSequentialGroup()
      			.addGap(43)
      			.addGroup(gl_pnAddCus.createParallelGroup(Alignment.LEADING, false)
      				.addComponent(lblCusPwd, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
      				.addComponent(lblCusId, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
      				.addComponent(txtCusPwd, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
      				.addComponent(txtCusId))
      			.addContainerGap(133, Short.MAX_VALUE))
      );
      gl_pnAddCus.setVerticalGroup(
      	gl_pnAddCus.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_pnAddCus.createSequentialGroup()
      			.addGap(75)
      			.addComponent(lblCusId)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addComponent(txtCusId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      			.addGap(18)
      			.addComponent(lblCusPwd)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addComponent(txtCusPwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
      			.addComponent(btnAddCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      			.addGap(34))
      );
      pnAddCus.setLayout(gl_pnAddCus);
      
  
     
      
      pnCusBtnEdit = new JPanel();
      pnCus.add(pnCusBtnEdit, BorderLayout.SOUTH);
      
//    *****************************************
//    RevenueToday
      pnRevenueToday = new JPanel();
		pnInfo.add(pnRevenueToday, "RevenueToday");
		pnRevenueToday.setLayout(new BorderLayout(0, 0));
		
		pnRevenueTodayTitle = new JPanel();
		pnRevenueTodayTitle.setPreferredSize(new Dimension(700,70));
		pnRevenueTodayTitle.setMinimumSize(new Dimension(700, 70));
		pnRevenueTodayTitle.setMaximumSize(new Dimension(700, 70));
		pnRevenueToday.add(pnRevenueTodayTitle, BorderLayout.NORTH);
		pnRevenueToday.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		
		lblRevenueToday = new JLabel("Revenue Today");
		lblRevenueToday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRevenueTodayTitle.add(lblRevenueToday);


		pntblRevenueToday = new JPanel();
				pntblRevenueToday.setPreferredSize(new Dimension(700,490));
				pntblRevenueToday.setMinimumSize(new Dimension(700, 490));
				pntblRevenueToday.setMaximumSize(new Dimension(700,490));
				pnRevenueToday.add(pntblRevenueToday, BorderLayout.CENTER);
				
				 dataRevenueToday= new Object[][]{
//					 {"1.Tra sua chan chau", 20000, 4}
				 		
			 };
			 Class[] colTypesRevenueToday = {
					 String.class, Double.class
			 };

			String[] ColumnRevenueToday= {
					"Time", "Total"
			};


			modelRevenueToday= new DefaultTableModel(dataRevenueToday, ColumnRevenueToday);
			
			this.writeTodayToTable(todays);
			tblRevenueToday= new JTable(modelRevenueToday);
			tblRevenueToday.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			tblRevenueToday.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
			
//			TableColumnModel columnModelRevenueToday = tblRevenueToday.getColumnModel();
//			columnModelRevenueToday.getColumn(0).setPreferredWidth(40); 
//			columnModelRevenueToday.getColumn(1).setPreferredWidth(240);  
//			columnModelRevenueToday.getColumn(2).setPreferredWidth(100);   
//			columnModelRevenueToday.getColumn(3).setPreferredWidth(200);   
//			columnModelRevenueToday.getColumn(4).setPreferredWidth(20);   

		  DefaultTableCellRenderer cellRendererRevenueToday = new DefaultTableCellRenderer() {
		        @Override
		        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFoRevenueToday, int row, int IngrColumn) {
		            JTextArea textArea = new JTextArea();
		            textArea.setText(value != null ? value.toString() : "");
		            textArea.setLineWrap(true);
		            textArea.setWrapStyleWord(true);
		            textArea.setBackground(table.getBackground());
		            textArea.setFont(table.getFont());

		            return textArea;
		        }
		    };
		    tblRevenueToday.getColumnModel().getColumn(0).setCellRenderer(cellRendererRevenueToday);
		 
		 
		 
			 
		    tblRevenueToday.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
//					btnPlus.setEnabled(true);
//					btnMinus.setEnabled(true);
//					btnRemove.setEnabled(true);
					
				}
			});

			
			 
		    tblRevenueToday.getModel().addTableModelListener(new TableModelListener() {

				
				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
					updateTbltRevenueToday();
				}
				
			});

		    spRevenueToday= new JScrollPane(tblRevenueToday);
//			sp.setBackground(new Color(255, 235, 205));
//		    spIngr.setMinimumSize(new Dimension(600, 490));
//		    spIngr.setMaximumSize(new Dimension(600, 490));
//		    spIngr.setPreferredSize(new Dimension(600, 490));
		    pntblRevenueToday.add(spRevenueToday);
		    
		    pnReToday = new JPanel();
		      pnReToday.setPreferredSize(new Dimension(200,400));
		      pnReToday.setMinimumSize(new Dimension(200, 400));
		      pnReToday.setMaximumSize(new Dimension(200, 400));
		      pntblRevenueToday.add(pnReToday);
		      pnReToday.setLayout(new BoxLayout(pnReToday, BoxLayout.Y_AXIS));
		      
		      pnReToday.add(Box.createVerticalGlue());
		      
		      lblNewLabel = new JLabel("Today:");
		      lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		      lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		      pnReToday.add(lblNewLabel);
		      
		      lblReToday = new JLabel("today");
		      lblReToday.setFont(new Font("Tahoma", Font.PLAIN, 14));
		      lblReToday.setAlignmentX(Component.CENTER_ALIGNMENT);
		      pnReToday.add(lblReToday);
		      
		      pnReToday.add(Box.createVerticalStrut(30));
		      
		      lblMoneyToday = new JLabel("Money");
		      lblMoneyToday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		      lblMoneyToday.setAlignmentX(Component.CENTER_ALIGNMENT);
		      pnReToday.add(lblMoneyToday);
		      
		      lblReMoney = new JLabel("0 VN\u0110");
		      lblReMoney.setAlignmentX(Component.CENTER_ALIGNMENT);
		      lblReMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		      pnReToday.add(lblReMoney);
		      
		      pnReToday.add(Box.createVerticalStrut(90));
		      
		      btnEndDay = new JButton("End day");
		      btnEndDay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		      btnEndDay.setMinimumSize(new Dimension(100, 30));
		      btnEndDay.setMaximumSize(new Dimension(100, 30));
		      btnEndDay.setPreferredSize(new Dimension(100, 30));
		      btnEndDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		      pnReToday.add(btnEndDay);
		      
		      pnReToday.add(Box.createVerticalGlue());
		       
            pnRevenueTodayPrint = new JPanel();
            pnRevenueToday.add(pnRevenueTodayPrint, BorderLayout.SOUTH);


//		            *****************************************
//		            RevenueTotal
		        	pnRevenueTotal = new JPanel();
		        	pnRevenueTotal.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		    		pnInfo.add(pnRevenueTotal, "Revenue");
		    		pnRevenueTotal.setLayout(new BorderLayout(0, 0));
		    		
		    		pnRevenueTotalTitle = new JPanel();
		    		pnRevenueTotalTitle.setPreferredSize(new Dimension(700,70));
		    		pnRevenueTotalTitle.setMinimumSize(new Dimension(700, 70));
		    		pnRevenueTotalTitle.setMaximumSize(new Dimension(700, 70));
		    		pnRevenueTotal.add(pnRevenueTotalTitle, BorderLayout.NORTH);
		    		
		    		lblRevenueTotal = new JLabel("Revenue Total");
		    		lblRevenueTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		    		pnRevenueTotalTitle.add(lblRevenueTotal);
		    		
		    		pntblRevenueTotal = new JPanel();
		    		pntblRevenueTotal.setPreferredSize(new Dimension(700,490));
		    		pntblRevenueTotal.setMinimumSize(new Dimension(700, 490));
		    		pntblRevenueTotal.setMaximumSize(new Dimension(700,490));
		    		pnRevenueTotal.add(pntblRevenueTotal, BorderLayout.CENTER);
		    		
		    		 dataRevenueTotal= new Object[][]{
//		    			 {"1.Tra sua chan chau", 20000, 4}
		    		 		
		    	 };
		    	 Class[] olTypesRevenueTotal = {
		    			 String.class, String.class
		    	 };

		    	String[] ColumnRevenueTotal= {
		    			"Date", "Revenue"
		    	};


		    	modelRevenueTotal= new DefaultTableModel(dataRevenueTotal, ColumnRevenueTotal);
		    	
		    	this.writeTotalToTable(totals);
		    	tblRevenueTotal= new JTable(modelRevenueTotal);
		    	tblRevenueTotal.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		    	tblRevenueTotal.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
		    	
		    	TableColumnModel columnModelRevenueTotal = tblRevenueTotal.getColumnModel();
		    	columnModelRevenueTotal.getColumn(0).setPreferredWidth(240); 
		    	columnModelRevenueTotal.getColumn(1).setPreferredWidth(100);  
//		    	columnModelRevenueTotal.getColumn(2).setPreferredWidth(20);   
		        
		          DefaultTableCellRenderer cellRendererRevenueTotal = new DefaultTableCellRenderer() {
		                @Override
		                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int IngrColumn) {
		                    JTextArea textArea = new JTextArea();
		                    textArea.setText(value != null ? value.toString() : "");
		                    textArea.setLineWrap(true);
		                    textArea.setWrapStyleWord(true);
		                    textArea.setBackground(table.getBackground());
		                    textArea.setFont(table.getFont());

		                    return textArea;
		                }
		            };
		            tblRevenueTotal.getColumnModel().getColumn(0).setCellRenderer(cellRendererRevenueTotal);
		         
		         
		         
		    	 
				    tblRevenueTotal.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
						
						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
//							btnPlus.setEnabled(true);
//							btnMinus.setEnabled(true);
//							btnRemove.setEnabled(true);
							
						}
					});

					
					 
				    tblRevenueTotal.getModel().addTableModelListener(new TableModelListener() {

						
						@Override
						public void tableChanged(TableModelEvent e) {
							// TODO Auto-generated method stub
							updateTbltRevenueTotal();
						}
						
					});

		            spRevenueTotal= new JScrollPane(tblRevenueTotal);
//		    	sp.setBackground(new Color(255, 235, 205));
//		            spIngr.setMinimumSize(new Dimension(600, 490));
//		            spIngr.setMaximumSize(new Dimension(600, 490));
//		            spIngr.setPreferredSize(new Dimension(600, 490));
		            pntblRevenueTotal.add(spRevenueTotal);
		            
				    pnReTotal = new JPanel();
				    pnReTotal.setPreferredSize(new Dimension(200,400));
				    pnReTotal.setMinimumSize(new Dimension(200, 400));
				    pnReTotal.setMaximumSize(new Dimension(200, 400));
		            pntblRevenueTotal.add(pnReTotal);
				     pnReTotal.setLayout(new BoxLayout(pnReTotal, BoxLayout.Y_AXIS));
		     
		            
				      pnReTotal.add(Box.createVerticalGlue());
				      
				      lblNewLabel2 = new JLabel("Total:");
				      lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				      lblNewLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
				      pnReTotal.add(lblNewLabel2);
				      
				      pnReTotal.add(Box.createVerticalStrut(30));
				      
				      lblMoneyTotal = new JLabel("Money");
				      lblMoneyTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
				      lblMoneyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
				      pnReTotal.add(lblMoneyTotal);
				      
				      lblReMoneyTotal = new JLabel("0 VN\u0110");
				      lblReMoneyTotal.setAlignmentX(Component.CENTER_ALIGNMENT);
				      lblReMoneyTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
				      pnReTotal.add(lblReMoneyTotal);
				      
				      pnReTotal.add(Box.createVerticalGlue());
		                
		            pnRevenueTotalPrint = new JPanel();
		            pnRevenueTotal.add(pnRevenueTotalPrint, BorderLayout.SOUTH);
        
        
        
        
        pnIngrBtnEdit = new JPanel();
        pnIngrBtnEdit.setMinimumSize(new Dimension(100, 49));
        pnIngrBtnEdit.setMaximumSize(new Dimension(100, 49));
        pnIngrBtnEdit.setPreferredSize(new Dimension(100, 49));
        pnIngr.add(pnIngrBtnEdit, BorderLayout.SOUTH);
        
        
        btnOutOf = new JButton("Out of");
//        btnOutOf.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        	}
//        });
        btnOutOf.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnOutOf.setPreferredSize(new Dimension(100, 30));
        btnOutOf.setMinimumSize(new Dimension(100, 30));
        btnOutOf.setMaximumSize(new Dimension(100, 30));
        pnIngrBtnEdit.add(btnOutOf);
        
        pnIngrBtnEdit.add(Box.createHorizontalStrut(30));
        
	      btnFill = new JButton("Fill");
	      btnFill.setPreferredSize(new Dimension(100, 30));
	      btnFill.setMinimumSize(new Dimension(100, 30));
	      btnFill.setMaximumSize(new Dimension(100, 30));
	      btnFill.setFont(new Font("Tahoma", Font.PLAIN, 17));
	      pnIngrBtnEdit.add(btnFill);
	      
        
	
		pnItem = new JPanel();
		pnItem.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		pnItem.setMinimumSize(new Dimension(400, 600));
		pnItem.setMaximumSize(new Dimension(400, 600));
		pnItem.setPreferredSize(new Dimension(400, 600));
		pnManagement.add(pnItem, BorderLayout.EAST);
		pnItem.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnItem.setLayout(new BoxLayout(pnItem, BoxLayout.Y_AXIS));
		
		pnItem.add(Box.createVerticalGlue());
		
		lblUser = new JLabel("root");
//		String temp = this.home.getUser();
//		lblUser.setText(temp);
		lblUser.setForeground(new Color(0, 0, 255));
		lblUser.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnItem.add(lblUser);
		
//		lblUser.setText(home.getUser());		
		
		

		
		pnItem.add(Box.createVerticalStrut(20));
		
		btnIngr = new JButton("Ingredient");
//		btnIngr.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pressedBtnItem(btnIngr);
//				
//			}
//		});
		btnIngr.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnIngr.setMinimumSize(new Dimension(140, 40));
		btnIngr.setMaximumSize(new Dimension(140, 40));
		btnIngr.setPreferredSize(new Dimension(140, 40));
		btnIngr.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnItem.add(btnIngr);
		
		pnItem.add(Box.createVerticalStrut(30));
		
		btnEm = new JButton("Employee");
//		btnEm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pressedBtnItem(btnEm);
//			}
//		});

		btnEm.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEm.setPreferredSize(new Dimension(140, 40));
		btnEm.setMinimumSize(new Dimension(140, 40));
		btnEm.setMaximumSize(new Dimension(140, 40));
		btnEm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnItem.add(btnEm);
		
		pnItem.add(Box.createVerticalStrut(30));

		
		btnCus = new JButton("Customer");
//		btnCus.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pressedBtnItem(btnCus);
//			}
//		});
		btnCus.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCus.setPreferredSize(new Dimension(140, 40));
		btnCus.setMinimumSize(new Dimension(140, 40));
		btnCus.setMaximumSize(new Dimension(140, 40));
		btnCus.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnItem.add(btnCus);
		
		
		pnItem.add(Box.createVerticalStrut(30));

		btnRevenueToday = new JButton("RevenueToday");
//		btnRevenueToday.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pressedBtnItem(btnRevenueToday);
//			}
//		});
		btnRevenueToday.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRevenueToday.setPreferredSize(new Dimension(140, 40));
		btnRevenueToday.setMinimumSize(new Dimension(140, 40));
		btnRevenueToday.setMaximumSize(new Dimension(140, 40));
		btnRevenueToday.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnItem.add(btnRevenueToday);
		
		pnItem.add(Box.createVerticalStrut(30));

		
		btnRevenue = new JButton("Revenue");
//		btnRevenue.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				pressedBtnItem(btnRevenue);
//			}
//		});
		
		btnRevenue.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRevenue.setPreferredSize(new Dimension(140, 40));
		btnRevenue.setMinimumSize(new Dimension(140, 40));
		btnRevenue.setMaximumSize(new Dimension(140, 40));
		btnRevenue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnItem.add(btnRevenue);
		
		
		pnItem.add(Box.createVerticalGlue());
	
		
	    btnRevenueTodayPrint = new JButton("Print");
	    btnRevenueTodayPrint.setFont(new Font("Tahoma", Font.PLAIN, 17));
	    btnRevenueTodayPrint.setMinimumSize(new Dimension(100, 30));
	    btnRevenueTodayPrint.setMaximumSize(new Dimension(100, 30));
	    btnRevenueTodayPrint.setPreferredSize(new Dimension(100, 30));
	    pnRevenueTodayPrint.add(btnRevenueTodayPrint);
	      
	      btnRevenueTotalPrint = new JButton("Print");
	      btnRevenueTotalPrint.setFont(new Font("Tahoma", Font.PLAIN, 17));
	      btnRevenueTotalPrint.setMinimumSize(new Dimension(100, 30));
	      btnRevenueTotalPrint.setMaximumSize(new Dimension(100, 30));
	      btnRevenueTotalPrint.setPreferredSize(new Dimension(100, 30));
	      pnRevenueTotalPrint.add(btnRevenueTotalPrint);
	
//	      dat mau nen
	      setPanelBackground(pnManagement, new Color(240, 255, 255));
	      btnIngr.setBackground(new Color(0, 139, 139));
	     
	      
	      ActionListener ac = new ManagementController(this);
	      btnIngr.addActionListener(ac);
	      btnEm.addActionListener(ac);
	      btnCus.addActionListener(ac);
	      btnRevenueToday.addActionListener(ac);
	      btnRevenue.addActionListener(ac);
	      btnAddIngr.addActionListener(ac);
	      btnOutOf.addActionListener(ac);
	      btnFill.addActionListener(ac);
	      btnUpGradeEm.addActionListener(ac);
	      btnStop.addActionListener(ac);
	      btnAddEm.addActionListener(ac);
	      btnAddCus.addActionListener(ac);
	      btnRevenueTodayPrint.addActionListener(ac);
	      btnEndDay.addActionListener(ac);
	      btnRevenueTotalPrint.addActionListener(ac);
	      
	      
	      MouseListener mlis = new ManagementController(this);
	      btnAddIngr.addMouseListener(mlis);
	      btnOutOf.addMouseListener(mlis);
	      btnFill.addMouseListener(mlis);
	      btnAddEm.addMouseListener(mlis);
	      btnAddCus.addMouseListener(mlis);
	      btnUpGradeEm.addMouseListener(mlis);
	      btnStop.addMouseListener(mlis);
	      btnRevenueTodayPrint.addMouseListener(mlis);
	      btnEndDay.addMouseListener(mlis);
	      btnRevenueTotalPrint.addMouseListener(mlis);

	      

	}
	
	//	ham dat mau nen
	public static void setPanelBackground(JPanel panel, Color color) {
		panel.setBackground(color);
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JPanel) {
				setPanelBackground((JPanel)component, color);
			}
			if(component instanceof JButton)
				component.setBackground(new Color(175, 238, 238));
		}
	}
	
	public void changeBtnItemsToDefault() {
		btnIngr.setBackground(new Color(175, 238, 238));
		btnEm.setBackground(new Color(175, 238, 238));
		btnCus.setBackground(new Color(175, 238, 238));
		btnRevenueToday.setBackground(new Color(175, 238, 238));
		btnRevenue.setBackground(new Color(175, 238, 238));
		btnIngr.setForeground(new Color(0, 0, 0));
		btnEm.setForeground(new Color(0, 0, 0));
		btnCus.setForeground(new Color(0, 0, 0));
		btnRevenueToday.setForeground(new Color(0, 0, 0));
		btnRevenue.setForeground(new Color(0, 0, 0));
	}
	
	public void changeBtnItem(JButton btn) {
		changeBtnItemsToDefault();
		btn.setBackground(new Color(0, 139, 139));
		btn.setForeground(new Color(255, 255, 240));
	}
	
	public void pressedBtnItem(JButton btn) {
		changeBtnItem(btn);
		JButton btnTemp;
		CardLayout cardLayout = (CardLayout) pnInfo.getLayout();
		String str= btn.getText();
		cardLayout.show(pnInfo, str);
	}
	
	public void hoverIn(JButton btn) {
		btn.setBackground(new Color(0, 139, 139));
		btn.setForeground(new Color(255, 255, 240));
	}
	
	public void hoverOut(JButton btn) {
		btn.setBackground(new Color(175, 238, 238));
		btn.setForeground(new Color(0, 0, 0));
	}
	
    private void updateTbltRevenueToday() {
    	
		
		reToday=0;

		
		for(int i=0; i<tblRevenueToday.getRowCount();i++) {
			double temp= (double) tblRevenueToday.getValueAt(i, 1);
			reToday+=temp;
		
		}
		lblRevenueToday.setText(reToday+"");
    }
    
    private void updateTbltRevenueTotal() {
    	
		
 		reTotal=0;

 		
 		for(int i=0; i<tblRevenueToday.getRowCount();i++) {
 			double temp= (double) tblRevenueToday.getValueAt(i, 1);
 			reTotal+=temp;
 		
 		}
 		lblRevenueTotal.setText(reTotal+"");
     }


	public JButton getBtnIngr() {
		return btnIngr;
	}

	public JButton getBtnEm() {
		return btnEm;
	}

	public JButton getBtnCus() {
		return btnCus;
	}

	public JButton getBtnRevenueToday() {
		return btnRevenueToday;
	}

	public JButton getBtnRevenue() {
		return btnRevenue;
	}


	public JLabel getLblIngr() {
		return lblIngr;
	}

	public JLabel getLblEm() {
		return lblEm;
	}

	public JLabel getLblCus() {
		return lblCus;
	}

	public JLabel getLblTitle() {
		return lblTitle;
	}

	public JLabel getLblRevenueToday() {
		return lblRevenueToday;
	}

	public JLabel getLblRevenueTotal() {
		return lblRevenueTotal;
	}



	public DefaultTableModel getModelIngr() {
		return modelIngr;
	}

	public DefaultTableModel getModelEm() {
		return modelEm;
	}

	public DefaultTableModel getModelCus() {
		return modelCus;
	}

	public DefaultTableModel getModelRevenueToday() {
		return modelRevenueToday;
	}

	public DefaultTableModel getModelRevenueTotal() {
		return modelRevenueTotal;
	}

	public Object[][] getDataIngr() {
		return dataIngr;
	}

	public Object[][] getDataEm() {
		return dataEm;
	}

	public Object[][] getDataCus() {
		return dataCus;
	}

	public Object[][] getDataRevenueToday() {
		return dataRevenueToday;
	}

	public Object[][] getDataRevenueTotal() {
		return dataRevenueTotal;
	}

	public JTable getTblIngr() {
		return tblIngr;
	}

	public JTable getTblEm() {
		return tblEm;
	}

	public JTable getTblCus() {
		return tblCus;
	}

	public JTable getTblRevenueToday() {
		return tblRevenueToday;
	}

	public JTable getTblRevenueTotal() {
		return tblRevenueTotal;
	}

	public JScrollPane getSpIngr() {
		return spIngr;
	}

	public JScrollPane getSpEm() {
		return spEm;
	}

	public JScrollPane getSpCus() {
		return spCus;
	}

	public JScrollPane getSpRevenueToday() {
		return spRevenueToday;
	}

	public JScrollPane getSpRevenueTotal() {
		return spRevenueTotal;
	}

	public JPanel getPnIngrBtnEdit() {
		return pnIngrBtnEdit;
	}

	public JPanel getPnEmBtnEdit() {
		return pnEmBtnEdit;
	}

	public JPanel getPnCusBtnEdit() {
		return pnCusBtnEdit;
	}

	public JPanel getPnRevenueTotalPrint() {
		return pnRevenueTotalPrint;
	}

	public JPanel getPnRevenueTodayPrint() {
		return pnRevenueTodayPrint;
	}

	public JButton getBtnAddIngr() {
		return btnAddIngr;
	}

	public JButton getBtnAddEm() {
		return btnAddEm;
	}

	public JButton getBtnRevenueTodayPrint() {
		return btnRevenueTodayPrint;
	}

	public JButton getBtnRevenueTotalPrint() {
		return btnRevenueTotalPrint;
	}

	public JButton getBtnStop() {
		return btnStop;
	}


	public JButton getBtnOutOf() {
		return btnOutOf;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JPanel getPnAddIngredient() {
		return pnAddIngredient;
	}

	public JButton getBtnFill() {
		return btnFill;
	}

	public JTextField getTxtNameIngredient() {
		return txtNameIngredient;
	}

	public JTextField getTxtAmount() {
		return txtAmount;
	}

	public JLabel getLblUnit() {
		return lblUnit;
	}

	public JTextField getTxtUnit() {
		return txtUnit;
	}
	
	public double getMaxKg() {
		return maxKg;
	}
	
	public double getMaxLit() {
		return maxLit;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public JPanel getPnAddEm() {
		return pnAddEm;
	}

	public JLabel getLblNameEm() {
		return lblNameEm;
	}

	public JTextField getTxtNameEm() {
		return txtNameEm;
	}

	public JLabel getLblIdEm() {
		return lblIdEm;
	}

	public JTextField getTxtIdEm() {
		return txtIdEm;
	}

	public JLabel getLblPwEm() {
		return lblPwEm;
	}

	

	public JPasswordField getTxtPwEm() {
		return txtPwEm;
	}



	public JButton getBtnUpGradeEm() {
		return btnUpGradeEm;
	}
	
	public void setLblUser() {
		Home home = new Home();
		String user = home.getTxtID().getText();
		this.lblUser.setText(user);
	}
	
	public void writeIngreToTable(List<Ingredient> ins) {
		for(Ingredient in : ins) {
			String name = in.getName();
			double amount = in.getAmount();
			String unit = in.getUnit();
			boolean stock = in.isStock();
			this.modelIngr.addRow(new Object[] {name, amount, unit, stock});
			
		}
	}
	
	public void addIngre(Ingredient in) {
		this.ins.add(in);
		this.fileIngre.writeIngre(in);
	}
	
	public void fillIngre(Ingredient in) {
		String unit = in.getUnit();
		if(unit.equals("kg")) {
			in.setAmount(maxKg);
		}
			
		else if(unit.equals("L")) {
			in.setAmount(maxLit);
		}
			
		else if(unit.equals("can")) {
			in.setAmount(maxCan);
		}
		
		else if(unit.equals("fruit")) {
			in.setAmount(maxFruit);
		}
		
		for(Ingredient ingre : mn.getIns())
			if(ingre.equals(in))
				ingre.setStock(true);
		ins = mn.getIns();
		fileIngre.writeIngreNew(ins.get(0));
		for(int i =1; i<ins.size();i++) {
			fileIngre.writeIngre(ins.get(i));
		}
		
			
		
	}
	
	public void outOfIn(Ingredient in) {
		for(Ingredient ingre : mn.getIns())
			if(ingre.equals(in))
				ingre.setStock(false);
		ins = mn.getIns();
		fileIngre.writeIngreNew(ins.get(0));
		for(int i =1; i<ins.size();i++) {
			fileIngre.writeIngre(ins.get(i));
		}
	}
	
	public void writeEmToTable(List<Employee> ems) {
//		ems = this.file.readEm();
		for(Employee em : ems) {
			String id = em.getEmID();
			String name = em.getEmName();
			int grade = em.getEmGrade();
			boolean isWorking = em.isWork();
			this.modelEm.addRow(new Object[]{id,name,grade,isWorking});
		}

	}
	public boolean checkExistedEm(String id) {
		for(Employee em : mn.getEms()) {
			if(em.getEmID().equalsIgnoreCase(id))
				return true;
			
		}
		
		return false;
	}
	
	
	public void addEm(Employee em) {
		this.ems.add(em);
		this.fileEm.writeEm(em);
	}
	
	public void stopEm(Employee em) {
		em.setWork(false);
		ems = mn.getEms();
		fileEm.reWriteEm(ems);
		
	}
	
	public void upgradeEm(Employee em, int newGrade) {
		em.setEmGrade(newGrade);
		ems = mn.getEms();
		fileEm.reWriteEm(ems);
	}
	

	
	public void writeCusToTable(List<Customer> cuses) {
		for(Customer cus : cuses) {
			String id = cus.getCusId();
			int point = cus.getPoint();
			this.modelCus.addRow(new Object[] {id,point});
		}
	}
	
	public boolean checkExistedCus(String id) {
		for(Customer cus : mn.getCuses()) {
			if(cus.getCusId().equalsIgnoreCase(id))
				return true;
			
		}
		
		return false;
	}
	
	public void addCus(Customer cus) {
		this.cuses.add(cus);
		this.fileCus.writeCus(cus);
	}
	
	

	
	
	public void writeTodayToTable(List<RevenueToday> todays) {
		for(RevenueToday today : todays) {			
			String timee = today.getTime().toString();
			double money = today.getMoney();
			this.modelRevenueToday.addRow(new Object[] {timee,money});
		}
	}
	
	
	public void writeNewDayToTable() {
		todays.removeAll(todays);
		this.fileToday.writeNewRevenueDay();
		todays = fileToday.readToday();
		this.modelRevenueToday.setRowCount(0);
		this.lblReMoney.setText("0 VND");
		writeTodayToTable(todays);
		
	
	}
	
	public void writeTotalToTable(List<RevenueTotal> totals) {
		for(RevenueTotal total : totals) {			
			String datee = total.getDate().toString();
			double money = total.getTotal();
			this.modelRevenueTotal.addRow(new Object[] {datee,money});
		}
	}

	public double totalMoneyOfDay() {
		double money=0;
		for(RevenueToday today : todays) {
			money = money + today.getMoney();
		}
		return money;
		
	}
	
	public Datee getDateToday() {
		return new Datee();
	}
	
	public void endDay() {
		RevenueTotal total = new RevenueTotal(this.getDateToday(), this.totalMoneyOfDay());
		this.totals.add(total);
		this.fileTotal.writeRevenueTotal(total);
		String date = total.getDate().toString();
		double money = total.getTotal();
		this.modelRevenueTotal.addRow(new Object[] {date, money});
		this.writeNewDayToTable();
		
		
	}
	
	public double totalMoney() {
		double money=0;
		for(RevenueTotal total : totals) {
			money = money + total.getTotal();
		}
		
		return money;
	}
	
	public boolean isNewDate() {
		RevenueTotal total = totals.get(totals.size()-1);
		String day1 = total.getDate().toString();
		String day2 = this.lblReToday.getText();
		if(day1.equals(day2))
			return false;
		else
			return true;
	}
	
	
	
	public void setTxtCusId(JTextField txtCusId) {
		this.txtCusId = txtCusId;
	}

	public void setTxtCusPwd(JPasswordField txtCusPwd) {
		this.txtCusPwd = txtCusPwd;
	}

	public JButton getBtnAddCus() {
		return btnAddCus;
	}

	public void setBtnAddCus(JButton btnAddCus) {
		this.btnAddCus = btnAddCus;
	}

	public JPanel getPnReToday() {
		return pnReToday;
	}

	public JPanel getPnReTotal() {
		return pnReTotal;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JLabel getLblNewLabel2() {
		return lblNewLabel2;
	}

	public JLabel getLblMoneyToday() {
		return lblMoneyToday;
	}

	public JLabel getLblMoneyTotal() {
		return lblMoneyTotal;
	}

	public double getReToday() {
		return reToday;
	}

	public double getReTotal() {
		return reTotal;
	}

	public HomeController getHome() {
		return home;
	}

	public List<Employee> getEms() {
		return ems;
	}

	public List<Customer> getCuses() {
		return cuses;
	}

	public FileRW getFileEm() {
		return fileEm;
	}

	public FileRW getFileCus() {
		return fileCus;
	}

	public JPanel getPnAddCus() {
		return pnAddCus;
	}

	public JTextField getTxtCusId() {
		return txtCusId;
	}

	public JPasswordField getTxtCusPwd() {
		return txtCusPwd;
	}

	public int getMaxCan() {
		return maxCan;
	}

	public int getMaxFruit() {
		return maxFruit;
	}

	public List<Ingredient> getIns() {
		return ins;
	}

	public FileRW getFileIngre() {
		return fileIngre;
	}

	public List<RevenueToday> getTodays() {
		return todays;
	}

	public void setTodays(List<RevenueToday> todays) {
		this.todays = todays;
	}

	public List<RevenueTotal> getTotals() {
		return totals;
	}

	public void setTotals(List<RevenueTotal> totals) {
		this.totals = totals;
	}

	public JLabel getLblReToday() {
		return lblReToday;
	}

	public void setLblReToday(JLabel lblReToday) {
		this.lblReToday = lblReToday;
	}

	public JLabel getLblReMoney() {
		return lblReMoney;
	}

	public void setLblReMoney(JLabel lblReMoney) {
		this.lblReMoney = lblReMoney;
	}

	public JLabel getLblReMoneyTotal() {
		return lblReMoneyTotal;
	}

	public void setLblReMoneyTotal(JLabel lblReMoneyTotal) {
		this.lblReMoneyTotal = lblReMoneyTotal;
	}

	public JPanel getPnCus() {
		return pnCus;
	}

	public JButton getBtnEndDay() {
		return btnEndDay;
	}

	public MilkTeaStore getMn() {
		return mn;
	}

	public void setMn(MilkTeaStore mn) {
		this.mn = mn;
	}

	public String getUrlRoot() {
		return urlRoot;
	}

	public void setUrlRoot(String urlRoot) {
		this.urlRoot = urlRoot;
	}
	
	
	
	
	


	
}
