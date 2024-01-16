/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public enum E_Categoria {
    Bebida("Bebida"),Comida(""),Menu(""),Snack("Snack");
    
    private final String categoria;
    private E_Categoria(String categoria){
            this.categoria= categoria;}
    public String get_TipoProducto(){
        return this.categoria;}
}
