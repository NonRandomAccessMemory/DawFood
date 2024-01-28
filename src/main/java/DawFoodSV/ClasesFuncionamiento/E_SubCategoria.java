/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public enum E_SubCategoria {
    Azucaradas("Azucaradas"),Cervezas("SinAzucar"),SinAzucar("Alcoholicas"),
    Hamburguesa("Hamburguesa"),Ensalada("Ensalada"),Patatas("Patatas"),
    Helados("Helados"),PostresCaseros("Postre"),Tartas("Postre");
    
    private final String categoria;
    private E_SubCategoria(String categoria){
            this.categoria= categoria;}
    public String get_SubTipoProducto(){
        return this.categoria;}
    
}
