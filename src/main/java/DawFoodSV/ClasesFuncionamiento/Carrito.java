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
    private ArrayList<Producto> m_carrito= new ArrayList<>();
    
    public Carrito(){
    }
    
    public void AñadirElemento(Producto producto,int cantidad){
        /*On development*/
      /*ProductoVenta productoventa= new ProductoVenta(producto.get_id(),producto.get_nombre()
                                                    ,E_Categoria.valueOf(producto.get_categoria())
                                                    ,E_SubCategoria.valueOf(producto.get_SubCategoria()),
                                                    producto.get_precio(),cantidad);
       m_carrito.add(productoventa);*/
    }
    
    public void EliminarElemento(int id){
            for (Producto p : m_carrito)
            {
                if(p.get_id()== id)
                {
                    m_carrito.remove(p);
                }
            }
          
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
