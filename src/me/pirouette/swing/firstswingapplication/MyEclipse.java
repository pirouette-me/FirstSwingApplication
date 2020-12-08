package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyEclipse extends JFrame {
    public MyEclipse() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new BorderLayout());

        JButton btnPushMe = new JButton("Push me");
        contentPane.add(btnPushMe, BorderLayout.NORTH);

        JButton btnClickMe = new JButton("Click me");
        btnClickMe.setPreferredSize(new Dimension(200, 0));
        contentPane.add(btnClickMe, BorderLayout.WEST);

        JCheckBox chkChechMe = new JCheckBox("Check me");
        contentPane.add(chkChechMe, BorderLayout.SOUTH);

        JTextArea txtEditMe= new JTextArea("Edit me");
        contentPane.add(txtEditMe);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyEclipse myWindow = new MyEclipse();
        myWindow.setVisible(true);
    }
}
