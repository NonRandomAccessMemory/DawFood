/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import DawFoodSV.ClasesFuncionamiento.Carrito;
import DawFoodSV.ClasesFuncionamiento.CartaComida;
import DawFoodSV.ClasesFuncionamiento.E_Categoria;
import DawFoodSV.ClasesFuncionamiento.E_SubCategoria;
import DawFoodSV.ClasesFuncionamiento.E_Usuario;
import DawFoodSV.ClasesFuncionamiento.Producto;
import DawFoodSV.ClasesFuncionamiento.TarjetaCredito;
import DawFoodSV.ClasesFuncionamiento.Ticket;
import DawFoodSV.ClasesFuncionamiento.Tpv;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Arrays;
import java.util.Random;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author vickyfg
 */
public class Menu {

    //icono("/Vistas/favicon.png")
    //Menú de encendidio 
    public void iniciarTPV() {

        ImageIcon iconoFavicon = new ImageIcon("src/main/java/DawFood/favicon.png");
        CartaComida carta = new CartaComida();
        Carrito carrito = new Carrito();
        Tpv ventas = new Tpv();
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
                    tipoUsuario(carta, carrito, ventas);
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
    private void tipoUsuario(CartaComida carta, Carrito carrito, Tpv ventas) {
        //Elección tipo usuario
        String[] botones1 = {"Modo Administrador", "Modo Usuario", "Atrás"};
        boolean continuar1 = true;
        do {
            int variable1 = JOptionPane.showOptionDialog(null, "Seleccione modo de acceso: ",
                    "DawFood", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú para admin
                case 0 -> {
                    modoAdmin(carta, carrito, ventas, categoria);
                    break;
                }
                //Opcion apertura menú para user
                case 1 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Opcion volver menu encendido
                case 2 -> {
                    iniciarTPV(categoria);
                    break;
                }

                default -> {
                    iniciarTPV(categoria);
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void modoAdmin(CartaComida carta, Carrito carrito, Tpv ventas, E_Categoria categoria) {
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
                opcionElegidAdmin(carta, carrito, ventas);
            }
        } while (continuar3);

    }

    //Metodo de opciones del administrados
    private void opcionElegidAdmin(CartaComida carta, Carrito carrito, Tpv ventas) {
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
                    /*Selecionar tipo de producto
                      mostrar lista con Productos
                      Seleccionar Producto
                      insertar producto cambiado*/
                    break;
                }
                case "2-. Dar de alta nuevos productos." -> {
                    System.out.println("2");
                    /*
                    JOptionPane.showInputDialog();
                    Producto p= new Producto();
                    carta.InsertarProducto(p, E_Usuario.Administrador);
                     */
                    break;
                }
                case "3-. Borrar productos existentes." -> {
                    System.out.println("3");
                    String productosDisponibles = MostrarPorCategoria(carta, carrito, E_Categoria.Comida);
                    /*Sacar Metodo*/
                    String eleccionHb = JOptionPane.showInputDialog(null, productosDisponibles, "DawFood", 0);
                    boolean estahecho = carta.BorrarProducto(new Producto(Integer.parseInt(eleccionHb)), E_Usuario.Administrador);
                    if (estahecho) {
                        JOptionPane.showMessageDialog(null, "Elemento Borrado!");
                    } else {
                    }
                    break;
                }
                case "4-. Consultar las ventas realizadas." -> {
                    consultarVentasAdmin(carta, carrito, ventas);
                    break;
                }
                case "5-. Atrás" -> {
                    tipoUsuario(carta, carrito, ventas);
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(1);
                }
            }
        } while (continuar);
    }

