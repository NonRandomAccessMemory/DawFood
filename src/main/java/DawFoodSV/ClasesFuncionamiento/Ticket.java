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
    
    public boolean AñadirElemento(ProductoVenta p)
    {
        if(elementosAñadidos < productos.length)
        {
            
            productos[elementosAñadidos] =  p.toString();
            elementosAñadidos++;
        }
        return true;
    }
    public void AñadirFecha(LocalDate horaLocal){
        this.fecha=horaLocal;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------UltraMarinos PACO-------------");
        sb.append("Ticket:").append(id);
        sb.append(", fecha=").append(fecha);
        for(int fila=0; fila < productos.length; fila++)
        {
         sb.append(productos[fila]);
        }
        sb.append(", productos=").append(productos);
        sb.append(", elementosA\u00f1adidos=").append(elementosAñadidos);
        sb.append('}');
        return sb.toString();
    }
    
}
