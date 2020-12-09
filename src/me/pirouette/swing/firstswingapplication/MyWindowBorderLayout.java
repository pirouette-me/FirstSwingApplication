package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class MyWindowBorderLayout extends JFrame {
    public MyWindowBorderLayout() throws HeadlessException {
        super("My first Swing application");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new BorderLayout());

        contentPane.add(createToolBar(), BorderLayout.NORTH);

        JScrollPane westComponent = new JScrollPane(new JTree());
        westComponent.setPreferredSize(new Dimension(200,0));
        contentPane.add(westComponent, BorderLayout.WEST);

        JTextArea txtContent = new JTextArea("The content of this editor");
        JScrollPane scrContent = new JScrollPane(txtContent);
        contentPane.add(scrContent);

        contentPane.add(createRightPanel(), BorderLayout.EAST);

        contentPane.add(createStatusBar(), BorderLayout.SOUTH);

    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton btnPushMe = new JButton("Push me");
        toolBar.add(btnPushMe);

        JButton btnClickMe = new JButton("Click me");
        toolBar.add(btnClickMe);

        JCheckBox chkCheckMe = new JCheckBox("Check me");
        toolBar.add(chkCheckMe);

        JTextField txtEditMe= new JTextField("Edit me");
        txtEditMe.setPreferredSize(new Dimension(140,30));
        toolBar.add(txtEditMe);

        return toolBar;
    }

    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblStatus1 = new JLabel("Message 1");
        lblStatus1.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus1);

        JLabel lblStatus2 = new JLabel("Message 2");
        lblStatus2.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus2);

        JLabel lblStatus3 = new JLabel("Message 3");
        lblStatus3.setPreferredSize(new Dimension(100,30));
        statusBar.add(lblStatus3);

        return  statusBar;

    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new GridLayout(4, 1));
        rightPanel.add(new JButton("Button1"));
        rightPanel.add(new JButton("Button2"));
        rightPanel.add(new JButton("Button3"));
        rightPanel.add(new JButton("Button4"));

        return  rightPanel;
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        MyWindowBorderLayout myWindow = new MyWindowBorderLayout();
        myWindow.setVisible(true);
    }
}
