/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.HashSet;

/**
 *
 * @author samue
 */
public class PasarelaDePago {
    HashSet<TarjetaCredito> tarjetas= new HashSet<>();
    
    public PasarelaDePago(){
        tarjetas.add(new TarjetaCredito("Samuel","1234","123","1/25", 699.0f));
        tarjetas.add(new TarjetaCredito("Vicky","2345","123","2/25", 699.0f));
    /*Añadir tarjetas de pago y sus fondos*/}
    
    
public boolean ProcesoDePago(Double cantidad,String numeroTarjeta){
    TarjetaCredito tarjeta=null;
    String usuariocvv;
    String usuariofecha;
    if(!(tarjetas.isEmpty())){
        for(TarjetaCredito p : tarjetas){
             if(p.getNumTarjeta().contentEquals(numeroTarjeta)){
                    tarjeta=p;
                    break;}}
 
    if(tarjeta.getCvv().equalsIgnoreCase(usuariocvv)){
             if(tarjeta.getFecha().equalsIgnoreCase(usuariofecha)){
                  tarjeta.restarFondos(cantidad);
                  return true;}
                 else{System.out.println("ERROR FECHA INCORRECTA");}
                 }
           else{System.out.println("CVV INCORRECTO");}
       }

   }
        
}
