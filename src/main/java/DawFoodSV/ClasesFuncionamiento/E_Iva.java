/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public enum E_Iva {
    Siete(0.07),Doce(0.12);
    private double iva;
    private E_Iva(double iva){
    this.iva=iva;}
    
    public double get_iva(){
       return this.iva;}
}
