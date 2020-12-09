package me.pirouette.swing.MenuBarAndToolBars;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuBarSample extends JFrame {

    public MenuBarSample() {
        super("JMenuBar Sample");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFichier = new JMenu("Fichier");
        menuFichier.setMnemonic('F');

        //MENU FICHIER
        JMenuItem menuFichierNew = new JMenu("Nouveau");
        menuFichierNew.setMnemonic('N');
        JMenuItem menuFichierNewFile = new JMenuItem("Nouveau Fichier");
        menuFichierNewFile.setMnemonic('C');
        menuFichierNewFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        menuFichierNewFile.setIcon(new ImageIcon("icons/new.png"));
        JMenuItem menuFichierNewFolder = new JMenuItem("Nouveau Dossier");
        menuFichierNewFolder.setMnemonic('D');
        menuFichierNew.add(menuFichierNewFile);
        menuFichierNew.add(menuFichierNewFolder);

        JMenuItem menuOpenFile = new JMenuItem("Ouvrir...");
        menuOpenFile.setMnemonic('O');
        menuOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        menuOpenFile.setIcon(new ImageIcon("icons/open.png"));
        menuOpenFile.addActionListener(this::menuOpenFileListener);

        JMenuItem menuSaveFile = new JMenuItem("Enregistrer");
        menuSaveFile.setMnemonic('E');
        menuSaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        menuSaveFile.setIcon(new ImageIcon("icons/save.png"));

        JMenuItem menuSaveAsFile = new JMenuItem("Enregistrer sous...");
        menuSaveAsFile.setMnemonic('S');
        menuSaveAsFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        menuSaveAsFile.setIcon(new ImageIcon("icons/save_as.png"));

        JMenuItem menuExit = new JMenuItem("Quitter");
        menuExit.setMnemonic('Q');
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
        menuExit.setIcon(new ImageIcon("icons/exit.png"));

        menuFichier.add(menuFichierNew);
        menuFichier.addSeparator();
        menuFichier.add(menuOpenFile);
        menuFichier.add(menuSaveFile);
        menuFichier.add(menuSaveAsFile);
        menuFichier.addSeparator();
        menuFichier.add(menuExit);

        // MENU EDITION
        JMenu menuEdition = new JMenu("Edition");
        menuEdition.setMnemonic('E');

        JMenuItem menuEditUndo = new JMenuItem("Annuler");
        menuEditUndo.setMnemonic('A');
        menuEditUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        menuEditUndo.setIcon(new ImageIcon("icons/undo.png"));
        menuEdition.add(menuEditUndo);

        JMenuItem menuEditRedo = new JMenuItem("Répéter");
        menuEditRedo.setMnemonic('R');
        menuEditRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        menuEditRedo.setIcon(new ImageIcon("icons/redo.png"));
        menuEdition.add(menuEditRedo);

        menuEdition.addSeparator();

        JMenuItem menuEditCopy = new JMenuItem("Copier");
        menuEditCopy.setMnemonic('P');
        menuEditCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        menuEditCopy.setIcon(new ImageIcon("icons/copy.png"));
        menuEdition.add(menuEditCopy);

        JMenuItem menuEditCut = new JMenuItem("Couper");
        menuEditCut.setMnemonic('C');
        menuEditCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        menuEditCut.setIcon(new ImageIcon("icons/cut.png"));
        menuEdition.add(menuEditCut);

        JMenuItem menuEditPaste = new JMenuItem("Coller");
        menuEditPaste.setMnemonic('O');
        menuEditPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        menuEditPaste.setIcon(new ImageIcon("icons/paste.png"));
        menuEdition.add(menuEditPaste);

        //MENU AIDE
        JMenu menuAide = new JMenu("Aide");
        menuAide.setMnemonic('A');

        menuBar.add(menuFichier);
        menuBar.add(menuEdition);
        menuBar.add(menuAide);

        return menuBar;
    }

    private void menuOpenFileListener (ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Ouvrir quel fichier ?");

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
            // Apply a look 'n' feel
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            MenuBarSample window = new MenuBarSample();
            window.setVisible(true);

    }
}
