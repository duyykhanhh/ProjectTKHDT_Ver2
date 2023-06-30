package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MilkTeaStore.Beverage;
import MilkTeaStore.IPayStrategy;
import view.PayView;

public class PayController implements ActionListener{

    private ArrayList<Beverage> list ;
    private PayView pay ;
    private IPayStrategy ipay ;

    public PayController(PayView pay){
        this.pay = pay ;

    }
    
    public void setPay(IPayStrategy pay){
        ipay = pay ;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (pay.getDrinksTable().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No order here.");
        } else if (!pay.getCashPayment().isSelected() && !pay.getCardPayment().isSelected() && !pay.getOnlinePayment().isSelected()) {
            JOptionPane.showMessageDialog(null, "Choose payment method first!");
        }
        else  {
            pay.addToToday();
            
            pay.setDrinks();
            pay.moveOrderToObserver();

            JOptionPane.showMessageDialog(null, "Total money : " + pay.getTotalLabel().getText() + " VND");
            
            pay.getTotalLabel().setText(0.0+"");
       
            pay.getModel().setRowCount(0);
          
//            pay.getTotalLabel().setText("Total: " + Order.currentOrder.getprice());
//            Order.currentOrder.setCount(0);
            pay.getPayButton().setEnabled(false);
            pay.getCashDiscountLabel().setVisible(false);
            pay.getCardDiscountLabel().setVisible(false);
            pay.getOnlineDiscountLabel().setVisible(false);

            pay.getCashPayment().setEnabled(false);
            pay.getCardPayment().setEnabled(false);
            pay.getOnlinePayment().setEnabled(false);


//            pay.backToOrder();

            
            pay.getCheckCodeButton().setEnabled(false);
            
            pay.getDiscountCodeField().setEnabled(false);
         
     

        }
            
            


            
            



        }
}
