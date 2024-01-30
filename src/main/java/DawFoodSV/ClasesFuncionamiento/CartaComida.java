/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author snavgar
 */
public class CartaComida {

    private final ArrayList<Producto> comidas;
    private final ArrayList<Producto> postres;
    private final ArrayList<Producto> bebidas;

    public CartaComida() {
        /*Instancio objeto New ArrayList*/
        this.comidas = new ArrayList<>();
        this.postres = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        //Añado objetos
        comidas.add(new Producto(1, "Hamburguesa simple", "Hamburguesa de ternera", E_Categoria.Comida, E_SubCategoria.Hamburguesa, 9.99, E_Iva.Siete, 12));
        comidas.add(new Producto(3, "Hamburguesa Mcfit[Pollo]", "Hamburguesa de pollo", E_Categoria.Comida, E_SubCategoria.Hamburguesa, 8.99, E_Iva.Siete, 12));
        comidas.add(new Producto(2, "Hamburguesa con queso", "Hamburguesa de ternera con queso", E_Categoria.Comida, E_SubCategoria.Hamburguesa, 10.99, E_Iva.Siete, 12));
        comidas.add(new Producto(4, "Patatas Gajo", "Patatas gajos muy buenas y saludables", E_Categoria.Comida, E_SubCategoria.Patatas, 2.99, E_Iva.Siete, 30));
        comidas.add(new Producto(5, "Patatas finas", "Patatas fritas finas", E_Categoria.Comida, E_SubCategoria.Patatas, 0.99, E_Iva.Siete, 28));
        comidas.add(new Producto(6, "Patatas clasicas", "Patatas fritas gruesas", E_Categoria.Comida, E_SubCategoria.Patatas, 1.99, E_Iva.Siete, 78));
        comidas.add(new Producto(7, "Ensalada mixta", "Lechuga, tomate y cebolla", E_Categoria.Comida, E_SubCategoria.Ensalada, 3.99, E_Iva.Siete, 27));
        comidas.add(new Producto(8, "Ensalada cesar", "MixLechuga, pollo y salsa cesar", E_Categoria.Comida, E_SubCategoria.Ensalada, 8.99, E_Iva.Siete, 12));
        comidas.add(new Producto(9, "Ensalada DawFood", "MixLechugas, langostinos, salsa rosa", E_Categoria.Comida, E_SubCategoria.Ensalada, 9.99, E_Iva.Siete, 47));

        postres.add(new Producto(10, "Mochi", "Pastel Helado Japones", E_Categoria.Postre, E_SubCategoria.PostresCaseros, 4.99, E_Iva.Siete, 12));
        postres.add(new Producto(11, "CafeConHelado", "Helado Amuricano", E_Categoria.Postre, E_SubCategoria.PostresCaseros, 2.99, E_Iva.Siete, 12));
        postres.add(new Producto(12, "McDawFlurry", "Helado con leche", E_Categoria.Postre, E_SubCategoria.Helados, 3.99, E_Iva.Siete, 12));
        postres.add(new Producto(13, "ConoChocolateNata", "Helado de cono con chocolate", E_Categoria.Postre, E_SubCategoria.Helados, 1.99, E_Iva.Siete, 12));
        postres.add(new Producto(14, "Yogur con toppin", "Yogur helado natural", E_Categoria.Postre, E_SubCategoria.PostresCaseros, 2.99, E_Iva.Siete, 12));
        postres.add(new Producto(22, "Tarta de queso", "Tarta de queso con mermermelada de fresa", E_Categoria.Postre, E_SubCategoria.PostresCaseros, 7.99, E_Iva.Siete, 5));

        bebidas.add(new Producto(15, "Pepsi", "Pepsi Clasica", E_Categoria.Bebida, E_SubCategoria.Azucaradas, 1.99, E_Iva.Doce, 25));
        bebidas.add(new Producto(16, "Cerveza sin", "Cerveza Sin", E_Categoria.Bebida, E_SubCategoria.Cervezas, 1.99, E_Iva.Doce, 25));
        bebidas.add(new Producto(17, "Ceveza", "Cerveza alcoholica", E_Categoria.Bebida, E_SubCategoria.Cervezas, 2.00, E_Iva.Doce, 30));
        bebidas.add(new Producto(18, "Kas", "Kas de Naranja", E_Categoria.Bebida, E_SubCategoria.Azucaradas, 1.99, E_Iva.Doce, 21));
        bebidas.add(new Producto(19, "Pepsi Max", "Pepsi zero zero", E_Categoria.Bebida, E_SubCategoria.SinAzucar, 1.99, E_Iva.Siete, 27));
        bebidas.add(new Producto(20, "Nestea", "Nestea Clasica", E_Categoria.Bebida, E_SubCategoria.Azucaradas, 1.99, E_Iva.Doce, 12));
        bebidas.add(new Producto(21, "Kas Max", "Kas de Naranja sin azúcar", E_Categoria.Bebida, E_SubCategoria.SinAzucar, 2.35, E_Iva.Doce, 21));
        bebidas.add(new Producto(22, "Aquarade Max", "Bebida isotonica zero", E_Categoria.Bebida, E_SubCategoria.SinAzucar, 1.99, E_Iva.Siete, 27));
        bebidas.add(new Producto(20, "Cerveza DawFood - Doble lupulo", "Cerveza original con doble lupulo", E_Categoria.Bebida, E_SubCategoria.Cervezas, 1.99, E_Iva.Doce, 12));

    }

