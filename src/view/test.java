package view;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public test() {
        // Thiết lập cấu hình JFrame
        super("Đăng nhập");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo các thành phần của giao diện đăng nhập
        JPanel panel = new JPanel(new GridLayout(3, 2));
        usernameLabel = new JLabel("Tài khoản:");
        passwordLabel = new JLabel("Mật khẩu:");
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Đăng nhập");

        // Thêm các thành phần vào panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));
        panel.add(loginButton);

        // Thêm panel vào JFrame
        add(panel, BorderLayout.CENTER);

        // Đăng ký sự kiện cho nút Đăng nhập
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (isValidLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu.");
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        // Kiểm tra tài khoản và mật khẩu
        // Đây là nơi bạn thêm mã của mình để kiểm tra tài khoản và mật khẩu
        return true;
    }

    public static void main(String[] args) {
        test loginScreen = new test();
        loginScreen.setVisible(true);
    }
}

