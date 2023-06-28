package view;

import controller.PanelController;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel extends JFrame {

    // đưa object hiện tại vào panelcontrooler
    PanelController panelController = new PanelController(this);//this tức là khi mà khởi tạo panel ở đâu
    // thì this là panel đó truyền vô cho panelcontroller
    //vì thằng này không phải giao dienj nên không sợ là khi tạo panel là


   public static int count = 0;

    ArrayList<JButton> buttonList = new ArrayList<>();

    public ArrayList<JButton> getList() {
        return buttonList;
    }

    JPanel contentPane = new JPanel();
    JButton buttonAction;

    public Panel() {

    }


    public void createButton() {
        for (int i = 1, j = 0; i <= 30; i++, j++) {
            buttonList.add(new JButton(String.valueOf(i)));
            buttonList.get(j).setBackground(new Color(255, 153, 51));
            buttonList.get(j).setPreferredSize(new Dimension(50, 50));
            contentPane.add(buttonList.get(j));
        }
    }

    public void addAction() {
        for (int i = 0, j = 1; i < buttonList.size(); i++) {
            buttonList.get(i).addActionListener(panelController);
        }

    }

    public void init(){
        // lí do : vì khi ấn cái tạo remote thì lệnh được đọc lại thì khi đó lại khởi tạo lại nút
        // nên ý tưởng là khi mới mở lần đầu tiên (lần đầu mở giao diện đó các lần tiếp theo
        //không khởi tạo nữa.
        if (count == 0) {
            createButton();
            addAction();
        }
        Panel.count++;// những laanfn tiếp theo count luôn >0 nên không khởi tạo lại
        setTitle("Panel with Buttons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane.setLayout(new GridLayout(6, 5, 10, 10));
        setContentPane(contentPane);
        this.setLocation(600, 250);
        this.setSize(350, 350);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Panel().init();
            }
        });


    }
}
