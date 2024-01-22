/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.util.Objects;

/**
 *
 * @author samue
 */
public class TarjetaCredito {
    private String titular;
    private String numTarjeta;
    private String cvv;
    private String Fecha;
    private double fondos;
    
    public TarjetaCredito(String titular,String numTarjeta, String cvv, String fecha,double fondos){
        this.titular= titular;
        this.numTarjeta= numTarjeta;
        this.cvv= cvv;
        this.Fecha= fecha;
        this.fondos=fondos;
    }
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public String getCvv() {
        return cvv;
    }
    public String getFecha() {
        return Fecha;
    }
    public boolean restarFondos(double cantidad){
        if(this.fondos < cantidad)
        {
            this.fondos-=cantidad;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numTarjeta);
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
        final TarjetaCredito other = (TarjetaCredito) obj;
        return Objects.equals(this.numTarjeta, other.numTarjeta);
    }
    
    
    
}
