/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;
import java.time.LocalDate;
/**
 *
 * @author samue
 */
public class Ticket {
    private Integer id;
    private LocalDate fecha;
    private String productos[];
    private int elementosAñadidos=0;
    
    public Ticket(Integer id, int numeroProductos){
        this.productos= new String[numeroProductos];
        this.fecha= LocalDate.now();
        this.id=id;
    }
    
    public boolean AñadirElemento(Producto p)
    {
        if(elementosAñadidos < productos.length)
        {
            //productos[elementosAñadidos] = ;
            elementosAñadidos++;
        }
        return true;
    }
}
