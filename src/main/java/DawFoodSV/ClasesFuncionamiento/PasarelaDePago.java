/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class PasarelaDePago {
    HashSet<TarjetaCredito> tarjetas;
    
    public PasarelaDePago(){
        this.tarjetas= new HashSet<>();
        tarjetas.add(new TarjetaCredito("Samuel","1234","123","01/25", 699.0f));
        tarjetas.add(new TarjetaCredito("Vicky","2345","123","02/25", 699.0f));
    /*Añadir tarjetas de pago y sus fondos*/}
    
    
public boolean ProcesoDePago(double cantidad,String numeroTarjeta){
    TarjetaCredito tarjeta=null;
    /*añadir opciones de JOptionPane*/
    String usuariocvv= new String();
    String usuariofecha= new String();
    if(!(tarjetas.isEmpty())){
        for(TarjetaCredito p : tarjetas){
             if(p.getNumTarjeta().contentEquals(numeroTarjeta)){
                    tarjeta=p;
                    break;}}
    usuariocvv=JPaneInserta("Inserte el codigo CVV, por favor");
    if(tarjeta.getCvv().equalsIgnoreCase(usuariocvv)){
             usuariofecha=JPaneInserta("Inserte la Fecha de Caducidad DD/MM");
             if(tarjeta.getFecha().equalsIgnoreCase(usuariofecha)){
                  tarjeta.restarFondos(cantidad);
                  return true;}
                 else{System.out.println("ERROR FECHA INCORRECTA");
                        return false;}
                 }
           else{System.out.println("CVV INCORRECTO");
                return false;}
       }
    return false;
   }
    public String JPaneInserta(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje);
    }
}
