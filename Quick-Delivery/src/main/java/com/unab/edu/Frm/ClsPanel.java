/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Frm;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author orell
 */
public class ClsPanel  {
    private JPanel container;
    private JPanel content;
    
    public void CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }
    
}
