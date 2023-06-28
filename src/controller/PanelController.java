package controller;

import view.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelController implements ActionListener {


    Panel pn ;

    public PanelController(Panel pn){
        this.pn = pn;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        int i = 1;
        // ấn thì vô dọc lệnh , thì loop qua vòn lặp để chekc dều kiện ấn
        for (; i <= pn.getList().size() ; i++) {
            if(action.equals(""+i)){
                pn.getList().get(i-1).setEnabled(false);
            }
        }
        JOptionPane.showMessageDialog(null, "đã cấp thành công remote số "+action);

        pn.setVisible(false);



    }
//
//    public void disableButton(String numberButton){
//
//
//
//
//
//
//
//
//
//
//    }
//
//    public void UnDisableButton(){
//
//    }
}
