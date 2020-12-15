package me.pirouette.swing.firstswingapplication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;


public class JSplitPanelSample extends JFrame {
    public JSplitPanelSample() {
        super("JSplitPanelSample");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();

        JTree projectTree = new JTree();
        JScrollPane projectScrollPane = new JScrollPane(projectTree);
        projectScrollPane.setPreferredSize(new Dimension(200,0));

        JTextArea editor = new JTextArea();
        JScrollPane editorScrollPane = new JScrollPane(editor);

        JTextArea console = new JTextArea();
        JScrollPane consoleScrollPane = new JScrollPane(console);

        JTree outlineTree = new JTree();
        JScrollPane outlineScrollPane = new JScrollPane(outlineTree);

        JSplitPane horizontalSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, editorScrollPane, outlineScrollPane);
        horizontalSplitPane.setResizeWeight(.6);

        JSplitPane  verticalSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, horizontalSplitPane, consoleScrollPane);
        verticalSplitPane.setResizeWeight(.5);

        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, projectScrollPane, verticalSplitPane);

        contentPane.add(mainSplitPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        JSplitPanelSample myWindow = new JSplitPanelSample();
        myWindow.setVisible(true);
    }
}
