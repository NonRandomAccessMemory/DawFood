/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DawFoodSV.Infraestructure;

import DawFoodSV.Domain.IProduct;
import java.util.ArrayList;

/**
 *
 * @author snavgar
 */
public interface IDataBase {
     
    public ArrayList<IProduct> DevolverTodos();
    public IProduct busquedaProducto();
    
}
