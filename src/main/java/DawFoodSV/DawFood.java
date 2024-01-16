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
        
        String mensaje = """
                      
                         Bienvenidos a DawFood
                      
                      """;
        
        JOptionPane.showInputDialog(null, mensaje);
        
        String[] opcionesMenu1 = {
            "1-. Cofigura tu menú",
            "2-. Salir",
            "3-. Otras opciones de Adimn",};
        JOptionPane.showMessageDialog(null, opcionesMenu1);
        String opcionElegida;
        boolean continuar = true;
         do {
        
        opcionElegida = (String) JOptionPane.showInputDialog(null,
                "Elige una opción", "DawFood",
                JOptionPane.QUESTION_MESSAGE, null,
                opcionesMenu1, "1-. Cofigura tu menú");
        switch (opcionElegida) {
            case "1-. Cofigura tu menú" -> {
                 
                 
            break;
        }
            
            case "2-. Salir" -> {
                continuar = false;
                break;
            }
            case "3-. Otras opciones de Adimn"-> {
                
            break;
            }
            default -> {
                continuar = false;
            }
            }
        
        
        } while(continuar);
        
    }
}
