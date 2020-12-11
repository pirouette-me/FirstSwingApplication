package me.pirouette.swing.MenuBarAndToolBars;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpMenuSample extends JFrame {

    public PopUpMenuSample() {
        super("JPopUpMenu Sample");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel contentPane = (JPanel) this.getContentPane();
        //contentPane.setLayout(new BorderLayout());

        JScrollPane leftScrollPane = new JScrollPane(new JTree());
        leftScrollPane.setPreferredSize(new Dimension(200,0));
        JTextArea textArea = new JTextArea();
        JScrollPane rightScrollPane = new JScrollPane(textArea);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);

        contentPane.add(createToolBar(), BorderLayout.NORTH);
        contentPane.add(splitPane);

        JPopupMenu popupMenu = this.createPopUpMenu();
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());

                }
            }
        });

    }

    private JPopupMenu createPopUpMenu () {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuFichierNewFile = new JMenuItem("Nouveau Fichier");
        menuFichierNewFile.setMnemonic('N');
        menuFichierNewFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        menuFichierNewFile.setIcon(new ImageIcon("icons/new.png"));

        JMenuItem menuEditUndo = new JMenuItem("Annuler");
        menuEditUndo.setMnemonic('A');
        menuEditUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        menuEditUndo.setIcon(new ImageIcon("icons/undo.png"));

        JMenuItem menuEditRedo = new JMenuItem("Répéter");
        menuEditRedo.setMnemonic('R');
        menuEditRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        menuEditRedo.setIcon(new ImageIcon("icons/redo.png"));

        JMenuItem menuEditCopy = new JMenuItem("Copier");
        menuEditCopy.setMnemonic('P');
        menuEditCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        menuEditCopy.setIcon(new ImageIcon("icons/copy.png"));

        JMenuItem menuEditCut = new JMenuItem("Couper");
        menuEditCut.setMnemonic('C');
        menuEditCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        menuEditCut.setIcon(new ImageIcon("icons/cut.png"));

        JMenuItem menuEditPaste = new JMenuItem("Coller");
        menuEditPaste.setMnemonic('O');
        menuEditPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        menuEditPaste.setIcon(new ImageIcon("icons/paste.png"));

        popupMenu.add(menuFichierNewFile);
        popupMenu.addSeparator();
        popupMenu.add(menuEditUndo);
        popupMenu.add(menuEditRedo);
        popupMenu.addSeparator();
        popupMenu.add(menuEditCopy);
        popupMenu.add(menuEditCut);
        popupMenu.add(menuEditPaste);

        return popupMenu;

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
            PopUpMenuSample window = new PopUpMenuSample();
            window.setVisible(true);

    }
}
