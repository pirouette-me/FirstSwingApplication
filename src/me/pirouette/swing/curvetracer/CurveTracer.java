package me.pirouette.swing.curvetracer;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CurveTracer extends JFrame {

    private JButton btnSinus = new JButton("Sinus");
    private JButton btnCosinus = new JButton("Cosinus");
    private CurveCanvas curveCanvas = new CurveCanvas();

    public CurveTracer() throws HeadlessException {
        super("Curve Tracer");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400,470);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();

        JPanel pnlTop = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        btnSinus.addActionListener(this::btnSinusListener);
        pnlTop.add(btnSinus);
        btnCosinus.addActionListener(this::btnCosinusListener);
        pnlTop.add(btnCosinus);
        contentPane.add(pnlTop, BorderLayout.NORTH);

        contentPane.add(curveCanvas, BorderLayout.CENTER);
    }

    private void btnSinusListener(ActionEvent e) {
        curveCanvas.setFunction((x) -> Math.sin(x));
    }

    private void btnCosinusListener(ActionEvent e) {
        curveCanvas.setFunction((x) -> Math.cos(x));
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // Apply a look 'n' feel
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        // Start my window
        CurveTracer myWindow = new CurveTracer();
        myWindow.setVisible(true);
    }
}
