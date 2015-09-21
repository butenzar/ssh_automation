/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.util;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Claudio
 */
public class ImagenPanel extends javax.swing.JPanel {

    String path;
    ImageIcon Img;
    
    public ImagenPanel(String strPath) {
        this.setSize(150, 150); //se selecciona el tamaño del panel
        if(!(strPath == null || strPath.trim().isEmpty())){
                path = strPath.substring(3, strPath.length());
              //Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
              if(getClass().getResource(path) == null){
                  Img = new ImageIcon(getClass().getResource("/resources/User/generic.png"));
                 
              }
              else{
                  Img = new ImageIcon(getClass().getResource(path));
              }  
        }else{
             Img = new ImageIcon(getClass().getResource("/resources/User/generic.png"));
        }
        
             
        
    }

    //Se crea un método cuyo parámetro debe ser un objeto Graphics
    public void paint(Graphics grafico) {
        try {
            Dimension height = getSize();


            //se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

            setOpaque(false);
            super.paintComponent(grafico);
        } catch (Exception e) {
            throw new IllegalArgumentException("No su pudo cargar la imagen");
        }

    }

}
