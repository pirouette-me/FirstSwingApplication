package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowGridLayout extends JFrame {
    public MyWindowGridLayout() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(2, 2, 20, 20));

        JButton btnPushMe = new JButton("Push me");
        contentPane.add(btnPushMe);

        JButton btnClickMe = new JButton("Click me");
        contentPane.add(btnClickMe);

        JCheckBox chkChechMe = new JCheckBox("Check me");
        contentPane.add(chkChechMe);

        JTextField txtEditMe= new JTextField("Edit me");
        contentPane.add(txtEditMe);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowGridLayout myWindow = new MyWindowGridLayout();
        myWindow.setVisible(true);
    }
}
