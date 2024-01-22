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
public class Bebida {
    ArrayList<Producto> Bebida= new ArrayList<>();
    
    public Bebida(){
    Bebida.add(new Producto(1,"Pepsi","Pepsi Clasica",E_Categoria.Bebida,E_SubCategoria.Azucaradas,9.99,E_Iva.Siete,12));
    }
}
