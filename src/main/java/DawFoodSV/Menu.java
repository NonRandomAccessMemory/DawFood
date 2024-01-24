/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author vickyfg
 */
public class Menu {

    //icono("/Vistas/favicon.png")
    //Menú de encendidio 
    public void iniciarTPV() {
        //Menú encender maquina
        JOptionPane.showConfirmDialog(null, "Bienvenidos a DawFood", "DawFood", JOptionPane.DEFAULT_OPTION);
        //Bucle que muestra opción de encendido
        String[] botones = {"Encender", "StandBy"};
        boolean continuar = true;
        do {
            int variable = JOptionPane.showOptionDialog(null, "¿Quieres encender el TPV?",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                case 0 -> {

                    tipoUsuario();
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
    private void tipoUsuario() {
        //Elección tipo usuario
        String[] botones1 = {"Modo Administrador", "Modo Usuario", "Atrás"};
        boolean continuar1 = true;
        do {
            int variable1 = JOptionPane.showOptionDialog(null, "Seleccione modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú para admin
                case 0 -> {
                    modoAdmin();
                    break;
                }
                //Opcion apertura menú para user
                case 1 -> {
                    modoUserIni();
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
                            "Introduzca constraseña del TPV: ", "DawFood - Modo mantenimiento", JOptionPane.QUESTION_MESSAGE);
                }
            } else {
                //Sale del bucle y continua;
                JOptionPane.showMessageDialog(null, "Contraseña correcta", "DawFood", 0);
                opcionElegidAdmin();
            }
        } while (continuar3);

    }
    //Metodo de opciones del administrados
    private void opcionElegidAdmin() {
        String[] opcionesMenu1 = {"1-. Cambiar cualquier dato de los productos, excepto su ID.",
            "2-. Dar de alta nuevos productos.", "3-. Borrar productos existentes.",
            "4-. Consultar las ventas realizadas.", "5-. Atrás"};

        String opcionElegida;
        boolean continuar = true;

        do {
            opcionElegida = (String) JOptionPane.showInputDialog(null,
                    "Elige una opción", "DawFood - Modo Mantenimiento",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenu1, "1-. Cambiar cualquier dato de los productos, excepto su ID.");

            switch (opcionElegida) {
                case "1-. Cambiar cualquier dato de los productos, excepto su ID." -> {
                    System.out.println("1");
                    break;
                }
                case "2-. Dar de alta nuevos productos." -> {
                    System.out.println("2");
                    break;
                }
                case "3-. Borrar productos existentes." -> {
                    System.out.println("3");
                    break;
                }
                case "4-. Consultar las ventas realizadas." -> {
                    consultarVentasAdmin();
                    break;
                }
                case "5-. Atrás" -> {
                    tipoUsuario();
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);
    }

    private void consultarVentasAdmin() {
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
                    System.out.println("1");
                    break;

                }
                case "2-. Hasta una fecha concreta." -> {
                    System.out.println("2");
                    break;
                }
                case "3-. Todas las ventas que haya registradas." -> {
                    System.out.println("3");
                    break;
                }
                case "4-. Atrás" -> {
                    opcionElegidAdmin();
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);

    }

    private void modoUserIni() {
        boolean continuar = true;
        String[] botones = {"Comienza tu pedido", "<-"};
        do {
            int variable = JOptionPane.showOptionDialog(null, "Bienvenidos a DawFood ",
                    "DawFood", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                //Opcion apertura de menú pedido
                case 0 -> {
                    modoUserCarta();
                    break;
                }
                //Opcion apertura menú usuarios
                case 1 -> {
                    tipoUsuario();
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);
    }

    private void modoUserCarta() {
        //Eleccion menu 
        String[] botones1 = {"Ver COMIDAS", "Ver BEBIDAS", "Ver POSTRES", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú COMIDAS
                case 0 -> {
                    System.out.println("comida");
                    break;
                }
                //Opcion apertura menú BEBIDAS
                case 1 -> {
                    System.out.println("bebida");
                    break;
                }
                //Opcion apertura menú POSTRES
                case 2 -> {
                    System.out.println("Postre");
                    break;
                }

                //Opcion volver menu encendido
                case 3 -> {
                    modoUserIni();
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
