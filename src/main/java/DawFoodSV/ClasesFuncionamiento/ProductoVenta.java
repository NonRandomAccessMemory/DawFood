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
    public ProductoVenta(int id, String nombre, String descripcion, E_Categoria categoria, E_SubCategoria subCategoria, double precio, E_Iva iva, int stock,int unidades) {
        super(id, nombre, descripcion, categoria, subCategoria, precio, iva, stock);
        this.unidades= unidades;
    }
    
    public void AddUnidadesPorUno(){
        this.unidades= this.unidades++;}
    public void ReduceUnidadesPorUno(){
        if(this.unidades>0){this.unidades--;}
}
    
    public void AddUnidades(int unidades){
     if(unidades > 0 && this.unidades > 0){this.unidades = this.unidades + unidades;}}
    public void ReduceUnidades(int unidades){
     if(unidades > 0 && ((this.unidades - unidades)) >= 0){ this.unidades= this.unidades-unidades;}
    } 
}
