package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowFlowLayoutListeners2 extends JFrame {

    private JButton btnPushMe = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me");

    public MyWindowFlowLayoutListeners2() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));


        btnPushMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bouton cliqué");
            }
        });
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPushListener(e);
            }
        });
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField("Edit me");
        txtEditMe.setPreferredSize(new Dimension(120, 30));
        contentPane.add(txtEditMe);

    }

    private void btnPushListener(ActionEvent e) {
        System.out.println("Autre bouton cliqué");
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowFlowLayoutListeners2 myWindow = new MyWindowFlowLayoutListeners2();
        myWindow.setVisible(true);
    }
}
