/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author snavgar
 */
public class Solicitud {
    
   /*Objeto BD*/
    private BD_Falsa db= new BD_Falsa();

    public Solicitud(){}
    /*SE PASA EL CONSUMER A LA BASE DE DATOS QUE DEVUELVE UNA LISTA DE PRODUCT*/
    
    public Producto getProductoPorNombre(){
        /*Implementar CONSUMER*/
        Consumer<Producto> solicitud;
        ArrayList<Producto> productos;
        productos.addAll(db.BuscaPor(solicitud));
        /*Implementar CONSUMER*/
        return;
    }
    public Producto getProductoPorID(){
        /*Implementar*/
        ArrayList<Producto> productos;
        Consumer<Producto> solicitud;
        
        return;
    }
    public double getPrecio(){
        /*Implementar*/
        ArrayList<Producto> productos;
        Consumer<Producto> solicitud;
        return;
    }
    
    
}
