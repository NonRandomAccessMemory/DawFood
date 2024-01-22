/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;


/**
 *
 * @author vickyfg
 */
public class Admin {
    //Generador de contraseña
    /*Una minúscula (a - z)
Una mayúscula (A - Z)
Un número (0 - 9)
Uno de los siguientes caracteres especiales: # $ % &  ( ) * + , - .  : ; < = > @
*/
   
   public static String generarPasswordAdmin(){
       
       StringBuilder password = new StringBuilder();
            
       //Generea una letra minuscula (a - z)
       password.append(RandomStringUtils.randomAlphabetic(1).toLowerCase());
       
       //Generea una letra mayuscula (A - Z)
       password.append(RandomStringUtils.randomAlphabetic(1).toUpperCase());
       
        //Generea un numero(0 - 9)
       password.append(RandomStringUtils.randomNumeric(1));
       
       //Genera tres caracteres especiales entre # $ % &  ( ) * + , - .  : ; < = > @
       password.append(RandomStringUtils.randomAscii(35, 38)); 
       password.append(RandomStringUtils.randomAscii(40, 46)); 
       password.append(RandomStringUtils.randomAscii(58, 64)); 
       
      if (password.length() > 6) {
        password.setLength(6);
    }  
        return  password.toString();
    }
                                                                           
}
    
