package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import MilkTeaStore.Alarm;
import MilkTeaStore.BartenderModel;
import MilkTeaStore.Employee;
import MilkTeaStore.FileRW;
import MilkTeaStore.Observer;
import MilkTeaStore.OrderData;
import MilkTeaStore.OrderModel;
import controller.BartenderController;
import controller.ManagementController;

public class Bartender extends JFrame implements Observer{

	private JPanel pnMain,pnInfo, pnBtn;
	private JTable tblOrderInfo;
	private JScrollPane sp;
	private DefaultTableModel model;
	private Object[][] data;
	private JButton btnAlarm;
	private JButton btnFinished;
	private int isAlarm=1;
	private BartenderModel ba;
	private OrderData orderData;
	List<OrderModel> orderList= new ArrayList<>();
    private FileRW fileAlarm;
	private List<Alarm> as = new ArrayList<>();
	private javax.swing.Timer timer;
	
	private String urlRoot="";
	private String urlAlarm;
	
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderData orderData = new OrderData();
					Bartender frame = new Bartender();
//					Bartender frame = new Bartender(orderData);
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
//	public Bartender(OrderData orderData)
	public Bartender() {
		
		urlRoot = Home.getUrlRoot();
		urlAlarm = urlRoot + "/alarm";
//		fileAlarm = new FileRW("src/data/alarm");
		fileAlarm = new FileRW(urlAlarm);
		as = this.fileAlarm.readAlarms();
		PayView.registerObserver(this);

		setTitle("Bartender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(pnMain);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));
		
		pnInfo = new JPanel();
		pnInfo.setMinimumSize(new Dimension(500, 600));
		pnInfo.setMaximumSize(new Dimension(500, 600));
		pnInfo.setPreferredSize(new Dimension(500, 600));
		pnMain.add(pnInfo);
		
		data = new Object[][] {
//			{"123456789012345678901234567890123456789012345678901234567890" , 1},
//			{"to minh nhat" , 2}
		};
		
		Class[] columnTypes = {
				String.class, Integer.class
		};
		
		String[] column= {
				"Order", "Alarm"
		};
		
		model= new DefaultTableModel(data, column);
		
		tblOrderInfo =new JTable(model);
		tblOrderInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblOrderInfo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblOrderInfo.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
		
		TableColumnModel columnModel = tblOrderInfo.getColumnModel();
		 columnModel.getColumn(0).setPreferredWidth(400); 
	     columnModel.getColumn(1).setPreferredWidth(100); 
		
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
	        
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        tblOrderInfo.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);    	        
	        tblOrderInfo.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	        
	        tblOrderInfo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
//					timer = new javax.swing.Timer(490, new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							// TODO Auto-generated method stub
//							alarming();
//
//						}
//					});
//					timer.start();
					btnAlarm.setEnabled(true);
					btnFinished.setEnabled(true);
				
			
					
				}
			});
	        
	   
	        
	        
//	        tblOrderInfo.getSelectionModel().addListSelectionListener(e -> {
//	            
//	            selectedRow = tblOrderInfo.getSelectedRow();
//	            if (selectedRow != -1) {
//	              
//	            	tblOrderInfo.setSelectionBackground(Color.WHITE);
//	            	tblOrderInfo.setSelectionForeground(Color.BLACK);
//	            }
//	        });
	        
	    	sp = new JScrollPane(tblOrderInfo);
			sp.setMinimumSize(new Dimension(500, 500));
			sp.setMaximumSize(new Dimension(500, 500));
			sp.setPreferredSize(new Dimension(500, 500));
			pnInfo.add(sp);
			
			pnBtn = new JPanel();
			
			pnBtn.setMinimumSize(new Dimension(200, 600));
			pnBtn.setMaximumSize(new Dimension(200, 600));
			pnBtn.setPreferredSize(new Dimension(200, 600));
			pnMain.add(pnBtn);
			pnBtn.setLayout(new BoxLayout(pnBtn, BoxLayout.Y_AXIS));
			
			pnBtn.add(Box.createVerticalGlue());
			
			btnAlarm = new JButton("Alarm!");
			btnAlarm.setMinimumSize(new Dimension(100, 60));
			btnAlarm.setMaximumSize(new Dimension(100, 60));
			btnAlarm.setPreferredSize(new Dimension(100, 60));
			btnAlarm.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAlarm.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnBtn.add(btnAlarm);
			
			pnBtn.add(Box.createVerticalStrut(100));
			
			btnFinished = new JButton("Finished");
			btnFinished.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnFinished.setAlignmentX(Component.CENTER_ALIGNMENT);
			pnBtn.add(btnFinished);
			
			pnBtn.add(Box.createVerticalGlue());
			
			MouseListener mlis = new BartenderController(this);
		    btnAlarm.addMouseListener(mlis);
		    btnFinished.addMouseListener(mlis);
		    
		    ActionListener ac = new BartenderController(this);
		    btnAlarm.addActionListener(ac);
		    btnFinished.addActionListener(ac);
			
			setPanelBackground(pnMain, new Color(240, 255, 255));
			