    private void consultarVentasAdmin(CartaComida carta, Carrito carrito, Tpv ventas) {
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
                    /*añadir dia*/
                    String eleccionHb = JOptionPane.showInputDialog(null, "Introduzca un dia", "DawFood", 0);
                    ArrayList<Ticket> tickets;
                    tickets = ventas.BuscarPor(Integer.parseInt(eleccionHb));
                    tickets.forEach((p) -> p.toString());
                    break;

                }
                case "2-. Hasta una fecha concreta." -> {
                    System.out.println("2");
                    String dia = new String();
                    String mes = new String();
                    String eleccionHb = JOptionPane.showInputDialog(null, "Introduzca una fecha", "DawFood", 0);
                    dia = eleccionHb.substring(0, eleccionHb.indexOf('/'));
                    mes = eleccionHb.substring(eleccionHb.indexOf('/'));
                    /*Extraer el día usando / como descartador*/
 /*Extraer el mes*/
                    ventas.BuscarPor(LocalDate.of(Integer.parseInt(dia), Month.of(Integer.parseInt(mes)), LocalDate.now().getYear()));

                    break;
                }
                case "3-. Todas las ventas que haya registradas." -> {
                    System.out.println("3");
                    StringBuilder sb = new StringBuilder();
                    ArrayList<Ticket> ventasRealizadas;
                    ventasRealizadas = ventas.todasLasVentas();
                    int contador = 0;
                    for (Ticket t : ventasRealizadas) {
                        contador += 1;
                        sb.append("Venta:").append(contador).append(t.getId()).append("   ")
                                .append("Fecha: ").append(t.getFecha().getDayOfMonth())
                                .append("/").append(t.getFecha().getDayOfYear()).append("\n");

                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;
                }
                case "4-. Atrás" -> {
                    opcionElegidAdmin(carta, carrito, ventas);
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);

    }

