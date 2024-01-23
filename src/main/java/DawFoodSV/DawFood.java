/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package DawFoodSV;

import javax.swing.JOptionPane;

/**
 *
 * @author snavgar
 */
public class DawFood {

    public static void main(String[] args) {
        
        //Instanciar la clase admin para ver la contraseña por consola
        Admin admin = new Admin();
        System.out.println(admin.generarPasswordAdmin());
        //Instanciar la clase que abre los menús
        Menu menu = new Menu();
        menu.iniciarTPV();
        
        
        
        
       
    }
   
    }
