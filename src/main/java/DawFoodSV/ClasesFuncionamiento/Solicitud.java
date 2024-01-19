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
    public Producto getProductoPorID(int id){
        /*Implementar*/
        Producto producto;
        Consumer<Producto> solicitud = (x)-> x.get_id();
        producto= db.BuscaElemento(solicitud);
        return producto;
    }
    public double getPrecio(int nombre){
        /*Implementar*/
        ArrayList<Producto> productos;
        Consumer<Producto> solicitud = (x) -> x.get_precio();
        productos.addAll(db.BuscaPor(solicitud));
        return ;
    }
    
    public void OrdenatePorPrecio(){
    /*implementar*/
    Comparator<Producto> criterioPrecio= (e1,e2)-> (int) (e1.get_precio()- e2.get_precio());
     db.OrdenatePorPrecio(criterioPrecio);
    }
    
}
