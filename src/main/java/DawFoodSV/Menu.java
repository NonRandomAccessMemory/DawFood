/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import DawFoodSV.ClasesFuncionamiento.Carrito;
import DawFoodSV.ClasesFuncionamiento.CartaComida;
import DawFoodSV.ClasesFuncionamiento.E_Categoria;
import DawFoodSV.ClasesFuncionamiento.E_SubCategoria;
import DawFoodSV.ClasesFuncionamiento.Producto;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author vickyfg
 */
public class Menu {

    //icono("/Vistas/favicon.png")
    //Menú de encendidio 
    public void iniciarTPV() {
        
        CartaComida carta= new CartaComida();
        Carrito carrito = new Carrito();
        //Menú encender maquina
        JOptionPane.showConfirmDialog(null, "Bienvenidos a DawFood", "DawFood", JOptionPane.DEFAULT_OPTION);
        //Bucle que muestra opción de encendido
        
        String[] botones = {"Encender", "StandBy"};
        boolean continuar = true;
        do {
            int variable = JOptionPane.showOptionDialog(null, "¿Quieres encender el TPV?",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                case 0 -> {

                    tipoUsuario(carta, carrito);
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
    private void tipoUsuario(CartaComida carta, Carrito carrito) {
        //Elección tipo usuario
        String[] botones1 = {"Modo Administrador", "Modo Usuario", "Atrás"};
        boolean continuar1 = true;
        do {
            int variable1 = JOptionPane.showOptionDialog(null, "Seleccione modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú para admin
                case 0 -> {
                    modoAdmin(carta, carrito);
                    break;
                }
                //Opcion apertura menú para user
                case 1 -> {
                    modoUserIni(carta, carrito);
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

    private void modoAdmin(CartaComida carta, Carrito carrito) {
        String password = generarPasswordAdmin();
        //Llamar a admin para usar contraseña generada
        String passwordIntroducida = JOptionPane.showInputDialog(null,
                "Introduzca constraseña del TPV: ", "DawFood - Modo mantenimiento", JOptionPane.WARNING_MESSAGE);
        boolean continuar3 = true;
        // contador de intentos
        int intentos = 0;
        // número máximo de intentos
        int maximo = 3;
        //Bucle para controlar que se introduce contraseña del TPV y un maximo de 3 veces para evitar accesos no deseados 
        do {
            if (passwordIntroducida.equals(password)) {
                intentos++;
                if (intentos == maximo) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado.Solo personal autorizado",
                            "DawFood - Modo mantenimiento", JOptionPane.ERROR_MESSAGE);
                    // salir del bucle
                    iniciarTPV();
                } else {
                    // repetir bucle                
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta, repitala.",
                            "DawFood - Modo mantenimiento", JOptionPane.WARNING_MESSAGE);
                    passwordIntroducida = JOptionPane.showInputDialog(null,
                            "Introduzca constraseña del TPV: ", "DawFood - Modo mantenimiento", JOptionPane.QUESTION_MESSAGE);
                }
            } else {
                //Sale del bucle y continua;
                JOptionPane.showMessageDialog(null, "Contraseña correcta", "DawFood", JOptionPane.INFORMATION_MESSAGE);
                opcionElegidAdmin(carta, carrito);
            }
        } while (continuar3);

    }

    //Metodo de opciones del administrados
    private void opcionElegidAdmin(CartaComida carta, Carrito carrito) {
        String[] opcionesMenu1 = {"1-. Cambiar cualquier dato de los productos, excepto su ID.",
            "2-. Dar de alta nuevos productos.", "3-. Borrar productos existentes.",
            "4-. Consultar las ventas realizadas.", "5-. Atrás"};
        boolean continuar = true;
        //Bucle que muestra las opciones de adminitracion
        do {
            String opcionElegida = (String) JOptionPane.showInputDialog(null,
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
                    consultarVentasAdmin(carta, carrito);
                    break;
                }
                case "5-. Atrás" -> {
                    tipoUsuario(carta, carrito);
                    break;
                }
                default -> {
                    continuar = false;
                    System.exit(1);
                }
            }
        } while (continuar);
    }

    private void consultarVentasAdmin(CartaComida carta, Carrito carrito) {
        String[] opcionesMenuVentas = {"1-. En un día concreto.",
            "2-. Hasta una fecha concreta.", "3-. Todas las ventas que haya registradas.", "4-. Atrás"};
        JOptionPane.showMessageDialog(
                null, "Consultar las ventas realizadas: ", "DawFood - Modo Mantenimiento", 0);
        String opcionesElegidaVentas;
        boolean continuar = true;

        do {
            opcionesElegidaVentas = (String) JOptionPane.showInputDialog(null,
                    "Consultar las ventas realizadas: ", "DawFood - Modo Mantenimiento",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opcionesMenuVentas, "");

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
                    opcionElegidAdmin(carta, carrito);
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);

    }

    private void modoUserIni(CartaComida carta, Carrito carrito) {
        boolean continuar = true;
        String[] botones = {"Comienza tu pedido", "<-"};
        do {
            int variable = JOptionPane.showOptionDialog(null, "Bienvenidos a DawFood ",
                    "DawFood", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            switch (variable) {
                //Opcion apertura de menú pedido
                case 0 -> {
                    modoUserCarta(carta, carrito);
                    break;
                }
                //Opcion apertura menú usuarios
                case 1 -> {
                    tipoUsuario(carta, carrito);
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);
    }

    private void modoUserCarta(CartaComida carta, Carrito carrito) {
        //Eleccion menu 
        String[] botones1 = {"Ver COMIDAS", "Ver BEBIDAS", "Ver POSTRES", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú COMIDAS
                case 0 -> {
                    System.out.println("comida");
                    cartaComidas(carta, carrito);
                    break;
                }
                //Opcion apertura menú BEBIDAS
                case 1 -> {
                    System.out.println("bebida");
                    cartaBebida(carta, carrito);
                    break;
                }
                //Opcion apertura menú POSTRES
                case 2 -> {
                    System.out.println("Postre");
                    break;
                }

                //Opcion volver menu encendido
                case 3 -> {
                    modoUserIni(carta, carrito);
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }
    
    private void cartaComidas(CartaComida carta,Carrito carrito) {
        //Eleccion menu comida 
        String[] botones1 = {"HAMBURGUESA", "PATATAS", "ENSALADAS", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA COMIDA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                
                case 0 -> {
                    System.out.println("HAMBURGUESA");
                    ArrayList<Producto> hamburguesas=carta.devolverPorSubcategoria(E_Categoria.Comida, E_SubCategoria.Hamburguesa);
                    if(!hamburguesas.isEmpty()){
                    Producto p= hamburguesas.get(1);
                    System.out.println(p.toString());
                    carrito.AñadirElemento(p, 1);
                    System.out.println(carrito.VerCarrito());}
                    
                    break;
                }
                
                case 1 -> {
                    System.out.println("PATATAS");
                    break;
                }
                
                case 2 -> {
                    System.out.println("ENSALADAS");
                    break;
                }

                
                case 3 -> {
                    modoUserCarta(carta, carrito);
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void cartaBebida(CartaComida carta,Carrito carrito) {
        //Eleccion menu 
        String[] botones1 = {"AZUCARADAS", "SIN AZUCAR", "BEBIDAS CALIENTES", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA BEBIDA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                
                case 0 -> {
                    System.out.println("AZUCARADAS");
                    break;
                }
                
                case 1 -> {
                    System.out.println("SIN AZUCAR");
                    break;
                }
                
                case 2 -> {
                    System.out.println("BEBIDAS CALIENTES");
                    break;
                }

                
                case 3 -> {
                    modoUserIni(carta, carrito);
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }
    
    private void cartaPostre(CartaComida carta,Carrito carrito) {
        //Eleccion menu 
        String[] botones1 = {"AZUCARADAS", "SIN AZUCAR", "BEBIDAS CALIENTES", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA BEBIDA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                
                case 0 -> {
                    System.out.println("AZUCARADAS");
                    break;
                }
                
                case 1 -> {
                    System.out.println("SIN AZUCAR");
                    break;
                }
                
                case 2 -> {
                    System.out.println("BEBIDAS CALIENTES");
                    break;
                }

                
                case 3 -> {
                    modoUserIni(carta, carrito);
                    break;
                }

                default -> {
                    continuar1 = false;
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

 
   public String generarPasswordAdmin() {
        //Array de contraseña
        String especiales = "#$%&()*+,-.:;<=>@";
        char[] passwordArray = new char[6];
        Random rndm= new Random();
        //Generea una letra minuscula (a - z)
        passwordArray[0] = RandomStringUtils.randomAlphabetic(1, 1).toLowerCase().charAt(0);

        //Generea una letra mayuscula (A - Z)
        passwordArray[1] = RandomStringUtils.randomAlphabetic(1, 1).toUpperCase().charAt(0);

        //Generea un numero(0 - 9)
        passwordArray[2] = RandomStringUtils.randomNumeric(1).charAt(0);

        //Genera tres caracteres especiales entre # $ % &  ( ) * + , - .  : ; < = > @
        passwordArray[3] = especiales.toCharArray()[rndm.nextInt(0,16)];

        // Rellenar las posiciones restantes de manera random
        for (int i = 4; i < 6; i++) {
            passwordArray[i] = RandomStringUtils.randomAscii(33, 126).charAt(0);
        }

        return String.valueOf(passwordArray);
    }
                                                                           
}
