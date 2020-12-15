package me.pirouette.swing.hypertext;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class KLink extends JLabel {

    private static final  Color LINK_COLOR = new Color(51,123,200);

    private Vector<ActionListener> actionListeners = new Vector<>();

    public KLink(String text) {
        super("<html><u>" + text + "</u></html>");
        this.setForeground(LINK_COLOR);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setFocusable(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                requestFocus();
                fireActionEvent(e);
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == ' ') fireActionEvent(e);
            }
        });

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Border border = BorderFactory.createLineBorder(LINK_COLOR);
                setBorder(border);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(null);
            }
        });
    }

    public void addActionListener(ActionListener listener) {
        this.actionListeners.add(listener);
    }
    public void removeActionListener(ActionListener listener) {
        this.actionListeners.remove(listener);
    }

    private void fireActionEvent(AWTEvent event) {
        ActionEvent actionEvent = new ActionEvent(this, event.getID(), null);
        for (var listener : actionListeners) {
            listener.actionPerformed(actionEvent);
        }
    }
}
