/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.TexturePaint;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author Claudio
 */
public class PrintGlassPane extends JPanel {
    private static final TexturePaint TEXTURE = SwingComponentUtil.createCheckerTexture(4);
    public PrintGlassPane() {
        super((LayoutManager) null);
    }
    @Override public void setVisible(boolean isVisible) {
        boolean oldVisible = isVisible();
        super.setVisible(isVisible);
        JRootPane rootPane = getRootPane();
        if (rootPane != null && isVisible() != oldVisible) {
            rootPane.getLayeredPane().setVisible(!isVisible);
        }
    }
    @Override public void paintComponent(Graphics g) {
        JRootPane rootPane = getRootPane();
        if (rootPane != null) {
            rootPane.getLayeredPane().print(g);
        }
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(TEXTURE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
    }
}