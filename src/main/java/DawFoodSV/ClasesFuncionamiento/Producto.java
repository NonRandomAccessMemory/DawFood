/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.Objects;

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
    
    private Integer id;
    private String descripcion,nombre;
    public E_Categoria Categoria;
    public E_SubCategoria subCategoria;
    public E_Iva Iva;
    private Double precio;
    private int stock;
    
    /*Constructor*/
    public Producto(int id){
        this.id=id;}
    
    public Producto(int id,String nombre,String descripcion, E_Categoria categoria,E_SubCategoria subCategoria,double precio,E_Iva iva,int stock){
        this.id=id;
        this.nombre=nombre;
        this.descripcion= descripcion;
        this.Categoria= categoria;
        this.subCategoria= subCategoria;
        this.Iva=iva;
        this.stock=stock;
        this.precio= precio;
    }
    
    public Integer get_id(){
       return this.id;}
    public String get_nombre(){
       return this.nombre;}
    public String get_descripcion(){
            return this.descripcion;}
    public String get_SubCategoria(){
            return this.subCategoria.get_SubTipoProducto();
            }
    public void set_descripcion(String descripcion){
           if(!descripcion.equals(this.descripcion)){
               this.descripcion= descripcion;}
           else{System.out.println("Cambio no realizado, descripcion iguales");}}
    public String get_categoria(){
            return this.Categoria.get_TipoProducto();}
    public Double get_precio(){
        return this.precio;
    }
    public int get_stock(){
        return this.stock;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
   
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", nombre=" + nombre + ", Iva=" + Iva + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
}
