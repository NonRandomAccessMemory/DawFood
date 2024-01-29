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

    public Integer getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------UltraMarinos PACO-------------").append("\n");
        sb.append("Ticket:").append(id).append("\n");
        sb.append(", fecha=").append(fecha).append("\n");
        for(int fila=0; fila < productos.length; fila++)
        {
         sb.append(productos[fila]).append("\n");
        }
        sb.append(", productos=").append(productos).append("\n");
        sb.append(", Total Añadidos=").append(elementosAñadidos).append("\n");
        sb.append('}');
        return sb.toString();
    }
    
}
