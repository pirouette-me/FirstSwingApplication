package me.pirouette.swing.MenuBarAndToolBars;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionSample extends JFrame {

    public ActionSample() {
        super("JPopUpMenu Sample");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Barre de menu
        this.setJMenuBar(this.createMenuBar());

        // Barre d'outils
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(createToolBar(), BorderLayout.NORTH);

        // Contenu de la fenetre
        JScrollPane leftScrollPane = new JScrollPane(new JTree());
        leftScrollPane.setPreferredSize(new Dimension(200,0));
        JTextArea textArea = new JTextArea();
        JScrollPane rightScrollPane = new JScrollPane(textArea);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightScrollPane);
        contentPane.add(splitPane);

        // Pop up menu sur la zone de texte
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

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Menu Fichier
        JMenu menuFile = new JMenu("Fichier");
        menuFile.setMnemonic('F');
        menuFile.add(actionNew);
        menuFile.addSeparator();
        menuFile.add(actionOpen);
        menuFile.add(actionSave);
        menuFile.add(actionSaveAs);
        menuFile.addSeparator();
        menuFile.add(actionExit);

        // Menu Edition
        JMenu menuEdit = new JMenu("Édition");
        menuEdit.setMnemonic('E');
        menuEdit.add(actionUndo);
        menuEdit.add(actionRedo);
        menuEdit.addSeparator();
        menuEdit.add(actionCopy);
        menuEdit.add(actionCut);
        menuEdit.add(actionPaste);

        // Menu Aide
        JMenu menuHelp = new JMenu("Aide");
        menuHelp.setMnemonic('A');
        menuHelp.add(actionHelp);
        menuHelp.add(actionAbout);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuHelp);

        return menuBar;
    }

    private JPopupMenu createPopUpMenu () {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(actionNew);

        return popupMenu;

    }

    private JToolBar createToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton iconNew = toolBar.add(actionNew);

        toolBar.add(iconNew);
        /*toolBar.add(iconSave);
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
        toolBar.add(textField);*/

        return toolBar;
    }

    // Actions
    private AbstractAction actionNew = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Nouveau fichier");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/new.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
            putValue(Action.SHORT_DESCRIPTION, "Nouveau fichier (CTL+N)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
            }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionOpen = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Ouvrir");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/open.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
            putValue(Action.SHORT_DESCRIPTION, "Ouvrir... (CTL+O)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionSave = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Enregistrer");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/save.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            putValue(Action.SHORT_DESCRIPTION, "Enregistrer (CTL+S)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionSaveAs = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Enregistrer sous...");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/save_as.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
            putValue(Action.SHORT_DESCRIPTION, "Enregistrer sous... (CTL+E)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionExit = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Quitter");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/exit.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Q);
            putValue(Action.SHORT_DESCRIPTION, "Quitter (ALT+F4)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionUndo = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Annuler");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/undo.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(Action.SHORT_DESCRIPTION, "Annuler (CONTROL+Z"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionRedo = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Répéter");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/redo.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
            putValue(Action.SHORT_DESCRIPTION, "Répéter (CONTROL+Y)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionCopy = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Copier");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/copy.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
            putValue(Action.SHORT_DESCRIPTION, "Copier (CONTROL+C)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionCut = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Couper");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/cut.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(Action.SHORT_DESCRIPTION, "Couper (CONTROL+X)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionPaste = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Coller");
            putValue(Action.SMALL_ICON, new ImageIcon("icons/paste.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_O);
            putValue(Action.SHORT_DESCRIPTION, "Coller (CONTROL+V)"); // ToolTipText sur toolbar
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };

    private AbstractAction actionHelp = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "Afficher l'aide");
            //putValue(Action.SMALL_ICON, new ImageIcon("icons/redo.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            putValue(Action.SHORT_DESCRIPTION, "Afficher l'aide (F1)"); // ToolTipText sur toolbar
            // how do we get F1 ?
            //putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.VK_EQUALS));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
            System.out.println("Hellllppppppppppp!!!!!!!!!!!!!!!!!");
        }
    };

    private AbstractAction actionAbout = new AbstractAction() {
        { // constructeur de CLASSE ANONYME
            putValue(Action.NAME, "A propos");
            //putValue(Action.SMALL_ICON, new ImageIcon("icons/redo.png"));
            putValue(Action.MNEMONIC_KEY, KeyEvent.VK_P);
            putValue(Action.SHORT_DESCRIPTION, "A propos"); // ToolTipText sur toolbar
            //putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK));
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // WHAT ARE WE DOING ???
        }
    };








    private void menuNewListener (ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Ouvrir quel fichier ?");

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
            // Apply a look 'n' feel
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            ActionSample window = new ActionSample();
            window.setVisible(true);

    }
}
