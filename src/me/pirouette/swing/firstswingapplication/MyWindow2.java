package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow2 {
    private JButton pushMeButton;
    private JPanel panel1;
    private JButton clickMeButton;
    private JCheckBox checkMeCheckBox;
    private JTextArea editMeTextArea;

    public MyWindow2() {
        pushMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Second Window");
        frame.setContentPane(new MyWindow2().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
