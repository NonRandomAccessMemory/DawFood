/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;

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
        //Llamar a admin para usar contraseña generada
        Admin admin = new Admin();
        String passwordIntroducida = JOptionPane.showInputDialog(null,
                "Introduzca constraseña del TPV: ", "DawFood - Modo mantenimiento", 0);
        boolean continuar3 = true;
        // contador de intentos
        int intentos = 0;
        // número máximo de intentos
        int maximo = 3;
        //Bucle para controlar que se introduce contraseña del TPV y un maximo de 3 veces para evitar accesos no deseados 
        do {
            if (passwordIntroducida.equals(Admin.generarPasswordAdmin())) {
                intentos++;
                if (intentos == maximo) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado.Solo personal autorizado",
                            "DawFood - Modo mantenimiento", 0);
                    // salir del bucle
                    iniciarTPV();
                } else {
                    // repetir bucle                
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta, repitala.",
                            "DawFood - Modo mantenimiento", 0);
                    passwordIntroducida = JOptionPane.showInputDialog(null,
                            "Introduzca constraseña del TPV: ", "DawFood - Modo mantenimiento", 1);
                }
            } else {
                //Sale del bucle y continua;
                JOptionPane.showMessageDialog(null, "Contraseña correcta", "DawFood", 0);
                opcionElegida();
            }
        } while (continuar3);
    }


    private void opcionElegida() {
        String[] opcionesMenu1 = {"1-. Cambiar cualquier dato de los productos, excepto su ID.",
            "2-. Dar de alta nuevos productos.", "3-. Borrar productos existentes.",
            "4-. Consultar las ventas realizadas.", "5-. Atrás"};

        JOptionPane.showMessageDialog(
                null, "Elige una opción: ", "DawFood - Modo Mantenimiento", 0);
        String opcionElegida;
        boolean continuar = true;

        do {
            opcionElegida = (String) JOptionPane.showInputDialog(null,
                    "Elige una opción", "DawFood - Modo Mantenimiento",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenu1, "1-. Cambiar cualquier dato de los productos, excepto su ID.");

            switch (opcionElegida) {
                case "1-. Cambiar cualquier dato de los productos, excepto su ID." -> {
                    break;
                }
                case "2-. Dar de alta nuevos productos." -> {
                    break;
                }
                case "3-. Borrar productos existentes." -> {
                    break;
                }
                case "4-. Consultar las ventas realizadas." -> {
                    consultarVentas();
                    break;
                }
                case "5-. Atrás" -> {
                    menu2();
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);
    }

    private void consultarVentas() {
        String[] opcionesMenuVentas = {"1-. En un día concreto.",
            "2-. Hasta una fecha concreta.", "3-. Todas las ventas que haya registradas.", "4.- Atrás"};
        JOptionPane.showMessageDialog(
                null, "Consultar las ventas realizadas: ", "DawFood - Modo Mantenimiento", 0);
        String opcionesElegidaVentas;
        boolean continuar = true;

        do {
            opcionesElegidaVentas = (String) JOptionPane.showInputDialog(null,
                    "Elige una opción", "DawFood - Modo Mantenimiento",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenuVentas, "1-. Cambiar cualquier dato de los productos, excepto su ID.");

            switch (opcionesElegidaVentas) {
                case "1-. En un día concreto." -> {
                    break;
                }
                case "2-. Hasta una fecha concreta." -> {
                    break;
                }
                case "3-. Todas las ventas que haya registradas." -> {
                    break;
                }
                case "4-. Atrás" -> {
                    opcionElegida();
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);

    }

    private void modoUser() {
        JOptionPane.showMessageDialog(null, "Bienvenidos a DawFood", "DawFood", 0);
        String[] botones1 = {"Ver COMIDAS", "Ver BEBIDAS", "Ver POSTRES", "<-"};
        boolean continuar1 = true;

        do {
            int variable = JOptionPane.showOptionDialog(null, "Seleccione modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable) {
                //Opcion apertura de menú COMIDAS
                case 0 -> {
                    
                    break;
                }
                //Opcion apertura menú BEBIDAS
                case 1 -> {
                    
                    break;
                }
                //Opcion apertura menú POSTRES
                case 2 -> {
                    
                    break;
                }

                //Opcion volver menu encendido
                case 3 -> {
                    modoUser();
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    public static String generarPasswordAdmin() {

        StringBuilder password = new StringBuilder();

        //Generea una letra minuscula (a - z)
        password.append(RandomStringUtils.randomAlphabetic(1).toLowerCase());

        //Generea una letra mayuscula (A - Z)
        password.append(RandomStringUtils.randomAlphabetic(1).toUpperCase());

        //Generea un numero(0 - 9)
        password.append(RandomStringUtils.randomNumeric(1));

        //Genera tres caracteres especiales entre # $ % &  ( ) * + , - .  : ; < = > @
        password.append(RandomStringUtils.randomAscii(35, 38));
        password.append(RandomStringUtils.randomAscii(40, 46));
        password.append(RandomStringUtils.randomAscii(58, 64));

        if (password.length() > 6) {
            password.setLength(6);
        }
        return password.toString();
    }
}
