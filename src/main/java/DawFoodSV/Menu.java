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
                    modoAdmin(carta, carrito, ventas);
                    break;
                }
                //Opcion apertura menú para user
                case 1 -> {
                    modoUserIni(carta, carrito, ventas);
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

    private void modoAdmin(CartaComida carta, Carrito carrito, Tpv ventas) {
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
                    String[] opcionesCambiardatos = {"1-. Hamburguesas", "2-. Patatas.", "3-. Ensaladas.", "4-. Atrás"};

                    String opcionElegidaCambiardatos = (String) JOptionPane.showInputDialog(null,
                            "Elige una opción", "DawFood - Modo Mantenimiento",
                            JOptionPane.QUESTION_MESSAGE, null,
                            opcionesCambiardatos, "4-. Atrás");

                    switch (opcionElegidaCambiardatos) {
                        case "1-. Hamburguesas":
                            elegirYModificar(carta.devolverPorSubcategoria(E_Categoria.Comida, E_SubCategoria.Hamburguesa), carta);
                            break;
                        case "2-. Patatas.":
                            elegirYModificar(carta.devolverPorSubcategoria(E_Categoria.Comida, E_SubCategoria.Hamburguesa), carta);
                            break;
                        case "3-. Ensaladas.":
                            elegirYModificar(carta.devolverPorSubcategoria(E_Categoria.Comida, E_SubCategoria.Hamburguesa), carta);
                            break;
                        default:
                            iniciarTPV();
                            System.exit(0);
                            break;
                    }

                    break;
                }
                case "2-. Dar de alta nuevos productos." -> {
                    System.out.println("2");
                    Producto p = new Producto(carta.get_Comidas().size() + 1);
                    p.setNombre(JPaneInserta("Inserte el Nombre del producto"));
                    /*AÑADIR SELECCIONAR TIPO PRODUCTO*/
                    p.Categoria = E_Categoria.Comida;
                    p.subCategoria = E_SubCategoria.Hamburguesa;
                    p.setDescripcion(JPaneInserta("Inserte la descripcion"));
                    p.setPrecio(Double.parseDouble(JPaneInserta("Inserte Precio")));
                    p.setStock(Integer.parseInt(JPaneInserta("Inserte el numero de stock")));
                    carta.InsertarProducto(p, E_Usuario.Administrador);
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
                    continuar = false;
                    System.exit(0);
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
                        contador++;
                        sb.append("Venta:").append(t.getId()).append("   ")
                                .append("Fecha: ").append(t.getFecha().getDayOfMonth())
                                .append("/").append(t.getFecha()).append("\n").append(t.toString());

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

    private void modoUserIni(CartaComida carta, Carrito carrito, Tpv ventas) {
        boolean continuar = true;
        String[] botones = {"Pedido", "<-"};
        do {
            int variable = JOptionPane.showOptionDialog(null, "Bienvenidos a DawFood ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones, botones[0]);
            switch (variable) {
                //Opcion apertura de menú pedido
                case 0 -> {
                    modoUserCarta(carta, carrito, ventas);
                    break;
                }
                //Opcion apertura menú usuarios
                case 1 -> {
                    tipoUsuario(carta, carrito, ventas);
                    break;
                }
                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
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
                    cartaBebidas(carta, carrito, ventas);
                    break;
                }
                //Opcion apertura menú POSTRES
                case 2 -> {
                    System.out.println("Postres");
                    cartaPostres(carta, carrito, ventas);
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

                    //Mostrar el estado de la venta
                    //Eliminar todos los productos del carrito
                    break;
                }
                //Opcion volver menu encendido
                case 5 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

            }

        } while (continuar1);
    }

    private void cartaComidas(CartaComida carta, Carrito carrito, Tpv ventas) {
        //Eleccion menu comida 
        String[] botones1 = {"HAMBURGUESA", "PATATAS", "ENSALADAS", "<-"};
        boolean continuar1 = true;
        do {
            int variable1 = JOptionPane.showOptionDialog(null, " CARTA COMIDA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {
                case 0 -> {
                    String nombre = "HAMBURGUESA";
                    cartaHamburguesa(carta, carrito, ventas);
                    break;
                }
                case 1 -> {
                    System.out.println("PATATAS");
                    cartaPatatas(carta, carrito, ventas);
                    break;
                }

                case 2 -> {
                    System.out.println("ENSALADAS");
                    cartaEnsalada(carta, carrito, ventas);
                    break;
                }

                case 3 -> {
                    modoUserCarta(carta, carrito, ventas);
                    break;
                }
                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }
        } while (continuar1);

    }

    private void cartaHamburguesa(CartaComida carta, Carrito carrito, Tpv ventas) {
        ArrayList<Producto> comidas = carta.get_Comidas();

        //Eleccion menu 
        String[] botones1 = {"SIMPLE", "MCFIT", "CON QUESO", "Menú Incio", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Elige una HAMBURGUESA: ",
                    "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {

                    System.out.println("SIMPLE");
                    String nombreProducto = "Hamburguesa simple";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 1 -> {
                    System.out.println("MCFIT");
                    String nombreProducto = "Hamburguesa Mcfit[Pollo]";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("CON QUESO");
                    String nombreProducto = "Hamburguesa con queso";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
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

                case 5 -> {
                    iniciarTPV();
                }
                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void cartaPatatas(CartaComida carta, Carrito carrito, Tpv ventas) {
        ArrayList<Producto> comidas = carta.get_Comidas();
        //Eleccion menu 
        String[] botones1 = {"FINAS", "CLÁSICAS", "GAJO", "Menú Incio", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Elige una HAMBURGUESA: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("FINAS");
                    String nombreProducto = "Patatas finas";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 1 -> {
                    System.out.println("CLASICAS");
                    String nombreProducto = "Patatas finas";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("GAJO");
                    String nombreProducto = "Patatas Gajo";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
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

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void cartaEnsalada(CartaComida carta, Carrito carrito, Tpv ventas) {
        ArrayList<Producto> comidas = carta.get_Comidas();
        //Eleccion menu 
        String[] botones1 = {"MIXTA", "CESAR", "DAWFOOD", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(null, "Carta ENSALADAS: ", "DawFood", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/main/java/DawFood/favicon.png"), botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("MIXTA");
                    String nombreProducto = "Ensalada mixta";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 1 -> {
                    System.out.println("CESAR");
                    String nombreProducto = "Ensalada cesar";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("DAWFOOD");
                    String nombreProducto = "Ensalada DawFood";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(comidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Comida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 3 -> {
                    //Hay que llamar al carrito
                    carrito.VerCarrito();
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void cartaBebidas(CartaComida carta, Carrito carrito, Tpv ventas) {
       
        //Eleccion menu 
        String[] botones1 = {"CERVEZA", "REFRESCOS AZ", "REFRESCOS CERO", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta BEBIDAS: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("CERVEZA");
                    mostrarCervezas(carta, carrito, ventas);
                    break;
                }

                case 1 -> {
                    System.out.println("REFRESCOS AZ");
                    mostrarRefrescos(carta, carrito, ventas);
                    break;
                }

                case 2 -> {
                    System.out.println("REFRESCOS CERO");
                    mostrarRefrescosCero(carta, carrito, ventas);
                    break;
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void mostrarCervezas(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> bebidas = carta.get_Bebidas();
        //Eleccion menu 
        String[] botones1 = {"CERVEZA", "CERVEZA 0%0", "DawFood DobleLupulo", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta CERVEZAS: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("CERVEZA");
                    String nombreProducto = "Ceveza";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 1 -> {
                    System.out.println("CERVEZA 0%0");
                    String nombreProducto = "Cerveza sin";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("DawFood DobleLupulo");
                    String nombreProducto = "Cerveza DawFood - Doble lupulo";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void mostrarRefrescos(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> bebidas = carta.get_Bebidas();
        //Eleccion menu 
        String[] botones1 = {"PEPSI", "KAS", "NESTEA", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta REFRESCOS: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("PEPSI");
                    String nombreProducto = "Pepsi";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 1 -> {
                    System.out.println("KAS");
                    String nombreProducto = "Kas";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 2 -> {
                    System.out.println("NESTEA");
                    String nombreProducto = "Nestea";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }

    private void mostrarRefrescosCero(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> bebidas = carta.get_Bebidas();
        //Eleccion menu 
        String[] botones1 = {"PEPSI MAX", "KAS MAX", "AQUARADE MAX", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta REFRESCOS CERO: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("PEPSI MAX");
                    String nombreProducto = "Pepsi Max";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 1 -> {
                    System.out.println("KAS MAX");
                    String nombreProducto = "Kas Max";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("AQUARADE MAX");
                    String nombreProducto = "Aquarade Max";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Bebida, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }
     private void cartaPostres(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> postres = carta.get_Postres();
        //Eleccion menu 
        String[] botones1 = {"HELADOS", "POSTRES CASEROS", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta POSTRES: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

               case 0 -> {
                    System.out.println("HELADOS");
                    mostrarHelados(carta, carrito, ventas);
                    break;
                }

                case 1 -> {
                    System.out.println("POSTRES CASEROS");
                    mostrarPCaseros(carta, carrito, ventas);
                    break;
                }
               
                case 2 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 3 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

            }

        } while (continuar1);
    }
     
    private void mostrarHelados(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> bebidas = carta.get_Bebidas();
        //Eleccion menu 
        String[] botones1 = {"CAFE HELADO", "MCDAWFLURRY", "CONO CHOCONATA", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta HELADOS: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("CAFE HELADO");
                    String nombreProducto = "CafeConHelado";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 1 -> {
                    System.out.println("MCDAWFLURRY");
                    String nombreProducto = "McDawFlurry";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("CONO CHOCONATA");
                    String nombreProducto = "ConoChocolateNata";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
                }
            }

        } while (continuar1);
    }
    
    private void mostrarPCaseros(CartaComida carta, Carrito carrito, Tpv ventas) {
         ArrayList<Producto> bebidas = carta.get_Bebidas();
        //Eleccion menu 
        String[] botones1 = {"MOCHI", "YOGUR CON TOPPIN", "TARTA DE QUESO", "Ver Carriro", "<-"};
        boolean continuar1 = true;

        do {

            int variable1 = JOptionPane.showOptionDialog(
                    null,
                    "Carta POSTRES CASEROS: ",
                    "DawFood",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("src/main/java/DawFood/favicon.png"),
                    botones1, botones1[0]);
            switch (variable1) {

                case 0 -> {
                    System.out.println("MOCHI");
                    String nombreProducto = "Mochi";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;                 
                }

                case 1 -> {
                    System.out.println("YOGUR CON TOPPIN");
                    String nombreProducto = "Yogur con toppin";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 2 -> {
                    System.out.println("TARTA DE QUESO");
                    String nombreProducto = "Tarta de queso";
                    String informacionHamburguesa = carta.obtenerInformacionProducto(bebidas, nombreProducto);
                    String cantidad = JPaneInserta(informacionHamburguesa + "\nInserte la cantidad deseada");
                    Producto hamburguesa = carta.devolverPorNombre(E_Categoria.Postre, nombreProducto);
                    carrito.AñadirElemento(hamburguesa, Integer.parseInt(cantidad));
                    break;
                }

                case 3 -> {
                    //Llamar al carrito
                    JOptionPaneMuestra(carrito.VerCarrito());
                    break;
                }
                case 4 -> {
                    modoUserIni(carta, carrito, ventas);
                    break;
                }

                //Cuando pulsa la X salta al inicio de user
                default -> {
                    JOptionPane.showMessageDialog(null, "Hasta pronto", "DawFood", variable1, new ImageIcon("src/main/java/DawFood/favicon.png"));
                    modoUserIni(carta, carrito, ventas);
                    break;
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
            String cantidad = JOptionPane.showInputDialog(null, "Inserta la cantidad", "DawFood", 0);
            carrito.AñadirElemento(p, Integer.parseInt(cantidad));
            System.out.println(carrito.VerCarrito());
        }

    }

    /*
    public void mostrarYSeleccionarComida(CartaComida carta, Carrito carrito, E_Categoria categoria, E_SubCategoria subcategoria) {
    // Obtener la lista de comidas de la carta

    ArrayList<Producto> productos = carta.devolverPorSubcategoria(categoria, subcategoria);

    // Construir el mensaje con las opciones de comida
    StringBuilder sb = new StringBuilder();
    int posicion = 0;
    for (Producto p : productos) {
        posicion += 1;
        sb.append(posicion).append(". ").append(p.get_nombre()).append(" ").append(p.get_precio()).append("\n");
    }
        
    // Verificar que la elección sea válida y agregar al carrito
    if ((nombre != null) && (!nombre.isEmpty())) {
        int eleccionIndex = Integer.parseInt(nombre) - 1;
        if (eleccionIndex >= 0 && eleccionIndex < productos.size()) {
            Producto comidaSeleccionada = productos.get(eleccionIndex);
            carrito.AñadirElemento(comidaSeleccionada, 1);
            System.out.println(carrito.VerCarrito());
        }
    }
}
     */
    public boolean elegirYModificar(ArrayList<Producto> lista, CartaComida carta) {
        ArrayList<Producto> productos = lista;

        StringBuilder sb = new StringBuilder();
        int posicion = 0;
        for (Producto p : productos) {
            posicion += 1;
            sb.append(p.get_nombre()).append(" ").append(p.get_precio()).append("\n");
        }
        //imprimir con el JoptionPane el string
        String eleccionHb = JPaneInserta(sb.toString());

        if (!productos.isEmpty()) {
            Producto p = productos.get((Integer.parseInt(eleccionHb) - 1));

            /*Insertar Nombre*/
            p.setNombre(JPaneInserta("Inserte el Nuevo Nombre"));
            /*Insertar Descripcion*/
            p.set_descripcion(JPaneInserta("Inserte la Nueva Descripción"));
            /*Insertar Precio*/
            p.setPrecio(Double.parseDouble(JPaneInserta("Inserte el nuevo Precio")));
            /*Insertar stock*/
            p.setStock(Integer.parseInt(JPaneInserta("Inserte el nuevo STOCK")));
            carta.ModificarProducto(p, E_Usuario.Administrador);
            return true;
        }
        return false;
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
                        String cantidad = JPaneInserta("Inserte la cantidad deseada");
                        carrito.AñadirElemento(p, Integer.parseInt(cantidad));
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