//			OrderModel o1 = new OrderModel("nhat", new Alarm(1, false));
//			OrderModel o2 = new OrderModel("to minh nhat", new Alarm(2, false));
//			
//			addNewToOrderList(o2);
//			addNewToOrderList(o1);
//			writeOrderToTable(orderList);
			
//			Temp t1 = new Temp("mot mot", 1);
//			Temp t2 =  new Temp("hai hai", 2);
//			temps.add(t1);
//			temps.add(t2);
//			writeOrderToTableTtest(temps);
			
			
		
	}

	
	public JTable getTblOrderInfo() {
		return tblOrderInfo;
	}

	public void setTblOrderInfo(JTable tblOrderInfo) {
		this.tblOrderInfo = tblOrderInfo;
	}

	public void hoverIn(JButton btn) {
		btn.setBackground(new Color(0, 139, 139));
		btn.setForeground(new Color(255, 255, 240));
	}
	
	public void hoverOut(JButton btn) {
		btn.setBackground(new Color(175, 238, 238));
		btn.setForeground(new Color(0, 0, 0));
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
	


	public JButton getBtnAlarm() {
		return btnAlarm;
	}

	public void setBtnAlarm(JButton btnAlarm) {
		this.btnAlarm = btnAlarm;
	}

	public JButton getBtnFinished() {
		return btnFinished;
	}

	public void setBtnFinished(JButton btnFinished) {
		this.btnFinished = btnFinished;
	}
	
	public void writeOrderToTable(List<OrderModel> orderList) {
		int currentRow=0;
		for(OrderModel o : orderList) {
			
			String drinks = o.getOrder();
			int alarmNum = o.getAlarm().getNumber();
//			int temp = drinks.length()/53 + 1;
			int temp = countNewLines(drinks)+1;
			
			tblOrderInfo.setRowHeight(currentRow, 20 * temp);
			this.model.addRow(new Object[] {drinks,alarmNum});
			tblOrderInfo.setRowHeight(currentRow, 20 * temp);
			currentRow++;
		}
	}

	public void addNewToOrderList(OrderModel o) {
		orderList.add(o);
	}

	@Override
	public void update(OrderModel o) {
		// TODO Auto-generated method stub
//		OrderModel temp = o;
		orderList.add(o);
//		addNewToOrderList(o);
		this.model.setRowCount(0);
		writeOrderToTable(orderList);
//		System.out.println(orderList);

		
		
		
	
	}
	
	   public int countNewLines(String str) {
		   String str1 = str;
	        int count = 0;
	        for (int i = 0; i < str1.length(); i++) {
	            if (str1.charAt(i) == '\n') {
	                count++;
	            }
	        }
	        return count;
	    }
	   
	   public void alarming() {
		   
		   int selectedRow = tblOrderInfo.getSelectedRow();
		   int num = (int) this.model.getValueAt(selectedRow, 1);
		   String str = num + ":alarming...";
		   this.model.setValueAt(str, selectedRow, 1);
		   for(Alarm a : as) {
			   if(a.getNumber() == num)
				   a.ring();
			 
		   }

		   
		   
	   }
	
	  
	  
	public void finishOrder() {
		int selectedRow = tblOrderInfo.getSelectedRow();
		String str = (String) this.model.getValueAt(selectedRow, 1);
		String[] info= str.split(":");
		int num = Integer.parseInt(info[0]);
		List<Alarm> alarms = fileAlarm.readAlarms();
		for(Alarm a : alarms) {
			if(a.getNumber() == num)
				a.setAvailable(true);
		}
		
		fileAlarm.reWriteAlarm(alarms);
		

		model.removeRow(selectedRow);
		tblOrderInfo.repaint();
		
	
	}

	public String getUrlRoot() {
		return urlRoot;
	}

	public void setUrlRoot(String urlRoot) {
		this.urlRoot = urlRoot;
	}

	
	

	
	

	

	
	
}
