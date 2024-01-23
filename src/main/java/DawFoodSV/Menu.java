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
    public void iniciarTPV() {
        //Menú encender maquina
        JOptionPane.showConfirmDialog(null, "Bienvenidos a DawFood", "DawFood", JOptionPane.DEFAULT_OPTION);

        String[] botones = {"Encender", "StandBy"};
        boolean continuar = true;
        do {
            int variable = JOptionPane.showOptionDialog(null, "¿Quieres encender el TPV?",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                case 0 -> {

                    menu2();
                    break;
                }

                case 1 -> {
                    iniciarTPV();
                    break;
                }

                default -> {
                    continuar = false;
                    System.exit(0);
                }
            }

        } while (continuar);
    }

    //Método para elegir menu de administración o usuario
    private void menu2() {
        //Elección tipo usuario

        String[] botones1 = {"Modo Administrador", "Modo Usuario", "Atrás"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, "Seleccione modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú para admin
                case 0 -> {
                    modoAdmin();
                    break;
                }
                //Opcion apertura menú para user
                case 1 -> {
                    modoUser();
                    break;
                }

                //Opcion volver menu encendido
                case 2 -> {
                    iniciarTPV();
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void modoAdmin() {
        Admin admin = new Admin();
        JOptionPane.showMessageDialog(null, "Modo mantenimiento", "DawFood", 0);

        String contraseñaIntroducida = JOptionPane.showInputDialog("Introduzca constraseña del TPV: ");
        if (contraseñaIntroducida == admin.generarPasswordAdmin()){
            JOptionPane.showMessageDialog(null, "Contraseña correcta", "DawFood", 0);
        }else {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
        }

        JOptionPane.showMessageDialog(null, "");
    }

    private void modoUser() {
    }
}
