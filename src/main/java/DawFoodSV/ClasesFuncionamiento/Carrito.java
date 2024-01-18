/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.ArrayList;

/**
 *
 * @author snavgar
 */
public class Carrito {
    private ArrayList<Record> m_carrito= new ArrayList<Record>();
    
    public Carrito(){
    }
    
    public void AñadirElemento(Producto producto,int cantidad){
       /*Añadir Elemento */
       R_Producto producto = new R_producto(producto.id(),producto.nombre(),producto.precio(),cantidad);
       m_carrito.add(producto);
    }
    
    public void EliminarElemento(int id){
            /*Añadir iterator/Bucle para eliminar el objecto que tenga el mismo id*/
    }
    
    public void ProcesarCompra(){
        /*Si la lista no está vacía*/
                /*Recorrer la lista y calcular el precio total*/
                /*Añadir la lista a las compras totales*/
                /*Restar de la base datos la cantidad de elementos*/
                /*Generar el ticket (ToSTRING)*/
         /*Si todo ha salido bien*/
            /*devuelve la lista que se guardar en la lista de compras del tpv*/
    }
}
