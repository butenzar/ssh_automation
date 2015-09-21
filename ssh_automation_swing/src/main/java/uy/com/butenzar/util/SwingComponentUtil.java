/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.com.butenzar.util;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.stream.IntStream;
import static java.util.stream.IntStream.range;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Bruno
 */
public class SwingComponentUtil {
    public static String CTE_CLIENTE = "Cliente";
    public static String CTE_PROVEEDOR = "Proveedor";
    
    private ImageIcon errorIcon = null;
    private ImageIcon successIcon = null;
    private static final Color DEFAULT_COLOR = new Color(100, 100, 100, 100);
    
    
    public static final String CTE_SERVICIO = "Servicio";
    public static final String CTE_PROMOCION = "Promoción";
    public static final String CTE_TIT_ACTUALIZAR_RESERVA = "Actualizar Estado de Reserva";
    public static final String CTE_TIT_VER_RESERVA = "Ver información de Reserva";
    public static final String CTE_TIT_ELIMINAR_RESERVA = "Eliminar Reserva";
    public static final String CTE_TIT_VER_SERVICIO = "Ver informacion de Servicio";
    public static final String CTE_TIT_VER_PROMOCION = "Ver informacion de Promocion";
    public static final String CTE_TIT_VER_INFO_CLIENTE = "Ver informacion de Cliente";
    public static final String CTE_TIT_VER_INFO_PROVEEDOR = "Ver informacion de Proveedor";
    public static final String CTE_TIT_SELECCIONAR_SERVICIO = "Seleccionar Servicio";
    public static final String CTE_TIT_ACTUALIZAR_SERVICIO = "Actualizar Servicio";
    
    public static final String CTE_ITEM_SELECCIONAR = "Seleccionar";
    
    public static final String CTE_URL_IMAGEN_USER = "src/resources/User/";
    public static final String CTE_URL_IMAGEN_SERVICE = "src/resources/Service/";
    
    public SwingComponentUtil (){
    }

    /**
     * Crea una un aviso de información utilizando los parametro.
     * @param infoMessage
     * @param titleBar 
     */
    public void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE, getSuccessIcon());
    }

    /**
     * Crea un aviso de error utilizando los parametros
     * @param infoMessage
     * @param titleBar 
     */
    public void errorBox(String infoMessage, String titleBar)
    {     
        
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE, getErrorIcon());
    }
    
    /**
     * @return the errorIcon
     */
    public ImageIcon getErrorIcon() {
       
        if (Objects.isNull(errorIcon))
        {
           Image tempImage = (new ImageIcon(getClass().getResource("/resources/icons/error.png"))).getImage();
           errorIcon = new ImageIcon(tempImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
        
        }
        return errorIcon;
    }

    /**
     * @return the successIcon
     */
    public ImageIcon getSuccessIcon() {
        if (Objects.isNull(errorIcon))
        {
            Image tempImage = (new ImageIcon(getClass().getResource("/resources/icons/success.png"))).getImage();
            successIcon = new ImageIcon(tempImage.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));  
            
        }
        return successIcon;
    }
    
    public static TexturePaint createCheckerTexture(int cs, Color color) {
        int size = cs * cs;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setPaint(color);
        g2.fillRect(0, 0, size, size);
        for (int i = 0; i * cs < size; i++) {
            for (int j = 0; j * cs < size; j++) {
                if ((i + j) % 2 == 0) {
                    g2.fillRect(i * cs, j * cs, cs, cs);
                }
            }
        }
        g2.dispose();
        return new TexturePaint(img, new Rectangle(0, 0, size, size));
    }
    
    public static TexturePaint createCheckerTexture(int cs) {
        return createCheckerTexture(cs, DEFAULT_COLOR);
    }
    
    
    
//    public static Date combofechaToDate(String dia, String mes, String anio) {
//        
//        String aux;
//        String stringFecha;
//
//        if (dia.length() < 2)
//            aux = "0" + dia;
//        else
//            aux = dia;
//        stringFecha = aux + "/";
//        aux = "";
//
//        if (mes.length() < 2)
//            aux = "0" + mes;
//        else
//            aux = mes;
//        stringFecha += aux + "/";
//        aux = "";
//
//        stringFecha += anio;
//        
//        Date fecha = generalConverter(stringFecha, "Debe ingresar una fecha de nacimiento válida dd/mm/yyyy", Date.class);
//            
//        return fecha;  
//    
//    }
    
    public static String combofechaToString(String dia, String mes, String anio) {
        
        String aux;
        String stringFecha;

        if (dia.length() < 2)
            aux = "0" + dia;
        else
            aux = dia;
        stringFecha = aux + "/";
        aux = "";

        if (mes.length() < 2)
            aux = "0" + mes;
        else
            aux = mes;
        stringFecha += aux + "/";
        aux = "";

        stringFecha += anio;
            
        return stringFecha;  
    
        }       
  
    //public static Integer[] combodia = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    public static Integer[] combodia() {
    
        Integer[] res = new Integer[31]; 
        for(int i = 0; i < 31; i++) {
	    res[i]=i+1;
	}   
     return res;   
    }
       
    //public static Integer[] combomes = {1,2,3,4,5,6,7,8,10,11,12};
     public static Integer[] combomes() {
    
        
        Integer[] res = new Integer[12];
        for(int i = 0; i < 12; i++) {
	    res[i]=i+1;
	}   
     return res;   
    }
    
    
    //public static Integer[] comboanio = {2014};
     public static Integer[] comboanioadelante() {
    
        Integer[] res = new Integer[21];  
        for(int i = (Calendar.getInstance().get(Calendar.YEAR)),j=0; i <= (Calendar.getInstance().get(Calendar.YEAR) + 20); i++,j++) {
	    res[j]=i;
	}   
     return res;   
    }
     
    public static Integer[] comboanionacimiento() {
               
        Integer[] res = new Integer[121];  
        for(int i = (Calendar.getInstance().get(Calendar.YEAR)- 120),j=0; i <= (Calendar.getInstance().get(Calendar.YEAR)); i++,j++) {
	    res[j]=i;
	}   
     return res;   
    } 
}