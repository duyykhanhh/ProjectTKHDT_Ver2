package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class BigScreen extends JFrame {

	private JPanel pnMain;
	private JScrollPane sp;
	private JTable tblAlarm;
	private DefaultTableModel model;
	private Object[][] data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BigScreen frame = new BigScreen();
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
	public BigScreen() {
		setTitle("BigScreen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		pnMain = new JPanel();
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMain.setLayout(new BorderLayout(0, 0));
		setContentPane(pnMain);
		
		JPanel pnAlarm = new JPanel();
		pnMain.add(pnAlarm, BorderLayout.CENTER);
		
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
		
		tblAlarm =new JTable(model);
		tblAlarm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblAlarm.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tblAlarm.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
		
		TableColumnModel columnModel = tblAlarm.getColumnModel();
		 columnModel.getColumn(0).setPreferredWidth(400); 
	     columnModel.getColumn(1).setPreferredWidth(100); 
		
	     DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
//	    	 
//	            @Override
//	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//	                JTextArea textArea = new JTextArea();
//	                textArea.setText(value != null ? value.toString() : "");
//	                textArea.setLineWrap(true);
//	                textArea.setWrapStyleWord(true);
//	                textArea.setBackground(table.getBackground());
//	                textArea.setFont(table.getFont());
//
//	                return textArea;
//	            }
	        };
	        
	        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
	        tblAlarm.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);    	        
	        tblAlarm.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
	        
	        tblAlarm.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
				
				}
			});
	        
	   
	  
	        
	    	sp = new JScrollPane(tblAlarm);
			sp.setMinimumSize(new Dimension(500, 500));
			sp.setMaximumSize(new Dimension(500, 500));
			sp.setPreferredSize(new Dimension(500, 500));
			pnAlarm.add(sp);
	}

}
