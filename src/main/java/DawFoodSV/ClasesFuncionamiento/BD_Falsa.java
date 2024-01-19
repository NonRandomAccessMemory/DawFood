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
public class BD_Falsa {
    /*EMULO SER UNA BASE DE DATOS*/
    public ArrayList<Producto> m_BDProducto= new ArrayList<>();
   
    public BD_Falsa(){
        /*AÑADIR OBJETOS POR DEFECTO*/
        m_BDProducto.add(new Producto(1,"Estofado","Estofado de ternera",E_Categoria.Comida,9.99,E_Iva.Siete,12));
        m_BDProducto.add(new Producto(2,"Pepsi Max","bebida azucarda",E_Categoria.Bebida, 2.90,E_Iva.Siete,60));
    }
    
    public ArrayList<Producto> DameTodo()
    {
        ArrayList<Producto> todo= new ArrayList<Producto>();
        todo.addAll(m_BDProducto);
        return todo;
    }
    
    public ArrayList<Producto> BuscaPor(Consumer<Producto> busqueda){
    
        return new ArrayList<Producto>();
    }
    
    public Producto BuscaElemento(Consumer<Producto>busqueda){
        /*mejorar*/
        ArrayList<Producto> productos= new ArrayList<Producto>();
        if(productos.isEmpty() && productos.size()<1){
            System.out.println("No existen productos con ese termino de busqueda");
            }
        Producto producto = productos.get(0);
        return producto;
    }
    
    public void BorrarElementoId(E_Usuario usuario, int id)
    {
        if(ComprobarUsuario(usuario)&& !(m_BDProducto.isEmpty()))
        {
            m_BDProducto.remove(id);
        }
        
    }
    public void OrdenatePorPrecio(Comparator<Producto> busqueda){
     /*Pasamos un consumer de comparación que ordenará la base de datos*/
     m_BDProducto.sort(busqueda);
    }
     private boolean ComprobarUsuario(E_Usuario usuario){
         if(!(usuario.get_usuario().equalsIgnoreCase(E_Usuario.Administrador.get_usuario()))){
             return false;
         }
         return true;
    }
    
     
}
