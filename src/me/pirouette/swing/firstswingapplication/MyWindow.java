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
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(new JButton("Push me"));
        contentPane.add(new JButton("Click me!!!!"));
        contentPane.add(new JCheckBox("Check me"));
        contentPane.add(new JTextField("Edit me"));
        contentPane.add(new JButton("Push me"));
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Appy a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);
    }
}
