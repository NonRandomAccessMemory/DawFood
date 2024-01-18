/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public record R_Producto(int id,String nombre,double precio, int cantidad) {
     /*RECORD donde se OMITE LA DESCRIPCION Y SE GUARDA LO PRINCIPAL DEL PROCESO
       DE COMPRA*/
    public R_Producto(int id,String nombre,double precio, int cantidad)
    {
       this.id=id;
       this.nombre=nombre;
       this.precio=precio;
       this.cantidad= cantidad;
    }
}
