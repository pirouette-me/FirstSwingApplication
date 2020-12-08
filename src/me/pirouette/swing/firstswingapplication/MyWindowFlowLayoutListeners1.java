package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowFlowLayoutListeners1 extends JFrame implements ActionListener {

    private JButton btnPushMe = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me");

    public MyWindowFlowLayoutListeners1() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));


        btnPushMe.addActionListener(this);
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener(this);
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField("Edit me");
        txtEditMe.setPreferredSize(new Dimension(120, 30));
        contentPane.add(txtEditMe);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPushMe) {
            System.out.println("Bouton cliqué");
        } else {
            System.out.println("Autre bouton cliqué");
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowFlowLayoutListeners1 myWindow = new MyWindowFlowLayoutListeners1();
        myWindow.setVisible(true);
    }
}
