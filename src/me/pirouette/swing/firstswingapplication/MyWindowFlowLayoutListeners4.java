package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;

public class MyWindowFlowLayoutListeners4 extends JFrame {

    private JButton btnPushMe = new JButton("Push me");
    private JButton btnClickMe = new JButton("Click me");

    public MyWindowFlowLayoutListeners4() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));


        btnPushMe.addActionListener(this::btnPushListener);
        contentPane.add(btnPushMe);

        btnClickMe.addActionListener((e) -> btnPushListener(e));
        btnClickMe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnClickMe.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnClickMe.setForeground(Color.BLACK);
            }
        });
        contentPane.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me");
        contentPane.add(chkCheckMe);

        JTextField txtEditMe = new JTextField("Edit me");
        txtEditMe.setPreferredSize(new Dimension(120, 30));
        contentPane.add(txtEditMe);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                int clickedButton = JOptionPane.showConfirmDialog(MyWindowFlowLayoutListeners4.this,
                        "Etes-vous sur ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (clickedButton == JOptionPane.YES_OPTION) {
                    MyWindowFlowLayoutListeners4.this.dispose();
                }
            }
        });

    }

    private void btnPushListener(ActionEvent e) {
        System.out.println("Autre bouton cliqué");

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowFlowLayoutListeners4 myWindow = new MyWindowFlowLayoutListeners4();
        myWindow.setVisible(true);
    }
}
