/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.util;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Bruno Szilagyi
 */
public class HighLightListener implements DocumentListener{
    
    JTextComponent comp = null;
    Border defaultBorder = null;
    JButton buttonToDisable;
    Border highlightBorder = 
            BorderFactory.createLineBorder(Color.RED);
    
    public HighLightListener(JTextComponent jtc, JButton buttonToDisable){
        comp = jtc;
        defaultBorder = comp.getBorder();
        this.buttonToDisable = buttonToDisable;
        // Adding this listener to a specified component;
        comp.getDocument().addDocumentListener(this);
        //Highlight if empty;
        this.maybeHighLight();
    }
    
    @Override
    public void insertUpdate(DocumentEvent e){
        maybeHighLight();
    }
    
    @Override
    public void removeUpdate(DocumentEvent e){
        maybeHighLight();
    }
    
    @Override
    public void changedUpdate(DocumentEvent e){
        maybeHighLight();
    }
    
    private void maybeHighLight(){
         if (comp.getText().trim().length() != 0){
             // if a field is non-empty, switch it to default look 
             comp.setBorder(defaultBorder);
             buttonToDisable.setEnabled(true);
         }
         else{
             // if a field is empty, highlight it
             comp.setBorder(highlightBorder);
             buttonToDisable.setEnabled(false);
             // ... more actions
         }
         
    }
}