    private void modoUserIni(CartaComida carta, Carrito carrito, Tpv ventas, E_Categoria categoria) {
        boolean continuar = true;
        String[] botones = {"Pedido", "<-"};
        do {
            int variable = JOptionPane.showOptionDialog(null, "Bienvenidos a DawFood ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones, botones[0]);
            switch (variable) {
                //Opcion apertura de menú pedido
                case 0 -> {
                    modoUserCarta(carta, carrito, ventas, categoria);
                    break;
                }
                //Opcion apertura menú usuarios
                case 1 -> {
                    tipoUsuario(carta, carrito, ventas);
                    break;
                }
                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }
        } while (continuar);
    }

    private void modoUserCarta(CartaComida carta, Carrito carrito, Tpv ventas) {
        //Eleccion menu 
        String[] botones1 = {"Ver COMIDAS", "Ver BEBIDAS", "Ver POSTRES", "Ver la Cesta", "Pagar", "<-"};
        boolean continuar1 = true;

        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {
                //Opcion apertura de menú COMIDAS
                case 0 -> {
                    System.out.println("comida");
                    cartaComidas(carta, carrito, ventas);
                    break;
                }
                //Opcion apertura menú BEBIDAS
                case 1 -> {
                    System.out.println("bebida");
                    //cartaBebida(carta, carrito, ventas);
                    break;
                }
                //Opcion apertura menú POSTRES
                case 2 -> {
                    System.out.println("Postre");
                    cartaPostre(carta, carrito, ventas);
                    break;
                }

                case 3 -> {
                    System.out.println("Ver La cesta");
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }

                case 4 -> {
                    System.out.println("Pagar");
                    /*
                     Muestra el carrito y solicita el numero te tarjeta
                     Mostrar el estado de la venta
                     Muestra si se ha realizado bien el proceso*/
                    JOptionPaneMuestra(carrito.VerCarrito());
                    String numeroTarjeta = JPaneInserta("Inserte el numero de tarjeta");
                    JOptionPaneMuestra(carrito.ProcesarCompra(numeroTarjeta));

                    /*Mostrar el estado de la venta*/
 /*Eliminar todos los productos del carrito*/
                    break;
                }
                //Opcion volver menu encendido
                case 5 -> {
                    modoUserIni(carta, carrito, ventas, categoria);
                    break;
                }

                default -> {
                    iniciarTPV(categoria);
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void cartaComidas(CartaComida carta, Carrito carrito, Tpv ventas, E_Categoria categoria) {
        //Eleccion menu comida 
        String[] botones1 = {"HAMBURGUESA", "PATATAS", "ENSALADAS", "<-"};
        boolean continuar1 = true;
        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA COMIDA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {
                case 0 -> {
                    String nombre = "HAMBURGUESA";
                    carta.devolverPorNombre(categoria, nombre);
                    break;
                }
                case 1 -> {
                    System.out.println("PATATAS");
                    cartaPatatas(carta, carrito, ventas, categoria);
                    break;
                }

                case 2 -> {
                    System.out.println("ENSALADAS");
                    mostrarYSeleccionar(carta, carrito, E_Categoria.Comida, E_SubCategoria.Ensalada);
                    break;
                }

                case 3 -> {
                    modoUserCarta(carta, carrito, ventas, categoria);
                    break;
                }

                default -> {
                    iniciarTPV(categoria);
                    System.exit(0);
                }
            }
        } while (continuar1);

    }

    private void cartaHamburguesa(CartaComida carta, Carrito carrito, Tpv ventas) {
        //Eleccion menu 
        String[] botones1 = {"SIMPLE", "MCFIT", "CON QUESO", "Menú Incio", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Elige una HAMBURGUESA: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("SIMPLE");
                    carta.devolverPorNombre(E_Categoria.Comida, "SIMPLE");

                    break;
                }

                case 1 -> {
                    System.out.println("MCFIT");
                    carta.devolverPorNombre(E_Categoria.Comida, "MCFIT");
                    break;
                }

                case 2 -> {
                    System.out.println("CON QUESO");
                    carta.devolverPorNombre(E_Categoria.Comida, "CON QUESO");
                    break;
                }

                case 3 -> {
                    System.out.println("Volver al menu inical");
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
                case 4 -> {
                    modoUserCarta(carta, carrito, ventas);
                    break;
                }

                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void cartaPatatas(CartaComida carta, Carrito carrito, Tpv ventas, E_Categoria categoria) {
        //Eleccion menu 
        String[] botones1 = {"FINAS", "CLÁSICAS", "GAJO", "Menú Incio", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Elige una HAMBURGUESA: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("FINAS");
                    carta.devolverPorNombre(E_Categoria.Comida, "FINAS");
                    break;
                }

                case 1 -> {
                    System.out.println("CLÁSICAS");
                    carta.devolverPorNombre(E_Categoria.Comida, "CLÁSICAS");
                    break;
                }

                case 2 -> {
                    System.out.println("GAJO");
                    carta.devolverPorNombre(E_Categoria.Comida, "GAJO");
                    break;
                }

                case 3 -> {
                    System.out.println("Volver al menu inical");
                    modoUserIni(carta, carrito, ventas, categoria);
                    break;
                }
                case 4 -> {
                    modoUserCarta(carta, carrito, ventas, categoria);
                    break;
                }

                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }

        } while (continuar1);
    }
    
    private void cartaHamburguesa(CartaComida carta, Carrito carrito, Tpv ventas) {
        //Eleccion menu 
        String[] botones1 = {"SIMPLE", "MCFIT", "CON QUESO", "Menú Incio", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Elige una HAMBURGUESA: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("SIMPLE");
                    carta.devolverPorNombre(E_Categoria.Comida, "SIMPLE");

                    break;
                }

                case 1 -> {
                    System.out.println("MCFIT");
                    carta.devolverPorNombre(E_Categoria.Comida, "MCFIT");
                    break;
                }

                case 2 -> {
                    System.out.println("CON QUESO");
                    carta.devolverPorNombre(E_Categoria.Comida, "CON QUESO");
                    break;
                }

                case 3 -> {
                    System.out.println("Volver al menu inical");
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
                case 4 -> {
                    modoUserCarta(carta, carrito, ventas);
                    break;
                }

                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    private void cartaEnsalada(CartaComida carta, Carrito carrito, Tpv ventas, E_Categoria categoria) {
        //Eleccion menu 
        String[] botones1 = {"MIXTA", "CESAR", "DAWFOOD", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Carta POSTRES: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("MIXTA");
                    carta.devolverPorNombre(E_Categoria.Comida, "MIXTA");
                    break;
                }

                case 1 -> {
                    System.out.println("CESAR");
                    carta.devolverPorNombre(E_Categoria.Comida, "CESAR");
                    break;
                }

                case 2 -> {
                    System.out.println("DAWFOOD");
                    carta.devolverPorNombre(E_Categoria.Comida, "DAWFOOD");
                    break;
                }

                case 3 -> {
                    //Hay que llamar al carrito
                    carrito.VerCarrito(carta, carrito,ventas);
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas, categoria);
                    break;
                }

                default -> {
                    iniciarTPV();
                    System.exit(0);
                }
            }

        } while (continuar1);
    }

    public String generarPasswordAdmin() {
        //Array de contraseña
        String especiales = "#$%&()*+,-.:;<=>@";
        char[] passwordArray = new char[6];
        Random rndm = new Random();
        //Generea una letra minuscula (a - z)
        passwordArray[0] = RandomStringUtils.randomAlphabetic(1, 1).toLowerCase().charAt(0);

        //Generea una letra mayuscula (A - Z)
        passwordArray[1] = RandomStringUtils.randomAlphabetic(1, 1).toUpperCase().charAt(0);

        //Generea un numero(0 - 9)
        passwordArray[2] = RandomStringUtils.randomNumeric(1).charAt(0);

        //Genera tres caracteres especiales entre # $ % &  ( ) * + , - .  : ; < = > @
        passwordArray[3] = especiales.toCharArray()[rndm.nextInt(0, 16)];

        // Rellenar las posiciones restantes de manera random
        for (int i = 4; i < 6; i++) {
            passwordArray[i] = RandomStringUtils.randomAscii(33, 126).charAt(0);
        }

        return String.valueOf(passwordArray);
    }

    //Metodos de Operacion
    public String MostrarPorCategoria(CartaComida carta, Carrito carrito, E_Categoria categoria) {
        ArrayList<Producto> productos = new ArrayList<>();
        //Switch para seleccionar la lista deseada
        switch (categoria.get_TipoProducto()) {

            case "Comida":
                productos = carta.get_Comidas();
                break;
            case "Bebida":
                productos = carta.get_Bebidas();
                break;
            case "Postre":
                productos = carta.get_Postres();
                break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("ID ").append("Nombre").append(" ").append("Precio").append("\n");
        for (Producto p : productos) {
            sb.append(p.get_id().intValue()).append("  ").append(p.get_nombre()).append(" ").append(p.get_precio()).append("\n");
        }

        return sb.toString();
    }

    /*public Producto elegirProductoYCantidad(CartaComida carta){
        ArrayList<Producto> produc;
        for(Producto p : produc){
        
            if(p.get_nombre()== nombre){
                return p;
                break;}
        }
        
    }*/

    public void mostrarYSeleccionar(CartaComida carta, Carrito carrito, E_Categoria categoria, E_SubCategoria subcategoria) {
        ArrayList<Producto> productos = carta.devolverPorSubcategoria(categoria, subcategoria);
        //en una variable del tipo string almacenar con un for la lista y su posicion

        StringBuilder sb = new StringBuilder();
        int posicion = 0;
        for (Producto p : productos) {
            posicion += 1;
            sb.append(p.get_nombre()).append(" ").append(p.get_precio()).append("\n");
        }
        //imprimir con el JoptionPane el string
        String eleccionHb = JOptionPane.showInputDialog(null, sb.toString(), "DawFood", 0);

        if (!productos.isEmpty()) {
            Producto p = productos.get((Integer.parseInt(eleccionHb) - 1));
            System.out.println(p.toString());
            carrito.AñadirElemento(p, 1);
            System.out.println(carrito.VerCarrito());
        }

    }

    //Método que nos servira para añadir cantidad
    public void elegirCantidadProducto(CartaComida carta, Carrito carrito, E_Categoria categoria, E_SubCategoria subcategoria) {
        ArrayList<Producto> productos = carta.devolverPorSubcategoria(categoria, subcategoria);
        /*en una variable del tipo string almacenar con un for la lista y su posicion*/

        StringBuilder sb = new StringBuilder();
        int posicion = 0;
        for (Producto p : productos) {
            posicion += 1;
            sb.append(posicion).append(p.get_nombre()).append(" ").append(p.get_precio()).append("\n");
        }
        //imprimir con el JoptionPane el string
        boolean continuar = false;
        do {
            try {
                int eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, sb.toString(), "Elige una opción"));
                System.out.println("eleccion: " + eleccion);

                if (eleccion <= 0 || eleccion > productos.size()) {
                    JOptionPane.showMessageDialog(null, "La eleccion tiene que ser en el rango mostrado");
                    continuar = true;
                } else {
                    if (!productos.isEmpty()) {
                        Producto p = productos.get(eleccion - 1);
                        System.out.println(p.toString());
                        carrito.AñadirElemento(p, 1);
                        System.out.println(carrito.VerCarrito());
                        continuar = false;
                    }
                }
            } catch (NumberFormatException e) {
                continuar = true;
                JOptionPane.showMessageDialog(null, "Tienes que elegir un numero");
            }

        } while (continuar);

    }

    public void JOptionPaneMuestra(String mensaje) {
        JOptionPane.showInputDialog(null, mensaje);
    }

    public String JPaneInserta(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }
}
