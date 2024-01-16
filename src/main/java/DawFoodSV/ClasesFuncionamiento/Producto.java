/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public class Producto {
    /*ID
      descripción
      categoría
      subcategoría a la que pertenece
      precio
      IVA y stock*/
    
    private int id;
    private String descripcion;
    private E_Categoria Categoria;
    private E_Iva Iva;
    private int stock;
    
    /*Constructor*/
    public Producto(int id,String descripcion, E_Categoria categoria,E_Iva iva,int stock){
        this.id=id;
        this.descripcion= descripcion;
        this.Categoria= categoria;
        this.Iva=iva;
        this.stock=stock;
    }
    
    public int get_id(){
       return this.id;}
    public String get_descripcion(){
            return this.descripcion;}
    public void set_descripcion(){}
    public String get_categoria(){
            return this.Categoria.get_TipoProducto();}
}
