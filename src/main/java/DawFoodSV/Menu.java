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
    public void Menu1() {
        //Menú encender maquina
        JOptionPane.showMessageDialog(null, "Bienvenidos a DawFood");
        String[] botones = {"Encender", "StandBy"};
        boolean continuar = true;
        do {
            int variable = JOptionPane.showOptionDialog(null, "¿Quieres encender el TPV?",
                    "Bienvenidos a DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                case 0 -> {

                    Menu2();
                    break;
                }

                case 1 -> {
                    continuar = false;
                    break;
                }

                default -> {
                    continuar = false;
                }
            }

        } while (continuar);
    }

    //Método para elegir menu de administración o usuario
    public void Menu2() {
        //Elección tipo usuario
        
        String[] botones1 = {"Modo Administrador", "Modo Usuario", "Atrás"};
        boolean continuar = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, "Modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú para admin
                case 1 -> {
                    Admin();
                    break;
                }
                //Opcion apertura menú para user
                case 2 -> {
                    User();
                    break;
                }
                
                //Opcion volver menu encendido
                case 3 -> {
                    
                    continuar = false;
                    break;
                }

                default -> {
                    continuar = false;
                }
            }

        } while (continuar);
    }

    
    public void Admin(){
        
        JOptionPane.showMessageDialog(null, "Modo mantenimiento ");
        String contraseñaIntroducida = JOptionPane.showInputDialog("Introduzca constraseña del TPV: ");
        //String contraseñaIntroducida = Integer.parseInt(eleccion);
        JOptionPane.showMessageDialog(null, "");
    }
    public void User(){
    }
}
