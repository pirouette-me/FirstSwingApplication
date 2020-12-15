package me.pirouette.swing.curvetracer;

import javax.swing.*;
import java.awt.*;

public class CurveCanvas extends JComponent {

    private CurveFunction function = (x) -> Math.sin(x);

    @Override
    protected void paintComponent(Graphics graphicsSimple) {
        super.paintComponent(graphicsSimple);

        // anti aliasing
        Graphics2D graphics = (Graphics2D) graphicsSimple;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // white background
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,getWidth(), getHeight());

        // draw axis
        graphics.setColor(Color.GRAY);
        graphics.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
        graphics.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());

        // draw values
        graphics.setColor(Color.BLACK);
        graphics.drawString("0,0", (int)(getWidth()*.505), (int)(getHeight()*.53));
        graphics.drawString("-\u03c0", (int)(getWidth()*.02), (int)(getHeight()*.53));
        graphics.drawString("\u03c0", (int)(getWidth()*.96), (int)(getHeight()*.53));

        // draw the curve
        double step = .05;
        graphics.setColor(new Color(255,0,255));

        int oldX = xToPixel(-Math.PI);
        int oldY = yToPixel(function.compute(-Math.PI));

        for (double logicalX = -Math.PI + step; logicalX < Math.PI + step; logicalX += step) {
            int x = xToPixel(logicalX);
            int y = yToPixel(function.compute(logicalX));

            graphics.drawLine(x, y, oldX, oldY);

            oldX = x;
            oldY = y;
        }
    }

    public void setFunction (CurveFunction function) {
        this.function = function;
        this.repaint(0,0,getWidth(), getHeight());

    }

    private int xToPixel(double x) {
        return (int) (getWidth() * (x + Math.PI) / (2 * Math.PI));
    }

    private int yToPixel(double y) {
        return (int) (getHeight() * (1 - (y + 1) / 2));
    }
    public interface CurveFunction {
        double compute (double x);
    }
}
