/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public class ProductoVenta extends Producto {
    int unidades=0;
    public ProductoVenta(int id, String nombre, String descripcion, E_Categoria categoria, double precio, E_Iva iva, int stock,int unidades) {
        super(id, nombre, descripcion, categoria, precio, iva, stock);
        this.unidades= unidades;
    }
    
}
