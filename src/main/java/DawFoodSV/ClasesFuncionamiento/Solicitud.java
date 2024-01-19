/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * @author snavgar
 */
public class Solicitud {
    
   /*Objeto BASE DE DATOS*/
    private BD_Falsa db= new BD_Falsa();

    public Solicitud(){}
    /*SE PASA EL CONSUMER A LA BASE DE DATOS QUE DEVUELVE UNA LISTA DE PRODUCT*/
    
    /*TODO*/
     /*CONSUMERS*/
    public Producto getProductoPorNombre(String nombre){
        /*Implementar CONSUMER*/
        Consumer<Producto> solicitud= (x)-> x.get_nombre().equalsIgnoreCase(nombre);
        return db.BuscaElemento(solicitud);
       
    }
    public ArrayList<Producto> TodosLosProductos(){
        return db.DameTodo();
    }
    
    public Producto getProductoPorID(int id){
        /*Implementar*/
        Producto producto;
        Consumer<Producto> solicitud = (e1)-> e1.get_id().compareTo(id);
        producto= db.BuscaElemento(solicitud);
        return producto;
    }
    public Producto getProductoPorPrecio(int precio){
        Producto producto;
        Consumer<Producto> solicitud = (e1)-> e1.get_id().compareTo(precio);
        producto= db.BuscaElemento(solicitud);
        return producto;
    }
    public double getPrecio(int nombre){
        /*Implementar*/
        ArrayList<Producto> productos;
        Consumer<Producto> solicitud = (x) -> x.get_id();
        productos.addAll(db.BuscaPor(solicitud));
        return productos.get(0).get_precio();
    }
    
    public void OrdenatePorPrecio(){
    /*implementar*/
    Comparator<Producto> criterioPrecio= (e1,e2)-> (int) (e1.get_precio()- e2.get_precio());
     db.OrdenatePor(criterioPrecio);
    }
    
     public void OrdenatePorID(){
    /*implementar*/
    Comparator<Producto> criterioPrecio= (e1,e2)-> (int) (e1.get_id()- e2.get_id());
     db.OrdenatePor(criterioPrecio);
    }
     
      public void OrdenatePorCategoria(){
    /*implementar*/
    Comparator<Producto> criterioPrecio= (e1,e2)-> (int) (e1.get_categoria().compareToIgnoreCase(e2.get_categoria()));
     db.OrdenatePor(criterioPrecio);
    }
    
}