    public void InsertarProducto(Producto producto, E_Usuario usuario) {

        if (usuario.get_usuario().contentEquals("Administrador")) {
            switch (producto.get_categoria()) {
                case "Bebida":
                    bebidas.add(producto);
                    break;
                case "Comida":
                    comidas.add(producto);
                    break;
                case "Postre":
                    postres.add(producto);
                    break;
            }
        }
    }
    
   
    
    public String obtenerInformacionProducto(ArrayList<Producto> listaProductos, String nombreProducto) {
        StringBuilder info = new StringBuilder();

        for (Producto producto : listaProductos) {
            if (producto.get_nombre().equals(nombreProducto)) {
                info.append("Nombre: ").append(producto.get_nombre()).append("\n");
                info.append("Descripción: ").append(producto.get_descripcion()).append("\n");
                info.append("Precio: ").append(producto.get_precio()).append("\n");
                info.append("----------------------------------").append("\n");
                // Si encuentras el producto por nombre, termina el bucle
                break;
            }
        }

        return info.toString();
    }

    public boolean BorrarProducto(Producto producto, E_Usuario usuario) {
        if (usuario.get_usuario().contentEquals("Administrador")) {
            switch (producto.get_categoria()) {
                case "Bebida":
                    for (Producto p : bebidas) {
                        if (producto.get_id().intValue() == p.get_id()) {
                            bebidas.remove(p);
                            return true;
                        }
                    }
                    break;
                case "Comida":
                    for (Producto p : comidas) {
                        if (producto.get_id().intValue() == p.get_id()) {
                            comidas.remove(p);
                            return true;
                        }
                    }
                    break;
                case "Postre":
                    for (Producto p : postres) {
                        if (producto.get_id().intValue() == p.get_id()) {
                            postres.remove(p);
                            return true;
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public boolean ModificarProducto(Producto p, E_Usuario usuario) {
         switch (p.get_categoria()) {
                case "Bebida":
                      bebidas.add( bebidas.indexOf(p), p);
                    break;
                case "Comida":
                       comidas.add( comidas.indexOf(p), p);
                    
                    break;
                case "Postre":
                     postres.add( bebidas.indexOf(p), p);
                    break;
            }
        return true;
    }

    public void Ordenar() {
        Comparator<Producto> comparador = (e1, e2) -> e1.get_id().compareTo(e2.get_id());
        comidas.sort(comparador);
        bebidas.sort(comparador);
        postres.sort(comparador);
    }

    /*Devuelvo TODA LA LISTA DE COMIDAS*/
    public ArrayList<Producto> get_Comidas() {
        return (ArrayList<Producto>) this.comidas.clone();
    }

    /*Devuelvo Toda la lista de Bebidas*/
    public ArrayList<Producto> get_Bebidas() {
        return (ArrayList<Producto>) this.bebidas.clone();
    }

    /*Devuelvo toda la lista de Postres*/
    public ArrayList<Producto> get_Postres() {
        return (ArrayList<Producto>) this.postres.clone();
    }

    //Devuelvo una lista de productos basados en su categoria y subcategoria pasame una Categoria(enum) y subCategoria(enum) GRACIAS
    public ArrayList<Producto> devolverPorSubcategoria(E_Categoria categoria, E_SubCategoria subcategoria) {
        ArrayList<Producto> productosPorSubcategoria = new ArrayList<>();

        switch (categoria.get_TipoProducto()) {
            case "Bebida":
                for (Producto p : bebidas) {
                    if (p.subCategoria.equals(subcategoria)) {
                        productosPorSubcategoria.add(p);
                    }
                }
                break;
            case "Comida":
                for (Producto p : comidas) {
                    if (p.subCategoria.equals(subcategoria)) {
                        productosPorSubcategoria.add(p);
                    }
                }
                break;

            case "Postre":
                for (Producto p : postres) {
                    if (p.subCategoria.equals(subcategoria)) {
                        productosPorSubcategoria.add(p);
                    }
                }
                break;
        }
        return productosPorSubcategoria;
    }

    public Producto devolverPorNombre(E_Categoria categoria, String nombre) {

        switch (categoria.get_TipoProducto()) {
            case "Bebida":
                for (Producto p : bebidas) {
                    if (p.get_nombre().equalsIgnoreCase(nombre)) {
                        return p;
                    }
                }
                break;
            case "Comida":
                for (Producto p : comidas) {
                    if (p.get_nombre().equalsIgnoreCase(nombre)) {
                        return p;
                    }
                }
                break;
            case "Postre":
                for (Producto p : postres) {
                    if (p.get_nombre().equalsIgnoreCase(nombre)) {
                        return p;
                    }
                }
                break;

        }return null;

    }
}
