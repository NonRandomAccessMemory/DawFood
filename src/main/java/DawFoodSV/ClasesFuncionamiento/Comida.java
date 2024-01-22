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
public class Comida {
    private ArrayList<Producto> Comida= new ArrayList<>();
     
   public Comida(){
   Comida.add(new Producto(1,"Hamburguesa","Hamburguesa de ternera",E_Categoria.Comida,E_SubCategoria.Hamburguesa,9.99,E_Iva.Siete,12));
   }
   
}
