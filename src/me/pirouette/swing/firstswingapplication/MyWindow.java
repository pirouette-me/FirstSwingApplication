package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();

        contentPane.setLayout(null);

        JButton btnPushMe = new JButton("Push me");
        btnPushMe.setBounds(200, 20, 160,30);
        contentPane.add(btnPushMe);

        JButton btnClickMe = new JButton("Click me");
        btnClickMe.setBounds(200, 70, 160,30);
        contentPane.add(btnClickMe);

        JCheckBox chkChechMe = new JCheckBox("Check me");
        chkChechMe.setBounds(200, 120, 160,30);
        contentPane.add(chkChechMe);

        JTextField txtEditMe= new JTextField("Edit me");
        txtEditMe.setBounds(200,170,160,30);
        contentPane.add(txtEditMe);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);
    }
}
