/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DawFoodSV.ClasesFuncionamiento;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author snavgar
 */
public class Carrito {
    private PasarelaDePago pasarelaPago= new PasarelaDePago();
    private ArrayList<ProductoVenta> m_carrito= new ArrayList<>();
    
    public Carrito(){
    }
    
    public void AñadirElemento(Producto producto,int cantidad){
     
      ProductoVenta productoventa= new ProductoVenta(producto.get_id(),producto.get_nombre()
                                                    ,producto.get_descripcion()
                                                    ,producto.Categoria
                                                    ,producto.subCategoria,
                                                    producto.get_precio(),producto.Iva,producto.get_stock(),cantidad);
       m_carrito.add(productoventa);
    }
    public String VerCarrito(){
        StringBuilder sb= new StringBuilder();
        double totalprecio=0.0f;
           sb.append("---Producto-----------Precio Sin iva------Con iva");
       for(ProductoVenta p : m_carrito){
            sb.append(p.get_nombre()).append("-").append(p.get_precio()).append("-")
                                            .append((p.get_precio()*p.Iva.get_iva()));
            sb.append("/n");
            totalprecio+= p.get_precio();
       }
        sb.append("-----------------------------------------------------");
        sb.append("TOTAL: ").append(totalprecio).append("€");
        return sb.toString();
       }
    public void EliminarElemento(int id){
            for (ProductoVenta p : m_carrito)
            {
                if(p.get_id()== id)
                {
                    m_carrito.remove(p);
                }
            }
          
    }
    
    public void ProcesarCompra(){
        /*Si la lista no está vacía*/
                /*Recorrer la lista y calcular el precio total*/
                /*Añadir la lista a las compras totales*/
                /*Restar de la base datos la cantidad de elementos*/
                /*Generar el ticket (ToSTRING)*/
         /*Si todo ha salido bien*/
            /*devuelve la lista que se guardar en la lista de compras del tpv*/
            double totalAcobrar=0;
            for(ProductoVenta pv : m_carrito){
                totalAcobrar+= (pv.get_precio()*(pv.Iva.get_iva()));
            }
            /*Añadir con optionpane el numero de tarjeta a validar*/
            String numeroTarjeta=new String();
            boolean estado=pasarelaPago.ProcesoDePago(totalAcobrar,numeroTarjeta);
            
            if(estado){
                ProcesarTicket();
                Tpv.VENTASTOTALES+=1;
                Ticket ticket = new Ticket(Tpv.VENTASTOTALES,m_carrito.size());
                for(ProductoVenta p : m_carrito)
                {
                    ticket.AñadirElemento(p);
                }
                ticket.AñadirFecha(LocalDate.now());
                
                /*Crear el objeto TIcket y añadirlo a la lista*/
             /*imprimir el ticket final*/
            }
            else{
                /*INFORMAR DEL ERROR PRODUCIDO y de que no se ha cobrado*/
                /*VOLVER AL MENU PRINCIPAL*/}
    }
    
    private void ProcesarTicket(){}
}
