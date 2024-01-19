/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import javax.swing.JOptionPane;

/**
 *
 * @author vickyfg
 */
public class Menu {
    //Menú de encendidio 
        public void Menu1(){
        JOptionPane.showMessageDialog(null, "Bienvenidos a DawFood");
            
        String[] opcionesMenu1 = {
            "1-. Encender el TPV",
            "2-. Salir",};
        
        String opcionElegida;
        boolean continuar = true;
        do {
            opcionElegida = (String) JOptionPane.showInputDialog(null,
                    "Encendiendo la maquina...", "DawFood",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenu1, "1-. Encender el TPV");
            switch (opcionElegida) {
                case "1-. Encender el TPV" -> {
                    
                    Menu2();
                    break;
                }

                default -> {
                    continuar = false;
                }
            }

        } while (continuar);

    }
    //Método para elegir menu de administración o usuario
    public void Menu2(){
    String mensaje3 = """
                      
                          Menú de administración
                      
                      """;

    JOptionPane.showMessageDialog(null, mensaje3);
    
    String[] opcionesMenu2 = {
            "1-. Menú Admin",
            "2-. Menú usuario",
            "3-. Atras"};
              
        String opcionElegida2;
        boolean continuar = true;
        do {
            opcionElegida2 = (String) JOptionPane.showInputDialog(null,
                    "hola", "DawFood",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenu2, "1-. Menú Admin");
            switch (opcionElegida2) {
                case "1-. Menú Admin" -> {
                    

                    break;
                }
                case "2-. Menú usuario" -> {

                    break;
                }
                case "3-. Atras" -> {

                    break;
                }

                default -> {
                    continuar = false;
                }
            }

        } while (continuar);
    }
    
}
    

