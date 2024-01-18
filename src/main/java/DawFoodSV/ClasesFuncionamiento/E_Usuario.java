/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

/**
 *
 * @author snavgar
 */
public enum E_Usuario {
    Usuario("usuario"),Administrador("administrador");
    
    private String usuario;
    private E_Usuario(String usuario){
        this.usuario= usuario;
    }
    
    public String get_usuario(){
        return this.usuario;
    }
}
