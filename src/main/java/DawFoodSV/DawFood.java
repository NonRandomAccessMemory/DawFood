/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package DawFoodSV;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author snavgar
 */
public class DawFood {

    public static void main(String[] args) {

        //Instanciar la clase admin para ver la contraseña por consola
        Menu menu = new Menu();
        String password = menu.generarPasswordAdmin();
        menu.generarPasswordAdmin();
        // Imprimir cada elemento del array
        System.out.println("Contraseña generada: " + password);
        //Instanciar la clase que abre los menús
        menu.iniciarTPV();

    }

}
