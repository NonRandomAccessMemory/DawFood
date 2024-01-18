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
public class BD_Falsa {
    /*EMULO SER UNA BASE DE DATOS*/
    public ArrayList<Producto> m_BDProducto= new ArrayList<Producto>();
   
    public BD_Falsa(){
        /*AÑADIR OBJETOS POR DEFECTO*/
        m_BDProducto.add(new Producto(1,"Estofado","Estofado de ternera",E_Categoria.Comida,E_Iva.Siete,12));
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
    
    public void BorrarElementoId(E_Usuario usuario, int id)
    {
        if(ComprobarUsuario(usuario)&& !(m_BDProducto.isEmpty()))
        {
            m_BDProducto.remove(id);
        }
        
    }
     private boolean ComprobarUsuario(E_Usuario usuario){
         if(!(usuario.get_usuario().equalsIgnoreCase(E_Usuario.Administrador.get_usuario()))){
             return false;
         }
         return true;
    }
}
