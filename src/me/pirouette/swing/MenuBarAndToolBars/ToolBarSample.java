package me.pirouette.swing.MenuBarAndToolBars;

import org.w3c.dom.events.EventListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ToolBarSample extends JFrame {

    public ToolBarSample() {
        super("JToolBar Sample");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new BorderLayout());

        contentPane.add(createToolBar(), BorderLayout.NORTH);
        contentPane.add(new JTree(), BorderLayout.WEST);


    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton iconNew = new JButton(new ImageIcon("icons/new.png"));
        iconNew.setToolTipText("Nouveau Fichier (CTRL+N)");
        iconNew.addActionListener(this::menuNewListener);

        JButton iconSave = new JButton(new ImageIcon("icons/save.png"));
        iconSave.setToolTipText("Enregistrer (CTRL+E)");

        JButton iconSaveAs = new JButton(new ImageIcon("icons/save_as.png"));
        iconSaveAs.setToolTipText("Enregistrer sous (CTRL+S)");

        JButton iconCopy = new JButton(new ImageIcon("icons/copy.png"));
        iconCopy.setToolTipText("Copier (CTRL+C)");

        JButton iconCut = new JButton(new ImageIcon("icons/cut.png"));
        iconCut.setToolTipText("Couper (CTRL+X)");

        JButton iconPaste = new JButton(new ImageIcon("icons/paste.png"));
        iconPaste.setToolTipText("Coller (CTRL+V)");

        JButton iconExit = new JButton(new ImageIcon("icons/exit.png"));
        iconExit.setToolTipText("Quitter (ALT+F4)");

        toolBar.add(iconNew);
        toolBar.add(iconSave);
        toolBar.add(iconSaveAs);
        toolBar.addSeparator();
        toolBar.add(iconCopy);
        toolBar.add(iconCut);
        toolBar.add(iconPaste);
        toolBar.addSeparator();
        toolBar.add(iconExit);
        toolBar.addSeparator();
        toolBar.add(new JCheckBox("Check me"));
        toolBar.addSeparator();
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100,30));
        toolBar.add(textField);

        return toolBar;
    }

    private void menuNewListener (ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Ouvrir quel fichier ?");

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
            // Apply a look 'n' feel
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            ToolBarSample window = new ToolBarSample();
            window.setVisible(true);

    }
}
