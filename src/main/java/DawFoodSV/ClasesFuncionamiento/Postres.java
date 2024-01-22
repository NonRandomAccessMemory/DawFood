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
public class Postres {
    
    private ArrayList<Producto> postres= new ArrayList<>();
    
    
    public Postres(){
    postres.add(new Producto(1,"Mochi","heladojapo",E_Categoria.Postre,E_SubCategoria.Helados,9.99,E_Iva.Siete,12));
    }
    
    public void Ordenar(){
    Comparator<Producto> comparador= (e1,e1)-> e1.get_id().compareTo(e2));
    postres.sort(;);
    }
    
    
    
}
