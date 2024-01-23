/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author snavgar
 */
public class CartaComida {
    private final ArrayList<Producto> comidas= new ArrayList<>();
    private final ArrayList<Producto> postres= new ArrayList<>();
    private final ArrayList<Producto> bebidas= new ArrayList<>();
     
   public CartaComida(){
   comidas.add(new Producto(1,"Hamburguesa","Hamburguesa de ternera",E_Categoria.Comida,E_SubCategoria.Hamburguesa,9.99,E_Iva.Siete,12));
   comidas.add(new Producto(3,"Hamburgusa Mcfit","Hamburguesa de ternera que sigue engondando",E_Categoria.Comida,E_SubCategoria.Hamburguesa,9.99,E_Iva.Siete,12));
   comidas.add(new Producto(2,"Hamburgusa con queso","Hamburguesa de ternera con queso",E_Categoria.Comida,E_SubCategoria.Hamburguesa,9.99,E_Iva.Siete,12));
   
   postres.add(new Producto(1,"Mochi","heladojapo",E_Categoria.Postre,E_SubCategoria.Helados,4.99,E_Iva.Siete,12));
   postres.add(new Producto(1,"CafeConHelado","helado Amuricano",E_Categoria.Postre,E_SubCategoria.PostresCaseros,2.99,E_Iva.Siete,12));
   postres.add(new Producto(2,"FrigoPie","helado con leche",E_Categoria.Postre,E_SubCategoria.Helados,3.99,E_Iva.Siete,12));
   postres.add(new Producto(3,"ConoChocolateNata","Helado de cono con chocolate",E_Categoria.Postre,E_SubCategoria.Helados,9.99,E_Iva.Siete,12));
   postres.add(new Producto(1,"CremaHelada","helado natural",E_Categoria.Postre,E_SubCategoria.PostresCaseros,2.99,E_Iva.Siete,12));
   
   bebidas.add(new Producto(1,"Pepsi","Pepsi Clasica",E_Categoria.Bebida,E_SubCategoria.Azucaradas,9.99,E_Iva.Siete,12));
   bebidas.add(new Producto(2,"Cerveza sin","Cerveza Sin",E_Categoria.Bebida,E_SubCategoria.SinAzucar,1.99,E_Iva.Siete,12));
   bebidas.add(new Producto(1,"Ceveza hacendaño","Cerveza alcoholica",E_Categoria.Bebida,E_SubCategoria.Alcoholicas,1.99,E_Iva.Doce,12));
   
   }
   
   
   public void InsertarProducto(Producto producto, E_Usuario usuario){
        
       if(usuario.get_usuario().contentEquals("Administrador")){
        switch(producto.get_categoria()){
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
   
   public void Ordenar(){
    Comparator<Producto> comparador=(e1,e2)-> e1.get_id().compareTo(e2.get_id());
    comidas.sort(comparador);
    bebidas.sort(comparador);
    postres.sort(comparador);
   }
   
   public ArrayList<Producto> get_Comidas(){
       return (ArrayList<Producto>)this.comidas.clone();
    }
    public ArrayList<Producto> get_Bebidas(){
       return (ArrayList<Producto>)this.bebidas.clone();
    }
    public ArrayList<Producto> get_Postres(){
        return (ArrayList<Producto>)this.postres.clone();
    }
    
    
    
   public void FinalizarCompra(){
       
   }
}
